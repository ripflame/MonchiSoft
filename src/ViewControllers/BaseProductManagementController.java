/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.BaseProduct;
import Helpers.MessageDisplayManager;
import Helpers.MessageType;
import Managers.BaseProductManager;
import Managers.BaseProductManagerImplementation;
import java.awt.HeadlessException;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */
public class BaseProductManagementController extends ManagementController {
    
    // Private constructor prevents instantiation from other classes
    private BaseProductManagementController() {}
 
    /**
    * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
    * or the first access to SingletonHolder.INSTANCE, not before.
    */
    private static class SingletonHolder { 
        public static final BaseProductManagementController INSTANCE = 
                new BaseProductManagementController();
    }
 
    public static BaseProductManagementController getInstance(BaseProduct baseProduct, 
            BaseProductManager baseProductManager, JTable productsTable, JButton button) {
        m_baseProduct = baseProduct;
        m_baseProductManager = baseProductManager;
        m_productsTable = productsTable;
        m_newButton = button;
        return SingletonHolder.INSTANCE;
    }


    @Override
    public void createAndDisplayCaptureWindow() {
        this.m_captureWindow = new CaptureProductData(this);
        this.m_captureWindow.setTitleLabel(TITLE_LABEL);
        this.m_captureWindow.setVisible(true);     
    }

    
    @Override     
    public void performAddingProcedures() {
        if (m_captureWindow.m_isAllValidData){
            String[] baseProductData = getDataCaptured();
            setBaseProductData(baseProductData);
            boolean isSucces = false;
            try {
                m_baseProductManager.add(m_baseProduct);
                isSucces = true;
            } catch (Exception e){} 
        
            if (isSucces){
                m_baseProductTableModel.addRow(baseProductData);
                this.m_captureWindow.dispose();
                m_newButton.setEnabled(true);
            } else {
                //falta un mensaje de error
                Logger.getLogger(ManagementController.class.getName()).log(Level.INFO, "Ocurrió un error");
            }
        } else {
            Logger.getLogger(ManagementController.class.getName()).log(Level.INFO, "Hay datos inválidos");
        }
        
    }
    
     private void setBaseProductData (String[] productData){
        m_baseProduct.setName(productData[0]);
        m_baseProduct.setSmallPrice(Double.parseDouble(productData[1]));
        m_baseProduct.setMediumPrice(Double.parseDouble(productData[2]));
        m_baseProduct.setLargePrice(Double.parseDouble(productData[3]));
     }
    
     private String[] getDataCaptured (){
        int elementNum = FIRST;
        String[] data = new String[ELEMENTS_TOTAL];
        data[elementNum] = this.m_captureWindow.getNameText();
        data[++elementNum] = this.m_captureWindow.getFirstPriceText();
        data[++elementNum] = this.m_captureWindow.getSecondPriceText();
        data[++elementNum] = this.m_captureWindow.getThirdPriceText();          
        return data;
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
        this.setProductsTableModel();
        List listBaseProducts = this.getBaseProducts();
        this.updateTableModel(listBaseProducts);
        m_productsTable.setModel(m_baseProductTableModel);
    }
    
    
    @Override
    public void performSearchingProcedures() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    @Override
    public void setProductsTableModel(){       
        m_baseProductTableModel = buildTableModel(BASE_PRODUCT_COLUMN_TITLES);
    }
    
    private List getBaseProducts() {
        List baseProducts = m_baseProductManager.getAll();
        return baseProducts;
    }
    
    
    private void updateTableModel (List baseProducts){
        Iterator<BaseProduct> iterator = baseProducts.iterator();
	
        while (iterator.hasNext()) {
            int columnNum = FIRST;
            BaseProduct m_baseProduct = (BaseProduct) iterator.next();
            String baseProductData[] = new String[ELEMENTS_TOTAL];
            baseProductData[columnNum] = m_baseProduct.getName();
            baseProductData[++columnNum] = String.valueOf(m_baseProduct.getSmallPrice());
            baseProductData[++columnNum] = String.valueOf(m_baseProduct.getMediumPrice());
            baseProductData[++columnNum] = String.valueOf(m_baseProduct.getLargePrice());
            this.m_baseProductTableModel.addRow(baseProductData);
        }
      
    }
    
    
    private final String NAME_FIELD_LABEL = "Nombre";
    private final String SMALL_PRICE_FIELD_LABEL = "Precio: Chico";
    private final String MEDIUM_PRICE_FIELD_LABEL = "Precio: Mediano";
    private final String LARGE_PRICE_FIELD_LABEL = "Precio: Grande";
    private final String[] BASE_PRODUCT_COLUMN_TITLES = {
        NAME_FIELD_LABEL, SMALL_PRICE_FIELD_LABEL,
        MEDIUM_PRICE_FIELD_LABEL, LARGE_PRICE_FIELD_LABEL};
    private final String TITLE_LABEL = "Producto base";
    private final int FIRST = 0;
    private final int ELEMENTS_TOTAL = BASE_PRODUCT_COLUMN_TITLES.length;
    private static BaseProduct m_baseProduct;
    private static BaseProductManager m_baseProductManager;
    private static JTable m_productsTable;
    private static JButton m_newButton;
    private DefaultTableModel m_baseProductTableModel;
    private CaptureProductData m_captureWindow;
    
}