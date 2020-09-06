package Models;

public class Offer {

    public Offer(int ItemID,double Quantity,double ForAdditional  ){
        this.ItemID = ItemID;
        this.Quantity = Quantity;
        this.ForAdditional = ForAdditional;
    }

    int ItemID;
    double Quantity;
    double ForAdditional;
}