/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package program;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import objektumok.*;



public final class MainGUI extends javax.swing.JFrame implements EI.BBListener{
    private ButtonGroup valaszt;

    public MainGUI() {
        initComponents();
        initComponentsOverride();
        //La_cim.setIcon(new Icon(null));
        // <editor-fold defaultstate="collapsed" desc="Videó">
        Platform.startup(new Runnable() {
            @Override
            public void run() {
                //Path currentRelativePath = Paths.get("stoh.mp3");
                //File f = new File(currentRelativePath.toAbsolutePath().toString());
                try {
                    //Media hit = new Media(f.toURI().toString());
                    //MediaPlayer mediaPlayer = new MediaPlayer(hit);
                    //mediaPlayer.play();
                    JFXPanel fxPanel = new JFXPanel();
                    Path currentRelativePath = Paths.get("DejaVu.mp4");
                    String s = currentRelativePath.toAbsolutePath().toString();
                    Media media = new Media(new File(s).toURI().toString()); 
                    MediaPlayer mediaPlayer = new MediaPlayer(media);
                    MediaView mediaView = new MediaView(mediaPlayer);
                    
                    DoubleProperty mvw = mediaView.fitWidthProperty();
                    DoubleProperty mvh = mediaView.fitHeightProperty();
                    mvw.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
                    mvh.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
                    mediaView.setPreserveRatio(true);
                    
                    mediaPlayer.setAutoPlay(false);
                    //mediaPlayer.getStatus().equals(Status.PLAYING);
                    mediaPlayer.setOnEndOfMedia(new Runnable() {
                        @Override
                        public void run() {
                            mediaPlayer.seek(Duration.ZERO);
                            mediaPlayer.play();
                        }
                    });
                    Group root = new Group();  
                    root.getChildren().add(mediaView);  
                    
                    fxPanel.setScene(new Scene(new Group(mediaView), fxPanel.getWidth(), fxPanel.getHeight()));
                    fxPanel.setSize(500, 400);
                    fxPanel.setBounds(0, 0, 500, 400);
                    Pa_video.add(fxPanel);
                    
                } catch (Exception e) {
                    System.out.println();
                }   
            }            
        });
        // </editor-fold>
    }
    
    public void initComponentsOverride(){
        SCPa_oldal.getVerticalScrollBar().setUnitIncrement(4);
        HL.addListener(this);
        HL.Restart(true);
        La_oldal.setToolTipText(null);
        this.getContentPane().setBackground(new java.awt.Color(100, 242, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        SCPa_oldal = new javax.swing.JScrollPane();
        La_oldal = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        Bt_tovabb = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Pa_kockak = new javax.swing.JPanel();
        La_ugyesseg = new javax.swing.JLabel();
        La_szerencse = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        La_ero = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        La_cim = new javax.swing.JLabel();
        Pa_video = new javax.swing.JPanel();
        Bt_dob = new javax.swing.JButton();
        SCPa_iranyok = new javax.swing.JScrollPane();
        Pa_irany = new javax.swing.JPanel();
        La_eszkoztar = new javax.swing.JLabel();
        Bt_vissza = new javax.swing.JButton();
        La_oldalszam = new javax.swing.JLabel();
        Bt_csata = new javax.swing.JButton();
        jLabel444 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        SCPa_oldal.setAutoscrolls(true);
        SCPa_oldal.setMaximumSize(new java.awt.Dimension(486, 108));
        SCPa_oldal.setMinimumSize(new java.awt.Dimension(484, 108));

        La_oldal.setBackground(new java.awt.Color(0, 0, 0));
        La_oldal.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        La_oldal.setForeground(new java.awt.Color(255, 51, 51));
        La_oldal.setToolTipText("");
        La_oldal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        La_oldal.setAutoscrolls(true);
        La_oldal.setMaximumSize(new java.awt.Dimension(454, 9999999));
        La_oldal.setMinimumSize(new java.awt.Dimension(454, 96));
        La_oldal.setOpaque(true);
        La_oldal.setPreferredSize(new java.awt.Dimension(454, 1000));
        La_oldal.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        SCPa_oldal.setViewportView(La_oldal);

        jRadioButton1.setText("jRadioButton1");

        Bt_tovabb.setText("Tovább");
        Bt_tovabb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_tovabbActionPerformed(evt);
            }
        });

        jLabel2.setText("Mit lépsz?");

        Pa_kockak.setBackground(new java.awt.Color(153, 51, 0));
        Pa_kockak.setBorder(new javax.swing.border.MatteBorder(null));
        Pa_kockak.setAutoscrolls(true);

