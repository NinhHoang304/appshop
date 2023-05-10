import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Account} from '../model/account';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private httpClient: HttpClient) {
  }

  getAccountById(accountId: number): Observable<Account> {
    return this.httpClient.get<Account>('http://localhost:8080/api/account/info/' + accountId);
  }
}
