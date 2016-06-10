package com.zakolenko.epam.mobilenetwork.model.entities;

import com.zakolenko.epam.mobilenetwork.model.entities.company.MobileCompany;
import com.zakolenko.epam.mobilenetwork.model.entities.tariff.Tariff;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * This class represents a user of mobile network.
 *
 * @author Roman Zakolenko
 */
public class User implements Serializable {
    private double balance;
    private String phoneNumber;
    private Tariff tariff;

    public User() {
    }

    /**
     * @param balance     double value of user balance
     * @param phoneNumber of user
     * @param tariff      of user
     */
    public User(double balance, String phoneNumber, Tariff tariff) {
        this.balance = balance;
        this.phoneNumber = phoneNumber;
        this.tariff = tariff;
    }

    /**
     * This method is used for calling to specific phone number.
     *
     * @param phoneNumber specific phone number
     * @return true, if call is successfully, otherwise false
     */
    public boolean call(String phoneNumber) {
        String number = deleteSpaces(phoneNumber);
        boolean isValidNumber = Pattern.matches(MobileCompany.PHONE_NUMBER_REGEX, number);
        if (isValidNumber) {
            double callPrice = tariff.getCallPrice(number);
            if (balance - callPrice >= 0) {
                balance -= callPrice;
                return true;
            }
        }
        return false;
    }

    /***
     * This method is used for refill user balance.
     *
     * @param balance
     */
    public void refillBalance(double balance) {
        this.balance += balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return phoneNumber.equals(user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return phoneNumber.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "balance=" + balance +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", tariff=" + tariff +
                '}';
    }

    private String deleteSpaces(String number) {
        return number.replaceAll("\\s+", "");
    }
}
