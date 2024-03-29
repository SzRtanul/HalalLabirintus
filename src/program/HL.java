/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import objektumok.*;

/**
 *
 * @author SzabóRoland(SZOFT_20
 */
public class HL {
    
    // <editor-fold defaultstate="collapsed" desc="Event implmentation">
    private static Set<EI.BBListener> listeners = new HashSet();
    
    public static void addListener(EI.BBListener listener) {
        listeners.add(listener);
    }
    
    public static void removeListener(EI.BBListener listener) {
        listeners.remove(listener);
        broadcast();
    }

    private static void broadcast() {
        deleteZeroElements();
        if(listeners.stream().count() > 0) listeners.forEach(x -> x.actionValueChanged());
    }
    // </editor-fold>
    
    private static int ugyesseg = 0;
    private static int eletero = 0;
    private static int szerencse = 0;
    //int tamadoEro = 0;
    
    
    //Játék lépései:
    private static byte lepesek = 3; // {megy, tárgyár, mehet?, csata}
    private static int aktualisHelyszin = 1;
    private static int soronJatekos = 0;
    /*
    private static java.util.List<String> targyak;
    private static java.util.List<String> ekkovek;
    private static java.util.List<String> italok;
    private static java.util.List<String> etelkeszlet;
    */
    //private static List<>
    private static int helyszinValtas = 0;
    private final static Stack<Integer> kockak = new Stack<>(); 
    private final static Stack<Integer> helyszinElozmeny = new Stack<>();
    
    // <editor-fold defaultstate="collapsed" desc="Szótár">
    private final static List<Targy> targyak = new ArrayList<>();
    private final static List<Ellenseg> ellensegek = new ArrayList<>();
    private final static List<Helyszin> helyszinek = new ArrayList<>();
    // </editor-fold>
    
    
    private final static List<InventoryItem> eszkoztar = new ArrayList<>();
    private final static List<Utvonal> utvonalak = new ArrayList<>();
    private final static List<TargyAr> targyarak = new ArrayList<>();
    private final static List<Csata> csatak = new ArrayList<>();
    private final static List<TudasAnyag> tudasanyag = new ArrayList<>();
    private final static List<Vege> vege = new ArrayList<>();
    
    // GUI visszaad
    
    
    
    //private static String[] ass = new String[400];
    //private static int arany = 0;
     
    public static void Restart(boolean reupload){
        ugyesseg = setKockaDobas() +6;
        eletero = setKockaDobas() + setKockaDobas() + 12;
        szerencse = setKockaDobas() + 6;

        aktualisHelyszin = 1;
        soronJatekos = 0;
        
        if(reupload){
            fileUploads();
        }
        broadcast();
    }
    
    private static boolean deleteZeroElements(){
        targyarak.removeAll(targyarak.stream().filter(x -> x.getAr()== 0).toList());
        eszkoztar.removeAll(eszkoztar.stream().filter(x -> x.getMenny() == 0).toList());
        return false;
    }
    // <editor-fold defaultstate="collapsed" desc="Input">
    private static boolean tamad(int index, boolean szerencs){
        // Teremtmény
        //tamadoEro[soronJatekos] = setKockaDobas() + setKockaDobas(); // Támadóerő
        
        List<Csata> idCsata = getEllenfelek();
        szerencse -= szerencs ? 1 : 0;
        if(kockak.stream().count() == 2){
            if(soronJatekos == 0){
                csatak.get(csatak.indexOf(idCsata.get(index)))
                        .ut(eletero, ugyesseg + kockak.pop() + kockak.pop(), true); 
                soronJatekos++;
                //Játékos választ
            }
            else{
                ellenfelUt(idCsata.get(soronJatekos)); //Játlkost ütik
                soronJatekos++;
                if(soronJatekos == idCsata.stream().count()){
                    soronJatekos = 0;
                }
            }
            
            
            
        }
        
        broadcast();
        return false;   
    }
    
