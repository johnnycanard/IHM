package ihm.affichage.arbitre.base;

import ihm.affichage.arbitre.Menu;
import ihm.affichage.panneau.Panneau;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * @author guillaumehalb
 */
public class Base extends JFrame {

    private Panneau panneau;

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Base(Panneau panneau) {

        this.panneau = panneau;

        this.setTitle("BASE");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font font = new Font("Equipe", Font.BOLD, 150);

        // Creation des 2 boutons :
        JButton b1 = new JButton("14");
        b1.setPreferredSize(new Dimension(X / 2, Y-37));
        b1.setBackground(Color.WHITE);
        b1.setFont(font);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (panneau.getChrono().getTime() <= 14) {
                    panneau.getChrono().setTime(14);
                    panneau.repaint();
                }
            }
        });

        JButton b2 = new JButton("24");
        b2.setPreferredSize(new Dimension(X / 2, Y-37));
        b2.setBackground(Color.WHITE);
        b2.setFont(font);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                panneau.getChrono().setTime(24);
                panneau.repaint();
            }
        });

        JButton retour = new JButton("R");
        retour.setPreferredSize(new Dimension(X, 3));
        retour.setBackground(Color.WHITE);
        retour.setFont(font);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Temps = 24
                fermer();
                Menu m = new Menu(panneau);
                panneau.repaint();
            }
        });

        JPanel all = new JPanel();
        all.add(b1);
        all.add(b2);
        all.add(retour);
        all.setBackground(Color.WHITE);

        content.repaint();
        this.setContentPane(all);
        this.setVisible(true);
    }

    public void fermer() {
        this.dispose();
    }
}
