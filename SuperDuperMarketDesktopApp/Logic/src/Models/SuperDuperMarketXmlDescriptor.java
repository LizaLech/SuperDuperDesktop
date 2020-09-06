package Models;

import Handlers.OrderManager;
import generatedClasses.SDMItems;
import generatedClasses.SDMStores;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "superDuperMarket")
public class SuperDuperMarketXmlDescriptor {

    @XmlElement(name = "Orders", required = true)
    protected OrderManager Orders;

    public OrderManager getOrderManager() {
        return Orders;
    }
}

