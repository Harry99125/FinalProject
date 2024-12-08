/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;
import model.Pharmacy.Pharmacy;
import model.TrainingCenter.TrainingCenter;
import org.bson.Document;



public class TrainingCenterService {
    MongoDatabase database = new Connection().connectToDatabase();
    MongoCollection<Document> collection = database.getCollection("TrainingCenter");
    CRUDOperations crud = new CRUDOperations();

    public void updateTrainingCenter(TrainingCenter trainingCenter, MongoDatabase database) {
        crud.updateStringById(trainingCenter.getTrainingCenterId(), "trainingcenterLocation", trainingCenter.getTrainingCenterLocation(), collection);
        crud.updateStringById(trainingCenter.getTrainingCenterId(), "trainingcenterContact", trainingCenter.getTrainingCenterContact(), collection);
        crud.updateStringById(trainingCenter.getTrainingCenterId(), "trainingcenterEmail", trainingCenter.getTrainingCenterEmail(), collection);
    }

}
