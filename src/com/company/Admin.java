package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Admin extends User{

    private Object NegativePriceException;

    public Admin(String nickname, String password){
        super(nickname, password);
    }

    public void addProduct(ArrayList arrList) throws NegativePriceException
    {
        Product p1 = new Product();
        Scanner scanner = new Scanner(System.in);
        Product product1 = new Product();
        System.out.println("Input product id");
        p1.setId(scanner.nextLine());
        System.out.println("Input product name");
        p1.setName(scanner.nextLine());
        System.out.println("Input product price");
        double price = scanner.nextDouble();
        if(price<0.0)
        {
                throw new NegativePriceException("Price cant be negative");
        }
        p1.setPrice(price);

        System.out.println("Input product quantity");
        p1.setQuantity(scanner.nextInt());
        arrList.add(p1);
    }

    public void removeProduct(ArrayList<Product> arrList, String idToRemove) throws IdNotFoundException
    {
        boolean bool =false;
        for(Product p : arrList)
        {
            if(p.getId().equals(idToRemove))
            {
                arrList.remove(p);
                bool=true;
            }
        }
        throw new IdNotFoundException("Id Not found");
    }

    public void editProduct(ArrayList<Product> arrList, String idToEdit)
    {
        int index =0;
        for(Product p: arrList)
        {
            if(p.getId().equals(idToEdit))
            {
                String command ="";
                Scanner scanner = new Scanner(System.in);
                System.out.println("What do you want to edit?");
                command = scanner.nextLine();
                while(!command.equals("end"))
                {
                    if(command.equals("id"))
                    {
                        System.out.println("Input new id");
                        p.setId(scanner.nextLine());
                    }
                    else if(command.equals("name"))
                    {
                        System.out.println("Input new name");
                        p.setName(scanner.nextLine());
                    }
                    else if(command.equals("price"))
                    {
                        System.out.println("Input new price");
                        p.setPrice(scanner.nextDouble());
                    }
                    command = scanner.nextLine();
                }
                arrList.set(index, p);
            }
            index++;
        }
    }

    public void getReport(Representative r1)
    {
        r1.printCatalog();
    }
    public void getReportByDate(ArrayList<Representative> arrList)
    {
        double wholePeriodProfit =0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Date firstDate = new Date();
        Date secondDate = new Date();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the first date?");
        String dateString;
        dateString = scanner.nextLine();
        try {
            firstDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid");
        }
        System.out.println("What is the second date?");
        dateString = scanner.nextLine();
        try {
            secondDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid");
        }


        for (Representative r1: arrList
             ) {
            for (Catalog c1: r1.getCatalog()
                 ) {
                if(c1.getDate().after(firstDate) && c1.getDate().before(secondDate))
                {
                    System.out.println("Client name: " + c1.getClientName());
                    System.out.println("Product id: " + c1.getProductId());
                    System.out.println("Product name: " + c1.getProductName());
                    System.out.println("Profit: " + c1.getProfitFromSale());
                    wholePeriodProfit+=c1.getProfitFromSale();
                }
            }
        }

        System.out.println("Total profit from " + firstDate + " to " + secondDate +" is: " + wholePeriodProfit);
    }
}
