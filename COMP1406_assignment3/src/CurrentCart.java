
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;

public class CurrentCart extends Pane {
    Label cCart;
    ListView<Product> product;

    public CurrentCart (ElectronicStore model) {

        Pane bPane = new Pane();


        cCart = new Label("Current Cart ($" + model.Total() + ")");
        cCart.setStyle("-fx-translate-y: -15; \n" + "-fx-translate-x: 15;");
        product = new ListView<>();
        ObservableList<Product> prod = FXCollections.observableArrayList(model.currentCartItem);
        product.setItems(prod);
        product.relocate(10, 10);
        product.setPrefSize(230, 300);



        product.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if( product.getSelectionModel().getSelectedItem() != null){
                    getParent().getChildrenUnmodifiable().get(5).setDisable(false);
                }

            }
        });





        bPane.getChildren().add(product);
        getChildren().addAll(bPane, cCart);



    }
}