/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.ModelMobil;
import view.ViewMobil;

/**
 *
 * @author M S I
 */
public class ControllerMobil {
    private ModelMobil MM;
    private ViewMobil VM;
    
    public ControllerMobil(ViewMobil VM){
        this.VM = VM;
    } 
    
    public void tambah(){
        MM = new ModelMobil();
        MM.setMerk(VM.getTFMerk().getText());
        MM.setTipe(VM.getTFTipe().getText());
        MM.setTahun(Integer.parseInt(VM.getTFTahun().getText()));
        MM.setNopol(VM.getTFNopol().getText());
        MM.setHarga(Integer.parseInt(VM.getTFHarga().getText()));
        
        MM.simpanDataMobil();
        bersihkan();
    }
    
    public void edit(){
        MM = new ModelMobil();
        MM.setIDMobil(Integer.parseInt(VM.getTFIDMobil().getText()));
        MM.setMerk(VM.getTFMerk().getText());
        MM.setTipe(VM.getTFTipe().getText());
        MM.setTahun(Integer.parseInt(VM.getTFTahun().getText()));
        MM.setNopol(VM.getTFNopol().getText());
        MM.setHarga(Integer.parseInt(VM.getTFHarga().getText()));
        
        MM.updateDataMobil();
        bersihkan();
        kontrolButton1();
    }
    
    public void hapus(){
        MM = new ModelMobil();
        MM.setIDMobil(Integer.parseInt(VM.getTFIDMobil().getText()));
        
        MM.deleteDataMobil();
        bersihkan();
        kontrolButton1();
    }
    
    public void bersihkan(){
        //VM.getTFIdMobil().setText("");
        VM.getTFMerk().setText("");
        VM.getTFTipe().setText("");
        VM.getTFTahun().setText("");
        VM.getTFNopol().setText("");
        VM.getTFHarga().setText("");
        VM.dispose();
        new ViewMobil().setVisible(true);
    }
    
    public void kontrolButton1(){
        VM.getBtnTambah().setEnabled(true);
        VM.getBtnHapus().setEnabled(false);
        VM.getBtnEdit().setEnabled(false);
        VM.getBtnBatal().setEnabled(true);
    }
    
    public void kontrolButton2(){
        VM.getBtnTambah().setEnabled(false);
        VM.getBtnHapus().setEnabled(true);
        VM.getBtnEdit().setEnabled(true);
        VM.getBtnBatal().setEnabled(false);
    }
}
