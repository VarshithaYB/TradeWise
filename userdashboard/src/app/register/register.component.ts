import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { RegisterDto } from '../register-dto.model';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms'; 
import { FormsModule } from '@angular/forms'; 
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

//   email: string = '';
//   password: string = '';
//   confirmPassword: string = '';
//   roles: string = '';

//   constructor(private authService: AuthService) {}

//   get isFormValid(): boolean {
//     return (
//       this.email.trim() !== '' &&
//       this.password.trim() !== '' &&
//       this.confirmPassword.trim() !== '' &&
//       this.roles.trim() !== '' &&
//       this.password === this.confirmPassword
//     );
//   }

//   // Submit method for registration
//   onRegisterSubmit(): void {
//     // Check if passwords match
//     if (this.password !== this.confirmPassword) {
//       alert('Passwords do not match!');
//       return;
//     }

//     // Create the DTO object for registration
//     const registerDto: RegisterDto = {
//       email: this.email,
//       password: this.password,
//       roles: this.roles
//     };


    
//   console.log('Payload being sent to backend:', registerDto);
//     // Call the AuthService register method
//     this.authService.register(registerDto).subscribe(
//       response => {
//         console.log('Registration successful:', response);
//         alert('Registration successful!');
//         // Redirect or perform additional actions after successful registration
//       },
//       error => {
//         console.error('Registration failed:', error);
//         alert('Registration failed. Please try again.');
//       }
//     );
//   }
  email: string = '';
  password: string = '';
  confirmPassword: string = '';
  roles: string = '';


  constructor(
    private router: Router,
    private authService: AuthService // Assuming an AuthService for handling registration
  ) {}

  // Check if the initial form is valid
  get isFormValid(): boolean {
    return (
      this.password === this.confirmPassword &&
      this.roles !== '' &&
      this.email !== '' &&
      this.password !== '' &&
      this.confirmPassword !== ''
    );
  }

  // 
  // Method to handle form submission
  onRegisterSubmit(form: NgForm): void {
    // Check if the form is valid
    if (form.invalid) {
      return;
    }

    // Create the RegisterDto object
    const registerDto: RegisterDto = {
      email: this.email,
      password: this.password,
      roles: this.roles
    };

    // Submit the form data to the backend
    this.authService.register(registerDto).subscribe(
      () => {
        alert('Registration successful!');
        this.router.navigate(['/login']);
      },
      (error) => {
        alert('Registration failed. Please try again.');
      }
    );
  }
}


