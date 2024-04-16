import { Component } from '@angular/core';
import { Cycle } from '../cycle';
import { CycleService } from '../cycle.service';

@Component({
  selector: 'borrowed-cycle',
  templateUrl: './borrowed-cycle.component.html',
  styleUrls: ['./borrowed-cycle.component.css']
})
export class BorrowedCycleComponent {
  cycles : Cycle[] = [];
  cost : number = 0;

  constructor(private cycleService: CycleService) {}

  ngOnInit() : void {
    this.cycleService.getAllBorrowedCycle().subscribe(res => this.cycles = res);
    console.log(this.cycles);
  }


  returnSelectedCycles(): void {
    alert("Refresh to see update");
    const selectedCycles = this.cycles.filter(cycle => cycle.selected);
    if (selectedCycles.length === 0) {
      console.log("No cycles selected for return.");
      return;
    }

    this.cycleService.updateCycleStatus(selectedCycles).subscribe(response => {
      this.cycleService.getAllBorrowedCycle().subscribe(res => this.cycles = res);
    });
  }

  addCost(cost : number, seleted: boolean, status: boolean)
  {
    if(!status)
      if(!seleted)
        this.cost = this.cost + cost;
      else
      this.cost = this.cost - cost;
  }
  }



