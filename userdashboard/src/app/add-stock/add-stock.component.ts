import { Component , OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StockService } from '../stock.service';


@Component({
  selector: 'app-add-stock',
  templateUrl: './add-stock.component.html',
  styleUrls: ['./add-stock.component.css']
})
export class AddStockComponent  implements OnInit {

  // stockId!: string;
  // quantity!: number;
  // price!: number;
  // userId = 1; // Assume a hardcoded userId for now

  company: string='';
  symbol: string = '';  // Make sure it's a string
  quantity: number = 0;  // Make sure it's a number
  price: number = 0; 
  currentPrice: number=0;
  initialPrice: number=0;
  
  constructor(private router: Router, private stockService: StockService) {}

  ngOnInit(): void {}

  submitStock() {
    const stockData = {
      company: this.company,
      symbol: this.symbol,
      quantity: this.quantity,
      currentPrice: this.currentPrice,
      initialPrice: this.initialPrice
      
    };

    this.stockService.addStock(stockData).subscribe(
      (response) => {
        console.log('Stock added successfully', response);
        window.alert('Stock added successfully!');
        this.router.navigate(['/mystocks']);
      },
      (error) => {
        console.error('Error adding stock', error);
        alert('Failed to add stock');
      }
    );

    
  }

}
