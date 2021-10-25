package com.assignment.app;
import com.assignment.app.controller.MainUI;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        MainUI.menu();
    }
}
