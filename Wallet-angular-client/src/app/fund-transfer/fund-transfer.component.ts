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
  success;
  
  constructor(private accountService:AccountServiceService, private router:Router) { }

  ngOnInit() {

      this.account = this.accountService.getter();
     // this.accountService.getaccount(this.accountnum).subscribe(data => this.account1=data);
    }

  submit()
  {
    this.accountService.deposit(this.accountnum,this.balanceval).subscribe(data => console.log(data));
    this.accountService.withdraw(this.account.accountno,this.accountnum,this.balanceval).subscribe(data => console.log(data));
    // this.accountService.transfer(this.account.accountno,this.accountnum,this.balanceval).subscribe(data =>console.log(data));
    
    this.message="Amount transferred"
    
  
}
back(){
  this.router.navigate(['/details']);
}
}
