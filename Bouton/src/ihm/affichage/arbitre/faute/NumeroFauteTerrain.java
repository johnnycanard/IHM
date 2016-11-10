package ihm.affichage.arbitre.faute;

import ihm.affichage.arbitre.classesabstraites.AbstractWindow;
import ihm.affichage.panneau.Panneau;
import ihm.match.Equipe;
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
public class NumeroFauteTerrain extends AbstractWindow {    
    public NumeroFauteTerrain(String type, String couleur, Panneau pann) {
        super(couleur, pann, 6);
        
        Equipe equipeCourante = panneau.getEquipe(couleur);
        
        ecrireBoutonNumero(equipeCourante.getTerrain());
        
        for (int i = 0; i < equipeCourante.getTerrain().size(); i++) {
            JButton boutonCourant = listeBoutons.get(i);
            boutonCourant.addActionListener((ActionEvent event) -> {
                fermer();
                Rendufaute renduFaute = new Rendufaute(type,
                        Integer.parseInt(boutonCourant.getText()),
                        couleurEquipe, panneau);
            });
        }
               
        Font font = new Font("Numero", Font.BOLD, 50);

        JButton boutonAutre = listeBoutons.getLast();
        boutonAutre.setText("Banc");
        boutonAutre.setFont(font);
        boutonAutre.addActionListener((ActionEvent event) -> {
            fermer();
            NumeroFauteBanc numeroFauteBanc = new NumeroFauteBanc(type,
                        couleurEquipe, panneau);
        });
    }
}
