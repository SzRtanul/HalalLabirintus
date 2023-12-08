/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author SzabóRoland(SZOFT_20
 */
public class TestApp {  
    public void search() {   
        // For searching  
        System.out.println("Searching...");  
    }  
    public void sort() {   
        // for sorting  
        System.out.println("Sorting....");  
    }  
  
    static public void main(String args[]) {  
       TestApp app = new TestApp();  
       GUI gui = new GUI(app);  
    }  
}  
  
class Command implements ActionListener  {  
    static final int SEARCH = 0;  
    static final int SORT = 1;  
    int id;  
    TestApp app;  
  
    public Command(int id, TestApp app) {  
        this.id = id;  
        this.app = app;  
    }  
  
    public void actionPerformed(ActionEvent e) {  
        switch(id) {  
          case SEARCH:   
            app.search();  
            break;  
          case SORT:  
            app.sort();  
            break;  
        }  
    }  
}  
  
class GUI {  
  
    public GUI(TestApp app) {  
        Frame f = new Frame();  
        f.setLayout(new FlowLayout());            
  
        Command searchCmd = new Command(Command.SEARCH, app);  
        Command sortCmd = new Command(Command.SORT, app);  
  
        Button b;  
        f.add(b = new Button("Search"));  
        b.addActionListener(searchCmd);  
        f.add(b = new Button("Sort"));  
        b.addActionListener(sortCmd);  
  
        List l;  
        f.add(l = new List());  
        l.add("Alphabetical");  
        l.add("Chronological");  
        l.addActionListener(sortCmd);  
        f.pack();  
  
        f.show();  
    }  
}  
