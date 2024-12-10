import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  {

  email: string = '';
  password: string = '';

  constructor(
    private router: Router,
    private authService: AuthService // Inject AuthService
  ) {}

  // // Check if form is valid
  // get isFormValid(): boolean {
  //   return (
  //     this.email !== '' &&
  //     this.password !== ''
  //   );
  // }

  // Handle login submission
  onLoginSubmit(): void {
    console.log("submit function")
    console.log(this.email,this.password)
    if (this.email && this.password) {
      const credentials = { email: this.email, password: this.password };
      this.authService.login(credentials).subscribe(
        {next:(response) => {
          // Successfully logged in, redirect based on role
          console.log('Login successful:', response);
          const role = sessionStorage.getItem('role');
          if (role === 'ADMIN') {
            this.router.navigate(['/admin']);
          } else if (role === 'USER') {
            this.router.navigate(['/user']);
            
          }
        },
        error:(error) => {
          console.error('Login failed:', error);
          alert('Invalid email or password.');
        }}
      );
    }
  }
}

  // email: string = '';  // Ensure this is a string
  // password: string = '';  // Ensure this is a string

  // constructor(private router: Router) {}

  // onLoginSubmit(form: any) {
  //   if (form.valid) {
  //     // Handle the login process here
  //     console.log('Email:', this.email);
  //     console.log('Password:', this.password);
  //   }
  // }

//   loginForm: FormGroup;

//   constructor(
//     private fb: FormBuilder,
//     private authService: AuthService,
//     private router: Router,
//     // private toastr: ToastrService
//   ) {}

//   ngOnInit(): void {
//     this.loginForm = this.fb.group({
//       email: ['', [Validators.required, Validators.email]],
//       password: ['', [Validators.required]],
//     });
//   }

//   onSubmit(): void {
//     if (this.loginForm.invalid) return;

//     const formData = this.loginForm.value;
//     this.authService.login(formData).subscribe(
//       (response) => {
//         // Store token and role in sessionStorage
//         sessionStorage.setItem('token', response.token);
//         sessionStorage.setItem('role', response.roles);

//         // this.toastr.success('Login successful!');
//         this.router.navigate([this.redirectBasedOnRole(response.roles)]);
//       },
//       (error) => {
//         // this.toastr.error('Login failed!');
//         console.error(error);
//       }
//     );
//   }

//   private redirectBasedOnRole(role: string): void {
//     if (role === 'USER') {
//       window.location.href = 'http://localhost:4202';
//     } else if (role === 'ADMIN') {
//       window.location.href = 'http://localhost:4201';
//     } 
//   }


// }

