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
  
  constructor(private accountService:AccountServiceService, private router:Router) { }

  ngOnInit(){
    this.account=this.accountService.getter();
 
  this.accountService.getTransById(this.account.accountno).subscribe((data:[]) => {
    this.trans=data;
    this.trans.toString;
   
    console.log(this.trans);
  }
  
   );
  
}

  back(){
    this.router.navigate(['/details']);
  }
}
