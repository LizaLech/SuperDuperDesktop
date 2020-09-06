package Controllers;

import Handlers.SuperDuperHandler;
import Models.Discount;
import Models.Store;
import Models.SuperDuperMarket;
import UIUtils.CommonUsed;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SaleController {

    @FXML
    private VBox vboxSales = new VBox();
    private List<Button> sales = new ArrayList<>();
    @FXML private AnchorPane salePane;
    @FXML private ScrollPane scrolPaneSale = new ScrollPane();
    private Stage primaryStage = new Stage();

    void showSales(List<Store> stores) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Resources/SaleScreen.fxml"));
        salePane = fxmlLoader.load();

        Scene scene = new Scene(scrolPaneSale);
        primaryStage.setScene(scene);
        primaryStage.show();
        Label label = new Label("On Sale!");

        // add label to vbox
        vboxSales.getChildren().add(label);

        // add buttons to VBox
        for (Store store: stores)
        {
            for (Discount dis:store.Sales) {
                sales.add(new Button(dis.Name));
                vboxSales.getChildren().add(new Button(dis.Name));

            }
        }
        salePane.getChildren().add(vboxSales);

    }
}
