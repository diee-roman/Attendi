import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, map, Observable, of} from "rxjs";
import {ApiService} from "../../services/api-service.service";
import {AddCustomerData} from "../../model/add-customer-data";

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})

export class AddCustomerComponent implements OnInit {

  error: string | undefined;
  loading = false;
  customerName: string = "";
  data: Observable<AddCustomerData> | undefined;

  constructor(private apiService: ApiService) {
  }

  ngOnInit(): void {
  }


  public onSubmit(): void {
    this.loading = true;

    this.apiService.addCustomer(1, this.customerName).pipe(
      map((data: AddCustomerData) => data))
      .subscribe(  (data) => {
        this.data = of(data);
        this.loading = false;
    },
        (error) => this.error = error.error);
  }

}
