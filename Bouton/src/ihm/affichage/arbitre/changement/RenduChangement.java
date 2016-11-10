package ihm.affichage.arbitre.changement;

import ihm.affichage.arbitre.Menu;
import ihm.affichage.arbitre.classesabstraites.AbstractMenuWindows;
import ihm.affichage.arbitre.classesabstraites.AbstractWindow;
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
public class RenduChangement extends AbstractMenuWindows {
    private int sortant;
    private int entrant;
    
    public RenduChangement(int sor, int ent, String coul, Panneau pann) {
        super(coul, pann, 3);
        this.sortant = sor;
        this.entrant = ent;

        validerChangement();
        panneau.repaint();
        panneau.arretChronometre();
        
        Font fontFaute = new Font("Equipe", Font.BOLD, 70);
        Font fontCoul = new Font("Equipe", Font.BOLD, 130);

        JButton boutonJoueurSortant = listeBoutons.get(1);
        boutonJoueurSortant.setText("OUT : " + Integer.toString(this.sortant));
        boutonJoueurSortant.setPreferredSize(new Dimension(X/2, Y/2 - 20));
        boutonJoueurSortant.setBackground(Color.WHITE);
        boutonJoueurSortant.setFont(fontFaute);
        boutonJoueurSortant.addActionListener((ActionEvent event) -> {
            annulerChangement();
            fermer();
            Changementsortant cs = new Changementsortant(entrant, couleurEquipe, panneau);
            panneau.repaint();
        });

        JButton boutonJoueurEntrant = listeBoutons.get(2);
        boutonJoueurEntrant.setText("IN : " + Integer.toString(this.entrant));
        boutonJoueurEntrant.setPreferredSize(new Dimension(X/2, Y/2 - 20));
        boutonJoueurEntrant.setBackground(Color.WHITE);
        boutonJoueurEntrant.setFont(fontFaute);
        boutonJoueurEntrant.addActionListener((ActionEvent event) -> {
            annulerChangement();
            fermer();
            Changemententrant ce = new Changemententrant(sortant, couleurEquipe, panneau);
            panneau.repaint();
        });

        JButton boutonCouleur = listeBoutons.get(0);
        peindreBoutonCouleur(boutonCouleur);
        boutonCouleur.setFont(fontCoul);
        boutonCouleur.setPreferredSize(new Dimension(X, Y / 2));
        boutonCouleur.addActionListener((ActionEvent event) -> {
            annulerChangement();
            if (couleurEquipe.equals(panneau.getVisiteurs().getCouleur())) {
                couleurEquipe = panneau.getLocaux().getCouleur();
            } else {
                couleurEquipe = panneau.getVisiteurs().getCouleur();
            }
            entrant = panneau.getEquipe(couleurEquipe).getBanc().getFirst().getNum();
            sortant = panneau.getEquipe(couleurEquipe).getTerrain().getFirst().getNum();
            peindreBoutonCouleur(boutonCouleur);
            validerChangement();
            boutonJoueurSortant.setText("OUT : " + Integer.toString(sortant));
            boutonJoueurEntrant.setText("IN : " + Integer.toString(entrant));
            panneau.repaint();
        });
    }

    private void validerChangement() {
        Joueur in = null;
        Joueur out = null; 
        try {
            in = panneau.getEquipe(this.couleurEquipe).getJoueurBanc(this.entrant);
        } catch (Exception ex) {
            Logger.getLogger(RenduChangement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            out = panneau.getEquipe(this.couleurEquipe).getJoueurTerrain(this.sortant);
        } catch (Exception ex) {
            Logger.getLogger(RenduChangement.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (in != null & out != null) {
            panneau.getEquipe(this.couleurEquipe).changement(in, out);
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
            in = panneau.getEquipe(couleurEquipe).getJoueurTerrain(entrant);
        } catch (Exception ex) {
            Logger.getLogger(RenduChangement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            out = panneau.getEquipe(couleurEquipe).getJoueurBanc(sortant);
        } catch (Exception ex) {
            Logger.getLogger(RenduChangement.class.getName()).log(Level.SEVERE, null, ex);
        }
        panneau.getEquipe(couleurEquipe).changement(out, in);
    }    
}
