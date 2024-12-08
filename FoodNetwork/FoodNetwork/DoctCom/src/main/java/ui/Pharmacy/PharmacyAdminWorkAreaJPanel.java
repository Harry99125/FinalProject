/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Pharmacy;

import com.google.maps.GeoApiContext;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AutocompletePrediction;

import java.awt.CardLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.Connection;

import java.awt.event.ItemEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.Business.Business;
import model.Pharmacy.Pharmacy;
import org.bson.Document;
import ui.LoginJFrame;
import ui.MainLoginJPanel;


public class PharmacyAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PharmacyAdminWorkAreaJPanel
     */
    JPanel CardSequencePanel;
    Business business;
    Pharmacy pharmacy;
    MongoDatabase database;
    private boolean isUpdating;

    public PharmacyAdminWorkAreaJPanel(JPanel cardSequencePanel, Pharmacy pharmacy, MongoDatabase database) {
        initComponents();
        this.CardSequencePanel = cardSequencePanel;
        this.pharmacy = pharmacy;
        this.database = database;
        populatePharmacyDetails();
        isUpdating = true;
        txtPharmacyName.setEnabled(false);
        txtPharmacyManagerName.setEnabled(false);
        btnSave.setEnabled(false);
        setFlag(false);
        //System.out.println(pharmacy.getId());
    }

    private void setFlag(boolean b) {
        txtPharmacyAddress.setEnabled(b);
        txtPharmacyContact.setEnabled(b);
        txtPharmacyEmail.setEnabled(b);
    }

    private void populatePharmacyDetails() {
        txtPharmacyName.setText(pharmacy.getPharmacyName());
        txtPharmacyAddress.setText(pharmacy.getPharmacyAddress());
        txtPharmacyContact.setText(pharmacy.getPharmacyContact());
        txtPharmacyEmail.setText(pharmacy.getPharmacyEmail());
        txtPharmacyManagerName.setText(pharmacy.getPharmacyManagerName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        PharmacyCardLayout = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblPharmacyName = new javax.swing.JLabel();
        lblPharmacyAddress = new javax.swing.JLabel();
        lblPharmacyContact = new javax.swing.JLabel();
        lblPharmacyEmail = new javax.swing.JLabel();
        lblPharmacyManagerName = new javax.swing.JLabel();
        txtPharmacyName = new javax.swing.JTextField();
        txtPharmacyContact = new javax.swing.JTextField();
        txtPharmacyEmail = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        txtPharmacyManagerName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        lblPharmacyDetails = new javax.swing.JLabel();
        txtPharmacyAddress = new javax.swing.JTextField();
        AutoCompleteCmb = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnMedicineList = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnChat = new javax.swing.JButton();

        jSplitPane2.setDividerLocation(150);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        PharmacyCardLayout.setLayout(new java.awt.CardLayout());

        jPanel4.setBackground(new java.awt.Color(206, 238, 251));

        lblPharmacyName.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblPharmacyName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPharmacyName.setText("Name :");

        lblPharmacyAddress.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblPharmacyAddress.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPharmacyAddress.setText("Location :");

        lblPharmacyContact.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblPharmacyContact.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPharmacyContact.setText("Contact :");

        lblPharmacyEmail.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblPharmacyEmail.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPharmacyEmail.setText("Email :");

        lblPharmacyManagerName.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblPharmacyManagerName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPharmacyManagerName.setText("Manager Name :");

        txtPharmacyName.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        txtPharmacyContact.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        txtPharmacyEmail.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtPharmacyEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPharmacyEmailActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 0, 0));
        btnEdit.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        txtPharmacyManagerName.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        btnSave.setBackground(new java.awt.Color(0, 153, 204));
        btnSave.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblPharmacyDetails.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblPharmacyDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPharmacyDetails.setText("PHARMACY DETAILS");
        lblPharmacyDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPharmacyAddress.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtPharmacyAddress.setMinimumSize(new java.awt.Dimension(40, 23));
        txtPharmacyAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPharmacyAddressKeyReleased(evt);
            }
        });

        AutoCompleteCmb.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        AutoCompleteCmb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AutoCompleteCmbMousePressed(evt);
            }
        });
        AutoCompleteCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoCompleteCmbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPharmacyDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPharmacyContact)
                                .addComponent(lblPharmacyEmail)
                                .addComponent(lblPharmacyManagerName))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtPharmacyContact, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                .addComponent(txtPharmacyEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                .addComponent(txtPharmacyManagerName, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPharmacyName)
                                .addComponent(lblPharmacyAddress))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPharmacyName, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                .addComponent(txtPharmacyAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addComponent(AutoCompleteCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(180, 180, 180))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblPharmacyAddress, lblPharmacyContact, lblPharmacyEmail, lblPharmacyManagerName, lblPharmacyName});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AutoCompleteCmb, txtPharmacyAddress, txtPharmacyContact, txtPharmacyEmail, txtPharmacyManagerName, txtPharmacyName});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblPharmacyDetails)
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPharmacyName)
                    .addComponent(txtPharmacyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPharmacyAddress)
                    .addComponent(txtPharmacyAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(AutoCompleteCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPharmacyContact)
                    .addComponent(txtPharmacyContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPharmacyEmail)
                    .addComponent(txtPharmacyEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPharmacyManagerName)
                    .addComponent(txtPharmacyManagerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblPharmacyAddress, lblPharmacyContact, lblPharmacyEmail, lblPharmacyManagerName, lblPharmacyName});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AutoCompleteCmb, txtPharmacyAddress, txtPharmacyContact, txtPharmacyEmail, txtPharmacyManagerName, txtPharmacyName});

        PharmacyCardLayout.add(jPanel4, "card2");

        jSplitPane2.setRightComponent(PharmacyCardLayout);

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));

        btnMedicineList.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnMedicineList.setText("Medicine List");
        btnMedicineList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicineListActionPerformed(evt);
            }
        });

        btnHome.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnChat.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnChat.setText("Chat");
        btnChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnChatActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMedicineList, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(139, 139, 139)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(221, 221, 221))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnChat, btnHome, btnLogout, btnMedicineList});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome)
                    .addComponent(btnMedicineList, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnChat, btnHome, btnLogout, btnMedicineList});

        jSplitPane2.setTopComponent(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPharmacyEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPharmacyEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPharmacyEmailActionPerformed

    private void btnMedicineListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicineListActionPerformed
        // TODO add your handling code here:
        MedicineListJPanel medicineListJPanel = new MedicineListJPanel(PharmacyCardLayout, business, pharmacy, database);
        PharmacyCardLayout.add("MedicineListJPanel", medicineListJPanel);
        CardLayout layout = (CardLayout) PharmacyCardLayout.getLayout();
        layout.next(PharmacyCardLayout);
    }//GEN-LAST:event_btnMedicineListActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        setFlag(true);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        pharmacy.setPharmacyAddress(txtPharmacyAddress.getText());
        pharmacy.setPharmacyContact(txtPharmacyContact.getText());
        pharmacy.setPharmacyEmail(txtPharmacyEmail.getText());
        pharmacy.updatePharmacy(pharmacy, database);
        btnSave.setEnabled(false);
        setFlag(false);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        MainLoginJPanel mainLoginJPanel = new MainLoginJPanel(CardSequencePanel, business, "Pharmacy", new Connection().connectToDatabase());
        CardSequencePanel.add("MainLoginJPanel", mainLoginJPanel);
        CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
        layout.next(CardSequencePanel);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        PharmacyAdminWorkAreaJPanel pharmacyAdminWorkAreaJPanel = new PharmacyAdminWorkAreaJPanel(CardSequencePanel, pharmacy, database);
        CardSequencePanel.add("PharmacyAdminWorkAreaJPanel", pharmacyAdminWorkAreaJPanel);
        CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
        layout.next(CardSequencePanel);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void txtPharmacyAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPharmacyAddressKeyReleased
        // TODO add your handling code here:
        AutoCompleteCmb.removeAllItems();
        String input = txtPharmacyAddress.getText();
        if (!input.isEmpty()) {
            try {
                List<String> suggestions = getPlaceAutocomplete(input);
                for (String suggestion : suggestions) {
                    AutoCompleteCmb.addItem(suggestion);
                }
            } catch (ApiException | IOException | InterruptedException ex) {
                throw new RuntimeException("Error getting place autocomplete", ex);
            }
        }
    }//GEN-LAST:event_txtPharmacyAddressKeyReleased

    private void AutoCompleteCmbMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoCompleteCmbMousePressed
        // TODO add your handling code here:
        String selectedItem = AutoCompleteCmb.getSelectedItem().toString();
        txtPharmacyAddress.setText(selectedItem);
    }//GEN-LAST:event_AutoCompleteCmbMousePressed

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_btnChatActionPerformed
        // TODO add your handling code here:
        ChatRoomListJPanel chatRoomListJPanel = new ChatRoomListJPanel(PharmacyCardLayout, pharmacy);
        PharmacyCardLayout.add("chatRoomListJPanel", chatRoomListJPanel);
        CardLayout layout = (CardLayout) PharmacyCardLayout.getLayout();
        layout.next(PharmacyCardLayout);
    }//GEN-LAST:event_btnChatActionPerformed

    private void AutoCompleteCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoCompleteCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AutoCompleteCmbActionPerformed

    public List<String> getPlaceAutocomplete(String input) throws IOException, InterruptedException, ApiException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyB1G-S3Qc1lFEZXojKnTMphuRjyN86woh4")
                .build();
        PlaceAutocompleteRequest.SessionToken token = new PlaceAutocompleteRequest.SessionToken();

        AutocompletePrediction[] predictions = PlacesApi.placeAutocomplete(context, input, token).await();

        List<String> suggestions = new ArrayList<>();
        for (AutocompletePrediction prediction : predictions) {
            suggestions.add(prediction.description);
        }

        return suggestions;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AutoCompleteCmb;
    private javax.swing.JPanel PharmacyCardLayout;
    private javax.swing.JButton btnChat;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMedicineList;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel lblPharmacyAddress;
    private javax.swing.JLabel lblPharmacyContact;
    private javax.swing.JLabel lblPharmacyDetails;
    private javax.swing.JLabel lblPharmacyEmail;
    private javax.swing.JLabel lblPharmacyManagerName;
    private javax.swing.JLabel lblPharmacyName;
    private javax.swing.JTextField txtPharmacyAddress;
    private javax.swing.JTextField txtPharmacyContact;
    private javax.swing.JTextField txtPharmacyEmail;
    private javax.swing.JTextField txtPharmacyManagerName;
    private javax.swing.JTextField txtPharmacyName;
    // End of variables declaration//GEN-END:variables

}
