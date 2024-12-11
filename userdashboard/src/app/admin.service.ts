import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  getStocks(): import("rxjs").Observable<any[]> {
    throw new Error('Method not implemented.');
  }
  // private stocksSubject = new BehaviorSubject<any[]>([
  //   { company: 'Tesla', symbol: 'TSLA', currentPrice: 700, initialPrice: 650, logo: '/assets/tesla.jpg' },
  //   { company: 'Apple', symbol: 'AAPL', currentPrice: 150, initialPrice: 145, logo: '/assets/apple.jpg' },
  // ]);

  private apiUrl = 'http://localhost:8086/api/admin/customers'; 

  constructor(private http: HttpClient) { }

  

  // Fetch all users
  getCustomersWithStocks(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
  // stocks$ = this.stocksSubject.asObservable();

  // Add a stock to the list
  // addStock(stock: any) {
  //   const currentStocks = this.stocksSubject.value;
  //   this.stocksSubject.next([...currentStocks, stock]);
  // }

  private stocksSubject = new BehaviorSubject<any[]>([]);

  // Observable for stocks
  stocks$ = this.stocksSubject.asObservable();

  // Add a new stock to the subject
  addStock(stock: any) {
    const currentStocks = this.stocksSubject.value;
    this.stocksSubject.next([...currentStocks, stock]);
  }
}