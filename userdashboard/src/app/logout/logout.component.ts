import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent {

  constructor(private router: Router) {}

  onLogout(): void {
    // Clear any stored authentication data (like tokens)
    localStorage.removeItem('authToken');
    
    // Redirect to the login page after logout
    this.router.navigate(['/login']);
  }

}

