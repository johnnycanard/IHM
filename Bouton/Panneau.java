
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

    private int posX = 0;
    private int posY = 0;

    /* Temps de possession */
//    private int time = 24;
    /* Chronomètre */
//    private int min = 10;
//    private int sec = 0;
//    private int centieme = 0;
    private Chronometre chrono = new Chronometre();

    private boolean chronometre = true;

    public void setBool(boolean b) {
        this.chronometre = b;
    }
    
    public boolean getBool() {
        return chronometre;
    }
    
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
        if (locaux.getCouleur().equals(s)) {
            return locaux;
        } else {
            return visiteurs;
        }
    }

    public int getLoc() {
        return locaux.getPoints();
    }

    public void setLoc(int i) {
        locaux.setPoints(i);
    }

    public int getVis() {
        return visiteurs.getPoints();
    }

    public void setVis(int i) {
        visiteurs.setPoints(i);
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

    public void defLocaux() {
        locaux = new Equipe("ASM", "RED");

        Joueur zidane = new Joueur(10, "Zidane");
        locaux.ajouterJoueur(zidane);
        locaux.ajouterTerrain(zidane);
        Joueur viera = new Joueur(4, "Viera");
        locaux.ajouterJoueur(viera);
        locaux.ajouterTerrain(viera);
        Joueur suba = new Joueur(1, "Subasic");
        locaux.ajouterJoueur(suba);
        locaux.ajouterTerrain(suba);
        Joueur evra = new Joueur(3, "Evra");
        locaux.ajouterJoueur(evra);
        locaux.ajouterTerrain(evra);
        Joueur henry = new Joueur(12, "Henry");
        locaux.ajouterJoueur(henry);
        locaux.ajouterTerrain(henry);

        Joueur paul = new Joueur(20, "Pogba");
        locaux.ajouterJoueur(paul);
        locaux.ajouterBanc(paul);
        Joueur Cassas = new Joueur(21, "Lemar");
        locaux.ajouterJoueur(Cassas);
        locaux.ajouterBanc(Cassas);
        Joueur Pd = new Joueur(22, "Josiane");
        locaux.ajouterJoueur(Pd);
        locaux.ajouterBanc(Pd);
        Joueur tesmorts = new Joueur(23, "Bella");
        locaux.ajouterJoueur(tesmorts);
        locaux.ajouterBanc(tesmorts);
        Joueur maman = new Joueur(24, "Papa");
        locaux.ajouterJoueur(maman);
        locaux.ajouterBanc(maman);

    }

    public void defVisiteurs() {
        visiteurs = new Equipe("OM", "BLUE");

        Joueur olivier = new Joueur(10, "Olivier");
        visiteurs.ajouterJoueur(olivier);
        visiteurs.ajouterTerrain(olivier);
        Joueur jo = new Joueur(4, "Jo");
        visiteurs.ajouterJoueur(jo);
        visiteurs.ajouterTerrain(jo);
        Joueur fifi = new Joueur(1, "Fifi");
        visiteurs.ajouterJoueur(fifi);
        visiteurs.ajouterTerrain(fifi);
        Joueur lee = new Joueur(3, "Lee");
        visiteurs.ajouterJoueur(lee);
        visiteurs.ajouterTerrain(lee);
        Joueur claire = new Joueur(12, "CLAIRE");
        visiteurs.ajouterJoueur(claire);
        visiteurs.ajouterTerrain(claire);

        Joueur Lulu = new Joueur(20, "Lulu");
        visiteurs.ajouterJoueur(Lulu);
        visiteurs.ajouterBanc(Lulu);
        Joueur Cassas = new Joueur(21, "Cassas");
        visiteurs.ajouterJoueur(Cassas);
        visiteurs.ajouterBanc(Cassas);
        Joueur Pd = new Joueur(22, "PD");
        visiteurs.ajouterJoueur(Pd);
        visiteurs.ajouterBanc(Pd);
        Joueur tesmorts = new Joueur(23, "tesmorts");
        visiteurs.ajouterJoueur(tesmorts);
        visiteurs.ajouterBanc(tesmorts);
        Joueur maman = new Joueur(24, "Maman");
        visiteurs.ajouterJoueur(maman);
        visiteurs.ajouterBanc(maman);
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

        /* ---------------------  CHRONOMETRE  ---------------------- */
        if (QT == 1) {
            s = Integer.toString(QT) + "er Quart-Temps";
        } else {
            s = Integer.toString(QT) + "e Quart-Temps";
        }

        font = new Font("Courier", Font.BOLD, 75);
        g.setFont(font);
        g.drawString(s, 65, 50);

        if (this.chrono.getTime() >= 10) {
            s = Integer.toString(this.chrono.getTime());
        } else {
            s = "0" + Integer.toString(this.chrono.getTime());
        }

        g.drawString(s, 352, 150);

        if (this.chrono.getMinutes() == 0) {
            s = Integer.toString(this.chrono.getSec())
                    + ":" + Integer.toString(this.chrono.getCentieme());
        } else if (this.chrono.getMinutes() < 10) {
            if (this.chrono.getSec() >= 10) {
                s = "0" + Integer.toString(this.chrono.getMinutes())
                        + ":" + Integer.toString(this.chrono.getSec());
            } else {
                s = "0" + Integer.toString(this.chrono.getMinutes()) + ":"
                        + "0" + Integer.toString(this.chrono.getSec());
            }
        } else {
            s = Integer.toString(this.chrono.getMinutes()) + ":"
                    + Integer.toString(this.chrono.getSec()) + "0";
        }

        g.drawString(s, 287, 250);


        /* ---------------------  FIN CHRONOMETRE  ---------------------- */
 /* ----------------------------- SCORE ------------------------------ */
        s = "Visiteurs : " + Integer.toString(visiteurs.getPoints());
        font = new Font("Courier", Font.BOLD, 50);
        g.setFont(font);
        g.drawString(s, 8, 350);

        s = "Fautes : " + Integer.toString(visiteurs.getFautes());
        font = new Font("Courier", Font.BOLD, 30);
        g.setFont(font);
        g.drawString(s, 8, 375);

        s = "Locaux : " + Integer.toString(locaux.getPoints());
        font = new Font("Courier", Font.BOLD, 50);
        g.setFont(font);
        g.drawString(s, 450, 350);

        s = "Fautes : " + Integer.toString(locaux.getFautes());
        font = new Font("Courier", Font.BOLD, 30);
        g.setFont(font);
        g.drawString(s, 450, 375);

        /* COMPOSITIONS D'EQUIPE + NbPoint + NbFautes */
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
            g.drawString(s, 420, 400 + 20 * i);
            s = j.getNom();
            g.drawString(s, 465, 400 + 20 * i);
            s = Integer.toString(j.getNbPoints());
            g.drawString(s, 560, 400 + 20 * i);
            s = Integer.toString(j.getFautes());
            g.drawString(s, 600, 400 + 20 * i);
            s = Integer.toString(j.getSportives());
            g.drawString(s, 680, 400 + 20 * i);
            s = Integer.toString(j.getTechniques());
            g.drawString(s, 730, 400 + 20 * i);
        }

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
            g.drawString(s, 20, 400 + 20 * i);
            s = j.getNom();
            g.drawString(s, 65, 400 + 20 * i);
            s = Integer.toString(j.getNbPoints());
            g.drawString(s, 160, 400 + 20 * i);
            s = Integer.toString(j.getFautes());
            g.drawString(s, 200, 400 + 20 * i);
            s = Integer.toString(j.getSportives());
            g.drawString(s, 280, 400 + 20 * i);
            s = Integer.toString(j.getTechniques());
            g.drawString(s, 330, 400 + 20 * i);

        }

        /* ---------------------- FIN PANNEAU AFFICHAGE --------------------- */
    }
}
