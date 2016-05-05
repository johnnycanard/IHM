
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
public class Changementsortant extends JFrame {

    private Panneau pann;
    
    String couleur; // couleur du joueur sortant
    int entrant; // joueur entrant

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Changementsortant(int ent, String c, boolean correction, Panneau panno) {

        this.pann = panno;
        
        this.couleur = c;
        this.entrant = ent;
	final boolean corr = correction;
	
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

        for (int i = 1; i < 6; i++) {
            JButton j = new JButton();
            final int k = i;
            j.setFont(font);
            j.setText(Integer.toString(i));
            j.setBackground(Color.WHITE);
            j.setPreferredSize(new Dimension(X / 3, Y / 2));
            j.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    fermer();
                    if (corr) {
                        Renduchangement rc = new Renduchangement(k, entrant, couleur, pann);
                    } else {
                        Changemententrant ce = new Changemententrant(k, couleur, pann);
                    }
                }
            });
            all.add(j);
        }

        JButton j = new JButton(c);
        Font changeFont = new Font("Couleur", Font.BOLD, 60);
        j.setFont(changeFont);

        if (couleur.equals("RED")) {
            j.setBackground(Color.RED);
        } else {
            j.setBackground(Color.BLUE);
        }
        
        j.setPreferredSize(new Dimension(X / 3, Y / 2));
        j.setForeground(Color.WHITE);
        
        j.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Couleurchangement cc = new Couleurchangement(0, entrant, pann);
            }
        });

        all.add(j);

        content.repaint();

        this.setContentPane(all);
        this.setVisible(true);
    }

    public void fermer() {
        this.dispose();
    }
}
