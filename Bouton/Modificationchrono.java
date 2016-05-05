
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
 * @author guillaumehalb
 */
public class Modificationchrono extends JFrame {
    
    private Panneau pann;

    
    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Modificationchrono(Panneau pann) {

        this.pann = pann;
        
        this.setTitle("Modification chrono");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font font = new Font("Equipe", Font.BOLD, 150);
        Font fontMenu = new Font("Equipe", Font.BOLD, 70);

        // Creation des 3 boutons :
        // Moins de temps
        JButton b1 = new JButton("-");
        b1.setPreferredSize(new Dimension(X / 2, Y / 2));
        b1.setBackground(Color.WHITE);
        b1.setFont(font);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Temps --
            }
        });

        // Plus de temps
        JButton b2 = new JButton("+");
        b2.setPreferredSize(new Dimension(X / 2, Y / 2));
        b2.setBackground(Color.WHITE);
        b2.setFont(font);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Temps ++
            }
        });

        // Retour
        JButton base = new JButton("Menu");
        base.setBackground(Color.WHITE);
        base.setPreferredSize(new Dimension(X, Y / 2));
        base.setFont(fontMenu);
        base.setForeground(Color.BLACK);
        base.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Menu maxibestof = new Menu(pann);
            }
        });

        JPanel all = new JPanel();
        all.add(b1);
        all.add(b2);
        all.add(base);
        all.setBackground(Color.WHITE);

        content.repaint();
        this.setContentPane(all);
        this.setVisible(true);
    }

    public void fermer() {
        this.dispose();
    }

}
