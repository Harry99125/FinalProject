/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.medicalEquipment;

import model.MedicalEquipment.MedicalEquipmentSupplier;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;

import java.awt.CardLayout;

import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class ChatRoom extends javax.swing.JPanel {

    /**
     * Creates new form ChatRoom
     */
    JPanel cardSequencePanel;
    MedicalEquipmentSupplier medicalEquipmentSupplier;
    MongoDatabase database;
    MongoCollection<Document> chatRoomCollection;
    MongoCollection<Document> chatCollection;
    MongoCollection<Document> userCollection;
    CRUDOperations crud = new CRUDOperations();
    ObjectId userId;
    String selectedChatRoom;

    public ChatRoom(JPanel cardSequencePanel, MedicalEquipmentSupplier medicalEquipmentSupplier, String selectedChatRoom) throws IOException {
        initComponents();
        this.cardSequencePanel = cardSequencePanel;
        this.medicalEquipmentSupplier = medicalEquipmentSupplier;
        this.selectedChatRoom = selectedChatRoom;
        this.database = new Connection().connectToDatabase();
        this.chatRoomCollection = database.getCollection("ChatRoom");
        this.chatCollection = database.getCollection("Chat");
        this.userCollection = database.getCollection("UserLogin");
        this.userId = crud.getFirstRecordByKey("name", medicalEquipmentSupplier.getMedicalEquipmentManagerId(), userCollection).getObjectId("_id");
        chatArea.setEditable(false);
        populateChatArea();
        populateUserList();
    }

    private void populateUserList() {
        // Get the chat room document from the database
        Document chatRoom = crud.getFirstRecordByKey("chatName", selectedChatRoom, chatRoomCollection);

        if (chatRoom == null) {
            return;
        }

        // Get the list of user ids from the chat room document
        List<String> userIds = (List<String>) chatRoom.get("users");

        // Create a DefaultListModel to hold the user names
        DefaultListModel<String> userListModel = new DefaultListModel<>();

        // Loop through the user ids and fetch the corresponding user details
        for (String userId : userIds) {
            ObjectId userObjectId = new ObjectId(userId);
            Document userDoc = crud.getFirstRecordByKey("_id", userObjectId, userCollection);
            if (userDoc != null) {
                // Add the user name to the list model
                userListModel.addElement(userDoc.getString("name"));
            }
        }

        // Set the model for the userList JList
        userList.setModel(userListModel);
    }

    public void populateChatArea() throws IOException {
        Document chatRoom = crud.getFirstRecordByKey("chatName", selectedChatRoom, chatRoomCollection);
        if (chatRoom == null) {
            return;
        }
        List<String> chatHistory = (List<String>) chatRoom.get("chatHistory");

        BufferedWriter writer = new BufferedWriter(new FileWriter("chat.html"));
        writer.write("<html><body>");

        for (String chat : chatHistory) {
            ObjectId chatId = new ObjectId(chat);
            System.out.println(chat);
            Document chatDoc = crud.getFirstRecordByKey("_id", chatId, chatCollection);
            if (chatDoc == null) {
                continue;
            }
            ObjectId messageUserId = new ObjectId(chatDoc.getString("userId"));
            Document userDoc = crud.getFirstRecordByKey("_id", messageUserId, userCollection);

            String color = generateColor(userDoc.getString("name"));
            String timestamp = chatDoc.getString("timestamp"); // assuming the timestamp is stored in the chat document
            String messageAlignment = (messageUserId.equals(this.userId)) ? "right" : "left";

            String newText = "<div style='text-align: " + messageAlignment + ";'>"
                    + "<font color='" + color + "'>" + userDoc.getString("name") + "</font>: "
                    + chatDoc.getString("message") + " <small>" + timestamp + "</small><br></div>";
            writer.write(newText);
        }

        writer.write("</body></html>");
        writer.close();
        System.out.println("Chat history populated");

// set text to chat area
        String htmlContent = new String(Files.readAllBytes(new java.io.File("chat.html").toPath()));
        chatArea.setContentType("text/html");
        chatArea.setText(htmlContent);
    }

    private String generateColor(String name) {
        Random rand = new Random(name.hashCode());
        String color = String.format("#%06x", rand.nextInt(0xff88ae));
        return color;
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
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JEditorPane();
        btnBack = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        btnAddUser = new javax.swing.JButton();

        jSplitPane1.setDividerLocation(900);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(900, 537));

        jPanel1.setBackground(new java.awt.Color(255, 223, 164));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField1.setText("Type here");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        btnSend.setBackground(new java.awt.Color(255, 102, 0));
        btnSend.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnSend.setForeground(new java.awt.Color(255, 255, 255));
        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ChatRoomName");

        jScrollPane2.setViewportView(chatArea);

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSend, jTextField1});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBack, jLabel1});

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        userList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        userList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        userList.setName("USERLIST"); // NOI18N
        userList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userList);
        userList.getAccessibleContext().setAccessibleDescription("");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Users");

        btnAddUser.setBackground(new java.awt.Color(0, 0, 0));
        btnAddUser.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddUser.setForeground(new java.awt.Color(255, 255, 255));
        btnAddUser.setText("Add User");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1219, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        String message = jTextField1.getText();
        Document chatRoom = crud.getFirstRecordByKey("chatName", selectedChatRoom, chatRoomCollection);
        if (chatRoom == null) {
            return;
        }
        System.out.println("dfcgv");
        List<String> chatHistory = (List<String>) chatRoom.get("chatHistory");
        Document chat = new Document();
        chat.append("chatRoomId", selectedChatRoom);
        chat.append("userId", userId.toString());
        chat.append("message", message);
