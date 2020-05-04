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
  withdraw()
  {
    //this.account=this.amtservice.getAccount(this.accno).subscribe(data => console.log(data));
    this.amtservice.withdraw(this.account.accountno,this.amountvalue)
  .subscribe(data=>console.log(data)
  );
  this.account=new Account();
  this.message="Amount withdrawn";
}

onSubmit(){
  this.withdraw();
}
back(){
  this.router.navigate(['/details']);
}
}
