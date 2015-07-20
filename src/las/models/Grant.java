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
public class Grant {
    private String grantNumber;
    private String grantIssueDate;
    private Permit permit;
    private Lot lot;
    private Client client;
    private NominatedSuccessor nominatedSuccessor;

    public Grant(String grantNumber, String grantIssueDate, Permit permit, Lot lot, Client client, NominatedSuccessor nominatedSuccessor) {
        this.grantNumber = grantNumber;
        this.grantIssueDate = grantIssueDate;
        this.permit = permit;
        this.lot = lot;
        this.client = client;
        this.nominatedSuccessor = nominatedSuccessor;
    }
    
    
    
    public String getGrantNumber() {
        return grantNumber;
    }

    public void setGrantNumber(String grantNumber) {
        this.grantNumber = grantNumber;
    }

    public String getGrantIssueDate() {
        return grantIssueDate;
    }

    public void setGrantIssueDate(String grantIssueDate) {
        this.grantIssueDate = grantIssueDate;
    }

    public Permit getPermit() {
        return permit;
    }

    public void setPermit(Permit permit) {
        this.permit = permit;
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
    
}
