package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Representative> representatives = new ArrayList<>();

        Admin a1 = new Admin("gosho", "haha");
        Representative r1 = new Representative("pesho", "haha");
        try {
            a1.addProduct(products);
        } catch (NegativePriceException e) {
            System.out.println(e.getMessage());
        }
        //a1.addProduct(products);
        representatives.add(r1);
        try {
            a1.removeProduct(products, "id3");
        } catch (IdNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // r1.sell("id1", 5, products, "Pesho");
        //r1.sell("id1", 1, products, "Gosho");
        //r1.sell("id2", 4, products, "Ivan");
        //r1.sell("id2", 2, products, "Dragan");
        for (Product p1: products
             ) {
            System.out.println(p1.getName() + "-" + p1.getId());
        }
        a1.getReportByDate(representatives);

    }

   // public void saveToFile()
    //{
        //Save
    //}
}
