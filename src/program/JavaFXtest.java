/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author SzabóRoland(SZOFT_20
 */
public class JavaFXtest {
    public JavaFXtest(){
        
    }
    
    public boolean play(){
         Path currentRelativePath = Paths.get("stoh.mp3");
        File f = new File(currentRelativePath.toAbsolutePath().toString());
        try {
            Media hit = new Media(f.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.play();                    
        } catch (Exception e) {
            System.out.println();
        }   

        return false;
    }
    
    public static void main(String args[]) {
        Platform.startup(new Runnable() {
            @Override
            public void run() {
                           }
        });   
    }
}
