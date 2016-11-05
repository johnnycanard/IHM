package ihm.affichage.arbitre.tempsmort;

import ihm.affichage.arbitre.Menu;
import ihm.affichage.panneau.Panneau;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Tempsmort extends JFrame {
 
    private Panneau panneau;
    
    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;
    private String couleur;

    public Tempsmort(String coul, Panneau panneau) {
        this.panneau = panneau;
        this.couleur = coul;
        
        //TODO: Faire un nouveau chrono de durée = durée d'un temps mort
        panneau.arretChronometre();
        
        if (couleur.equals(panneau.getVisiteurs().getCouleur())) {
            panneau.getVisiteurs().incrNbTM();
        } else {
            panneau.getLocaux().incrNbTM();
        }
        
        this.setTitle("Temps-Mort");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font font = new Font("Equipe", Font.BOLD, 100);

        JButton boutonCouleurTempsMort = new JButton("<html>Temps-Mort<br>         " + couleur + "</html>");
        boutonCouleurTempsMort.setPreferredSize(new Dimension(X, Y-20));
        peindreBoutonTempsMort(boutonCouleurTempsMort);
        boutonCouleurTempsMort.setFont(font);
        boutonCouleurTempsMort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (couleur.equals(panneau.getVisiteurs().getCouleur())) {
                    panneau.getLocaux().incrNbTM();
                    try {
                        panneau.getVisiteurs().decrNbTM();
                    } catch (Exception ex) {
                        Logger.getLogger(Tempsmort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    couleur = panneau.getLocaux().getCouleur();
                    peindreBoutonTempsMort(boutonCouleurTempsMort);
                } else {
                    panneau.getVisiteurs().incrNbTM();
                    try {
                        panneau.getLocaux().decrNbTM();
                    } catch (Exception ex) {
                        Logger.getLogger(Tempsmort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    couleur = panneau.getVisiteurs().getCouleur();
                    peindreBoutonTempsMort(boutonCouleurTempsMort);
                }    
                panneau.repaint();
            }
        });
        
	JButton retour = new JButton("R");
        retour.setPreferredSize(new Dimension(X , 3));
        retour.setBackground(Color.WHITE);
        retour.setFont(font);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Temps = 24
		fermer();
		Menu m = new Menu(panneau);
                panneau.repaint();
            }
        });
        
        JPanel all = new JPanel();
        all.add(boutonCouleurTempsMort);
	all.add(retour);
        all.setBackground(Color.WHITE);

        content.repaint();
        this.setContentPane(all);
        this.setVisible(true);
    }

    private void peindreBoutonTempsMort(JButton boutonCouleurTempsMort) {
        boutonCouleurTempsMort.setForeground(Color.WHITE);
        if (couleur.equals("RED")) {
            boutonCouleurTempsMort.setBackground(Color.RED);
            boutonCouleurTempsMort.setText("<html>Temps-Mort<br> Rouge </html>");
        } else if (couleur.equals("BLUE")) {
            boutonCouleurTempsMort.setBackground(Color.BLUE);
            boutonCouleurTempsMort.setText("<html>Temps-Mort<br> BLEU </html>");
        } else if (couleur.equals("GREEN")) {
            boutonCouleurTempsMort.setBackground(Color.GREEN);
            boutonCouleurTempsMort.setText("<html>Temps-Mort<br> VERT </html>");
        } else if (couleur.equals("WHITE")) {
            boutonCouleurTempsMort.setBackground(Color.WHITE);
            boutonCouleurTempsMort.setText("<html>Temps-Mort<br> BLANC </html>");
            boutonCouleurTempsMort.setForeground(Color.BLACK);
        }        
    }
    
    public void fermer() {
        this.dispose();
    }    
}
