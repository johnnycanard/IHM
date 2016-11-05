/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.affichage.arbitre.classesabstraites;

import ihm.affichage.arbitre.faute.NumeroFauteBanc;
import ihm.affichage.arbitre.faute.NumeroFauteTerrain;
import ihm.affichage.arbitre.panier.Numeropanier;
import ihm.affichage.panneau.Panneau;
import ihm.match.Joueur;
import java.awt.Font;
import java.util.LinkedList;
import javax.swing.JButton;

/**
 *
 * @author guillaumehalb
 */
public class AbstractNumero extends AbstractSixCases {
    protected LinkedList<Joueur> listeJoueur;
    
    public AbstractNumero(String couleur, Panneau panneau) {
        super(couleur, panneau);
        if (this instanceof Numeropanier || this instanceof NumeroFauteTerrain) {
            listeJoueur = panneau.getEquipe(couleur).getTerrain();
        } else if (this instanceof NumeroFauteBanc) {
            listeJoueur = panneau.getEquipe(couleur).getBanc();        
        }
        
        for (int i = 0; i < 5; i++) {
            JButton bouton = this.listeBoutons.get(i);
            Joueur joueur = listeJoueur.get(i);
            bouton.setText(Integer.toString(joueur.getNum()));
        }
        
        JButton bouton = this.listeBoutons.get(5);
        Font changeFont = new Font("Joueurs", Font.BOLD, 20);
        bouton.setText("Autre");
        bouton.setFont(changeFont);
    }
}
