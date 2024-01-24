/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objektumok;

/**
 *
 * @author SzabóRoland(SZOFT_20
 */
public class Csata {
    int helyszinID, 
            ellensegID, 
            eletero, 
            ugyesseg, 
            harcCsoportSzam, 
            menny;
    public Csata(int helyszinID, int ellensegID, int eletero, int ugyesseg, int harcCsoportSzam, int menny){
        this.helyszinID = helyszinID;
        this.ellensegID = ellensegID;
        this.eletero = eletero;
        this.ugyesseg = ugyesseg;
        this.harcCsoportSzam = harcCsoportSzam;
        this.menny = menny;
    }
    
    public boolean ut(){
        // Karakter üt
        return false;
    }
    
    public int getHelyszinID() {
        return helyszinID;
    }

    public int getEllensegID() {
        return ellensegID;
    }

    public int getEletero() {
        return eletero;
    }

    public int getUgyesseg() {
        return ugyesseg;
    }

    public int getHarcCsoportSzam() {
      return harcCsoportSzam;
    }

    public int getMenny() {
        return menny;
    }
}
