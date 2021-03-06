package Controllers;

import Models.SDMResultObject;
import Models.SuperDuperMarket;
import UIUtils.CommonUsed;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.*;

public class MainController { @FXML
private Text userName;
    @FXML private Button changeUserButton;
    @FXML private Text currentBranch;
    @FXML private Button newBranchButton;
    @FXML private Button resetBranchButton;
    @FXML private Label sdmHeader;
    @FXML private Button changeRepoButton;
    @FXML private Button loadRepoButton;
    @FXML private Button createNewRepoButton;
    @FXML private Text currentRepo;
    @FXML private Text pathRepo;
    @FXML private Button changeLayoutButton;
    @FXML private HBox layoutHbox;
    @FXML private Button pinkButton;
    @FXML private Button blueButton;
    @FXML private Button greenButton;
    @FXML private SplitPane mainSplitPane;
    @FXML private Label magitLargeHeader;
    @FXML private ComboBox<String> branchesOptionsComboBox;
    @FXML private Button checkoutButton;
    @FXML private Button deleteBranchButton;
    @FXML private Pane textPane;
    @FXML private Pane showStatusPane;
    @FXML private AnchorPane treeAnchorPane;
    @FXML private Text commitTreeHeader;
    @FXML private Button showStatusButton;
    @FXML private Button commitButton;
    @FXML private Button pushButton;
    @FXML private Button pullButton;
    @FXML private Button mergeButton;
    @FXML private Button cloneButton;
    @FXML private Button fetchButton;
    @FXML private Button showCommitData;
    @FXML private Text wcStatusHeader;

    //  =========================== Controllers ==================================
    private ShowMarketsController marketController = new ShowMarketsController();
    private ShowItemsController itemController = new ShowItemsController();
    private PlaceOrderController placeOrderController = new PlaceOrderController();
    private MapController mapController = new MapController();


    //  =========================== Scene Builder ================================
    private ScrollPane scrollPane = new ScrollPane();
    //private PannableCanvas canvas;

    //  ================================ Utils ===================================
    //private Graph commitTreeGraph = new Graph();
    private SuperDuperMarket superDuperMarket = new SuperDuperMarket();
    private String remoteRepoPath;
    private Scene scene;
    private Stage primaryStage;
    private String style;
    private String secondBranchCommitSha1 = null;
    private boolean isShowStatusOpen = false;
    private boolean isGreenButtonPressed = false;
    private boolean isBlueButtonPressed = true;
    private boolean isPinkButtonPressed = false;


//  ============================= Util Functions ===============================

    @FXML
    void showMarkets() {
        marketController.showMarkets(superDuperMarket, textPane);
    }

    @FXML
    void showItems() {
        itemController.showItems(superDuperMarket, textPane);
    }

    @FXML
    void showLayoutButtons(ActionEvent event) {
        layoutHbox.setVisible(true);
    }

    @FXML
    void changeStyleToBlue(ActionEvent event) {
        //primaryStage.getScene().getStylesheets().clear();
        //primaryStage.getScene().getStylesheets().add(getClass().getResource("/Css/Style1.css").toExternalForm());
        //if(canvas != null) {
        //    canvas.setBackground(Background.EMPTY);
        //    style = "-fx-background-color: #3B5998";
        //    canvas.setStyle(style);
        //    scrollPane.setContent(canvas);
        //    treeAnchorPane.getChildren().clear();
        //    treeAnchorPane.getChildren().add(scrollPane);
        //    setTreeBoundaries();
        //    primaryStage.getScene().getStylesheets().add(getClass().getResource("/Css/CommitNode.css").toExternalForm());
        //}
//
        //isBlueButtonPressed = true;
        //isGreenButtonPressed = false;
        //isPinkButtonPressed = false;
    }

