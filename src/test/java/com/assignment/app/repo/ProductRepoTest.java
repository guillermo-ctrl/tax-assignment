package com.assignment.app.repo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {
    ProductRepo productRepo = new ProductRepo();

    @Test
    void getProductPrice() {

        // Given
        String product = "chocolate bar";

        // When
        double price = productRepo.getProductPrice(product);

        // Then
        assertEquals(12.49, price);

    }

    @Test
    void productCheckDoesNotExist() {

        // Given
        String product = "chocolate chips";

        // When
        boolean check = productRepo.checkIfProductExists(product);

        // Then
        assertEquals(check,false);

    }

    @Test
    void productCheckDoesExist() {
        // Given
        String product = "chocolate bar";

        // When
        boolean check = productRepo.checkIfProductExists(product);

        // Then
        assertEquals(true,check);
    }

    @Test
    void productCheckDoesExist2() {
        // Given
        String product = "book";

        // When
        boolean check = productRepo.checkIfProductExists(product);

        // Then
        assertEquals(true, check);
    }

}