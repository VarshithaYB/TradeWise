import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common'; 
import { StockService } from '../stock.service'; 
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { AdminService } from '../admin.service';


@Component({
  selector: 'app-stocks',
  templateUrl: './stocks.component.html',
  styleUrls: ['./stocks.component.css']
})
export class StocksComponent implements OnInit{

  stocks = [
    { company: 'Apple', symbol: 'AAPL', currentPrice: 150, initialPrice: 120, logo: '/assets/apple.jpg'},
    { company: 'Tesla', symbol: 'TSLA', currentPrice: 800, initialPrice: 700, logo: '/assets/tesla.jpg' },
    { company: 'Amazon', symbol: 'AMZN', currentPrice: 3400, initialPrice: 3000, logo: '/assets/amazon.jpg' },
    { company: 'Google', symbol: 'GOOGL', currentPrice: 2800, initialPrice: 2500, logo: '/assets/google.jpg' },
    { company: 'Microsoft', symbol: 'MSFT', currentPrice: 290, initialPrice: 250, logo: '/assets/microsoft.jpg' },
    { company: 'Facebook', symbol: 'FB', currentPrice: 360, initialPrice: 320, logo: '/assets/facebook.jpg' }
  ];

  constructor(private router: Router, private stockService: StockService, private authService: AuthService,private adminService:AdminService) {}

  ngOnInit(): void {
    this.adminService.stocks$.subscribe((newStocks) => {
      // Add new stocks to the existing stocks array
      this.stocks = [...this.stocks, ...newStocks];
    });
  }

  // addStock(stock: any): void {
  //   this.router.navigate(['/add-stock'], { state: { stock } });
  // }

  addStock(stock: any): void {
    if (this.authService.isLoggedIn()) {
      this.router.navigate(['/add-stock'], { state: { stock } });
    } else {
      window.alert('Please sign up or log in to add stocks.');
      this.router.navigate(['/register']);
    }
  }
  

  

  // Method to navigate to the 'userpage' component
  goToUserPage() {
    this.router.navigate(['/user']);
  }

}
