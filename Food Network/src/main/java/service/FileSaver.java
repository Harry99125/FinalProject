package service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileSaver {
    private JTable table;
    private List<String> columnNames;
    private String header;

    public FileSaver(JTable table,String header, List<String> columnNames) {
        this.table = table;
        this.header = header;
        this.columnNames = columnNames;
    }

    public void saveFile() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");
            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                Object[] options = {"PDF", "CSV"};
                int n = JOptionPane.showOptionDialog(null,
                        "In which format do you want to save the file?",
                        "Choose Format",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (n == 0) {
                    saveAsPDF(fileToSave);
                } else if (n == 1) {
                    saveAsCSV(fileToSave);
                }
            }
        } catch (Exception e) {
            System.err.println("Error creating file: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error creating file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveAsPDF(File fileToSave) throws DocumentException, FileNotFoundException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(fileToSave.getAbsolutePath() + ".pdf"));
        document.open();
        PdfPTable pdfTable = new PdfPTable(columnNames.size());
        for (String columnName : columnNames) {
            pdfTable.addCell(columnName);
        }
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnNames.size(); j++) {
                String cellValue = model.getValueAt(i, j).toString();
                pdfTable.addCell(cellValue);
            }
        }
//        add header
        document.add(new Paragraph(header));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(pdfTable);
        document.close();
        JOptionPane.showMessageDialog(null, "Report has been saved to " + fileToSave.getAbsolutePath() + ".pdf");
    }

    private void saveAsCSV(File fileToSave) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileToSave.getAbsolutePath() + ".csv"))) {
            String[] header = columnNames.toArray(new String[0]);
            writer.writeNext(header);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int rowCount = model.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String[] data = new String[columnNames.size()];
                for (int j = 0; j < columnNames.size(); j++) {
                    data[j] = model.getValueAt(i, j).toString();
                }
                writer.writeNext(data);
            }
            JOptionPane.showMessageDialog(null, "Report has been saved to " + fileToSave.getAbsolutePath() + ".csv");
        }
    }
}