/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

// import BCrypt library for password hashing
import org.mindrot.jbcrypt.BCrypt;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;


public class DataBaseConnection {

    private static DataBaseConnection instance = null;
    public MongoDatabase database;

    private DataBaseConnection() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://nilay09raut:vse5Ru7LMlEOAbd9@cluster0.qxs2w.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");

        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());

        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);

        MongoClientSettings clientSettings;
        clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();

        MongoClient client = (MongoClient) MongoClients.create(clientSettings);
        database = client.getDatabase("FoodSupply");

    }

    public static DataBaseConnection connectToDatabase() {
        if (instance == null) {
            instance = new DataBaseConnection();
        }

        return instance;
    }

    public Document findUserById(String id) {
        MongoCollection<Document> collection = database.getCollection("users");
        return collection.find(new Document("_id", new ObjectId(id))).first();
    }

    public void insertUser(String name, String dob, String password) {
        MongoCollection<Document> collection = database.getCollection("users");

        Document newUser = new Document("_id", new org.bson.types.ObjectId()) // Generates a new ObjectId
                .append("name", name)
                .append("dob", dob)
                .append("password", hashPassword(password));

        collection.insertOne(newUser);
        System.out.println("Inserted a new user with ID: " + newUser.getObjectId("_id"));
    }

    // Method to hash the password using BCrypt
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Method to verify the password
    private boolean verifyPassword(String enteredPassword, String hashedPassword) {
        return BCrypt.checkpw(enteredPassword, hashedPassword);
    }

    public static void main(String[] args) {
        DataBaseConnection dbConnection = DataBaseConnection.connectToDatabase();
        Document user = dbConnection.findUserById("6621c3a0e4d9b81679a09fba7");
        if (user != null) {
            System.out.println(user.toJson());
        } else {
            System.out.println("No user found with the given ID.");
        }
//        dbConnection.insertUser("New User", "01/01/2000");
//        
        dbConnection.insertUser("New User", "01/01/2000", "password123");

     
    }
}
