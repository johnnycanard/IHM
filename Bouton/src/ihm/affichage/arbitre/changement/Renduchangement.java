package ihm.affichage.arbitre.changement;

import ihm.affichage.arbitre.Menu;
import ihm.affichage.panneau.Panneau;
import ihm.match.Joueur;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Renduchangement extends JFrame {

    private Panneau panneau;

    int sortant;
    int entrant;
    String couleur;

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;
    private static String coul;
    
    public Renduchangement(int sor, int ent, String coul, Panneau pann) {

        this.panneau = pann;
        this.sortant = sor;
        this.entrant = ent;
        this.couleur = coul;

        validerChangement();
        panneau.repaint();

        this.setTitle("Rendu Changement");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font fontFaute = new Font("Equipe", Font.BOLD, 70);
        Font fontCoul = new Font("Equipe", Font.BOLD, 130);

        // Creation des 3 boutons :
        // Joueur sortant
        JButton boutonSortant = new JButton("OUT : " + Integer.toString(this.sortant));
        boutonSortant.setPreferredSize(new Dimension(X / 2, Y / 2 - 20));
        boutonSortant.setBackground(Color.WHITE);
        boutonSortant.setFont(fontFaute);
        boutonSortant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    panneau.getEquipe(coul).ajouterTerrain(panneau.getEquipe(coul).getJoueurEquipe(sor));
                } catch (Exception ex) {
                    Logger.getLogger(Renduchangement.class.getName()).log(Level.SEVERE, null, ex);
                }
                fermer();
                if (coul.equals("RED")) {
                    Changementsortant cs = new Changementsortant(entrant, "RED", true, panneau);
                } else if (coul.equals("BLUE")) {
                    Changementsortant cs = new Changementsortant(entrant, "BLUE", true, panneau);
                } else if (coul.equals("GREEN")) {
                    Changementsortant cs = new Changementsortant(entrant, "GREEN", true, panneau);
                } else if (coul.equals("WHITE")) {
                    Changementsortant cs = new Changementsortant(entrant, "WHITE", true, panneau);
                }
                panneau.repaint();
            }
        });

        // Joueur entrant
        JButton boutonEntrant = new JButton("IN : " + Integer.toString(this.entrant));
        boutonEntrant.setPreferredSize(new Dimension(X / 2, Y / 2 - 20));
        boutonEntrant.setBackground(Color.WHITE);
        boutonEntrant.setFont(fontFaute);
        boutonEntrant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    panneau.getEquipe(coul).ajouterBanc(panneau.getEquipe(coul).getJoueurEquipe(ent));
                } catch (Exception ex) {
                    Logger.getLogger(Renduchangement.class.getName()).log(Level.SEVERE, null, ex);
                }
                fermer();
                if (coul.equals("RED")) {
                    Changemententrant ce = new Changemententrant(sortant, "RED", panneau);
                } else if (coul.equals("BLUE")) {
                    Changemententrant ce = new Changemententrant(sortant, "BLUE", panneau);
                } else if (coul.equals("GREEN")) {
                    Changemententrant ce = new Changemententrant(sortant, "GREEN", panneau);
                } else if (coul.equals("WHITE")) {
                    Changemententrant ce = new Changemententrant(sortant, "WHITE", panneau);
                }
                panneau.repaint();
            }
        });

        // Couleur d'équipe
        JButton boutonCouleur = new JButton("AUTRE");
        boutonCouleur.setForeground(Color.WHITE);
        if (coul.equals("RED")) {
            boutonCouleur.setBackground(Color.RED);
            boutonCouleur.setText("ROUGE");
        } else if (coul.equals("BLUE")) {
            boutonCouleur.setBackground(Color.BLUE);
            boutonCouleur.setText("BLEU");
        } else if (coul.equals("GREEN")) {
            boutonCouleur.setBackground(Color.GREEN);
            boutonCouleur.setText("VERT");
        } else if (coul.equals("BLACK")) {
            boutonCouleur.setBackground(Color.BLACK);
            boutonCouleur.setText("NOIR");
        } else {
            boutonCouleur.setBackground(Color.WHITE);
            boutonCouleur.setForeground(Color.BLACK);
            boutonCouleur.setText("BLANC");
        }
        boutonCouleur.setFont(fontCoul);
        boutonCouleur.setPreferredSize(new Dimension(X, Y / 2));
        boutonCouleur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // annulerChangement();
                
                Joueur joueurSortant = null;
                Joueur joueurEntrant = null;
                try {
                    joueurEntrant = panneau.getEquipe(coul).getJoueurBanc(entrant);
                } catch (Exception ex) {
                    Logger.getLogger(Renduchangement.class.getName()).log(Level.SEVERE, null, ex);
                }                
                try {
                    joueurSortant = panneau.getEquipe(coul).getJoueurTerrain(sortant);
                } catch (Exception ex) {
                    Logger.getLogger(Renduchangement.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                panneau.getEquipe(coul).annulerChangement(joueurEntrant, joueurSortant);
                if (coul.equals(panneau.getVisiteurs().getCouleur())) {
                    couleur = panneau.getLocaux().getCouleur();
                    entrant = panneau.getEquipe(couleur).getBanc().getFirst().getNum();
                    sortant = panneau.getEquipe(couleur).getTerrain().getFirst().getNum();
                    // TODO: Nouveaux numéros (entrant sortant)
                    if (coul.equals("RED")) {
                        boutonCouleur.setBackground(Color.RED);
                        boutonCouleur.setText("ROUGE");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else if (coul.equals("BLUE")) {
                        boutonCouleur.setBackground(Color.BLUE);
                        boutonCouleur.setText("BLEU");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else if (coul.equals("GREEN")) {
                        boutonCouleur.setBackground(Color.GREEN);
                        boutonCouleur.setText("VERT");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else if (coul.equals("BLACK")) {
                        boutonCouleur.setBackground(Color.BLACK);
                        boutonCouleur.setText("NOIR");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else {
                        boutonCouleur.setBackground(Color.WHITE);
                        boutonCouleur.setForeground(Color.BLACK);
                        boutonCouleur.setText("BLANC");
                    }
                } else {
                    couleur = panneau.getVisiteurs().getCouleur();
                    entrant = panneau.getEquipe(couleur).getBanc().getFirst().getNum();
                    sortant = panneau.getEquipe(couleur).getTerrain().getFirst().getNum();
                    if (coul.equals("RED")) {
                        boutonCouleur.setBackground(Color.RED);
                        boutonCouleur.setText("ROUGE");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else if (coul.equals("BLUE")) {
                        boutonCouleur.setBackground(Color.BLUE);
                        boutonCouleur.setText("BLEU");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else if (coul.equals("GREEN")) {
                        boutonCouleur.setBackground(Color.GREEN);
                        boutonCouleur.setText("VERT");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else if (coul.equals("BLACK")) {
                        boutonCouleur.setBackground(Color.BLACK);
                        boutonCouleur.setText("NOIR");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else {
                        boutonCouleur.setBackground(Color.WHITE);
                        boutonCouleur.setForeground(Color.BLACK);
                        boutonCouleur.setText("BLANC");
                    }
                }
                validerChangement();
                boutonSortant.setText("OUT : " + Integer.toString(sortant));
                boutonEntrant.setText("IN : " + Integer.toString(entrant));
            }
        });

        JButton retour = new JButton("R");
        retour.setPreferredSize(new Dimension(X, 3));
        retour.setBackground(Color.WHITE);
        retour.setFont(fontCoul);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Temps = 24
                fermer();
                Menu m = new Menu(panneau);
            }
        });

        JPanel all = new JPanel();
        all.add(boutonEntrant);
        all.add(boutonSortant);
        all.add(boutonCouleur);
        all.add(retour);
        all.setBackground(Color.WHITE);

        content.repaint();
        this.setContentPane(all);
        this.setVisible(true);
    }

    public void fermer() {
        this.dispose();
    }

    public void validerChangement() {
        Joueur in = null;
        Joueur out = null; 
        try {
            in = panneau.getEquipe(this.couleur).getJoueurBanc(this.entrant);
        } catch (Exception ex) {
            Logger.getLogger(Renduchangement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            out = panneau.getEquipe(this.couleur).getJoueurTerrain(this.sortant);
        } catch (Exception ex) {
            Logger.getLogger(Renduchangement.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (in != null & out != null) {
            panneau.getEquipe(this.couleur).changement(in, out);
        }
    }

}
