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
    private String lotNumber;
    private int numberOfAcres;
    private int isAvilable=0;
    private int numberofRoods;
    private int numberOfPerches; 
    private Land land;
    
    
    public Lot(String lotNumber, int numberOfAcres, int numberofRoods, int numberOfPerches, Land land) {
        this.lotNumber = lotNumber;
        this.numberOfAcres = numberOfAcres;
        this.numberofRoods = numberofRoods;
        this.numberOfPerches = numberOfPerches;
        this.land = land;
    }

    public Lot(String lotNumber, int numberOfAcres, int numberofRoods, int numberOfPerches) {
        this.lotNumber = lotNumber;
        this.numberOfAcres = numberOfAcres;
        this.numberofRoods = numberofRoods;
        this.numberOfPerches = numberOfPerches;
    }

    
    public String getLotNumber() {
        return lotNumber;
    }

    public int getIsAvilable() {
        return isAvilable;
    }

    public void setIsAvilable(int isAvilable) {
        this.isAvilable = isAvilable;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public int getNumberOfAcres() {
        return numberOfAcres;
    }

    public void setNumberOfAcres(int numberOfAcres) {
        this.numberOfAcres = numberOfAcres;
    }

    public int getNumberofRoods() {
        return numberofRoods;
    }

    public void setNumberofRoods(int numberofRoods) {
        this.numberofRoods = numberofRoods;
    }

    public int getNumberOfPerches() {
        return numberOfPerches;
    }

    public void setNumberOfPerches(int numberOfPerches) {
        this.numberOfPerches = numberOfPerches;
    }

    
    

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }
    
    
}
