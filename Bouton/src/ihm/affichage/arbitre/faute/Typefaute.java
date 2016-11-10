package ihm.affichage.arbitre.faute;

import ihm.affichage.arbitre.classesabstraites.AbstractWindow;
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
 * @author halbg
 */
public class Typefaute extends AbstractWindow {
    int numeroFautif;

    public Typefaute(int n, String coul, Panneau pann) {
        super(coul, pann, 3);
        this.numeroFautif = n;

        Font fontFaute = new Font("faute", Font.BOLD, 80);
        Font fontSport = new Font("sport", Font.BOLD, 50);
        Font fontTech = new Font("tech", Font.BOLD, 50);

        JButton boutonFaute = listeBoutons.get(0);
        boutonFaute.setText("FAUTE");
        boutonFaute.setFont(fontFaute);
        boutonFaute.addActionListener((ActionEvent event) -> {
            fermer();
            Rendufaute r = new Rendufaute("FAUTE", numeroFautif, couleurEquipe, panneau);
        });

        JButton boutonAntiSportive = listeBoutons.get(1);
        boutonAntiSportive.setText("SPORTIVE");
        boutonAntiSportive.setFont(fontSport);
        boutonAntiSportive.addActionListener((ActionEvent event) -> {
            fermer();
            Rendufaute r = new Rendufaute("SPORT", numeroFautif, couleurEquipe, pann);
        });
        
        JButton boutonTechnique = listeBoutons.get(2);
        boutonTechnique.setText("TECHNIQUE");
        boutonTechnique.setFont(fontTech);
        boutonTechnique.addActionListener((ActionEvent event) -> {
            fermer();
            Rendufaute r = new Rendufaute("TECH", numeroFautif, couleurEquipe, pann);
        });        
    }
}