    public static boolean ellenfelUt(Csata ellenfel){
        
        eletero = eletero;
        ugyesseg = ugyesseg;
        return false;
    }
    
    public static boolean lapoz(){
        boolean both = false;
        helyszinElozmeny.push(aktualisHelyszin);
        if(setHelyszin(aktualisHelyszin += 1)){ 
            helyszinValtas++;
            both=true;
        }
        return both;
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
        if(!helyszinElozmeny.isEmpty()){
            helyszinValtas += elore ? 1 : -1;
            aktualisHelyszin = helyszinElozmeny.pop();
            setHelyszin(aktualisHelyszin);
            both = true;
        }
        return both;
    }
    
     private static boolean setHelyszin(int oldalszam){
        boolean both = false;
        boolean fizet = true;
        
        
        for (TargyAr item2 : targyarak.stream().filter(x->x.getHelyszinID() == oldalszam).toList()){
            if(eszkoztar.stream().filter(x -> x.getTargyID() == item2.getTargyID()).count() == 0){
                eszkoztar.add(new InventoryItem(item2.getTargyID()));
            }
            if(eszkoztar.stream().filter(x -> x.getTargyID() == item2.getTargyID()).findFirst().get().getMenny() + item2.getAr() < 0){
                    fizet = false;
            }
        }
        
        Helyszin hly = helyszinek.stream().filter(x -> x.getId() == oldalszam).findFirst().get();
        if(fizet){
            for (InventoryItem item : eszkoztar){
                for (TargyAr item2 : targyarak.stream().filter(x->x.getHelyszinID() == oldalszam).toList()){
                    eszkoztar.stream().filter(x -> x.equals(item)).findFirst().get().ad(item2.getAr());
                    targyarak.stream().filter(x -> x.equals(item2)).findFirst().get().vesz();
                }
            }
            both = true;
            aktualisHelyszin = oldalszam;
            broadcast();
        }
        
        return true;
    } 
     
