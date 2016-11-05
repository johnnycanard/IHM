package ihm.affichage.arbitre.panier;

import ihm.affichage.arbitre.changement.RenduChangement;
import ihm.affichage.arbitre.classesabstraites.AbstractNumero;
import ihm.affichage.panneau.Panneau;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Numeropanier extends AbstractNumero {
    private int nombre;
    
    private int X = 700;
    private int Y = 500;

    public Numeropanier(int nombre, String couleur, Panneau panneau) {
        super(couleur, panneau);
	this.nombre = nombre;
	        
        for (int i = 0; i < 5; i++) {
            JButton bouton = this.listeBoutons.get(i);
            bouton.addActionListener((ActionEvent event) -> {
                fermer();
                RenduPanier rp = new RenduPanier(nombre, Integer.parseInt(bouton.getText()), couleur, panneau);
            });
        }
       
        JButton bouton = this.listeBoutons.get(5);
        bouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                int out = panneau.getEquipe(couleur).getTerrain().getFirst().getNum();
                int in = panneau.getEquipe(couleur).getBanc().getFirst().getNum();
                RenduChangement renduChangement = new RenduChangement(out, in, couleur, panneau);
            }
        });
    }
}

