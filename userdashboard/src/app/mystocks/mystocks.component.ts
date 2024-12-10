import { Component, OnInit } from '@angular/core';
import { StockService } from '../stock.service';
import { Router } from '@angular/router'; 
@Component({
  selector: 'app-mystocks',
  templateUrl: './mystocks.component.html',
  styleUrls: ['./mystocks.component.css']
})
export class MystocksComponent implements OnInit {

  userStocks: any[] = [];
  wallet: number = 0;  // Replace with your actual wallet data

  constructor(private stockService: StockService,private router: Router) {}

  ngOnInit(): void {
    this.getStocks();
    //this.getUserStocks();
  }

  

  getStocks(): void {
    this.stockService.getAllStocks().subscribe(
      (data) => {
        this.userStocks = data;
        console.log('Stocks retrieved successfully:', this.userStocks);
      },
      (error) => {
        console.error('Error fetching stocks:', error);
      }
    );
  }


   // Navigate to the Sell Order form
   navigateToSellOrder(company: string): void {
    this.router.navigate(['/sell-order', company]);  // Navigates to sell order route
  }
  
  }

