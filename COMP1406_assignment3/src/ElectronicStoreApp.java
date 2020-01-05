import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElectronicStoreApp extends Application {

    ElectronicStore model;

    StoreSummary summary;
    StoreStock stock;
    CurrentCart cart;
    MostPopular popular;
    ListView<Product> LVcart, LVstore;

    Button cSale, addCart, rStore, removeCart;
    Product index;
    Label tCart;





    public void start(Stage primaryStage) {
            model = ElectronicStore.createStore();
            Pane pane = new Pane();






            //Reset Store button
            rStore = new Button("Reset Store");
            rStore.relocate(29, 335);
            rStore.setPrefSize(143, 53);


            // Add to Cart Button
            addCart = new Button("Add to Cart");
            addCart.relocate(300,340);
            addCart.setPrefSize(120, 50);
            addCart.setDisable(true);

            //Remove from Cart button
            removeCart = new Button("Remove from Cart");
            removeCart.relocate(490, 335);
            removeCart.setPrefSize(143, 53);
            removeCart.setDisable(true);




            //Complete Sale button
            cSale = new Button("Complete Sale");
            cSale.relocate(633, 335);
            cSale.setPrefSize(143, 53);
            cSale.setDisable(true);


            //Most Popular
            popular = new MostPopular(model);
            popular.relocate(10, 150);

            //Summary
            summary = new StoreSummary(model);
            summary.relocate(10, 20);


            //Stock
            stock = new StoreStock(model);
            stock.relocate(230, 20);


            cart = new CurrentCart(model);
            cart.relocate(520, 20);



            LVstore = (ListView<Product>) ((Pane) stock.getChildren().get(0)).getChildren().get(0);
            LVcart = (ListView<Product>) ((Pane) cart.getChildren().get(0)).getChildren().get(0);
            tCart = ((Label) cart.getChildrenUnmodifiable().get(1));




        //event handling for adding cart
            addCart.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent actionEvent) {
                    index = LVstore.getSelectionModel().getSelectedItem();
                    int carts = model.placeCart(index);


                    if (carts == 0 ) {
                        LVcart.getItems().add(index);
                        tCart.setText("Current Cart ($" + model.Total() + "): " );
                         cSale = (Button) pane.getChildrenUnmodifiable().get(6);
                        cSale.setDisable(false);

                    } else {
                        LVstore.getItems().remove(index);
                    }

                }
            });
        //event handling for removing cart
            removeCart.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent actionEvent) {
                    cSale = (Button) pane.getChildrenUnmodifiable().get(6);
                    handleRemoveButton();

                }
            });
        //event handling for completing Sale
            cSale.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent actionEvent) {
                   handleCompleteButton();
                    //Array of Integers

                }
            });
            //event handling for restore store
            rStore.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent actionEvent) {
                    LVstore.getItems().clear();

                    LVcart.getItems().clear();
                    model.reset();
                    model.getRid();

                    for (Product product : model.stock) {
                        if (product != null) {
                            LVstore.getItems().add(product);
                        }
                    }
                    handleRestoreButton();

                }
            });

        //add pane and buttons to pane
        pane.getChildren().add(popular);
        pane.getChildren().add(summary);
        pane.getChildren().add(stock);
        pane.getChildren().add(cart);

        pane.getChildren().add(addCart);
        pane.getChildren().add(removeCart);
        pane.getChildren().add(cSale);
        pane.getChildren().add(rStore);



            // Set title ands scene
            primaryStage.setTitle(model.getName());
            primaryStage.setScene(new Scene(pane, 800, 400));
            primaryStage.setResizable(false);
            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);

            }


    public void handleCompleteButton(){

        model.Sales += 1;
        model.revenue += model.finish();
        model.avgRev = model.revenue / model.Sales;

        ((TextField)((Pane) summary.getChildrenUnmodifiable().get(0)).getChildren().get(1)).setText(String.valueOf(model.Sales));
        ((TextField)((Pane) summary.getChildrenUnmodifiable().get(0)).getChildren().get(3)).setText(String.valueOf(model.revenue));
        ((TextField)((Pane) summary.getChildrenUnmodifiable().get(0)).getChildren().get(5)).setText(String.valueOf(model.avgRev));

        tCart.setText("Current Cart ($" + model.Total() + "):");
        LVcart.getItems().clear();
        cSale.setDisable(true);
        cSale.setDisable(true);


    }

    public void handleRestoreButton(){

        ((TextField)((Pane) summary.getChildrenUnmodifiable().get(0)).getChildren().get(1)).setText(String.valueOf(model.Sales));
        ((TextField)((Pane) summary.getChildrenUnmodifiable().get(0)).getChildren().get(3)).setText(String.valueOf(model.revenue));
        ((TextField)((Pane) summary.getChildrenUnmodifiable().get(0)).getChildren().get(5)).setText("N/A");

        addCart.setDisable(true);
        removeCart.setDisable(true);
        cSale.setDisable(true);

    }


    public void handleRemoveButton(){
        index = LVcart.getSelectionModel().getSelectedItem();

        String carts = model.leaveCart(index);



        if (!carts.equals("success")) {
            LVcart.getItems().remove(index);
            tCart.setText("Current Cart ($" + model + "):");
        }

        if (LVcart.getChildrenUnmodifiable().isEmpty()) {
            cSale.setDisable(false);
        }

    }

    }











































