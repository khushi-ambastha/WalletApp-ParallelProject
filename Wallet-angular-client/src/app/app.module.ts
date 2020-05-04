import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { AccountListComponent } from './account-list/account-list.component';
import { AccountServiceService } from './account-service.service';
import {HttpClientModule} from '@angular/common/http';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { ShowbalanceComponent } from './showbalance/showbalance.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { MainPageComponent } from './main-page/main-page.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { FundTransferComponent } from './fund-transfer/fund-transfer.component';
import { TransactionRecordComponent } from './transaction-record/transaction-record.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { AdminFunctionComponent } from './admin-function/admin-function.component';

@NgModule({
  declarations: [
    AppComponent,
    AccountDetailsComponent,
    AccountListComponent,
    UpdateAccountComponent,
    DepositComponent,
    WithdrawComponent,
    ShowbalanceComponent,
    UserLoginComponent,
    MainPageComponent,
    CreateAccountComponent,
    FundTransferComponent,
    TransactionRecordComponent,
    HomeComponent,
    AdminComponent,
    AdminFunctionComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [AccountServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
