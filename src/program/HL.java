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
public class Jatek {
    
    // <editor-fold defaultstate="collapsed" desc="Event implmentation">
    private Set<EI.CCListener> listeners = new HashSet();
    
    public void addListener(EI.CCListener listener) {
        listeners.add(listener);
    }
    
    public void removeListener(EI.CCListener listener) {
        listeners.remove(listener);
    }

    private void broadcast() {
        listeners.forEach(x -> x.actionValueChanged());
    }
    // </editor-fold>
    
    int uyesseg = 0, eletero=0, szerencse=0;
    int soronJatekos = 0; // 0: Ellenség, 1: Te
    //int tamadoEro = 0;
    
    String[] oldalak = {
        "Egy versenyre nevezel, aminek a lényege, hogy át kell kelni a halállabirintuson. A labirintusban tárgyakat találhatsz és szörnyekkel kell harcoljál.",
        "Miután öt percet haladtál lassan az alagútban, egy kőasztalhoz érsz, amely a bal oldali fal mellett áll. Hat doboz van rajta, egyikükre a te neved festették. Ha kiakarod nyitni a dobozt, lapozz a 270-re. Ha inkább tovább haladsz észak felé, lapozz a 66-ra.",
        "Látod, hogy az akadály egy széles, barna, sziklaszerű tárgy. Megérinted, és meglepve tapasztalod, hogy lágy, szivacsszerű. Ha át szeretnél mászni rajta, lapozz a 373-ra. Ha ketté akarod vágni a kardoddal, lapozz a 215-re.",
        "Néhány perc gyaloglás után egy elágazáshoz érsz az alagútban. Egy, a falra festett fehér nyíl nyugatfelé mutat. A földön nedves lábnyomok jelzik, merre haladtak az előtted járók. Nehéz biztosan megmondani, de úgy tűnik, hogy három közülük a nyíl irányába halad, míg egyikük úgy döntött, hogy keletnek megy. Ha nyugat felé kívánsz menni, lapozz a 293-ra. Ha keletnek, lapozz a 56-re.",
        "Ahogy végigmész az alagúton, csodálkozva látod, hogy egy jókora vasharang csüng alá a boltozatról.",
        "Kardod könnyedén áthatol a spóragolyó vékonykülső burkán. Sűrű barna spórafelhő csap ki a golyóból, és körülvesz. Némelyik spóra a bőrödhöz tapad, és rettenetes viszketést okoz. Nagy daganatok nőnek az arcodon és karodon, és a bőröd mintha égne. 2 ÉLETERŐ pontot veszítesz. Vadul vakarózva átléped a leeresztett golyót, és keletnek veszed az utad.",
        "A doboz teteje könnyedén nyílik. Benne két aranypénzt találsz, és egy üzenetet, amely egy kis pergamenen neked szól. Előbb zsebre vágod az aranyakat, aztán elolvasod az üzenetet: - „Jól tetted. Legalább volt annyi eszed, hogy megállj és elfogadd az ajándékot. Most azt tanácsolom neked, hogy keress és használj különféle tárgyakat, ha sikerrel akarsz áthaladni Halállabirintusomon.” Azaláírás Szukumvit. Megjegyzed a tanácsot, apródarabokra téped a pergament, és tovább mészészak felé. Lapozz a 66-ra.",
        "A három pár nedves lábnyomot követve az alagútnyugati elágazásában hamarosan egy újabb el-ágazáshoz érsz. Ha továbbmész nyugat felé a lábnyomokat követve, lapozz a 137-re. Ha inkább észak felé mész a harmadik pár lábnyom után, lapozz a 387-re.",
        "Fölmászol a lágy sziklára, attól tartasz, hogy bár-melyik pillanatban elnyelhet. Nehéz átvergődni rajta, mert puha anyagában alig tudod a lábadat emelni, de végül átvergődsz rajta. Megkönnyebbülten érsz újra szilárd talajra, és fordulsz kelet felé.",
        "Hallod, hogy elölről súlyos lépések közelednek. Egy széles, állatbőrökbe öltözött, kőbaltás, primitívlény lép elő. Ahogy meglát, morog, a földre köp, majd a kőbaltát felemelve közeledik, és mindennek kinéz, csak barátságosnak nem. Előhúzod kardodat, és felkészülsz, hogy megküzdj a Barlangi Emberrel."    
    };
    
    java.util.List<String> targyak;
    java.util.List<String> ekkovek;
    java.util.List<String> italok;
    java.util.List<String> etelkeszlet;
    
    String[] ass = new String[400];
    int arany = 0;
     
    public Jatek(){
        this.uyesseg = setKockaDobas() +6;
        this.eletero = setKockaDobas() + setKockaDobas() + 12;
        this.szerencse = setKockaDobas() + 6;
    }
    
    private boolean Harc(){
        // Teremtmény
        //tamadoEro[soronJatekos] = setKockaDobas() + setKockaDobas(); // Támadóerő
        broadcast();
        return false;
        
    }
    
    public String setValaszt(int val){
        return ass[val];
    }
    
    private int setKockaDobas(){
        // Két kockadobás egyszerre:
        return (int)((Math.random() * 6) + 1);
    }
}

class KalandOldal{
    int oldalszam;
    int[] mutat;
    String oldalszoveg = "";
    
    int uyesseg = 0, eletero=0, szerencse=0;
    
    public KalandOldal(int oldalszam, int[] mutat, String oldalszoveg){
        this.oldalszoveg = oldalszoveg; 
        this.oldalszam = oldalszam;
        
        this.mutat = mutat;
        
    }
    
    public boolean setParameters(){
        return false;
    }
}