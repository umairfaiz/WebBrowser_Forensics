/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web_browser;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import javax.rmi.CORBA.Util;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import web_browser.ResultSetTableModel;

/**
 *
 * @author Blogger
 */
public class Downloads extends javax.swing.JFrame {
    
    
    ArrayList<File> historyFiles = new ArrayList<>();
    ArrayList<Connection> conn = new ArrayList<>();
    ArrayList<Statement> stmts = new ArrayList<>();
    ArrayList<ResultSet> rsa = new ArrayList<>();
            
    Utilities utilities = new Utilities();
    final ResultSetTableModel model = new ResultSetTableModel();
    JFrame parent = null;


    /**
     * Creates new form History
     */
    public Downloads() 
    {
        initComponents();
        jTable_Download.setShowGrid(true);
    }

    Downloads(JFrame frame) 
    {
        initComponents();
        jTable_Download.setShowGrid(true);
        parent = frame;
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
        jTable_Download = new javax.swing.JTable();
        button_ChromeDownload = new javax.swing.JButton();
        button_MozillaDownload = new javax.swing.JButton();
        exportExcel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboSelectUser = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Download History");
        setName("View History"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable_Download.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_Download.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(jTable_Download);

        button_ChromeDownload.setText("Load Google Chrome History");
        button_ChromeDownload.setLabel("Load Google Chrome Downloads");
        button_ChromeDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ChromeDownloadActionPerformed(evt);
            }
        });

        button_MozillaDownload.setLabel("Load Mozilla Firefox Downloads");
        button_MozillaDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_MozillaDownloadActionPerformed(evt);
            }
        });

        exportExcel.setLabel("Export to Excel");
        exportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportExcelActionPerformed(evt);
            }
        });

        jLabel1.setText("Select User:");

        String userDirectory = System.getProperty("user.home");
        File root = new File("C:\\Users\\");
            File[] list = root.listFiles();

            for ( File f : list )
            {
                if ( f.isDirectory() )
                {
                    comboSelectUser.addItem(f.getName());
                }
            }

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(comboSelectUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(button_ChromeDownload, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                        .addComponent(button_MozillaDownload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(button_ChromeDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(9, 9, 9)
                            .addComponent(button_MozillaDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(comboSelectUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(exportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(35, 35, 35)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void button_ChromeDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ChromeDownloadActionPerformed
        try
        {
            historyFiles = utilities.getChromeFiles("C:\\Users\\"+comboSelectUser.getSelectedItem()+"\\AppData\\Local\\Google\\Chrome\\User Data", "History");
            
            if(historyFiles.size() >= 1)
            {
                for (int i=0; i<historyFiles.size();i++)
                {
                    conn.add(i,DbController.getConnection(historyFiles.get(i).toString()));
                    stmts.add(conn.get(i).createStatement());
                    rsa.add( stmts.get(i).executeQuery(
                    "select replace(target_path, rtrim(target_path, replace(target_path, '\\', '' ) ), '') As 'File', "
                             + "current_path as Path, ROUND((total_bytes/(1024.0*1024.0)),2) as 'File Size(MB)',"
                            + "datetime((start_time / 1000000) + (strftime('%s', '1601-01-01')), 'unixepoch','localtime') as 'Download Time',"
                            + "referrer as 'Referral Site' from downloads where target_path!='';"));
                }
                model.setResultSet(rsa);
                System.out.println ("Row Count : " + model.getRowCount());
                jTable_Download.setModel(model); 
                jTable_Download.setAutoCreateRowSorter(true);
            }
            else
            {
                JOptionPane.showMessageDialog(jTable_Download, "No Downloads found on this system");
            }         
        }
        catch (Exception ex)
        {
            if (ex.getMessage().contains("The database file is locked"))
            {
                JOptionPane.showMessageDialog(jTable_Download, "Please Close google chrome and try again in 30 seconds");
            }
            else
            {
                System.out.println("Catch Error in button_ChromeDownloadActionPerformed: " + ex.getMessage());
            }
        }
        finally
        {
            try 
            {
                historyFiles.clear(); conn.clear(); stmts.clear();rsa.clear();   
            } 
            catch (Exception ex) 
            {
               System.out.println("Finally Error in button_ChromeDownloadActionPerformed: " + ex.getMessage() );
            }
        }
    }//GEN-LAST:event_button_ChromeDownloadActionPerformed

    private void button_MozillaDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_MozillaDownloadActionPerformed
        try
        {
            historyFiles = utilities.getMozillaFiles("C:\\Users\\"+comboSelectUser.getSelectedItem()+"\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles","places.sqlite");
            
            if(historyFiles.size() >= 1)
            {
                for (int i=0; i<historyFiles.size();i++)
                {
                    conn.add(i,DbController.getConnection(historyFiles.get(i).toString()));
                    stmts.add(conn.get(i).createStatement());
                    rsa.add( stmts.get(i).executeQuery("SELECT content as File, "
                            + "datetime((dateAdded/1000000), 'unixepoch','localtime') as 'Download Time' "
                            + "from moz_annos where content NOT LIKE '{%' "));
                }
                model.setResultSet(rsa);
                System.out.println ("Row Count : " + model.getRowCount());
                jTable_Download.setModel(model); 
                jTable_Download.setAutoCreateRowSorter(true);
            }
            else
            {
                JOptionPane.showMessageDialog(jTable_Download, "No Downloads found on this system");
            }         
        }
        catch (Exception ex)
        {
            System.out.println("Catch Error in button_MozillaDownloadActionPerformed: " + ex.getMessage());
        }
        finally
        {
            try 
            {
                historyFiles.clear(); conn.clear(); stmts.clear();rsa.clear();   
            } 
            catch (Exception ex) 
            {
               System.out.println("Finally Error in button_MozillaDownloadActionPerformed: " + ex.getMessage() );
            }
        }
        
    }//GEN-LAST:event_button_MozillaDownloadActionPerformed

    private void exportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportExcelActionPerformed
        utilities.toExcel(jTable_Download, this);
    }//GEN-LAST:event_exportExcelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Downloads.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Downloads.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Downloads.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Downloads.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

       
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Downloads download = new Downloads();
                Utilities.setFrameLocation(download);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_ChromeDownload;
    private javax.swing.JButton button_MozillaDownload;
    private javax.swing.JComboBox comboSelectUser;
    private javax.swing.JButton exportExcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Download;
    // End of variables declaration//GEN-END:variables
}