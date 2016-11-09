package ihm.affichage.arbitre.tempsmort;

import ihm.affichage.arbitre.classesabstraites.AbstractMenuWindows;
import ihm.affichage.panneau.Panneau;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Tempsmort extends AbstractMenuWindows {

    public Tempsmort(String coul, Panneau panneau) {
        super(coul, panneau, 1);
        
        validerTM();
        //TODO: Faire un nouveau chrono de durée = durée d'un temps mort
        panneau.arretChronometre();
       
        Font font = new Font("Equipe", Font.BOLD, 100);

        JButton boutonCouleurTempsMort = listeBoutons.getFirst();
        boutonCouleurTempsMort.setText("<html>Temps-Mort<br>         " + couleurEquipe + "</html>");
        // boutonCouleurTempsMort.setPreferredSize(new Dimension(X, Y - 20));
        peindreBoutonCouleur(boutonCouleurTempsMort);
        boutonCouleurTempsMort.setFont(font);
        boutonCouleurTempsMort.setPreferredSize(new Dimension(X, Y - 20));
        boutonCouleurTempsMort.addActionListener((ActionEvent event) -> {
            try {
                annulerTM();
            } catch (Exception ex) {
                Logger.getLogger(Tempsmort.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (couleurEquipe.equals(panneau.getVisiteurs().getCouleur())) {
                couleurEquipe = panneau.getLocaux().getCouleur();
                peindreBoutonCouleur(boutonCouleurTempsMort);
            } else {
                couleurEquipe = panneau.getVisiteurs().getCouleur();
                peindreBoutonCouleur(boutonCouleurTempsMort);
            }
            validerTM();
            panneau.repaint();
        });
    }
    
    private void validerTM() {
        if (couleurEquipe.equals(panneau.getVisiteurs().getCouleur())) {
            panneau.getVisiteurs().incrNbTM();
        } else {
            panneau.getLocaux().incrNbTM();
        }
    }
    
    private void annulerTM() throws Exception {
        if (couleurEquipe.equals(panneau.getVisiteurs().getCouleur())) {
            panneau.getVisiteurs().decrNbTM();
        } else {
            panneau.getLocaux().decrNbTM();
        }
    }
}
