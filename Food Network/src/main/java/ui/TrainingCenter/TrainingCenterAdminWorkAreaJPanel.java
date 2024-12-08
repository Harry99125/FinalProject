/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.TrainingCenter;

import com.mongodb.client.MongoDatabase;
import database.Connection;

import java.awt.CardLayout;
import javax.swing.JPanel;
import model.Business.Business;
import model.TrainingCenter.TrainingCenter;
import ui.MainLoginJPanel;


public class TrainingCenterAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TrainingCenterAdminWorkAreaJPanel
     */
    JPanel CardSequencePanel;
    Business business;
    TrainingCenter trainingcenter;
    MongoDatabase database;

    public TrainingCenterAdminWorkAreaJPanel(JPanel cardSequencePanel, TrainingCenter trainingcenter, MongoDatabase database, Business business) {
        initComponents();
        this.CardSequencePanel = cardSequencePanel;
        this.trainingcenter = trainingcenter;
        this.database = database;
        populateTrainingCenterDetails();
        txtTrainingCenterName.setEnabled(false);
        txtTrainingCenterManagerName.setEnabled(false);
        btnSave.setEnabled(false);
        setFlag(false);
    }

    private void setFlag(boolean b) {
        txtTrainingCenterAddress.setEnabled(b);
        txtTrainingCenterContact.setEnabled(b);
        txtTrainingCenterEmail.setEnabled(b);
    }

    private void populateTrainingCenterDetails() {
        txtTrainingCenterName.setText(trainingcenter.getTrainingCenterName());
        txtTrainingCenterAddress.setText(trainingcenter.getTrainingCenterLocation());
        txtTrainingCenterContact.setText(trainingcenter.getTrainingCenterContact());
        txtTrainingCenterEmail.setText(trainingcenter.getTrainingCenterEmail());
        String managerName = trainingcenter.getTrainingCenterManagerName();
        System.out.println("Manager Name: " + managerName);
        txtTrainingCenterManagerName.setText(trainingcenter.getTrainingCenterManagerName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        TrainingCenterControlPanel = new javax.swing.JPanel();
        btnResidentDoctor = new javax.swing.JButton();
        btnCourseList = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnChat = new javax.swing.JButton();
        TrainingCenterCardLayout = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblTCName = new javax.swing.JLabel();
        lblTCLocation = new javax.swing.JLabel();
        lblTCContact = new javax.swing.JLabel();
        lblTCEmail = new javax.swing.JLabel();
        txtTrainingCenterName = new javax.swing.JTextField();
        txtTrainingCenterAddress = new javax.swing.JTextField();
        txtTrainingCenterContact = new javax.swing.JTextField();
        txtTrainingCenterEmail = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblTrainingCenterDetails = new javax.swing.JLabel();
        txtTrainingCenterManagerName = new javax.swing.JTextField();
        lblTCManagerName = new javax.swing.JLabel();

        jSplitPane1.setDividerLocation(150);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        TrainingCenterControlPanel.setBackground(new java.awt.Color(150, 83, 178));

        btnResidentDoctor.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnResidentDoctor.setText("Resident Doctor");
        btnResidentDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResidentDoctorActionPerformed(evt);
            }
        });

        btnCourseList.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnCourseList.setText("Course List");
        btnCourseList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCourseListActionPerformed(evt);
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
                btnChatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TrainingCenterControlPanelLayout = new javax.swing.GroupLayout(TrainingCenterControlPanel);
        TrainingCenterControlPanel.setLayout(TrainingCenterControlPanelLayout);
        TrainingCenterControlPanelLayout.setHorizontalGroup(
            TrainingCenterControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrainingCenterControlPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnResidentDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnCourseList)
                .addGap(26, 26, 26)
                .addComponent(btnChat, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(TrainingCenterControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        TrainingCenterControlPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnChat, btnCourseList, btnLogout, btnResidentDoctor});

        TrainingCenterControlPanelLayout.setVerticalGroup(
            TrainingCenterControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrainingCenterControlPanelLayout.createSequentialGroup()
                .addGroup(TrainingCenterControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TrainingCenterControlPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnLogout))
                    .addGroup(TrainingCenterControlPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(TrainingCenterControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChat)
                            .addComponent(btnResidentDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCourseList))))
                .addGap(30, 30, 30))
        );

        TrainingCenterControlPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnChat, btnCourseList, btnLogout, btnResidentDoctor});

        jSplitPane1.setTopComponent(TrainingCenterControlPanel);

        TrainingCenterCardLayout.setLayout(new java.awt.CardLayout());

        jPanel3.setBackground(new java.awt.Color(241, 206, 255));

        lblTCName.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblTCName.setText("Name :");

        lblTCLocation.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblTCLocation.setText("Location :");

        lblTCContact.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblTCContact.setText("Contact :");

        lblTCEmail.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblTCEmail.setText("Email :");

        txtTrainingCenterAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrainingCenterAddressActionPerformed(evt);
            }
        });

        txtTrainingCenterEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrainingCenterEmailActionPerformed(evt);
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

        btnSave.setBackground(new java.awt.Color(150, 83, 178));
        btnSave.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblTrainingCenterDetails.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblTrainingCenterDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrainingCenterDetails.setText("TRAINING CENTER DETAILS");
        lblTrainingCenterDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTrainingCenterManagerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrainingCenterManagerNameActionPerformed(evt);
            }
        });

        lblTCManagerName.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblTCManagerName.setText("Manager Name :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblTrainingCenterDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTCEmail)
                            .addComponent(lblTCContact)
                            .addComponent(lblTCLocation)
                            .addComponent(lblTCName)
                            .addComponent(lblTCManagerName))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtTrainingCenterAddress)
                            .addComponent(txtTrainingCenterContact)
                            .addComponent(txtTrainingCenterEmail)
                            .addComponent(txtTrainingCenterName, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(txtTrainingCenterManagerName, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(150, 150, 150))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtTrainingCenterAddress, txtTrainingCenterContact, txtTrainingCenterEmail, txtTrainingCenterName});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblTrainingCenterDetails)
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTCName)
                    .addComponent(txtTrainingCenterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTCContact)
                        .addGap(18, 18, 18)
                        .addComponent(lblTCEmail)
                        .addGap(18, 18, 18)
                        .addComponent(lblTCManagerName))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrainingCenterAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTCLocation))
                        .addGap(18, 18, 18)
                        .addComponent(txtTrainingCenterContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTrainingCenterEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTrainingCenterManagerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEdit, btnSave});

        TrainingCenterCardLayout.add(jPanel3, "card2");

        jSplitPane1.setRightComponent(TrainingCenterCardLayout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTrainingCenterEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrainingCenterEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrainingCenterEmailActionPerformed

    private void txtTrainingCenterAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrainingCenterAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrainingCenterAddressActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        setFlag(true);
        btnSave.setEnabled(true);
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        trainingcenter.setTrainingCenterAddress(txtTrainingCenterAddress.getText());
        trainingcenter.setTrainingCenterContact(txtTrainingCenterContact.getText());
        trainingcenter.setTrainingCenterEmail(txtTrainingCenterEmail.getText());
        trainingcenter.updateTrainingCenter(trainingcenter, database);
        btnSave.setEnabled(false);
        setFlag(false);
    }

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here
        MainLoginJPanel mainLoginJPanel = new MainLoginJPanel(CardSequencePanel, business, "TrainingCenter", new Connection().connectToDatabase());
        CardSequencePanel.add("MainLoginJPanel", mainLoginJPanel);
        CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
        layout.next(CardSequencePanel);
    }//GEN-LAST:event_btnLogoutActionPerformed


    private void txtTrainingCenterManagerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrainingCenterManagerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrainingCenterManagerNameActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        TrainingCenterAdminWorkAreaJPanel trainingCenterAdminWorkAreaJPanel = new TrainingCenterAdminWorkAreaJPanel(CardSequencePanel, trainingcenter, database, business);
        CardSequencePanel.add("TrainingCenterAdminWorkAreaJPanel", trainingCenterAdminWorkAreaJPanel);
        CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
        layout.next(CardSequencePanel);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnResidentDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResidentDoctorActionPerformed
        // TODO add your handling code here:

        ResidentDoctorJPanel residentDoctorJPanel = new ResidentDoctorJPanel(TrainingCenterCardLayout, trainingcenter, database, business);
        TrainingCenterCardLayout.add("ResidentDoctorJPanel", residentDoctorJPanel);
        CardLayout layout = (CardLayout) TrainingCenterCardLayout.getLayout();
        layout.next(TrainingCenterCardLayout);

    }//GEN-LAST:event_btnResidentDoctorActionPerformed

    private void btnCourseListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCourseListActionPerformed
        // TODO add your handling code here:

        CourseListJPanel courseListJPanel = new CourseListJPanel(TrainingCenterCardLayout, trainingcenter, database, business);
        TrainingCenterCardLayout.add("CourseListJPanel", courseListJPanel);
        CardLayout layout = (CardLayout) TrainingCenterCardLayout.getLayout();
        layout.next(TrainingCenterCardLayout);

    }//GEN-LAST:event_btnCourseListActionPerformed

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
        // TODO add your handling code here:
        ChatRoomListJPanel chatRoomListJPanel = new ChatRoomListJPanel(TrainingCenterCardLayout, trainingcenter);
        TrainingCenterCardLayout.add("chatRoomListJPanel", chatRoomListJPanel);
        CardLayout layout = (CardLayout) TrainingCenterCardLayout.getLayout();
        layout.next(TrainingCenterCardLayout);
    }//GEN-LAST:event_btnChatActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TrainingCenterCardLayout;
    private javax.swing.JPanel TrainingCenterControlPanel;
    private javax.swing.JButton btnChat;
    private javax.swing.JButton btnCourseList;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnResidentDoctor;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblTCContact;
    private javax.swing.JLabel lblTCEmail;
    private javax.swing.JLabel lblTCLocation;
    private javax.swing.JLabel lblTCManagerName;
    private javax.swing.JLabel lblTCName;
    private javax.swing.JLabel lblTrainingCenterDetails;
    private javax.swing.JTextField txtTrainingCenterAddress;
    private javax.swing.JTextField txtTrainingCenterContact;
    private javax.swing.JTextField txtTrainingCenterEmail;
    private javax.swing.JTextField txtTrainingCenterManagerName;
    private javax.swing.JTextField txtTrainingCenterName;
    // End of variables declaration//GEN-END:variables
}