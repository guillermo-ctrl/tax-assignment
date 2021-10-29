package com.assignment.app.service;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductService {

    ProductCheck productCheck = new ProductCheck();
    StringExtractor stringExtractor = new StringExtractor();
    InputLineReformat inputLineReformat = new InputLineReformat();

    public String checkout(ArrayList<String> productList) {

        if (productList.isEmpty()) {
            return "You need to add at least a product";
        }

        StringBuilder outputString = new StringBuilder();
        double totalPrice = 0;
        double salesTaxes = 0;

        for (String product : productList) {
           outputString.append(inputLineReformat.toOutput(product));
           totalPrice += stringExtractor.price(product);

           if (productCheck.tax(stringExtractor.name(product))) {
               double taxAmount = stringExtractor.price(product)*0.10;
               salesTaxes += taxAmount;

           }
            if(productCheck.imported(product).length() > 0) {
                salesTaxes += stringExtractor.price(product)*0.05;

            }
        }

        DecimalFormat twoDecimals = new DecimalFormat("0.00");

        salesTaxes = Math.ceil(salesTaxes * 20) / 20.0;
        totalPrice = totalPrice + salesTaxes;
        outputString
                .append("> Sales Taxes: ")
                .append(twoDecimals.format(salesTaxes).replace(",","."))
                .append("\n")
                .append("> Total: ")
                .append(twoDecimals.format(totalPrice).replace(",","."));


        return outputString.toString();
    }

}