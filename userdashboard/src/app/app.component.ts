import { Component } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'userdashboard';




  showHeader = false;

    constructor(private router: Router) {}

    ngOnInit(): void {
      this.router.events.subscribe(event => {
          if (event instanceof NavigationEnd) {
              // Define the routes where the header should be displayed
              const headerRoutes = ['/stocks', '/mystocks', '/logout'];
              const currentRoute = event.urlAfterRedirects;

              // Check if the route is static or matches the dynamic pattern
              this.showHeader =
                  headerRoutes.includes(currentRoute) || 
                  currentRoute.startsWith('/sell-order/');
          }
      });
  }
}
