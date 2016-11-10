package ihm.affichage.arbitre.chronometre;

import ihm.affichage.arbitre.Menu;
import ihm.affichage.panneau.Panneau;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class Modificationchrono extends JFrame {
    private Panneau panneau;

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Modificationchrono(Panneau panno) {
        this.panneau = panno;
        
        this.setTitle("Modification chrono");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }
        Font font = new Font("Equipe", Font.BOLD, 150);
        Font fontMenu = new Font("Equipe", Font.BOLD, 70);

        panneau.arretChronometre();
        
        JButton boutonMoinsChronometre = new JButton("-");
        boutonMoinsChronometre.setPreferredSize(new Dimension(X/2, 13*Y/32));
        boutonMoinsChronometre.setBackground(Color.WHITE);
        boutonMoinsChronometre.setFont(font);
        boutonMoinsChronometre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                panneau.getChrono().decrementeChronometre();
                panneau.repaint();
            }
        });

        JButton boutonPlusChronometre = new JButton("+");
        boutonPlusChronometre.setPreferredSize(new Dimension(X/2, 13*Y/32));
        boutonPlusChronometre.setBackground(Color.WHITE);
        boutonPlusChronometre.setFont(font);
        boutonPlusChronometre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                panneau.getChrono().incrementeChronometre();
                panneau.repaint();
            }
        });

        JButton boutonMoinsPossession = new JButton("-");
        boutonMoinsPossession.setPreferredSize(new Dimension(X/2, 13*Y/32));
        boutonMoinsPossession.setBackground(Color.WHITE);
        boutonMoinsPossession.setFont(font);
        boutonMoinsPossession.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                panneau.getChrono().decrementePossession();
                panneau.repaint();
            }
        });

        JButton boutonPlusPossession = new JButton("+");
        boutonPlusPossession.setPreferredSize(new Dimension(X/2, 13*Y/32));
        boutonPlusPossession.setBackground(Color.WHITE);
        boutonPlusPossession.setFont(font);
        boutonPlusPossession.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                panneau.getChrono().incrementePossession();
                panneau.repaint();
            }
        });
        
        // Retour
        JButton retour = new JButton("Menu");
        retour.setBackground(Color.WHITE);
        retour.setPreferredSize(new Dimension(X, 3));
        retour.setFont(fontMenu);
        retour.setForeground(Color.BLACK);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Menu maxibestof = new Menu(panneau);
                panneau.repaint();
            }
        });

        JLabel stringChronometre = new JLabel("Chronometre");
        stringChronometre.setPreferredSize(new Dimension(X, Y/16));
        stringChronometre.setFont(new Font("", Font.BOLD, 30));
        stringChronometre.setHorizontalAlignment(JLabel.CENTER);
        stringChronometre.setVerticalAlignment(JLabel.CENTER);
        JLabel stringPossession = new JLabel("Possession");
        stringPossession.setPreferredSize(new Dimension(X, Y/16));    
        stringPossession.setFont(new Font("", Font.BOLD, 30));
        stringPossession.setHorizontalAlignment(JLabel.CENTER);
        stringPossession.setVerticalAlignment(JLabel.CENTER);
        
        JPanel all = new JPanel();
        all.add(stringChronometre);
        all.add(boutonMoinsChronometre);
        all.add(boutonPlusChronometre);
        all.add(stringPossession);
        all.add(boutonMoinsPossession);
        all.add(boutonPlusPossession);
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
