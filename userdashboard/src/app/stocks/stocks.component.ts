import { Component } from '@angular/core';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common'; 
import { StockService } from '../stock.service'; 
import { Router } from '@angular/router';


@Component({
  selector: 'app-stocks',
  templateUrl: './stocks.component.html',
  styleUrls: ['./stocks.component.css']
})
export class StocksComponent {

  stocks = [
    { company: 'Apple', symbol: 'AAPL', currentPrice: 150, initialPrice: 120, logo: '/assets/apple.jpg'},
    { company: 'Tesla', symbol: 'TSLA', currentPrice: 800, initialPrice: 700, logo: '/assets/tesla.jpg' },
    { company: 'Amazon', symbol: 'AMZN', currentPrice: 3400, initialPrice: 3000, logo: '/assets/amazon.jpg' },
    { company: 'Google', symbol: 'GOOGL', currentPrice: 2800, initialPrice: 2500, logo: '/assets/google.jpg' },
    { company: 'Microsoft', symbol: 'MSFT', currentPrice: 290, initialPrice: 250, logo: '/assets/microsoft.jpg' },
    { company: 'Facebook', symbol: 'FB', currentPrice: 360, initialPrice: 320, logo: '/assets/facebook.jpg' }
  ];
  
  constructor(private router: Router, private stockService: StockService) {}

  ngOnInit(): void {}

  addStock(stock: any): void {
    this.router.navigate(['/add-stock'], { state: { stock } });
  }

  

  // Method to navigate to the 'userpage' component
  goToUserPage() {
    this.router.navigate(['/user']);
  }

}
