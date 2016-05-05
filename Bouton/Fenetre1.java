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
    //private boolean chrono = true;
    private JPanel container = new JPanel();
    /* --------------------- */

    public Fenetre1(Panneau panno){
        this.pann = panno;
	this.setTitle("IHM Basket");
	this.setSize(X + 100, Y + 50);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	/* ---- Avec boutonS ---- */
	final JButton tps = new JButton("Arret chrono");
	tps.setPreferredSize(new Dimension(50, 50));
	tps.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		    pann.setBool(!pann.getBool());
		    if (pann.getBool()) 
			tps.setText("Arret chrono");
		    else if (!pann.getBool()) 
			tps.setText("Reprise chrono");
		}
	    }
	    );

	container.setBackground(Color.WHITE);
	container.setLayout(new BorderLayout());
	container.add(pann, BorderLayout.CENTER);
	container.add(tps, BorderLayout.SOUTH);
        
	this.setContentPane(container);
	/* --------------------- */
 
	this.setVisible(true);

        pann.defLocaux();
        pann.defVisiteurs();
        /*
        if (pann.getVisiteurs() == null)
            System.out.println("mauvaise initialisation");
        */
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
                
		if (pann.getBool()) {
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
            pann.getVisiteurs().reinitFautes();
            pann.getLocaux().reinitFautes();
	}
	pann.setQT(1);
	pann.repaint();
    }


    
}
