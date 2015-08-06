/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.common_classes;

import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Gimhani
 */
public class ComboItemAdder {
    public static void addItemToCombo(ArrayList list,JComboBox combo){
                combo.setPopupVisible(true);
                String test = String.valueOf(combo.getEditor().getItem());
                combo.removeAllItems();
                for (int i=0;i<list.size();i++) {
                        combo.addItem(list.get(i));
                  }
                combo.getEditor().setItem(test);
                
    
    };
    
}
