import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit{
  constructor(private service: ItemService){}
  quantities: number[] = [0,0,0];
  itemsOfDoor: any[] = [];

  totalPay : number = 0;

  bill: any[] = [];
  i=0;

  ngOnInit(): void {
    this.quantities = this.service.getQuantities();
    this.itemsOfDoor = this.service.getDoorItems();

    console.log(this.quantities);
    console.log(this.itemsOfDoor);
    
      for (let i = 0; i < this.itemsOfDoor.length; i++) {
        const item = this.itemsOfDoor[i];
    
        const billItem = {
          name: item.name,
          quantity: this.quantities[i],
          cost: item.cost,
          total: this.quantities[i] * item.cost,
        };

        this.totalPay = this.totalPay + billItem.total;
    
        this.bill.push(billItem);
      }

      console.log(this.bill);
    }


  }
  
