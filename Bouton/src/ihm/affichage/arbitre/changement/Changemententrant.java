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
public class Changemententrant extends JFrame {

    private Panneau panneau;

    private String couleurSortant;
    private int numeroSortant;
    private LinkedList<JButton> listeJoueurEntrant = new LinkedList<JButton>();
    private String couleurInitiale;
    
    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Changemententrant(int sortant, String coul, Panneau panneau) {
        this.couleurInitiale = coul;
        this.panneau = panneau;
        this.numeroSortant = sortant;
        this.couleurSortant = coul;

        this.setTitle("Joueur Entrant");
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

        Equipe equipe = panneau.getEquipe(couleurSortant);
        
        for (Joueur joueur : equipe.getBanc()) {
            JButton boutonJoueurCourant = new JButton(Integer.toString(joueur.getNum()));
            boutonJoueurCourant.setFont(font);
            boutonJoueurCourant.setBackground(Color.WHITE);
            boutonJoueurCourant.setPreferredSize(new Dimension(X / 3, Y / 2));
            boutonJoueurCourant.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    fermer();
                    if (!couleurInitiale.equals(couleurSortant)) {
                        if (!panneau.getEquipe(couleurSortant).surTerrain(numeroSortant)) {
                            numeroSortant = panneau.getEquipe(couleurSortant).getTerrain().getFirst().getNum();
                        }
                    }
                    RenduChangement rc = new RenduChangement(numeroSortant, 
                            Integer.parseInt(boutonJoueurCourant.getText()), couleurSortant, panneau);
                }
            });
            listeJoueurEntrant.add(boutonJoueurCourant);
            all.add(boutonJoueurCourant);
        }

        JButton boutonCouleur = new JButton(couleurSortant);
        Font changeFont = new Font("Couleur", Font.BOLD, 60);
        boutonCouleur.setFont(changeFont);
        boutonCouleur.setPreferredSize(new Dimension(X / 3, Y / 2));
        peindreBoutonCouleur(boutonCouleur);
        
        boutonCouleur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // fermer();
                // Couleurchangement cc = new Couleurchangement(1, entrant, pann);
                if (couleurSortant.equals(panneau.getVisiteurs().getCouleur())) {
                    Equipe locaux = panneau.getLocaux();
                    couleurSortant = locaux.getCouleur();
                    peindreBoutonCouleur(boutonCouleur);
                    for (int i = 0; i < listeJoueurEntrant.size(); i++) {
                        listeJoueurEntrant.get(i).setText(Integer.toString(locaux.getBanc().get(i).getNum()));
                    }
                } else {
                    Equipe visiteurs = panneau.getVisiteurs();
                    couleurSortant = panneau.getVisiteurs().getCouleur();
                    peindreBoutonCouleur(boutonCouleur);
                    for (int i = 0; i < listeJoueurEntrant.size(); i++) {
                        listeJoueurEntrant.get(i).setText(Integer.toString(visiteurs.getBanc().get(i).getNum()));
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
        if (couleurSortant.equals("RED")) {
            boutonCouleur.setBackground(Color.RED);
            boutonCouleur.setText("ROUGE");
        } else if (couleurSortant.equals("BLUE")) {
            boutonCouleur.setBackground(Color.BLUE);
            boutonCouleur.setText("BLEU");
        } else if (couleurSortant.equals("GREEN")) {
            boutonCouleur.setBackground(Color.GREEN);
            boutonCouleur.setText("VERT");
        } else if (couleurSortant.equals("BLACK")) {
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
