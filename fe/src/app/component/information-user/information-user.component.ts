import {Component, OnInit} from '@angular/core';
import {AccountService} from '../../service/account.service';
import {Account} from '../../model/account';
import {TokenStorageService} from '../security-authentication/service/token-storage.service';

@Component({
  selector: 'app-information-user',
  templateUrl: './information-user.component.html',
  styleUrls: ['./information-user.component.css']
})
export class InformationUserComponent implements OnInit {
  account: Account;
  userId: number;

  constructor(private accountService: AccountService,
              private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.getAccount();
  }

  getAccount() {
    if (this.tokenStorageService.getToken()) {
      this.userId = this.tokenStorageService.getUser().id;
    }
    this.accountService.getAccountById(this.userId).subscribe(item => {
      this.account = item;
      console.log('aosiduoaisdu' + this.account);
    });
  }

}
