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
public class Numeropanier extends JFrame {

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Numeropanier(int nombre, String c) {

	final int nombreok = nombre;
	final String cok = c;
	
        this.setTitle("Numéro Panier");
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
                    Rendupanier rp = new Rendupanier(nombreok, k, cok);
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
                Changementsortant cs = new Changementsortant(0, cok, false);
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

