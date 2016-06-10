package com.zakolenko.epam.mobilenetwork.model;

import com.zakolenko.epam.mobilenetwork.model.entities.company.MobileCompany;
import com.zakolenko.epam.mobilenetwork.model.entities.tariff.Tariff;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class contains logic for work with mobile operators.
 *
 * @author Roman Zakolenko
 */
public class Model {

    /**
     * Counts number of clients of specific mobile company.
     *
     * @param company whose clients will be counted
     * @return number of clients
     */
    public int getNumberOfClients(MobileCompany company) {
        return company.getNumberOfClients();
    }

    /**
     * Returns sorted by monthly price list of tariffs.
     *
     * @param company whose tariffs will be sorted
     * @return sorted list of tariffs
     */
    public List<Tariff> sortTariffsByMonthlyPrice(MobileCompany company) {
        return company.getTariffs().stream().
                sorted((t1, t2) -> Double.compare(t1.getMonthlyPrice(), t2.getMonthlyPrice())).
                collect(Collectors.toList());
    }

    /**
     * It finds the tariffs monthly price of which ranges(min..max).
     *
     * @param company keeps tariffs
     * @param min     lower   value of monthly price
     * @param max     bigger value of monthly price
     * @return list of tariffs monthly price of which ranges(min..max)
     */
    public List<? extends Tariff> getTariffsByMonthlyPrice(MobileCompany company, double min, double max) {
        TariffFilter filter = new TariffFilter(t -> t.getMonthlyPrice() >= min && t.getMonthlyPrice() <= max);
        return filter.filter(new ArrayList<>(company.getTariffs()));
    }

    /**
     * It finds the tariffs number of clients of which ranges(min..max).
     *
     * @param company keeps tariffs
     * @param min     lower   value of number of clients
     * @param max     bigger value of number of clients
     * @return list of tariffs number of clients of which ranges(min..max).
     */
    public List<? extends Tariff> getTariffsByNumberOfClients(MobileCompany company, int min, int max) {
        TariffFilter filter = new TariffFilter(t -> t.getNumberOfClients() >= min && t.getNumberOfClients() <= max);
        return filter.filter(new ArrayList<>(company.getTariffs()));
    }

    /**
     * It finds the tariffs by specific condition.
     *
     * @param company      keeps tariffs
     * @param tariffFilter contains specific condition for tariff filtering
     * @return list of tariffs which satisfies the specific condition
     */
    public List<? extends Tariff> getTariffsByFilter(MobileCompany company, TariffFilter tariffFilter) {
        return tariffFilter.filter(new ArrayList<>(company.getTariffs()));
    }
}