package de.game.bomberman;

import de.game.bomberman.Bomberman;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 * @author Aenderungen durch Ilgar (JavaDoc-Kommentaren);
 * Die Klasse Hauptmenue ist fuer das Hauptmenue des Spiels verantwortlich.
 * Hier wird unter anderem der Name des Spiels, die Buttons im Fenster
 * und das Layout festgesetzt.
 * Hier werden die Buttons mit Inhalt versehen, so wird die Taste "Beenden" mit dem Befehlt
 * das Spiel zu beenden verknuepft.
 * Hier ist die Main-Klasse drinnen, wo der Compiler anfaengt zu kompilieren.
 * In dieser Klasse wird ein Listener fuer die Buttons hinzugefuegt.
 */
public class Hauptmenu {
  
  /**
   * @param args
   * ## Die Main-Klasse
   */
  public static void main(String[] args) {
    
    // Buttons, labels, frames, panels
    final CardLayout cardlayout = new CardLayout();
    
    // Name des Frames
    final JFrame window = new JFrame("Bombastischer Mann"); 
    JPanel menu = new JPanel();
    JPanel buttons = new JPanel();
    // Name der Ueberschrift
    JLabel titeltext = new JLabel("BOMBERMAAAN"); 
    
    // steuert die Groesse aller Buttons
    Dimension groessebutton = new Dimension(160, 50); 
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    // Die Buttons im Menue-Fenster
    JButton singleb = new JButton("Play! (Windowed)");
    JButton fullb = new JButton("Play! (Fullscreen) ");
    JButton optionenb = new JButton("Optionen (In Arbeit!) ");
    JButton exitb = new JButton("Beenden");
    
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Layout wird festgesetzt
    // Groesse des Fensters in Pixeln
    window.setSize(700, 450); 
    // Layout des Fensters
    window.setLayout(cardlayout);
    menu.setLayout(new GridLayout(3, 1));
    window.setLocation((int) screenSize.getWidth() / 2 - window.getWidth() / 2,
        (int) screenSize.getHeight() / 2 - window.getHeight() / 2);
    
    // Position des Fensters beim Erscheinen
    buttons.setLayout(new FlowLayout());
    titeltext.setHorizontalAlignment(0);
    window.setResizable(false);
    
    // die Groesse der Buttons
    singleb.setPreferredSize(groessebutton);
    fullb.setPreferredSize(groessebutton);
    optionenb.setPreferredSize(groessebutton);
    exitb.setPreferredSize(groessebutton);
    
    // buttons zu den panels hinzufuegen
    buttons.add(singleb);
    buttons.add(fullb);
    buttons.add(optionenb);
    buttons.add(exitb);
    
    // die Art des Fensters
    titeltext.setFont(new Font("Arial", Font.BOLD, 15)); 
    
    // ...und in den frame
    menu.add(titeltext);
    menu.add(buttons);
    
    window.add(menu, "hauptmenu");
    
    window.setVisible(true);
    cardlayout.show(window.getContentPane(), "hauptmenu");
    
    // ActionListener, was eigentlich bei einem Klick gemacht wird
    
    // Singleplayer
    ActionListener splayer = new ActionListener() {
      
      @Override
      /* 
       * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
       */
      public void actionPerformed(ActionEvent evt) {
        // Anweisungen um Singleplayer zu starten
        AppGameContainer container = null;
        try {
          // Fenster des Spiels
          container = new AppGameContainer(new Bomberman(), 640, 480, false);
        } catch (SlickException e1) {
          e1.printStackTrace();
        }
        try {
          container.start();
        } catch (SlickException e1) {
          e1.printStackTrace();
        }
      }
    };
    
    // Fullscreen
    ActionListener fscreen = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent evt) {
        // Fullscreen
        try {
          AppGameContainer container = new AppGameContainer(null);
          container = new AppGameContainer(new Bomberman(),container.getScreenWidth(), container.getScreenHeight(), true);
          container.start();
        } catch (SlickException e1) {
          e1.printStackTrace();
        }
      }
    };
    
    // Beenden
    ActionListener beenden = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        System.exit(0);
      }
    };
    
    // listener hinzufuegen
    singleb.addActionListener(splayer);
    fullb.addActionListener(fscreen);
    exitb.addActionListener(beenden);
  }
  
}