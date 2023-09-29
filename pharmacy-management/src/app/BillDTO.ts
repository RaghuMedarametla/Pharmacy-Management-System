import { Ordered_Drugs } from "./Ordered_Drugs";
import { Orders } from "./Orders";

export class BillDTO{

    orderId: number = 0;
    customerssn: string = "";  
    totalAmount: number = 0;
    customerAmount: number = 0; 
    order: Orders = new Orders;
    ordereddrugs: Ordered_Drugs[] = [];

    constructor(){
        
    }
}



