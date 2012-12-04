/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */

public interface ManagementComponents {
     
    //public abstract void 
    public abstract DefaultTableModel getModelTable ();
    public abstract void displayCaptureView ();
    public abstract void performRemovalProcedures();
    public abstract void performModificationProcedures();
    public abstract void performAddingProcedures();
    public abstract void performSearchingProcedures();
    
    public final String NEW_COMMAND = "Nuevo";
    public final String MODIFY_COMMAND = "Modificar";
    public final String REMOVE_COMMAND = "Eliminar";
    public final String SHOW_ALL_COMMAND = "Mostrar todos";
}
