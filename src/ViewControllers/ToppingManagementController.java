/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.Topping;
import Managers.ToppingManager;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */
public class ToppingManagementController extends ManagementController{
    

    private ToppingManagementController() {}
 
    
    private static class SingletonHolder { 
        public static final ToppingManagementController INSTANCE = 
                new ToppingManagementController();
    }
 
    
    public static ToppingManagementController getInstance(Topping topping, 
            ToppingManager toppingManager, JTable productsTable) {
        m_topping = topping;
        m_toppingManager = toppingManager;
        m_productsTable = productsTable;
        return SingletonHolder.INSTANCE;
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
    
    private static Topping m_topping;
    private static ToppingManager m_toppingManager;
    private static JTable m_productsTable;
    private DefaultTableModel m_toppingTableModel;
    

}