//        append timestamp
        Date date = new Date();
        chat.append("timestamp", date.toString());
        crud.insertDocument(chat, chatCollection);
        ObjectId chatId = crud.getFirstRecordByKey("timestamp", date.toString(), chatCollection).getObjectId("_id");
        chatHistory.add(chatId.toString());
        chatRoom.append("chatHistory", chatHistory);
        crud.updateArrayById(chatRoom.getObjectId("_id"), "chatHistory", chatId.toString(), chatRoomCollection);
        jTextField1.setText("");
        try {
            populateChatArea();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnSendActionPerformed

    private void userListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userListMouseClicked
        // TODO add your handling code here:
        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 2) { // Double-click detected
            int index = list.locationToIndex(evt.getPoint());
            String selectedUser = list.getModel().getElementAt(index).toString();
            ObjectId userObjectId = new ObjectId("661c7b0c2e8985ba7583b958");
            Document userDoc = crud.getFirstRecordByKey("_id", userObjectId, userCollection);
            if (userDoc != null) {
                String userDetails = "Name: " + userDoc.getString("name") + "\n"
                        + "Other details: " + userDoc.getString("otherDetails"); // replace with actual fields
                JOptionPane.showMessageDialog(null, userDetails, "User Details", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_userListMouseClicked

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        // TODO add your handling code here:
        String userName = JOptionPane.showInputDialog(null, "Enter the name of the user to add to the chat room", "Add User", JOptionPane.QUESTION_MESSAGE);
        if (userName == null || userName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "User name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        check if the user exists
        Document userDoc = crud.getFirstRecordByKey("name", userName, userCollection);
        if (userDoc == null) {
            JOptionPane.showMessageDialog(null, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        get the chat room document
        Document chatRoom = crud.getFirstRecordByKey("chatName", selectedChatRoom, chatRoomCollection);
        if (chatRoom == null) {
            return;
        }
//        get the list of user ids from the chat room document
        List<String> userIds = (List<String>) chatRoom.get("users");
//        check if the user is already in the chat room
        if (userIds.contains(userDoc.getObjectId("_id").toString())) {
            JOptionPane.showMessageDialog(null, "User already in the chat room", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        add the user to the chat room
        userIds.add(userDoc.getObjectId("_id").toString());
        crud.updateArrayById(chatRoom.getObjectId("_id"), "users", userDoc.getObjectId("_id").toString(), chatRoomCollection);
        populateUserList();

    }//GEN-LAST:event_btnAddUserActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
//        if pressed enter key
        if (evt.getKeyCode() == 10) {
//            send btn
            btnSend.doClick();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        ChatRoomListJPanel chatRoomListJPanel = new ChatRoomListJPanel(cardSequencePanel, medicalEquipmentSupplier);
        cardSequencePanel.add("chatRoomListJPanel", chatRoomListJPanel);
        CardLayout layout = (CardLayout) cardSequencePanel.getLayout();
        layout.next(cardSequencePanel);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSend;
    private javax.swing.JEditorPane chatArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList<String> userList;
    // End of variables declaration//GEN-END:variables
}
