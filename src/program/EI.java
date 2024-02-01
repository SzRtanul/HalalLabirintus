/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

/**
 *
 * @author SzabóRoland(SZOFT_20
 */
public class EI { //EventInterfaces
    public static interface BBListener{
        public void actionValueChanged();
        
        public void actionKockadobasKezd(int kockaszam);
        public void actionKockadobasFolyamatban(int[] gen);
        public void actionKockadobasVege();
        
        public void actionCsataKezdodik();
        public void actionCsataVege();
        
        public void actionJatekVege();
    }
    
    public static interface FormCenter{
    
    }
}
