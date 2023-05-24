/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Date;
import model.ModelPeminjaman;
import view.ViewMobil;
import view.ViewPeminjaman;
import view.ViewMenuUtama;
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
        
    
        MP.setIDPelanggan(Integer.parseInt(VP.getTFIDPelanggan().getText()));
        MP.setIDMobil(Integer.parseInt(VP.getTFIDMobil().getText()));
        Date d = VP.getDCTglSewa().getCalendar().getTime();
                    java.sql.Date tglSewa = new java.sql.Date(d.getTime());
                    MP.setTglSewa(tglSewa);
        Date c = VP.getDCTglKembali().getCalendar().getTime();
                    java.sql.Date tglKembali = new java.sql.Date(d.getTime());
                    MP.setTglKembali(tglKembali);
        MP.setTotalHarga(Integer.parseInt(VP.getTFTotalHarga().getText()));    
        MP.simpanPeminjaman();
    }
         public void bersihkan(){
            VP.dispose();
            //new ViewPeminjaman().setVisible(true);
            new ViewMenuUtama().setVisible(true);
    }
}
