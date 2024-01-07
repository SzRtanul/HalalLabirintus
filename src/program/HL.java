/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import java.lang.Math;
import java.awt.*;  
import java.awt.event.*;
import java.beans.PropertyChangeSupport;
import java.util.*;

/**
 *
 * @author SzabóRoland(SZOFT_20
 */
public class HL {
    
    // <editor-fold defaultstate="collapsed" desc="Event implmentation">
    private static Set<EI.CCListener> listeners = new HashSet();
    
    public static void addListener(EI.CCListener listener) {
        listeners.add(listener);
    }
    
    public static void removeListener(EI.CCListener listener) {
        listeners.remove(listener);
    }

    private static void broadcast() {
        listeners.forEach(x -> x.actionValueChanged());
    }
    // </editor-fold>
    
    private static int uyesseg = 0;
    private static int eletero = 0;
    private static int szerencse = 0;
    //int tamadoEro = 0;
    
    
    
    private static java.util.List<String> targyak;
    private static java.util.List<String> ekkovek;
    private static java.util.List<String> italok;
    private static java.util.List<String> etelkeszlet;
    
    private static String[] ass = new String[400];
    private static int arany = 0;
     
    public static void Restart(){
        uyesseg = setKockaDobas() +6;
        eletero = setKockaDobas() + setKockaDobas() + 12;
        szerencse = setKockaDobas() + 6;
    }
    
    private static boolean Harc(){
        // Teremtmény
        //tamadoEro[soronJatekos] = setKockaDobas() + setKockaDobas(); // Támadóerő
        broadcast();
        return false;
        
    }
    
    public static String setValaszt(int val){
        return ass[val];
    }
    
    private static int setKockaDobas(){
        // Két kockadobás egyszerre:
        return (int)((Math.random() * 6) + 1);
    }
}

class Helyszin{
    private int id;
    private String szoveg;
    
    public Helyszin(int id, String szoveg){
        this.id = id;
        this.szoveg=szoveg;
    }
    
    public int getId(){
        return id;
    }
    
    public String getSzoveg(){
        return szoveg;
    }
}

class Utvonal{
    private int startID = -1;
    private int celID = -1;
    
    public Utvonal(int start, int cel){
        this.startID = start;
        this.celID = cel;
    }
    
    public int getStartID(){
        return startID;
    }
    public int getCelID(){
        return celID;
    }
}

class Vege{
    private int helyszinID;
    private boolean nyert;
    
    public Vege(int helyszinID, boolean nyert){
        this.helyszinID = helyszinID;
        this.nyert = nyert;
    }
    
    public int getHelyszinID(){
        return helyszinID;
    }
    
    public boolean getNyert(){
        return nyert;
    }
}