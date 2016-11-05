package ihm.affichage.panneau;


import java.awt.Color; // Pour la couleur
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension; 

/* ---- Avec bouton ---- */
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/* --------------------- */

public class Fenetre1 extends JFrame {
    private Panneau panneau;
    // Dimension de la fenêtre
    private int X = 800;
    private int Y = 800;


    /* ---- Avec boutonS ---- */
    private JPanel container = new JPanel();
    /* --------------------- */

    public Fenetre1(Panneau panno){
        this.panneau = panno;
	this.setTitle("IHM Basket");
	this.setSize(X, Y);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	/* ---- Avec boutonS ---- */
	final JButton tps = new JButton("Arret chrono");
	tps.setPreferredSize(new Dimension(50, 50));
	tps.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		    panneau.setBool(!panneau.getBool());
		    if (panneau.getBool()) 
			tps.setText("Arret chrono");
		    else if (!panneau.getBool()) 
			tps.setText("Reprise chrono");
		}
	    }
	    );

	container.setBackground(Color.WHITE);
	container.setLayout(new BorderLayout());
	container.add(panneau, BorderLayout.CENTER);
	container.add(tps, BorderLayout.SOUTH);
        
	this.setContentPane(container);
	/* --------------------- */
 
	this.setVisible(true);

	chrono();
    }
    
    public Panneau getPanneau() {
        return this.panneau;
    }
    
    private void chrono() {
        int QT = panneau.getQT();
        int t24;
        int min = 1;
	int sec = 1;
	int cen = 1;
                
	while (QT < 5) {                     
            while (panneau.getChrono().getMinutes() > 0 
                    || panneau.getChrono().getSec() > 0 
                    || panneau.getChrono().getCentieme() > 0) {
                
                t24 = panneau.getChrono().getTempsPossession();
                min = panneau.getChrono().getMinutes();
                sec = panneau.getChrono().getSec();
                cen = panneau.getChrono().getCentieme();
                
		if (panneau.getBool()) {
		    if (cen == 0) {
			cen = 100;
			if (t24 == 0)
			    t24 = 25;
			t24--;
		    
			if (sec == 0) {
			    min = min - 1;
			    sec = 60;
			}
		
			sec--;
			panneau.getChrono().setMin(min);
			panneau.getChrono().setSec(sec);
		    }
		    cen--;
		    panneau.getChrono().setCentieme(cen);
		    panneau.getChrono().setTime(t24);
		    panneau.repaint();
		    try {
			Thread.sleep(10);
		    } catch (InterruptedException e) {
			e.printStackTrace();
		    }
		}
		else {
		    try {
			Thread.sleep(10);
		    } catch (InterruptedException e) {
			e.printStackTrace();
		    }
		}
	    }
	    panneau.getChrono().reinitChrono();
	    QT++;
	    panneau.setQT(QT);
            panneau.getVisiteurs().reinitFautes();
            panneau.getLocaux().reinitFautes();
	}
	panneau.setQT(1);
	panneau.repaint();
    }


    
}
