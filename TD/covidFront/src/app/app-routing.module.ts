import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentComponent } from './appointment/appointment.component';
import { CenterlistComponent } from './centerlist/centerlist.component';
import { SearchbarComponent } from './searchbar/searchbar.component';

const routes: Routes = [
  { path: 'search', component: SearchbarComponent},
  { path: 'appointment/:idCentre', component: AppointmentComponent},
  { path: 'list/:ville', component: CenterlistComponent},
  { path: 'appointment/:email', component: AppointmentComponent},
  { path : '', redirectTo: 'search', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
