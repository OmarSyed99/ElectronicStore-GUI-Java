
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;


public class StoreStock extends Pane {
    Label sStock;
    ListView<Product> product;


    public StoreStock(ElectronicStore model) {

        Pane aPane = new Pane();

        //Print Store stock label for the given Pane
        sStock = new Label("Store Stock:");
        sStock.setStyle("-fx-translate-y: -15; \n" + "-fx-translate-x: 15;");
        //Creates a listview and populates items
        product = new ListView<>();
        ObservableList<Product> prod = FXCollections.observableArrayList(new ArrayList<>());
        product.setItems(prod);
        product.relocate(10, 10);
        product.setPrefSize(275, 300);




        //Sets the array with products
        for (int i=0; i<model.stock.length; i++) {
            if (model.stock[i]!= null) { prod.add(model.stock[i]); }
        }

        //When list is clicked on then it makes addCart Button to appear
        product.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (product.getSelectionModel().getSelectedItem() != null) {
                    getParent().getChildrenUnmodifiable().get(4).setDisable(false);
                }
            }
        });
        //adds the list to the pane
        aPane.getChildren().add(product);
        getChildren().addAll(aPane, sStock);

    }

}


