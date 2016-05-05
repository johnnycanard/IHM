
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
public class Rendufaute extends JFrame {

    private Panneau pann;

    String type;
    int num = 0;
    String couleur;

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Rendufaute(String s, int n, String c, Panneau panno) {

        this.pann = panno;
        this.type = s;
        this.num = n;
        this.couleur = c;

        final String sok = s;
        final int nok = n;

        validerFaute(s, n, couleur);
        pann.repaint();

        this.setTitle("Rendu Faute");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font fontNum = new Font("Equipe", Font.BOLD, 150);
        Font fontFaute = new Font("Equipe", Font.BOLD, 70);
        Font fontCoul = new Font("Equipe", Font.BOLD, 130);

        // Creation des 3 boutons :
        // Type de faute
        JButton f = new JButton(type);
        f.setPreferredSize(new Dimension(X / 2, Y / 2 - 20));
        f.setBackground(Color.WHITE);
        f.setFont(fontFaute);
        f.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                annulerFaute(sok, nok, couleur);
                fermer();
                if (couleur.equals("RED")) {
                    Typefaute tf = new Typefaute(num, "RED", pann);
                } else if (couleur.equals("BLUE")) {
                    Typefaute tf = new Typefaute(num, "BLUE", pann);
                } else if (couleur.equals("GREEN")) {
                    Typefaute tf = new Typefaute(num, "GREEN", pann);
                } else if (couleur.equals("WHITE")) {
                    Typefaute tf = new Typefaute(num, "WHITE", pann);
                }
                pann.repaint();
            }
        });

        // Numéro de joueur
        JButton numero = new JButton(Integer.toString(num));
        numero.setPreferredSize(new Dimension(X / 2, Y / 2 - 20));
        numero.setBackground(Color.WHITE);
        numero.setFont(fontNum);
        numero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                annulerFaute(sok, nok, couleur);
                fermer();
                if (couleur.equals("RED")) {
                    NumeroFaute nf = new NumeroFaute(type, "RED", pann);
                } else if (couleur.equals("BLUE")) {
                    NumeroFaute nf = new NumeroFaute(type, "BLUE", pann);
                } else if (couleur.equals("GREEN")) {
                    NumeroFaute nf = new NumeroFaute(type, "GREEN", pann);
                } else if (couleur.equals("WHITE")) {
                    NumeroFaute nf = new NumeroFaute(type, "WHITE", pann);
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
                annulerFaute(sok, nok, couleur);
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
                validerFaute(s, n, couleur);
                pann.repaint();
            }
        });

        JButton retour = new JButton("R");
        retour.setPreferredSize(new Dimension(X, 3));
        retour.setBackground(Color.WHITE);
        retour.setFont(fontNum);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
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

    public void annulerFaute(String s, int n, String c) {
        Joueur fautif = pann.getEquipe(c).getJoueur(n);
        if (fautif != null) {
            if (s.equals("FAUTE")) {
                fautif.decrFautes();
            } else if (s.equals("SPORT")) {
                fautif.decrSport();
            } else if (s.equals("TECH")) {
                fautif.decrTech();
            } else {
                System.out.println("Type de faute non reconnu : " + s);
            }
            pann.getEquipe(c).decrFautes();
        }
    }

    public void validerFaute(String s, int n, String c) {
        Joueur fautif = pann.getEquipe(c).getJoueur(n);
        if (fautif != null) {
            if (s.equals("FAUTE")) {
                fautif.incrFautes();
            } else if (s.equals("SPORT")) {
                fautif.incrSport();
            } else if (s.equals("TECH")) {
                fautif.incrTech();
            } else {
                System.out.println("Type de faute non reconnu : " + s);
            }

            pann.getEquipe(c).incrFautes();
        }
    }
}
