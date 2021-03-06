package com.assignment.app.service;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductService {

    ProductCheck productCheck = new ProductCheck();
    StringExtractor stringExtractor = new StringExtractor();
    InputLineReformat inputLineReformat = new InputLineReformat();
    DecimalFormat twoDecimals = new DecimalFormat("0.00");

    public String checkout(ArrayList<String> productList) {

        if (productList.isEmpty()) {
            return "You need to add at least a product";
        }

        StringBuilder outputString = new StringBuilder();
        double totalPrice = 0;
        double salesTaxes = 0;

        for (String product : productList) {
            double productPrice = stringExtractor.price(product);
            String productName = stringExtractor.name(product);
            outputString.append(inputLineReformat.toOutput(product));

            totalPrice += productPrice;

            if (productCheck.tax(productName)) {
                double taxAmount = productPrice*0.10;
                salesTaxes += taxAmount;
            }
             if(productCheck.imported(product).length() > 0) {
                 salesTaxes += productPrice*0.05;
             }
        }

        salesTaxes = Math.ceil(salesTaxes * 20) / 20.0;
        totalPrice += salesTaxes;
        outputString
                .append("> Sales Taxes: ")
                .append(twoDecimals.format(salesTaxes).replace(",","."))
                .append("\n")
                .append("> Total: ")
                .append(twoDecimals.format(totalPrice).replace(",","."));

        return outputString.toString();
    }
}