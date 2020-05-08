import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Account } from "../accountserv";
import { AccountServiceService} from "../account-service.service";

@Component({
  selector: 'app-admin-function',
  templateUrl: './admin-function.component.html',
  styleUrls: ['./admin-function.component.css']
})
export class AdminFunctionComponent implements OnInit {

  account:Account[];
  accountno:number;
  message;
  constructor(private accountService: AccountServiceService,
    private router: Router) { }

  ngOnInit(): void {
  }
 
 back(){

 }
 accounts(){
this.accountService.getAccountList().subscribe((data:[]) => this.account=data);
console.log(this.account);


}
delete(){
this.accountService.deleteAccount(this.accountno).subscribe(data=> {this.account.splice(this.accountno),
           console.log(data);});
this.message="Account deleted";
}

}
