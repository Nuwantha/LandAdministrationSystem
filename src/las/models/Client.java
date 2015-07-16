/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.models;

/**
 *
 * @author H.P. Asela
 */
public class Client {

    private String clientName;
    private String NIC;
    private String birthday;
    private String telephone;
    private int annualIncome;
    private String address;
    
    private boolean marriedStatus;
    private int numberOfMarriedSons;
    private int numberOfUnmarriedSons;
    
    private int permitOwnershipPosition;
    private int grantOwnershipPosition;

    Client() {

    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

  
    public boolean isMarried() {
        return marriedStatus;
    }

    public void setMarriedStatus(boolean marriedStatus) {
        this.marriedStatus = marriedStatus;
    }

    public int getNumberOfMarriedSons() {
        return numberOfMarriedSons;
    }

    public void setNumberOfMarriedSons(int numberOfMarriedSons) {
        this.numberOfMarriedSons = numberOfMarriedSons;
    }

    public int getNumberOfUnmarriedSons() {
        return numberOfUnmarriedSons;
    }

    public void setNumberOfUnmarriedSons(int numberOfUnmarriedSons) {
        this.numberOfUnmarriedSons = numberOfUnmarriedSons;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(int annualIncome) {
        this.annualIncome = annualIncome;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPermitOwnershipPosition() {
        return permitOwnershipPosition;
    }

    public void setPermitOwnershipPosition(int permitOwnershipPosition) {
        this.permitOwnershipPosition = permitOwnershipPosition;
    }

    public int getGrantOwnershipPosition() {
        return grantOwnershipPosition;
    }

    public void setGrantOwnershipPosition(int grantOwnershipPosition) {
        this.grantOwnershipPosition = grantOwnershipPosition;
    }
}
