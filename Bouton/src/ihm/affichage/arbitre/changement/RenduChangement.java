package ihm.affichage.arbitre.changement;

import ihm.affichage.arbitre.Menu;
import ihm.affichage.panneau.Panneau;
import ihm.match.Joueur;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
 * @author halbg
 */
public class RenduChangement extends JFrame {
    private Panneau panneau;
    private int sortant;
    private int entrant;
    private String couleur;

    private int X = 700;
    private int Y = 500;
    
    public RenduChangement(int sor, int ent, String coul, Panneau pann) {
        this.panneau = pann;
        this.couleur = coul;
        this.sortant = sor;
        this.entrant = ent;

        validerChangement();
        panneau.repaint();
        panneau.arretChronometre();
        
        this.setTitle("Rendu Changement");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font fontFaute = new Font("Equipe", Font.BOLD, 70);
        Font fontCoul = new Font("Equipe", Font.BOLD, 130);

        JButton boutonJoueurSortant = new JButton("OUT : " + Integer.toString(this.sortant));
        boutonJoueurSortant.setPreferredSize(new Dimension(X / 2, Y / 2 - 20));
        boutonJoueurSortant.setBackground(Color.WHITE);
        boutonJoueurSortant.setFont(fontFaute);
        boutonJoueurSortant.addActionListener((ActionEvent event) -> {
            annulerChangement();
            fermer();
            Changementsortant cs = new Changementsortant(entrant, couleur, panneau);
            panneau.repaint();
        });

        JButton boutonJoueurEntrant = new JButton("IN : " + Integer.toString(this.entrant));
        boutonJoueurEntrant.setPreferredSize(new Dimension(X / 2, Y / 2 - 20));
        boutonJoueurEntrant.setBackground(Color.WHITE);
        boutonJoueurEntrant.setFont(fontFaute);
        boutonJoueurEntrant.addActionListener((ActionEvent event) -> {
            annulerChangement();
            fermer();
            Changemententrant ce = new Changemententrant(sortant, couleur, panneau);
            panneau.repaint();
        });

        JButton boutonCouleur = new JButton("AUTRE");
        peindreBoutonCouleur(boutonCouleur);
        boutonCouleur.setFont(fontCoul);
        boutonCouleur.setPreferredSize(new Dimension(X, Y / 2));
        boutonCouleur.addActionListener((ActionEvent event) -> {
            annulerChangement();
            if (couleur.equals(panneau.getVisiteurs().getCouleur())) {
                couleur = panneau.getLocaux().getCouleur();
            } else {
                couleur = panneau.getVisiteurs().getCouleur();
            }
            entrant = panneau.getEquipe(couleur).getBanc().getFirst().getNum();
            sortant = panneau.getEquipe(couleur).getTerrain().getFirst().getNum();
            peindreBoutonCouleur(boutonCouleur);
            validerChangement();
            boutonJoueurSortant.setText("OUT : " + Integer.toString(sortant));
            boutonJoueurEntrant.setText("IN : " + Integer.toString(entrant));
            panneau.repaint();
        });
        JButton retour = new JButton("R");
        retour.setPreferredSize(new Dimension(X, 3));
        retour.setBackground(Color.WHITE);
        retour.setFont(fontCoul);
        retour.addActionListener((ActionEvent event) -> {
            fermer();
            Menu m = new Menu(panneau);
        });

        JPanel all = new JPanel();
        all.add(boutonJoueurEntrant);
        all.add(boutonJoueurSortant);
        all.add(boutonCouleur);
        all.add(retour);
        all.setBackground(Color.WHITE);

        this.setContentPane(all);
        this.setVisible(true);
    }

    public void fermer() {
        this.dispose();
    }

    private void validerChangement() {
        Joueur in = null;
        Joueur out = null; 
        try {
            in = panneau.getEquipe(this.couleur).getJoueurBanc(this.entrant);
        } catch (Exception ex) {
            Logger.getLogger(RenduChangement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            out = panneau.getEquipe(this.couleur).getJoueurTerrain(this.sortant);
        } catch (Exception ex) {
            Logger.getLogger(RenduChangement.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (in != null & out != null) {
            panneau.getEquipe(this.couleur).changement(in, out);
        }
    }
    
    /*
    * in est sur le terrain et doit aller sur le banc
    * out est sur le banc et doit aller sur le terrain
    */
    private void annulerChangement() {
        Joueur in = null;
        Joueur out = null;
        try {
            in = panneau.getEquipe(couleur).getJoueurTerrain(entrant);
        } catch (Exception ex) {
            Logger.getLogger(RenduChangement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            out = panneau.getEquipe(couleur).getJoueurBanc(sortant);
        } catch (Exception ex) {
            Logger.getLogger(RenduChangement.class.getName()).log(Level.SEVERE, null, ex);
        }
        panneau.getEquipe(couleur).changement(out, in);
    }

    private void peindreBoutonCouleur(JButton boutonCouleur) {
    boutonCouleur.setForeground(Color.WHITE);
        switch (couleur) {
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
