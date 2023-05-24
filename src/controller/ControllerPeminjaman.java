/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Date;
import model.ModelPeminjaman;
import view.ViewPeminjaman;
/**
 *
 * @author M S I
 */
public class ControllerPeminjaman {
    private ModelPeminjaman MP;
    private ViewPeminjaman VP;
    
    public ControllerPeminjaman(ViewPeminjaman VP){
        this.VP = VP;
    }
        public void simpanPeminjaman(){
        MP = new ModelPeminjaman();
        
        MP.setIdPelanggan(VP.getTFIdPelanggan().getText());
        MP.setIdMobil(VP.getTFIdMobil().getText());
        Date d = VP.getDCTglPinjam().getCalendar().getTime();
                    java.sql.Date tglPinjam = new java.sql.Date(d.getTime());
                    MP.setTglPinjam(tglPinjam);
        Date c = VP.getDCTglKembali().getCalendar().getTime();
                    java.sql.Date tglKembali = new java.sql.Date(d.getTime());
                    MP.setTglKembali(tglKembali);
        MP.setTotalHarga(VP.getTFTotalBayar().getText());
        MP.setUangBayar(VP.getTFUangBayar().getText());
        
        MP.simpanPeminjaman();
    }
}
