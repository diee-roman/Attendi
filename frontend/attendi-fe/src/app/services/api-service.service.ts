import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {AddCustomerData} from "../model/add-customer-data";
import {addCustomerUrl} from "../api-urls/api-urls";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  addCustomer(partnerId: number, customerName: string): Observable<AddCustomerData> {
    const url = addCustomerUrl(partnerId);
    return this.http.post<AddCustomerData>(url, {name: customerName}).pipe(
      map(body => body)
    );
  }
}
