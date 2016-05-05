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

    private Panneau pann;
    // Dimension de la fenêtre
    private int X = 800;
    private int Y = 800;


    /* ---- Avec boutonS ---- */
    private boolean chrono = true;
    private JPanel container = new JPanel();
    /* --------------------- */

    public Fenetre1(Panneau pann){
        this.pann = pann;
	this.setTitle("IHM Basket");
	this.setSize(X + 100, Y + 50);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	/* ---- Avec boutonS ---- */
	final JButton tps = new JButton("Arret chrono");
	tps.setPreferredSize(new Dimension(50, 50));
	tps.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		    chrono = !chrono;
		    if (chrono) 
			tps.setText("Arret chrono");
		    else if (!chrono) 
			tps.setText("Reprise chrono");
		}
	    }
	    );

	JButton t24 = new JButton("24");
	t24.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		    pann.getChrono().setTime(24);
		}
	    }
	    );

	JButton t14 = new JButton("14");
	t14.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		    if (pann.getChrono().getTime() <= 14)
			pann.getChrono().setTime(14);
		}
	    }
	    );	

	container.setBackground(Color.WHITE);
	container.setLayout(new BorderLayout());
	container.add(pann, BorderLayout.CENTER);
	container.add(tps, BorderLayout.SOUTH);
	container.add(t24, BorderLayout.EAST);
	container.add(t14, BorderLayout.WEST);
	this.setContentPane(container);
	/* --------------------- */
 
	this.setVisible(true);

	chrono();
    }
    
    public Panneau getPanneau() {
        return this.pann;
    }
    
    private void chrono() {
int QT = pann.getQT();
        int t24;
        int min = 1;
	int sec = 1;
	int cen = 1;
                
	while (QT < 5) {         
            System.out.println("Nouveau QT");
            
            while (pann.getChrono().getMinutes() > 0 
                    || pann.getChrono().getSec() > 0 
                    || pann.getChrono().getCentieme() > 0) {
                t24 = pann.getChrono().getTime();
                min = pann.getChrono().getMinutes();
                sec = pann.getChrono().getSec();
                cen = pann.getChrono().getCentieme();
		if (chrono) {
		    if (cen == 0) {
			cen = 100;
			if (t24 == 1)
			    t24 = 25;
			t24--;
		    
			if (sec == 0) {
			    min = min - 1;
			    sec = 60;
			}
		
			sec--;
			pann.getChrono().setMin(min);
			pann.getChrono().setSec(sec);
		    }
		    cen--;
		    pann.getChrono().setCentieme(cen);
		    pann.getChrono().setTime(t24);
		    pann.repaint();
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
	    pann.getChrono().reinitChrono();
	    QT++;
	    pann.setQT(QT);
	}
	pann.setQT(1);
	pann.repaint();
    }


    
}
