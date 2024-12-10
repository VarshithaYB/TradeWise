import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StockService,StockRequest } from '../stock.service';
@Component({
  selector: 'app-sellorder',
  templateUrl: './sellorder.component.html',
  styleUrls: ['./sellorder.component.css']
})
export class SellorderComponent implements OnInit{
  company: string = '';
  quantity: number = 0;
  price: number = 0;

  
  sellRequest = {
    company: '',
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
    this.company = this.route.snapshot.paramMap.get('company') || '';
  }

  // onSubmit(): void {
  //   this.stockService.sellStock(this.companyName, this.quantity, this.price).subscribe(
  //     (response) => {
  //       console.log('Stock sold successfully:', response);
  //       alert('Stock is sold successfully');
  //       this.router.navigate(['/stocks']); // Redirect to mystocks page
  //     },
  //     (error) => {
  //       console.error('Error selling stock:', error);
  //       alert('Error selling stock');
  //     }
  //   );
  // }

  onSubmit(): void {
    console.log('Submitting stock:', this.sellRequest);
  
    this.stockService.sellStock(this.sellRequest.company, this.sellRequest.quantity, this.sellRequest.currentPrice)
      .subscribe(
        (response) => {
          console.log('Operation successful:', response);
          alert('Stock operation successful');
          this.router.navigate(['/mystocks']);
        },
        (error) => {
          console.error('Error:', error);
          alert('Error performing stock operation');
        }
      );
  }
  

  
  
}


  
  


        
 