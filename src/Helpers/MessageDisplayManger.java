package Helpers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class MessageDisplayManger {
    private static final String NO_CELL_SELECTED_STRING = "No seleccionaste ninguna celda";
    private static final String SEARCH_FIELD_EMPTY_STRING = "No escribiste nada en el campo de búsqueda";
    private static final String NO_COSTUMER_FOUND_STRING = "No se encontró ningún cliente";
    private static final String NO_SUPPLIER_FOUND_STRING = "No se encontró ningún provedor";
    private static final String INFORMATION_DIALOG_TITLE = "Información";
    private static final String ERROR_DIALOG_TITLE = "Error";
    
    public static void showInformation(MessageType type, JFrame parentFrame) {
        String dialogMessage = getMessageStringFromType(type);
        JOptionPane.showConfirmDialog(parentFrame,
                dialogMessage,
                INFORMATION_DIALOG_TITLE,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showError(MessageType type, JFrame parentFrame) {
        String dialogMessage = getMessageStringFromType(type);
        JOptionPane.showConfirmDialog(parentFrame,
                dialogMessage,
                ERROR_DIALOG_TITLE,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE);
    }
    
    private static String getMessageStringFromType(MessageType type) {
        String messageString = "";
        
        switch(type) {
            case NO_CELL_SELECTED:
                messageString = NO_CELL_SELECTED_STRING;
                break;
                
            case SEARCH_FIELD_EMPTY:
                messageString = SEARCH_FIELD_EMPTY_STRING;
                break;
                
            case NO_COSTUMER_FOUND:
                messageString = NO_COSTUMER_FOUND_STRING;
                break;
                
            case NO_SUPPLIER_FOUND:
                messageString = NO_SUPPLIER_FOUND_STRING;
        }
        
        return messageString;
    }
}
