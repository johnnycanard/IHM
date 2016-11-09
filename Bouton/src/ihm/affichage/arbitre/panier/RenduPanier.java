package ihm.affichage.arbitre.panier;

import ihm.affichage.arbitre.classesabstraites.AbstractMenuWindows;
import ihm.affichage.panneau.Panneau;
import ihm.match.Joueur;
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
public class RenduPanier extends AbstractMenuWindows {
    private int nombrePoints;
    private int numeroJoueur;
    
    public RenduPanier(int nombre, int n, String coul, Panneau pann) {
        super(coul, pann, 3);
        this.nombrePoints = nombre;
        this.numeroJoueur = n;
        
        validerPanier();
        panneau.repaint();

        Font fontPoint = new Font("Equipe", Font.BOLD, 130);
        Font fontNum = new Font("Equipe", Font.BOLD, 150);
        Font fontCoul = new Font("Equipe", Font.BOLD, 130);

        // Creation des 3 boutons :
        JButton numberPointsButton = listeBoutons.get(0);
        numberPointsButton.setText(Integer.toString(nombrePoints) + "pts");
        if (nombrePoints == 1) {
            numberPointsButton.setText(Integer.toString(nombrePoints) + "pt");
        }
        numberPointsButton.setFont(fontPoint);
        numberPointsButton.addActionListener((ActionEvent event) -> {
            annulerPanier();
            fermer();
            Nombrepoints np = new Nombrepoints(numeroJoueur, couleurEquipe, panneau);
            panneau.repaint();
        });

        // Numéro de joueur
        JButton numberButton = listeBoutons.get(1);
        numberButton.setText(Integer.toString(numeroJoueur));
        numberButton.setFont(fontNum);
        numberButton.addActionListener((ActionEvent event) -> {
            annulerPanier();
            fermer();
            Numeropanier np = new Numeropanier(nombrePoints, couleurEquipe, panneau);
            panneau.repaint();
        });

        // Couleur d'équipe
        JButton colorButton = listeBoutons.get(2);
        peindreBoutonCouleur(colorButton);
        colorButton.setFont(fontCoul);
        colorButton.addActionListener((ActionEvent event) -> {
            annulerPanier();
            if (couleurEquipe.equals(panneau.getVisiteurs().getCouleur())) {
                couleurEquipe = panneau.getLocaux().getCouleur();
                peindreBoutonCouleur(colorButton);
            } else {
                couleurEquipe = panneau.getVisiteurs().getCouleur();
                peindreBoutonCouleur(colorButton);
            }
            validerPanier();
            numberButton.setText(Integer.toString(numeroJoueur));
            panneau.repaint();
        });
    }

    public void annulerPanier() {
        Joueur marqueur = null;
        try {
            marqueur = panneau.getEquipe(this.couleurEquipe).getJoueurEquipe(numeroJoueur);
        } catch (Exception ex) {
            Logger.getLogger(RenduPanier.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (marqueur != null) {
            switch (nombrePoints) {
                case 1:
                    marqueur.decr1Point();
                    break;
                case 2:
                    marqueur.decr2Points();
                    break;
                case 3:
                    marqueur.decr3Points();
                    break;
                default:
                    break;
            }
            panneau.getEquipe(couleurEquipe).comptePoints();
        }
    }

    public void validerPanier() {
        Joueur marqueur = null;
        try {
            marqueur = panneau.getEquipe(couleurEquipe).getJoueurEquipe(numeroJoueur);
        } catch (Exception ex) {
            marqueur = panneau.getEquipe(couleurEquipe).getTerrain().getFirst();
            this.numeroJoueur = marqueur.getNum();        
        }
        if (marqueur != null) {
            switch (nombrePoints) {
                case 1:
                    marqueur.incr1Point();
                    break;
                case 2:
                    marqueur.incr2Points();
                    break;
                case 3:
                    marqueur.incr3Points();
                    break;
                default:
                    break;
            }
            panneau.getEquipe(couleurEquipe).comptePoints();
        }
    }
}
