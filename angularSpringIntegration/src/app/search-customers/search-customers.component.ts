import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerserviceService } from '../customerservice.service';

@Component({
  selector: 'app-search-customers',
  templateUrl: './search-customers.component.html',
  styleUrls: ['./search-customers.component.css']
})
export class SearchCustomersComponent implements OnInit {

  age : number;
  customers : Customer[];
  constructor(private customerService : CustomerserviceService) { }

  ngOnInit(): void {
    this.age = 0;
  }

  private searchCustomers() {​​​​​​​
    this.customers = [];
    this.customerService.getCustomersByAge(this.age)
      .subscribe(customers => this.customers = customers);
  }​​​​​​​
 
  onSubmit() {​​​​​​​
    this.searchCustomers();
  }​​​​​​​
}​​​​​​​

