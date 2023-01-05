import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { ArticlesComponent } from './pages/articles/articles.component';
import { OrdersComponent } from './pages/orders/orders.component';


@NgModule({
  declarations: [
    AppComponent,
    ArticlesComponent,
    OrdersComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule,
    RouterModule.forRoot([
      { path: 'articles', component: ArticlesComponent },
      { path: 'orders', component: OrdersComponent }

    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
