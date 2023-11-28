/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import java.lang.Math;

/**
 *
 * @author SzabóRoland(SZOFT_20
 */
public class Jatek {
    int[] uyesseg = {0,0}, eletero={0,0}, szerencse={0,0};
    int soronJatekos = 0; // 0: Ellenség, 1: Te
    int[] tamadoEro = {0, 0};
    
    String[] ass = new String[400];
    
    
    
    public Jatek(){
        this.uyesseg[1] = setKockaDobas() +6;
        this.eletero[1] = setKockaDobas() + setKockaDobas() + 12;
        this.szerencse[1] = setKockaDobas() + 6;
    }
    
    private int setKockaDobas(){
        // Két kockadobás egyszerre:
        return (int)((Math.random() * 6) + 1);
    }
    
    public boolean setHarc(){
        // Teremtmény
        tamadoEro[soronJatekos] = setKockaDobas() + setKockaDobas(); // Támadóerő
        return false;
    }
    
    public String setValaszt(int val){
        return ass[val];
    }
}
