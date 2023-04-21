import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import { NavbarComponent } from './component/shared/navbar/navbar.component';
import { FooterComponent } from './component/shared/footer/footer.component';
import { ContentComponent } from './component/shared/content/content.component';
import { ProductDetailComponent } from './component/product/product-detail/product-detail.component';
import { ShoppingCartComponent } from './component/cart/shopping-cart/shopping-cart.component';
import { LoginComponent } from './component/login/login/login.component';
import {RouterModule} from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    ContentComponent,
    ProductDetailComponent,
    ShoppingCartComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
