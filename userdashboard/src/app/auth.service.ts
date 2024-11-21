import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { RegisterDto } from './register-dto.model';


interface LoginResponse {
  token: string;
  roles: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8085/api/auth'; // Replace with your backend API URL

  constructor(private http: HttpClient) {}

  

  // Login method
  login(credentials: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/login`, credentials).pipe(
      map(response => {
        // Store token and role in session storage
        sessionStorage.setItem('token', response.token);
        sessionStorage.setItem('role', response.roles); 
        if(response.roles === 'USER'){
          
        }
         // assuming response includes a single role
        return response;
      }),
      catchError(error => {
        throw new Error('Login failed');
      })
    );
  }


  // Register method
  register(registerDto: RegisterDto): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/register`, registerDto).pipe(
      map(response => {
        // Assuming the backend sends a message or data upon successful registration.
        console.log('Registration successful:', response);
        return response; // Returning the response for further use
      }),
      catchError(error => {
        // Handle the error appropriately
        console.log('Registration failed:', error);
        throw new Error('Registration failed: ' + error.message); // Throws the error to be handled upstream
      })
    );


}
}
