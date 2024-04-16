import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { CycleService } from './cycle.service';


@Injectable({
  providedIn: 'root'
})

export class AuthService {
  constructor(private http: HttpClient, private cycleService : CycleService) {}
  authUrl = 'http://localhost:8080/api/auth';

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.authUrl}/token`,{username:username, password:password}).pipe(
      tap(res => {
        localStorage.setItem('token', res['token']);
        localStorage.setItem('username', res['username']);
        //this.getRole(res['username']);
      })
    );
  }

  // getRole(username: string): void {
  //   console.log("getrole");
  //   const headers = this.cycleService.getHeaders();
    
  //   // Make an HTTP POST request and subscribe to the Observable
  //   this.http.post<any>(`${this.authUrl}/getRole/${username}`, {headers}).subscribe(
  //     response => {
  //       // Assuming the response contains the isAdmin information
  //       const isAdmin: boolean = response.isAdmin;
        
  //       // Store the isAdmin status in localStorage
  //       localStorage.setItem('isAdmin', isAdmin ? 'true' : 'false');
        
  //       console.log(localStorage.getItem('isAdmin'));
  //     },
  //     error => {
  //       // Handle errors here if needed
  //       console.error('Error while getting role:', error);
  //     }
  //   );
  // }
  

}

