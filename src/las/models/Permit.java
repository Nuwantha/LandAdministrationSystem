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
public class Permit {
    private String permitNumber;
    private String permitIssueDate;
    private Lot lot;
    private Client client;
    private NominatedSuccessor nominatedSuccessor;
    int haveGrant=0;

    public Permit(String permitNumber, String permitIssueDate, Lot lot, Client client, NominatedSuccessor nominatedSuccessor, int havePermit) {
        this.permitNumber = permitNumber;
        this.permitIssueDate = permitIssueDate;
        this.lot = lot;
        this.client = client;
        this.nominatedSuccessor = nominatedSuccessor;
        this.haveGrant = havePermit;
    }

    
    
    public Permit(String permitNumber, String permitIssueDate, Lot lot, Client client, NominatedSuccessor nominatedSuccessor) {
        this.permitNumber = permitNumber;
        this.permitIssueDate = permitIssueDate;
        this.lot = lot;
        this.client = client;
        this.nominatedSuccessor = nominatedSuccessor;
        
    }
    
    
    public String getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(String permitNumber) {
        this.permitNumber = permitNumber;
    }

    public String getPermitIssueDate() {
        return permitIssueDate;
    }

    public void setPermitIssueDate(String permitIssueDate) {
        this.permitIssueDate = permitIssueDate;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public NominatedSuccessor getNominatedSuccessor() {
        return nominatedSuccessor;
    }

    public void setNominatedSuccessor(NominatedSuccessor nominatedSuccessor) {
        this.nominatedSuccessor = nominatedSuccessor;
    }
    
    
    public int getHaveGrant() {
        return haveGrant;
    }

    public void setHaveGrant(int havePermit) {
        this.haveGrant = havePermit;
    }

}
