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
    private double annualIncome;
    private String address;
    
    private int marriedStatus;
    private int numberOfMarriedSons;
    private int numberOfUnmarriedSons;
    
    private int permitOwnershipPosition;
    private int grantOwnershipPosition;

    Client() {

    }

    public Client( String NIC,String clientName, String birthday, String telephone, String address,  double annualIncome, int grantOwnershipPosition, int permitOwnershipPosition,  int marriedStatus, int numberOfMarriedSons, int numberOfUnmarriedSons) {
        this.clientName = clientName;
        this.NIC = NIC;
        this.birthday = birthday;
        this.telephone = telephone;
        this.annualIncome = annualIncome;
        this.address = address;
        this.marriedStatus = marriedStatus;
        this.numberOfMarriedSons = numberOfMarriedSons;
        this.numberOfUnmarriedSons = numberOfUnmarriedSons;
        this.permitOwnershipPosition = permitOwnershipPosition;
        this.grantOwnershipPosition = grantOwnershipPosition;
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

  
    public int isMarried() {
        return marriedStatus;
    }

    public void setMarriedStatus(int marriedStatus) {
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

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
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
