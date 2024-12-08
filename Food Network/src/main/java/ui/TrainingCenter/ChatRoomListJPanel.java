/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.TrainingCenter;

import model.TrainingCenter.TrainingCenter;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;


public class ChatRoomListJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ChatRoomListJPanel
     */
    JPanel CardSequencePanel;
    TrainingCenter trainingCenter;
    MongoCollection<Document> chatRoomCollection;
    MongoDatabase database;
    MongoCollection<Document> chatCollection;
    CRUDOperations crud = new CRUDOperations();
    MongoCollection<Document> userCollection;
    ObjectId userId;

    public ChatRoomListJPanel(JPanel CardSequencePanel, TrainingCenter trainingCenter) {
        initComponents();
        this.CardSequencePanel = CardSequencePanel;
        this.trainingCenter = trainingCenter;
        database = new Connection().connectToDatabase();
        chatRoomCollection = database.getCollection("ChatRoom");
        chatCollection = database.getCollection("Chat");
        userCollection = database.getCollection("UserLogin");
        this.userId = crud.getFirstRecordByKey("name", trainingCenter.getTrainingCenterManagerName(), userCollection).getObjectId("_id");
        populateChatRooms();
    }

    private void populateChatRooms() {
        chatsList.setCellRenderer(new ChatRoomRenderer());
        DefaultListModel<String> model = new DefaultListModel<>();
        FindIterable<Document> chatRooms = crud.getRecordsByArrayContains("users", userId.toString(), chatRoomCollection);
        for (Document chatRoom : chatRooms) {
            model.addElement(chatRoom.getString("chatName"));
        }
        chatsList.setModel(model);

    }

    private class ChatRoomRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Fetch the chat room document
            Document chatRoom = crud.getFirstRecordByKey("chatName", value.toString(), chatRoomCollection);
            //check format
            Object imageField = chatRoom.get("image");
            if (imageField != null) {
                if (imageField instanceof String) {
                    String imageString = (String) imageField;
                    label.setIcon(new ImageIcon(imageString));
                    // handle string image data
                } else {
                    // Retrieve the image data from the document
                    org.bson.types.Binary imageBinary = (org.bson.types.Binary) imageField;
                    byte[] imageData = imageBinary.getData();
                    // Convert the byte array into an ImageIcon
                    ImageIcon icon = new ImageIcon(imageData);
                    // set size
                    Image image = icon.getImage(); // transform it
                    Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                    icon = new ImageIcon(newimg);

                    // Set the ImageIcon to the JLabel
                    label.setIcon(icon);
                }
            }

            // Add a border to each cell
            label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

            // Change the font of each cell
            label.setFont(new Font("Arial", Font.BOLD, 14));

            // Set the background color of each cell
            label.setBackground(Color.LIGHT_GRAY);
            label.setOpaque(true);

            return label;
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
        chatsList = new javax.swing.JList<>();
        btnAddChat = new javax.swing.JButton();

        setBackground(new java.awt.Color(241, 206, 255));

        chatsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    chatsListMouseClicked(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        jScrollPane1.setViewportView(chatsList);

        btnAddChat.setBackground(new java.awt.Color(150, 83, 178));
        btnAddChat.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAddChat.setForeground(new java.awt.Color(255, 255, 255));
        btnAddChat.setText("Add Chat");
        btnAddChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnAddChatActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddChat, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddChat, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chatsListMouseClicked(java.awt.event.MouseEvent evt) throws IOException {//GEN-FIRST:event_chatsListMouseClicked
        // TODO add your handling code here:
        String selectedChatRoom = chatsList.getSelectedValue();
        ChatRoom chatRoomUI = new ChatRoom(CardSequencePanel, trainingCenter, selectedChatRoom);
        CardSequencePanel.add("ChatRoom", chatRoomUI);
        CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
        layout.next(CardSequencePanel);
    }//GEN-LAST:event_chatsListMouseClicked

    private void btnAddChatActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_btnAddChatActionPerformed
        // TODO add your handling code here:
        String chatRoomName;
        while (true) {
            chatRoomName = JOptionPane.showInputDialog("Enter Chat Room Name");
            if (chatRoomName == null || chatRoomName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Chat Room Name cannot be empty");
            } else if (crud.getFirstRecordByKey("chatName", chatRoomName, chatRoomCollection) != null) {
                JOptionPane.showMessageDialog(null, "Chat Room with this name already exists");
            } else {
                break;
            }
        }
        Document chatRoom = new Document();
        chatRoom.append("chatName", chatRoomName);
        // array of user ids
        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> chatHistory = new ArrayList<>();
        users.add(userId.toString());
        chatRoom.append("users", users);
        chatRoom.append("chatHistory", chatHistory);

        // Add image to chat room
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to add a display image?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
            fileChooser.setFileFilter(filter);
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    byte[] image = Files.readAllBytes(selectedFile.toPath());
                    chatRoom.append("image", image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            File file = new File("src/main/java/Avatar.png"); // replace with your file path
            BufferedImage img = ImageIO.read(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "png", baos);
            byte[] image = baos.toByteArray();
            chatRoom.append("image", image);
        }

        crud.insertDocument(chatRoom, chatRoomCollection);
        populateChatRooms();
    }//GEN-LAST:event_btnAddChatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddChat;
    private javax.swing.JList<String> chatsList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}