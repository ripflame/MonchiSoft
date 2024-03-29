/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Helpers.DataCheckerImplementation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */

public abstract class ManagementController implements ActionListener {
     
    //public abstract void 
    public abstract void createAndDisplayCaptureWindow();
    public abstract void performAddingProcedures();
    public abstract void performModificationProcedures();
    public abstract void performRemovalProcedures();
    public abstract void performDisplayProcedures();
    public abstract void setProductsTableModel();
    public abstract void closeCaptureWindow();
    public abstract void buildCaptureModifyWindow();
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        
        if (command.equalsIgnoreCase(NEW_COMMAND)) {
            createAndDisplayCaptureWindow();
        } else if (command.equalsIgnoreCase(MODIFY_COMMAND)){
            buildCaptureModifyWindow();
        } else if (command.equalsIgnoreCase(SAVE_MODIFY_COMMAND)){
            performModificationProcedures();
        } else if (command.equalsIgnoreCase(REMOVE_COMMAND)){
            performRemovalProcedures();   
        } else if (command.equalsIgnoreCase(SAVE_COMMAND)){
            performAddingProcedures();
        } else if (command.equalsIgnoreCase(CANCEL_COMMAND)){
            closeCaptureWindow();
        } else{
            Logger.getLogger(ManagementController.class.getName()).log(Level.INFO, "Caso no considerado");
        }
    }
    
    public DefaultTableModel buildTableModel(String[] columnTitles) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnTitles);
        return model;
    }
    
    
    private void auditDataText(String dataToAudit){
    m_dataChecker = new DataCheckerImplementation();    
    if ( !m_dataChecker.isNullString(dataToAudit)){
            if ( m_dataChecker.isDoubleNum(dataToAudit) | m_dataChecker.isIntegerNum(dataToAudit) ){
                //MessageDisplayManager.showError(MessageType.REQUIRED_TEXT, this);
                this.m_isAllValidData = false;
            } else {
                this.m_isAllValidData = true;
            }
        }else{
          // MessageDisplayManager.showError(MessageType.SEARCH_FIELD_EMPTY, this);
           this.m_isAllValidData = false;
        }
    }
    
    private void auditDataNum (String dataToAudit){
        m_dataChecker = new DataCheckerImplementation();
        if ( !m_dataChecker.isNullString(dataToAudit)){
            if ( m_dataChecker.isDoubleNum(dataToAudit) | m_dataChecker.isIntegerNum(dataToAudit) ){
                this.m_isAllValidData = true;
            } else {
             //   MessageDisplayManager.showError(MessageType.REQUIRED_NUM, this);
                this.m_isAllValidData = false;
            }
        }else{
          // MessageDisplayManager.showError(MessageType.SEARCH_FIELD_EMPTY, this);
            this.m_isAllValidData = false;
        }
        
    }
     
    public static final String NEW_COMMAND = "Nuevo";
    public static final String MODIFY_COMMAND = "Modificar";
    public static final String SAVE_MODIFY_COMMAND = "Guardar/Modificar";
    public static final String REMOVE_COMMAND = "Eliminar";
    public static final String SAVE_COMMAND = "Guardar"; 
    public static final String CANCEL_COMMAND = "Cancelar";
    
    public static final String STRING_NULL = "";
    public boolean m_isAllValidData = true; 
    private DataCheckerImplementation m_dataChecker;
}
