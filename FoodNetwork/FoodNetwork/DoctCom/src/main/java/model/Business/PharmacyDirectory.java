package model.Business;

import com.mongodb.client.MongoDatabase;
import model.Pharmacy.Pharmacy;
import service.PharmacyService;

import java.util.ArrayList;

public class PharmacyDirectory {
    private ArrayList<Pharmacy> pharmacyList;

    public PharmacyDirectory() {
        pharmacyList = new ArrayList<>();
    }

    public Pharmacy createPharmacy(String paradisePharmacy, String adminName, String address, String contact, String email) {
        Pharmacy pharmacy = new Pharmacy(paradisePharmacy, adminName, address, contact, email);
        pharmacyList.add(pharmacy);
        return pharmacy;
    }

    public Pharmacy authenticatePharmacyAdmin(String pharmacyName, String AdminUserName) {
        Pharmacy pharmacy = findPharmacy(pharmacyName);
        if (pharmacy != null) {
            if (pharmacy.authenticateAdmin(AdminUserName)) {
                return pharmacy;
            }
        }
        return null;
    }

    private Pharmacy findPharmacy(String pharmacyName) {
        for (Pharmacy p : pharmacyList) {
            if (p.isMatch(pharmacyName)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Pharmacy> getPharmacyList() {
        return pharmacyList;
    }

   
}
