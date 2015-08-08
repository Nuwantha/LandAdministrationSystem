/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.common_classes;

/**
 *
 * @author Gimhani
 */
public class IdGenerator {
    
    public  static String generateNextPlanNumber(String oldPlanNumber){
        String newPlanNumber="PL";
        String substring = oldPlanNumber.substring(2);
        int parseInt = Integer.parseInt(substring);
        parseInt++;
        String valueOf = String.valueOf(parseInt);
        if(parseInt<10){
           newPlanNumber+="0"+valueOf; 
        }
        else{
            newPlanNumber+=valueOf;
        }
        return newPlanNumber;
    } 
    public  static String generateNextLotNumber(String oldLotNumber){
        String newLotNumber="L";
        String substring = oldLotNumber.substring(1);
        int parseInt = Integer.parseInt(substring);
        parseInt++;
        String valueOf = String.valueOf(parseInt);
        if(parseInt>10&&parseInt<100){
           newLotNumber+="0"+valueOf; 
        }
        else if(parseInt>100){
            newLotNumber+=valueOf;
        }else{
            newLotNumber+="00"+valueOf;
        }
        return newLotNumber;
    } 
}
