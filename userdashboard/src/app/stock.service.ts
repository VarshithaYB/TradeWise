import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StockService {
  private baseUrl = 'http://localhost:5050/stocks';  // Base API URL

  constructor(private http: HttpClient) {}

  // Fetch all stocks
  getAllStocks(): Observable<any> {
    return this.http.get(`${this.baseUrl}/all`);  // Fetch all stocks
  }

  // Fetch stocks specific to a user, if needed
  getUserStocks(userId: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/user/${userId}`);  // Adjust based on your API design
  }

  // Add a new stock
  addStock(stock: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/add`, stock);  // Add stock to database


    
  }
  // sellStock(sellStockRequest: any): Observable<any> {
  //   return this.http.put(`${this.baseUrl}/sell`, sellStockRequest);


    // sellStock(stockSymbol: string, quantity: number, price: number): Observable<any> {
    //   const body = {
    //     symbol: stockSymbol,
    //     quantity: quantity,
    //     price: price
    //   };
    //   return this.http.put(`${this.baseUrl}/sell`, body); // Adjust endpoint as necessary
    // }

    sellStock(companyName: string, quantity: number, price: number): Observable<any> {
      const sellStockPayload = { companyName, quantity, price };
      return this.http.post<any>(`${this.baseUrl}/sellStock`, sellStockPayload);
    }
    
}




export interface StockRequest
{
  stockId: number;
  userId: number;
  quantity: number;
  price:number;
}
