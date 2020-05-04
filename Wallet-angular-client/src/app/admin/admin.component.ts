import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {


  message;
  username;
  password;
  success;
  constructor(private router: Router) { }

  ngOnInit(): void {
    this.success=false;
  }
  login(){
    if(this.username=="admin" && this.password=="easytokenpass")
    {
      this.success=true;
      this.message="logged in";
      this.router.navigate(['adminFunc']);
    }
    else
    this.message="Try Again";

  }
 

  
}
