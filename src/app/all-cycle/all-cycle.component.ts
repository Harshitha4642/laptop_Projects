import { Component, OnInit } from '@angular/core';
import { Brand } from '../brand';
import { CycleService } from '../cycle.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-all-cycle',
  templateUrl: './all-cycle.component.html',
  styleUrls: ['./all-cycle.component.css']
})
export class AllCycleComponent implements OnInit {
  brands: Brand[] = [];
  count: number = 1;

  constructor(private cycleService: CycleService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.cycleService.getAllBrand().subscribe(res => {
      this.brands = res;
    });
  }

  borrow(brand: Brand): void {
    this.cycleService.borrowBrandCycle(brand.id, this.count).subscribe(res => this.brands = res);
    this.count = 1;
  }

  addToCart(brand: Brand): void {
    this.cycleService.addBrandToCart(brand.id, this.count).subscribe(res => {
      this.brands = res;
      //this.toastr.success('Cycle added to cart', 'Success'); // Display success message
    });
    alert("Cycle added to cart");
  }
}
