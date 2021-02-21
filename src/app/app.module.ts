import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AdminComponent } from './admin/admin.component';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { OrderlistComponent } from './admin/orderlist/orderlist.component';
import { AdminNavComponent } from './admin/admin-nav/admin-nav.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    AdminComponent,
    DashboardComponent,
    OrderlistComponent,
    AdminNavComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
