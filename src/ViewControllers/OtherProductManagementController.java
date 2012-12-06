/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.OtherProduct;
import Helpers.DataCheckerImplementation;
import Helpers.MessageDisplayManager;
import Helpers.MessageType;
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
    public void buildCaptureModifyWindow(){
        int rowSelected = this.getRowAndProductSelected();
        this.m_captureWindow = new CaptureProductData(this);
        this.m_captureWindow.addActionsListener(this);
        this.m_captureWindow.changeButton();
        this.m_captureWindow.setNameText(this.m_otherProduct.getName());
        this.m_captureWindow.setFirstPriceText(String.valueOf(this.m_otherProduct.getPrice()));

        this.m_captureWindow.setLocationRelativeTo(m_productsModule);
        m_productsModule.setEnabled(false);
        this.m_captureWindow.setTitleLabel(TITLE_LABEL);
        this.m_captureWindow.setFirstPriceText(PRICE_FIELD_LABEL);
        this.m_captureWindow.setSecondPriceText(STRING_NULL);
        this.m_captureWindow.setThirdPriceText(STRING_NULL);
        this.m_captureWindow.setVisible(true);
    }
    
    private int getRowAndProductSelected (){
        int rowSelected = m_productsModule.getSelectedRowNum();
        Object nameSelected = this.m_otherProductTableModel.getValueAt(rowSelected, 0);
        List listProducts = m_otherProductManager.searchByExactName(nameSelected.toString());
        Iterator<OtherProduct> iterator = listProducts.iterator();
        this.m_otherProduct = new OtherProduct ();
        this.m_otherProduct = (OtherProduct) iterator.next();
        return rowSelected;
    } 
     
    @Override    
    public void performModificationProcedures() {      
        int idProduct = this.m_otherProduct.getId();
        String[] otherProductData = new String [ELEMENTS_TOTAL];
        otherProductData = getAndAuditDataCaptured();
        if (m_isAllValidData){
            setOtherProductData(otherProductData);
            m_otherProductManager.modify(m_otherProduct);
            performDisplayProcedures();
            m_productsModule.setEnabled(true);
            m_captureWindow.dispose();
            m_productsModule.enableNewButton();
        } else {
            MessageDisplayManager.showInformation(MessageType.INVALID_DATA, m_captureWindow);
        }
          
    }


    
    @Override
    public void performAddingProcedures() {
        String[] otherProductData = new String [ELEMENTS_TOTAL];
        otherProductData = getAndAuditDataCaptured();
        if (m_isAllValidData){
            setOtherProductData(otherProductData);
            boolean isSucces = false;
            if ( !exists( m_otherProduct.getName() ) ){
                try {
                     m_otherProductManager.add( m_otherProduct );
                     isSucces = true;
                }catch(Exception e){
                    isSucces = false;}
                
            if (isSucces){
                    m_otherProductTableModel.addRow(otherProductData);
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
    
    private String[] getAndAuditDataCaptured (){
         
         String name = this.m_captureWindow.getNameText();
         String price = this.m_captureWindow.getFirstPriceText();
         
         this.m_dataChecker = new DataCheckerImplementation();
         
         if (m_dataChecker.isNullString ( name )){
             m_isAllValidData = false;
             MessageDisplayManager.showInformation(MessageType.EMPTY_FIELDS, m_captureWindow);
             
         } else {
             if ( m_dataChecker.isNum( name ) ){
                 m_isAllValidData = false;  
                 MessageDisplayManager.showInformation(MessageType.REQUIRED_TEXT, m_captureWindow);
             } else {
                 if (  m_dataChecker.isNum( price ) ) {
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
         data [++elementNum] = price;
        
         return data;
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
    
    
    private void setOtherProductData (String[] productData){
         int dataNum = FIRST;
         this.m_otherProduct = new OtherProduct();
         this.m_otherProduct.setName(productData[dataNum]);
         this.m_otherProduct.setPrice(Double.parseDouble(productData[++dataNum]));
     }
    
    private boolean exists(String textData){
        List listProducts = m_otherProductManager.searchByExactName(textData);
        if (listProducts.isEmpty()){
            return false;            
        } else {
            MessageDisplayManager.showInformation(MessageType.PRODUCT_EXISTS, m_captureWindow);
            return true;
        }
    }

    private static final String NAME_FIELD_LABEL = "Nombre";
    private static final String PRICE_FIELD_LABEL = "Precio";
    private static final String[] OTHER_PRODUCT_COLUMN_TITLES = {NAME_FIELD_LABEL, PRICE_FIELD_LABEL};
    private static final int FIRST = 0;
    private static final int ELEMENTS_TOTAL = OTHER_PRODUCT_COLUMN_TITLES.length;
    private static final String TITLE_LABEL = "Otro tipo de producto";
    private OtherProduct m_otherProduct;
    private static OtherProductManager m_otherProductManager;
    private static JTable m_productsTable;
    private DefaultTableModel m_otherProductTableModel;
    private CaptureProductData m_captureWindow;
    private static ProductsManagement m_productsModule;
    
    private DataCheckerImplementation m_dataChecker;
    private boolean m_isAllValidData;
}
