import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from "@angular/router";
import { AbstractControl, Validators } from "@angular/forms";
import { AccountServiceService } from '../account-service.service';
import {Account} from '../accountserv';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {


  account:Account= new Account();
  confirmPassword;
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private accountService: AccountServiceService
  ) {}

  regForm = this.formBuilder.group(
    {
      username: [null, Validators.required],
      name: [null, Validators.required],
      dob: [null, Validators.required],
      email: [null, Validators.required],
      phoneno: [
        null,
        [Validators.required, Validators.pattern("[6789][0-9]{9}")],
      ], address: [null, Validators.required],
      password: [null, [Validators.required, Validators.minLength(8)]],
      confirmPassword: [null, [Validators.required]],
    },
    { validator: passwordValidator }
  );

  ngOnInit(): void {}

  /**
   * --------method to add new users---------
   */

  async submit() {
    try{
      this.regForm.removeControl("confirmPassword");
      let response = await this.accountService.createAccount(this.account);
      //let data = await response;
      console.log(response);
      console.log(this.regForm.value);
      this.router.navigate(["/user"]);
    } catch (err){
      
     this.router.navigate(['/']);
    }
  }
}

/**
 * ------- function to check password and confirm password field are same---------
 */

function passwordValidator(
  control: AbstractControl
): { [key: string]: any } | null {
  const pass = control.get("password");
  const confirm = control.get("confirmPassword");
  if (pass && confirm && pass.value != confirm.value) {
    return { mismatch: true };
  } else {
    return null;
  }

}
