/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.common_classes;

import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Gimhani
 */
public class ComponentSizeController {
    public static void limitSpinnerValue(JSpinner spinner, int min, int max) {
        if (Integer.parseInt(spinner.getValue().toString()) <= min) {
            spinner.setValue(min);

        } else if (Integer.parseInt(spinner.getValue().toString()) >= max) {
            spinner.setValue(max);

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