     public static boolean dob(){
        Runnable r = new Runnable() {
          public void run() {
            kockak.clear();
            int[] gen = new int[2];
            int rotate = (int)Math.floor((Math.random()*63)+37);
        listeners.forEach(x -> x.actionKockadobasKezd(gen.length));
        for (int i = 0; i < rotate; i++) {
            for(int j = 0; j < gen.length; j++){
                gen[j] = (int)Math.floor((Math.random()*6)+1);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch (InterruptedException ex) {
                Logger.getLogger(HL.class.getName()).log(Level.SEVERE, null, ex);
            }
            final int[] localRitard = gen;
            listeners.forEach(listener -> listener.actionKockadobasFolyamatban(localRitard));
        }
        for(int item : gen){
            kockak.push(item);
        }
          }
        };
        Thread asd = new Thread(r);
        asd.start();
        
        return true;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Output">
     
     // <editor-fold defaultstate="collapsed" desc="TargyLista">
     
    public static List<Targy> getTargyElnevezesek(){
        return targyak;
    }
     
    public static String getTargyNev(int id){
        return targyak.stream().filter(x -> x.getID() == id).findFirst().get().getNev();
    }
     
     // </editor-fold>
    public static List<Integer> getKockak(){
        
        
        return new ArrayList<Integer>();
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
    
    public static List<InventoryItem> getEszkoztar(){
        return eszkoztar.stream().toList();
    }
    
    public static List<Csata> getEllenfelek(){
        return csatak.stream().filter(x -> x.getHelyszinID() == aktualisHelyszin).toList();
    }
    
    public static String getEllenfelNev(int id){
        return ellensegek.stream().filter(x -> x.getID() == id).findFirst().get().getNev();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Loading">
    public static List<String> uploadList(String filename){
        File f = new File(filename);
        List<String> items = new ArrayList<>();
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
        
        
        
        
        
        int i = 0;
        String filename = "szotar\\helyszinek.txt";
        helyszinek.clear();
        for(String item : uploadList(filename)){
            try {
                String[] sp = item.split("\\|");
                helyszinek.add(new Helyszin(Integer.parseInt(sp[0]), sp[1])); 
            } catch (Exception e) {
                System.out.println(String.format("A %s fájl %d. sorával probléma akadt.", filename, i));
            }
            i++;
        }
        
        i = 0;
        filename = "muvelet\\utvonalak.txt";
        utvonalak.clear();
        for(String item : uploadList(filename)){
            try {
                String[] sp = item.split(";");
                utvonalak.add(new Utvonal(Integer.parseInt(sp[0]), Integer.parseInt(sp[1]))); 
            } catch (Exception e) {
                System.out.println(String.format("A %s fájl %d. sorával probléma akadt.", filename, i));
            }
            i++;
        }
        
         i = 0;
        filename = "szotar\\targy.txt";
        targyak.clear();
        for(String item : uploadList(filename)){
            try {
                String[] sp = item.split(";");
                targyak.add(new Targy(Integer.parseInt(sp[0]), sp[1]));
            } catch (Exception e) {
                System.out.println(String.format("A %s fájl %d. sorával probléma akadt.", filename, i));
            }
            i++;
        }
        
        i = 0;
        filename = "muvelet\\targyar.txt";
        targyarak.clear();
        for(String item : uploadList(filename)){
            try {
                String[] sp = item.split(";");
                targyarak.add(new TargyAr(
                        Integer.parseInt(sp[0]), 
                        Integer.parseInt(sp[1]), 
                        Integer.parseInt(sp[2]), 
                        sp[3].equals("1"))
                ); 
            } catch (Exception e) {
                System.out.println(String.format("A %s fájl %d. sorával probléma akadt.", filename, i));
            }
            i++;
        }
        
        i = 0;
        filename = "muvelet\\vege.txt";
        vege.clear();
        for(String item : uploadList(filename)){
            try {
                String[] sp = item.split(";");
                vege.add(new Vege(Integer.parseInt(sp[0]), sp[1].equals("1"))); 
            } catch (Exception e) {
                System.out.println(String.format("A %s fájl %d. sorával probléma akadt.", filename, i));
            }
            i++;
        }
        
        i = 0;
        filename = "muvelet\\csatak.txt";
        csatak.clear();
        for(String item : uploadList(filename)){
            try {
                String[] sp = item.split(";");
                csatak.add(new Csata(
                        Integer.parseInt(sp[0]), 
                        Integer.parseInt(sp[1]), 
                        Integer.parseInt(sp[1]), 
                        Integer.parseInt(sp[2]), 
                        Integer.parseInt(sp[3]), 
                        Integer.parseInt(sp[4]))
                ); 
            } catch (Exception e) {
                System.out.println(String.format("A %s fájl %d. sorával probléma akadt.", filename, i));
            }
            i++;
        }
        
        i = 0;
        filename = "szotar\\ellenseg.txt";
        ellensegek.clear();
        for(String item : uploadList(filename)){
            try {
                String[] sp = item.split(";");
                ellensegek.add(new Ellenseg(Integer.parseInt(sp[0]), sp[1])); 
            } catch (Exception e) {
                System.out.println(String.format("A %s fájl %d. sorával probléma akadt.", filename, i));
            }
            i++;
        }
        
        i = 0;
        filename = "muvelet\\tudasanyag.txt";
        tudasanyag.clear();
        for(String item : uploadList(filename)){
            try {
                String[] sp = item.split(";");
                tudasanyag.add(new TudasAnyag(
                        Integer.parseInt(sp[0]), 
                        Integer.parseInt(sp[1]))
                ); 
            } catch (Exception e) {
                System.out.println(String.format("A %s fájl %d. sorával probléma akadt.", filename, i));
            }
            i++;
        }
    }
     // </editor-fold>
}
