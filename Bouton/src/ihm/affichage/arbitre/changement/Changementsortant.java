package ihm.affichage.arbitre.changement;

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
public class Changementsortant extends JFrame {

    private Panneau panneau;

    private String couleur;
    private int numeroEntrant;
    private LinkedList<JButton> listeJoueursSortants = new LinkedList<JButton>();
    private String couleurInitiale;
    
    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;
    
    public Changementsortant(int entrant, String coul, Panneau panneau) {
        this.couleurInitiale = coul;
        this.panneau = panneau;
        this.couleur = coul;
        this.numeroEntrant = entrant;

        this.setTitle("Joueur Sortant");
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

        Equipe equipe = panneau.getEquipe(coul);

        for (Joueur joueur : equipe.getTerrain()) {
            JButton boutonJoueur = new JButton(Integer.toString(joueur.getNum()));
            boutonJoueur.setFont(font);
            boutonJoueur.setBackground(Color.WHITE);
            boutonJoueur.setPreferredSize(new Dimension(X / 3, Y / 2));
            boutonJoueur.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    fermer();
                    if (!couleurInitiale.equals(couleur)) {
                        if (!panneau.getEquipe(couleur).dansEquipe(numeroEntrant)) {
                            numeroEntrant = panneau.getEquipe(couleur).getBanc().getFirst().getNum();
                        }
                    }
                    RenduChangement rc = new RenduChangement(Integer.parseInt(boutonJoueur.getText()),
                        numeroEntrant, coul, panneau);
                }
            });
            all.add(boutonJoueur);
        }

        JButton boutonCouleur = new JButton(coul);
        Font changeFont = new Font("Couleur", Font.BOLD, 40);
        boutonCouleur.setFont(changeFont);
        peindreBoutonCouleur(boutonCouleur);
        boutonCouleur.setPreferredSize(new Dimension(X/3, Y/2));
        boutonCouleur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (couleur.equals(panneau.getVisiteurs().getCouleur())) {
                    Equipe locaux = panneau.getLocaux();
                    couleur = locaux.getCouleur();
                    peindreBoutonCouleur(boutonCouleur);
                    for (int i = 0; i < listeJoueursSortants.size(); i++) {
                        listeJoueursSortants.get(i).setText(
                                Integer.toString(locaux.getBanc().get(i).getNum()));
                    }
                } else {
                    Equipe visiteurs = panneau.getVisiteurs();
                    couleur = visiteurs.getCouleur();
                    peindreBoutonCouleur(boutonCouleur);
                    for (int i = 0; i < listeJoueursSortants.size(); i++) {
                        listeJoueursSortants.get(i).setText(
                                Integer.toString(visiteurs.getBanc().get(i).getNum()));
                    }
                }
                panneau.repaint();
            }
        });

        all.add(boutonCouleur);

        content.repaint();

        this.setContentPane(all);
        this.setVisible(true);
    }
    
    private void peindreBoutonCouleur(JButton boutonCouleur) {
    boutonCouleur.setForeground(Color.WHITE);
        if (couleur.equals("RED")) {
            boutonCouleur.setBackground(Color.RED);
            boutonCouleur.setText("ROUGE");
        } else if (couleur.equals("BLUE")) {
            boutonCouleur.setBackground(Color.BLUE);
            boutonCouleur.setText("BLEU");
        } else if (couleur.equals("GREEN")) {
            boutonCouleur.setBackground(Color.GREEN);
            boutonCouleur.setText("VERT");
        } else if (couleur.equals("BLACK")) {
            boutonCouleur.setBackground(Color.BLACK);
            boutonCouleur.setText("NOIR");
        } else {
            boutonCouleur.setBackground(Color.WHITE);
            boutonCouleur.setForeground(Color.BLACK);
            boutonCouleur.setText("BLANC");
        }
    }
    
    public void fermer() {
        this.dispose();
    }
}
