import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MystocksComponent } from './mystocks/mystocks.component';
import { SellorderComponent } from './sellorder/sellorder.component';
import { LogoutComponent } from './logout/logout.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { StocksComponent } from './stocks/stocks.component';
import { HttpClientModule } from '@angular/common/http';
import { AddStockComponent } from './add-stock/add-stock.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserpageComponent } from './userpage/userpage.component';
import { QuizComponent } from './quiz/quiz.component';
import { ResultComponent } from './result/result.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { UsersComponent } from './users/users.component';
//import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    MystocksComponent,
    SellorderComponent,
    LogoutComponent,
    HeaderComponent,
    FooterComponent,
    StocksComponent,
    AddStockComponent,
    LoginComponent,
    RegisterComponent,
    UserpageComponent,
    QuizComponent,
    ResultComponent,
    AdmindashboardComponent,
    UsersComponent,
    //ReactiveFormsModule

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
