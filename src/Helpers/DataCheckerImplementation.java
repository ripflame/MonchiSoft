/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import ViewControllers.ManagementController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ileana
 */
public class DataCheckerImplementation implements DataChecker{

    public DataCheckerImplementation() {
    }
    
    
    
    @Override
    public boolean isNullString(String textData) {

        if (textData.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean isDoubleNum (String textData){
        try {
            Double.parseDouble(textData);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    @Override
    public boolean isIntegerNum (String textData){
        try {
            Integer.parseInt(textData);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean isNum (String textData){
        if ( isDoubleNum ( textData ) | isIntegerNum( textData ) ){
            return true;
        } else {
            return false;
        }
    }
    
}
