import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
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
 * @author guillaumehalb
 */
public class Tempsmort extends JFrame {
 
        private Panneau pann;
    
    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Tempsmort(String c, Panneau panno) {

        this.pann = panno;
        
        this.setTitle("Temps-Mort");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font font = new Font("Equipe", Font.BOLD, 100);

        // Moins de temps
        JButton b1 = new JButton("<html>Temps-Mort<br>         " + c + "</html>");
        b1.setPreferredSize(new Dimension(X, Y-20));
        b1.setForeground(Color.WHITE);
        if (c.equals("RED")) {
            b1.setBackground(Color.RED);
            b1.setText("<html>Temps-Mort<br> Rouge </html>");
        } else if (c.equals("BLUE")) {
            b1.setBackground(Color.BLUE);
            b1.setText("<html>Temps-Mort<br> BLEU </html>");
        } else if (c.equals("GREEN")) {
            b1.setBackground(Color.GREEN);
            b1.setText("<html>Temps-Mort<br> VERT </html>");
        } else if (c.equals("WHITE")) {
            b1.setBackground(Color.WHITE);
            b1.setText("<html>Temps-Mort<br> BLANC </html>");
            b1.setForeground(Color.BLACK);
        } 
        b1.setFont(font);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Couleurtm ctm = new Couleurtm(pann); 
                pann.repaint();
            }
        });
	JButton retour = new JButton("R");
        retour.setPreferredSize(new Dimension(X , 3));
        retour.setBackground(Color.WHITE);
        retour.setFont(font);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Temps = 24
		fermer();
		Menu m = new Menu(pann);
                pann.repaint();
            }
        });
        
        JPanel all = new JPanel();
        all.add(b1);
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
