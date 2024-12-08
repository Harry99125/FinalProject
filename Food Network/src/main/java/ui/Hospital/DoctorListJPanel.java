/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Hospital;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Business.Business;
import model.Hospital.Hospital;
import org.bson.Document;


public class DoctorListJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorListJPanel
     */
    JPanel hospitalCardLayout;
    Business business;
    Hospital hospital;
    MongoDatabase database;
    CRUDOperations crud = new CRUDOperations();
    MongoCollection<Document> doctorCollection;
    public DoctorListJPanel(JPanel hospitalCardLayout,Hospital hospital,MongoDatabase database, Business business) {
        initComponents();
        this.hospitalCardLayout = hospitalCardLayout;
        this.hospital = hospital;
        this.database = new Connection().connectToDatabase();
        populateTableDoctorList();
        this.doctorCollection = this.database.getCollection("Doctor");
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
        tblDoctorList = new javax.swing.JTable();
        btnAddDoctor = new javax.swing.JButton();
        btnPatients = new javax.swing.JButton();
        lblBlogPostHeader = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 228, 230));

        tblDoctorList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Speciality", "Is Resident", "Is Instructor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDoctorList);
        if (tblDoctorList.getColumnModel().getColumnCount() > 0) {
            tblDoctorList.getColumnModel().getColumn(0).setResizable(false);
            tblDoctorList.getColumnModel().getColumn(1).setResizable(false);
            tblDoctorList.getColumnModel().getColumn(2).setResizable(false);
            tblDoctorList.getColumnModel().getColumn(3).setResizable(false);
        }

        btnAddDoctor.setBackground(new java.awt.Color(244, 63, 94));
        btnAddDoctor.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddDoctor.setForeground(new java.awt.Color(255, 255, 255));
        btnAddDoctor.setText("Add Doctor");
        btnAddDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDoctorActionPerformed(evt);
            }
        });

        btnPatients.setBackground(new java.awt.Color(0, 153, 51));
        btnPatients.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnPatients.setForeground(new java.awt.Color(255, 255, 255));
        btnPatients.setText("Patients");
        btnPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientsActionPerformed(evt);
            }
        });

        lblBlogPostHeader.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblBlogPostHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBlogPostHeader.setText("Doctor List");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnPatients, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(lblBlogPostHeader)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblBlogPostHeader)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPatients))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddDoctor, btnPatients});

    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDoctorActionPerformed
        // TODO add your handling code here:
        AddDoctorJPanel addDoctorJPanel = new AddDoctorJPanel(hospitalCardLayout, hospital, database, business);
        hospitalCardLayout.add("AddDoctorJPanel", addDoctorJPanel);
        CardLayout layout = (CardLayout) hospitalCardLayout.getLayout();
        layout.next(hospitalCardLayout);
    }//GEN-LAST:event_btnAddDoctorActionPerformed

    private void btnPatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientsActionPerformed
         // Get the selected row index
        int selectedRowIndex = tblDoctorList.getSelectedRow();

        // Check if a row is actually selected
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a doctor from the list first.", "No Doctor Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Retrieve the doctor's name from the selected row (assuming column 0 holds the doctorName)
        String selectedDoctorName = (String) tblDoctorList.getValueAt(selectedRowIndex, 0);

        // Create and show the PatientsJPanel, passing the selected doctor's name
        PatientsJPanel patientsJPanel = new PatientsJPanel(hospitalCardLayout, hospital, database, business, selectedDoctorName);
        hospitalCardLayout.add("PatientsJPanel", patientsJPanel);
        CardLayout layout = (CardLayout) hospitalCardLayout.getLayout();
        layout.next(hospitalCardLayout);
    }//GEN-LAST:event_btnPatientsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDoctor;
    private javax.swing.JButton btnPatients;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBlogPostHeader;
    private javax.swing.JTable tblDoctorList;
    // End of variables declaration//GEN-END:variables

    private void populateTableDoctorList() {
        DefaultTableModel model = (DefaultTableModel) tblDoctorList.getModel();
        model.setRowCount(0);  // Clear existing data

        String hospitalId = hospital.getHospitalId().toString();  // Get hospital ID from the hospital object
        System.out.println("Hospital ID: " + hospitalId);

        // Ensure the doctorCollection is properly initialized before using it
        if (doctorCollection == null) {
            doctorCollection = database.getCollection("Doctor");
        }

        // Query the database for doctors associated with the hospitalId
        FindIterable<Document> findIterable = crud.getRecordsByKey("hospitalId", hospitalId, doctorCollection);
        try (MongoCursor<Document> cursor = findIterable.iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println(doc.toJson());  // Output the document to the console

                Object[] row = new Object[4];  // Prepare a row for the table
                row[0] = doc.getString("doctorName");  // Doctor's name
                row[1] = doc.getString("doctorSpecialization");  // Doctor's specialization
                row[2] = doc.getBoolean("isResidentDoctor", false);  // Default to false if not specified
                row[3] = doc.getBoolean("isInstructor", false);  // Default to false if not specified
                model.addRow(row);  // Add row to the table model
            }
        } catch (Exception e) {
            e.printStackTrace();  // Print stack trace for debugging
            // Consider user feedback here, such as a dialog box or a status message
        }
    }

}