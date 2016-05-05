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

public class Nombrepoints extends JFrame {

    private JPanel content = new JPanel();
    private int X = 700;
    private int Y = 500;

    public Nombrepoints(int n, String c) {

	final String cok = c;
	final int nok = n;
	
        this.setTitle("Nombre Points");
        this.setSize(X + 20, Y + 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            System.out.println("Problème d'affichage");
        }

        Font fontNum = new Font("Numero", Font.BOLD, 150);

        JButton pt1 = new JButton("1");
        pt1.setBackground(Color.white);
        pt1.setPreferredSize(new Dimension(X / 2, Y / 2));
        pt1.setFont(fontNum);
        pt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                    fermer();
                    Rendupanier rp = new Rendupanier(1, nok, cok);
            }
        });
        
        JButton pt2 = new JButton("2");
        pt2.setBackground(Color.white);
        pt2.setPreferredSize(new Dimension(X / 2, Y / 2));
        pt2.setFont(fontNum);
        pt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                    fermer();
                    Rendupanier rp = new Rendupanier(2, nok, cok);
            }
        });
        
        JButton pt3 = new JButton("3");
        pt3.setBackground(Color.white);
        pt3.setPreferredSize(new Dimension(X / 2, Y / 2));
        pt3.setFont(fontNum);
        pt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                    fermer();
                    Rendupanier rp = new Rendupanier(3, nok, cok);
            }
        });
        
        JButton refuser = new JButton("REFUSER");
        refuser.setBackground(Color.white);
        refuser.setPreferredSize(new Dimension(X / 2, Y / 2));
        refuser.setFont(new Font("Numero", Font.BOLD, 70));
        refuser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                    fermer();
                    Base b = new Base();
            }
        });

        JPanel all = new JPanel();
        all.add(pt1);
        all.add(pt2);
        all.add(pt3);
        all.add(refuser);

        content.repaint();

        this.setContentPane(all);
        this.setVisible(true);
    }

    public void fermer() {
        this.dispose();
    }

}
