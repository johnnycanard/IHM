package ihm.affichage.arbitre.faute;

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
public class Rendufaute extends JFrame {

    private Panneau panneau;

    private String typeFaute;
    private int numeroJoueur = 0;
    private String couleur;

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Rendufaute(String s, int n, String c, Panneau panneau) {

        this.panneau = panneau;
        this.typeFaute = s;
        this.numeroJoueur = n;
        this.couleur = c;

        final String sok = s;
        final int nok = this.numeroJoueur;

        validerFaute();
        panneau.repaint();

        this.setTitle("Rendu Faute");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font fontNum = new Font("Numero", Font.BOLD, 150);
        Font fontFaute = new Font("TypeFaute", Font.BOLD, 70);
        Font fontCouleur = new Font("Couleur", Font.BOLD, 130);

        // Creation des 3 boutons :
        // Type de faute
        JButton boutonFaute = new JButton(typeFaute);
        boutonFaute.setPreferredSize(new Dimension(X / 2, Y / 2 - 20));
        boutonFaute.setBackground(Color.WHITE);
        boutonFaute.setFont(fontFaute);
        boutonFaute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    annulerFaute();
                } catch (Exception ex) {
                    Logger.getLogger(Rendufaute.class.getName()).log(Level.SEVERE, null, ex);
                }
                fermer();
                if (couleur.equals("RED")) {
                    Typefaute tf = new Typefaute(numeroJoueur, "RED", panneau);
                } else if (couleur.equals("BLUE")) {
                    Typefaute tf = new Typefaute(numeroJoueur, "BLUE", panneau);
                } else if (couleur.equals("GREEN")) {
                    Typefaute tf = new Typefaute(numeroJoueur, "GREEN", panneau);
                } else if (couleur.equals("WHITE")) {
                    Typefaute tf = new Typefaute(numeroJoueur, "WHITE", panneau);
                }
                panneau.repaint();
            }
        });

        // Numéro de joueur
        JButton boutonNumero = new JButton(Integer.toString(numeroJoueur));
        boutonNumero.setPreferredSize(new Dimension(X / 2, Y / 2 - 20));
        boutonNumero.setBackground(Color.WHITE);
        boutonNumero.setFont(fontNum);
        boutonNumero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    annulerFaute();
                } catch (Exception ex) {
                    Logger.getLogger(Rendufaute.class.getName()).log(Level.SEVERE, null, ex);
                }
                fermer();
                if (couleur.equals("RED")) {
                    NumeroFaute nf = new NumeroFaute(typeFaute, "RED", panneau);
                } else if (couleur.equals("BLUE")) {
                    NumeroFaute nf = new NumeroFaute(typeFaute, "BLUE", panneau);
                } else if (couleur.equals("GREEN")) {
                    NumeroFaute nf = new NumeroFaute(typeFaute, "GREEN", panneau);
                } else if (couleur.equals("WHITE")) {
                    NumeroFaute nf = new NumeroFaute(typeFaute, "WHITE", panneau);
                }
                panneau.repaint();
            }
        });

        // Couleur d'équipe
        JButton boutonCouleur = new JButton("AUTRE");
        boutonCouleur.setForeground(Color.WHITE);
        if (c.equals("RED")) {
            boutonCouleur.setBackground(Color.RED);
            boutonCouleur.setText("ROUGE");
        } else if (c.equals("BLUE")) {
            boutonCouleur.setBackground(Color.BLUE);
            boutonCouleur.setText("BLEU");
        } else if (c.equals("GREEN")) {
            boutonCouleur.setBackground(Color.GREEN);
            boutonCouleur.setText("VERT");
        } else if (c.equals("BLACK")) {
            boutonCouleur.setBackground(Color.BLACK);
            boutonCouleur.setText("NOIR");
        } else {
            boutonCouleur.setBackground(Color.WHITE);
            boutonCouleur.setForeground(Color.BLACK);
            boutonCouleur.setText("BLANC");
        }
        boutonCouleur.setFont(fontCouleur);
        boutonCouleur.setPreferredSize(new Dimension(X, Y / 2));
        boutonCouleur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    annulerFaute();
                } catch (Exception ex) {
                    Logger.getLogger(Rendufaute.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (couleur.equals(panneau.getVisiteurs().getCouleur())) {
                    couleur = panneau.getLocaux().getCouleur(); 
                    if (couleur.equals("RED")) {
                        boutonCouleur.setBackground(Color.RED);
                        boutonCouleur.setText("ROUGE");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else if (couleur.equals("BLUE")) {
                        boutonCouleur.setBackground(Color.BLUE);
                        boutonCouleur.setText("BLEU");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else if (couleur.equals("GREEN")) {
                        boutonCouleur.setBackground(Color.GREEN);
                        boutonCouleur.setText("VERT");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else if (couleur.equals("BLACK")) {
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
                    if (couleur.equals("RED")) {
                        boutonCouleur.setBackground(Color.RED);
                        boutonCouleur.setText("ROUGE");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else if (couleur.equals("BLUE")) {
                        boutonCouleur.setBackground(Color.BLUE);
                        boutonCouleur.setText("BLEU");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else if (couleur.equals("GREEN")) {
                        boutonCouleur.setBackground(Color.GREEN);
                        boutonCouleur.setText("VERT");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else if (couleur.equals("BLACK")) {
                        boutonCouleur.setBackground(Color.BLACK);
                        boutonCouleur.setText("NOIR");
                        boutonCouleur.setForeground(Color.WHITE);
                    } else {
                        boutonCouleur.setBackground(Color.WHITE);
                        boutonCouleur.setForeground(Color.BLACK);
                        boutonCouleur.setText("BLANC");
                    }
                }
                validerFaute();
                boutonNumero.setText(Integer.toString(numeroJoueur));
                panneau.repaint();
            }
        });
        JButton retour = new JButton("R");
        retour.setPreferredSize(new Dimension(X, 3));
        retour.setBackground(Color.WHITE);
        retour.setFont(fontNum);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Menu menu = new Menu(panneau);
                panneau.repaint();
            }
        });

        JPanel all = new JPanel();
        all.add(boutonFaute);
        all.add(boutonNumero);
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

    public void annulerFaute() throws Exception{
        Joueur fautif;
        try {
            fautif = panneau.getEquipe(this.couleur).getJoueurEquipe(this.numeroJoueur);
        } catch (Exception e) {
            // Normalement on n'arrive jamais là
            throw new Exception(this.numeroJoueur + " " + this.couleur + "pas sur le terrain");
        }
        if (fautif != null) {
            if (this.typeFaute.equals("FAUTE")) {
                fautif.decrFautes();
            } else if (this.typeFaute.equals("SPORT")) {
                fautif.decrSport();
            } else if (this.typeFaute.equals("TECH")) {
                fautif.decrTech();
            }
            panneau.getEquipe(this.couleur).decrFautes();
        }
    }

    /**
     * On peut donner une faute à un joueur sur le banc
    */
    public void validerFaute() {
        Joueur fautif;
        try {
            fautif = panneau.getEquipe(this.couleur).getJoueurEquipe(this.numeroJoueur);
        } catch (Exception e) {
            fautif = panneau.getEquipe(couleur).getTeam().getFirst();
            this.numeroJoueur = fautif.getNum();
        }
        
        if (fautif != null) {
            if (this.typeFaute.equals("FAUTE")) {
                fautif.incrFautes();
            } else if (this.typeFaute.equals("SPORT")) {
                fautif.incrSport();
            } else if (this.typeFaute.equals("TECH")) {
                fautif.incrTech();
            }
            panneau.getEquipe(this.couleur).incrFautes();
        }
    }
}
