package com.zakolenko.epam.mobilenetwork.model.entities.company;

import com.zakolenko.epam.mobilenetwork.model.entities.tariff.Tariff;

import java.util.Set;

/**
 * This interface is a generalization for the mobile company.
 * The interface contains a regular expression to validate the mobile phone number,
 * as well as basic behavior.
 *
 * @author Roman Zakolenko
 */
public interface MobileCompany {
    //Regular expression to validate mobile number
    String PHONE_NUMBER_REGEX = "^\\+?(3\\-?8\\-?)?((\\(\\d{3}\\))|(\\d{3}))\\-?\\d{3}\\-?\\d{2}\\-?\\d{2}$";

    /**
     * Counts the number of clients company.
     *
     * @return number of clients
     */
    int getNumberOfClients();

    /**
     * Returns all tariffs of the mobile company.
     *
     * @return set of tariffs mobile company
     */
    Set<Tariff> getTariffs();

    /**
     * Checks the mobile number in the mobile company affiliation.
     *
     * @param number for verification
     * @return true, if company contains specific number, otherwise false
     */
    boolean hasNumber(String number);
}
