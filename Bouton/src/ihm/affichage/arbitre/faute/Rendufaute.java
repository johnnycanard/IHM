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
    private int numeroJoueur;
    private String couleur;

    private int X = 700;
    private int Y = 500;

    public Rendufaute(String type, int num, String coul, Panneau panneau) {
        this.panneau = panneau;
        this.typeFaute = type;
        this.numeroJoueur = num;
        this.couleur = coul;

        panneau.arretChronometre();
        
        validerFaute();
        panneau.repaint();

        System.out.println("Classe name: " + this.getClass().getSimpleName());
        
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
        boutonFaute.addActionListener((ActionEvent event) -> {
            try {
                annulerFaute();
            } catch (Exception ex) {
                Logger.getLogger(Rendufaute.class.getName()).log(Level.SEVERE, null, ex);
            }
            fermer();
            Typefaute tf = new Typefaute(numeroJoueur, couleur, panneau);
            panneau.repaint();
        });

        // Numéro de joueur
        JButton boutonNumero = new JButton(Integer.toString(numeroJoueur));
        boutonNumero.setPreferredSize(new Dimension(X / 2, Y / 2 - 20));
        boutonNumero.setBackground(Color.WHITE);
        boutonNumero.setFont(fontNum);
        boutonNumero.addActionListener((ActionEvent event) -> {
            try {
                annulerFaute();
            } catch (Exception ex) {
                Logger.getLogger(Rendufaute.class.getName()).log(Level.SEVERE, null, ex);
            }
            fermer();
            NumeroFauteTerrain nf = new NumeroFauteTerrain(typeFaute, couleur, panneau);
            panneau.repaint();
        });

        JButton boutonCouleur = new JButton("");
        peindreBoutonCouleur(boutonCouleur);
        boutonCouleur.setFont(fontCouleur);
        boutonCouleur.setPreferredSize(new Dimension(X, Y / 2));
        boutonCouleur.addActionListener((ActionEvent event) -> {
            try {
                annulerFaute();
            } catch (Exception ex) {
                Logger.getLogger(Rendufaute.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (couleur.equals(panneau.getVisiteurs().getCouleur())) {
                couleur = panneau.getLocaux().getCouleur();
                peindreBoutonCouleur(boutonCouleur);
            } else {
                couleur = panneau.getVisiteurs().getCouleur();
                peindreBoutonCouleur(boutonCouleur);
            }
            validerFaute();
            boutonNumero.setText(Integer.toString(numeroJoueur));
            panneau.repaint();
        });
        JButton retour = new JButton("R");
        retour.setPreferredSize(new Dimension(X, 3));
        retour.setBackground(Color.WHITE);
        retour.setFont(fontNum);
        retour.addActionListener((ActionEvent event) -> {
            fermer();
            Menu menu = new Menu(panneau);
            panneau.repaint();
        });

        JPanel all = new JPanel();
        all.add(boutonFaute);
        all.add(boutonNumero);
        all.add(boutonCouleur);
        all.add(retour);
        all.setBackground(Color.WHITE);

        this.setContentPane(all);
        this.setVisible(true);
    }

    public void fermer() {
        this.dispose();
    }

    public void annulerFaute() throws Exception {
        Joueur fautif;
        try {
            fautif = panneau.getEquipe(this.couleur).getJoueurEquipe(this.numeroJoueur);
        } catch (Exception e) {
            // Normalement on n'arrive jamais là
            throw new Exception(this.numeroJoueur + " " + this.couleur + "pas sur le terrain");
        }
        if (fautif != null) {
            switch (this.typeFaute) {
                case "FAUTE":
                    fautif.decrFautes();
                    break;
                case "SPORT":
                    fautif.decrSport();
                    break;
                case "TECH":
                    fautif.decrTech();
                    break;
                default:
                    break;
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
            switch (this.typeFaute) {
                case "FAUTE":
                    fautif.incrFautes();
                    break;
                case "SPORT":
                    fautif.incrSport();
                    break;
                case "TECH":
                    fautif.incrTech();
                    break;
                default:
                    break;
            }
            panneau.getEquipe(this.couleur).incrFautes();
        }
        
        if (panneau.getEquipe(this.couleur).surBanc(fautif) && typeFaute.equals("FAUTE")) {
            System.out.println("Un joueur sur le banc ne peut pas avoir une faute simple");
            // TODO: générer une erreur
        }
    }
    
    private void peindreBoutonCouleur(JButton boutonCouleur) {
        boutonCouleur.setForeground(Color.WHITE);
        switch (couleur) {
            case "RED":
                boutonCouleur.setBackground(Color.RED);
                boutonCouleur.setText("ROUGE");
                break;
            case "BLUE":
                boutonCouleur.setBackground(Color.BLUE);
                boutonCouleur.setText("BLEU");
                break;
            case "GREEN":
                boutonCouleur.setBackground(Color.GREEN);
                boutonCouleur.setText("VERT");
                break;
            case "BLACK":
                boutonCouleur.setBackground(Color.BLACK);
                boutonCouleur.setText("NOIR");
                break;
            default:
                boutonCouleur.setBackground(Color.WHITE);
                boutonCouleur.setForeground(Color.BLACK);
                boutonCouleur.setText("BLANC");
                break;
        }
    }
}
