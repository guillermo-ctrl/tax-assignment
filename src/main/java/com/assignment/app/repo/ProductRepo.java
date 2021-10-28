package com.assignment.app.repo;

import com.assignment.app.model.Book;
import com.assignment.app.model.BottleOfPerfume;
import com.assignment.app.model.MusicCD;
import com.assignment.app.model.BoxOfChocolates;
import com.assignment.app.model.HeadAchePills;
import com.assignment.app.model.ChocolateBar;
import com.assignment.app.model.Product;
import org.reflections.Reflections;

import java.util.Set;


public class ProductRepo {

    public double getProductPrice(String productName) {

        switch(productName.trim().toLowerCase())  {
            case "book":
                return new Book().getPrice();
            case "bottleofperfume":
                return new BottleOfPerfume().getPrice();
            case "musiccd":
                return new MusicCD().getPrice();
            case "chocolatebar":
                return new ChocolateBar().getPrice();
            case "boxofchocolates":
                return new BoxOfChocolates().getPrice();
            case "headachepills":
                return new HeadAchePills().getPrice();

            default: return 0;
        }

    }

    public boolean checkIfProductExists(String selection) {
        Reflections reflections = new Reflections("com.assignment.app");
        Set<Class<? extends Product>> allProducts = reflections.getSubTypesOf(Product.class);

        boolean returnStatement = false;

        for (Class product : allProducts) {
            if (product.getName().toLowerCase().trim().contains(selection)) {
                returnStatement = true;
                break;
            }
        }
        return returnStatement;
    }
}