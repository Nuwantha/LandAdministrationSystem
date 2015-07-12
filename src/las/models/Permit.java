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
public class Permit {
    
    private String PermitNo;
    private String Date;
    private String NominatedSuccessor;
    
    Permit(){
}

    public String getPermitNo() {
        return PermitNo;
    }

    public void setPermitNo(String PermitNo) {
        this.PermitNo = PermitNo;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getNominatedSuccessor() {
        return NominatedSuccessor;
    }

    public void setNominatedSuccessor(String NominatedSuccessor) {
        this.NominatedSuccessor = NominatedSuccessor;
    }
    
    
}
