import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ContentComponent} from './component/shared/content/content.component';
import {LoginComponent} from './component/login/login/login.component';
import {ProductDetailComponent} from './component/product/product-detail/product-detail.component';
import {ShoppingCartComponent} from './component/cart/shopping-cart/shopping-cart.component';
import {UserGuard} from './component/security-authentication/security-auth/user.guard';
import {ErrorComponent} from './component/error/error.component';
import {OrderHistoryComponent} from './component/order-history/order-history.component';
import {InformationUserComponent} from './component/information-user/information-user.component';


const routes: Routes = [
  {path: '', component: ContentComponent},
  {path: 'login', component: LoginComponent},
  {path: 'product/detail/:id', component: ProductDetailComponent},
  {path: 'product/cart/:id', component: ShoppingCartComponent, canActivate: [UserGuard]},
  {path: 'order/history/:id', component: OrderHistoryComponent, canActivate: [UserGuard]},
  {path: 'account/info/:id', component: InformationUserComponent, canActivate: [UserGuard]},
  {path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
