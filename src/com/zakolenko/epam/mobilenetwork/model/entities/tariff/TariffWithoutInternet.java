package com.zakolenko.epam.mobilenetwork.model.entities.tariff;

import com.zakolenko.epam.mobilenetwork.model.entities.User;
import com.zakolenko.epam.mobilenetwork.model.entities.company.MobileCompany;

import java.util.List;

/**
 * This class represents a particular mobile tariff without an internet connection.
 *
 * @author Roman Zakolenko
 */
public class TariffWithoutInternet extends AbstractTariff {
    private double callPriceInsideNet;
    private double callPriceOutsideNet;

    public TariffWithoutInternet() {
    }

    /**
     * @param title               of tariff
     * @param monthlyPrice        double value of monthly price
     * @param mobileCompany       indicates the tariff belonging to a specific company
     * @param users               list of tariff
     * @param callPriceInsideNet  double value of call price inside net
     * @param callPriceOutsideNet double value of call price outside net
     */
    public TariffWithoutInternet(String title, double monthlyPrice, MobileCompany mobileCompany,
                                 List<User> users, double callPriceInsideNet, double callPriceOutsideNet) {
        super(title, monthlyPrice, mobileCompany, users);
        this.callPriceInsideNet = callPriceInsideNet;
        this.callPriceOutsideNet = callPriceOutsideNet;
    }

    /**
     * @see AbstractTariff#getCallPriceInsideNet()
     */
    @Override
    public double getCallPriceInsideNet() {
        return callPriceInsideNet;
    }

    /**
     * @see AbstractTariff#getCallPriceOutsideNet()
     */
    @Override
    public double getCallPriceOutsideNet() {
        return callPriceOutsideNet;
    }

    public void setCallPriceInsideNet(double callPriceInsideNet) {
        this.callPriceInsideNet = callPriceInsideNet;
    }

    public void setCallPriceOutsideNet(double callPriceOutsideNet) {
        this.callPriceOutsideNet = callPriceOutsideNet;
    }
}
