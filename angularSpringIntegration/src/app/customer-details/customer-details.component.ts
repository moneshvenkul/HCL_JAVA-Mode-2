import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../Customer';
import { CustomersListComponent } from '../customers-list/customers-list.component';
import { CustomerserviceService } from '../customerservice.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {

  @Input() customer: Customer;
  
  constructor(private router: Router,private customerService: CustomerserviceService, private listComponent: CustomersListComponent) { }

  ngOnInit(): void {
  }

  editCustomer(customer: Customer): void{
    console.log("into edit");
    localStorage.setItem("id",customer.id.toString());
    this.router.navigate(["edit"]);
  }

  deleteCustomer() {
    this.customerService.deleteCustomer(this.customer.id)
      .subscribe(
        data => {
          console.log(data);
          this.listComponent.reloadData();
        },
        error => console.log(error));
  }
}
