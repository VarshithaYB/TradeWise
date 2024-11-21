import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StockService,StockRequest } from '../stock.service';
@Component({
  selector: 'app-sellorder',
  templateUrl: './sellorder.component.html',
  styleUrls: ['./sellorder.component.css']
})
export class SellorderComponent implements OnInit{
  companyName: string = '';
  quantity: number = 0;
  price: number = 0;

  
  sellRequest = {
    companyName: '',
    companySymbol: '',
    quantity: 0,
    currentPrice: 0
  };

  constructor(
    private route: ActivatedRoute,
    private stockService: StockService,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Get the companyName from route parameters
    this.companyName = this.route.snapshot.paramMap.get('companyName') || '';
  }

  onSubmit(): void {
    this.stockService.sellStock(this.companyName, this.quantity, this.price).subscribe(
      (response) => {
        console.log('Stock sold successfully:', response);
        alert('Stock is sold successfully');
        this.router.navigate(['/stocks']); // Redirect to mystocks page
      },
      (error) => {
        console.error('Error selling stock:', error);
        alert('Error selling stock');
      }
    );
  }

  
  
}


  
  


        
 