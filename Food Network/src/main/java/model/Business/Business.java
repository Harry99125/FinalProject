/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import model.Personnel.*;
import model.TrainingCenter.TrainingCenter;


public class Business {

    private HospitalDirectory hospitaldirectory;
    private DoctorDirectory doctordirectory;
    private PharmacyDirectory pharmacydirectory;
    private TrainingCenterDirectory trainingcenterdirectory;
    private MedicalEquipmentSupplierDirectory medicalequipmentsupplierdirectory;
    private ResearchDirectory researchdirectory;

    public Business() {
        this.hospitaldirectory = new HospitalDirectory();
        this.doctordirectory = new DoctorDirectory();
        this.pharmacydirectory = new PharmacyDirectory();
        this.trainingcenterdirectory = new TrainingCenterDirectory();
        this.medicalequipmentsupplierdirectory = new MedicalEquipmentSupplierDirectory();
        this.researchdirectory = new ResearchDirectory();
    }


//    public Adminstrator createAdminstrator(String name) {
//        if(persondirectory.findPerson(name)==null){
//            return null;
//        }
//        Person p = new Person(name);
//        admin = new Adminstrator(p);
//        persondirectory.newPerson(p);
//        return admin;
//    }

    public HospitalDirectory getHospitaldirectory() {
        return hospitaldirectory;
    }

    public PharmacyDirectory getPharmacydirectory() {
        return pharmacydirectory;
    }

    public TrainingCenterDirectory getTrainingcenterdirectory() {
        return trainingcenterdirectory;
    }

    public MedicalEquipmentSupplierDirectory getMedicalequipmentsupplierdirectory() {
        return medicalequipmentsupplierdirectory;
    }

    public ResearchDirectory getResearchdirectory() {
        return researchdirectory;
    }
}
