import { Component, OnInit } from '@angular/core';
import { AccountServiceService } from '../account-service.service';
 import { Account } from '../accountserv';
 import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  account:Account[];
  username: string;
  password: string;
  accountno:number;
  acc:Account=new Account();
  message;
  flag=false;
  constructor( private accountserv :AccountServiceService,
    private router: Router) { }

  ngOnInit(): void {
    this.accountserv.getAccountList().subscribe((data:[]) => this.account=data)
    //this.accountserv.setter(this.acc);
  }
 async login(){

  //this.router.navigate(['details']);
  for (let ac of this.account) {
    if (ac.username == this.username) {
    
    if (ac.password == this.password){
      this.flag=true;
    console.log("logged in");
    alert("logged in");
    try{
      let response = await this.accountserv.getAccount(ac.accountno);
      if (response.ok) {
        this.acc = await response.json();
        //this.customerid = this.account.customerId;
      } else {
        this.router.navigate(["/"]);
      }
    } catch(err){
      this.router.navigate(["/"]);
    }
    //this.accountserv.getAccount(ac.accountno);
    this.accountserv.setter(this.acc);
    this.router.navigate(['details']);
  }
}
  }
  if(this.username=="" || !this.flag ){
    this.message="Try again!";
    console.log("try again");

  }

 }
}
