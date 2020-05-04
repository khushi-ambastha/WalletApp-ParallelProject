import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { AccountServiceService } from '../account-service.service';
import { Account } from '../accountserv';
import { Transaction } from '../transaction';
@Component({
  selector: 'app-showbalance',
  templateUrl: './showbalance.component.html',
  styleUrls: ['./showbalance.component.css']
})
export class ShowbalanceComponent implements OnInit {

  account:Account;
  account1= new Account();
  trans:Transaction[];
  
showBalance:boolean;
confirmUser=new Transaction();
  amount:any;
  accno:number;
  constructor(private route:ActivatedRoute ,
    private http:HttpClient, private router: Router,
    private amtservice:AccountServiceService) { }

  ngOnInit(): void {
    this.account=this.amtservice.getter();
    this.account1=this.amtservice.getter();

    //this.amount=this.route.snapshot.params['amount'];
  
}
  
  showbal()
  {

    this.amtservice.showBalance(this.account1.accountno).subscribe(data => {this.amount=data
      , console.log(this.amount)} );;
    //this.amount=this.account1.balance;
    // this.account1=this.amtservice.getter();
    // this.amount=this.account1.balance;
    // this.amtservice.getAccount( this.accno )
    // .subscribe((data)=>{console.log(data),
    // this.account=data;}
    // );
    // this.amount=this.account.balance;
    // this.account=new Account();
    // this.amtservice.showbalance(this.accno).subscribe(data => {this.amount=data
    //   , console.log(this.amount)} );
  }

  onSubmit(){
    this.showbal();
  }
  back(){
    this.router.navigate(['/details']);
  }

}
