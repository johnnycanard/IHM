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
 
    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Tempsmort(String c) {

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
        b1.setPreferredSize(new Dimension(X, Y));
        if (c.equals("RED")) {
            b1.setBackground(Color.RED);
            b1.setText("<html>Temps-Mort<br>      Rouge </html>");
        }
        else {
            b1.setBackground(Color.BLUE);
            b1.setText("<html>Temps-Mort<br>         BLEU </html>");
        }
        b1.setForeground(Color.WHITE);
        b1.setFont(font);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Couleurtm ctm = new Couleurtm(); 
            }
        });
        
        JPanel all = new JPanel();
        all.add(b1);
        all.setBackground(Color.WHITE);

        content.repaint();
        this.setContentPane(all);
        this.setVisible(true);
    }

    public void fermer() {
        this.dispose();
    }    
}
