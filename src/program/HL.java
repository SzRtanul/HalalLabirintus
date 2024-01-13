/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.*;
import objektumok.*;

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
    
    private static int ugyesseg = 0;
    private static int eletero = 0;
    private static int szerencse = 0;
    //int tamadoEro = 0;
    
    
    //Játék lépései:
    private static byte lepesek = 3; // {megy, tárgyár, mehet?, csata}
    private static int aktualisHelyszin = 1;
    /*
    private static java.util.List<String> targyak;
    private static java.util.List<String> ekkovek;
    private static java.util.List<String> italok;
    private static java.util.List<String> etelkeszlet;
    */
    //private static List<>
    private static int helyszinValtas = 0;
    private final static Stack<Integer> helyszinElozmeny = new Stack<Integer>();
    private final static List<InventoryItem> eszkoztar = new ArrayList<InventoryItem>();
    
    
    private final static List<Helyszin> helyszinek = new ArrayList<Helyszin>();
    private final static List<Utvonal> utvonalak = new ArrayList<Utvonal>();
    
    private final static List<Targy> targyak = new ArrayList<Targy>();
    private final static List<TargyAr> targyar = new ArrayList<TargyAr>();
    private final static List<Vege> vege = new ArrayList<Vege>();
    
    // GUI visszaad
    
    
    
    //private static String[] ass = new String[400];
    //private static int arany = 0;
     
    public static void Restart(boolean reupload){
        ugyesseg = setKockaDobas() +6;
        eletero = setKockaDobas() + setKockaDobas() + 12;
        szerencse = setKockaDobas() + 6;
        
        aktualisHelyszin = 1;
        
        if(reupload){
            fileUploads();
        }
        broadcast();
    }
    
    private static boolean Harc(){
        // Teremtmény
        //tamadoEro[soronJatekos] = setKockaDobas() + setKockaDobas(); // Támadóerő
        broadcast();
        return false;
        
    }
    
    public static boolean setValaszt(int val){
        helyszinElozmeny.push(aktualisHelyszin);
        if(setHelyszin(val)){ 
            helyszinValtas++;
        }
        return false;
    }
    
    private static int setKockaDobas(){
        //helyszinElozmeny.add(1);
        // Két kockadobás egyszerre:
        return (int)((Math.random() * 6) + 1);
    }
    
    public static boolean vissza(boolean elore){
        boolean both = false;
        if(helyszinElozmeny.size() > 0){
            helyszinValtas += elore ? 1 : -1;
            aktualisHelyszin = helyszinElozmeny.pop();
            for(int item : helyszinElozmeny){
                System.out.println(item);
            }
            System.out.println(helyszinValtas);
            System.out.println(aktualisHelyszin);
            setHelyszin(aktualisHelyszin);
            both = true;
        }
        return both;
    }
    
    private static boolean setHelyszin(int val){
        aktualisHelyszin = val;
        broadcast();
        return true;
    }
    
    public static List<Utvonal> getLehetosegek(){
        return utvonalak.stream().filter(x -> x.getStartID() == aktualisHelyszin).toList();
    }
    
    public static Helyszin getHelyszin(){
        return helyszinek.stream().filter(x -> x.getId() == aktualisHelyszin).findFirst().get();
    }
    
    public static int getUgyesseg(){
        return ugyesseg;
    }
    
    public static int getEro(){
        return eletero;
    }
    
    public static int getSzerencse(){
        return szerencse;
    }
    
    public static List<String> uploadList(String filename){
        File f = new File(filename);
        List<String> items = new ArrayList<String>();
        try(Scanner sc = new Scanner(f, "utf-8")){
            for(int i=0; sc.hasNextLine(); i++){
                items.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nem található a fájl.");
        }
        return items;
    }
    
    
    
     public static void fileUploads(){
        eszkoztar.clear();
        helyszinek.clear();
        utvonalak.clear();
        targyak.clear();
        targyar.clear();
        
        int i = 0;
        String filename = "helyszinek.txt";
        for(String item : uploadList(filename)){
            try {
                String[] sp = item.split(";");
                helyszinek.add(new Helyszin(Integer.parseInt(sp[0]), sp[1])); 
            } catch (Exception e) {
                System.out.println(String.format("A %s fájl %d. sorával probléma akadt.", filename, i));
            }
            i++;
        }
        
        i = 0;
        filename = "utvonalak.txt";
        for(String item : uploadList(filename)){
            try {
                String[] sp = item.split(";");
                utvonalak.add(new Utvonal(Integer.parseInt(sp[0]), Integer.parseInt(sp[1]))); 
            } catch (Exception e) {
                System.out.println(String.format("A %s fájl %d. sorával probléma akadt.", filename, i));
            }
            i++;
        }
    }
}
