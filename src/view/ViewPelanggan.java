/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerMobil;
import controller.ControllerPelanggan;
import database.Koneksi;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author M S I
 */
public class ViewPelanggan extends javax.swing.JFrame {

    /**
     * Creates new form ViewPelanggan
     */
    private ControllerPelanggan CP;
    private DefaultTableModel tbmodel;
    
    public ViewPelanggan() {
        initComponents();
        
        CP = new ControllerPelanggan(this);

        tbmodel = new DefaultTableModel();
        TBPelanggan.setModel(tbmodel);
        tbmodel.addColumn("ID Pelanggan");
        tbmodel.addColumn("NIK");
        tbmodel.addColumn("Nama");
        tbmodel.addColumn("Jenis Kelamin");
        tbmodel.addColumn("Alamat");
        
        tampilDataPelanggan();
        CP.kontrolButton1();
    }
    public JButton getBtnBatal() {
        return BtnBatalP;
    }

    public JButton getBtnHapus() {
        return BtnHapusP;
    }

    public JButton getBtnTambah() {
        return BtnTambahP;
    }

    public JButton getBtnEdit() {
        return BtnEditP;
    }

    public JTable getTBPelanggan() {
        return TBPelanggan;
    }
    
    public JTextField getTFIDPelanggan() {
        return TFIDPelanggan;
    }
    
    public JTextField getTFNIK() {
        return TFNIK;
    }

    public JTextField getTFNama() {
        return TFNama;
    }

    public JComboBox getCBJenisKelamin() {
        return CBJenisKelamin;
    }

    public JTextField getTFAlamat() {
        return TFAlamat;
    }
    
    public void tampilDataPelanggan() {
    try {
        // Mendapatkan objek koneksi dari kelas Koneksi
        Koneksi connect = new Koneksi();

        String[] kolom = {"ID pelanggan", "NIK", "Nama", "Jenis Kelamin", "Alamat"};
        tbmodel.setColumnIdentifiers(kolom);

        // Menghapus data yang ada di tabel
        tbmodel.setRowCount(0);

        String sql = "SELECT * FROM pelanggan";

        PreparedStatement statement = connect.getConnection().prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            int id_pelanggan = result.getInt("id_pelanggan");
            int nik = result.getInt("nik");
            String nama = result.getString("nama");
            String jenis_kelamin = result.getString("jenis_kelamin");
            String alamat = result.getString("alamat");

            Object[] data = {id_pelanggan, nik, nama, jenis_kelamin, alamat};
            tbmodel.addRow(data);
        }

        statement.close();
        result.close();
        connect.getConnection().close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Gagal mendapatkan data pelanggan: " + ex.getMessage());
    }
}


    public void ambilDataPelanggan() {
        int barisTerpilih = TBPelanggan.getSelectedRow();

            int id_pelanggan = Integer.parseInt(TBPelanggan.getValueAt(barisTerpilih, 0).toString());
            int nik = Integer.parseInt(TBPelanggan.getValueAt(barisTerpilih, 1).toString());
            String nama = TBPelanggan.getValueAt(barisTerpilih, 2).toString();
            String jenis_kelamin = TBPelanggan.getValueAt(barisTerpilih, 3).toString();
            String alamat = TBPelanggan.getValueAt(barisTerpilih, 4).toString();

            TFIDPelanggan.setText(Integer.toString(id_pelanggan));
            TFNIK.setText(Integer.toString(nik));
            TFNama.setText(nama);
            CBJenisKelamin.setSelectedItem(jenis_kelamin);
            TFAlamat.setText(alamat);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBPelanggan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TFNIK = new javax.swing.JTextField();
        TFNama = new javax.swing.JTextField();
        TFAlamat = new javax.swing.JTextField();
        BtnTambahP = new javax.swing.JButton();
        BtnBatalP = new javax.swing.JButton();
        BtnHapusP = new javax.swing.JButton();
        BtnEditP = new javax.swing.JButton();
        CBJenisKelamin = new javax.swing.JComboBox<>();
        TFIDPelanggan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(960, 540));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setText("JENIS MOBIL");

        TBPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIK", "Nama", "Jenis Kelamin", "Alamat"
            }
        ));
        TBPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBPelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBPelanggan);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(247, 247, 247))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setText("TAMBAH PELANGGAN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(76, 76, 76))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(14, 14, 14))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel3.setText("NIK");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("Nama");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("Jenis Kelamin");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setText("Alamat");

        TFNIK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFNIKActionPerformed(evt);
            }
        });

        TFNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFNamaActionPerformed(evt);
            }
        });

        TFAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFAlamatActionPerformed(evt);
            }
        });

        BtnTambahP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnTambahP.setText("Tambah");
        BtnTambahP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahPActionPerformed(evt);
            }
        });

        BtnBatalP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnBatalP.setText("Batal");
        BtnBatalP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalPActionPerformed(evt);
            }
        });

        BtnHapusP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnHapusP.setText("Hapus");
        BtnHapusP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusPActionPerformed(evt);
            }
        });

        BtnEditP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnEditP.setText("Edit");
        BtnEditP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditPActionPerformed(evt);
            }
        });

        CBJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pria", "Wanita" }));
        CBJenisKelamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBJenisKelaminActionPerformed(evt);
            }
        });

        TFIDPelanggan.setEditable(false);
        TFIDPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFIDPelangganActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnEditP, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnBatalP, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnTambahP)
                                .addGap(47, 47, 47)
                                .addComponent(BtnHapusP, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFIDPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFNIK, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(37, 37, 37)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CBJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TFNama, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFIDPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFNIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CBJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(TFAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTambahP)
                    .addComponent(BtnHapusP))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBatalP)
                    .addComponent(BtnEditP))
                .addGap(0, 152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFNIKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFNIKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFNIKActionPerformed

    private void TFNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFNamaActionPerformed

    private void CBJenisKelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBJenisKelaminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBJenisKelaminActionPerformed

    private void TFAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFAlamatActionPerformed

    private void BtnTambahPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahPActionPerformed
        // TODO add your handling code here:
        CP.tambah();
        tampilDataPelanggan();
    }//GEN-LAST:event_BtnTambahPActionPerformed

    private void BtnEditPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditPActionPerformed
        // TODO add your handling code here:
        CP.edit();
        tampilDataPelanggan();
    }//GEN-LAST:event_BtnEditPActionPerformed

    private void BtnHapusPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusPActionPerformed
        // TODO add your handling code here:
        CP.hapus();
        tampilDataPelanggan();
    }//GEN-LAST:event_BtnHapusPActionPerformed

    private void BtnBatalPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalPActionPerformed
        // TODO add your handling code here:
        CP.kontrolButton1();
        CP.bersihkan();
    }//GEN-LAST:event_BtnBatalPActionPerformed

    private void TBPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBPelangganMouseClicked
        // TODO add your handling code here:
        ambilDataPelanggan();
        CP.kontrolButton2();
    }//GEN-LAST:event_TBPelangganMouseClicked

    private void TFIDPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFIDPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFIDPelangganActionPerformed

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
            java.util.logging.Logger.getLogger(ViewPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBatalP;
    private javax.swing.JButton BtnEditP;
    private javax.swing.JButton BtnHapusP;
    private javax.swing.JButton BtnTambahP;
    private javax.swing.JComboBox<String> CBJenisKelamin;
    private javax.swing.JTable TBPelanggan;
    private javax.swing.JTextField TFAlamat;
    private javax.swing.JTextField TFIDPelanggan;
    private javax.swing.JTextField TFNIK;
    private javax.swing.JTextField TFNama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
