import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from 'src/app/model/order';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  private localUrl = environment.API_URL;


  constructor(private http:HttpClient) { }

  updateOrder(orderId: number, productId: number, add: boolean): Observable<Order> {
    const params = new HttpParams().set('add', add ? 'true' : 'false');
    return this.http.put<Order>(`${this.localUrl}/${orderId}/products/${productId}`, null, { params });
  }

  
}
