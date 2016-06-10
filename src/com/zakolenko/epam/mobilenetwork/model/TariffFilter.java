package com.zakolenko.epam.mobilenetwork.model;

import com.zakolenko.epam.mobilenetwork.model.entities.tariff.Tariff;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * An instance of this class is used to filter the tariffs for a certain condition.
 *
 * @author Roman Zakolenko
 */
public class TariffFilter {
    /**
     * It contains condition for filtering.
     */
    private Predicate<Tariff> predicate;
    /**
     * It contains the following filter. Used to filter layout.
     */
    private TariffFilter nextFilter;

    /**
     * @param predicate condition for filtering
     */
    public TariffFilter(Predicate<Tariff> predicate) {
        this.predicate = predicate;
    }

    /**
     * @param predicate  condition for filtering
     * @param nextFilter following filter. Used to filter layout.
     */
    public TariffFilter(Predicate<Tariff> predicate, TariffFilter nextFilter) {
        this.predicate = predicate;
        this.nextFilter = nextFilter;
    }

    public void setNextFilter(TariffFilter nextFilter) {
        this.nextFilter = nextFilter;
    }

    /**
     * Filters tariffs and calls the next filter if it is not null.
     *
     * @param tariffs a list of tariffs for filtering
     * @return list of filtered tariffs
     */
    public List<? extends Tariff> filter(List<? extends Tariff> tariffs) {
        List<? extends Tariff> filtered = tariffs.stream().filter(predicate).collect(Collectors.toList());
        if (nextFilter != null) {
            return nextFilter.filter(filtered);
        }
        return filtered;
    }
}
