import { Component, OnInit } from '@angular/core';
import {Account} from '../accountserv';
import {AccountServiceService } from '../account-service.service';
@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent implements OnInit {

  account:Account= new Account();
  constructor(private accountService: AccountServiceService) { }

  ngOnInit(): void {
    this.account=this.accountService.getter();
  
  }

}
