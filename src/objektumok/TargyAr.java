/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objektumok;

/**
 *
 * @author SzabóRoland(SZOFT_20
 */
public class TargyAr {
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
