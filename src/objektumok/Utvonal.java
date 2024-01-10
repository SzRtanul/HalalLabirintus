/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objektumok;

/**
 *
 * @author SzabóRoland(SZOFT_20
 */
public class Utvonal {
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
