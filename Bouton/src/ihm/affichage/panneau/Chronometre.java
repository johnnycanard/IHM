/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.affichage.panneau;

/**
 *
 * @author guillaumehalb
 */
public class Chronometre {

    private int min = 10;
    private int sec = 0;
    private int centieme = 0;

    /* Temps de possession */ 
    private int tempsPossession = 24;
    
    public Chronometre() {
        this.min = 10;
        this.sec = 0;
        this.centieme = 0;
        this.tempsPossession = 24;
    }

    public int getTempsPossession() {
        return this.tempsPossession;
    }
    
    public void setTime(int i) {
        this.tempsPossession = i;
    }
    
    public int getMinutes() {
        return this.min;
    }

    public int getSec() {
        return this.sec;
    }

    public int getCentieme() {
        return this.centieme;
    }
    
    public void setCentieme(int i) {
        centieme = i;
    }
    
    public void setMin(int i) {
        min = i;
    }
    
    public void setSec(int i) {
        sec = i;
    }
    
    public int getPossession() {
        return this.tempsPossession;
    }
    
    public void reinitChrono() {
	this.min = 10;
	this.sec = 0;
	this.centieme = 0;
	this.tempsPossession = 24;
    }
    
    public void reinit24() {
	this.tempsPossession = 24;
    }
    
    public void reinit14() {
        if (this.tempsPossession <= 14) 
            this.tempsPossession = 14;
    }
    
    public void incrementeChronometre() {
        if (!(sec == 0 && min == 10)) {
            sec++;
            if (sec == 60) {
                sec = 0;
                min++;
            }
        }
    }
    
    public void decrementeChronometre() {
        if (!(sec == 0 
                && min == 0 
                && centieme == 0)) {
            sec--;
            if (sec < 0) {
                sec = 59;
                min--;
            } 
        }
    }

    public void incrementePossession() {
        if(tempsPossession < 24) {
            this.tempsPossession++;
        }
    }
    
    public void decrementePossession() {
        if (tempsPossession > 0) {
            this.tempsPossession--;
        }
    }
}
