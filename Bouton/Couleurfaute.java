
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
public class Couleurfaute extends JFrame {

    private Panneau pann;

    String type;
    int num = 0;

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Couleurfaute(String t, int n, Panneau panno) {

        this.pann = panno;

        this.type = t;
        this.num = n;

        this.setTitle("Couleur Faute");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font font = new Font("Equipe", Font.BOLD, 50);

        JButton b1 = new JButton("AUTRE");
        b1.setForeground(Color.WHITE);

        if (this.pann.getVisiteurs().getCouleur().equals("RED")) {
            b1.setBackground(Color.RED);
            b1.setText("ROUGE");
        } else if (this.pann.getVisiteurs().getCouleur().equals("BLUE")) {
            b1.setBackground(Color.BLUE);
            b1.setText("BLEU");
        } else if (this.pann.getVisiteurs().getCouleur().equals("GREEN")) {
            b1.setBackground(Color.GREEN);
            b1.setText("VERT");
        } else if (this.pann.getVisiteurs().getCouleur().equals("BLACK")) {
            b1.setBackground(Color.BLACK);
            b1.setText("NOIR");
        } else {
            b1.setBackground(Color.WHITE);
            b1.setText("BLANC");
            b1.setForeground(Color.BLACK);
        }
        b1.setFont(font);
        b1.setPreferredSize(new Dimension(X / 2, Y));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Rendufaute r = new Rendufaute(type, num,
                        pann.getVisiteurs().getCouleur(), pann);
                System.out.println(pann.getVisiteurs().getCouleur());
            }
        });

        JButton b2 = new JButton("AUTRE");
        b2.setForeground(Color.WHITE);
        if (this.pann.getLocaux().getCouleur().equals("RED")) {
            b2.setBackground(Color.RED);
            b2.setText("ROUGE");
        } else if (this.pann.getLocaux().getCouleur().equals("BLUE")) {
            b2.setBackground(Color.BLUE);
            b2.setText("BLEU");
        } else if (this.pann.getLocaux().getCouleur().equals("GREEN")) {
            b2.setBackground(Color.GREEN);
            b2.setText("VERT");
        } else if (this.pann.getLocaux().getCouleur().equals("BLACK")) {
            b2.setBackground(Color.BLACK);
            b2.setText("NOIR");
        } else {
            b2.setBackground(Color.WHITE);
            b2.setForeground(Color.BLACK);
            b2.setText("BLANC");
        }
        b2.setFont(font);
        b2.setPreferredSize(new Dimension(X / 2, Y));
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Rendufaute r = new Rendufaute(type, num,
                        pann.getLocaux().getCouleur(), pann);
            }
        });

        JPanel all = new JPanel();
        all.add(b1);
        all.add(b2);

        content.repaint();

        this.setContentPane(all);
        this.setVisible(true);
    }

    public void fermer() {
        this.dispose();
    }

}
