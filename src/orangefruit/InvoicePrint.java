/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InvoicePrint.java
 *
 * Created on May 25, 2018, 7:19:12 AM
 */
package orangefruit;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author javap
 */
public class InvoicePrint extends javax.swing.JFrame {

    DB db = new DB();
    /** Creates new form InvoicePrint */
    public InvoicePrint() {
        initComponents();
   
    }

    public InvoicePrint(String data){
        initComponents();
        date_today();
        lbl_invoiceID.setText(data);
        get();
    }
    
        void date_today(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        lbl_date.setText(sdf.format(date));
    }
    
    private void get(){
        try {
            ResultSet r = db.getdata("select * from invoice where invoiceID = '" + lbl_invoiceID.getText() + "'");
            ResultSet r2 = db.getdata("select * from invoicetot where invoiceID = '" + lbl_invoiceID.getText() + "'");
            
            DefaultTableModel d = (DefaultTableModel) tbl_invoice.getModel();
            while (r.next()) {
                Vector v = new Vector();
                v.add(r.getString("itemName"));
                v.add(r.getString("Qty"));
                v.add(r.getString("unitPrice"));
                v.add(r.getString("amount"));
                
                d.addRow(v);
            }
            while (r2.next()) {
                Vector v2 = new Vector();
                v2.add(r2.getString("Total"));
                
                
                lbl_total.setText(v2.toString());
            }
        } catch (Exception ex) {
            System.out.println(ex);;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_invoiceID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_invoice = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        btn_close = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(java.awt.Color.black);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poor Richard", 0, 48)); // NOI18N
        jLabel1.setText("Orange Fruit");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 11, 251, 98));
        getContentPane().add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(654, 115, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Invoice ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 115, -1, -1));
        getContentPane().add(lbl_invoiceID, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 115, -1, -1));

        tbl_invoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity", "Unit Price", "Net Amount"
            }
        ));
        jScrollPane1.setViewportView(tbl_invoice);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 147, 677, 404));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Total");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 573, -1, -1));
        getContentPane().add(lbl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 573, -1, -1));

        btn_close.setText("Close");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 569, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Buttons/603.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        setSize(new java.awt.Dimension(816, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
    this.dispose();
    new Invoice().setVisible(true);
}//GEN-LAST:event_btn_closeActionPerformed

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
            java.util.logging.Logger.getLogger(InvoicePrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoicePrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoicePrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoicePrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new InvoicePrint().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_invoiceID;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable tbl_invoice;
    // End of variables declaration//GEN-END:variables
}
