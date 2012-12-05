/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.Topping;
import Managers.ToppingManager;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */
public class ToppingManagementController extends ManagementController{

    public ToppingManagementController(Topping m_topping, ToppingManager m_toppingManager) {
        this.m_topping = m_topping;
        this.m_toppingManager = m_toppingManager;
    }
      

    @Override
    public void displayCaptureView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void performAddingProcedures() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    @Override
    public void performModificationProcedures() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    @Override
    public void performRemovalProcedures() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
     
     
    @Override
    public void performDisplayProcedures() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    @Override
    public void performSearchingProcedures() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void setProductsTableModel(){       
        m_toppingTableModel = buildTableModel(TOPPING_COLUMN_TITLES);
    }
    
    public final String[] TOPPING_COLUMN_TITLES = {"Nombre","Precio de Extra"};
    
    private Topping m_topping;
    private ToppingManager m_toppingManager;
    private DefaultTableModel m_toppingTableModel;

}
