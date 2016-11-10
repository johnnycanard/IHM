package ihm.affichage.arbitre.changement;

import ihm.affichage.arbitre.classesabstraites.AbstractWindow;
import ihm.affichage.panneau.Panneau;
import ihm.match.Equipe;
import ihm.match.Joueur;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author halbg
 */
public class Changementsortant extends AbstractWindow {
    private int numeroEntrant;
    
    public Changementsortant(int entrant, String couleur, Panneau panneau) {
        super(couleur, panneau, 5);
        this.numeroEntrant = entrant;

        ecrireBoutonNumero(panneau.getEquipe(couleurEquipe).getTerrain());
        
        for (int i = 0; i < panneau.getEquipe(couleurEquipe).getTerrain().size(); i++) {
            JButton boutonJoueur = listeBoutons.get(i);
            boutonJoueur.addActionListener((ActionEvent event) -> {
                fermer();
                RenduChangement rc = new RenduChangement(Integer.parseInt(boutonJoueur.getText()),
                        numeroEntrant, couleurEquipe, panneau);
            });
        }
    }
}
