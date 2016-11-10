package ihm.affichage.arbitre.panier;

import ihm.affichage.arbitre.base.Base;
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

public class Nombrepoints extends AbstractWindow {
    private int nombre;
    
    public Nombrepoints(int n, String coul, Panneau pann) {
        super(coul, pann, 4);
        this.nombre = n;

        Font fontNum = new Font("Numero", Font.BOLD, 150);

        JButton boutonUnPoint = listeBoutons.get(0);
        boutonUnPoint.setText("1");
        boutonUnPoint.setFont(fontNum);
        boutonUnPoint.addActionListener((ActionEvent event) -> {
            fermer();
            RenduPanier rp = new RenduPanier(1, nombre, couleurEquipe, panneau);
        });
        
        JButton boutonDeuxPoints = listeBoutons.get(1);
        boutonDeuxPoints.setText("2");
        boutonDeuxPoints.setFont(fontNum);
        boutonDeuxPoints.addActionListener((ActionEvent event) -> {
            fermer();
            RenduPanier rp = new RenduPanier(2, nombre, couleurEquipe, panneau);
        });
        
        JButton boutonTroisPoints = listeBoutons.get(2);
        boutonTroisPoints.setText("3");
        boutonTroisPoints.setFont(fontNum);
        boutonTroisPoints.addActionListener((ActionEvent event) -> {
            fermer();
            RenduPanier rp = new RenduPanier(3, nombre, couleurEquipe, pann);
        });
        
        JButton boutonRefuser = listeBoutons.get(3);
        boutonRefuser.setText("REFUSER");
        boutonRefuser.setFont(new Font("Numero", Font.BOLD, 70));
        boutonRefuser.addActionListener((ActionEvent event) -> {
            fermer();
            Base base1 = new Base(pann);
        });
    }
}
