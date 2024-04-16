import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CheckItemsComponent } from './check-items/check-items.component';
import { BuyItemsComponent } from './buy-items/buy-items.component';
import { BillComponent } from './bill/bill.component';

const routes: Routes = [
  {path: '', component: CheckItemsComponent},
  {path: 'buyItems', component: BuyItemsComponent},
  {path: 'bill', component: BillComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
