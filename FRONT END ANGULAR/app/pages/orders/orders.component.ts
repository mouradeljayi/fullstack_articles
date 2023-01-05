import { Component, OnInit } from '@angular/core';
import { OrdersService } from 'src/app/services/orders/orders.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  constructor(private orderService: OrdersService) { }

  ngOnInit(): void {
  }

  deleteArticleFromOrder(orderId:number, productId:number) {
    this.orderService.updateOrder(orderId, productId, false).subscribe(order => {
      // Traiter la commande mise à jour
    });
  }

  

}
