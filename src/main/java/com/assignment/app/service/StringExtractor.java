package com.assignment.app.service;

public class StringExtractor {

    public String name(String line) {
        return line
                .replaceAll("\\d","") // Remove digits
                .replace(" at ", "") // Remove "at"
                .replace(" imported ", "") // Remove "imported"
                .replace(".", ""); // Remove the dot
    }

    public double price(String line) {
        String priceString = line.substring(line.indexOf("at ")+3, line.length());
        return new Double(priceString);
    }
}
