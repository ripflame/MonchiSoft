/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.BaseProduct;
import Helpers.DataCheckerImplementation;
import Helpers.MessageDisplayManager;
import Helpers.MessageType;
import Managers.BaseProductManager;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTable;
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
 
    public static BaseProductManagementController getInstance( 
            BaseProductManager baseProductManager, ProductsManagement productsModule) {
        m_baseProductManager = baseProductManager;
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
        this.m_captureWindow.setVisible(true);     
    }

    
    @Override     
    public void performAddingProcedures() {
        String[] baseProductData = new String [ELEMENTS_TOTAL];
        baseProductData = getAndAuditDataCaptured();
        if (m_isAllValidData){
            setBaseProductData(baseProductData);
            boolean isSucces = false;
            if ( !exists( m_baseProduct.getName() ) ){
                try {
                     m_baseProductManager.add( m_baseProduct );
                     isSucces = true;
                }catch(Exception e){
                    isSucces = false;}
                
            if (isSucces){
                    m_baseProductTableModel.addRow(baseProductData);
                    m_productsModule.setEnabled(true);
                    m_captureWindow.dispose();
                    m_productsModule.enableNewButton();
                } else {
                      MessageDisplayManager.showInformation(MessageType.ERROR_DATA_BASE, m_captureWindow);
                }
            }
        } else {
            MessageDisplayManager.showInformation(MessageType.INVALID_DATA, m_captureWindow);
        }
    }
    
    
    @Override    
    public void performModificationProcedures() {
        
    }

    
    @Override
    public void performRemovalProcedures() {
        int rowSelected = m_productsModule.getSelectedRowNum();
        Object nameSelected = this.m_baseProductTableModel.getValueAt(rowSelected, 0);
        List listProducts = m_baseProductManager.searchByExactName(nameSelected.toString());
        Iterator<BaseProduct> iterator = listProducts.iterator();
        m_baseProduct = new BaseProduct ();
        BaseProduct m_baseProduct = (BaseProduct) iterator.next();
        boolean isSucces = false;
        try {
            m_baseProductManager.remove(m_baseProduct);
            isSucces = true;
        }catch(Exception e){}
        if (isSucces) {
            this.m_baseProductTableModel.removeRow(rowSelected);
            m_productsModule.disableRemoveButton();
            m_productsModule.disableModifyButton();
        }
    }
    
    @Override
    public void performDisplayProcedures() {
        m_productsTable = m_productsModule.productsTable;
        this.setProductsTableModel();
        List listBaseProducts = this.getBaseProducts();
        this.updateTableModel(listBaseProducts);
        m_productsTable.setModel(m_baseProductTableModel);
    }
    
    @Override
    public void closeCaptureWindow(){
        m_productsModule.setEnabled(true);
        m_captureWindow.dispose();
        m_productsModule.enableNewButton();
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
            m_baseProduct = new BaseProduct();
            BaseProduct m_baseProduct = (BaseProduct) iterator.next();
            String baseProductData[] = new String[ELEMENTS_TOTAL];
            baseProductData[columnNum] = m_baseProduct.getName();
            baseProductData[++columnNum] = String.valueOf(m_baseProduct.getSmallPrice());
            baseProductData[++columnNum] = String.valueOf(m_baseProduct.getMediumPrice());
            baseProductData[++columnNum] = String.valueOf(m_baseProduct.getLargePrice());
            this.m_baseProductTableModel.addRow(baseProductData);
        }
      
    }
    
    
    private void setBaseProductData (String[] productData){
         int dataNum = FIRST;
         m_baseProduct = new BaseProduct();
         m_baseProduct.setName(productData[dataNum]);
         m_baseProduct.setSmallPrice(Double.parseDouble(productData[++dataNum]));
         m_baseProduct.setMediumPrice(Double.parseDouble(productData[++dataNum]));
         m_baseProduct.setLargePrice(Double.parseDouble(productData[++dataNum]));
     }
    
    
     private String[] getAndAuditDataCaptured (){
         
         String name = this.m_captureWindow.getNameText();
         String smallPrice = this.m_captureWindow.getFirstPriceText();
         String mediumPrice = this.m_captureWindow.getSecondPriceText();
         String largePrice = this.m_captureWindow.getThirdPriceText();
         
         this.m_dataChecker = new DataCheckerImplementation();
         
         if (m_dataChecker.isNullString ( name )){
             m_isAllValidData = false;
             MessageDisplayManager.showInformation(MessageType.EMPTY_FIELDS, m_captureWindow);
             
         } else {
             if ( m_dataChecker.isNum( name ) ){
                 m_isAllValidData = false;  
                 MessageDisplayManager.showInformation(MessageType.REQUIRED_TEXT, m_captureWindow);
             } else {
                 if (  m_dataChecker.isNum( smallPrice ) & 
                       m_dataChecker.isNum( mediumPrice ) &
                       m_dataChecker.isNum( largePrice ) ) {
                     m_isAllValidData = true;
                     } else { 
                     m_isAllValidData = false;
                     MessageDisplayManager.showInformation(MessageType.REQUIRED_NUM, m_captureWindow);
                 }               
             }
         }
             
         int elementNum = FIRST;
         String[] data = new String[ELEMENTS_TOTAL];
         data [elementNum] = name;
         data [++elementNum] = smallPrice;
         data [++elementNum] = mediumPrice;
         data [++elementNum] = largePrice;
        
         return data;
    }   

     
    private boolean exists(String textData){
        List listProducts = m_baseProductManager.searchByExactName(textData);
        if (listProducts.isEmpty()){
            return false;            
        } else {
            MessageDisplayManager.showInformation(MessageType.PRODUCT_EXISTS, m_captureWindow);
            return true;
        }
    }
    
    /*CONSTANTES NOMBRADAS*/
    private static final String NAME_FIELD_LABEL = "Nombre";
    private static final String SMALL_PRICE_FIELD_LABEL = "Precio: Chico";
    private static final String MEDIUM_PRICE_FIELD_LABEL = "Precio: Mediano";
    private static final String LARGE_PRICE_FIELD_LABEL = "Precio: Grande";
    private static final String[] BASE_PRODUCT_COLUMN_TITLES = {
        NAME_FIELD_LABEL, SMALL_PRICE_FIELD_LABEL,
        MEDIUM_PRICE_FIELD_LABEL, LARGE_PRICE_FIELD_LABEL};
    private static final String TITLE_LABEL = "Producto base";
    private static final int FIRST = 0;
    private static final int ELEMENTS_TOTAL = BASE_PRODUCT_COLUMN_TITLES.length;
    
    /*VARIABLES POR REFERENCIA*/
    private static BaseProduct m_baseProduct;
    private static BaseProductManager m_baseProductManager;
    private static JTable m_productsTable;
    private static ProductsManagement m_productsModule;
    private DefaultTableModel m_baseProductTableModel;
    private CaptureProductData m_captureWindow;
    
    private DataCheckerImplementation m_dataChecker;
    private boolean m_isAllValidData;
}