/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Warehouse;

import ui.Restaurant.*;
import ui.Farmer.*;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.opencsv.CSVWriter;
import database.CRUDOperations;
import database.Connection;
import model.Business.Business;
import model.Farmer.Farmer;
import model.Farmer.Produce;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Restaurant.Restaurant;
import model.Warehouse.Warehouse;
import service.FileSaver;


public class WarehousePListJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WarehousePListJPanel
     */
    JPanel cardSequencePanel;
    Business business;
    Warehouse warehouse;
    MongoDatabase database;
    MongoCollection<Document> collection;
    MongoCollection<Document> produceCollection;
     MongoCollection<Document> FarmCollection;
      MongoCollection<Document> FactoryCollection;
    CRUDOperations crud = new CRUDOperations();

    public WarehousePListJPanel(JPanel cardSequencePanel, Business business, Warehouse warehouse, MongoDatabase prevdatabase) {
        initComponents();
        this.cardSequencePanel = cardSequencePanel;
        this.business = business;
        this.warehouse = warehouse;
        this.database = new Connection().connectToDatabase();
        this.collection = this.database.getCollection("WarehouseProduce");
        this.produceCollection = this.database.getCollection("Produce");
        this.FarmCollection=this.database.getCollection("FarmerProduce");
        this.FactoryCollection=this.database.getCollection("FactoryProduct");
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tableProduceList.getModel();
        model.setRowCount(0); // Clear existing rows in the table
       
        String farmerId = warehouse.getWarehouseId().toString();
        FindIterable<Document> farmerProduces = crud.getRecordsByKey("warehouseId", farmerId, collection);
  
        FindIterable<Document> docList=FarmCollection.find();
         try (MongoCursor<Document> cursor = docList.iterator()) {
            while (cursor.hasNext()) {
                System.out.println("yes");
                Document farmerProduceDoc = cursor.next();
                ObjectId produceId = new ObjectId(farmerProduceDoc.getString("produceId"));

                // Fetch produce details
                Document produceDoc = crud.getFirstRecordByKey("_id", produceId, produceCollection);

                if (produceDoc != null) {
                    Object[] row = new Object[]{
                        produceDoc.getString("produceName"),
                        produceDoc.getString("produceCategory"),
                        farmerProduceDoc.getInteger("stockQuantity"),
                        farmerProduceDoc.getString("farmerId")
                    };
                    model.addRow(row); // Add the row to the table model
                } else {
                    System.err.println("No produce found for ID: " + produceId);
                }
            }
            }
          FindIterable<Document> docList1=FactoryCollection.find();
         try (MongoCursor<Document> cursor = docList1.iterator()) {
            while (cursor.hasNext()) {
                System.out.println("yes");
                Document farmerProduceDoc = cursor.next();
                ObjectId produceId = new ObjectId(farmerProduceDoc.getString("productId"));

                // Fetch produce details
                Document produceDoc = crud.getFirstRecordByKey("_id", produceId, produceCollection);

                if (produceDoc != null) {
                    Object[] row = new Object[]{
                        produceDoc.getString("produceName"),
                        produceDoc.getString("produceCategory"),
                        farmerProduceDoc.getInteger("stockQuantity"),
                        farmerProduceDoc.getString("farmerId")
                    };
                    model.addRow(row); // Add the row to the table model
                } else {
                    System.err.println("No produce found for ID: " + produceId);
                }
            }
            }
         
        try (MongoCursor<Document> cursor = farmerProduces.iterator()) {
            while (cursor.hasNext()) {
                Document farmerProduceDoc = cursor.next();
                ObjectId produceId = new ObjectId(farmerProduceDoc.getString("produceId"));

                // Fetch produce details
                Document produceDoc = crud.getFirstRecordByKey("_id", produceId, produceCollection);

                if (produceDoc != null) {
                    Object[] row = new Object[]{
                        produceDoc.getString("produceName"),
                        produceDoc.getString("produceCategory"),
                        farmerProduceDoc.getInteger("quantity")
                    };
                    model.addRow(row); // Add the row to the table model
                } else {
                    System.err.println("No produce found for ID: " + produceId);
                }
            }
        } catch (Exception e) {
            System.err.println("Error populating table: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error fetching produce data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduceList = new javax.swing.JTable();
        btnGetReport = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        tableProduceList.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        tableProduceList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Category", "Quantity", "userId"
            }
        ));
        jScrollPane1.setViewportView(tableProduceList);

        btnGetReport.setBackground(new java.awt.Color(204, 0, 0));
        btnGetReport.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnGetReport.setForeground(new java.awt.Color(255, 255, 255));
        btnGetReport.setText("Get Report");
        btnGetReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGetReport, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnGetReport)
                .addContainerGap(119, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetReportActionPerformed
        // TODO add your handling code here:
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("Name");
        columnNames.add("Category");
        columnNames.add("Quantity");
        FileSaver fileSaver = new FileSaver(tableProduceList, warehouse.getWarehouseName(), columnNames);
        fileSaver.saveFile();
    }//GEN-LAST:event_btnGetReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGetReport;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProduceList;
    // End of variables declaration//GEN-END:variables

    private void populateTableByCategory(String category) {
        DefaultTableModel model = (DefaultTableModel) tableProduceList.getModel();
        model.setRowCount(0);  // Clear the table
        String farmerId = warehouse.getWarehouseId().toString();
        MongoCollection<Document> produceCollection = database.getCollection("Produce");
        FindIterable<Document> iterable;

// Check if category is not 'All' and use the correct field name
        if (!"All".equals(category)) {
            System.out.println("Filtering by category: " + category);
            iterable = produceCollection.find(Filters.eq("produceCategory", category));
        } else {
            System.out.println("Fetching all produces");
            iterable = produceCollection.find();
        }
        try (MongoCursor<Document> cursor = iterable.iterator()) {
            if (!cursor.hasNext()) {
                System.out.println("No documents found");
            }
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println("Document found: " + doc.toJson());
                ObjectId prodId = doc.getObjectId("_id");
                Document stockDoc;
                try {
                    stockDoc = crud.getRecordByTwoKeys("produceId", prodId.toString(), "warehouseId", farmerId, database.getCollection("WarehouseProduce"));
                    if (stockDoc == null || stockDoc.getInteger("quantity") == null) {
                        JOptionPane.showMessageDialog(null, "No stock data available for the selected category.", "Data Error", JOptionPane.ERROR_MESSAGE);
                        return; // Exit the method or skip adding this row
                    }
                    int stockValue = stockDoc.getInteger("stockQuantity");
                    Object[] row = new Object[]{
                        doc.getString("produceName"),
                        doc.getString("produceCategory"),
                        stockValue
                    };
                    model.addRow(row);  // Add rows to the table model
                } catch (Exception e) {
                    System.err.println("Error fetching stock data: " + e.getMessage());
                    JOptionPane.showMessageDialog(null, "Error fetching stock data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching data: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
