import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor() { }

  doorItems: any [] = [];
  quantities: number[] = [];

  itemsArray: any[] = [
    {
      id: 1,
      name: 'dairy milk',
      quantity: 8,
      doorNo: 1,
      cost:50
    },
    {
      id: 2,
      name: 'Lays',
      quantity: 9,
      doorNo: 1,
      cost: 20
    },
    {
      id: 3,
      name: 'oreo biscuits',
      quantity: 7,
      doorNo: 1,
      cost: 20
    },
    {
      id: 4,
      name: 'maaza',
      quantity: 6,
      doorNo: 2,
      cost:40
    },
    {
      id: 5,
      name: 'snickers',
      quantity: 4,
      doorNo: 2,
      cost: 30
    },
    {
      id: 6,
      name: 'cake',
      quantity: 3,
      doorNo: 2,
      cost: 100
    },
    {
      id: 7,
      name: 'bourbon biscuits',
      quantity: 10,
      doorNo: 3,
      cost:10
    },
    {
      id: 8,
      name: 'noodles',
      quantity: 6,
      doorNo: 3,
      cost: 70
    },
    {
      id: 9,
      name: 'kurkure',
      quantity: 12,
      doorNo: 3,
      cost: 20
    }
  ];  


  getItemsOfDoor(id: number): any[]{
    const door_id: number = this.getDoorId(id);
    const itemsOfDoor : any [] = [];
    for( const item of this.itemsArray)
    { 
        if(item.doorNo === door_id)
        {
          itemsOfDoor.push(item);
        }
    }
    return itemsOfDoor;
  }

  getDoorId(id: number): number{
    if(id === 1 || id === 2 || id ===3)
    {
      return 1;
    }
    else if(id === 4 || id===5 || id ===6)
    {
      return 2;
    }
    else if(id === 7 || id===8 || id ===9)
    {
      return 3;
    }
    else{
      return -1;
    }
  }

  save(doorItems: any[], quantities: number[]): void{
    this.doorItems = doorItems;
    this.quantities = quantities;
    this.modify();
  }

  getDoorItems() : any[]{
    return this.doorItems;
  }
  getQuantities(): number[]{
    return this.quantities;
  }

  modify(): void {
    for (var i = 0; i < this.itemsArray.length; i++) {
      const door = this.getDoorId(this.doorItems[i]);
  
      // Find the index of the item in doorItems based on name
      const j = this.doorItems.findIndex(item => item.name === this.itemsArray[i].name);
  
      if (j !== -1 && this.itemsArray[i].doorNo === door) {
        console.log(j);
        console.log(this.itemsArray[i].quantity);
        this.itemsArray[i].quantity = this.itemsArray[i].quantity - this.quantities[j];
        console.log(this.itemsArray[i].quantity);
      }
    }
  }

}