    @FXML
    void changeStyleToGreen(ActionEvent event) {
        //primaryStage.getScene().getStylesheets().clear();
        //primaryStage.getScene().getStylesheets().add(getClass().getResource("/Css/Style 2.css").toExternalForm());
        //if(canvas != null) {
        //    canvas.setBackground(Background.EMPTY);
        //    style = "-fx-background-color: #405d27";
        //    canvas.setStyle(style);
        //    scrollPane.setContent(canvas);
        //    treeAnchorPane.getChildren().clear();
        //    treeAnchorPane.getChildren().add(scrollPane);
        //    setTreeBoundaries();
        //    primaryStage.getScene().getStylesheets().add(getClass().getResource("/Css/CommitNode2.css").toExternalForm());
        //}
        //isGreenButtonPressed = true;
        //isBlueButtonPressed = false;
        //isPinkButtonPressed = false;
    }

    @FXML
    void changeStyleToPink(ActionEvent event) {
        //primaryStage.getScene().getStylesheets().clear();
        //primaryStage.getScene().getStylesheets().add(getClass().getResource("/Css/Style 3.css").toExternalForm());
        //if(canvas != null) {
        //    canvas.setBackground(Background.EMPTY);
        //    style = "-fx-background-color: #622569";
        //    canvas.setStyle(style);
        //    scrollPane.setContent(canvas);
        //    treeAnchorPane.getChildren().clear();
        //    treeAnchorPane.getChildren().add(scrollPane);
        //    setTreeBoundaries();
        //    primaryStage.getScene().getStylesheets().add(getClass().getResource("/Css/CommitNode3.css").toExternalForm());
        //}
//
        //isPinkButtonPressed = true;
        //isGreenButtonPressed = false;
        //isBlueButtonPressed = false;
    }

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public void setScene(Scene scene){
        this.scene = scene;
    }

    public void initialize() {
        //layoutHbox.setVisible(false);

        //currentRepo.wrappingWidthProperty().set(120);
        //userName.wrappingWidthProperty().set(70);
        //currentBranch.wrappingWidthProperty().set(50);

        //userName.textProperty().bind(myMagit.getUserName());
        //currentRepo.textProperty().bind(myMagit.getRepoName());
        //currentBranch.textProperty().bind(myMagit.getCurrentBranch());

        //treeAnchorPane.prefWidthProperty().bind(mainSplitPane.widthProperty());

        //newBranchButton.setDisable(true);
        //resetBranchButton.setDisable(true);
        //commitButton.setDisable(true);
        //showStatusButton.setDisable(true);
        //pushButton.setDisable(true);
        //pullButton.setDisable(true);
        //mergeButton.setDisable(true);
        //cloneButton.setDisable(true);
        //fetchButton.setDisable(true);
        //branchesOptionsComboBox.setDisable(true);
        //checkoutButton.setDisable(true);
        //deleteBranchButton.setDisable(true);
        //showCommitData.setDisable(true);
        //branchesOptionsComboBox.setOnAction(e -> {
        //    deleteBranchButton.setDisable(false);
        //    checkoutButton.setDisable(false);
        //});
    }

    private void setRepoActionsAvailable(){
        showStatusButton.setDisable(false);
        branchesOptionsComboBox.setDisable(false);
        newBranchButton.setDisable(false);
        resetBranchButton.setDisable(false);
        commitButton.setDisable(false);
        //branchesOptionsComboBox.setItems(myMagit.getCurrentBranchesNames());
        mergeButton.setDisable(false);
        cloneButton.setDisable(false);
        showCommitData.setDisable(false);
        fetchButton.setDisable(false);
        pullButton.setDisable(false);
        pushButton.setDisable(false);
    }

    //  ============================= Repo Functions ===============================
    @FXML
    void updateMagitUser() {
        Optional<String> res = CommonUsed.showDialog("Change user name", "Enter your name:",
                "Name:");
        //res.ifPresent(name-> myMagit.setUserName(name));
    }
    @FXML
    void showMaps() {
        mapController.ShowStoresAndOrdersOnMap(superDuperMarket, textPane);
    }
    @FXML
    void placeOrder() {
        placeOrderController.placeOrder(superDuperMarket, textPane);
    }

