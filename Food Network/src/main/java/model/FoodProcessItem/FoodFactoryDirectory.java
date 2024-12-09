/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.FoodProcessItem;

/**
 *
 * @author Nilay
 */

import java.util.ArrayList;

public class FoodFactoryDirectory {

    private ArrayList<FoodFactory> factoryList;

    public FoodFactoryDirectory() {
        this.factoryList = new ArrayList<>();
    }

    public FoodFactory createFactory(String factoryName, String adminName, String location, String contact, String email) {
        FoodFactory factory = new FoodFactory(factoryName, adminName, location, contact, email);
        factoryList.add(factory);
        return factory;
    }

    public FoodFactory authenticateFactoryAdmin(String factoryName, String adminUserName) {
        FoodFactory factory = findFactory(factoryName);
        if (factory != null) {
            if (factory.authenticateAdmin(adminUserName)) {
                return factory;
            }
        }
        return null;
    }

    private FoodFactory findFactory(String factoryName) {
        for (FoodFactory factory : factoryList) {
            if (factory.isMatch(factoryName)) {
                return factory;
            }
        }
        return null;
    }

    public ArrayList<FoodFactory> getFactoryList() {
        return factoryList;
    }
}
