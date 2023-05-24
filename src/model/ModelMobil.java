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
public class ModelMobil {
    private int idMobil;
    private String merk;
    private String tipe;
    private int tahun;
    private String nopol;
    private int harga;
    
    Koneksi connect = new Koneksi();

    public int getIDMobil() {
        return idMobil;
    }

    public void setIDMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    public  void simpanDataMobil(){
        String sql = ("INSERT INTO mobil(merk, tipe, tahun, nopol, harga)"
                + " VALUES('"+getMerk()+"', '"+getTipe()+"', '"+getTahun()+"'"
                + ", '"+getNopol()+"', '"+getHarga()+"')");   

         try{
            PreparedStatement eksekusi = connect.getConnection().prepareStatement(sql);
            eksekusi.execute();
            JOptionPane.showMessageDialog(null, "Data Mobil Berhasil Disimpan");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Mobil Gagal Disimpan \n" + ex);
        }
    }
    
    public void updateDataMobil() {

        String sql = "UPDATE mobil SET merk = ?, tipe = ?, tahun = ?, nopol = ?, harga = ? WHERE id_mobil = ?";

        try {
            PreparedStatement eksekusi = connect.getConnection().prepareStatement(sql);
            eksekusi.setString(1, getMerk());
            eksekusi.setString(2, getTipe());
            eksekusi.setInt(3, getTahun());
            eksekusi.setString(4, getNopol());
            eksekusi.setInt(5, getHarga());
            eksekusi.setInt(6, getIDMobil());

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
    
    public void deleteDataMobil(){
        System.out.println(getIDMobil());
        String sql = "DELETE from mobil WHERE id_mobil = " + " '"+getIDMobil()+"'";
        
         try{
            PreparedStatement eksekusi = connect.getConnection().prepareStatement(sql);
            eksekusi.execute();
            JOptionPane.showMessageDialog(null, "Data Mobil Berhasil Dihapus");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Mobil Gagal Dihapus \n" + ex);
        }
    }
}
