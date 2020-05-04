import { Injectable } from '@angular/core';
import { HttpClient ,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Account } from './accountserv';
//import { Headers,Http,Response,RequestOptions} from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { Transaction } from './transaction';

@Injectable({
  providedIn: 'root'
})
export class AccountServiceService {

private acc:Account= new Account();
  private baseUrl='http://localhost:8080/rest/walletApp';
  constructor(private http: HttpClient) { }

  
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })}

    getAccount(id) {
      return fetch(this.baseUrl + "/accountlist/" + id);
    }
    getaccount(id) {
      return this.http.get(this.baseUrl + "/accountlist/" + id);
    }
  
  setter(acc:Account)
  {
    this.acc = acc;
  }

  getter(){
    return this.acc;
  }
  createAccount(acco) {
    let options = {
      method: "POST",
      body: JSON.stringify(acco),
      headers: { "Content-Type": "application/json" },
    };
    return fetch(this.baseUrl + "/create", options);
  }
  // updateAccount(id: number, value: any): Observable<Object> {
  //   return this.http.put("http://localhost:8080/rest/walletApp/update/{id}", value);
  // }
  updateAccount(account) {
    let options = {
      method: "POST",
      body: JSON.stringify(account),
      headers: new Headers({ "Content-Type": "application/json" }),
    };
    return fetch(this.baseUrl + "/update", options);
  }

  deleteAccount(id: number): Observable<any> {
    return this.http.delete("http://localhost:8080/rest/walletApp/create/{id}", { responseType: 'text' });
  }

  getAccountList():Observable<Account[]> {
    return this.http.get<Account[]>(`http://localhost:8080/rest/walletApp/accountlist`);
  }
deposit(accno,amount)
{
  return this.http.get(this.baseUrl+"/deposit/"+accno+"/"+amount);

}
withdraw(accno, amount)
{
  return this.http.get(this.baseUrl+"/withdraw/"+accno+"/"+amount);
}

getTransById(id:number):Observable<Transaction[]>
{
  return this.http.get<Transaction[]>(this.baseUrl+"/trans/"+id);
}
showBalance(accno) {
  return this.http.get(this.baseUrl + "/getBalance/" + accno);
}
transfer(accno1, accno2, amount){
  return this.http.get(this.baseUrl+"/transfer/"+accno1+"/"+accno2+"/"+amount);
}
}
