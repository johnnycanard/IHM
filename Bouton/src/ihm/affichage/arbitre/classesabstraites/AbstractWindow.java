/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.affichage.arbitre.classesabstraites;

import ihm.affichage.arbitre.faute.Rendufaute;
import ihm.affichage.panneau.Panneau;
import ihm.match.Joueur;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
            else if (nombreBoutons == 2) {
                boutonCourant.setPreferredSize(new Dimension(X/2, Y));
            }
            else if (nombreBoutons == 3) {
                if (i < 2) {
                    boutonCourant.setPreferredSize(new Dimension(X/2, Y/2 - 20));
                } else {
                    boutonCourant.setPreferredSize(new Dimension(X, Y/2 - 20));
                }
            } else if (nombreBoutons == 5) {
                if (i < 3) {
                    boutonCourant.setPreferredSize(new Dimension(X/3, Y/2));
                } else {
                    boutonCourant.setPreferredSize(new Dimension(X/2, Y/2));                    
                }
            } else if (nombreBoutons == 7) {
                if (i < 4) {
                    boutonCourant.setPreferredSize(new Dimension(X/4, Y/2));
                } else {
                    boutonCourant.setPreferredSize(new Dimension(X/3, Y/2));
                }
            } else if (nombreBoutons > 5) {
                boutonCourant.setPreferredSize(new Dimension(2*X/nombreBoutons, Y/2));
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
    
    protected void ecrireBoutonNumero(LinkedList<Joueur> liste) {
        Font font = new Font("Joueurs", Font.BOLD, 100);

        for (int i = 0; i < liste.size(); i++) {
            Joueur joueurCourant = liste.get(i);
            JButton boutonCourant = listeBoutons.get(i);
            boutonCourant.setFont(font);
            boutonCourant.setText(Integer.toString(joueurCourant.getNum()));
        }
    }

    protected void peindreBoutonCouleur(JButton boutonCouleur) {
        boutonCouleur.setForeground(Color.WHITE);
        switch (couleurEquipe) {
            case "RED":
                boutonCouleur.setBackground(Color.RED);
                boutonCouleur.setText("ROUGE");
                break;
            case "BLUE":
                boutonCouleur.setBackground(Color.BLUE);
                boutonCouleur.setText("BLEU");
                break;
            case "GREEN":
                boutonCouleur.setBackground(Color.GREEN);
                boutonCouleur.setText("VERT");
                break;
            case "BLACK":
                boutonCouleur.setBackground(Color.BLACK);
                boutonCouleur.setText("NOIR");
                break;
            default:
                boutonCouleur.setBackground(Color.WHITE);
                boutonCouleur.setForeground(Color.BLACK);
                boutonCouleur.setText("BLANC");
                break;
        }
    }
}
