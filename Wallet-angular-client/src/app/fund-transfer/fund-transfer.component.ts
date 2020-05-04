import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountServiceService } from '../account-service.service';
import {Account} from '../accountserv';

@Component({
  selector: 'app-fund-transfer',
  templateUrl: './fund-transfer.component.html',
  styleUrls: ['./fund-transfer.component.css']
})
export class FundTransferComponent implements OnInit {
  public accounts:Account[];
  accountnum:number;
  password:string;
  balanceval:number;
  acc :Account= new Account();
  account : Account= new Account();
  account1: any;
  amount:number;
  message;
  
  constructor(private accountService:AccountServiceService, private router:Router) { }

  ngOnInit() {

    // this.accountService.getAccountList().subscribe((data: any[])=>{
    //   console.log(data);
    //   this.accounts = data;

    // }
   // ) 
      this.account = this.accountService.getter();
     // this.accountService.getaccount(this.accountnum).subscribe(data => this.account1=data);
    }

  submit()
  {
    //console.log(this.account1);
  //   this.accountService.withdraw(this.account.accountno,this.balanceval);
  //   this.accountService.deposit(this.accountnum,this.balanceval);
  //   this.message="Money transferred";
  //  // this.router.navigate(['/details']);
  //  console.log(this.balanceval);
  //    console.log(this.account);
     this.accountService.transfer(this.account.accountno,this.accountnum,this.balanceval);
    this.message="Amount transferred"
    //this.accountService.getAccount(this.accountno).subscribe(data => this.acc=data);
    // this.acc= this.accountService.getter();
    // console.log(this.acc);
    // this.acc.balance-=this.amount;
  
}
back(){
  this.router.navigate(['/details']);
}
}
