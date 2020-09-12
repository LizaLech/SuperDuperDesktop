package Models;

public class Offer {

    public Offer(int ItemID,double Quantity,double ForAdditional  ){
        this.ItemID = ItemID;
        this.Quantity = Quantity;
        this.ForAdditional = ForAdditional;
    }
    public int ItemID;
    public double Quantity;
    public double ForAdditional;
}