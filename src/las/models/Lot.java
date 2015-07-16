/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.models;

/**
 *
 * @author Nuwantha
 */
public class Lot {
    private int lotNumber;
    private double numberOfAcres;
    private double numberofRoods;
    private double numberOfPerches;
    
    private Land land;

    public int getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public double getNumberOfAcres() {
        return numberOfAcres;
    }

    public void setNumberOfAcres(double numberOfAcres) {
        this.numberOfAcres = numberOfAcres;
    }

    public double getNumberofRoods() {
        return numberofRoods;
    }

    public void setNumberofRoods(double numberofRoods) {
        this.numberofRoods = numberofRoods;
    }

    public double getNumberOfPerches() {
        return numberOfPerches;
    }

    public void setNumberOfPerches(double numberOfPerches) {
        this.numberOfPerches = numberOfPerches;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }
    
    
}
