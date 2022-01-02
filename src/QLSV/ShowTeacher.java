/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSV;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DELL
 */
public class ShowTeacher extends javax.swing.JFrame {

    /**
     * Creates new form ShowTeacher
     */
    public ShowTeacher() {
        initComponents();
        Show_Teachers_In_JTable();
    }
    
    // Display Data in JTable
   // 1 - Fill ArrayList with the data
   public ArrayList<teacher> getTeacherList(){
            ArrayList <teacher> teacherList = new ArrayList<teacher>();
            Connection con = MyConnection.getConnection();
            String query = "SELECT * FROM teacher";
            
            Statement st;
            ResultSet rs;
        try
        {                       
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            teacher tch;
            
            while(rs.next()){
                tch = new teacher(rs.getInt("id"), rs.getString("name"), rs.getString("gender"),
                         rs.getString("Birthdate"), rs.getString("Email"),
                        rs.getString("Address"), rs.getString("Phone_number"), rs.getBytes("Image"));
                teacherList.add(tch);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(ManageTeacherForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return teacherList;
   }
   
   
   
   // 2 - Populate the JTable
   public void Show_Teachers_In_JTable(){
       ArrayList<teacher> list = getTeacherList();
       DefaultTableModel model = (DefaultTableModel)tbl_teacher.getModel();
       // Clear JTable content
       model.setRowCount(0);
       Object[] row = new Object[7];
       for(int i = 0; i < list.size(); i++){
           row[0] = list.get(i).getId();
           row[1] = list.get(i).getName();
           row[2] = list.get(i).getGender();
           row[3] = list.get(i).getBdate();
           row[4] = list.get(i).getEmail();
           row[5] = list.get(i).getAddress();
           row[6] = list.get(i).getPhonenumber();
           
           model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_teacher = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_valfind = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Show Teachers");

        tbl_teacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Gender", "Birth date", "Email", "Address", "Phone "
            }
        ));
        tbl_teacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_teacherMouseClicked(evt);
            }
        });
        tbl_teacher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_teacherKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_teacher);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Enter Values to search :");

        txt_valfind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_valfind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_valfindKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_valfind))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_valfind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_teacherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_teacherMouseClicked

//        int rowIndex = tbl_teacher.getSelectedRow();
//        DefaultTableModel model = (DefaultTableModel)tbl_teacher.getModel();
//        txt_id.setText(model.getValueAt(rowIndex, 0).toString());
//        txt_name.setText(model.getValueAt(rowIndex, 1).toString());
//        if(model.getValueAt(rowIndex, 2).toString().equals("male")){
//            rbd_male.setSelected(true);
//            rbd_female.setSelected(false);
//        }else{
//            rbd_female.setSelected(true);
//            rbd_male.setSelected(false);
//        }
//        try
//        {
//
//            Date addDate = null;
//            addDate = new SimpleDateFormat("yyyy-MM-dd").parse((String)getTeacherList().get(rowIndex).getBdate());
//            DateChooser_Birthdate.setDate(addDate);
//        } catch (ParseException ex)
//        {
//            Logger.getLogger(ManageStudentForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        txt_email.setText(model.getValueAt(rowIndex, 4).toString());
//        txt_address.setText(model.getValueAt(rowIndex, 5).toString());
//        txt_phone_number.setText(model.getValueAt(rowIndex, 6).toString());
//        lbl_image.setIcon(ResizeImage(null, getTeacherList().get(rowIndex).getPicture()));
    }//GEN-LAST:event_tbl_teacherMouseClicked

    private void tbl_teacherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_teacherKeyReleased
//        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
//            int rowIndex = tbl_teacher.getSelectedRow();
//            DefaultTableModel model = (DefaultTableModel)tbl_teacher.getModel();
//            txt_id.setText(model.getValueAt(rowIndex, 0).toString());
//            txt_name.setText(model.getValueAt(rowIndex, 1).toString());
//            if(model.getValueAt(rowIndex, 2).toString().equals("male")){
//                rbd_male.setSelected(true);
//                rbd_female.setSelected(false);
//            }else{
//                rbd_female.setSelected(true);
//                rbd_male.setSelected(false);
//            }
//            try
//            {
//
//                Date addDate = null;
//                addDate = new SimpleDateFormat("yyyy-MM-dd").parse((String)getTeacherList().get(rowIndex).getBdate());
//                DateChooser_Birthdate.setDate(addDate);
//            } catch (ParseException ex)
//            {
//                Logger.getLogger(ManageStudentForm.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            txt_email.setText(model.getValueAt(rowIndex, 4).toString());
//            txt_address.setText(model.getValueAt(rowIndex, 5).toString());
//            txt_phone_number.setText(model.getValueAt(rowIndex, 6).toString());
//            lbl_image.setIcon(ResizeImage(null, getTeacherList().get(rowIndex).getPicture()));
//        }
    }//GEN-LAST:event_tbl_teacherKeyReleased

    private void txt_valfindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valfindKeyReleased
        DefaultTableModel model = (DefaultTableModel)tbl_teacher.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tbl_teacher.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txt_valfind.getText().trim()));
    }//GEN-LAST:event_txt_valfindKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ShowTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ShowTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ShowTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ShowTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbl_teacher;
    private javax.swing.JTextField txt_valfind;
    // End of variables declaration//GEN-END:variables
}
