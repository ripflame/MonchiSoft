/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.OtherProduct;
import Managers.OtherProductManager;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */
public class OtherProductManagementController extends ManagementController{
    
    
    private OtherProductManagementController() {}
 
    
    private static class SingletonHolder { 
        public static final OtherProductManagementController INSTANCE = 
                new OtherProductManagementController();
    }
 
    
    public static OtherProductManagementController getInstance(OtherProduct otherProduct, 
            OtherProductManager otherProductManager, JTable productsTable) {
        m_otherProduct = otherProduct;
        m_otherProductManager = otherProductManager;
        m_productsTable = productsTable;
        return SingletonHolder.INSTANCE;
    }
    

    @Override
    public void displayCaptureView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    @Override
    public void performRemovalProcedures() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    @Override
    public void performModificationProcedures() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    @Override
    public void performAddingProcedures() {
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
        m_otherProductTableModel = buildTableModel(OTHER_PRODUCT_COLUMN_TITLES);
    }
    
    
    public final String[] OTHER_PRODUCT_COLUMN_TITLES = {"Nombre","Precio"};
    
    private static OtherProduct m_otherProduct;
    private static OtherProductManager m_otherProductManager;
    private static JTable m_productsTable;
    private DefaultTableModel m_otherProductTableModel;
}
