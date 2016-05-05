
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

	final String sok = s;
	final int nok = n;
	final String cok = c;
	
        Joueur fautif = pann.getEquipe(c).getJoueur(n);

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
        pann.repaint();
        
        this.pann = pann;

        this.type = s;
        this.num = n;
        this.couleur = c;

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
                annulerFaute(sok, nok, cok);
                fermer();
                if (couleur.equals("RED")) {
                    Typefaute tf = new Typefaute(num, "RED", pann);
                } else {
                    Typefaute tf = new Typefaute(num, "BLUE", pann);
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
                annulerFaute(sok, nok, cok);
                fermer();
                if (couleur.equals("RED")) {
                    NumeroFaute nf = new NumeroFaute(type, "RED", pann);
                } else {
                    NumeroFaute nf = new NumeroFaute(type, "BLUE", pann);
                }
                pann.repaint();
            }
        });

        // Couleur d'équipe
        JButton coul = new JButton(c);
        if (couleur.equals("RED")) {
            coul.setBackground(Color.RED);
        } else {
            coul.setBackground(Color.BLUE);
        }

        coul.setPreferredSize(new Dimension(X, Y / 2 - 20));
        coul.setFont(fontCoul);
        coul.setForeground(Color.WHITE);
        coul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                annulerFaute(sok, nok, cok);
                fermer();
                Couleurfaute cf = new Couleurfaute(type, num, pann);
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

    public void annulerFaute(String s, int n, String c) {
        Joueur fautif = pann.getEquipe(c).getJoueur(n);
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
