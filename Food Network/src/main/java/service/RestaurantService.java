package service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;
import model.Farmer.Farmer;
import model.Restaurant.Restaurant;
import org.bson.Document;
 import org.bson.types.ObjectId;

public class RestaurantService {
    MongoDatabase database = new Connection().connectToDatabase();
    MongoCollection<Document> collection = database.getCollection("Restaurant");
    CRUDOperations crud = new CRUDOperations();

    public void updateRestaurant(Restaurant farmer, MongoDatabase database) {
        crud.updateStringById(farmer.getRestaurantId(), "RestaurantAddress", farmer.getRestaurantlocation(), collection);
        crud.updateStringById(farmer.getRestaurantId(), "RestaurantContact", farmer.getRestaurantcontact(), collection);
        crud.updateStringById(farmer.getRestaurantId(), "RestaurantEmail", farmer.getRestaurantemail(), collection);
    }
    
  
}
