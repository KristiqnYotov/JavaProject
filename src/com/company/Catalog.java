package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Catalog {
    private String clientName;
    private String productId;
    private String productName;
    private double profitFromSale;
    private Date date = new Date();

    public String getClientName() {
        return clientName;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProfitFromSale() {
        return profitFromSale;
    }

    public void setProfitFromSale(double profitFromSale) {
        this.profitFromSale = profitFromSale;
    }
}
