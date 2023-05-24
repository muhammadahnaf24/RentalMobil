/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.Koneksi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author M S I
 */
public class ModelPeminjaman {
    private int idPeminjaman;
    private int idPelanggan;
    private int idMobil;
    private Date tglPinjam;
    private Date tglKembali;
    private int totalHarga;
    
    Koneksi connect = new Koneksi();
    
    public int getIDPeminjaman() {
        return idPeminjaman;
    }

    public void setIDPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public void setIdMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    public int getIdMobil() {
        return idMobil;
    }
    
    public Date getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(Date tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public Date getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(Date tglKembali) {
        this.tglKembali = tglKembali;
    }
    
    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }
    
    public void simpanPeminjaman(){
        String sql = "INSERT into peminjaman (id_pelanggan, id_mobil, tgl_pinjam, tgl_kembali, total_harga, status)"
                + "VALUES ('"+getIdPelanggan()+"','"+getIdMobil()+"','"+getTglPinjam()+"'"
                + ",'"+getTglKembali()+"','"+getTotalHarga()+"','"+"Pinjam"+"')";
        
        try {
            PreparedStatement eksekusi = connect.getConnection().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Peminjaman Berhasil Disimpan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Peminjaman Gagal Disimpan \n"+ex);
        }
    }
}
