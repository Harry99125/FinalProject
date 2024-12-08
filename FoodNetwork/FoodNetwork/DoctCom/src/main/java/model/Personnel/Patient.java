package model.Personnel;

import java.io.File;

public class Patient {
    private String id;
    private String name;
    private String address;
    private String phone;
    private String condition;
//    report in pdf file
    private File report;
    private String lastVisit;

    public Patient(String id, String name, String address, String phone, String condition, String lastVisit) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.condition = condition;
        this.lastVisit = lastVisit;
    }

    public String getName() {
        return name;
    }
}
