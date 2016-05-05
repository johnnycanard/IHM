
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
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
public class Menu extends JFrame {
    
    private Panneau pann;
    
    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Menu(Panneau panno) {
        
        this.pann = panno;
        
        this.setTitle("MENU");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font font = new Font("Equipe", Font.BOLD, 50);

        // Creation de 6 boutons :
        JButton b1 = new JButton("Base");
        b1.setPreferredSize(new Dimension(X / 3, Y / 2));
        b1.setBackground(Color.WHITE);
        b1.setFont(font);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();                
                Base b = new Base(pann);
            }
        });

        JButton b2 = new JButton("Faute");
        b2.setPreferredSize(new Dimension(X / 3, Y / 2));
        b2.setBackground(Color.WHITE);
        b2.setFont(font);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Rendufaute rf = new Rendufaute("FAUTE", 4, "RED", pann);
            }
        });

        JButton b3 = new JButton("Points");
        b3.setBackground(Color.WHITE);
        b3.setPreferredSize(new Dimension(X / 3, Y / 2));
        b3.setFont(font);
        b3.setForeground(Color.BLACK);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Rendupanier rp = new Rendupanier(0,0, "RED", pann);
            }
        });
       
        JButton b4 = new JButton("Changement");       
        b4.setBackground(Color.WHITE);
        b4.setPreferredSize(new Dimension(X / 3, Y / 2));
        b4.setFont(new Font("Equipe", Font.BOLD, 30));
        b4.setForeground(Color.BLACK);
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Renduchangement rp = new Renduchangement(0,0, "RED", pann);
            }
        });
        
        JButton b5 = new JButton("Chrono");
        b5.setBackground(Color.WHITE);
        b5.setPreferredSize(new Dimension(X / 3, Y / 2));
        b5.setFont(font);
        b5.setForeground(Color.BLACK);
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Modificationchrono mc = new Modificationchrono(pann);
            }
        });
        
        JButton b6 = new JButton("T-M");
        b6.setBackground(Color.WHITE);
        b6.setPreferredSize(new Dimension(X / 3, Y / 2));
        b6.setFont(font);
        b6.setForeground(Color.BLACK);
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Tempsmort tm = new Tempsmort("RED", pann);
            }
        });
        
        JPanel all = new JPanel();
        all.add(b1);
        all.add(b2);
        all.add(b3);
        all.add(b4);
        all.add(b5);
        all.add(b6);
        

        all.setBackground(Color.WHITE);

        content.repaint();
        this.setContentPane(all);
        this.setVisible(true);
    }

    public void fermer() {
        this.dispose();
    }
    
}
