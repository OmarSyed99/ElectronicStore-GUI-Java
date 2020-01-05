
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostPopular extends Pane {
    ListView<Product> mPopList;

    public MostPopular(ElectronicStore model) {


        //int[] product = {model.stock[0].getQuantity(),model.stock[1].getQuantity(),model.stock[2].getQuantity()};
        ListView<Product> product = new ListView<>();

        Pane dPane = new Pane();
        int[] myIntArray = new int[]{model.stock[0].getQuantity(),model.stock[1].getQuantity(),model.stock[2].getQuantity(),model.stock[3].getQuantity()
                ,model.stock[4].getQuantity(),model.stock[5].getQuantity(),model.stock[6].getQuantity(),model.stock[7].getQuantity()};


        Arrays.sort(myIntArray);


        for (int i = 0; i < myIntArray.length; i++) {
            System.out.println(myIntArray[i]);
            List<Product> temp = new ArrayList<>();
        }

        Label mPop = new Label();
        mPop.setText("Most Popular: ");
        mPop.setStyle("-fx-translate-y: -8; \n" + "-fx-translate-x: 10;");
        mPopList = new ListView<>();
        ObservableList<Product> prod = FXCollections.observableArrayList(new ArrayList<>());
        mPopList.setItems(prod);
        mPopList.relocate(15,15);
        mPopList.setPrefSize(200,165);
        dPane.getChildren().add(mPopList);

        for (int i=0; i<3; i++) {
            if (model.stock[i]!= null) { prod.add(model.stock[i]); }
        }






        getChildren().addAll(dPane, mPop);




    }
}