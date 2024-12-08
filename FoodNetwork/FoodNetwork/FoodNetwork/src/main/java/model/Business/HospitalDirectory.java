package model.Business;


import model.Hospital.Hospital;

import java.util.ArrayList;
import org.bson.types.ObjectId;

public class HospitalDirectory {
    private ArrayList<Hospital> hospitals;

    public HospitalDirectory() {
        hospitals = new ArrayList<>();
    }

    public boolean getHospital(String name) {
        return findHospital(name);
    }

    private boolean findHospital(String name) {
        for (Hospital h : hospitals) {
            if (h.isMatch(name)) {
                return true;
            }
        }
        return false;
    }

//    public Hospital createHospital(String name, ObjectId hospitalAdminId) {
//        if(!findHospital(name)){
//            Hospital h = new Hospital(name, hospitalAdminId);
//            hospitals.add(h);
//            return h;
//        }
//        else {
//            System.out.println("Hospital already exists");
//            return null;
//        }
//    }
}
