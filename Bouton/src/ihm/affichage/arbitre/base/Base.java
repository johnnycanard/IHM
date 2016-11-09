package ihm.affichage.arbitre.base;

import ihm.affichage.arbitre.Menu;
import ihm.affichage.arbitre.classesabstraites.AbstractMenuWindows;
import ihm.affichage.arbitre.classesabstraites.AbstractWindow;
import ihm.affichage.panneau.Panneau;
import java.awt.Color;
import java.awt.Dimension;
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
public class Base extends AbstractMenuWindows {
    
    public Base(Panneau panneau) {
        super(null, panneau, 2);
        Font font = new Font("Equipe", Font.BOLD, 150);

        JButton boutonQuatorze = listeBoutons.get(0);
        boutonQuatorze.setText(Integer.toString(14));
        boutonQuatorze.setPreferredSize(new Dimension(X/2, Y - 20));
        boutonQuatorze.setFont(font);
        boutonQuatorze.addActionListener((ActionEvent event) -> {
            if (panneau.getChrono().getTempsPossession() <= 14) {
                panneau.getChrono().setTime(14);
                panneau.repaint();
            }
        });

        JButton twentyFourButton = listeBoutons.get(1);
        twentyFourButton.setText(Integer.toString(24));
        twentyFourButton.setPreferredSize(new Dimension(X/2, Y - 20));
        twentyFourButton.setFont(font);
        twentyFourButton.addActionListener((ActionEvent event) -> {
            panneau.getChrono().setTime(24);
            panneau.repaint();
        });
    }
}
