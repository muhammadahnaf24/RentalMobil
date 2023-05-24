/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import controller.ControllerPeminjaman;
import database.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author M S I
 */
public class ViewPeminjaman extends javax.swing.JFrame {
    private ControllerPeminjaman CP;
    private DefaultTableModel tbmodelMobil;
    private DefaultTableModel tbmodelPelanggan;
    private int hasil;
        
    /**
     * Creates new form ViewPeminjaman
     */
    public ViewPeminjaman() {
        initComponents();
        setLocationRelativeTo(this);
        
        CP = new ControllerPeminjaman(this);
        tbmodelMobil = new DefaultTableModel();
        tbmodelPelanggan = new DefaultTableModel();
        TBPinjamMobil.setModel(tbmodelMobil);
        TBPinjamPelanggan.setModel(tbmodelPelanggan);

        tampilDataMobil();
        tampilDataPelanggan();
 
    }
        public JButton getBTBatal() {
            return BtnBatalSewa;
        }

        public JButton getBtnSewa() {
            return BtnSewa;
        }

        public JTextField getTFIDMobil() {
            return TFIDMobil;
        }

        public JDateChooser getDCTglKembali() {
            return DCTglKembali;
        }

        public JDateChooser getDCTglSewa() {
            return DCTglSewa;
        }

        public JTextField getTFAlamat() {
            return TFAlamat;
        }

        public JTextField getTFHarga() {
            return TFHarga;
        }

        public JTextField getTFIDPelanggan() {
            return TFIDPelanggan;
        }

        public JTextField getTFLamaSewa() {
            return TFLamaSewa;
        }

        public JTextField getTFNama() {
            return TFNama;
        }


        public JTextField getTFNopol() {
            return TFNopol;
        }

        public JTextField getTFTotalHarga() {
            return TFTotalHarga;
        }


        public JTextField getTFMerk() {
            return TFMerk;
        }

        public JTextField getTFTahun() {
            return TFTahun;
        }

