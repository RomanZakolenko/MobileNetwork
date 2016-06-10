package com.zakolenko.epam.mobilenetwork.controller;

import com.zakolenko.epam.mobilenetwork.controller.config.Config;
import com.zakolenko.epam.mobilenetwork.model.entities.company.Operator;
import com.zakolenko.epam.mobilenetwork.model.entities.tariff.Tariff;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

/**
 * An  instance of this class is used to the initialization mobile network.
 *
 * @author Roman Zakolenko
 */
public class InitializationController {

    /**
     * It initializes the mobile network by deserializing objects
     * from files which settings in config.
     */
    public void initialize() {
        try (ObjectInputStream ous = new ObjectInputStream(new FileInputStream(Config.CONFIG.getMtsFile()))) {
            Operator.MTS.setTariffs((Set<Tariff>) ous.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream ous = new ObjectInputStream(new FileInputStream(Config.CONFIG.getKyivstarFile()))) {
            Operator.KYIVSTAR.setTariffs((Set<Tariff>) ous.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
