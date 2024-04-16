import { Component } from '@angular/core';
import { ItemService } from '../item.service';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-buy-items',
  templateUrl: './buy-items.component.html',
  styleUrls: ['./buy-items.component.css']
})
export class BuyItemsComponent {
  constructor(private itemService: ItemService, private router: Router) {}

  product_id : number = 0;
  itemsOfDoor : any[] = []; 
  quantities: number[] = [0,0,0];
  message: string = "";
  flag: boolean = true;

  getItemsOfDoor(): any{
    this.itemsOfDoor = this.itemService.getItemsOfDoor(this.product_id);
    console.log(this.itemsOfDoor);
  };

  he(){}

  closeDoor(): void{
    console.log(this.quantities);
    this.flag = true;

    for(var i = 0; i < this.itemsOfDoor.length; i++)
    {
        if(this.quantities[i] > this.itemsOfDoor[i].quantity)
        {
              this.message = "Qunatity exceeded";
              this.flag = false;
        }
    }
    if(this.flag){
    this.itemService.save(this.itemsOfDoor, this.quantities);
    this.router.navigate(['bill']);
    }
    
  }


}
