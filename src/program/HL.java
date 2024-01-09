/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
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
    private final static List<Integer> helyszinElozmeny = new ArrayList<Integer>();
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
        uyesseg = setKockaDobas() +6;
        eletero = setKockaDobas() + setKockaDobas() + 12;
        szerencse = setKockaDobas() + 6;
        if(reupload){
            fileUploads();
        }
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
    
    private static boolean Harc(){
        // Teremtmény
        //tamadoEro[soronJatekos] = setKockaDobas() + setKockaDobas(); // Támadóerő
        broadcast();
        return false;
        
    }
    
    public static boolean setValaszt(int val){
        
        return false;
    }
    
    private static int setKockaDobas(){
        helyszinElozmeny.add(1);
        // Két kockadobás egyszerre:
        return (int)((Math.random() * 6) + 1);
    }
    
    public static boolean vissza(boolean elore){
        boolean both = false;
        if(helyszinValtas > 0 && helyszinValtas < helyszinElozmeny.size()-1){
            helyszinValtas += elore ? 1 : -1;
            aktualisHelyszin = helyszinElozmeny.indexOf(helyszinValtas);
            both = true;
        }
        return both;
    }
    
    public static boolean setHelyszin(int val){
        aktualisHelyszin = val;
        broadcast();
        return false;
    }
    
    public List<Utvonal> getLehetosegek(){
        return utvonalak.stream().filter(x -> x.getStartID() == aktualisHelyszin).toList();
    }
    
    public String getLeiras(){
        return helyszinek.stream().filter(x -> x.getId() == aktualisHelyszin).findFirst().get().getSzoveg();
    }
}

class InventoryItem{
    private int targyID;
    private int menny;
    
    public InventoryItem(int targyID){
        this.menny = 0;
        this.targyID = targyID;
    }
    
    public int getTargyID(){
        return targyID;
    }
    
    public int getMenny(){
        return menny;
    }
    
    public boolean ad(int menny){
        boolean both = false;
        if(this.menny + menny >= 0){
            this.menny += menny;
            both = true;
        }
        return both;
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

class Targy{
    private int id;
    private String nev;
    
    public Targy(int id, String nev){
        this.id = id;
        this.nev = nev;
    }
    
    public int getID(){
        return id;
    }
    
    public String getNev(){
        return nev;
    }
}

class TargyAr{
    private int helyszinID;
    private int targyID;
    private int ar;
    private boolean egyszerFizetendo;
    
    public TargyAr(int helyszinID, int targyID, int ar, boolean egyszerFizetendo){
        this.helyszinID = helyszinID;
        this.targyID = targyID;
        this.ar = ar;
        this.egyszerFizetendo = egyszerFizetendo;
    }
    
    public int getHelyszinID(){
        return helyszinID;
    }
    
    public int getTargyID(){
        return targyID;
    }
    
     public int getAr(){
        return ar;
    }
     
    public boolean vesz(){
        boolean both = true;
        if (egyszerFizetendo) {
            ar = 0;
        }
        return both;
    }
}

