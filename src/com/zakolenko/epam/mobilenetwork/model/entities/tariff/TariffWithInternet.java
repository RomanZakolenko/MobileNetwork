package com.zakolenko.epam.mobilenetwork.model.entities.tariff;

import com.zakolenko.epam.mobilenetwork.model.entities.User;
import com.zakolenko.epam.mobilenetwork.model.entities.company.MobileCompany;

import java.util.List;

/**
 * This class represents a particular mobile tariff with an internet connection.
 *
 * @author Roman Zakolenko
 */
public class TariffWithInternet extends AbstractTariff {
    private AbstractTariff tariff;
    private double internetPrice;

    public TariffWithInternet() {
    }

    /**
     * @param title         of tariff
     * @param monthlyPrice  double value of monthly price
     * @param mobileCompany indicates the tariff belonging to a specific company
     * @param users         list of tariff
     * @param tariff        internal tariff
     * @param internetPrice double value of internet price
     */
    public TariffWithInternet(String title, double monthlyPrice, MobileCompany mobileCompany,
                              List<User> users, AbstractTariff tariff, double internetPrice) {
        super(title, monthlyPrice, mobileCompany, users);
        this.tariff = tariff;
        this.internetPrice = internetPrice;
    }

    /**
     * @see AbstractTariff#getCallPriceInsideNet()
     */
    @Override
    public double getCallPriceInsideNet() {
        return tariff.getCallPriceInsideNet();
    }

    /**
     * @see AbstractTariff#getCallPriceOutsideNet()
     */
    @Override
    public double getCallPriceOutsideNet() {
        return tariff.getCallPriceOutsideNet();
    }


    public AbstractTariff getTariff() {
        return tariff;
    }

    public void setTariff(AbstractTariff tariff) {
        this.tariff = tariff;
    }

    public void setInternetPrice(double internetPrice) {
        this.internetPrice = internetPrice;
    }

    public double getInternetPrice() {
        return internetPrice;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", internetPrice=" + getInternetPrice();
    }
}