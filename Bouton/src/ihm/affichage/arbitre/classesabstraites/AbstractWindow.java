/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.affichage.arbitre.classesabstraites;

import ihm.affichage.panneau.Panneau;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author guillaumehalb
 */
public abstract class AbstractWindow extends JFrame {
    protected Panneau panneau;
    protected String couleurEquipe;
    protected LinkedList<JButton> listeBoutons = new LinkedList<JButton>();
    protected JPanel jpanel;
    private int nombreBoutons;
    
    // TODO: Les mettre en variables générales plus haut ou ailleurs
    protected int X = 700;
    protected int Y = 500;  
    
    public AbstractWindow(String couleur, Panneau pann, int nombre) {
        this.panneau = pann;
        this.couleurEquipe = couleur;
        this.nombreBoutons = nombre;
        
        this.setTitle(getClass().getSimpleName());
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        this.jpanel = new JPanel();
        Font font = new Font("Joueurs", Font.BOLD, 100);
        
        for (int i = 0; i < nombreBoutons; i++) {
            JButton boutonCourant = new JButton(Integer.toString(i));
            boutonCourant.setFont(font);
            boutonCourant.setBackground(Color.WHITE);
            if (nombreBoutons == 1) {
                boutonCourant.setPreferredSize(new Dimension(X, Y));
            }
            if (nombreBoutons == 2) {
                boutonCourant.setPreferredSize(new Dimension(X/2, Y));
            }
            if (nombreBoutons == 3) {
                if (i < 2) {
                    boutonCourant.setPreferredSize(new Dimension(X/2, Y/2 - 20));
                } else {
                    boutonCourant.setPreferredSize(new Dimension(X, Y/2 - 20));
                }
            } else if (nombreBoutons == 4) {
                boutonCourant.setPreferredSize(new Dimension(X/2, Y/2));
            } else if (nombreBoutons == 6) {
                boutonCourant.setPreferredSize(new Dimension(X/3, Y/2));
            }
            jpanel.add(boutonCourant);    
            listeBoutons.add(boutonCourant);
        }
        this.setContentPane(jpanel);
        this.setVisible(true);
    }
        
    public void fermer() {
        this.dispose();
    }
}
