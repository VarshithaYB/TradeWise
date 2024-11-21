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
    { company: 'Apple', symbol: 'AAPL', currentPrice: 150, initialPrice: 120, logo: 'path-to-logo-apple.png' },
    { company: 'Tesla', symbol: 'TSLA', currentPrice: 800, initialPrice: 700, logo: 'path-to-logo-tesla.png' },
    { company: 'Amazon', symbol: 'AMZN', currentPrice: 3400, initialPrice: 3000, logo: 'path-to-logo-amazon.png' },
    { company: 'Google', symbol: 'GOOGL', currentPrice: 2800, initialPrice: 2500, logo: 'path-to-logo-google.png' },
    { company: 'Microsoft', symbol: 'MSFT', currentPrice: 290, initialPrice: 250, logo: 'path-to-logo-microsoft.png' },
    { company: 'Facebook', symbol: 'FB', currentPrice: 360, initialPrice: 320, logo: 'path-to-logo-facebook.png' }
  ];
  
  constructor(private router: Router, private stockService: StockService) {}

  ngOnInit(): void {}

  addStock(stock: any): void {
    this.router.navigate(['/add-stock'], { state: { stock } });
  }

}
