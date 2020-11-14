import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NavComponent } from './nav/nav.component';
import { FootComponent } from './foot/foot.component';
import { AccordionModule } from 'primeng/accordion';
import { DialogModule } from 'primeng/dialog';
import { SidebarModule } from 'primeng/sidebar';
import { TabViewModule } from 'primeng/tabview';
import { InputSwitchModule } from 'primeng/inputswitch';
import { FieldsetModule } from 'primeng/fieldset';
import { ToastModule } from 'primeng/toast';
import { ProgressSpinnerModule } from 'primeng/progressspinner';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from './service/login.service';
import { AuthService } from './core/auth.service';
import { LoginGuard } from './service/login-guard.service';
import { MessageService } from 'primeng/components/common/messageservice';
import { BookingsComponent } from './bookings/bookings.component';
import { CancelBookingDialogComponent } from './cancel-booking-dialog/cancel-booking-dialog.component';
import { BookingsService } from './service/bookings.service';
import { CancelBookingDialogService } from './service/cancel-booking-dialog.service';
import { PackagesComponent } from './packages/packages.component';
import { DealsComponent } from './deals/deals.component';
import { PackagesService } from './service/packages.service';
import { RegisterService } from './service/register.service';
import { RegisterComponent } from './register/register.component';
import { RegisterPipe } from './pipe/register.pipe';
import { BookComponent } from './book/book.component';
import { CancelBookingErrorDialogComponent } from './cancel-booking-error-dialog/cancel-booking-error-dialog.component';
import { CancelBookingErrorDialogService } from './service/cancel-booking-error-dialog.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavComponent,
    FootComponent,
    BookingsComponent,
    CancelBookingDialogComponent,
    PackagesComponent,
    DealsComponent,
    RegisterComponent,
    RegisterPipe,
    BookComponent,
    CancelBookingErrorDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AccordionModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    DialogModule,
    SidebarModule,
    TabViewModule,
    InputSwitchModule,
    FieldsetModule,
    ToastModule,
    ProgressSpinnerModule,
    NgbModule
  ],
  providers: [
    LoginService,
    LoginGuard,
    AuthService,MessageService,
    BookingsService,
    CancelBookingDialogService,
    PackagesService,
    RegisterService,
    CancelBookingErrorDialogService
  ],
  bootstrap: [AppComponent],
  entryComponents: [ 
    CancelBookingDialogComponent,
    CancelBookingErrorDialogComponent
  ]
})

export class AppModule { }