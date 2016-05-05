import java.awt.Graphics2D;
import java.awt.Color; 
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font; // Pour la police d'écriture 
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.GradientPaint;

public class Panneau extends JPanel { 

    /* Les deux équipes */
    private Equipe locaux;
    private Equipe visiteurs;

    /* Quart-temps en cours */
    private int QT = 1;

    /* Points des équipes */
    private int vis = 0;
    private int loc = 0;

    private int posX = 0;
    private int posY = 0;

    
    /* Temps de possession */ 
//    private int time = 24;
    
    /* Chronomètre */
//    private int min = 10;
//    private int sec = 0;
//    private int centieme = 0;
    
    private Chronometre chrono = new Chronometre();
    
    public Chronometre getChrono() {
        return this.chrono;
    }
    
    public Equipe getLocaux() {
	return locaux;
    }

    public Equipe getVisiteurs() {
	return visiteurs;
    }

    public Equipe getEquipe(String s) {
    if (locaux.getCouleur().equals(s))
        return locaux;
    else
        return visiteurs;
    }
    
    /*
    public void reinitChrono() {
	this.min = 10;
	this.sec = 0;
	this.centieme = 0;
	this.time = 24;
    }

    public void reinit24() {
	this.time = 24;
    }
    
    
    public int getCentieme() {
	return this.centieme;
    }

    public void setCentieme(int i) {
	this.centieme = i;
    }

    public int getMin() {
	return this.min;
    }

    public void setMin(int i) {
	this.min = i;
    }

    public int getSec() {
	return this.sec;
    }

    public void setSec(int i) {
	this.sec = i;
    }

    public int getTime() {
	return this.time;
    }

    public void setTime(int tim) {
	this.time = tim;
    }
    */
    
    public int getLoc() {
	return this.loc;
    }

    public void setLoc(int i) {
	this.loc = i;
    }

    public int getVis() {
	return this.vis;
    }

    public void setVis(int i) {
	this.vis = i;
    }

    public int getQT() {
	return this.QT;
    }

    public void setQT(int i) {
	this.QT = i;
    }

    public int getPosX() {
	return this.posX;
    }

    public void setPosX(int posX) {
	this.posX = posX;
    }

    public int getPosY() {
	return this.posY;
    }

    public void setPosY(int posY) {
	this.posY = posY;
    }     
   
