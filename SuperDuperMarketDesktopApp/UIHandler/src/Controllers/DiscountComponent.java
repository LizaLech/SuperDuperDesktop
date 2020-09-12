package Controllers;

import Enums.OperatorTypeOfSale;
import Handlers.ItemHandler;
import Handlers.SuperDuperHandler;
import Models.*;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.io.IOException;
import javafx.scene.control.CheckBox;

public class DiscountComponent extends VBox {

    @FXML
    private Label lblSale;
    @FXML
    private Label lblPrice;
    @FXML
    private Label lblItem;
    @FXML
    private Label lblQuantity;
    @FXML
    private VBox vboxOffers;


    @FXML private CheckBox cbxSelectDiscount;

    private final ReadOnlyObjectWrapper<Customer> currentCustomer = new ReadOnlyObjectWrapper<>();

    public ReadOnlyObjectProperty<Customer> currentCustomerProperty() {
        return currentCustomer.getReadOnlyProperty() ;
    }
    public Customer getCurrentCustomer() {
        return currentCustomer.get();
    }
    private SuperDuperHandler superDuperHandler;
    private OperatorTypeOfSale operatorTypeOfSale;

    public DiscountComponent() {

        superDuperHandler = new SuperDuperHandler();
/*        chk1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String x = "";
            }
        });*/

                //.setOnAction(eh);
    }

    public void SetDiscount(SuperDuperMarket sdm, Offer offer, OperatorTypeOfSale operatorTypeOfSale) {
        this.operatorTypeOfSale = operatorTypeOfSale;
        lblPrice.setText(Double.toString(offer.ForAdditional));
        Item item = superDuperHandler.getItemById(sdm, offer.ItemID);
        lblSale.setText(item.name);
        lblQuantity.setText(Integer.toString((int) offer.Quantity));


        cbxSelectDiscount.selectedProperty().addListener(checkboxChange);
    }

    ChangeListener checkboxChange = new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) {

            if (new_val) {
                //if (operatorTypeOfSale == OperatorTypeOfSale.ALL_OR_NOTHING){
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Resources/SaleScreen.fxml"));
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                SaleController sc = fxmlLoader.getController();
                    sc.markAllDiscountsAsChecked();
                //}else  if (operatorTypeOfSale == OperatorTypeOfSale.ONE_OF){

                //}
            }

        }};




}