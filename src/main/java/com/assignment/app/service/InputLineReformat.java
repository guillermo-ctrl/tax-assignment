package com.assignment.app.service;

import java.text.DecimalFormat;

public class InputLineReformat {

    ProductCheck productCheck = new ProductCheck();
    StringExtractor stringExtractor = new StringExtractor();

    public String toOutput (String line) {

        char numberOfProducts = line.charAt(0);
        String productName = stringExtractor.name(line);
        String imported = productCheck.imported(line);
        double price = stringExtractor.price(line);

        if (imported.length() > 0) {
            if (productCheck.tax(productName)) {
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

        else if (productCheck.tax(productName)) {
            price += price * 0.10;
        }

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return "> " + numberOfProducts + imported + productName + ": " + decimalFormat.format(price).replaceAll(",",".") + "\n";
    }

}
