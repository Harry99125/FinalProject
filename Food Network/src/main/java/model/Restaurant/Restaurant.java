package model.Restaurant;

import model.Restaurant.Restaurant.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import service.FarmerService;
import service.RestaurantService;

public class Restaurant {

    public ObjectId getRestaurantId() {
        return RestaurantId;
    }

    public void setRestaurantId(ObjectId RestaurantId) {
        this.RestaurantId = RestaurantId;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String RestaurantName) {
        this.RestaurantName = RestaurantName;
    }

    public String getRestaurantlocation() {
        return Restaurantlocation;
    }

    public void setRestaurantlocation(String Restaurantlocation) {
        this.Restaurantlocation = Restaurantlocation;
    }

    public String getRestaurantcontact() {
        return Restaurantcontact;
    }

    public void setRestaurantcontact(String Restaurantcontact) {
        this.Restaurantcontact = Restaurantcontact;
    }

    public String getRestaurantemail() {
        return Restaurantemail;
    }

    public void setRestaurantemail(String Restaurantemail) {
        this.Restaurantemail = Restaurantemail;
    }

    public String getRestaurantAdminId() {
        return RestaurantAdminId;
    }

    public void setRestaurantAdminId(String RestaurantAdminId) {
        this.RestaurantAdminId = RestaurantAdminId;
    }

    public String getRestaurantManageName() {
        return RestaurantManageName;
    }

    public void setRestaurantManageName(String RestaurantManageName) {
        this.RestaurantManageName = RestaurantManageName;
    }


    private ObjectId RestaurantId;
    private String RestaurantName;
    private String Restaurantlocation;
    private String Restaurantcontact;
    private String Restaurantemail;
    private RestaurantItemDirectory produceDirectory;
    private String RestaurantAdminId;
    private String RestaurantManageName;

    public RestaurantService getRestaurantService() {
        return RestaurantService;
    }

    public void setRestaurantService(RestaurantService RestaurantService) {
        this.RestaurantService = RestaurantService;
    }
    
   RestaurantService  RestaurantService = new  RestaurantService();

    public Restaurant(String RestaurantName, String RestaurantAdminId, String RestaurantAddress, String RestaurantContact, String RestaurantEmail) {
        this.RestaurantName = RestaurantName;
        this.produceDirectory = new RestaurantItemDirectory();
        this.RestaurantAdminId =RestaurantAdminId;
        this.Restaurantlocation = RestaurantAddress;
        this.Restaurantcontact = RestaurantContact;
        this.Restaurantemail = RestaurantEmail;
    }

    public Restaurant(Document organization, Document userLogin) {
        this.RestaurantId = organization.getObjectId("_id");
        this.RestaurantName = organization.getString("restaurantName");
        this.Restaurantlocation = organization.getString("restaurantAddress");
        this.Restaurantcontact = organization.getString("restaurantContact");
        this.Restaurantemail = organization.getString("restaurantEmail");
        this.produceDirectory = new RestaurantItemDirectory();
        this.RestaurantAdminId = userLogin.getString("username");
    }

    private RestaurantItem createProduce(String produceName, ObjectId produceID, String produceComposition,
            String producePrice, int produceQuantity, String produceDescription, String produceCategory,
            String produceExpiryDate, String produceHarvestDate, String produceUsage) {
        RestaurantItem prod = produceDirectory.findProduce(produceName);
        if (prod != null) {
            System.out.println(prod + " produce already exists");
        }
        prod = produceDirectory.addProduce(produceName, produceID, produceComposition,
                producePrice, produceQuantity, produceDescription, produceCategory,
                produceExpiryDate, produceHarvestDate, produceUsage);
        return prod;
    }

    private void updateQuantity(int quantity, RestaurantItem produce) {

        if (produceDirectory.findProduce(produce.getProduceName()) != null) {
            produce.updateQuantity(quantity);
            System.out.println("produce quantity updated");
            return;
        }
        System.out.println("Produce does not exist");
    }

    private RestaurantItemDirectory getProduceList() {
        return produceDirectory;
    }

    private RestaurantItemDirectory getProducesByCategory(String category) {
        RestaurantItemDirectory pd = new RestaurantItemDirectory();
        for (RestaurantItem prod : produceDirectory.getProduceList()) {
            if (prod.getProduceCategory().equalsIgnoreCase(category)) {
                pd.addProduce(prod);
            }
        }
        return pd;
    }

    private ArrayList<String> getCategoryList() {
        return produceDirectory.getCategoryList();
    }

    public boolean isMatch(String farmerName) {
        return this.farmName.equalsIgnoreCase(farmerName);
    }

    public boolean authenticateAdmin(String adminUserName) {
        if (isMatch(adminUserName)) {
            return true;
        }
        return false;
    }

   

    public RestaurantItemDirectory getProduceDirectory() {
        return produceDirectory;
    }

    public void setProduceDirectory(RestaurantItemDirectory produceDirectory) {
        this.produceDirectory = produceDirectory;
    }

   

    @Override
    public String toString() {
        return RestaurantName;
    }

 
    public void updateFarmer(Restaurant farmer, MongoDatabase database) {
        RestaurantService.updateRestaurant(farmer, database);
    }
    
  
    
    

    public Document toDocument() {
        return new Document("RestaurantName", RestaurantName)
                .append("RestaurantAddress", Restaurantlocation)
                .append("RestaurantContact", Restaurantcontact)
                .append("RestaurantEmail", Restaurantemail)
                .append("RestaurantAdminId", RestaurantAdminId);
    }
}
