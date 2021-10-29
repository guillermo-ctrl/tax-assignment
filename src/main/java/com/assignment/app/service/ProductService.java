package com.assignment.app.service;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductService {


    private String importCheck(String line) {
        if(line.contains("imported")) {
            return " imported ";
        }
        return "";
    }

    private String extractProductName(String line) {
        return line
                .replaceAll("\\d","") // Remove digits
                .replace(" at ", "") // Remove "at"
                .replace(" imported ", "") // Remove "imported"
                .replace(".", ""); // Remove the dot
    }

    private double extractProductPrice(String line) {
        String priceString = line.substring(line.indexOf("at ")+3, line.length());
        return new Double(priceString);
    }

    private boolean checkIfTaxesApply(String productName) {
        String name = productName.toLowerCase().trim();
        if (name.contains("perfume") || name.contains("music")) {
            return true;
        }
        return false;
    }

    private String changeProductInputFormat(String line) {

        char numberOfProducts = line.charAt(0);
        String productName = extractProductName(line);
        String imported = importCheck(line);
        double price = extractProductPrice(line);

        if (imported.length() > 0) {
            if (checkIfTaxesApply(productName)) {
                double tax = price * 0.15;
                tax = Math.round(tax * 20) / 20.0;
                price += tax;

            }

            else {
                double tax = price * 0.05;
                tax = Math.ceil(tax * 20) / 20.0;
                price += tax;

            }
        }
        else if (checkIfTaxesApply(productName)) {

            price += price * 0.10;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");



        return "> " + numberOfProducts + imported + productName + ": " + decimalFormat.format(price).replaceAll(",",".") + "\n";
    }

    public String checkout(ArrayList<String> productList) {

        if (productList.isEmpty()) {
            return "You need to add at least a product";
        }

        StringBuilder outputString = new StringBuilder();
        double totalPrice = 0;
        double salesTaxes = 0;

        for (String product : productList) {
           outputString.append(changeProductInputFormat(product));
           totalPrice += extractProductPrice(product);

           if (checkIfTaxesApply(extractProductName(product))) {
               double taxAmount = extractProductPrice(product)*0.10;
               salesTaxes += taxAmount;

           }
            if(importCheck(product).length() > 0) {
                salesTaxes += extractProductPrice(product)*0.05;

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