package StringBuilder_;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringBuilderProject01 {
    public static void main(String args[]) {
        /*
        Project Description:
        1. Use prompt to input a product with its name and price.
        2. Print the product info in the format of "productName  productPrice".
        3. The productPrice is in for format of 123,456.78
         */
        /*
        My Design:
        1. create a class of product with field of name and price.
        2. create a method to format the price to meet the requirement.
        3. Taking care of the prompt for input and the output.
         */
        //Code go here ~
        String moreProduct = "N";
        //ArrayList productList = new ArrayList<Product>();
        //List<Product> productList = new ArrayList<Product>();
        ArrayList<Product> productList = new ArrayList<Product>();
        do {
            Scanner myScanner = new Scanner(System.in);
            System.out.println("===Please input the product name===");
            String pName = myScanner.next();
            System.out.println("===Please input the product price===");
            String pPrice = myScanner.next();
            Product inputProduct = new Product(pName, pPrice);
            productList.add(inputProduct);
            System.out.println("Do you have more products to input? Y/N ?");
            moreProduct = myScanner.next();
        }while(moreProduct.equals("Y"));

        System.out.println("===Product Information Table===");
        System.out.println(" ");
        System.out.print("\t" + "Product Name" );
        System.out.print("\t" + "Product Price" +"\n" );

        //Product cellphone = new Product(pName, pPrice);
        //for (int i = 0; i < productList.size(); i++) {
        //for (Object obj: productList) {
        for (Product currentProduct: productList) {
            //Product currentProduct = (Product)obj;
            //Product currentProduct = (Product) productList.get(i);
            String productName = currentProduct.getName();
            String productPrice = currentProduct.getPrice();
            StringBuilder formattedPrice= currentProduct.formatPrice(productPrice);
            System.out.print("\t" + productName);
            System.out.println("\t" + "\t" + "\t" + formattedPrice);
            //System.out.println(productName + " " + formattedPrice);
        }
        System.out.println("================================");
    }
}

//1. create a class of product with field of name and price.
class Product {
    private String name;
    private String price;

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    //2.create a method to format the price to meet the requirement.
    //Q: static or non-static method? go with non-static first.
    public StringBuilder formatPrice(String price) {
        StringBuilder sbPrice = new StringBuilder(price);
        //Use example price 123,456.78 as example
        //A. find the ".".
        int indexOfDecimalPoint = sbPrice.indexOf(".");
        //B. start from ".", move to left, insert a "," for every 3 digit.
        for (int i = indexOfDecimalPoint - 3; i > 0; i -= 3)
            sbPrice.insert(i, ",");
        return sbPrice;
    }
}
