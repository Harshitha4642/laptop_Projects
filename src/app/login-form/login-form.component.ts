import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {
  username: string = "";
  password: string = "";

  constructor(private authService: AuthService, private router: Router) {}

  login(): void {
    console.log("Login success");
    this.authService.login(this.username, this.password).subscribe(() => {
        this.router.navigate(['/allCycles']);
      });
    };
  }

