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
    private int arrayCount;
    private int[] helyszinID, targyID, ar;
    private boolean[] egyszerFizetendo;
    
    
    public TargyAr(){
        arrayCount = 0;
    }
   /* 
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
*/
    public synchronized boolean readSorok(String[] sorok, String jel) throws Exception {
        boolean both = true;
        int kezd = arrayCount;
        arrayCount += sorok.length;
        
        for (int i = 0; i < sorok.length; i++) {
            String[] szetvalaszt = sorok[i].split(jel);
            try {
                
            } catch (Exception e) {
                throw new Exception(
                        "A %s osztály %d. sorával probléma történt a beolvasás során."
                                .formatted(this.getClass().getName(), i));
            }
        }
        return both;
    }
    
    public synchronized boolean deleteElem(int index){
        return deleteElem(index, index);
    }
    
    public synchronized boolean deleteElem(int firstIndex, int lastIndex){
        boolean both = firstIndex >= 0 && lastIndex < arrayCount;
        for (int i = firstIndex; i < lastIndex; i++) {
            helyszinID[i] = 0;
            targyID[i] = 0;
            ar[i] = 0;
            egyszerFizetendo[i] = false;
        }
        return both;
    }
    
    // <editor-fold defaultstate="collapsed" desc="GET">
    public int[] getHelyszinID() {
        return helyszinID;
    }
    
    public int[] getTargyID() {
        return targyID;
    }
    
    public int[] getAr() {
        return ar;
    }
    
    public boolean[] getEgyszerFizetendo() {
        return egyszerFizetendo;
    }
    // </editor-fold>
}
