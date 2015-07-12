/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package las;

/**
 *
 * @author H.P. Asela
 */
public class Client {
    
    protected String name;
    protected String NIC;
    protected String birthday;
    protected String job;
    protected int income;
    protected boolean MarriedStatus;
    protected int NumberOfMarriedSons;
    protected int NumberOfUnmarriedSons;
    protected String address;
    
    Client(){ 
        
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public boolean isMarriedStatus() {
        return MarriedStatus;
    }

    public void setMarriedStatus(boolean MarriedStatus) {
        this.MarriedStatus = MarriedStatus;
    }

    public int getNumberOfMarriedSons() {
        return NumberOfMarriedSons;
    }

    public void setNumberOfMarriedSons(int NumberOfMarriedSons) {
        this.NumberOfMarriedSons = NumberOfMarriedSons;
    }

    public int getNumberOfUnmarriedSons() {
        return NumberOfUnmarriedSons;
    }

    public void setNumberOfUnmarriedSons(int NumberOfUnmarriedSons) {
        this.NumberOfUnmarriedSons = NumberOfUnmarriedSons;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
   
    
    
}
