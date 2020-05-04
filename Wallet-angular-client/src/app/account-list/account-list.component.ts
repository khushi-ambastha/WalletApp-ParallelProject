import { Component, OnInit, NgModule} from '@angular/core';
import {Router} from '@angular/router';
import {Account } from "../accountserv";
import { AccountServiceService} from "../account-service.service";
import {Observable } from "rxjs";
import {HttpClient } from "@angular/common/http";
//import {AccountDetailsComponent } from '../account-details/account-details.component';


@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})


export class AccountListComponent implements OnInit {

  //accounts: Observable<Account[]>;
  account:Account;
   accounts:any;
  cust = [];
  acc:Account= new Account();
 // accountno:number;
  constructor(private accountService: AccountServiceService,
    private router: Router, private http: HttpClient) {
      // this.http.get(`http://localhost:8080/rest/walletApp/list/${this.account.accountno}`).subscribe((data: any[])=>{
      //   console.log(data);
        //this.accounts = data;
      // for(let key in data)
      // {
      //   if (data.hasOwnProperty(key))
      //   this.accounts.push(data[key]);
      // }
     // });
  }
  ngOnInit() {
    // this.accountService.getAccountList().subscribe((accounts)=> {
    //   console.log(accounts);
    //   this.accounts=accounts;
    // },(error)=>{
    //   console.log(error);
    // })
    // this.accountService.getAccount(this.accountno).subscribe(data => this.account=data);
    this.acc=this.accountService.getter();
    this.reloadData();
  }

  reloadData() {
    //  this.accountService.getAccountList().subscribe((
    //   data :[])=> {
    //     console.log(data),
    //     this.accounts=data;
    //   });
    console.log(this.acc);
  }

  update(){
    this.router.navigate(['/details/update']);
  }
  back(){
    this.router.navigate(['/details']);
  }
  // deleteaccount(id: number) {
  //   this.accountService.deleteAccount(id)
  //     .subscribe((data) => {this.accounts.splice(id),
  //         console.log(data);
  //         this.reloadData();
  //       },
  //       error => console.log(error));
  // }

  // accountDetails(id: number){
  //   console.log("Account details to be displayed here.");
  //   this.router.navigate(['/details', id]);
  // }
}
