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
public class Lot {
    
    private String LotNo;
    private String Size;
    private String FourBoundaries;//Array is better
    
    Lot(){
        
    }

    public String getLotNo() {
        return LotNo;
    }

    public void setLotNo(String LotNo) {
        this.LotNo = LotNo;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getFourBoundaries() {
        return FourBoundaries;
    }

    public void setFourBoundaries(String FourBoundaries) {
        this.FourBoundaries = FourBoundaries;
    }
    
}