    public void paintComponent(Graphics g) {
	// Hauteur et largeur de l'image
	int x = this.getWidth();
	int y = this.getHeight();

	/* FOND D'ECRAN */

	// Pour rectangle : x, y, longX, longY
	g.setColor(Color.WHITE);
	g.fillRect(0, 0, 400, 800);
	g.setColor(Color.WHITE);
	g.fillRect(400, 0, 400, 800);

	/* ---------------------  PANNEAU D'AFFICHAGE  ---------------------- */
	
	// Pour les String
	Font font = new Font("Courier", Font.BOLD, 100);
	g.setFont(font);
	g.setColor(Color.BLACK);
	String s = new String();

	if (QT == 1)
	    s = Integer.toString(QT) + "er Quart-Temps";
	else
	    s = Integer.toString(QT) + "e Quart-Temps";
	
	font = new Font("Courier", Font.BOLD, 75);
	g.setFont(font);
	g.drawString(s, 65, 50);

	if (this.chrono.getTime() >= 10)
	    s = Integer.toString(this.chrono.getTime());
	else
	    s = "0" + Integer.toString(this.chrono.getTime());
	g.drawString(s, 352, 150);

	if (this.chrono.getMinutes() == 0)
	    s = Integer.toString(this.chrono.getSec()) 
                    + ":" + Integer.toString(this.chrono.getCentieme());
	else
	    if (this.chrono.getMinutes() < 10)
		if (this.chrono.getSec() >= 10)
		    s = "0" + Integer.toString(this.chrono.getMinutes()) 
                            + ":" + Integer.toString(this.chrono.getSec());
		else
		    s = "0" + Integer.toString(this.chrono.getMinutes()) + ":" 
                            + "0" + Integer.toString(this.chrono.getSec());
	    else
		s = Integer.toString(this.chrono.getMinutes()) + ":" 
                        + Integer.toString(this.chrono.getSec()) + "0";
	
	g.drawString(s, 287, 250);

	/* ----------------------------- SCORE ------------------------------ */
	
	s = "Visiteurs : " + Integer.toString(this.vis);
	font = new Font("Courier", Font.BOLD, 50);
	g.setFont(font);
	g.drawString(s, 8, 350);

	s = "Locaux : " + Integer.toString(this.loc);
	g.drawString(s, 450, 350);

	/* COMPOSITIONS D'EQUIPE + NbPoint + NbFautes */

	locaux = new Equipe("ASM", "RED");	
	Joueur zidane = new Joueur(10, "Zidane");
	locaux.ajouterJoueur(zidane);
	Joueur viera = new Joueur(4, "Viera");
	locaux.ajouterJoueur(viera);
	Joueur suba = new Joueur(1, "Subasic");
	locaux.ajouterJoueur(suba);
	Joueur evra = new Joueur(3, "Evra");
	locaux.ajouterJoueur(evra);
	Joueur henry = new Joueur(12, "Henry");
	locaux.ajouterJoueur(henry);


	font = new Font("Courier", Font.BOLD, 20);
	g.setFont(font);

	s = "Num";
	g.drawString(s, 420, 400);
	s = "Nom";
	g.drawString(s, 485, 400);
	s = "Pts";
	g.drawString(s, 540, 400);
	s = "Fte";
	g.drawString(s, 585, 400);
	s = "Sport";
	g.drawString(s, 630, 400);
	s = "Tech";
	g.drawString(s, 700, 400);

	int i = 0;
	for (Joueur j : locaux.getTeam()) {
	    i++;
	    s = Integer.toString(j.getNum());  
	    g.drawString(s, 420, 400 + 20*i);
	    s = j.getNom();  
	    g.drawString(s, 465, 400 + 20*i);
	    s = Integer.toString(j.getNbPoints());  
	    g.drawString(s, 560, 400 + 20*i);
	    s = Integer.toString(j.getFautes());  
	    g.drawString(s, 600, 400 + 20*i);
	    s = Integer.toString(j.getSportives());
	    g.drawString(s, 680, 400 + 20*i);
	    s = Integer.toString(j.getTechniques());
	    g.drawString(s, 730, 400 + 20*i);
	}

	visiteurs = new Equipe("OM", "BLUE");
	Joueur olivier = new Joueur(10, "Olivier");
	visiteurs.ajouterJoueur(olivier);
	Joueur jo = new Joueur(4, "Jo");
	visiteurs.ajouterJoueur(jo);
	Joueur fifi = new Joueur(1, "Fifi");
	visiteurs.ajouterJoueur(fifi);
	Joueur lee = new Joueur(3, "Lee");
	visiteurs.ajouterJoueur(lee);
	Joueur claire = new Joueur(12, "CLAIRE");
	visiteurs.ajouterJoueur(claire);

	s = "Num";
	g.drawString(s, 20, 400);
	s = "Nom";
	g.drawString(s, 85, 400);
	s = "Pts";
	g.drawString(s, 140, 400);
	s = "Fte";
	g.drawString(s, 185, 400);
	s = "Sport";
	g.drawString(s, 230, 400);
	s = "Tech";
	g.drawString(s, 300, 400);

	i = 0;
	for (Joueur j : visiteurs.getTeam()) {
	    i++;
	    s = Integer.toString(j.getNum());  
	    g.drawString(s, 20, 400 + 20*i);
	    s = j.getNom();  
	    g.drawString(s, 65, 400 + 20*i);
	    s = Integer.toString(j.getNbPoints());  
	    g.drawString(s, 160, 400 + 20*i);
	    s = Integer.toString(j.getFautes());  
	    g.drawString(s, 200, 400 + 20*i);
	    s = Integer.toString(j.getSportives());
	    g.drawString(s, 280, 400 + 20*i);
	    s = Integer.toString(j.getTechniques());
	    g.drawString(s, 330, 400 + 20*i);

	}
	
	/* ---------------------- FIN PANNEAU AFFICHAGE --------------------- */
    }               
}
