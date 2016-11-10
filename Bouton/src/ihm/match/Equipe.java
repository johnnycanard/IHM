package ihm.match;

import java.util.Collections;
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
    private int fautesEntraineur;
    
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
    
    public int getNbTM() {
        return nbTM;
    }

    // Verifier le nombre de temps mort maximal
    public void incrNbTM() {
        nbTM++;
    }
    
    public void decrNbTM() throws Exception {
        if (nbTM > 0) {
            nbTM--;
        } else {
            throw new Exception("Nombre de temps mort ne peux pas être négatif:" + nbTM);
        }
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
                        + ") déjà ajouté à l'équipe");
                System.exit(0);
            } else if (j1.getNum() == j.getNum()) {
                System.out.println(j1.getNom() + " porte déjà le numéro "
                        + j1.getNum());
                System.exit(0);
            }
        }
        team.add(j);
    }

    public boolean surTerrain(Joueur j) {
        for (Joueur j1 : terrain) {
            if (j1.equals(j)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean surTerrain(int numero) {
        for (Joueur joueur : terrain) {
            if (joueur.getNum() == numero) {
                return true;
            }
        }
        return false;
    }
    
    public boolean dansEquipe(int numero) {
        for (Joueur joueur : team) {
            if (joueur.getNum() == numero) {
                return true;
            }
        }
        return false;
    }

    public boolean surBanc(Joueur j) {
        for (Joueur j1 : banc) {
            if (j1.equals(j)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean surBanc(int numero) {
        for (Joueur joueur : banc) {
            if (joueur.getNum() == numero) {
                return true;
            }
        }
        return false;
    }

    public void comptePoints() {
        int tot = 0;
        for (Joueur j1 : team) {
            tot += j1.getNbPoints();
        }
        this.points = tot;
    }

    public void changement(Joueur in, Joueur out) {
        if (surTerrain(out) && surBanc(in)) {
            terrain.remove(out);
            banc.remove(in);
            terrain.add(in);
            banc.add(out);
            trier();
        }
    }
    
    public void trier() {
        Collections.sort(banc);
        Collections.sort(terrain);
    }

    public void annulerChangement(Joueur in, Joueur out) {
        if (surTerrain(in) && surBanc(out)) {
            terrain.remove(in);
            banc.remove(out);
            terrain.add(out);
            banc.add(in);
        }
    }

    public void ajouterTerrain(Joueur joueur) {
        // Vérifier que deux joueurs n'aient pas le même numéro :
        for (Joueur joueurTerrain : terrain) {
            if (joueurTerrain.equals(joueur)) {
                System.out.println(joueur.getNom() + " (numéro " + joueur.getNum()
                        + ") déjà sur le terrain");
                System.exit(0);
            } else if (joueurTerrain.getNum() == joueur.getNum()) {
                System.out.println(joueurTerrain.getNom() + " porte déjà le numéro "
                        + joueurTerrain.getNum());
                System.exit(0);
            }

        }
        terrain.add(joueur);
    }

    // TODO: Générer des exceptions
    public void ajouterBanc(Joueur joueur) {
        // Vérifier que deux joueur n'ait pas le même numéro :
        for (Joueur joueurBanc : banc) {
            if (joueurBanc.equals(joueur)) {
                System.out.println(joueur.getNom() + " (numéro " + joueur.getNum()
                        + ") déjà sur le banc");
                System.exit(0);
            } else if (joueurBanc.getNum() == joueur.getNum()) {
                System.out.println(joueurBanc.getNom() + " porte déjà le numéro "
                        + joueurBanc.getNum());
                System.exit(0);
            }
        }
        banc.add(joueur);
    }

    public Joueur getJoueurEquipe(int n) throws Exception{
        for (Joueur j1 : team) {
            if (j1.getNum() == n) {
                return j1;
            }
        }
        throw new Exception(n + " " + this.couleur + " pas dans l'équipe");
    }
    
    public Joueur getJoueurTerrain(int n) throws Exception{
        for (Joueur j1 : terrain) {
            if (j1.getNum() == n) {
                return j1;
            }
        }
        System.out.println("Joueur " + couleur + " sur le terrain");
        for (Joueur joueurTerrain : getTerrain()) {
            System.out.println(joueurTerrain.getNum());
        }
        throw new Exception(n + " " + this.couleur + " pas sur le terrain");
    }

    public Joueur getJoueurBanc(int n) throws Exception{
        for (Joueur j1 : banc) {
            if (j1.getNum() == n) {
                return j1;
            }
        }
        throw new Exception(n + " " + this.couleur + " pas sur le banc");
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
        if (i == 5) {
            return true;
        }
        return false;
    }
    
    public void incrFautesEntraineur() {
        fautesEntraineur++;
    }

    public String toString() {
        String s = new String();
        for (Joueur j : team) {
            s += j.toString();
        }
        return s;
    }
}
