package model.Farmer;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import service.FarmerService;

public class Farmer {

    private ObjectId farmerId;
    private String farmName;
    private String farmlocation;
    private String farmcontact;
    private String farmemail;
    private ProduceDirectory produceDirectory;
    private String farmAdminId;
    private String farmerName;
    
    FarmerService farmerService = new FarmerService();

    public Farmer(String farmerName, String farmerAdminId, String farmerAddress, String farmerContact, String farmerEmail) {
        this.farmName = farmerName;
        this.produceDirectory = new ProduceDirectory();
        this.farmAdminId = farmerAdminId;
        this.farmlocation = farmerAddress;
        this.farmcontact = farmerContact;
        this.farmemail = farmerEmail;
    }

    public Farmer(Document organization, Document userLogin) {
        this.farmerId = organization.getObjectId("_id");
        this.farmName = organization.getString("farmName");
        this.farmlocation = organization.getString("farmlocation");
        this.farmcontact = organization.getString("farmcontact");
        this.farmemail = organization.getString("farmemail");
        this.produceDirectory = new ProduceDirectory();
        this.farmAdminId = userLogin.getString("username");
    }

    private Produce createProduce(String produceName, ObjectId produceID, String produceComposition,
            String producePrice, int produceQuantity, String produceDescription, String produceCategory,
            String produceExpiryDate, String produceHarvestDate, String produceUsage) {
        Produce prod = produceDirectory.findProduce(produceName);
        if (prod != null) {
            System.out.println(prod + " produce already exists");
        }
        prod = produceDirectory.addProduce(produceName, produceID, produceComposition,
                producePrice, produceQuantity, produceDescription, produceCategory,
                produceExpiryDate, produceHarvestDate, produceUsage);
        return prod;
    }

    private void updateQuantity(int quantity, Produce produce) {

        if (produceDirectory.findProduce(produce.getProduceName()) != null) {
            produce.updateQuantity(quantity);
            System.out.println("produce quantity updated");
            return;
        }
        System.out.println("Produce does not exist");
    }

    private ProduceDirectory getProduceList() {
        return produceDirectory;
    }

    private ProduceDirectory getProducesByCategory(String category) {
        ProduceDirectory pd = new ProduceDirectory();
        for (Produce prod : produceDirectory.getProduceList()) {
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

    public String getFarmerName() {
        return farmName;
    }

    public ObjectId getId() {
        return farmerId;
    }

    public void setId(ObjectId id) {
        this.farmerId = id;
    }

    public void setFarmerName(String farmerName) {
        this.farmName = farmerName;
    }

    public String getFarmerAddress() {
        return farmlocation;
    }

    public void setFarmerAddress(String farmerAddress) {
        this.farmlocation = farmerAddress;
    }

    public String getFarmerContact() {
        return farmcontact;
    }

    public void setFarmerContact(String farmerContact) {
        this.farmcontact = farmerContact;
    }

    public String getFarmerEmail() {
        return farmemail;
    }

    public void setFarmerEmail(String farmerEmail) {
        this.farmemail = farmerEmail;
    }

    public ProduceDirectory getProduceDirectory() {
        return produceDirectory;
    }

    public void setProduceDirectory(ProduceDirectory produceDirectory) {
        this.produceDirectory = produceDirectory;
    }

    public String getFarmerAdminId() {
        return farmAdminId;
    }

    public void setFarmerAdminId(String farmerAdminId) {
        this.farmAdminId = farmerAdminId;
    }

    @Override
    public String toString() {
        return farmName;
    }

    public String getFarmerManagerName() {
        return farmAdminId;
    }

    public void updateFarmer(Farmer farmer, MongoDatabase database) {
        farmerService.updateFarmer(farmer, database);
    }
    
    public void updateFarmerProduce(int stockQuantity, String farmerPrice, ObjectId id, MongoCollection<Document> collection) {
        farmerService.updateFarmerProduce(stockQuantity, farmerPrice, id, collection);
    }
    
    

    public Document toDocument() {
        return new Document("farmerName", farmName)
                .append("farmerAddress", farmlocation)
                .append("farmerContact", farmcontact)
                .append("farmerEmail", farmemail)
                .append("farmerAdminId", farmAdminId);
    }
}
