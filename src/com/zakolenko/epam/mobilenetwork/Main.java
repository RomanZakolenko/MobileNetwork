package com.zakolenko.epam.mobilenetwork;

import com.zakolenko.epam.mobilenetwork.controller.InitializationController;
import com.zakolenko.epam.mobilenetwork.controller.UserController;
import com.zakolenko.epam.mobilenetwork.model.Model;
import com.zakolenko.epam.mobilenetwork.view.View;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InitializationController initController = new InitializationController();
        initController.initialize();
        UserController userController = new UserController(new Model(), new View());
        userController.printOperatorsInfo();
        userController.findTariffByMonthlyPrice();
    }
}
