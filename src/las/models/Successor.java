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
public class Successor extends Client{
    
    private Applicant ApplicantPreffered;
    
    Successor(){
        
    }

    public Applicant getApplicantPreffered() {
        return ApplicantPreffered;
    }

    public void setApplicantPreffered(Applicant ApplicantPreffered) {
        this.ApplicantPreffered = ApplicantPreffered;
    }
    
    
    
}
