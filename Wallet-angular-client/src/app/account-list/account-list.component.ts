import { Component, OnInit, NgModule} from '@angular/core';
import {Router} from '@angular/router';
import {Account } from "../accountserv";
import { AccountServiceService} from "../account-service.service";
import {HttpClient } from "@angular/common/http";
//import {AccountDetailsComponent } from '../account-details/account-details.component';


@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})


export class AccountListComponent implements OnInit {

  
  account:Account;
  accounts:any;
 
  acc:Account= new Account();
 
  constructor(private accountService: AccountServiceService,
    private router: Router, private http: HttpClient) {
     
  }
  ngOnInit() {
   
    this.acc=this.accountService.getter();
    this.reloadData();
  }

  reloadData() {
   
    console.log(this.acc);
  }

  update(){
    this.router.navigate(['/details/update']);
  }
  back(){
    this.router.navigate(['/details']);
  }
}
