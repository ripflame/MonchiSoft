/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.OtherProduct;
import Managers.OtherProductManager;
import java.util.Iterator;
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
    public void createAndDisplayCaptureWindow() {
        CaptureProductData captureWindow = new CaptureProductData(this);
        captureWindow.setVisible(true);
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
        
    }

    @Override
    public void performDisplayProcedures() {
        this.setProductsTableModel();
        List listOtherProducts = this.getOtherProducts();
        this.updateTableModel(listOtherProducts);
        m_productsTable.setModel(m_otherProductTableModel);
    }
    
    
    @Override
    public void performSearchingProcedures() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    @Override
    public void setProductsTableModel(){       
        m_otherProductTableModel = buildTableModel(OTHER_PRODUCT_COLUMN_TITLES);
    }
    
    
    private List getOtherProducts() {
        List otherProducts = m_otherProductManager.getAll();
        return otherProducts;
    }
    
    
    public void updateTableModel (List otherProducts){
        Iterator<OtherProduct> iterator = otherProducts.iterator();
	
        while (iterator.hasNext()) {
            int columnNum = FIRST;
            OtherProduct m_otherProduct = (OtherProduct) iterator.next();
            String otherProductData[] = new String[ELEMENTS_TOTAL];
            otherProductData[columnNum] = m_otherProduct.getName();
            otherProductData[++columnNum] = String.valueOf(m_otherProduct.getPrice());
            this.m_otherProductTableModel.addRow(otherProductData);
        }
      
    }

    
    private final String[] OTHER_PRODUCT_COLUMN_TITLES = {"Nombre","Precio"};
    private final int FIRST = 0;
    private final int ELEMENTS_TOTAL = OTHER_PRODUCT_COLUMN_TITLES.length;
    private static OtherProduct m_otherProduct;
    private static OtherProductManager m_otherProductManager;
    private static JTable m_productsTable;
    private DefaultTableModel m_otherProductTableModel;
}
