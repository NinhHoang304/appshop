import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NavbarComponent} from './component/shared/navbar/navbar.component';
import {FooterComponent} from './component/shared/footer/footer.component';
import {ContentComponent} from './component/shared/content/content.component';
import {ProductDetailComponent} from './component/product/product-detail/product-detail.component';
import {ShoppingCartComponent} from './component/cart/shopping-cart/shopping-cart.component';
import {LoginComponent} from './component/login/login/login.component';
import {RouterModule} from '@angular/router';
import {ErrorComponent} from './component/error/error.component';
import {AuthInterceptor} from './component/security-authentication/security-auth/auth.interceptor';
import { OrderHistoryComponent } from './component/order-history/order-history.component';
import { InformationUserComponent } from './component/information-user/information-user.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    ContentComponent,
    ProductDetailComponent,
    ShoppingCartComponent,
    LoginComponent,
    ErrorComponent,
    OrderHistoryComponent,
    InformationUserComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule,
    FormsModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
