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
public class Rendupanier extends JFrame {

    private Panneau pann;
    
    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Rendupanier(int nombre, int n, String c, Panneau pann) {

	final int nok = n;
	final String cok = c;
	final int nombreok = nombre;
	
        this.setTitle("Rendu Panier");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font fontPoint = new Font("Equipe", Font.BOLD, 130);
        Font fontNum = new Font("Equipe", Font.BOLD, 150);
        Font fontCoul = new Font("Equipe", Font.BOLD, 130);

        // Creation des 3 boutons :
        // Type de faute
        JButton f = new JButton(Integer.toString(nombreok) + "pts");
        if (nombreok == 1)
            f.setText(Integer.toString(nombreok) + "pt");
        f.setPreferredSize(new Dimension(X / 2, Y / 2));
        f.setBackground(Color.WHITE);
        f.setFont(fontPoint);
        f.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                if (cok.equals("RED")) {
                    Nombrepoints np = new Nombrepoints(nok, "RED", pann);
                } else {
                    Nombrepoints np = new Nombrepoints(nok, "BLUE", pann);
                }
                
            }
        });

        // Numéro de joueur
        JButton numero = new JButton(Integer.toString(nok));
        numero.setPreferredSize(new Dimension(X / 2, Y / 2));
        numero.setBackground(Color.WHITE);
        numero.setFont(fontNum);
        numero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                if (cok.equals("RED")) {
                    Numeropanier np = new Numeropanier(nombreok, "RED", pann);
                } else {
                    Numeropanier np = new Numeropanier(nombreok, "BLUE", pann);
                }
                
            }
        });

        // Couleur d'équipe
        JButton coul = new JButton(cok);
        if (cok.equals("RED")) {
            coul.setBackground(Color.RED);
        } else {
            coul.setBackground(Color.BLUE);
        }

        coul.setPreferredSize(new Dimension(X, Y / 2));
        coul.setFont(fontCoul);
        coul.setForeground(Color.WHITE);
        coul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fermer();
                Couleurpanier cp = new Couleurpanier(nombreok, nok, pann);
            }
        });

        JPanel all = new JPanel();
        all.add(f);
        all.add(numero);
        all.add(coul);
        all.setBackground(Color.WHITE);

        content.repaint();
        this.setContentPane(all);
        this.setVisible(true);
    }

    public void fermer() {
        this.dispose();
    }

}
