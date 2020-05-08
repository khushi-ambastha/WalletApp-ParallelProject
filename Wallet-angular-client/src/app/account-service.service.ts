import { Injectable } from '@angular/core';
import { HttpClient ,HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Account } from './accountserv';
//import { Headers,Http,Response,RequestOptions} from '@angular/common/http';
import { catchError, map, tap, retry } from 'rxjs/operators';
import { Transaction } from './transaction';

@Injectable({
  providedIn: 'root'
})
export class AccountServiceService {
errmessage="Insufficient Balance!";
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
    return this.http.delete("http://localhost:8080/rest/walletApp/delete/{id}", { responseType: 'text' });
  }

  getAccountList():Observable<Account[]> {
    return this.http.get<Account[]>(`http://localhost:8080/rest/walletApp/accountlist`).pipe(
      retry(1),
      catchError(this.handleError)
    );
  }
deposit(accno,amount)
{
  return this.http.get(this.baseUrl+"/deposit/"+accno+"/"+amount).pipe(
    retry(1),
    catchError(this.handleError)
  );

}
withdraw(accno,dest, amount)
{
  return this.http.get(this.baseUrl+"/withdraw/"+accno+"/"+dest+"/"+amount).pipe(
    retry(1),
    catchError(this.handleError1)
  );
}

getTransById(id:number):Observable<Transaction[]>
{
  return this.http.get<Transaction[]>(this.baseUrl+"/trans/"+id).pipe(
    retry(1),
    catchError(this.handleError)
  );
}
showBalance(accno) {
  return this.http.get(this.baseUrl + "/getBalance/" + accno).pipe(
    retry(1),
    catchError(this.handleError)
  );
}
transfer(accno1, accno2, amount){
  return this.http.get(this.baseUrl+"/transfer/"+accno1+"/"+accno2+"/"+amount).pipe(
    retry(1),
    catchError(this.handleError)
  );
}

handleError(error) {
  let errorMessage = '';
  if (error.error instanceof ErrorEvent) {
    // client-side error
    errorMessage = `Error: ${error.error.message}`;
  } else {
    // server-side error
    errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
  }
  window.alert("Oops there is some error here.\n"+errorMessage);
  return throwError(errorMessage);
}
handleError1(error) {
  let errorMessage = '';
  if (error.error instanceof ErrorEvent) {
    // client-side error
    errorMessage = `Error: Client side ${error.error.message}`;
  } else {
    // server-side error
    errorMessage = `Error Code: Server side ${error.status}\nMessage: ${error.message}`;
  }
  window.alert("Low Balance !!\n"+errorMessage);
  return throwError(errorMessage);
}

}

