
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
public class NumeroFaute extends JFrame {

    private Panneau pann;
    
    String type;
    String couleur;

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public NumeroFaute(String t, String c, Panneau panno) {
        
        this.pann = panno;

        this.type = t;
        this.couleur = c;

        this.setTitle("Numéro Faute");
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
        
        for (Joueur j1 : eq.getTerrain()) {
            JButton j = new JButton(Integer.toString(j1.getNum()));
            j.setFont(font);
            j.setBackground(Color.WHITE);
            j.setPreferredSize(new Dimension(X / 3, Y / 2));
	    final Joueur j1ok = j1;
            j.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    fermer();
                    Rendufaute r = new Rendufaute(type, j1ok.getNum(), couleur, pann);
                }
            });
            all.add(j);
        }

        JButton j = new JButton();
        Font changeFont = new Font("Joueurs", Font.BOLD, 20);
        j.setText("Changement");
        j.setFont(changeFont);
        j.setBackground(Color.WHITE);
        j.setPreferredSize(new Dimension(X / 3, Y / 2));
        all.add(j);
        j.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Changementsortant cs = new Changementsortant(0, couleur, false, pann);
            }
        });

        content.repaint();

        this.setContentPane(all);

        this.setVisible(
                true);
    }

    public void fermer() {
        this.dispose();
    }
}
