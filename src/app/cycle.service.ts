import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Brand } from './brand';
import { Cycle } from './cycle';

@Injectable({
  providedIn: 'root'
})
export class CycleService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private _http: HttpClient) {}

  getHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
  }

  private handleError(error: any): Observable<any> {
    console.error('An error occurred:', error);
    return throwError(error);
  }

  getAllBrand(): Observable<Brand[]> {
    return this._http.get<Brand[]>(`${this.apiUrl}/brand/list`);
  }

  addNewBrand(name: string, qty: number, cost: number): Observable<any> {
    const headers = this.getHeaders();
    const brand: Brand = { id: 0, name, stock: qty, cost };
    return this._http.post(`${this.apiUrl}/cart/add`, brand, { headers });
  }

  restockCycle(id: number, count: number): Observable<Brand[]> {
    const headers = this.getHeaders();
    return this._http.post<Brand[]>(`${this.apiUrl}/brand/restock/${id}`, { qty: count }, { headers });
  }

  borrowBrandCycle(id: number, count: number): Observable<Brand[]> {
    const headers = this.getHeaders();
    return this._http.post<Brand[]>(`${this.apiUrl}/brand/borrow/${id}`, { qty: count }, { headers });
  }

  countAllAvailableCycleByBrandId(id: number): Observable<number> {
    const headers = this.getHeaders();
    return this._http.get<number>(`${this.apiUrl}/cycle/countAvailableByBrand/${id}`, { headers });
  }

  getAllBorrowedCycle(): Observable<Cycle[]> {
    const headers = this.getHeaders();
    return this._http.get<Cycle[]>(`${this.apiUrl}/cycle/borrowedList`, { headers });
  }

  getAllAvailableCycle(): Observable<Cycle[]> {
    const headers = this.getHeaders();
    return this._http.get<Cycle[]>(`${this.apiUrl}/cycle/availableList`, { headers });
  }

  returnCycle(id: number): Observable<Cycle[]> {
    const headers = this.getHeaders();
    return this._http.post<Cycle[]>(`${this.apiUrl}/cycle/return/${id}`, null, { headers });
  }

  borrowCycle(id: number): Observable<Cycle[]> {
    return this._http.post<Cycle[]>(`${this.apiUrl}/cycle/borrow/${id}`, null);
  }

  addBrandToCart(id: number, count: number): Observable<Brand[]> {
    const headers = this.getHeaders();
    return this._http.post<Brand[]>(`${this.apiUrl}/cart/add/${id}?quantity=${count}`, null, { headers });
  }

  getCartCycles(): Observable<Cycle[]> {
    const headers = this.getHeaders();
    return this._http.get<Cycle[]>(`${this.apiUrl}/cycle/CartList`, { headers });
  }

  removeFromCart(cycleId: number): Observable<any> {
    const headers = this.getHeaders();
    return this._http.delete(`${this.apiUrl}/cycle/removeFromCart/${cycleId}`, { headers });
  }

  updateCycleStatus(cycles: Cycle[]): Observable<any> {
    const headers = this.getHeaders();
    const cycleIds = cycles.map(cycle => cycle.id);
    return this._http.put(`${this.apiUrl}/cycle/updateStatus`, cycleIds, { headers });
  }
}
