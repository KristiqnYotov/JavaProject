package com.company;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Representative extends User{

    public Representative(String nickname, String password){
        super(nickname, password);
    }

    public ArrayList<Catalog> getCatalog() {
        return catalog;
    }

    private ArrayList<Catalog> catalog = new ArrayList<>();

    public void printCatalog() {
        int numberOfSales = 1;
        int totalProfit = 0;
        System.out.println("Information for: " + this.nickName);
        for (Catalog c1: catalog
             ) {
            System.out.println("Sale number" + numberOfSales + ":");
            System.out.println("Client name: " + c1.getClientName());
            System.out.println("Product id: " + c1.getProductId());
            System.out.println("Product name: " + c1.getProductName());
            System.out.println("Profit: " + c1.getProfitFromSale());
            System.out.println("Date: " + c1.getDate());
            totalProfit+=c1.getProfitFromSale();
        }
        System.out.println("Total profit :" + totalProfit);
    }

    private double profit = 0.0;

    public void sell(String idToSell, int quantityToSell, ArrayList<Product> arrList, String clientName)
    {
        for(Product p: arrList)
        {
            if(p.getId().equals(idToSell))
            {
                if(p.getQuantity()-quantityToSell>0)
                {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
                    Catalog c1 = new Catalog();
                    p.decreaseQuantity();
                    profit +=p.getPrice()*quantityToSell;
                    c1.setClientName(clientName);
                    c1.setProductId(p.getId());
                    c1.setProductName(p.getName());
                    c1.setProfitFromSale(p.getPrice()*quantityToSell);
                    catalog.add(c1);
                    System.out.println("What is the date");
                    String dateString;
                    Scanner scanner = new Scanner(System.in);
                    dateString = scanner.nextLine();
                    try {
                        c1.setDate(dateFormat.parse(dateString));
                    } catch (ParseException e) {
                        System.out.println("Invalid");
                    }
                }
                else
                {
                    System.out.println("Sorry, the shop does not have enough quantity");
                }
            }
        }
    }

    public void saveCatalogToFile()
    {

    }
}
