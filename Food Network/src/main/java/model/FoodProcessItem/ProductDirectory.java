/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.FoodProcessItem;

/**
 *
 * @author Nilay
 */
import java.util.ArrayList;
import org.bson.types.ObjectId;

public class ProductDirectory {

    private ArrayList<Product> productList;

    public ProductDirectory() {
        productList = new ArrayList<>();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public Product addProduct(String productName, ObjectId productID, String productDescription,
            String productCategory, Double productPrice, int productQuantity) {
        Product product = new Product(productName, productID, productDescription, productCategory, productPrice, productQuantity);
        productList.add(product);
        return product;
    }


    public Product addProduct(String productName, ObjectId productId, String productDescription,
            double productPrice, int productQuantity, String productCategory) {
        // Check if the product already exists in the directory
        Product existingProduct = findProduct(productName);
        if (existingProduct != null) {
            System.out.println("Product with name '" + productName + "' already exists.");
            return existingProduct;
        }

        // Create a new Product object
        Product product = new Product(productName, productId, productDescription, productCategory, productPrice, productQuantity);

        // Add the new product to the product list
        productList.add(product);

        System.out.println("Product '" + productName + "' has been added successfully.");
        return product;
    }

    public Product findProduct(String productName) {
        for (Product product : productList) {
            if (product.toString().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public ArrayList<String> getCategoryList() {
        ArrayList<String> productCatList = new ArrayList<>();
        for (Product product : productList) {
            if (!productCatList.contains(product.getProductCategory())) {
                productCatList.add(product.getProductCategory());
            }
        }
        return productCatList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

}
