/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.OtherProduct;
import Managers.OtherProductManager;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */
public class OtherProductManagementController extends ManagementController{
    
    public OtherProductManagementController(OtherProduct m_otherProduct, 
            OtherProductManager m_otherProductManager) {
        this.m_otherProduct = m_otherProduct;
        this.m_otherProductManager = m_otherProductManager;
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
    
    private OtherProduct m_otherProduct;
    private OtherProductManager m_otherProductManager;
    private DefaultTableModel m_otherProductTableModel;
}
