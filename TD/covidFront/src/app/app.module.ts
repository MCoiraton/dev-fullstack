import { NgModule } from '@angular/core';
import { MatInputModule, } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card'; 
import { MatButtonModule } from '@angular/material/button'; 
import { BrowserModule } from '@angular/platform-browser';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchbarComponent } from './searchbar/searchbar.component';
import { CenterlistComponent } from './centerlist/centerlist.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule }        from '@angular/forms';
import { SearchAppointmentComponent } from './search-appointment/search-appointment.component';
import { LoginComponent } from './login/login.component';
import { WaitingComponent } from './waiting/waiting.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchbarComponent,
    CenterlistComponent,
    AppointmentComponent,
    SearchAppointmentComponent,
    LoginComponent,
    WaitingComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    MatProgressBarModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
