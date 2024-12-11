import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MystocksComponent } from './mystocks/mystocks.component';
import { SellorderComponent } from './sellorder/sellorder.component';
import { LogoutComponent } from './logout/logout.component';
import { HomepageComponent } from './homepage/homepage.component';
import { StocksComponent } from './stocks/stocks.component';
import { AddStockComponent } from './add-stock/add-stock.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserpageComponent } from './userpage/userpage.component';
import { ResultComponent } from './result/result.component';
import { QuizComponent } from './quiz/quiz.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { UsersComponent } from './users/users.component';

const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'stocks', component: StocksComponent },
  { path: 'mystocks', component: MystocksComponent },
  { path: 'sellorder', component: SellorderComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'add-stock', component: AddStockComponent },
  { path: 'stocks', component: MystocksComponent },
  { path: 'sell-order/:symbol', component: SellorderComponent },
  { path: 'register', component: RegisterComponent },
  {path: 'user',component: UserpageComponent},
  { path: 'quiz', component: QuizComponent },
  { path: 'result', component: ResultComponent },
  { path: '', redirectTo: '/quiz', pathMatch: 'full' },
  { path: '', redirectTo: '/stocks', pathMatch: 'full' },
  { path: 'admin', component: AdmindashboardComponent},
  { path: 'users', component: UsersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
