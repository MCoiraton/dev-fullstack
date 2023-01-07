import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentComponent } from './appointment/appointment.component';
import { CenterlistComponent } from './centerlist/centerlist.component';
import { SearchAppointmentComponent } from './search-appointment/search-appointment.component';
import { SearchbarComponent } from './searchbar/searchbar.component';

const routes: Routes = [
  { path: 'search', component: SearchbarComponent},
  { path: 'appointment/:idCentre', component: AppointmentComponent},
  { path: 'list/:ville', component: CenterlistComponent},
  { path: 'searchAppointment', component: SearchAppointmentComponent},
  { path : '', redirectTo: 'search', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
