package com.assignment.app.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    ProductService productService = new ProductService();

    @Test
    public void assignmentInput1() {

        // Given
        ArrayList <String> input = new ArrayList();
        input.add("1 book");
        input.add("1 music CD");
        input.add("1 chocolate bar");

        // When
        String checkoutOutput = productService.checkout(input);

        // Then
        assertEquals("> 1 book: 12.49\n" +
                "> 1 music CD: 16.49\n" +
                "> 1 chocolate bar: 0.85\n" +
                "> Sales Taxes: 1.50\n" +
                "> Total: 29.83", checkoutOutput);
    }

    @Test
    public void assignmentInput2() {

        // Given
        ArrayList <String> input = new ArrayList();
        input.add("1 imported box of chocolates");
        input.add("1 imported bottle of perfume");

        // When
        String checkoutOutput = productService.checkout(input);

        // Then
        assertEquals("> 1 imported box of chocolates: 10.50\n" +
                "> 1 imported bottle of perfume: 54.65\n" +
                "> Sales Taxes: 7.65\n" +
                "> Total: 65.15", checkoutOutput);

    }

    @Test
    public void assignmentInput3() {

        // Given
        ArrayList <String> input = new ArrayList();
        input.add("1 imported bottle of perfume");
        input.add("1 bottle of perfume");
        input.add("1 packet of headache pills");
        input.add("1 imported box of chocolates");

        // When
        String checkoutOutput = productService.checkout(input);

        // Then
        assertEquals("> 1 imported bottle of perfume: 32.19\n" +
                "> 1 bottle of perfume: 20.89\n" +
                "> 1 packet of headache pills: 9.75\n" +
                "> 1 imported box of chocolates: 11.85\n" +
                "> Sales Taxes: 6.70\n" +
                "> Total: 74.68", checkoutOutput);
    }

}