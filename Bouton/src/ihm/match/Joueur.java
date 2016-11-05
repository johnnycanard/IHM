/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.match;

import java.util.Comparator;

/**
 *
 * @author guillaumehalb
 */
public class Joueur implements Comparator<Joueur>, Comparable<Joueur>{

    private int nb1point;
    private int nb2points;
    private int nb3points;
    private int nbfautes;
    private int nbtechniques;
    private int nbsportives;
    private int totalFautes;
    private int num;
    private String nom;

    public Joueur(int i, String s) {
        this.nb1point = 0;
        this.nb2points = 0;
        this.nb3points = 0;
        this.nbfautes = 0;
        this.nbtechniques = 0;
        this.nbsportives = 0;
        this.num = i;
        this.nom = s;
        this.totalFautes = 0;
    }
    
    public int getTotalFautes() {
        return this.totalFautes;
    }

    public String getNom() {
        return this.nom;
    }

    public int getNum() {
        return this.num;
    }

    public int getNbPoints() {
        return nb1point + 2 * nb2points + 3 * nb3points;
    }

    public int getNb1Point() {
        return this.nb1point;
    }
    
    public void incr1Point() {
        this.nb1point++;
    }
    
    public void decr1Point() {
        this.nb1point--;
    }
    
    public void incr2Points() {
        this.nb2points++;
    }
    
    public void decr2Points() {
        this.nb2points--;
    }

    public void incr3Points() {
        this.nb3points++;
    }
  
    public void decr3Points() {
        this.nb3points--;
    }    
    
    public int getNb2Points() {
        return this.nb2points;
    }

    public int getNb3Points() {
        return this.nb3points;
    }

    public int getFautes() {
        return this.nbfautes;
    }

    public boolean incrFautes() {
        this.nbfautes++;
        this.totalFautes++;
        if (this.totalFautes >= 5) {
            return true;
            // Afficher num + background coul + "5 FAUTES"
        } else {
            return false;
        }
    }
    
    public boolean decrFautes() {
        this.nbfautes--;
        this.totalFautes--;
        if (this.totalFautes >= 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean incrTech() {
        this.nbtechniques++;
        this.totalFautes++;
        if (this.totalFautes >= 5) {
            return true;
            // Afficher num + background coul + "5 FAUTES"
        } else {
            return false;
        }
    }

    public boolean decrTech() {
        this.nbtechniques--;
        this.totalFautes--;
        if (this.totalFautes >= 5) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean incrSport() {
        this.nbsportives++;
        this.totalFautes++;
        if (this.totalFautes >= 5) {
            return true;
            // Afficher num + background coul + "5 FAUTES"
        } else {
            return false;
        }
    }
    
    public boolean decrSport() {
        this.nbsportives--;
        this.totalFautes--;
        if (this.totalFautes >= 5) {
            return true;
            // Afficher num + background coul + "5 FAUTES"
        } else {
            return false;
        }
    }
    

    public int getTechniques() {
        return this.nbtechniques;
    }

    public int getSportives() {
        return this.nbsportives;
    }

    @Override
    public String toString() {
        return Integer.toString(this.num) + " " + this.nom + " "
                + Integer.toString(this.getNbPoints()) + " "
                + Integer.toString(this.totalFautes);
    }

    public boolean equals(Joueur j) {
        if (this.nom.equals(j.getNom()) && this.num == j.getNum()) {
            return true;
        }
        return false;
    }
    
    @Override
    public int compare(Joueur j1, Joueur j2) {
        return j1.getNum() - j2.getNum();
    }

    @Override
    public int compareTo(Joueur j) {
        return this.getNum() - j.getNum();
    }

}
