
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
        
        
        Joueur in = pann.getEquipe(c).getJoueur(ent);
        Joueur out = pann.getEquipe(c).getJoueur(sor);
        pann.getEquipe(c).changement(in, out);
        
        
        this.sortant = sor;
        this.entrant = ent;
        this.couleur = c;

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
        sort.setPreferredSize(new Dimension(X / 2, Y /2 -20 ));
        sort.setBackground(Color.WHITE);
        sort.setFont(fontFaute);
        sort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                if (couleur.equals("RED")) {
                    Changementsortant cs = new Changementsortant(entrant, "RED", true, pann);
                } else {
                    Changementsortant cs = new Changementsortant(entrant, "BLUE", true, pann);
                }
            }
        });

        // Joueur entrant
        JButton entre = new JButton("IN : " + Integer.toString(this.entrant));
        entre.setPreferredSize(new Dimension(X / 2, Y /2 -20 ));
        entre.setBackground(Color.WHITE);
        entre.setFont(fontFaute);
        entre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                if (couleur.equals("RED")) {
                    Changemententrant cs = new Changemententrant(sortant, "RED", pann);

                } else {
                    Changemententrant cs = new Changemententrant(sortant, "RED", pann);
                }
            }
        });

        // Couleur d'équipe
        JButton coul = new JButton(c);
        if (couleur.equals("RED")) {
            coul.setBackground(Color.RED);
        } else {
            coul.setBackground(Color.BLUE);
        }

        coul.setPreferredSize(new Dimension(X, Y /2 -20 ));
        coul.setFont(fontCoul);
        coul.setForeground(Color.WHITE);
        coul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Couleurchangement cc = new Couleurchangement(sortant, entrant, pann);
            }
        });

	JButton retour = new JButton("R");
        retour.setPreferredSize(new Dimension(X , 3));
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

}
