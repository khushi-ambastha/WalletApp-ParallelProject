import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccountListComponent } from './account-list/account-list.component';
import { UpdateAccountComponent } from './update-account/update-account.component';
import {DepositComponent } from './deposit/deposit.component';
import {WithdrawComponent } from './withdraw/withdraw.component';
import {ShowbalanceComponent } from './showbalance/showbalance.component';
import {MainPageComponent } from './main-page/main-page.component';
import {AccountDetailsComponent } from './account-details/account-details.component';
import {UserLoginComponent } from './user-login/user-login.component'; 
import {CreateAccountComponent } from './create-account/create-account.component';
import {FundTransferComponent } from './fund-transfer/fund-transfer.component';
import {TransactionRecordComponent } from './transaction-record/transaction-record.component';
import { HomeComponent} from './home/home.component';
import {AdminComponent } from './admin/admin.component';
import {AdminFunctionComponent } from './admin-function/admin-function.component';
import { from, fromEventPattern } from 'rxjs';

const routes: Routes = [
  {path: 'main', component:MainPageComponent},
  {path: '',component: HomeComponent},
  {path: 'admin', component: AdminComponent},
  {path:'adminFunc', component: AdminFunctionComponent},
  {path: 'details/list', component: AccountListComponent},
  {path: 'details/update', component: UpdateAccountComponent},
  {path: 'details/deposit' ,component: DepositComponent},
  {path: 'details/withdraw' , component: WithdrawComponent},
  {path: 'details/showbal', component: ShowbalanceComponent},
  {path:'details', component: AccountDetailsComponent },
  {path:'user', component: UserLoginComponent},
  {path:'create',component: CreateAccountComponent},
  {path:'details/transfer', component: FundTransferComponent},
  {path:'details/trans', component:TransactionRecordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
//export const routingComponents= [AddAccountComponent, AccountListComponent, UpdateAccountComponent];
