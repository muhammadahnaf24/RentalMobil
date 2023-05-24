/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.Koneksi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author M S I
 */
public class ModelPelanggan {
    private int idPelanggan;
    private int nik;
    private String nama;
    private String jenis_kelamin;
    private String alamat;
    
    Koneksi connect = new Koneksi();
    
    public int getIDPelanggan() {
        return idPelanggan;
    }

    public void setIDPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public int getNIK() {
        return nik;
    }

    public void setNIK(int nik) {
        this.nik = nik;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNama() {
        return nama;
    }
    
    public String getJenisKelamin() {
        return jenis_kelamin;
    }

    public void setJenisKelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public  void simpanDataPelanggan(){
        String sql = ("INSERT INTO pelanggan(nik, nama, jenis_kelamin, alamat)"
                + " VALUES('"+getNIK()+"', '"+getNama()+"', '"+getJenisKelamin()+"'"
                + ", '"+getAlamat()+"')");   

         try{
            PreparedStatement eksekusi = connect.getConnection().prepareStatement(sql);
            eksekusi.execute();
            JOptionPane.showMessageDialog(null, "Data Pelanggan Berhasil Disimpan");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Pelanggan Gagal Disimpan \n" + ex);
        }
    }
    
    public void updateDataPelanggan() {

        String sql = "UPDATE pelanggan SET nik = ?, nama = ?, jenis_kelamin = ?, alamat = ? WHERE id_pelanggan = ?";

        try {
            PreparedStatement eksekusi = connect.getConnection().prepareStatement(sql);
            eksekusi.setInt(1, getNIK());
            eksekusi.setString(2, getNama());
            eksekusi.setString(3, getJenisKelamin());
            eksekusi.setString(4, getAlamat());
            eksekusi.setInt(5, getIDPelanggan());

            int rowsAffected = eksekusi.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data Mobil Berhasil Diupdate");
            } else {
                JOptionPane.showMessageDialog(null, "Data Mobil Tidak Ditemukan");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Mobil Gagal Diupdate\n" + ex);
        }
    }
    
    public void deleteDataPelanggan(){
        System.out.println(getIDPelanggan());
        String sql = "DELETE from pelanggan WHERE id_pelanggan = " + " '"+getIDPelanggan()+"'";
        
         try{
            PreparedStatement eksekusi = connect.getConnection().prepareStatement(sql);
            eksekusi.execute();
            JOptionPane.showMessageDialog(null, "Data Mobil Berhasil Dihapus");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Mobil Gagal Dihapus \n" + ex);
        }
    }
}
