/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.affichage.arbitre.faute;

import ihm.affichage.arbitre.classesabstraites.AbstractNumero;
import ihm.affichage.panneau.Panneau;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author guillaumehalb
 */
public abstract class AbstractNumeroFaute extends AbstractNumero {
    protected String typeFaute;
    
    public AbstractNumeroFaute(String type, String couleur, Panneau pann) {
        super(couleur, pann);
        this.typeFaute = type;
        
        for (int i = 0; i < 5; i++) {
            JButton bouton = this.listeBoutons.get(i);
            bouton.addActionListener((ActionEvent event) -> {
                fermer();
                Rendufaute renduFaute = new Rendufaute(typeFaute,
                        Integer.parseInt(bouton.getText()), couleurEquipe,
                        panneau);
            });
        }
        
        JButton bouton = this.listeBoutons.get(5);
        Font changeFont = new Font("Joueurs", Font.BOLD, 20);
        bouton.setText("Autre");
        bouton.setFont(changeFont);
        bouton.addActionListener((ActionEvent event) -> {
            fermer();
            if (listeJoueur.equals(panneau.getEquipe(couleur).getBanc())) {
                NumeroFauteTerrain numeroFauteTerrain = new NumeroFauteTerrain(typeFaute, couleurEquipe, panneau);
            } else {
                NumeroFauteBanc numeroFauteBanc = new NumeroFauteBanc(typeFaute, couleurEquipe, panneau);
            }
        });
    }
}
