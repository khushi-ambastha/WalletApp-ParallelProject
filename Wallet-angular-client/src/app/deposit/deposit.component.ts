import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { AccountServiceService } from '../account-service.service';
import { Account } from '../accountserv';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {

  account:Account= new Account();
  amountvalue:number;
  accountno:number;
  message;
  constructor(private route:ActivatedRoute ,
    private http:HttpClient, private router: Router,
    private amtservice:AccountServiceService) { }

  ngOnInit(): void {
    // this.account=new Account();
    // this.amount=this.route.snapshot.params['amount'];
    // this.accno=this.route.snapshot.params['accountNumber'];
    this.account=this.amtservice.getter();

  }
  deposit()
  {
    this.amtservice.deposit(this.account.accountno,this.amountvalue)
    .subscribe(data=>console.log(data)
    );
    this.account=new Account();
    this.message="Amount deposited";
   
  
  //this.router.navigate(["/details"])
  }
  onSubmit(){
    this.deposit();
  }
  back(){
    this.router.navigate(['/details']);
  }
}
