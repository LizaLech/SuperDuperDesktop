package Models;

import java.util.Date;
import java.util.List;

public class OrderItem {
    public int itemId;
    public int storeId;
    public double price;
    public QuantityObject quantityObject;

    public OrderItem(){
        this.quantityObject= new QuantityObject();
    }

    public OrderItem(int itemId, int price, int storeId) {
        this.itemId= itemId;
        this.storeId= storeId;
        this.price= price;
        this.quantityObject= new QuantityObject();
    }

}
