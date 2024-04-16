import { Component } from '@angular/core';
import { Cycle } from '../cycle';
import { CycleService } from '../cycle.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

  cycles: Cycle[] = [];

  constructor(private cycleService: CycleService) {}

  ngOnInit(): void {
    this.cycleService.getCartCycles().subscribe(res => this.cycles = res);
    console.log(this.cycles);
  }

  remove(cycle: Cycle): void {
    this.cycleService.removeFromCart(cycle.id).subscribe(() => {
      console.log("Cycle removed from cart successfully");
      
    });
    
  }

  checkoutSelectedCycles(): void {
    const selectedCycles = this.cycles.filter(cycle => cycle.selected);
    if (selectedCycles.length === 0) {
      console.log("No cycles selected for checkout.");
      return;
    }

    // Perform the remove action for selected cycles (checkout)
    selectedCycles.forEach(cycle => {
      this.remove(cycle);
    });

    window.location.reload();
    
  }
}
