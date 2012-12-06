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
 
    
    public static OtherProductManagementController getInstance( 
            OtherProductManager otherProductManager, ProductsManagement productsModule) {
        m_otherProductManager = otherProductManager;
        m_productsModule = productsModule;
        return SingletonHolder.INSTANCE;
    }
    

    @Override
    public void createAndDisplayCaptureWindow() {
        m_productsModule.disableNewButton();
        this.m_captureWindow = new CaptureProductData(this);
        this.m_captureWindow.setLocationRelativeTo(m_productsModule);
        m_productsModule.setEnabled(false);
        this.m_captureWindow.setTitleLabel(TITLE_LABEL);
        this.m_captureWindow.setFirstPriceText(PRICE_FIELD_LABEL);
        this.m_captureWindow.setSecondPriceText(STRING_NULL);
        this.m_captureWindow.setThirdPriceText(STRING_NULL);
        this.m_captureWindow.disableSecondPriceText();
        this.m_captureWindow.disableThirdPriceText();
        this.m_captureWindow.setVisible(true);     
    }
    
    
    @Override
    public void performRemovalProcedures() {
        int rowSelected = m_productsModule.getSelectedRowNum();
        Object nameSelected = this.m_otherProductTableModel.getValueAt(rowSelected, 0);
        List listProducts = m_otherProductManager.searchByExactName(nameSelected.toString());
        Iterator<OtherProduct> iterator = listProducts.iterator();
        m_otherProduct = new OtherProduct ();
        OtherProduct m_otherProduct = (OtherProduct) iterator.next();
        boolean isSucces = false;
        try {
            m_otherProductManager.remove(m_otherProduct);
            isSucces = true;
        }catch(Exception e){}
        if (isSucces) {
            this.m_otherProductTableModel.removeRow(rowSelected);
            m_productsModule.disableRemoveButton();
            m_productsModule.disableModifyButton();
        }
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
        m_productsTable = m_productsModule.productsTable;
        this.setProductsTableModel();
        List listOtherProducts = this.getOtherProducts();
        this.updateTableModel(listOtherProducts);
        m_productsTable.setModel(m_otherProductTableModel);
    }
    
    
    @Override
    public void closeCaptureWindow(){
        m_productsModule.setEnabled(true);
        m_captureWindow.dispose();
        m_productsModule.enableNewButton();
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

    private static final String NAME_FIELD_LABEL = "Nombre";
    private static final String PRICE_FIELD_LABEL = "Precio";
    private static final String[] OTHER_PRODUCT_COLUMN_TITLES = {NAME_FIELD_LABEL, PRICE_FIELD_LABEL};
    private static final int FIRST = 0;
    private static final int ELEMENTS_TOTAL = OTHER_PRODUCT_COLUMN_TITLES.length;
    private static final String TITLE_LABEL = "Otro tipo de producto";
    private static OtherProduct m_otherProduct;
    private static OtherProductManager m_otherProductManager;
    private static JTable m_productsTable;
    private DefaultTableModel m_otherProductTableModel;
    private CaptureProductData m_captureWindow;
    private static ProductsManagement m_productsModule;
}
