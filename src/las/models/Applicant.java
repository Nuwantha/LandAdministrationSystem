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
public class Applicant extends Client{
    
    private String placeHeLIvedAtTimeApplied;
    private String GramaNiladariCertification;
    
    
    Applicant(){
        
    }
    

    public String getPlaceHeLIvedAtTimeApplied() {
        return placeHeLIvedAtTimeApplied;
    }

    public void setPlaceHeLIvedAtTimeApplied(String placeHeLIvedAtTimeApplied) {
        this.placeHeLIvedAtTimeApplied = placeHeLIvedAtTimeApplied;
    }

    public String getGramaNiladariCertification() {
        return GramaNiladariCertification;
    }

    public void setGramaNiladariCertification(String GramaNiladariCertification) {
        this.GramaNiladariCertification = GramaNiladariCertification;
    }
    
    
}
