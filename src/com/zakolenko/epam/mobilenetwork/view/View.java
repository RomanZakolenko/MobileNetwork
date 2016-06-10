package com.zakolenko.epam.mobilenetwork.view;

/**
 * An instance of this class is used to represent data.
 *
 * @author Roman Zakolenko
 */
public class View {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(String... messages) {
        StringBuilder message = new StringBuilder();
        for (String m : messages) {
            message.append(m);
        }
        System.out.println(message);
    }
}
