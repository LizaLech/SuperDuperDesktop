package Controllers;

import Enums.OperatorTypeOfSale;
import Models.Discount;
import Models.Offer;
import Models.SuperDuperMarket;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaleController {

    @FXML
    private VBox vboxSales = new VBox();
    private List<Button> sales = new ArrayList<>();
    @FXML private AnchorPane salePane = new AnchorPane();
    @FXML private ScrollPane scrolPaneSale = new ScrollPane();
    private Stage primaryStage = new Stage();
    @FXML Label onSaleLabel = new Label();
    @FXML Label lblDiscountOperator = new Label();
    public SaleController(){
        scrolPaneSale.setVvalue(1.0);
    }

    void showSales(SuperDuperMarket sdm, List<Discount> discounts) throws IOException {

        int height = 0;
        for (Discount discount: discounts) {

            onSaleLabel.setText(discount.Name);
            //vboxSales.getChildren().add(onSaleLabel);
            if (discount.OperatorType == OperatorTypeOfSale.ALL_OR_NOTHING){
                lblDiscountOperator.setText("To add all following offers to your order press");
                Button bt = new Button();
                bt.setText("Add");
            }else if(discount.OperatorType == OperatorTypeOfSale.ONE_OF){
                lblDiscountOperator.setText("Please select one of the following offers you would like to add to your order");
            }
            try {
                for (Offer offer:discount.Offers) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Resources/Discount.fxml"));
                    vboxSales.getChildren().add(fxmlLoader.load());
                    DiscountComponent saleComponent = fxmlLoader.getController();
                    saleComponent.SetDiscount(sdm,offer, discount.OperatorType);
                    saleComponent.setLayoutY(height * 200);
                    height++;
                    //Checkbox tb = (Checkbox)saleComponent.lookup("#cbxSelectDiscount");
                }
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    public void markAllDiscountsAsChecked() {
        for (Node node:
        vboxSales.getChildren()) {

        }
    }
}
