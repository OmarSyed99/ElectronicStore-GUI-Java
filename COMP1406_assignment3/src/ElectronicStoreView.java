/*
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ElectronicStoreView extends Pane {
    ElectronicStore model;
    ListView<String> namesList;
    ListView<Product> sStockList, cCartList;


    TextField newName, dSaleField;
    Button addCart;
    Button removeCart;
    Button cSale;


    public ElectronicStoreView(ElectronicStore aModel) {
        model = aModel;
        // Add the list

        // Create the labels and textfields
        //Store Stock Label
        Label sStock = new Label("Store Stock:");
        sStock.relocate(314, 20);
        sStock.setPrefSize(100, 27);
        getChildren().add(sStock);


        //Current Cart Label
        Label cCart = new Label("Current Cart ($" + model.totPrice + ")");
        cCart.relocate(571, 20);
        cCart.setPrefSize(100, 27);
        getChildren().add(cCart);


        //Most Popular item Label
        Label mPop = new Label("Most Popular Items:");
        mPop.relocate(57, 147);
        mPop.setPrefSize(200, 27);
        getChildren().add(mPop);


        //Creating #sales Label and Textfield
        //Label
        Label nSales = new Label("# Sales:");
        nSales.relocate(32, 53);
        nSales.setPrefSize(100, 27);
        getChildren().add(nSales);


        //Creating revenue Label and Textfield
        //Label
        Label revenue = new Label("Revenue:");
        revenue.relocate(24, 85);
        revenue.setPrefSize(100, 27);
        getChildren().add(revenue);


        //Creating $/sale Label and Textfield
        //Label
        Label dSale = new Label("$/Sale:");
        dSale.relocate(38, 117);
        dSale.setPrefSize(100, 27);
        getChildren().add(dSale);

        //Textfield
        TextField nSalesField = new TextField();
        nSalesField.relocate(80, 53);
        nSalesField.setPrefSize(100, 27);
        nSalesField.setEditable(false);
        nSalesField.setText(String.valueOf(model.Sales));
        getChildren().addAll(nSalesField);

        //Textfield
        TextField revenueField = new TextField();
        revenueField.relocate(80, 85);
        revenueField.setPrefSize(100, 27);
        revenueField.setEditable(false);
        revenueField.setText(String.valueOf(model.revenue));
        getChildren().addAll(revenueField);

        //Textfield
        dSaleField = new TextField();
        dSaleField.relocate(80, 117);
        dSaleField.setPrefSize(100, 27);
        dSaleField.setEditable(false);
        nSalesField.setText(String.valueOf(model.avgRev));
        getChildren().addAll(dSaleField);


        //Store Stock listview
        ListView<Product> sStockList = new ListView<Product>();
        //ObservableList<Product> list = FXCollections.observableArrayList(model.stock);
        //updateStockList();
        //sStockList.setItems(list);
        sStockList.relocate(194, 53);
        sStockList.setPrefSize(286, 277);
        getChildren().add(sStockList);
        updateStockList(sStockList);

        //Current Cart listview
        ListView<Product> cCartList = new ListView<Product>();
        cCartList.relocate(490, 53);
        cCartList.setPrefSize(286, 277);
        getChildren().add(cCartList);
        updateCurrentList(cCartList);


        //Most Popular listview
        ListView<Product> mPopList = new ListView<Product>();
        Product[] mPopItem = {aModel.stock[0], aModel.stock[1], aModel.stock[2]};

        ObservableList<Product> mPopItemList = FXCollections.observableArrayList(mPopItem);
        mPopList.setItems(mPopItemList);
        mPopList.relocate(14, 170);
        mPopList.setPrefSize(171, 160);
        getChildren().add(mPopList);


        //Reset Store button
        Button rStore = new Button("Reset Store");
        rStore.relocate(29, 335);
        rStore.setPrefSize(143, 53);
        getChildren().add(rStore);

        //Add to Cart button
        addCart = new Button("Add to Cart");
        addCart.relocate(257, 335);
        addCart.setPrefSize(143, 53);
        addCart.setDisable(false);
       // getChildren().add(addCart);

        //Remove from Cart button
        removeCart = new Button("Remove from Cart");
        removeCart.relocate(490, 335);
        removeCart.setPrefSize(143, 53);
        removeCart.setDisable(true);
        getChildren().add(removeCart);

        //Complete Sale button
        cSale = new Button("Complete Sale");
        cSale.relocate(633, 335);
        cSale.setPrefSize(143, 53);
        cSale.setDisable(true);
        getChildren().add(cSale);



        */
/*save = new Button("Save Changes");
        save.relocate(440, 435);
        save.setPrefSize(140, 25);
        getChildren().add(save);
        update();*//*


    }

    public ListView<Product> getsStockList(){return sStockList;};

    public void updateStockList(ListView<Product> sStockList) {
         Product[] stock = model.getItems();
        //ObservableList<Product> list = FXCollections.observableArrayList(stock);
        sStockList.setItems(FXCollections.observableArrayList(stock));
    }

    public void updateCurrentList(ListView<Product> cCartList){
        Product[] CurrentStock = {};
        ObservableList<Product> list1 = FXCollections.observableArrayList(CurrentStock);
        cCartList.setItems(list1);

    }


}*/
