package com.assignment.app.service;

import com.assignment.app.repo.ProductRepo;

import java.util.ArrayList;

public class ProductService {

    ProductRepo productRepo = new ProductRepo();

    private String extractImportedStatus(String line) {
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

    private String turnProductInputToOutput (String line) {

        char numberOfProducts = line.charAt(0);
        String productName = extractProductName(line);
        double price = productRepo.getProductPrice(productName);
        String imported = extractImportedStatus(line);

        return "> " + numberOfProducts + imported + productName + ": " + price + "\n";
    }

    public String checkout(ArrayList<String> productList) {

        if (productList.isEmpty()) {
            return "You need to add a product";
        }

        StringBuilder outputString = new StringBuilder();
        double totalPrice = 0;
        double salesTaxes = 0;

        for (String product : productList) {
           outputString.append(turnProductInputToOutput(product));
           totalPrice += productRepo.getProductPrice(extractProductName(product));
           if(extractImportedStatus(product).length() > 0) {
               double taxAmount = productRepo.getProductPrice(extractProductName(product))/100*5;
               salesTaxes += taxAmount;
               totalPrice += taxAmount;
           }

        }

        outputString
                .append("> Sales Taxes: ")
                .append(salesTaxes)
                .append("\n")
                .append("> Total: ")
                .append(totalPrice)
                .append("\n");


        return outputString.toString();
    }

    public boolean checkIfExists(String selection) {
        return productRepo.checkIfProductExists(selection);
    }
}