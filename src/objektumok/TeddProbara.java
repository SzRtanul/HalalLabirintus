/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objektumok;

/**
 *
 * @author SzabóRoland(SZOFT_20)
 */
public class TeddProbara {
    private int 
            helyszinID, 
            kepessegID;
    
    // Konstruktor
    public TeddProbara(int helyszinID, int kepessegID) {
        this.helyszinID = helyszinID;
        this.kepessegID = kepessegID;
    }

    // Get metódusok
    public int getHelyszinID() {
        return helyszinID;
    }

    public int getKepessegID() {
        return kepessegID;
    }
}
