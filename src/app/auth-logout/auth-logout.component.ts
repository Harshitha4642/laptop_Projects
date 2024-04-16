import { Component, Inject } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import { DOCUMENT } from '@angular/common';


@Component({
  selector: 'app-auth-logout',
  templateUrl: './auth-logout.component.html',
  styleUrls: ['./auth-logout.component.css']
})
export class AuthLogoutComponent {
  constructor(@Inject(DOCUMENT) public document: Document, public auth: AuthService) {}
  
  
  
  
  demo() : void{
    
}

}