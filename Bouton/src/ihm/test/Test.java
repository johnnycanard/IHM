package ihm.test;

import javax.swing.JFrame;
import java.awt.Color;

import ihm.affichage.arbitre.Menu;
import ihm.affichage.panneau.Panneau;
import ihm.affichage.panneau.Fenetre1;

public class Test {

    public static void main(String[] args) {
	Panneau pann = new Panneau();
        pann.defLocaux();
        pann.defVisiteurs();
	Menu menu = new Menu(pann);
        Fenetre1 fenetre = new Fenetre1(pann);
    }
}
