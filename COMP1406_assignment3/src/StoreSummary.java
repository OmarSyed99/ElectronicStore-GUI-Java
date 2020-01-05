
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;

public class StoreSummary extends Pane{
    Label nSale, revenue, dSale, sSum;
    TextField nSalesField, revField,dSaleField;
    public StoreSummary(ElectronicStore model){

        Pane cPane = new Pane();

        //Store Summary Label
        sSum = new Label();
        sSum.setText("Store Summary:");
        sSum.setStyle("-fx-translate-y: -15; \n" + "-fx-translate-x: 15;");

        //Labels and Textfield
        nSale=new Label("# Sales: ");
        nSale.relocate(10,20);
        nSale.setPrefSize(70,20);
        nSalesField = new TextField("0");
        nSalesField.relocate(80,20);
        nSalesField.setPrefSize(100,27);


        //Revenue Label and Texrfield
        revenue=new Label("Revenue: ");
        revenue.relocate(10,50);
        revenue.setPrefSize(70,20);
        revField=new TextField("0.0");
        revField.relocate(80,50);
        revField.setPrefSize(100,27);

        dSale=new Label("$ / Sale: ");
        dSale.relocate(10,80);
        dSale.setPrefSize(70,20);
        dSaleField=new TextField("N/A");
        dSaleField.relocate(80,80);
        dSaleField.setPrefSize(100,27);



        cPane.getChildren().addAll(nSale,nSalesField,revenue,revField,dSale,dSaleField);
        getChildren().addAll(cPane, sSum);

    }
}