        javax.swing.GroupLayout Pa_kockakLayout = new javax.swing.GroupLayout(Pa_kockak);
        Pa_kockak.setLayout(Pa_kockakLayout);
        Pa_kockakLayout.setHorizontalGroup(
            Pa_kockakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        Pa_kockakLayout.setVerticalGroup(
            Pa_kockakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        La_ugyesseg.setText("0");

        La_szerencse.setText("0");

        jLabel5.setText("Szerencse:");

        jLabel6.setText("Erő:");

        La_ero.setText("0");

        jButton1.setText("Be/Ki");

        La_cim.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        La_cim.setText("Halállabirintus");
        La_cim.setToolTipText("");

        javax.swing.GroupLayout Pa_videoLayout = new javax.swing.GroupLayout(Pa_video);
        Pa_video.setLayout(Pa_videoLayout);
        Pa_videoLayout.setHorizontalGroup(
            Pa_videoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );
        Pa_videoLayout.setVerticalGroup(
            Pa_videoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        Bt_dob.setBackground(new java.awt.Color(102, 255, 51));
        Bt_dob.setText("dob");
        Bt_dob.setOpaque(true);
        Bt_dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_dobActionPerformed(evt);
            }
        });

        SCPa_iranyok.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout Pa_iranyLayout = new javax.swing.GroupLayout(Pa_irany);
        Pa_irany.setLayout(Pa_iranyLayout);
        Pa_iranyLayout.setHorizontalGroup(
            Pa_iranyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        Pa_iranyLayout.setVerticalGroup(
            Pa_iranyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        SCPa_iranyok.setViewportView(Pa_irany);

        La_eszkoztar.setBackground(new java.awt.Color(255, 102, 51));
        La_eszkoztar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        La_eszkoztar.setOpaque(true);

        Bt_vissza.setText("Vissza");
        Bt_vissza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_visszaActionPerformed(evt);
            }
        });

        La_oldalszam.setText("0");

        Bt_csata.setText("Csata");
        Bt_csata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_csataActionPerformed(evt);
            }
        });

        jLabel444.setText("Aktuális helyszín:");

        jLabel1.setText("Ügyesség:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(La_cim, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SCPa_oldal, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel444)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(La_oldalszam)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Pa_video, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(La_ero)
                            .addComponent(La_szerencse)
                            .addComponent(La_ugyesseg)))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Bt_tovabb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bt_vissza)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bt_csata))
                    .addComponent(SCPa_iranyok, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pa_kockak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(La_eszkoztar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bt_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(La_cim, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Pa_video, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(La_ugyesseg)
                            .addGap(1, 1, 1))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(La_oldalszam)
                                .addComponent(jLabel444))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(La_szerencse)
                            .addComponent(jLabel5))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(La_ero)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(La_eszkoztar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pa_kockak, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bt_dob, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SCPa_iranyok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Bt_tovabb)
                            .addComponent(Bt_vissza)
                            .addComponent(Bt_csata)))
                    .addComponent(SCPa_oldal, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    // <editor-fold defaultstate="collapsed" desc="Input Műveletek">
    private void Bt_tovabbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_tovabbActionPerformed
        JRadioButton selectedRadioButton = getSelectedRadioButton(valaszt);
        if(selectedRadioButton != null){
            HL.setValaszt(Integer.parseInt(selectedRadioButton.getText()));  
        }
        
       //HL.lapoz();
    }//GEN-LAST:event_Bt_tovabbActionPerformed
    
    private static JRadioButton getSelectedRadioButton(ButtonGroup buttonGroup) {
        for (javax.swing.AbstractButton button : Collections.list(buttonGroup.getElements())) {
            if (button.isSelected()) {
                return (JRadioButton) button;
            }
        }
        return null;
    }
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       HL.removeListener(this);
    }//GEN-LAST:event_formWindowClosed

    private void Bt_visszaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_visszaActionPerformed
        HL.vissza(false);
    }//GEN-LAST:event_Bt_visszaActionPerformed

    private void Bt_dobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_dobActionPerformed
       HL.dob();
    }//GEN-LAST:event_Bt_dobActionPerformed

    private void Bt_csataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_csataActionPerformed
        HarcGUI hc = new HarcGUI();
        hc.setVisible(true);
    }//GEN-LAST:event_Bt_csataActionPerformed
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Main">
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="HTML && String">
    
    public String setKiemelSzamok(String szoveg){
        String s = szoveg;
        s = s.replaceAll("10 000", "<span style=\"color: FFD700;\"> " + "10 000" + " </span>");
        for (var item : Alakit.Modszer.getNumbersFromString(szoveg)){
            System.out.println(item);
            if(s.split(item+"-r").length > 1 || s.split(item+"r").length > 1){    
                s = s.replaceAll(" "+item+"-r", "<span style=\"color: yellow;\"> "+item+"</span>-r");
                s = s.replaceAll(item+"r", "<span style=\"color: yellow;\" >"+item+"</span>-r");
            }
            else if(s.split(item+" kg").length > 1){
                 s = s.replaceAll(" "+item+" kg", "<span style=\"color: 2114C3;\" > "+item+"</span> kg");
            }
            else if(s.split(" " + item + " ").length > 1){
                s =  s.replaceAll(" " + item+ " ", "<span style=\"color: blue;\"> "+item+" </span>");
            }
        }
        return s;
    }
    
    private String getEszkoztarToString(List<InventoryItem> l){
        String s = "";
        for(InventoryItem item : l){
            String itemName = HL.getTargyElnevezesek().stream().filter(x -> x.getID() == item.getTargyID()).findFirst().get().getNev(); 
            s += "<p>"+ getCamelCase(itemName) + ": " + item.getMenny()+"</p>";
        }
        return s;
    }
    // n=3
    // ossz = 6
    // i = 3
    
    public String getCamelCase(String itemName){
        return itemName.substring(0,1).toUpperCase() + itemName.substring(1).toLowerCase();
    }
    
    public String htmlMainTree(String szoveg){
        return String.format(
                "<html>"
                    + "<head>"
                        + "<meta charset=\"UTF-8\">"
                    + "</head>"
                    + "<body>"
                        + "%s"
                    + "</body>"
                + "</html>", szoveg);
    }
    // </editor-fold>
    
    @Override
    protected void finalize() {  
       HL.removeListener(this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bt_csata;
    private javax.swing.JButton Bt_dob;
    private javax.swing.JButton Bt_tovabb;
    private javax.swing.JButton Bt_vissza;
    private javax.swing.JLabel La_cim;
    private javax.swing.JLabel La_ero;
    private javax.swing.JLabel La_eszkoztar;
    private javax.swing.JLabel La_oldal;
    private javax.swing.JLabel La_oldalszam;
    private javax.swing.JLabel La_szerencse;
    private javax.swing.JLabel La_ugyesseg;
    private javax.swing.JPanel Pa_irany;
    private javax.swing.JPanel Pa_kockak;
    private javax.swing.JPanel Pa_video;
    private javax.swing.JScrollPane SCPa_iranyok;
    private javax.swing.JScrollPane SCPa_oldal;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel444;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration//GEN-END:variables

    // <editor-fold defaultstate="collapsed" desc="Event Frissítés">
    @Override
    public void actionValueChanged() {
        SCPa_oldal.getVerticalScrollBar().setValue(0);
        La_oldalszam.setText(HL.getHelyszin().getId()+"");
        
        La_oldal.setText(
                htmlMainTree(
                    "<p style=\"padding: 5px 10px 5px 10px; text-align: justify;\">" +
                        setKiemelSzamok(HL.getHelyszin().getSzoveg()) +
                    "</p>")
        );
        La_eszkoztar.setText(
                    htmlMainTree(getEszkoztarToString(HL.getEszkoztar()))
        );
        
        //La_oldal.setPreferredSize(new Dimension(SCPa_oldal.getWidth()-130, La_oldal.));
        La_oldal.updateUI();
        
        valaszt = new ButtonGroup();
        int db = 0;
        Pa_irany.removeAll();
        
        for (Utvonal item : HL.getLehetosegek()){
            JRadioButton rb = new JRadioButton(item.getCelID() + "");
            valaszt.add(rb);
            rb.setBounds(2, (20 * db) , 2000, 20);
            Pa_irany.add(rb);
            db++;
        }
        Pa_irany.updateUI();
        
        La_ugyesseg.setText(HL.getUgyesseg()+"");
        La_ero.setText(HL.getEro()+"");
        La_szerencse.setText(HL.getSzerencse()+"");
    }
    
    @Override
    public void actionKockadobasKezd(int kockaszam) {
        Pa_kockak.removeAll();
        for(int i = 0; i < kockaszam; i++){
            JLabel kocka = new JLabel();
            Pa_kockak.add(kocka);
            kocka.setBounds((i*42) + 17, (Pa_kockak.getHeight()/2) - 17, 35, 35);
            kocka.setIcon(new ImageIcon(
                    new ImageIcon("kepek\\kockakepek\\kocka" + 1 + ".PNG")
                            .getImage().getScaledInstance(
                                    kocka.getWidth(), 
                                    kocka.getHeight(), 
                                    Image.SCALE_DEFAULT)
            ));
        }
    }

    @Override
    public void actionKockadobasFolyamatban(int[] gen) {
        List<JLabel> kockak = new ArrayList<>();
        for(Component item : Pa_kockak.getComponents()){
            if(item instanceof JLabel) kockak.add((JLabel)item);
        }
        //Pa_kockak.removeAll();
        for(int i = 0; i < gen.length; i++){
            try {
               kockak.get(i).setIcon(
                        new ImageIcon(
                                new ImageIcon("kepek\\kockakepek\\kocka" + gen[i] + ".PNG")
                                        .getImage().getScaledInstance(
                                                kockak.get(i).getWidth(), 
                                                kockak.get(i).getHeight(), 
                                                Image.SCALE_DEFAULT)
                        ));
            } catch (Exception ex) {
                System.out.println("Hoppá! Valami nem stimmel!");
            }
        }
    }
    
    @Override
    public void actionKockadobasVege() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionCsataKezdodik() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionCsataVege() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionJatekVege() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // </editor-fold>
}