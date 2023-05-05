import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from '../../security-authentication/service/token-storage.service';
import {ShareService} from '../../security-authentication/service/share.service';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  username: string;
  currentUser: string;
  nameEmployee: string;
  role: string;
  isLoggedIn = false;
  userId: number;

  constructor(private tokenStorageService: TokenStorageService,
              private shareService: ShareService,
              private router: Router) {
  }

  loadHeader(): void {
    if (this.tokenStorageService.getToken()) {
      this.currentUser = this.tokenStorageService.getUser().username;
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
    }
    this.isLoggedIn = this.username != null;
    this.getUsernameAccount();
  }


  ngOnInit(): void {
    this.shareService.getClickEvent().subscribe(() => {
      this.loadHeader();
    });
    this.loadHeader();
  }

  async logOut() {
    this.tokenStorageService.signOut();
    this.shareService.sendClickEvent();
    await Swal.fire({
      text: 'Đăng xuất thành công',
      icon: 'success',
      showConfirmButton: false,
      timer: 1500
    });
    await this.router.navigateByUrl('/');
    location.reload();
  }

  getUsernameAccount() {
    if (this.tokenStorageService.getToken()) {
      this.nameEmployee = this.tokenStorageService.getUser().name;
      this.userId = this.tokenStorageService.getUser().id;
    }
  }

}
