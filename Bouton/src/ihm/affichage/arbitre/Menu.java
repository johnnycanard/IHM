package ihm.affichage.arbitre;

import ihm.affichage.arbitre.base.Base;
import ihm.affichage.arbitre.changement.Renduchangement;
import ihm.affichage.arbitre.chronometre.Modificationchrono;
import ihm.affichage.arbitre.faute.Rendufaute;
import ihm.affichage.arbitre.panier.Rendupanier;
import ihm.affichage.arbitre.tempsmort.Tempsmort;
import ihm.affichage.panneau.Panneau;
import ihm.match.Joueur;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guillaumehalb
 */
public class Menu extends JFrame {
    
    private Panneau panneau;
    
    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Menu(Panneau panneau) {
        
        this.panneau = panneau;
        
        this.setTitle("MENU");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font font = new Font("Equipe", Font.BOLD, 50);

        // Creation de 6 boutons :
        JButton b1 = new JButton("Base");
        b1.setPreferredSize(new Dimension(X / 3, Y / 2));
        b1.setBackground(Color.WHITE);
        b1.setFont(font);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();                
                Base base = new Base(panneau);
            }
        });

        JButton b2 = new JButton("Faute");
        b2.setPreferredSize(new Dimension(X / 3, Y / 2));
        b2.setBackground(Color.WHITE);
        b2.setFont(font);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Rendufaute rf = new Rendufaute("FAUTE", 
                        panneau.getEquipe("GREEN").getTerrain().getFirst().getNum(),
                        "GREEN", panneau);
            }
        });

        JButton b3 = new JButton("Points");
        b3.setBackground(Color.WHITE);
        b3.setPreferredSize(new Dimension(X / 3, Y / 2));
        b3.setFont(font);
        b3.setForeground(Color.BLACK);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Rendupanier rp = new Rendupanier(1, 
                        panneau.getEquipe("GREEN").getTerrain().getFirst().getNum(),
                        "GREEN", panneau);
            }
        });
       
        JButton boutonChangement = new JButton("Changement");       
        boutonChangement.setBackground(Color.WHITE);
        boutonChangement.setPreferredSize(new Dimension(X / 3, Y / 2));
        boutonChangement.setFont(new Font("Equipe", Font.BOLD, 30));
        boutonChangement.setForeground(Color.BLACK);
        boutonChangement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                int numeroSortant = panneau.getEquipe("GREEN").getTerrain().getFirst().getNum();
                int numeroEntrant = panneau.getEquipe("GREEN").getBanc().getFirst().getNum();
                Renduchangement rp = new Renduchangement(numeroSortant, 
                        numeroEntrant, "GREEN", panneau);
            }
        });
        
        JButton boutonChronometre = new JButton("Chrono");
        boutonChronometre.setBackground(Color.WHITE);
        boutonChronometre.setPreferredSize(new Dimension(X / 3, Y / 2));
        boutonChronometre.setFont(font);
        boutonChronometre.setForeground(Color.BLACK);
        boutonChronometre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Modificationchrono mc = new Modificationchrono(panneau);
            }
        });
        
        JButton boutonTempsMort = new JButton("T-M");
        boutonTempsMort.setBackground(Color.WHITE);
        boutonTempsMort.setPreferredSize(new Dimension(X / 3, Y / 2));
        boutonTempsMort.setFont(font);
        boutonTempsMort.setForeground(Color.BLACK);
        boutonTempsMort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Tempsmort tm = new Tempsmort("GREEN", panneau);
            }
        });
        
        JPanel all = new JPanel();
        all.add(b1);
        all.add(b2);
        all.add(b3);
        all.add(boutonChangement);
        all.add(boutonChronometre);
        all.add(boutonTempsMort);
        

        all.setBackground(Color.WHITE);

        content.repaint();
        this.setContentPane(all);
        this.setVisible(true);
    }

    public void fermer() {
        this.dispose();
    }
    
}
