import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-check-items',
  templateUrl: './check-items.component.html',
  styleUrls: ['./check-items.component.css']
})
export class CheckItemsComponent implements OnInit{
  itemList : any[] = [];

  constructor(private itemService : ItemService){}

  ngOnInit(): void {
    this.itemList = this.itemService.itemsArray;
    console.log(this.itemList);
  }

  
  
  

}
