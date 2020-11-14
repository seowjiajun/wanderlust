import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { BookingsComponent } from './bookings/bookings.component';
import { PackagesComponent } from './packages/packages.component';
import { DealsComponent } from './deals/deals.component';
import { RegisterComponent } from './register/register.component';
import { BookComponent } from './book/book.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'home/:userId',component: HomeComponent },

  //for login
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },

  //for searched packages
  { path: 'packages/:search', component: PackagesComponent },

  //for hot deals
  { path: 'deals', component: DealsComponent },

  //for bookings
  { path: 'book/:destinationId', component: BookComponent },
  { path: 'bookings', component: BookingsComponent },

  //handlers for empty path and catch all
  { path: '', component:HomeComponent },
  { path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }