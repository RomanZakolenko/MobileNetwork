package com.zakolenko.epam.mobilenetwork.model.entities.tariff;

import com.zakolenko.epam.mobilenetwork.model.entities.User;

/**
 * This interface is a generalization for the mobile tariff.
 *
 * @author Roman Zakolenko
 */
public interface Tariff {

    /**
     * Returns number of tariff clints.
     *
     * @return number of clients
     */
    int getNumberOfClients();

    /**
     * Returns monthly price of tariff.
     *
     * @return double value of monthly price
     */
    double getMonthlyPrice();

    /**
     * Returns call price for specific mobile number.
     *
     * @param number specific mobile number
     * @return double value of call price
     */
    double getCallPrice(String number);

    /**
     * Adds specific user in list users of this tariff.
     *
     * @param user specific user
     */
    void addUser(User user);
}
