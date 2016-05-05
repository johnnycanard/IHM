
import java.awt.Color;
import java.util.LinkedList;

import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guillaumehalb
 */
public class Equipe {
    private int points;
    private int fautes;
    private String couleur;
    private LinkedList<Joueur> team;
    private String nom = new String();
    private LinkedList<Joueur> terrain;
    private LinkedList<Joueur> banc;
    private int nbTM;

    public Equipe(String n, String c) {
	this.nom = n;
	this.couleur = c;
	this.points = 0;
	this.fautes = 0;
	this.team = new LinkedList<Joueur>();
        this.terrain = new LinkedList<Joueur>();
        this.banc = new LinkedList<Joueur>();
        this.nbTM = 0;
    }

    public void incrFautes() {
        this.fautes++;
    }
    
    public void decrFautes() {
        this.fautes--;
    }
    
    public void reinitFautes() {
        this.fautes = 0;
    }
    
    public void ajouterJoueur(Joueur j) {
	// Vérifier que deux joueur n'ait pas le même numéro :
	for (Joueur j1 : team) {
	    if (j1.equals(j)) {
		System.out.println(j.getNom() + " (numéro " + j.getNum() 
				    +") déjà ajouté à l'équipe");
		System.exit(0);
	    }
	    else if (j1.getNum() == j.getNum()) {
		System.out.println(j1.getNom() + " porte déjà le numéro " 
				    + j1.getNum());
		System.exit(0);
	    }
	    
	}
	team.add(j);		
    }
    
    public void comptePoints() {
        int tot = 0;
        for (Joueur j1 : team) {
            tot += j1.getNbPoints();
        }
        this.points = tot;
    }
    
    public void changement(Joueur in, Joueur out) {
        terrain.remove(out);
        banc.remove(in);
        terrain.add(in);
        banc.add(out);
    }
        
    public void ajouterTerrain(Joueur j) {
	// Vérifier que deux joueur n'ait pas le même numéro :
	for (Joueur j1 : terrain) {
	    if (j1.equals(j)) {
		System.out.println(j.getNom() + " (numéro " + j.getNum() 
				    +") déjà sur le terrain");
		System.exit(0);
	    }
	    else if (j1.getNum() == j.getNum()) {
		System.out.println(j1.getNom() + " porte déjà le numéro " 
				    + j1.getNum());
		System.exit(0);
	    }
	    
	}
	terrain.add(j);		
    }
    
    public void ajouterBanc(Joueur j) {
	// Vérifier que deux joueur n'ait pas le même numéro :
	for (Joueur j1 : banc) {
	    if (j1.equals(j)) {
		System.out.println(j.getNom() + " (numéro " + j.getNum() 
				    +") déjà sur le banc");
		System.exit(0);
	    }
	    else if (j1.getNum() == j.getNum()) {
		System.out.println(j1.getNom() + " porte déjà le numéro " 
				    + j1.getNum());
		System.exit(0);
	    }
	    
	}
	banc.add(j);		
    }
    
    public Joueur getJoueur(int n) {
        for (Joueur j1 : team) {
            if (j1.getNum() == n)
                return j1;
        }
        System.out.println("Joueur numéro " + Integer.toString(n) 
                + "pas sur le terrain");
	return null;    
    }
    
    public LinkedList<Joueur> getTerrain() {
        return this.terrain;
    }

    public LinkedList<Joueur> getBanc() {
        return this.banc;
    }
    
    public int getPoints() {
	return this.points;
    }

    public int getFautes() {
	return this.fautes;
    }

    public String getCouleur() {
	return this.couleur;
    }

    public String getNom() {
	return this.nom;
    }

    public LinkedList<Joueur> getTeam() {
	return this.team;
    }

    public void setPoints(int i) {
	this.points = i;
    }

    /* Retourne true si 5 fautes d'équipes */
    public boolean setFautes(int i) {
	this.fautes = i;
	if (i == 5)
	    return true;
	return false;
    }

    public String toString() {
	String s = new String();
	for (Joueur j : team)
	    s += j.toString();
	return s;
    }
}
