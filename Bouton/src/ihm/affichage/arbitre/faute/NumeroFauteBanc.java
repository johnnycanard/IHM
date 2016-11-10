/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.affichage.arbitre.faute;

import ihm.affichage.arbitre.classesabstraites.AbstractWindow;
import ihm.affichage.panneau.Panneau;
import ihm.match.Joueur;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author guillaumehalb
 */
public class NumeroFauteBanc extends AbstractWindow {
    public NumeroFauteBanc(String typeFaute, String couleur, Panneau pann) {
        super(couleur, pann, pann.getEquipe(couleur).getBanc().size() + 2);
        
        //TODO: verifier le type de faute possible
        
        ecrireBoutonNumero(panneau.getEquipe(couleur).getBanc());
        
        for (int i = 0; i < pann.getEquipe(couleur).getBanc().size(); i++) {
            JButton boutonCourant = listeBoutons.get(i);
            boutonCourant.addActionListener((ActionEvent event) -> {
                fermer();
                Rendufaute renduFaute = new Rendufaute(typeFaute, 
                        Integer.parseInt(boutonCourant.getText()), couleurEquipe,
                        panneau);
            });
        }
        
        Font font = new Font("Numero", Font.BOLD, 30);
        
        JButton boutonEntraineur = listeBoutons.get(pann.getEquipe(couleur).getBanc().size());
        boutonEntraineur.setText("Entraineur");
        boutonEntraineur.setFont(font);
        boutonEntraineur.addActionListener((ActionEvent event) -> {
            fermer();
            Rendufaute renduFaute = new Rendufaute(typeFaute, -1,
                        couleurEquipe, panneau);
        });
    
        Font fontTerrain = new Font("Numero", Font.BOLD, 30);
        
        JButton boutonAutre = listeBoutons.getLast();
        boutonAutre.setText("Terrain");
        boutonAutre.setFont(fontTerrain);
        boutonAutre.addActionListener((ActionEvent event) -> {
            fermer();
            NumeroFauteTerrain numeroFauteTerrain = new NumeroFauteTerrain(typeFaute,
                        couleurEquipe, panneau);
        });
    }
}
