/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guillaumehalb
 */
public class Chronometre {

    private int min = 10;
    private int sec = 0;
    private int centieme = 0;

    /* Temps de possession */ 
    private int time = 24;
    
    public Chronometre() {
        this.min = 10;
        this.sec = 0;
        this.centieme = 0;
        this.time = 24;
    }

    public int getTime() {
        return this.time;
    }
    
    public void setTime(int i) {
        this.time = i;
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
        return this.time;
    }
    
    public void reinitChrono() {
	this.min = 10;
	this.sec = 0;
	this.centieme = 0;
	this.time = 24;
    }
    
    public void reinit24() {
	this.time = 24;
    }
    
    public void reinit14() {
        if (this.time <= 14) 
            this.time = 14;
    }
    
    public void incr() {
        sec++;
        if (sec == 60) {
            sec = 0;
            min++;
        }
    }
    
    public void decr() {
        sec--;
        if (sec < 0) {
            sec = 59;
            min--;
        } 
    }

}
