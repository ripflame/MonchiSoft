package Helpers;

import java.awt.Window;
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
    private static final String EMPTY_FIELDS_STRING = "No todos los campos han sido llenados";
    private static final String INFORMATION_DIALOG_TITLE = "Información";
    private static final String ERROR_DIALOG_TITLE = "Error";
    private static final String NO_EXPENSE_FOUND = "No se encontró el gasto";
    private static final String NO_CUSTOMER_NAME_FOUND = "No se encontró el cliente, verifica los campos";
    private static final String NO_SALES_FOUND = "No se encontraron ventas.";
    private static final String NO_DATE_DEFINED = "No se ha seleccionado una fecha.";
    
    public static void showInformation(MessageType type, Window parentFrame) {
        String dialogMessage = getMessageStringFromType(type);
        JOptionPane.showConfirmDialog(parentFrame,
                dialogMessage,
                INFORMATION_DIALOG_TITLE,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showError(MessageType type, Window parentFrame) {
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
                break;
            
            case EMPTY_FIELDS:
                messageString = EMPTY_FIELDS_STRING;
                break;
                
            case NO_EXPENSE_FOUND:
                messageString = NO_EXPENSE_FOUND;
                break;
                
            case NO_CUSTOMER_NAME_FOUND:
                messageString = NO_CUSTOMER_NAME_FOUND;
                break;
            case NO_SALES_FOUND:
                messageString = NO_SALES_FOUND;
                break;
            case NO_DATE_DEFINED:
                messageString = NO_DATE_DEFINED;
                break;
        }
        
        return messageString;
    }
}
