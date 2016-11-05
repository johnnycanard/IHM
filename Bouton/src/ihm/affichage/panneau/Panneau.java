package ihm.affichage.panneau;

import ihm.match.Equipe;
import ihm.match.Joueur;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font; // Pour la police d'écriture 

public class Panneau extends JPanel {

    private static int YCOURANT = 0;
    private static int TAILLECOURANTE = 0;
    private static int MARGE = 20;
    private static int ECARTVISITEURSLOCAUX = 440;

    /* Les deux équipes */
    private Equipe locaux;
    private Equipe visiteurs;

    /* Quart-temps en cours */
    private int QT = 1;

    private Chronometre chrono = new Chronometre();
    private boolean chronometre = true;

    public void setBool(boolean b) {
        this.chronometre = b;
    }
    
    public void arretChronometre() {
        this.chronometre = false;
    }
    
    public void lancerChronometre() {
        this.chronometre = true;
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

    public void defLocaux() {
        locaux = new Equipe("Espagne", "WHITE");

        Joueur zidane = new Joueur(4, "Zidane");
        locaux.ajouterJoueur(zidane);
        locaux.ajouterTerrain(zidane);
        Joueur viera = new Joueur(6, "Viera");
        locaux.ajouterJoueur(viera);
        locaux.ajouterTerrain(viera);
        Joueur suba = new Joueur(9, "Subasic");
        locaux.ajouterJoueur(suba);
        locaux.ajouterTerrain(suba);
        Joueur evra = new Joueur(11, "Evra");
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
        locaux.trier();
    }

    public void defVisiteurs() {
        visiteurs = new Equipe("Lituanie", "GREEN");

        Joueur olivier = new Joueur(8, "Olivier");
        visiteurs.ajouterJoueur(olivier);
        visiteurs.ajouterTerrain(olivier);
        Joueur jo = new Joueur(13, "Jo");
        visiteurs.ajouterJoueur(jo);
        visiteurs.ajouterTerrain(jo);
        Joueur fifi = new Joueur(17, "Fifi");
        visiteurs.ajouterJoueur(fifi);
        visiteurs.ajouterTerrain(fifi);
        Joueur lee = new Joueur(19, "Lee");
        visiteurs.ajouterJoueur(lee);
        visiteurs.ajouterTerrain(lee);
        Joueur claire = new Joueur(21, "CLAIRE");
        visiteurs.ajouterJoueur(claire);
        visiteurs.ajouterTerrain(claire);

        Joueur Lulu = new Joueur(20, "Lulu");
        visiteurs.ajouterJoueur(Lulu);
        visiteurs.ajouterBanc(Lulu);
        Joueur Cassas = new Joueur(5, "Cassas");
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
        visiteurs.trier();
    }

    @Override
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

        /* ---------------------  CHRONOMETRE  ---------------------- */
        String quartTemps;
        if (QT == 1) {
            quartTemps = Integer.toString(QT) + "er Quart-Temps";
        } else {
            quartTemps = Integer.toString(QT) + "e Quart-Temps";
        }

        YCOURANT = 50;
        TAILLECOURANTE = 50;
        font = new Font("Courier", Font.BOLD, TAILLECOURANTE);
        g.setFont(font);
        
        MARGE = 125;
        g.drawString(quartTemps, MARGE, YCOURANT);
        YCOURANT += TAILLECOURANTE + 10;
        
        String tempsPossession;
        if (this.chrono.getTempsPossession() >= 10) {
            tempsPossession = Integer.toString(this.chrono.getTempsPossession());
        } else {
            tempsPossession = "0" + Integer.toString(this.chrono.getTempsPossession());
        }
        MARGE = 352;
        g.drawString(tempsPossession, MARGE, YCOURANT);
        YCOURANT += TAILLECOURANTE + 10;
        
        String temps;
        if (this.chrono.getMinutes() == 0) {
            temps = Integer.toString(this.chrono.getSec())
                    + ":" + Integer.toString(this.chrono.getCentieme());
        } else if (this.chrono.getMinutes() < 10) {
            if (this.chrono.getSec() >= 10) {
                temps = "0" + Integer.toString(this.chrono.getMinutes())
                        + ":" + Integer.toString(this.chrono.getSec());
            } else {
                temps = "0" + Integer.toString(this.chrono.getMinutes()) + ":"
                        + "0" + Integer.toString(this.chrono.getSec());
            }
        } else {
            temps = Integer.toString(this.chrono.getMinutes()) + ":"
                    + Integer.toString(this.chrono.getSec()) + "0";
        }
        MARGE = 287;
        g.drawString(temps, MARGE, YCOURANT);
        YCOURANT += TAILLECOURANTE + 10;


        /* ---------------------  FIN CHRONOMETRE  ---------------------- */
        /* ---------------------       SCORE       ---------------------- */
        MARGE = 20;
        drawScore(g);
        drawTempsMorts(g);
        drawFautes(g);
        drawCompositionEquipes(g);

        /* ---------------------- FIN PANNEAU AFFICHAGE --------------------- */
    }
    
