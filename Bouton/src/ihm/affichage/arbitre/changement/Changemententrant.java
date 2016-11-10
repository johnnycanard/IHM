package ihm.affichage.arbitre.changement;

import ihm.affichage.arbitre.classesabstraites.AbstractWindow;
import ihm.affichage.panneau.Panneau;
import ihm.match.Joueur;
import java.awt.Font;
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
public class Changemententrant extends AbstractWindow {
    private int numeroSortant;
    
    public Changemententrant(int sortant, String coul, Panneau panneau) {
        super(coul, panneau, panneau.getEquipe(coul).getBanc().size());
        this.numeroSortant = sortant;
        
        ecrireBoutonNumero(panneau.getEquipe(couleurEquipe).getBanc());
        
        for (int i = 0; i < panneau.getEquipe(couleurEquipe).getBanc().size(); i++) {
            JButton boutonCourant = listeBoutons.get(i);
            boutonCourant.addActionListener((ActionEvent event) -> {
                fermer();
                RenduChangement renduChangement = new RenduChangement(numeroSortant,
                        Integer.parseInt(boutonCourant.getText()), couleurEquipe,
                        panneau);
            }); 
        }
    }
}
