import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({ 
    'Access-Control-Allow-Origin':'*',
    
  })
};

@Injectable({
  providedIn: 'root'
})
export class CustomerserviceService {
 

  private baseUrl = 'http://localhost:8081/api/customers';
  // private baseUrl = '/api/customers';

  constructor(private http: HttpClient) { }

  createCustomer(customer: any): Observable<any>{
    return this.http.post(this.baseUrl, customer);
  }
    getCustomersList(): Observable<any>{
      return this.http.get(this.baseUrl);
  }

  deleteAll(): Observable<any>{
    return this.http.delete(this.baseUrl);
  }

  getCustomer(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getCustomersByAge(age: number): Observable<any> {​​​​​​​
    // return this.http.get(`${​​​​​​​this.baseUrl}​​​​​​​/age/${​​​​​​​age}​​​​​​​`,httpOptions);
    return this.http.get(`api/customers/age/${age}`);
  }​​​​​​​
  

  updateCustomer(customer: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}` + `/update`, customer);
  }

  deleteCustomer(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
