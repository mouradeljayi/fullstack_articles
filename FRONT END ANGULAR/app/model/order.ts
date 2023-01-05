import { Article } from "./article";

export class Order {
    id?: number;
    date?: Date;
    products?: Article[];
    total?: number;
}
  