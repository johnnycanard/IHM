
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
public class Changemententrant extends JFrame {

    private Panneau pann;

    String couleur; // couleur du joueur sortant
    int sortant; // numéro du joueur sortant 

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Changemententrant(int sort, String c, Panneau panno) {

        this.pann = panno;

        this.sortant = sort;
        this.couleur = c;

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

        Equipe eq = pann.getEquipe(c);

        for (Joueur j1 : eq.getBanc()) {
            JButton j = new JButton(Integer.toString(j1.getNum()));
            j.setFont(font);
            j.setBackground(Color.WHITE);
            j.setPreferredSize(new Dimension(X / 3, Y / 2));
            final Joueur j1ok = j1;
            j.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    fermer();
                    Renduchangement rc = new Renduchangement(sortant, j1ok.getNum(), couleur, pann);
                }
            });
            all.add(j);
        }

        JButton j = new JButton(c);
        Font changeFont = new Font("Couleur", Font.BOLD, 60);
        j.setFont(changeFont);
        j.setForeground(Color.WHITE);
        j.setPreferredSize(new Dimension(X / 3, Y / 2));
        if (c.equals("RED")) {
            j.setBackground(Color.RED);
        } else if (c.equals("BLUE")) {
            j.setBackground(Color.BLUE);
        } else if (c.equals("GREEN")) {
            j.setBackground(Color.GREEN);
        } else if (c.equals("BLACK")) {
            j.setBackground(Color.BLACK);
        } else {
            j.setBackground(Color.WHITE);
            j.setForeground(Color.BLACK);
        }

        all.add(j);

        content.repaint();

        this.setContentPane(all);
        this.setVisible(true);
    }

    public void fermer() {
        this.dispose();
    }
}
