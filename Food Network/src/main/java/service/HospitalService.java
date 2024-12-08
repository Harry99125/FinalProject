/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;
import model.Hospital.Hospital;
import org.bson.Document;


public class HospitalService {
    MongoDatabase database = new Connection().connectToDatabase();
    MongoCollection<Document> collection = database.getCollection("Hospital");
    CRUDOperations crud = new CRUDOperations();
    public void updateHospital(Hospital hospital, MongoDatabase database) {
        CRUDOperations crud = new CRUDOperations();
        crud.updateStringById(hospital.getHospitalId(), "hospitalContact", hospital.getHospitalContact(), collection);
        crud.updateStringById(hospital.getHospitalId(), "hospitalLocation", hospital.getHospitalLocation(), collection);
        crud.updateStringById(hospital.getHospitalId(), "hospitalEmail", hospital.getHospitalEmail(), collection);
    }
}
