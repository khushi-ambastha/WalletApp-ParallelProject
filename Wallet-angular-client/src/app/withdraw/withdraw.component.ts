import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { AccountServiceService } from '../account-service.service';
import { Account } from '../accountserv';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent implements OnInit {
  account:Account=new Account();
  amountvalue:number;
  accno:number;
  dest=0;
  message;
  amount:any;
  account1:Account= new Account;
  constructor(private route:ActivatedRoute ,
    private http:HttpClient, private router: Router,
    private amtservice:AccountServiceService) { }

  ngOnInit(): void {
   
    this.account=this.amtservice.getter();
    
  }
  withdraw()
  {
    
   // this.amtservice.getaccount(this.account.accountno).subscribe((data: Account)=> this.account1=data);
   this.amtservice.showBalance(this.account.accountno).subscribe(data => {this.amount=data
    , console.log(this.amount)} );
    if(this.amount < this.amountvalue)
    {
    alert("Low Balance.");
    }
    else{
    this.amtservice.withdraw(this.account.accountno,this.dest,this.amountvalue)
  .subscribe(data=>console.log(data)
  );
  this.account=new Account();
  this.message="Amount withdrawn";
    }
}

onSubmit(){
  this.withdraw();
}
back(){
  this.router.navigate(['/details']);
}
}
