package com.zakolenko.epam.mobilenetwork.model.entities.company;

import com.zakolenko.epam.mobilenetwork.model.entities.tariff.Tariff;

import java.util.HashSet;
import java.util.Set;

/**
 * This class contains a enumeration of the mobile operators.
 *
 * @author Roman Zakolenko
 */
public enum Operator implements MobileCompany {

    KYIVSTAR("39", "67", "68", "96", "97", "98"),
    MTS("50", "66", "95", "99");

    private Set<String> operatorCodes = new HashSet<>();
    private Set<Tariff> tariffs = new HashSet<>();

    Operator(String... operatorCodes) {
        for (String code : operatorCodes) {
            this.operatorCodes.add(code);
        }
    }

    /**
     * @see MobileCompany#getNumberOfClients()
     */
    @Override
    public int getNumberOfClients() {
        return tariffs.stream().mapToInt(t -> t.getNumberOfClients()).sum();
    }

    /**
     * @see MobileCompany#getTariffs()
     */
    @Override
    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    /**
     * @see MobileCompany#hasNumber(String)
     */
    @Override
    public boolean hasNumber(String number) {
        number = number.replaceAll("[-()]", "");
        String code = number.substring(0, number.length() - 7);
        for (String opCode : operatorCodes) {
            if (code.contains(opCode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds the specific operator code in the operator's code list.
     *
     * @param code specific operator code
     * @return true, if code successfully added, otherwise false
     */
    public boolean addOperatorCodes(String code) {
        return operatorCodes.add(code);
    }

    public boolean addTariff(Tariff tariff) {
        return tariffs.add(tariff);
    }

    public Set<String> getOperatorCodes() {
        return operatorCodes;
    }

    public void setOperatorCodes(Set<String> operatorCodes) {
        this.operatorCodes = operatorCodes;
    }

    public void setTariffs(Set<Tariff> tariffs) {
        this.tariffs = tariffs;
    }
}
