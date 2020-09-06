package Handlers;

import Models.*;
import generatedClasses.SuperDuperMarketDescriptor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class OrderManager {

    public String ordersHistoryPath;
    private  int _orderID = 1;

    @XmlElement
    public Map<Integer, Order> ordersMap = new HashMap<Integer, Order>();

    private StoreHandler storeHandler;

    public OrderManager() {

        storeHandler = new StoreHandler();

    }

    public OrderItem FindCheapestStoreForItem(SuperDuperMarket superDuperMarket, int itemSerialNumber) {

        OrderItem cheapestOrderItem = null;

        for (int i = 0; i < superDuperMarket.Stores.toArray().length; i++){

            Store store = superDuperMarket.Stores.get(i);

            OrderItem orderItem = new StoreHandler().GetOrderItemByItemId(store, itemSerialNumber);

            if (cheapestOrderItem == null) {
                cheapestOrderItem = storeHandler.CloneOrderItem(orderItem);

            }
            if (orderItem !=null && cheapestOrderItem!=null){
                if (cheapestOrderItem.price > orderItem.price){
                    cheapestOrderItem = storeHandler.CloneOrderItem(orderItem);
                }
            }
        }
        return cheapestOrderItem;
    }

    public Order GetOrderByOrderID(SuperDuperMarket sdm, int orderId) {
        return sdm.Orders.ordersMap.get(orderId);
    }

    public void addOrder(SuperDuperMarket superDuperMarket, Order order) {

        order.id = _orderID;
        _orderID++;

        for (OrderItem orderItem: order.orderItems) {

            Store store = storeHandler.getStoreById(superDuperMarket, orderItem.storeId);

            if (store.OrderHistoryIDs.contains(order.id) == false) {
                store.OrderHistoryIDs.add(order.id);
            }
        }

        ordersMap.put(order.id, order);
    }









}
