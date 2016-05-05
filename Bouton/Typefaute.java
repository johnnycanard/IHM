
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
public class Typefaute extends JFrame {

        private Panneau pann;
    
    String couleur;
    int num;

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Typefaute(int n, String c, Panneau pann) {

        this.pann = pann;
        
        this.num = n;
        this.couleur = c;

        this.setTitle("Type Faute");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font fontFaute = new Font("faute", Font.BOLD, 130);
        Font fontSport = new Font("sport", Font.BOLD, 50);
        Font fontTech = new Font("tech", Font.BOLD, 50);

        JButton faute = new JButton("FAUTE");
        faute.setBackground(Color.white);
        faute.setPreferredSize(new Dimension(X, Y / 2));
        faute.setFont(fontFaute);
        faute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                    fermer();
                    Rendufaute r = new Rendufaute("FAUTE", num, couleur, pann);
            }
        });

        JButton sport = new JButton("SPORTIVE");
        sport.setBackground(Color.white);
        sport.setPreferredSize(new Dimension(X / 2, Y / 2));
        sport.setFont(fontSport);
        sport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                    fermer();
                    Rendufaute r = new Rendufaute("SPORT", num, couleur, pann);
            }
        });
        
        JButton tech = new JButton("TECHNIQUE");
        tech.setBackground(Color.white);
        tech.setPreferredSize(new Dimension(X / 2, Y / 2));
        tech.setFont(fontTech);
        tech.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                    fermer();
                    Rendufaute r = new Rendufaute("TECH", num, couleur, pann);
            }
        });
        

        JPanel all = new JPanel();
        all.add(faute);
        all.add(sport);
        all.add(tech);

        content.repaint();

        this.setContentPane(all);
        this.setVisible(true);
    }

    public void fermer() {
        this.dispose();
    }

}
