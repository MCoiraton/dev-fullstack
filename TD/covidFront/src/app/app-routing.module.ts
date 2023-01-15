import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentComponent } from './appointment/appointment.component';
import { AdminGuard } from './guard/admin.guard';
import { AuthGuard } from './guard/auth.guard';
import { SuperAdminGuard } from './guard/super-admin.guard';
import { CenterManagementComponent } from './center-management/center-management.component';
import { CenterlistComponent } from './centerlist/centerlist.component';
import { CreateUserComponent } from './CreateUser/create-user.component';
import { LoginComponent } from './login/login.component';
import { SearchAppointmentComponent } from './search-appointment/search-appointment.component';
import { SearchbarComponent } from './searchbar/searchbar.component';
import { WaitingComponent } from './waiting/waiting.component';

const routes: Routes = [
  { path: 'search', component: SearchbarComponent},
  { path: 'appointment/:idCentre', component: AppointmentComponent},
  { path: 'admin/centerManagement', component: CenterManagementComponent, canActivate:[AdminGuard]},
  { path: 'list/:ville', component: CenterlistComponent},
  { path: 'searchAppointment', component: SearchAppointmentComponent, canActivate:[AuthGuard]},
  { path: 'login', component: LoginComponent},
  { path: 'waiting/:temps', component: WaitingComponent},
  { path: 'createUser', component:CreateUserComponent, canActivate:[AdminGuard]},

  { path : '**', redirectTo: 'search', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
