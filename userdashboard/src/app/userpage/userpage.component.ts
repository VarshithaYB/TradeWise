import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userpage',
  templateUrl: './userpage.component.html',
  styleUrls: ['./userpage.component.css']
})
export class UserpageComponent {
  constructor(private router: Router) { }

  // Method to navigate to the 'userpage' component
  goToUserPage() {
    this.router.navigate(['/userpage']);
  }

}
