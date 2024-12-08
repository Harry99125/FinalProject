/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.TrainingCenter;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;

import javax.print.Doc;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import model.Business.Business;
import model.TrainingCenter.TrainingCenter;
import org.bson.Document;
import org.bson.types.ObjectId;


public class ViewDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewDetailsJPanel
     */
    JPanel CardSequencePanel;
    Business business;
    TrainingCenter trainingcenter;
    MongoDatabase database;
    String doctorName;
    CRUDOperations crud = new CRUDOperations();
    MongoCollection<Document> doctorCollection;
    MongoCollection<Document> doctorResidentCourseCollection;
    MongoCollection<Document> courseCollection;
    MongoCollection<Document> doctorCourseCollection;
    public ViewDetailsJPanel(JPanel cardSequencePanel,TrainingCenter trainingcenter,MongoDatabase database, Business business, String doctorName) {
      initComponents();
        this.CardSequencePanel = cardSequencePanel;
        this.trainingcenter = trainingcenter;
        this.database = database;
        this.doctorName = doctorName;
        this.doctorCollection = this.database.getCollection("Doctor");
        this.doctorResidentCourseCollection = this.database.getCollection("DoctorResidentCourse");
        this.courseCollection = this.database.getCollection("Course");
        this.doctorCourseCollection = this.database.getCollection("DoctorCourse");
        txtStudentName.setText(this.doctorName);
        populateGetDetailsTable(doctorName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGetDetails = new javax.swing.JTable();

        setBackground(new java.awt.Color(241, 206, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setText("Student Name :");

        tblGetDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course Name", "Instrutor", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblGetDetails);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGetDetails;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables

    private void populateGetDetailsTable(String doctorName) {
        DefaultTableModel model = (DefaultTableModel) tblGetDetails.getModel();
        model.setRowCount(0);
        Document doctorDoc = crud.getFirstRecordByKey("doctorName", doctorName, doctorCollection);
        ObjectId doctorId = doctorDoc.getObjectId("_id");
        System.out.println("Doctor Id :" + doctorId);
        FindIterable<Document> findIterable = crud.getRecordsByKey("doctorId", doctorId.toString(), doctorResidentCourseCollection);
        MongoCursor<Document> cursor = findIterable.iterator();
        System.out.println("Cusor: " + cursor);
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                String courseId = doc.getString("courseId");
                Document courseDoc = crud.getFirstRecordByKey("_id", new ObjectId(courseId), courseCollection);
                String courseName = courseDoc.getString("courseName");
                System.out.println("Course Name: " + courseName);
                Document doctorCourseDoc = crud.getFirstRecordByKey("courseId", courseId, doctorCourseCollection);
                String docId = doctorCourseDoc.getString("doctorId");
                System.out.println("Doctor Id: " + docId);
                Document doctorDoc1 = crud.getFirstRecordByKey("_id", new ObjectId(docId), doctorCollection);
                String instructor = doctorDoc1.getString("doctorName");
                String status = doc.getString("courseStatus");
                model.addRow(new Object[]{courseName, instructor, status});
            }
        } finally {
            cursor.close();
        }
    }
}