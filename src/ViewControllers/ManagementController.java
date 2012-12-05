/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */

public abstract class ManagementController implements ActionListener {
     
    //public abstract void 
    public abstract void displayCaptureView ();
    public abstract void performAddingProcedures();
    public abstract void performModificationProcedures();
    public abstract void performRemovalProcedures();
    public abstract void performDisplayProcedures();
    public abstract void performSearchingProcedures();
    public abstract void setProductsTableModel();
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        
        if (command.equalsIgnoreCase(NEW_COMMAND)) {
            performAddingProcedures();
        } else if (command.equalsIgnoreCase(MODIFY_COMMAND)){
            performModificationProcedures();
        } else if (command.equalsIgnoreCase(REMOVE_COMMAND)){
            performRemovalProcedures();   
        } else {
            Logger.getLogger(ManagementController.class.getName()).log(Level.INFO, "Caso no considerado");
        }
    }
    
    public DefaultTableModel buildTableModel(String[] columnTitles) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnTitles);
        return model;
    }
     
    public final String NEW_COMMAND = "Nuevo";
    public final String MODIFY_COMMAND = "Modificar";
    public final String REMOVE_COMMAND = "Eliminar"; 
}