    public void drawCompositionEquipes(Graphics graphic) {
        TAILLECOURANTE = 20;
        Font font = new Font("Courier", Font.BOLD, TAILLECOURANTE);
        graphic.setFont(font);

        String statistiquesJoueur = "Num";
        graphic.drawString(statistiquesJoueur, MARGE, YCOURANT);
        graphic.drawString(statistiquesJoueur, MARGE + ECARTVISITEURSLOCAUX, YCOURANT);
        statistiquesJoueur = "Points";
        graphic.drawString(statistiquesJoueur, MARGE + 80, YCOURANT);
        graphic.drawString(statistiquesJoueur, MARGE + 80 + ECARTVISITEURSLOCAUX, YCOURANT);
        statistiquesJoueur = "Fautes";
        graphic.drawString(statistiquesJoueur, MARGE + 180, YCOURANT);
        graphic.drawString(statistiquesJoueur, MARGE + 180 + ECARTVISITEURSLOCAUX, YCOURANT);
        YCOURANT += TAILLECOURANTE + 5;
        
        graphic.drawString("Terrain", MARGE, YCOURANT);
        graphic.drawString("Terrain", MARGE + ECARTVISITEURSLOCAUX, YCOURANT);
        YCOURANT += TAILLECOURANTE + 5;

        for (Joueur joueur : visiteurs.getTerrain()) {
            statistiquesJoueur = Integer.toString(joueur.getNum());
            graphic.drawString(statistiquesJoueur, MARGE, YCOURANT);
            statistiquesJoueur = Integer.toString(joueur.getNbPoints());
            graphic.drawString(statistiquesJoueur, MARGE + 80, YCOURANT);
            statistiquesJoueur = Integer.toString(joueur.getTotalFautes());
            graphic.drawString(statistiquesJoueur, MARGE + 180, YCOURANT);
            YCOURANT += TAILLECOURANTE + 5;
        }
        YCOURANT -= (TAILLECOURANTE + 5)*visiteurs.getTerrain().size();

        for (Joueur joueur : locaux.getTerrain()) {
        statistiquesJoueur = Integer.toString(joueur.getNum());
            graphic.drawString(statistiquesJoueur, MARGE + ECARTVISITEURSLOCAUX, YCOURANT);
            statistiquesJoueur = Integer.toString(joueur.getNbPoints());
            graphic.drawString(statistiquesJoueur, MARGE + 80 + ECARTVISITEURSLOCAUX, YCOURANT);
            statistiquesJoueur = Integer.toString(joueur.getTotalFautes());
            graphic.drawString(statistiquesJoueur, MARGE + 180 + ECARTVISITEURSLOCAUX, YCOURANT);
            YCOURANT += TAILLECOURANTE + 5;
        }
        
        graphic.drawString("Banc", MARGE, YCOURANT);
        graphic.drawString("Banc", MARGE + ECARTVISITEURSLOCAUX, YCOURANT);
        YCOURANT += TAILLECOURANTE + 5;
        
        for (Joueur joueur : locaux.getBanc()) {
            statistiquesJoueur = Integer.toString(joueur.getNum());
            graphic.drawString(statistiquesJoueur, MARGE + ECARTVISITEURSLOCAUX, YCOURANT);
            statistiquesJoueur = Integer.toString(joueur.getNbPoints());
            graphic.drawString(statistiquesJoueur, MARGE + 80 + ECARTVISITEURSLOCAUX, YCOURANT);
            statistiquesJoueur = Integer.toString(joueur.getTotalFautes());
            graphic.drawString(statistiquesJoueur, MARGE + 180 + ECARTVISITEURSLOCAUX, YCOURANT);
            YCOURANT += TAILLECOURANTE + 5;
        }
        YCOURANT -= (TAILLECOURANTE + 5)*locaux.getBanc().size();

        for (Joueur joueur : visiteurs.getBanc()) {
            statistiquesJoueur = Integer.toString(joueur.getNum());
            graphic.drawString(statistiquesJoueur, MARGE, YCOURANT);
            statistiquesJoueur = Integer.toString(joueur.getNbPoints());
            graphic.drawString(statistiquesJoueur, MARGE + 80, YCOURANT);
            statistiquesJoueur = Integer.toString(joueur.getTotalFautes());
            graphic.drawString(statistiquesJoueur, MARGE + 180, YCOURANT);
            YCOURANT += TAILLECOURANTE + 5;
        }
    }
    
    public void drawFautes(Graphics graphic) {
        TAILLECOURANTE = 30;
        Font font = new Font("Courier", Font.BOLD, TAILLECOURANTE);
        graphic.setFont(font);
        String fautesVisiteurs = "Fautes : " + Integer.toString(visiteurs.getFautes());
        graphic.drawString(fautesVisiteurs, MARGE, YCOURANT);
        String fautesLocaux = "Fautes : " + Integer.toString(locaux.getFautes());
        graphic.drawString(fautesLocaux, MARGE + ECARTVISITEURSLOCAUX, YCOURANT);
        YCOURANT += TAILLECOURANTE + 5;

    }
    
    public void drawTempsMorts(Graphics graphic) {
        TAILLECOURANTE = 30;
        Font font = new Font("Courier", Font.BOLD, TAILLECOURANTE);
        graphic.setFont(font);
        String tempsMortsVisiteurs = "temps-morts : " + Integer.toString(visiteurs.getNbTM());
        graphic.drawString(tempsMortsVisiteurs, MARGE, YCOURANT);                
        String tempsMortsLocaux = "temps-mort : " + Integer.toString(locaux.getNbTM());
        graphic.drawString(tempsMortsLocaux, MARGE + ECARTVISITEURSLOCAUX, YCOURANT);
        YCOURANT += TAILLECOURANTE + 5;
    }
    
    public void drawScore(Graphics graphic) {
        TAILLECOURANTE = 30;
        Font font = new Font("Courier", Font.BOLD, TAILLECOURANTE);
        graphic.setFont(font);
        String pointsVisiteurs = visiteurs.getNom() + " : " + Integer.toString(visiteurs.getPoints());
        graphic.drawString(pointsVisiteurs, MARGE, YCOURANT);        
        String pointsLocaux = locaux.getNom() + " : " + Integer.toString(locaux.getPoints());
        graphic.drawString(pointsLocaux, MARGE + ECARTVISITEURSLOCAUX, YCOURANT);
        YCOURANT += TAILLECOURANTE + 5;
    }
}
