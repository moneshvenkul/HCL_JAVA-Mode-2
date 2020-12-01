import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../Customer';
import { CustomerserviceService } from '../customerservice.service';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.css']
})
export class CustomersListComponent implements OnInit {

  customers: Observable<Customer[]>;

  constructor(private customerService: CustomerserviceService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(){
    this.customers = this.customerService.getCustomersList();
  }

  deleteCustomers() {
    this.customerService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }
}
