package Controllers;
import Handlers.ItemHandler;
import Handlers.StoreHandler;
import Handlers.SuperDuperHandler;
import Models.*;
import UIUtils.CommonUsed;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Accordion;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

public class ShowMarketsController {
    @FXML
    private Accordion accodionPane;
    private SuperDuperHandler superDuperHandler = new SuperDuperHandler();
    private ItemHandler itemHandler = new ItemHandler();
    private StoreHandler storeHandler = new StoreHandler();
    void showMarkets(SuperDuperMarket superDuperMarket, Pane textPane) {


/*        TitledPane changedFilesTitledPane = new TitledPane();
        ListView<String> changedFilesListView = new ListView<>();
        TitledPane deletedFilesTitledPane = new TitledPane();
        ListView<String> deletedFilesListView = new ListView<>();*/


        FXMLLoader fxmlLoader = new FXMLLoader();
        URL url = getClass().getResource("/Resources/ShowMarketsScreen.fxml");
        fxmlLoader.setLocation(url);

        List<Store> stores = superDuperMarket.Stores;
        try {
            accodionPane =  fxmlLoader.load(url.openStream());


            for (int i = 0; i < superDuperMarket.Stores.toArray().length; i++) {
                TitledPane newFilesTitledPane = new TitledPane();
                ListView<String> newFilsListView = new ListView<>();

                ObservableList<String> storeDetails = FXCollections.observableArrayList();

                Store store = stores.get(i);

                storeDetails.add( String.format("Store number %d", i + 1) + ": ");
                storeDetails.add(String.format("Serial number: %d", store.serialNumber));
                storeDetails.add(String.format("Store name: %s", store.name));
                storeDetails.add("");

                List<OrderItem> orderItems = store.Inventory;
                if (orderItems != null) {
                    storeDetails.add("items:");

                    for (int j = 0; j < orderItems.toArray().length; j++) {
                        OrderItem orderItem = orderItems.get(j);
                        Item item = superDuperHandler.getItemById(superDuperMarket, orderItem.itemId);
                        storeDetails.add(String.format("%-25s  %-25s  %-25s  %-25s", "Serial number:" + orderItem.itemId, " Name:" + item.name, " Purchase type:" + item.purchaseType.toString(), " Price:" + orderItem.price));
                        double soldItemsAmount = itemHandler.CalculateSoldItemsAmountPerStore(superDuperMarket, item.serialNumber, store.serialNumber);
                        storeDetails.add("Amount of sold items: " +String.format("%.2f", soldItemsAmount));
                        storeDetails.add("");
                    }
                }
                storeDetails.add("");
                List<Integer> ordersIds = store.OrderHistoryIDs;

                if (ordersIds.size() > 0) {
                    storeDetails.add("Orders:");
                    for (int orderID : ordersIds) {
                        Order order = superDuperMarket.Orders.GetOrderByOrderID(superDuperMarket, orderID);
                        DateFormat dateFormat = new SimpleDateFormat("dd/mm-hh:mm");
                        storeDetails.add(String.format("%-25s  %-25s  %-25s  %-25s  %-25s", "Date:" +
                                dateFormat.format(order.purchaseDate), "Total amount of items:" +
                                String.format("%.2f", storeHandler.countTotalItemsAmountOfStoreInOrder(order, store)), "Toatal cost of items :" +
                                String.format("%.2f", storeHandler.countTotalCostItemsOfStoreInOrder(order, store)), "Delevery price:" +
                                String.format("%.2f", storeHandler.countDeliveryPriceOfStoreInOrder(order, store)), "Total price:" +
                                String.format("%.2f", storeHandler.countTotalPriceOfStoreInOrder(order, store))));
                        storeDetails.add("");
                    }
                }
                storeDetails.add(String.format("PPK: %d", store.PPK));
                double totalDeliveriesCost = storeHandler.getStoreById(superDuperMarket, store.serialNumber).CalculateTotalDeliveriesCost(superDuperMarket);
                storeDetails.add("Total cost of deliveries from store: " +String.format("%.2f", totalDeliveriesCost) + "\n");

                newFilsListView.setItems(storeDetails);

                newFilesTitledPane.setContent(newFilsListView);
                newFilesTitledPane.setText(String.format("Store number %d", i + 1));
                newFilesTitledPane.setStyle("-fx-text-fill: #052f59; -fx-font-weight: bold;");
                accodionPane.getPanes().addAll(newFilesTitledPane);
            }





/*
            ObservableList<String> changedItems = FXCollections.observableArrayList(changedFiles);
            changedFilesListView.setItems(changedItems);

            ObservableList<String> deletedItems = FXCollections.observableArrayList(deletedFiles);
            deletedFilesListView.setItems(deletedItems);
*/



            //for (int i = 0; i < stores.toArray().length; i++) {
            //    Store store = stores.get(i);
//
            //    System.out.println(String.format("Store number %d", i + 1) + ": ");
            //    System.out.println(String.format("Serial number: %d", store.serialNumber));
            //    System.out.println(String.format("Store name: %s", store.name));
            //    System.out.println("Items:");
//
            //    List<OrderItem> orderItems = store.Inventory;
            //    if (orderItems != null) {
            //        printOrderItems(store.serialNumber, orderItems, true);
            //    }
//
            //    printOrdersOfStore(store);
//
            //    System.out.println(String.format("PPK: %d", store.PPK));
            //    double totalDeliveriesCost = storeHandler.getStoreById(superDuperMarket, store.serialNumber).CalculateTotalDeliveriesCost(superDuperMarket);
            //    System.out.println("Total cost of deliveries from store: " +String.format("%.2f", totalDeliveriesCost) + "\n");
//
            //}





/*            changedFilesTitledPane.setContent(changedFilesListView);
            changedFilesTitledPane.setText("Changed Files:");
            changedFilesTitledPane.setStyle("-fx-text-fill: #052f59; -fx-font-weight: bold;");

            deletedFilesTitledPane.setContent(deletedFilesListView);
            deletedFilesTitledPane.setText("Deleted Files:");
            deletedFilesTitledPane.setStyle("-fx-text-fill: #052f59; -fx-font-weight: bold;");*/


             // changedFilesTitledPane, deletedFilesTitledPane

            textPane.getChildren().clear();
            textPane.getChildren().add(accodionPane);
            accodionPane.prefWidthProperty().bind(textPane.widthProperty());

        } catch(IOException e) {
            CommonUsed.showError(e.getMessage());
        }
    }

}
