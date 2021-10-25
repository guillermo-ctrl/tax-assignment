package com.assignment.app;
import com.assignment.app.controller.ProductController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ProductController.sayHi();
    }
}
