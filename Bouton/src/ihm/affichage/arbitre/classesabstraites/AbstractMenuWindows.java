/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.affichage.arbitre.classesabstraites;

import ihm.affichage.arbitre.Menu;
import ihm.affichage.panneau.Panneau;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 * Windows with a return to menu button
 * @author guillaumehalb
 */
public abstract class AbstractMenuWindows extends AbstractWindow {

    public AbstractMenuWindows(String couleur, Panneau panneau, int nombreBoutons) {
        super(couleur, panneau, nombreBoutons);
        
        Font font = new Font("Joueurs", Font.BOLD, 100);
        JButton retour = new JButton("R");
        retour.setPreferredSize(new Dimension(X, 3));
        retour.setBackground(Color.WHITE);
        retour.setFont(font);
        retour.addActionListener((ActionEvent event) -> {
            fermer();
            Menu menu = new Menu(panneau);
            panneau.repaint();
        });
        jpanel.add(retour);
    }
}
