package com.assignment.app.controller;

import com.assignment.app.service.ProductService;
import java.util.ArrayList;

public class MainUI {

    public static void menu () {

        ProductService productService = new ProductService();
        boolean keepRunning = true;

        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {

            while (keepRunning) {
                try {
                    System.out.println("Enter a product or write checkout");
                    String selection = scanner.nextLine();
                    ArrayList <String> productList = new ArrayList();
                    switch (selection) {

                        case "checkout":
                            System.out.println(productService.checkout(productList));
                            keepRunning = false;
                        default:
                            if (productService.checkIfExists(selection)) {
                                productList.add(selection);
                            }
                            break;

                    }

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());

                }
            }
        }
    }
}