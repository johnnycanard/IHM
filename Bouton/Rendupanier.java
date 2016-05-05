
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
public class Rendupanier extends JFrame {

    private Panneau pann;

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Rendupanier(int nombre, int n, String c, Panneau panno) {

        this.pann = panno;

        Joueur marqueur = pann.getEquipe(c).getJoueur(n);

        if (nombre == 1) {
            marqueur.incr1Point();
        } else if (nombre == 2) {
            marqueur.incr2Points();
        } else if (nombre == 3) {
            marqueur.incr3Points();
        } else {
            System.out.print(Integer.toString(nombre) + " point(s) n'est pas acceptable");
        }

        pann.getEquipe(c).comptePoints();
        pann.repaint();

        final int nok = n;
        final String cok = c;
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
                annulerPanier(nombreok, nok, cok);
                fermer();
                if (cok.equals("RED")) {
                    Nombrepoints np = new Nombrepoints(nok, "RED", pann);
                } else {
                    Nombrepoints np = new Nombrepoints(nok, "BLUE", pann);
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
                annulerPanier(nombreok, nok, cok);
                fermer();
                if (cok.equals("RED")) {
                    Numeropanier np = new Numeropanier(nombreok, "RED", pann);
                } else {
                    Numeropanier np = new Numeropanier(nombreok, "BLUE", pann);
                }
                pann.repaint();
            }
        });

        // Couleur d'équipe
        JButton coul = new JButton(cok);
        if (cok.equals("RED")) {
            coul.setBackground(Color.RED);
        } else {
            coul.setBackground(Color.BLUE);
        }

        coul.setPreferredSize(new Dimension(X, Y / 2 - 20));
        coul.setFont(fontCoul);
        coul.setForeground(Color.WHITE);
        coul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                annulerPanier(nombreok, nok, cok);
                fermer();
                Couleurpanier cp = new Couleurpanier(nombreok, nok, pann);
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
        all.add(coul);
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
        Joueur marqueur = pann.getEquipe(c).getJoueur(n);
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
