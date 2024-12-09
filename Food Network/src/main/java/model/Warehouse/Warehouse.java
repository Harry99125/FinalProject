package model.Warehouse;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import service.RestaurantService;

public class Warehouse {

    public ObjectId getWarehouseId() {
        return WarehouseId;
    }

    public void setWarehouseId(ObjectId WarehouseId) {
        this.WarehouseId = WarehouseId;
    }

    public String getWarehouseName() {
        return WarehouseName;
    }

    public void setWarehouseName(String WarehouseName) {
        this.WarehouseName = WarehouseName;
    }

    public String getWarehouselocation() {
        return Warehouselocation;
    }

    public void setWarehouselocation(String Warehouselocation) {
        this.Warehouselocation = Warehouselocation;
    }

    public String getWarehousecontact() {
        return Warehousecontact;
    }

    public void setWarehousecontact(String Warehousecontact) {
        this.Warehousecontact = Warehousecontact;
    }

    public String getWarehouseemail() {
        return Warehouseemail;
    }

    public void setWarehouseemail(String Warehouseemail) {
        this.Warehouseemail = Warehouseemail;
    }

    public String getWarehouseAdminId() {
        return WarehouseAdminId;
    }

    public void setWarehouseAdminId(String WarehouseAdminId) {
        this.WarehouseAdminId = WarehouseAdminId;
    }

    public String getWarehouseManageName() {
        return WarehouseAdminId;
    }

    public void setWarehouseManageName(String WarehouseManageName) {
        this.WarehouseManageName = WarehouseManageName;
    }

    private ObjectId WarehouseId;
    private String WarehouseName;
    private String Warehouselocation;
    private String Warehousecontact;
    private String Warehouseemail;
    private WarehouseProduceDirectory produceDirectory;
    private String WarehouseAdminId;
    private String WarehouseManageName;

    public RestaurantService getRestaurantService() {
        return RestaurantService;
    }

    public void setRestaurantService(RestaurantService RestaurantService) {
        this.RestaurantService = RestaurantService;
    }

    RestaurantService RestaurantService = new RestaurantService();

    public Warehouse(String RestaurantName, String RestaurantAdminId, String RestaurantAddress, String RestaurantContact, String RestaurantEmail) {
        this.WarehouseName = RestaurantName;
        this.produceDirectory = new WarehouseProduceDirectory();
        this.WarehouseAdminId = RestaurantAdminId;
        this.Warehouselocation = RestaurantAddress;
        this.Warehousecontact = RestaurantContact;
        this.Warehouseemail = RestaurantEmail;
    }

    public Warehouse(Document organization, Document userLogin) {
        this.WarehouseId = organization.getObjectId("_id");
        this.WarehouseName = organization.getString("warehouseName");
        this.Warehouselocation = organization.getString("warehouseAddress");
        this.Warehousecontact = organization.getString("warehouseContact");
        this.Warehouseemail = organization.getString("warehouseEmail");
        this.produceDirectory = new WarehouseProduceDirectory();
        this.WarehouseAdminId = userLogin.getString("username");
        
    }

    private void updateQuantity(int quantity, WarehouseProduce produce) {

        if (produceDirectory.findProduce(produce.getProduceName()) != null) {
            produce.updateQuantity(quantity);
            System.out.println("produce quantity updated");
            return;
        }
        System.out.println("Produce does not exist");
    }

    private WarehouseProduceDirectory getProduceList() {
        return produceDirectory;
    }

    private WarehouseProduceDirectory getProducesByCategory(String category) {
        WarehouseProduceDirectory pd = new WarehouseProduceDirectory();
        for (WarehouseProduce prod : produceDirectory.getProduceList()) {
            if (prod.getProduceCategory().equalsIgnoreCase(category)) {
                pd.addProduce(prod);
            }
        }
        return pd;
    }

    private ArrayList<String> getCategoryList() {
        return produceDirectory.getCategoryList();
    }

    public boolean isMatch(String warehouseName) {
        return this.WarehouseName.equalsIgnoreCase(warehouseName);
    }

    public boolean authenticateAdmin(String adminUserName) {
        if (isMatch(adminUserName)) {
            return true;
        }
        return false;
    }

    public WarehouseProduceDirectory getProduceDirectory() {
        return produceDirectory;
    }

    public void setProduceDirectory(WarehouseProduceDirectory produceDirectory) {
        this.produceDirectory = produceDirectory;
    }

    @Override
    public String toString() {
        return WarehouseName;
    }

    public Document toDocument() {
        return new Document("RestaurantName", WarehouseName)
                .append("RestaurantAddress", Warehouselocation)
                .append("RestaurantContact", Warehousecontact)
                .append("RestaurantEmail", Warehouseemail)
                .append("RestaurantAdminId", WarehouseAdminId);
    }
}
