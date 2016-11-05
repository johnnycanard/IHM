/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.affichage.arbitre.classesabstraites;

import ihm.affichage.panneau.Panneau;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author guillaumehalb
 */
public abstract class AbstractSixCases extends JFrame {
    protected Panneau panneau;
    protected String couleurEquipe;
    protected LinkedList<JButton> listeBoutons = new LinkedList<JButton>();
    // TODO: Les mettre en variables générales plus haut ou ailleurs
    private int X = 700;
    private int Y = 500;
    
    public AbstractSixCases(String couleur, Panneau panneau) {
        this.panneau = panneau;
        this.couleurEquipe = couleur;
        
        this.setTitle(getClass().getSimpleName());
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }
        
        JPanel all = new JPanel();
        Font font = new Font("Joueurs", Font.BOLD, 100);
        
        for (int i = 0; i < 6; i++) {
            JButton boutonCourant = new JButton(Integer.toString(i));
            boutonCourant.setFont(font);
            boutonCourant.setBackground(Color.WHITE);
            boutonCourant.setPreferredSize(new Dimension(X/3, Y/2));
            all.add(boutonCourant);
            listeBoutons.add(boutonCourant);
        }
     
        this.setContentPane(all);
        this.setVisible(true);
    }
    
    public void fermer() {
        this.dispose();
    }
}
