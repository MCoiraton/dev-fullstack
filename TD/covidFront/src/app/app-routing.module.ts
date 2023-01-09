import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentComponent } from './appointment/appointment.component';
import { CenterManagementComponent } from './center-management/center-management.component';
import { SearchAppointmentComponent } from './search-appointment/search-appointment.component';
import { SearchbarComponent } from './searchbar/searchbar.component';

const routes: Routes = [
  { path: 'search', component: SearchbarComponent},
  { path: 'appointment/:idCentre', component: AppointmentComponent},
  { path: 'centerRdv/:idCentre', component: CenterManagementComponent},
  { path: 'searchAppointment', component: SearchAppointmentComponent},
  { path : 'centerManagement', component: CenterManagementComponent},
  { path : '', redirectTo: 'search', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
