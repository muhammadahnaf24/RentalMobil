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
    private Date tglSewa;
    private Date tglKembali;
    private int totalHarga;
    
    Koneksi connect = new Koneksi();
    
    public int getIDPeminjaman() {
        return idPeminjaman;
    }

    public void setIDPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public int getIDPelanggan() {
        return idPelanggan;
    }

    public void setIDPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public void setIDMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    public int getIDMobil() {
        return idMobil;
    }
    
    public Date getTglSewa() {
        return tglSewa;
    }

    public void setTglSewa(Date tglSewa) {
        this.tglSewa = tglSewa;
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
        String sql = "INSERT into peminjaman (id_pelanggan, id_mobil, tgl_sewa, tgl_kembali, total_harga, status)"
                + "VALUES ('"+getIDPelanggan()+"','"+getIDMobil()+"','"+getTglSewa()+"'"
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
