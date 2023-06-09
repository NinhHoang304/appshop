package com.example.controller;

import com.example.security_authentication.jwt.JwtFilter;
import com.example.security_authentication.jwt.JwtUtility;
import com.example.model.Account;
import com.example.security_authentication.payload.reponse.JwtResponse;
import com.example.security_authentication.payload.reponse.MessageResponse;
import com.example.security_authentication.payload.request.LoginRequest;
import com.example.security_authentication.payload.request.ResetPasswordRequest;
import com.example.service.IAccountService;
import com.example.security_authentication.service.AccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class SecurityRestController {

    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IAccountService accountService;

    /**
     * Created by: HoangNM
     * Date created: 29/03/2023
     * Function: login, authentication
     *
     * @param loginRequest
     * @return HttpStatus.No_Content if result is error or HttpStatus.OK is result is not error
     */
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        // Xác thực
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Khởi tạo jwt
        String jwt = jwtUtility.generateJwtToken(loginRequest.getUsername());
        AccountDetails userDetails = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        // Gởi những dữ liệu cần dùng
        return ResponseEntity.ok(
                new JwtResponse(jwt,
                        userDetails.getUsername(),
                        this.accountService.findAccountByEmail(loginRequest.getUsername()).getName(),
                        this.accountService.findAccountByEmail(loginRequest.getUsername()).getId(),
                        roles)
        );
    }
}
