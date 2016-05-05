
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
 * @author halbg
 */
public class Renduchangement extends JFrame {

    private Panneau pann;

    int sortant;
    int entrant;
    String couleur;

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Renduchangement(int sor, int ent, String c, Panneau panno) {

        this.pann = panno;
        this.sortant = sor;
        this.entrant = ent;
        this.couleur = c;

        validerChangement(c, ent, sor);
        pann.repaint();

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
        JButton sort = new JButton("OUT : " + Integer.toString(this.sortant));
        sort.setPreferredSize(new Dimension(X / 2, Y / 2 - 20));
        sort.setBackground(Color.WHITE);
        sort.setFont(fontFaute);
        sort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (pann.getEquipe(c).getJoueur(sor) != null) {
                    pann.getEquipe(c).ajouterTerrain(pann.getEquipe(c).getJoueur(sor));
                }
                fermer();
                if (couleur.equals("RED")) {
                    Changementsortant cs = new Changementsortant(entrant, "RED", true, pann);
                } else if (couleur.equals("BLUE")) {
                    Changementsortant cs = new Changementsortant(entrant, "BLUE", true, pann);
                } else if (couleur.equals("GREEN")) {
                    Changementsortant cs = new Changementsortant(entrant, "GREEN", true, pann);
                } else if (couleur.equals("WHITE")) {
                    Changementsortant cs = new Changementsortant(entrant, "WHITE", true, pann);
                }
                pann.repaint();
            }
        });

        // Joueur entrant
        JButton entre = new JButton("IN : " + Integer.toString(this.entrant));
        entre.setPreferredSize(new Dimension(X / 2, Y / 2 - 20));
        entre.setBackground(Color.WHITE);
        entre.setFont(fontFaute);
        entre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (pann.getEquipe(c).getJoueur(ent) != null) {
                    pann.getEquipe(c).ajouterBanc(pann.getEquipe(c).getJoueur(ent));
                }
                fermer();
                if (couleur.equals("RED")) {
                    Changemententrant ce = new Changemententrant(sortant, "RED", pann);
                } else if (couleur.equals("BLUE")) {
                    Changemententrant ce = new Changemententrant(sortant, "BLUE", pann);
                } else if (couleur.equals("GREEN")) {
                    Changemententrant ce = new Changemententrant(sortant, "GREEN", pann);
                } else if (couleur.equals("WHITE")) {
                    Changemententrant ce = new Changemententrant(sortant, "WHITE", pann);
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
                if (pann.getEquipe(c).getJoueur(sor) != null
                        && pann.getEquipe(c).getJoueur(ent) != null) {
                    pann.getEquipe(c).annulerChangement(
                            pann.getEquipe(c).getJoueur(ent),
                            pann.getEquipe(c).getJoueur(sor));
                }
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
                validerChangement(c, ent, sor);
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
                Menu m = new Menu(pann);
            }
        });

        JPanel all = new JPanel();
        all.add(entre);
        all.add(sort);
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

    public void validerChangement(String c, int ent, int sor) {
        Joueur in = pann.getEquipe(c).getJoueur(ent);
        Joueur out = pann.getEquipe(c).getJoueur(sor);
        if (in != null & out != null) {
            pann.getEquipe(c).changement(in, out);
        }
    }

}
