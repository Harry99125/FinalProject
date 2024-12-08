/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Blogs;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import database.CRUDOperations;
import database.Connection;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Business.Business;
import model.Personnel.Doctor;
import org.bson.Document;
import org.bson.types.ObjectId;


public class BlogSelectorJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;
    MongoDatabase database;
    CRUDOperations crud = new CRUDOperations();
    ObjectId doctorId;
    MongoCollection<Document> blogCollection;
    MongoCollection<Document> doctorCollection;
    /**
     * Creates new form BlogSelectorJPanel
     */
    public BlogSelectorJPanel(JPanel cardSequencePanel, MongoDatabase database, Business business, ObjectId doctorId) {
        initComponents();
        this.CardSequencePanel = cardSequencePanel;
        this.database = new Connection().connectToDatabase();
        this.business = business;
        this.doctorId = doctorId;
        this.blogCollection = this.database.getCollection("Blog");
        this.doctorCollection = this.database.getCollection("Doctor");
        populateBlogPostedTable();
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
        tableBlogPostedList = new javax.swing.JTable();
        btnViewBlog = new javax.swing.JButton();
        lblBlogPostHeader = new javax.swing.JLabel();
        btnDeleteBlog = new javax.swing.JButton();

        tableBlogPostedList.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        tableBlogPostedList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title", "Field", "Date", "Published By"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableBlogPostedList);
        if (tableBlogPostedList.getColumnModel().getColumnCount() > 0) {
            tableBlogPostedList.getColumnModel().getColumn(0).setResizable(false);
            tableBlogPostedList.getColumnModel().getColumn(1).setResizable(false);
            tableBlogPostedList.getColumnModel().getColumn(2).setResizable(false);
            tableBlogPostedList.getColumnModel().getColumn(3).setResizable(false);
        }

        btnViewBlog.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnViewBlog.setText("View Blog");
        btnViewBlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBlogActionPerformed(evt);
            }
        });

        lblBlogPostHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBlogPostHeader.setText("View Blogs");

        btnDeleteBlog.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnDeleteBlog.setText("Delete Blog");
        btnDeleteBlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBlogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBlogPostHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnViewBlog, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteBlog, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblBlogPostHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteBlog)
                    .addComponent(btnViewBlog))
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewBlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBlogActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableBlogPostedList.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a blog from the list.", "Selection Needed", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String blogTitle = (String) tableBlogPostedList.getValueAt(selectedRow, 0); // Assuming the title is in the first column
        if (blogTitle == null || blogTitle.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid blog selection.", "Selection Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Fetch the blog document using the title
        Document blog = blogCollection.find(Filters.eq("blogPostTitle", blogTitle)).first();
        if (blog == null) {
            JOptionPane.showMessageDialog(this, "Blog not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ObjectId blogId = blog.getObjectId("_id"); // Retrieve the ObjectId of the blog

        // Proceed to open the blog view panel
        BlogViewJPanel blogViewJPanel = new BlogViewJPanel(CardSequencePanel, database, business, blogId);
        CardSequencePanel.add("blogViewJPanel", blogViewJPanel);
        CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
        layout.next(CardSequencePanel);
        
    }//GEN-LAST:event_btnViewBlogActionPerformed

    private void btnDeleteBlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBlogActionPerformed
        int selectedRow = tableBlogPostedList.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a blog to delete.", "Selection Needed", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String blogTitle = (String) tableBlogPostedList.getValueAt(selectedRow, 0); // Assuming the title is in the first column
        Document blog = blogCollection.find(Filters.eq("blogPostTitle", blogTitle)).first();

        if (blog == null) {
            JOptionPane.showMessageDialog(this, "Blog not found or already deleted.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String blogDoctorIdStr = blog.getString("doctorId"); // Retrieve doctorId as String
        ObjectId blogDoctorId = new ObjectId(blogDoctorIdStr); // Convert String to ObjectId

        if (!blogDoctorId.equals(doctorId)) {
            JOptionPane.showMessageDialog(this, "You do not have permission to delete this blog.", "Permission Denied", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Proceed to delete the blog post if doctorId matches
        blogCollection.deleteOne(Filters.eq("_id", blog.getObjectId("_id")));
        JOptionPane.showMessageDialog(this, "Blog deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Refresh the table after deletion
        populateBlogPostedTable();
    }//GEN-LAST:event_btnDeleteBlogActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteBlog;
    private javax.swing.JButton btnViewBlog;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBlogPostHeader;
    private javax.swing.JTable tableBlogPostedList;
    // End of variables declaration//GEN-END:variables

    private void populateBlogPostedTable() {
        // Clear previous rows
        DefaultTableModel model = (DefaultTableModel) tableBlogPostedList.getModel();
        model.setRowCount(0);

        // Fetch all blog entries
        FindIterable<Document> blogs = blogCollection.find();
        for (Document blog : blogs) {
            // Retrieve the doctorId from the blog document
            String doctorPublishId = blog.getString("doctorId");

            // Retrieve the doctor's name using the doctorId
            Document doctor = doctorCollection.find(Filters.eq("_id", new ObjectId(doctorPublishId))).first();
            String doctorName = (doctor != null) ? doctor.getString("doctorName") : "Unknown";

            // Get other details from the blog document
            String title = blog.getString("blogPostTitle");
            String field = blog.getString("blogPostField");
            String date = blog.getString("blogPostDate");

            // Add row to the table
            model.addRow(new Object[]{title, field, date, doctorName});
        }
    }

}
