import { Component } from '@angular/core';
import { Cycle } from '../cycle';
import { CycleService } from '../cycle.service';

@Component({
  selector: 'available-cycle',
  templateUrl: './available-cycle.component.html',
  styleUrls: ['./available-cycle.component.css']
})
export class AvailableCycleComponent {
  cycles : Cycle[] = [];

  constructor(private cycleService: CycleService) {}

  ngOnInit() : void {
    this.cycleService.getAllAvailableCycle().subscribe(res => this.cycles = res);
    console.log(this.cycles);
  }

  borrowCycle(cycle: Cycle) : void {
    this.cycleService.borrowCycle(cycle.id).subscribe(res => this.cycles = res);
    console.log(cycle);
  }
}

