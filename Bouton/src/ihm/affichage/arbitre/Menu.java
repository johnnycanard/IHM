package ihm.affichage.arbitre;

import ihm.affichage.arbitre.base.Base;
import ihm.affichage.arbitre.changement.RenduChangement;
import ihm.affichage.arbitre.chronometre.Modificationchrono;
import ihm.affichage.arbitre.classesabstraites.AbstractWindow;
import ihm.affichage.arbitre.faute.Rendufaute;
import ihm.affichage.arbitre.panier.RenduPanier;
import ihm.affichage.arbitre.tempsmort.Tempsmort;
import ihm.affichage.panneau.Panneau;
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
 * @author guillaumehalb
 */
public class Menu extends AbstractWindow {
    public Menu(Panneau panneau) {
        super(panneau.getVisiteurs().getCouleur(), panneau, 6);
        
        Font font = new Font("Equipe", Font.BOLD, 50);

        // Creation de 6 boutons :
        JButton boutonBase = listeBoutons.get(0);
        boutonBase.setText("Base");
        boutonBase.setFont(font);
        boutonBase.addActionListener((ActionEvent event) -> {
            fermer();
            Base base1 = new Base(panneau);
        });

        JButton boutonFaute = listeBoutons.get(1);
        boutonFaute.setText("Faute");
        boutonFaute.setFont(font);
        boutonFaute.addActionListener((ActionEvent event) -> {
            fermer();
            Rendufaute rf = new Rendufaute("FAUTE",
                    panneau.getEquipe(couleurEquipe).getTerrain().getFirst().getNum(),
                    couleurEquipe, panneau);
        });

        JButton boutonPoints = listeBoutons.get(2);
        boutonPoints.setText("Points");
        boutonPoints.setFont(font);
        boutonPoints.addActionListener((ActionEvent event) -> {
            fermer();
            RenduPanier rp = new RenduPanier(1,
                    panneau.getEquipe(couleurEquipe).getTerrain().getFirst().getNum(),
                    couleurEquipe, panneau);
        });
       
        JButton boutonChangement = listeBoutons.get(3);
        boutonChangement.setText("Changement");       
        boutonChangement.setFont(new Font("Equipe", Font.BOLD, 30));
        boutonChangement.addActionListener((ActionEvent event) -> {
            fermer();
            int numeroSortant = panneau.getEquipe(couleurEquipe).getTerrain().getFirst().getNum();
            int numeroEntrant = panneau.getEquipe(couleurEquipe).getBanc().getFirst().getNum();
            RenduChangement rp = new RenduChangement(numeroSortant,
                    numeroEntrant, couleurEquipe, panneau);
        });
        
        JButton boutonChronometre = listeBoutons.get(4);
        boutonChronometre.setText("Chrono");
        boutonChronometre.setFont(font);
        boutonChronometre.addActionListener((ActionEvent event) -> {
            fermer();
            Modificationchrono mc = new Modificationchrono(panneau);
        });
        
        JButton boutonTempsMort = listeBoutons.get(5);
        boutonTempsMort.setText("T-M");
        boutonTempsMort.setFont(font);
        boutonTempsMort.addActionListener((ActionEvent event) -> {
            fermer();
            Tempsmort tm = new Tempsmort(couleurEquipe, panneau);
        });
    }
}
