package model.Business;

import com.mongodb.client.MongoDatabase;
import model.Farmer.Farmer;
import service.FarmerService;

import java.util.ArrayList;

public class FarmerDirectory {
    private ArrayList<Farmer> farmerList;

    public FarmerDirectory() {
        farmerList = new ArrayList<>();
    }

    public Farmer createFarmer(String farmerName, String adminName, String address, String contact, String email) {
        Farmer farmer = new Farmer(farmerName, adminName, address, contact, email);
        farmerList.add(farmer);
        return farmer;
    }

    public Farmer authenticateFarmerAdmin(String farmerName, String adminUserName) {
        Farmer farmer = findFarmer(farmerName);
        if (farmer != null) {
            if (farmer.authenticateAdmin(adminUserName)) {
                return farmer;
            }
        }
        return null;
    }

    private Farmer findFarmer(String farmerName) {
        for (Farmer f : farmerList) {
            if (f.isMatch(farmerName)) {
                return f;
            }
        }
        return null;
    }

    public ArrayList<Farmer> getFarmerList() {
        return farmerList;
    }
}
