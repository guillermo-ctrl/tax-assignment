package com.assignment.app.service;

public class ProductCheck {

    public String imported(String line) {
        if(line.contains("imported")) {
            return " imported ";
        }
        return "";
    }

    public boolean tax(String productName) {
        String name = productName.toLowerCase().trim();
        if (name.contains("perfume") || name.contains("music")) {
            return true;
        }
        return false;
    }

}