    @FXML
    void createNewRepository() {
        //DirectoryChooser directoryChooser = new DirectoryChooser();
        //directoryChooser.setTitle("Create new repository!");
//
        //File selectFile = directoryChooser.showDialog(primaryStage);
        //if (selectFile == null) {
        //    return;
        //}
//
        //MagitStringResultObject res = myMagit.createNewRepo(selectFile.getAbsolutePath(), "just a custom repo");
        //if(isShowStatusOpen){
        //    showStatusPane.getChildren().clear();
        //    isShowStatusOpen = false;
        //}
        //if (!res.getIsHasError()) {
        //    CommonUsed.showSuccess(res.getData());
        //    setRepoActionsAvailable();
        //    currentBranch.textProperty().unbind();
        //    currentBranch.textProperty().bind(myMagit.getCurrentBranch());
        //}
        //else {
        //    CommonUsed.showError(res.getErrorMSG());
        //}
    }

    @FXML
    void loadSDMData() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select XML file!");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML file", "*.xml"));

        File selectFile = fileChooser.showOpenDialog(primaryStage);
        if (selectFile == null) {
            return;
        }

        try {
            if(isShowStatusOpen){
                showStatusPane.getChildren().clear();
                isShowStatusOpen = false;
            }

            SDMResultObject res =
                    superDuperMarket.loadSDMFromXML(selectFile.getAbsolutePath());
            if (res.getIsHasError()){
                CommonUsed.showError(res.getErrorMSG());
            }
            else {
                CommonUsed.showSuccess("File loaded to system succesfully!");
            }
        }
        catch(JAXBException e){
            CommonUsed.showError(e.getMessage());
        }
    }

    @FXML
    void switchRepository() {
        //DirectoryChooser directoryChooser = new DirectoryChooser();
        //directoryChooser.setTitle("Select repository!");
//
        //File selectFile = directoryChooser.showDialog(primaryStage);
        //if (selectFile == null) {
        //    return;
        //}
//
        //if(isShowStatusOpen){
        //    showStatusPane.getChildren().clear();
        //    isShowStatusOpen = false;
        //}
//
        //MagitStringResultObject res = myMagit.changeRepository(selectFile.getAbsolutePath());
        //if (!res.getIsHasError()) {
        //    CommonUsed.showSuccess(res.getData());
        //    setRepoActionsAvailable();
        //    currentBranch.textProperty().unbind();
        //    currentBranch.textProperty().bind(myMagit.getCurrentBranch());
        //    pathRepo.textProperty().bind(myMagit.getPath());
        //    createCommitTree();
        //}
        //else {
        //    CommonUsed.showError(res.getErrorMSG());
        //}

    }

    //  ============================ Branch Functions ==============================
    @FXML
    void deleteBranch() {
        //try {
        //    if(isShowStatusOpen){
        //        showStatusPane.getChildren().clear();
        //        isShowStatusOpen = false;
        //    }
//
        //    MagitStringResultObject res = myMagit.deleteBranch(branchesOptionsComboBox.getValue());
        //    if (!res.getIsHasError()) {
        //        CommonUsed.showSuccess(res.getData());
        //    }
        //    else {
        //        CommonUsed.showError(res.getErrorMSG());
        //    }
        //} catch (InvalidDataException e) {
        //    CommonUsed.showError(e.getMessage());
        //}
    }

    @FXML
    void resetBranchToSpecificCommit() {
        Optional<String> newCommitSha1 = CommonUsed.showDialog("Reset Head", "Enter commit SHA-1:",
                "SHA-1:");

        if(isShowStatusOpen){
            showStatusPane.getChildren().clear();
            isShowStatusOpen = false;
        }

        resetBranchToASpecificCommit(newCommitSha1, false);
    }

    private void resetBranchToASpecificCommit(Optional<String> newCommitSha1, boolean toIgnoreChanges) {
        //newCommitSha1.ifPresent(sha1-> {
        //    try {
        //        MagitStringResultObject res = myMagit.resetBranch(sha1, toIgnoreChanges);
        //        if (!res.getIsHasError()) {
        //            CommonUsed.showSuccess(res.getData());
        //            createCommitTree();
        //        }
        //        else {
        //            CommonUsed.showError(res.getErrorMSG());
        //        }
        //    } catch (DirectoryNotEmptyException e) {
        //        boolean toContinue = CommonUsed.showDilemma(e.getMessage());
        //        if(toContinue) {
        //            resetBranchToASpecificCommit(newCommitSha1, true);
        //        }
        //        else {
        //            String errorMsg = "To reset commit first!";
        //            CommonUsed.showSuccess(errorMsg);
        //        }
        //    }
//
        //});
    }

    @FXML
    void checkoutBranch() {
        if(isShowStatusOpen){
            showStatusPane.getChildren().clear();
            isShowStatusOpen = false;
        }

        checkoutABranch(false);
    }

    private void checkoutABranch(boolean toIgnoreChanges) {
        //try {
        //    MagitStringResultObject res = myMagit.checkoutBranch(branchesOptionsComboBox.getValue(), toIgnoreChanges);
        //    if (!res.getIsHasError()) {
        //        CommonUsed.showSuccess(res.getData());
        //        currentBranch.textProperty().unbind();
        //        currentBranch.textProperty().bind(myMagit.getCurrentBranch());
        //        createCommitTree();
        //    }
        //    else {
        //        CommonUsed.showError(res.getErrorMSG());
        //    }
        //} catch (DirectoryNotEmptyException e) {
        //    boolean toContinue = CommonUsed.showDilemma(e.getMessage());
        //    if(toContinue){
        //        checkoutABranch(true);
        //    }
        //    else {
        //        String errorMsg = "To checkout commit first!";
        //        CommonUsed.showSuccess(errorMsg);
        //    }
        //}
    }

    @FXML
    void createNewBranch() {
        //Optional<Pair<String, String>> newBranchName = CommonUsed.showMultipleChoiceDialog("New Branch",
        //        "Enter the following data:","Name:", "Sha1:");
        //newBranchName.ifPresent(name -> {
        //    if(!name.getValue().isEmpty()) {
        //        createBranch(false, name.getKey(),
        //                name.getValue(), false);
        //        branchesOptionsComboBox.setItems(myMagit.getCurrentBranchesNames());
//
        //    } else {
        //        createBranch(false, name.getKey(),
        //                myMagit.getBranchByName(myMagit.getCurrentBranch().getValue()).getCommitSha1(), false);
        //    }
        //});
    };

    private void createBranch(boolean isRemoteTracking, String branchName, String branchSha1, boolean toIgnoreSha1) {
        //try {
        //    if(isShowStatusOpen){
        //        showStatusPane.getChildren().clear();
        //        isShowStatusOpen = false;
        //    }
//
        //    MagitStringResultObject res = myMagit.addNewBranch(branchName, branchSha1, isRemoteTracking, toIgnoreSha1);
        //    if (!res.getIsHasError()){
        //        CommonUsed.showSuccess(res.getData());
        //    }
        //    else {
        //        CommonUsed.showError(res.getErrorMSG());
        //    }
//
        //} catch (InvalidDataException e) {
        //    CommonUsed.showError(e.getMessage());
        //    createNewBranch();
        //} catch (DataAlreadyExistsException e) {
        //    boolean isOk = CommonUsed.showConfirmation(e.getMessage());
        //    if(isOk) {
        //        String branch = myMagit.findBranchBySha1(branchSha1);
        //        if(branch != null) {
        //            createBranch(true, branch, branchSha1, true);
        //        }
        //    }
        //    else {
        //        createBranch(false, branchName, branchSha1, true);
        //    }
        //}
    }

    //  ============================ Commit Functions ==============================
    @FXML
    void createNewCommit() {
        //Optional<String> commitMessage = CommonUsed.showDialog("New Commit",
        //        "Enter a message for the commit:", "Message:");
//
        //commitMessage.ifPresent(msg -> {
        //    if(isShowStatusOpen){
        //        showStatusPane.getChildren().clear();
        //        isShowStatusOpen = false;
        //    }
//
        //    MagitStringResultObject result;
        //    if (secondBranchCommitSha1 != null) {
        //        result = myMagit.createNewCommit(msg, secondBranchCommitSha1);
        //        secondBranchCommitSha1 = null;
        //    }
        //    else {
        //        result = myMagit.createNewCommit(msg, null);
        //    }
        //    if (!result.getIsHasError()){
        //        CommonUsed.showSuccess(result.getData());
        //        if(result.getChanged()) {
        //            addCommitToTree();
        //        }
        //    }
        //    else {
        //        CommonUsed.showError(result.getErrorMSG());
        //    } });
    }



//  ======================== Collaboration Functions ===========================



}

