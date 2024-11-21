import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent {

  constructor(private router: Router) {}

  navigateToLogin() {
    console.log('Navigating to /login');
    this.router.navigate(['/login']);
  }

  navigateToSignup() {
    console.log('Navigating to /signup');
    this.router.navigate(['/register']);
  }

  navigateToStocks() {
    console.log('Navigating to /stocks');
    this.router.navigate(['/stocks']);
  }


  navigateToQuiz(): void {
    this.router.navigate(['/quiz']); 
  }

}
