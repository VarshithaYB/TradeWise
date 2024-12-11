import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { StockService } from '../stock.service';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-adminstocks',
  templateUrl: './adminstocks.component.html',
  styleUrls: ['./adminstocks.component.css']
})
export class AdminstocksComponent {

  stocks = [
    { company: 'Walmart', symbol: 'WAL-MART', currentPrice: 150, initialPrice: 120, logo: '/assets/walmart.jpg'},
    { company: 'IBM', symbol: 'IBM', currentPrice: 800, initialPrice: 700, logo: '/assets/ibm.jpeg' },
    { company: 'Oracle', symbol: 'ORCL', currentPrice: 3400, initialPrice: 3000, logo: '/assets/oracle.jpg' },
    { company: 'Cisco', symbol: 'CISCO', currentPrice: 2800, initialPrice: 2500, logo: '/assets/cisco.jpg' },
    { company: 'Alphabet', symbol: 'ALPHABET', currentPrice: 290, initialPrice: 250, logo: '/assets/alpabet.jpg' },
    { company: 'HCLTech', symbol: 'HCL', currentPrice: 360, initialPrice: 320, logo: '/assets/hcl.jpg' }
  ];
  
  constructor(private AdminService: AdminService) {}

  addToUsers(stock: any) {
    this.AdminService.addStock(stock);
    alert(`${stock.company} added to users!`);
  }

  
}