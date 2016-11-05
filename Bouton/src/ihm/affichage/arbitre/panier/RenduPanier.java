package ihm.affichage.arbitre.panier;

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
public class RenduPanier extends JFrame {

    private Panneau pann;
    private String couleur;

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public RenduPanier(int nombre, int n, String c, Panneau panno) {

        this.pann = panno;
        this.couleur = c;
        
        validerPanier(c, n, nombre);
        
        pann.repaint();

        final int nok = n;
        final int nombreok = nombre;

        this.setTitle("Rendu Panier");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font fontPoint = new Font("Equipe", Font.BOLD, 130);
        Font fontNum = new Font("Equipe", Font.BOLD, 150);
        Font fontCoul = new Font("Equipe", Font.BOLD, 130);

        // Creation des 3 boutons :
        // Type de faute
        JButton f = new JButton(Integer.toString(nombreok) + "pts");
        if (nombreok == 1) {
            f.setText(Integer.toString(nombreok) + "pt");
        }
        f.setPreferredSize(new Dimension(X / 2, Y / 2 - 20));
        f.setBackground(Color.WHITE);
        f.setFont(fontPoint);
        f.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                annulerPanier(nombreok, nok, couleur);
                fermer();
                if (couleur.equals("RED")) {
                    Nombrepoints np = new Nombrepoints(nok, "RED", pann);
                } else if (couleur.equals("BLUE")) {
                    Nombrepoints np = new Nombrepoints(nok, "BLUE", pann);
                } else if (couleur.equals("GREEN")) {
                    Nombrepoints np = new Nombrepoints(nok, "GREEN", pann);
                } else if (couleur.equals("WHITE")) {
                    Nombrepoints np = new Nombrepoints(nok, "WHITE", pann);
                }
                pann.repaint();
            }
        });

        // Numéro de joueur
        JButton numero = new JButton(Integer.toString(nok));
        numero.setPreferredSize(new Dimension(X / 2, Y / 2 - 20));
        numero.setBackground(Color.WHITE);
        numero.setFont(fontNum);
        numero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                annulerPanier(nombreok, nok, couleur);
                fermer();
                if (couleur.equals("RED")) {
                    Numeropanier np = new Numeropanier(nombreok, "RED", pann);
                } else if (couleur.equals("BLUE")) {
                    Numeropanier np = new Numeropanier(nombreok, "BLUE", pann);
                } else if (couleur.equals("GREEN")) {
                    Numeropanier np = new Numeropanier(nombreok, "GREEN", pann);
                } else if (couleur.equals("WHITE")) {
                    Numeropanier np = new Numeropanier(nombreok, "WHITE", pann);
                }
                pann.repaint();
            }
        });

        // Couleur d'équipe
        JButton b2 = new JButton("AUTRE");
        b2.setForeground(Color.WHITE);
        if (c.equals("RED")) {
            b2.setBackground(Color.RED);
            b2.setText("ROUGE");
        } else if (c.equals("BLUE")) {
            b2.setBackground(Color.BLUE);
            b2.setText("BLEU");
        } else if (c.equals("GREEN")) {
            b2.setBackground(Color.GREEN);
            b2.setText("VERT");
        } else if (c.equals("BLACK")) {
            b2.setBackground(Color.BLACK);
            b2.setText("NOIR");
        } else {
            b2.setBackground(Color.WHITE);
            b2.setForeground(Color.BLACK);
            b2.setText("BLANC");
        }
        b2.setFont(fontCoul);
        b2.setPreferredSize(new Dimension(X, Y / 2));
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                annulerPanier(nombreok, nok, couleur);
                if (couleur.equals(pann.getVisiteurs().getCouleur())) {
                    couleur = pann.getLocaux().getCouleur();
                    if (couleur.equals("RED")) {
                        b2.setBackground(Color.RED);
                        b2.setText("ROUGE");
                        b2.setForeground(Color.WHITE);
                    } else if (couleur.equals("BLUE")) {
                        b2.setBackground(Color.BLUE);
                        b2.setText("BLEU");
                        b2.setForeground(Color.WHITE);
                    } else if (couleur.equals("GREEN")) {
                        b2.setBackground(Color.GREEN);
                        b2.setText("VERT");
                        b2.setForeground(Color.WHITE);
                    } else if (couleur.equals("BLACK")) {
                        b2.setBackground(Color.BLACK);
                        b2.setText("NOIR");
                        b2.setForeground(Color.WHITE);
                    } else {
                        b2.setBackground(Color.WHITE);
                        b2.setForeground(Color.BLACK);
                        b2.setText("BLANC");
                    }
                } else {
                    couleur = pann.getVisiteurs().getCouleur();
                    if (couleur.equals("RED")) {
                        b2.setBackground(Color.RED);
                        b2.setText("ROUGE");
                        b2.setForeground(Color.WHITE);
                    } else if (couleur.equals("BLUE")) {
                        b2.setBackground(Color.BLUE);
                        b2.setText("BLEU");
                        b2.setForeground(Color.WHITE);
                    } else if (couleur.equals("GREEN")) {
                        b2.setBackground(Color.GREEN);
                        b2.setText("VERT");
                        b2.setForeground(Color.WHITE);
                    } else if (couleur.equals("BLACK")) {
                        b2.setBackground(Color.BLACK);
                        b2.setText("NOIR");
                        b2.setForeground(Color.WHITE);
                    } else {
                        b2.setBackground(Color.WHITE);
                        b2.setForeground(Color.BLACK);
                        b2.setText("BLANC");
                    }
                }
                validerPanier(couleur, n, nombre);
                pann.repaint();
            }
        });

        JButton retour = new JButton("R");
        retour.setPreferredSize(new Dimension(X, 3));
        retour.setBackground(Color.WHITE);
        retour.setFont(fontNum);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Temps = 24
                fermer();
                Menu m = new Menu(pann);
                pann.repaint();
            }
        });

        JPanel all = new JPanel();
        all.add(f);
        all.add(numero);
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

    public void annulerPanier(int nombre, int n, String c) {
        Joueur marqueur = null;
        try {
            marqueur = pann.getEquipe(c).getJoueurEquipe(n);
        } catch (Exception ex) {
            Logger.getLogger(RenduPanier.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (marqueur != null) {
            if (nombre == 1) {
                marqueur.decr1Point();
            } else if (nombre == 2) {
                marqueur.decr2Points();
            } else if (nombre == 3) {
                marqueur.decr3Points();
            }
            pann.getEquipe(c).comptePoints();
        }
    }

    public void validerPanier(String c, int n, int nombre) {
        Joueur marqueur = null;
        try {
            marqueur = pann.getEquipe(c).getJoueurEquipe(n);
        } catch (Exception ex) {
            Logger.getLogger(RenduPanier.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (marqueur != null) {
            if (nombre == 1) {
                marqueur.incr1Point();
            } else if (nombre == 2) {
                marqueur.incr2Points();
            } else if (nombre == 3) {
                marqueur.incr3Points();
            }
            pann.getEquipe(c).comptePoints();
        }
    }
}
