/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

/**
 *
 * @author Ileana
 */
public class DataCheckerImplementation implements DataChecker{

    public DataCheckerImplementation() {
    }
    
    
    
    public boolean isNullString(String textData) {
        if (textData.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isDoubleNum (String textData){
        try {
            Double.parseDouble(textData);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean isIntegerNum (String textData){
        try {
            Integer.parseInt(textData);
            return true;
        }catch(Exception e){
            return false;
        }
    } 
    
}
