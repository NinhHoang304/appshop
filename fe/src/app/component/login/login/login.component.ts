import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {LoginService} from '../../security-authentication/service/login.service';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';
import {TokenStorageService} from '../../security-authentication/service/token-storage.service';
import {ShareService} from '../../security-authentication/service/share.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  username: string;
  // errorMessage = '';
  roles: string[] = [];
  returnUrl: string;

  constructor(private loginService: LoginService,
              private router: Router,
              private tokenStorageService: TokenStorageService,
              private shareService: ShareService) {
  }

  ngOnInit(): void {
    this.view();
    debugger
    if (this.loginService.isLoggedIn) {
      Swal.fire({
        text: 'Bạn đã đăng nhập.',
        icon: 'warning',
        showConfirmButton: false,
        timer: 1500
      });
      this.router.navigateByUrl('/');
    }
    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.email, Validators.required]),
      password: new FormControl('', [Validators.required]),
      rememberMe: new FormControl()
    });
    if (this.tokenStorageService.getToken()) {
      const user = this.tokenStorageService.getUser();
      this.loginService.isLoggedIn = true;
      this.roles = this.tokenStorageService.getUser().roles;
      this.username = this.tokenStorageService.getUser().username;
    }
  }


  view(): void {
    const element = document.getElementById('login');
    if (element) {
      element.scrollIntoView();
    }
  }

  onSubmit() {
    this.loginService.login(this.loginForm.value).subscribe(
      data => {
        if (this.loginForm.value.rememberMe) {
          this.tokenStorageService.saveTokenLocal(data.accessToken);
          this.tokenStorageService.saveUserLocal(data);
        } else {
          this.tokenStorageService.saveTokenSession(data.accessToken);
          this.tokenStorageService.saveUserLocal(data);
        }

        this.loginService.isLoggedIn = true;
        this.username = this.tokenStorageService.getUser().username;
        this.roles = this.tokenStorageService.getUser().roles;
        this.loginForm.reset();
        Swal.fire({
          text: 'Đăng nhập thành công',
          icon: 'success',
          showConfirmButton: false,
          timer: 1500
        });
        this.router.navigateByUrl('');
        this.shareService.sendClickEvent();
      },
      err => {
        // this.errorMessage = err.error.message;
        this.loginService.isLoggedIn = false;
        Swal.fire({
          text: 'Tài khoản, mật khẩu không đúng hoặc chưa được kích hoạt!',
          icon: 'error',
          confirmButtonText: 'OK'
        });
      }
    );
  }
}
