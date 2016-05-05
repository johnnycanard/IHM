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

    String type;
    int num = 0;

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Couleurfaute(String t, int n) {

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

        JButton bleu = new JButton("BLEU");
        bleu.setBackground(Color.BLUE);
        bleu.setForeground(Color.WHITE);
        bleu.setFont(font);
        bleu.setPreferredSize(new Dimension(X / 2, Y));
        bleu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Rendufaute r = new Rendufaute(type, num, "BLUE");
            }
        });

        JButton rouge = new JButton("ROUGE");
        rouge.setBackground(Color.RED);
        rouge.setForeground(Color.WHITE);
        rouge.setFont(font);
        rouge.setPreferredSize(new Dimension(X / 2, Y));
        rouge.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Rendufaute r = new Rendufaute(type, num, "RED");
            }
        });

        JPanel all = new JPanel();
        all.add(bleu);
        all.add(rouge);

        content.repaint();

        this.setContentPane(all);
        this.setVisible(true);

    }

    public void fermer() {
        this.dispose();
    }

}
