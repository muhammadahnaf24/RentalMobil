/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.ModelPelanggan;
import view.ViewMobil;
import view.ViewPelanggan;
/**
 *
 * @author M S I
 */
public class ControllerPelanggan {
    private ModelPelanggan MP;
    private ViewPelanggan VP;
    
    public ControllerPelanggan(ViewPelanggan VP){
        this.VP = VP;
    }
    
    public void tambah(){
        MP = new ModelPelanggan();
        MP.setNIK(Integer.parseInt(VP.getTFNIK().getText()));
        MP.setNama(VP.getTFNama().getText());
        MP.setJenisKelamin(VP.getCBJenisKelamin().getSelectedItem().toString());
        MP.setAlamat(VP.getTFAlamat().getText());
        
        MP.simpanDataPelanggan();
        bersihkan();
    }
    
    public void edit(){
        MP = new ModelPelanggan();
        MP.setIDPelanggan(Integer.parseInt(VP.getTFIDPelanggan().getText()));
        MP.setNIK(Integer.parseInt(VP.getTFNIK().getText()));
        MP.setNama(VP.getTFNama().getText());
        String jenisKelamin = VP.getCBJenisKelamin().getSelectedItem().toString();
        MP.setJenisKelamin(jenisKelamin);
        MP.setAlamat(VP.getTFAlamat().getText());
        MP.updateDataPelanggan();
        bersihkan();
        kontrolButton1();
    }
    
    public void hapus(){
        MP = new ModelPelanggan();
        MP.setIDPelanggan(Integer.parseInt(VP.getTFIDPelanggan().getText()));
        
        MP.deleteDataPelanggan();
        bersihkan();
        kontrolButton1();
    }
    
    public void bersihkan(){
        VP.getTFIDPelanggan().setText("");
        VP.getTFNIK().setText("");
        VP.getTFNama().setText("");
        VP.getTFAlamat().setText("");
        VP.dispose();
        new ViewPelanggan().setVisible(true);
    }
    
    public void kontrolButton1(){
        VP.getBtnTambah().setEnabled(true);
        VP.getBtnHapus().setEnabled(false);
        VP.getBtnEdit().setEnabled(false);
        VP.getBtnBatal().setEnabled(true);
    }
    
    public void kontrolButton2(){
        VP.getBtnTambah().setEnabled(false);
        VP.getBtnHapus().setEnabled(true);
        VP.getBtnEdit().setEnabled(true);
        VP.getBtnBatal().setEnabled(false);
    }
}