        public JTextField getTFTipe() {
            return TFTipe;
        }
        public void tampilDataMobil() {
            try {
                // Mendapatkan objek koneksi dari kelas Koneksi
                Koneksi connect = new Koneksi();

                String[] kolom = {"ID Mobil", "Merk", "Tipe", "Tahun", "Nopol", "Harga"};
                tbmodelMobil.setColumnIdentifiers(kolom);

                // Menghapus data yang ada di tabel
                tbmodelMobil.setRowCount(0);

                String sql = "SELECT * FROM mobil";

                PreparedStatement statement = connect.getConnection().prepareStatement(sql);
                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    int id_mobil = result.getInt("id_mobil");
                    String merk = result.getString("merk");
                    String tipe = result.getString("tipe");
                    int tahun = result.getInt("tahun");
                    String nopol = result.getString("nopol");
                    int harga = result.getInt("harga");

                    Object[] data = {id_mobil, merk, tipe, tahun, nopol, harga};
                    tbmodelMobil.addRow(data);
                }

                statement.close();
                result.close();
                connect.getConnection().close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal mendapatkan data mobil: " + ex.getMessage());
            }
        }
        
        public void ambilDataMobil() {
            int barisTerpilih = TBPinjamMobil.getSelectedRow();

            String id_mobil = TBPinjamMobil.getValueAt(barisTerpilih, 0).toString();
            String merk = TBPinjamMobil.getValueAt(barisTerpilih, 1).toString();
            String tipe = TBPinjamMobil.getValueAt(barisTerpilih, 2).toString();
            int tahun = Integer.parseInt(TBPinjamMobil.getValueAt(barisTerpilih, 3).toString());
            String nopol = TBPinjamMobil.getValueAt(barisTerpilih, 4).toString();
            int harga = Integer.parseInt(TBPinjamMobil.getValueAt(barisTerpilih, 5).toString());

            TFIDMobil.setText(id_mobil);
            TFMerk.setText(merk);
            TFTipe.setText(tipe);
            TFTahun.setText(Integer.toString(tahun));
            TFNopol.setText(nopol);
            TFHarga.setText(Integer.toString(harga));
        }
        
        public void tampilDataPelanggan() {
            try {
                // Mendapatkan objek koneksi dari kelas Koneksi
                Koneksi connect = new Koneksi();

                String[] kolom = {"ID pelanggan", "NIK", "Nama", "Jenis Kelamin", "Alamat"};
                tbmodelPelanggan.setColumnIdentifiers(kolom);

                // Menghapus data yang ada di tabel
                tbmodelPelanggan.setRowCount(0);

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
                    tbmodelPelanggan.addRow(data);
                }

                statement.close();
                result.close();
                connect.getConnection().close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal mendapatkan data pelanggan: " + ex.getMessage());
            }
        }


    public void ambilDataPelanggan() {
        int barisTerpilih = TBPinjamPelanggan.getSelectedRow();

            int id_pelanggan = Integer.parseInt(TBPinjamPelanggan.getValueAt(barisTerpilih, 0).toString());
            int nik = Integer.parseInt(TBPinjamPelanggan.getValueAt(barisTerpilih, 1).toString());
            String nama = TBPinjamPelanggan.getValueAt(barisTerpilih, 2).toString();
            String jenis_kelamin = TBPinjamPelanggan.getValueAt(barisTerpilih, 3).toString();
            String alamat = TBPinjamPelanggan.getValueAt(barisTerpilih, 4).toString();

            TFIDPelanggan.setText(Integer.toString(id_pelanggan));
            TFNIK.setText(Integer.toString(nik));
            TFNama.setText(nama);
            TFJenisKelamin.setText(jenis_kelamin);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBPinjamMobil = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBPinjamPelanggan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TFIDMobil = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TFMerk = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TFNopol = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TFTipe = new javax.swing.JTextField();
        TFHarga = new javax.swing.JTextField();
        TFTahun = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        BtnHitung = new javax.swing.JButton();
        TFTotalHarga = new javax.swing.JTextField();
        BtnSewa = new javax.swing.JButton();
        BtnBatalSewa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        TFIDPelanggan = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TFNIK = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TFJenisKelamin = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TFNama = new javax.swing.JTextField();
        TFAlamat = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TFLamaSewa = new javax.swing.JTextField();
        DCTglSewa = new com.toedter.calendar.JDateChooser();
        DCTglKembali = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("FORM PEMINJAMAN MOBIL");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("PILIH DATA MOBIL");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("PILIH DATA PELANGGAN");

        TBPinjamMobil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID MOBIL", "MERK", "TIPE", "TAHUN", "NOPOL", "HARGA"
            }
        ));
        TBPinjamMobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBPinjamMobilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBPinjamMobil);

        TBPinjamPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID PELANGGAN", "NIK", "NAMA", "JENIS KELAMIN", "ALAMAT"
            }
        ));
        TBPinjamPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBPinjamPelangganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TBPinjamPelanggan);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("ID MOBIL");

        TFIDMobil.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("MERK");

        TFMerk.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("TIPE");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("HARGA");

        TFNopol.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("NOPOL");

        TFTipe.setEditable(false);

        TFHarga.setEditable(false);

        TFTahun.setEditable(false);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("TAHUN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel17)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFTahun, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFNopol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFHarga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(TFIDMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TFTipe, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TFMerk, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TFIDMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TFMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TFTipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(TFTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(TFNopol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TFHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("TOTAL HARGA");

        BtnHitung.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnHitung.setText("HITUNG HARGA");
        BtnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHitungActionPerformed(evt);
            }
        });

        BtnSewa.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        BtnSewa.setText("SEWA");
        BtnSewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSewaActionPerformed(evt);
            }
        });

        BtnBatalSewa.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        BtnBatalSewa.setText("BATAL");
        BtnBatalSewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalSewaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("ID PELANGGAN");

        TFIDPelanggan.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("NIK");

        TFNIK.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("NAMA");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("ALAMAT");

        TFJenisKelamin.setEditable(false);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("JENIS KELAMIN");

        TFNama.setEditable(false);

        TFAlamat.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TFNIK, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TFNama, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TFJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TFAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(TFIDPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(TFIDPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(TFNIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(TFNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(TFJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(TFAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("TANGGAL SEWA");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("TANGGAL KEMBALI");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("LAMA SEWA");

        DCTglSewa.setDateFormatString("yyyy-MM-dd");
        DCTglSewa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DCTglSewaFocusLost(evt);
            }
        });

        DCTglKembali.setDateFormatString("yyyy-MM-dd");
        DCTglKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DCTglKembaliMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(100, 100, 100)
                        .addComponent(TFLamaSewa))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(59, 59, 59)
                        .addComponent(DCTglKembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(DCTglSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(117, 117, 117))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(DCTglSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(DCTglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFLamaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(594, 594, 594)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(557, 557, 557)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnHitung)
                                    .addComponent(TFTotalHarga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(BtnBatalSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnHitung)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TFTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBatalSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TBPinjamPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBPinjamPelangganMouseClicked
        // TODO add your handling code here:
        ambilDataPelanggan();
    }//GEN-LAST:event_TBPinjamPelangganMouseClicked

    private void TBPinjamMobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBPinjamMobilMouseClicked
        // TODO add your handling code here:
        ambilDataMobil();
    }//GEN-LAST:event_TBPinjamMobilMouseClicked

    private void BtnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHitungActionPerformed
        // TODO add your handling code here:
        LocalDate tanggalMulai = DCTglSewa.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate tanggalAkhir = DCTglKembali.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Hitung selisih hari
        long selisih = ChronoUnit.DAYS.between(tanggalMulai, tanggalAkhir);;

        // Tampilkan hasil selisih hari
        TFLamaSewa.setText(String.valueOf(selisih));
        System.out.println(selisih);
        hasil = Integer.parseInt(TFLamaSewa.getText()) * Integer.parseInt(TFHarga.getText());
        TFTotalHarga.setText(String.valueOf(hasil));
    }//GEN-LAST:event_BtnHitungActionPerformed

    private void BtnSewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSewaActionPerformed
        // TODO add your handling code here:
        CP.simpanPeminjaman();
        CP.bersihkan();
    }//GEN-LAST:event_BtnSewaActionPerformed

    private void BtnBatalSewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalSewaActionPerformed
        // TODO add your handling code here:
        CP.bersihkan();
    }//GEN-LAST:event_BtnBatalSewaActionPerformed

    private void DCTglSewaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DCTglSewaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_DCTglSewaFocusLost

    private void DCTglKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DCTglKembaliMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_DCTglKembaliMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBatalSewa;
    private javax.swing.JButton BtnHitung;
    private javax.swing.JButton BtnSewa;
    private com.toedter.calendar.JDateChooser DCTglKembali;
    private com.toedter.calendar.JDateChooser DCTglSewa;
    private javax.swing.JTable TBPinjamMobil;
    private javax.swing.JTable TBPinjamPelanggan;
    private javax.swing.JTextField TFAlamat;
    private javax.swing.JTextField TFHarga;
    private javax.swing.JTextField TFIDMobil;
    private javax.swing.JTextField TFIDPelanggan;
    private javax.swing.JTextField TFJenisKelamin;
    private javax.swing.JTextField TFLamaSewa;
    private javax.swing.JTextField TFMerk;
    private javax.swing.JTextField TFNIK;
    private javax.swing.JTextField TFNama;
    private javax.swing.JTextField TFNopol;
    private javax.swing.JTextField TFTahun;
    private javax.swing.JTextField TFTipe;
    private javax.swing.JTextField TFTotalHarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
