package ihm.affichage.arbitre.panier;

import ihm.affichage.arbitre.changement.RenduChangement;
import ihm.affichage.arbitre.classesabstraites.AbstractWindow;
import ihm.affichage.panneau.Panneau;
import java.awt.event.ActionEvent;
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
public class Numeropanier extends AbstractWindow {
    private int nombrePoints;
    
    public Numeropanier(int nombre, String couleur, Panneau panneau) {
        super(couleur, panneau, 6);
	this.nombrePoints = nombre;
	        
        ecrireBoutonNumero(panneau.getEquipe(couleur).getTerrain());
        
        for (int i = 0; i < panneau.getEquipe(couleur).getTerrain().size(); i++) {
            JButton bouton = this.listeBoutons.get(i);
            bouton.addActionListener((ActionEvent event) -> {
                fermer();
                RenduPanier rp = new RenduPanier(nombre,
                        Integer.parseInt(bouton.getText()), couleur, panneau);
            });
        }
       
        JButton boutonChangement = this.listeBoutons.get(5);
        boutonChangement.addActionListener((ActionEvent event) -> {
            fermer();
            int out = panneau.getEquipe(couleur).getTerrain().getFirst().getNum();
            int in = panneau.getEquipe(couleur).getBanc().getFirst().getNum();
            RenduChangement renduChangement = new RenduChangement(out, in, couleur, panneau);
        });
    }
}

