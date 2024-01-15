/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SzabóRoland(SZOFT_20
 */
public class Alakit {
    static class Modszer{
        public static List<Integer> getNumbersFromString(String szoveg){
            szoveg = szoveg.replaceAll(" ", "i");
            List<Integer> szamok = new ArrayList<Integer>();
            char[] csari = szoveg.toCharArray();
            String szam = "";
            
            for(char item : csari) {
                if(Character.isDigit(item)){
                    szam += item;
                }
                else if(szam != ""){
                    szamok.add(Integer.parseInt(szam));
                    szam = "";
                }
            }
            return szamok;
        }
    }
}
