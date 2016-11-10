package ihm.affichage.arbitre.faute;

import ihm.affichage.arbitre.classesabstraites.AbstractMenuWindows;
import ihm.affichage.panneau.Panneau;
import ihm.match.Joueur;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author halbg
 */
public class Rendufaute extends AbstractMenuWindows {
    private String typeFaute;
    private int numeroJoueur;

    public Rendufaute(String type, int num, String coul, Panneau panneau) {
        super(coul, panneau, 3);
        this.typeFaute = type;
        this.numeroJoueur = num;
        
        panneau.arretChronometre();
        
        validerFaute();
        panneau.repaint();

        Font fontNum = new Font("Numero", Font.BOLD, 150);
        Font fontFaute = new Font("TypeFaute", Font.BOLD, 70);
        Font fontCouleur = new Font("Couleur", Font.BOLD, 130);

        JButton boutonTypeFaute = listeBoutons.getFirst();
        boutonTypeFaute.setText(typeFaute);
        boutonTypeFaute.setFont(fontFaute);
        boutonTypeFaute.addActionListener((ActionEvent event) -> {
            try {
                annulerFaute();
            } catch (Exception ex) {
                Logger.getLogger(Rendufaute.class.getName()).log(Level.SEVERE, null, ex);
            }
            fermer();
            Typefaute tf = new Typefaute(numeroJoueur, couleurEquipe, panneau);
            panneau.repaint();
        });

        JButton boutonNumero = listeBoutons.get(1);
        if (numeroJoueur == - 1) {
            boutonNumero.setText("Entraineur");
            Font fontEntraineur = new Font("TypeFaute", Font.BOLD, 40);
            boutonNumero.setFont(fontEntraineur);
        } else {
            boutonNumero.setText(Integer.toString(numeroJoueur));
            boutonNumero.setFont(fontNum);
        }
        boutonNumero.addActionListener((ActionEvent event) -> {
            try {
                annulerFaute();
            } catch (Exception ex) {
                Logger.getLogger(Rendufaute.class.getName()).log(Level.SEVERE, null, ex);
            }
            fermer();
            NumeroFauteTerrain nf = new NumeroFauteTerrain(typeFaute, couleurEquipe, panneau);
            panneau.repaint();
        });

        JButton boutonCouleur = listeBoutons.get(2);
        peindreBoutonCouleur(boutonCouleur);
        boutonCouleur.setFont(fontCouleur);
        boutonCouleur.setPreferredSize(new Dimension(X, Y / 2));
        boutonCouleur.addActionListener((ActionEvent event) -> {
            try {
                annulerFaute();
            } catch (Exception ex) {
                Logger.getLogger(Rendufaute.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (couleurEquipe.equals(panneau.getVisiteurs().getCouleur())) {
                couleurEquipe = panneau.getLocaux().getCouleur();
                peindreBoutonCouleur(boutonCouleur);
            } else {
                couleurEquipe = panneau.getVisiteurs().getCouleur();
                peindreBoutonCouleur(boutonCouleur);
            }
            validerFaute();
            boutonNumero.setText(Integer.toString(numeroJoueur));
            panneau.repaint();
        });
    }

    private void annulerFaute() throws Exception {
        Joueur fautif;
        try {
            fautif = panneau.getEquipe(this.couleurEquipe).getJoueurEquipe(this.numeroJoueur);
        } catch (Exception e) {
            // Normalement on n'arrive jamais là
            throw new Exception(this.numeroJoueur + " " + this.couleurEquipe + "pas sur le terrain");
        }
        if (fautif != null) {
            switch (this.typeFaute) {
                case "FAUTE":
                    fautif.decrFautes();
                    break;
                case "SPORT":
                    fautif.decrSport();
                    break;
                case "TECH":
                    fautif.decrTech();
                    break;
                default:
                    break;
            }
            panneau.getEquipe(this.couleurEquipe).decrFautes();
        }
    }

    /**
     * On peut donner une faute à un joueur sur le banc
    */
    private void validerFaute() {
        Joueur fautif;
        if (numeroJoueur == -1) {
            panneau.getEquipe(this.couleurEquipe).incrFautesEntraineur();
            return;
        }
        try {
            fautif = panneau.getEquipe(this.couleurEquipe).getJoueurEquipe(this.numeroJoueur);
        } catch (Exception e) {
            fautif = panneau.getEquipe(couleurEquipe).getTeam().getFirst();
            this.numeroJoueur = fautif.getNum();
        }
        
        if (fautif != null) {
            switch (this.typeFaute) {
                case "FAUTE":
                    fautif.incrFautes();
                    break;
                case "SPORT":
                    fautif.incrSport();
                    break;
                case "TECH":
                    fautif.incrTech();
                    break;
                default:
                    break;
            }
            panneau.getEquipe(this.couleurEquipe).incrFautes();
        }
        
        if (panneau.getEquipe(this.couleurEquipe).surBanc(fautif) && typeFaute.equals("FAUTE")) {
            System.out.println("Un joueur sur le banc ne peut pas avoir une faute simple");
            // TODO: générer une erreur
        }
    }
}
