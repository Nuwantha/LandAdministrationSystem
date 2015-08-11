/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.common_classes;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Gimhani
 */
public class GUIitemsValidator {
    public static void addItemToCombo(ArrayList list,JComboBox combo){
                combo.setPopupVisible(true);
                String test = String.valueOf(combo.getEditor().getItem());
                combo.removeAllItems();
                for (int i=0;i<list.size();i++) {
                        combo.addItem(list.get(i));
                  }
                combo.getEditor().setItem(test);
                
    
    };
    public static void incermentSpinnerValue(JSpinner spinner) {
        int i=(int)spinner.getValue()+1;
        spinner.setValue((Object)i);

    }
    public static void decrementSpinnerValue(JSpinner spinner) {
        int i=(int)spinner.getValue()-1;
        spinner.setValue((Object)i);

    }
    public static void limitSpinnerValue(JSpinner spinner, int min, int max) {
        if (Integer.parseInt(spinner.getValue().toString()) <= min) {
            spinner.setValue(min);

        } else if (Integer.parseInt(spinner.getValue().toString()) >= max) {
            spinner.setValue(max);

        } else {
            spinner.setEnabled(true);
        }

    }
    public static void limitminimumSpinnerValue(JSpinner spinner, int min) {
        if (Integer.parseInt(spinner.getValue().toString()) <= min) {
            spinner.setValue(min);

        } else {
            spinner.setEnabled(true);
        }

    }

    public static void limitTextFieldValue(JTextField textField, int max) {
         if (textField.getText().length() > max) {
            String newtext = textField.getText().substring(0, max - 1);
            textField.setText(newtext);
        }
      
    }
    
}
