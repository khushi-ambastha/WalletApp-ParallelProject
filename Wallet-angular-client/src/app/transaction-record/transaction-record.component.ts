import { Component, OnInit } from '@angular/core';
import { Transaction } from '../transaction';
import { AccountServiceService } from '../account-service.service';
import { Router } from '@angular/router';
import {Account} from '../accountserv';

@Component({
  selector: 'app-transaction-record',
  templateUrl: './transaction-record.component.html',
  styleUrls: ['./transaction-record.component.css']
})
export class TransactionRecordComponent implements OnInit {

  tran:Transaction
  trans:Transaction[];
  accounts:Account[];
  account:Account=new Account();
  type;
  // acc:Account;
  // accountno:number;
  constructor(private accountService:AccountServiceService, private router:Router) { }

  ngOnInit(){
    this.account=this.accountService.getter();
   
    
  
 
  this.account=this.accountService.getter();
   
  this.accountService.getTransById(this.account.accountno).subscribe((data:[]) => {
    this.trans=data;
    this.trans.toString;
   
    console.log(this.trans);
  }
   );
}
 // this.accountService.getAccountList().subscribe((data: any[])=>{this.accounts = data;}) 

  // getName(id:Number)
  // {
  //   this.acc = this.accounts.find(data => data.accountno == id);
  //   return this.acc.name;
  // }
  // getMob(id:Number)
  // {
  //   this.acc = this.accounts.find(data => data.accountno ==id);
  //   // return this.use.phoneno;
  // }
  back(){
    this.router.navigate(['/details']);
  }
}
