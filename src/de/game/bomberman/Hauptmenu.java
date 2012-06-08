package de.game.bomberman;

import de.game.bomberman.Bomberman;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Hauptmenu {
  
  public static void main(String[] args) {
    
    // Buttons, labels, frames, panels
    final CardLayout cardlayout = new CardLayout();
    
    final JFrame window = new JFrame("Bombastischer Mann"); // Name des Frames
    JPanel menu = new JPanel();
    JPanel buttons = new JPanel();
    JLabel titeltext = new JLabel("BOMBERMAAAN"); // Name der Ueberschrift
    
    Dimension groessebutton = new Dimension(160, 50); // steuert die Groesse
                                                      // aller Buttons
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    JButton singleb = new JButton("Play! (Windowed)");
    JButton fullb = new JButton("Play! (Fullscreen) ");
    JButton optionenb = new JButton("Optionen (In Arbeit!) ");
    JButton exitb = new JButton("Beenden");
    
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Layout wird festgesetzt
    window.setSize(700, 450); // Groesse des Fensters in Pixeln
    window.setLayout(cardlayout);
    menu.setLayout(new GridLayout(3, 1));
    window.setLocation((int) screenSize.getWidth() / 2 - window.getWidth() / 2,
        (int) screenSize.getHeight() / 2 - window.getHeight() / 2); // Position
                                                                    // des
                                                                    // Fensters
                                                                    // bei
                                                                    // erscheinen
    buttons.setLayout(new FlowLayout());
    titeltext.setHorizontalAlignment(0);
    window.setResizable(false);
    
    singleb.setPreferredSize(groessebutton);
    fullb.setPreferredSize(groessebutton);
    optionenb.setPreferredSize(groessebutton);
    exitb.setPreferredSize(groessebutton);
    
    // buttons zu den panels hinzufuegen
    buttons.add(singleb);
    buttons.add(fullb);
    buttons.add(optionenb);
    buttons.add(exitb);
    
    titeltext.setFont(new Font("Arial", Font.BOLD, 15)); // steuert Groesse und
                                                         // Font des obersten
                                                         // labels
    
    // ...und in den frame
    menu.add(titeltext);
    menu.add(buttons);
    
    window.add(menu, "hauptmenu");
    
    window.setVisible(true);
    cardlayout.show(window.getContentPane(), "hauptmenu");
    
    // ActionListener, was eigentlich bei einem klick gemacht wird
    
    // Singleplayer
    ActionListener splayer = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        // Anweisungen um Singleplayer zu starten
        AppGameContainer container = null;
        try {
          container = new AppGameContainer(new Bomberman(), 640, 480, false);
        } catch (SlickException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        try {
          container.start();
        } catch (SlickException e1) {
          // TODO Auto-generated catch block
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
          // TODO Auto-generated catch block
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