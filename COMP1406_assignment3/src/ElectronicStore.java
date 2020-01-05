//Class representing an electronic store
//Has an array of products that represent the items the store can sell
import javafx.collections.FXCollections;

import java.util.*;

public class ElectronicStore{
    public final int MAX_PRODUCTS = 10; //Maximum number of products the store can have
    private int curProducts;
    String name;
    Product[] stock; //Array to hold all products
    double revenue;
    Map<Product, Integer> cartProduct;
    double totPrice;
    int Sales;
    double avgRev;
    List<Product> currentCartItem;
    double rev ;
    double sum;

    public ElectronicStore(String initName){
        revenue = 0.0;
        name = initName;
        stock = new Product[MAX_PRODUCTS];
        curProducts = 0;
        cartProduct = new HashMap<>();
        totPrice = 0.0;
        Sales = 0;
        avgRev = 0;
        currentCartItem = new ArrayList<>();
        rev = 0;
        sum = 0;
    }


    public String getName(){
        return name;
    }

    //Adds a product and returns true if there is space in the array
    //Returns false otherwise
    public boolean addProduct(Product newProduct){
        if(curProducts < MAX_PRODUCTS){
            stock[curProducts] = newProduct;
            curProducts++;
            return true;
        }
        return false;
    }



    public void sellProducts(int index, int amount){
        if(index >= 0 && index < curProducts){
            revenue += stock[index].sellUnits(amount);
        }
    }




    //Prints the stock of the store
    public void printStock(){
        for(int i = 0; i < curProducts; i++){
            System.out.println(i + ". " + stock[i] + " (" + stock[i].getQuantity() + " in stock, " + stock[i].getPrice() + " dollars each)");
        }
    }





    public static ElectronicStore createStore(){
        ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
        Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
        Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
        Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
        Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
        Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", 15.5, false);
        Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", 23, true);
        ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", 8, false);
        ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", 12, true);
        store1.addProduct(d1);
        store1.addProduct(d2);
        store1.addProduct(l1);
        store1.addProduct(l2);
        store1.addProduct(f1);
        store1.addProduct(f2);
        store1.addProduct(t1);
        store1.addProduct(t2);
        return store1;
    }


    //Method to place item in Cart
    public int placeCart(Product item) {

        Integer obj = cartProduct.get(item);

        if (obj == null || obj == 0) {
            cartProduct.put(item, 1);
            currentCartItem.add(item);
            return 0;
        }
        else if (obj >= item.getQuantity()) {
            return 1;
        }
        else {
            cartProduct.put(item,obj+1);
            currentCartItem.add(item);
            return 0;
        }
    }






    public String leaveCart(Product item) {

        Integer obj = cartProduct.get(item);

        if (obj > 0) {
            cartProduct.put(item,obj-1);
            currentCartItem.remove(item);
            return "m";
        }
        else if (obj == 1) {
            cartProduct.remove(item);
            currentCartItem.remove(item);
            return "mm"; //product remove
        }

        return "success";


    }

    public double finish() {
        double rev = 0;
        for (Product item : currentCartItem) {

            rev+=item.sellUnits(1);
        }
        getRid();
        return rev;
    }

    public void getRid() {

        currentCartItem = new ArrayList<>();
        cartProduct = new HashMap<>();
    }


    public void reset(){
        revenue = 0;
        Sales = 0;
        avgRev = 0;
    }

    
    public double Total() {
        double sum=0;
        for (Product item : currentCartItem) {

            sum += item.getPrice();
        }
        return sum;
    }


} 