import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
 import { AccountServiceService } from '../account-service.service';
 import { Account } from '../accountserv';

 
@Component({
  selector: 'app-update-account',
  templateUrl: './update-account.component.html',
  styleUrls: ['./update-account.component.css']
})
//@NgModule()
export class UpdateAccountComponent implements OnInit {

  accno: number;
  account : Account;
  constructor(private route: ActivatedRoute ,private router: Router,
    private accountservice: AccountServiceService) { }

  ngOnInit(){
    this.account = new Account();

    this.account=this.accountservice.getter();
    this.accno = this.account.accountno;
    
    // this.accountservice.getAccount(this.accno)
    //   .subscribe(data => {
    //     console.log(data)
    //     this.account = data;
    //   }, error => console.log(error));
  }

  updateaccount() {
    this.accountservice.updateAccount( this.account);
    this.account = new Account();
    this.gotoList();
  }

  onSubmit() {
    this.updateaccount();    
  }

  gotoList() {
    this.router.navigate(['/details']);
  }
  back(){
    this.router.navigate(['/details']);
  }
}

