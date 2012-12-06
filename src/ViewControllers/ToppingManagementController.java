/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.Topping;
import Managers.ToppingManager;
import java.util.Iterator;
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
 
    
    public static ToppingManagementController getInstance(
            ToppingManager toppingManager, ProductsManagement productsModule) {
        m_toppingManager = toppingManager;
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
        this.m_captureWindow.setFirstPriceText(EXTRA_PRICE_FIELD_LABEL);
        this.m_captureWindow.setSecondPriceText(STRING_NULL);
        this.m_captureWindow.setThirdPriceText(STRING_NULL);
        this.m_captureWindow.disableSecondPriceText();
        this.m_captureWindow.disableThirdPriceText();
        this.m_captureWindow.setVisible(true); 
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
        int rowSelected = m_productsModule.getSelectedRowNum();
        Object nameSelected = this.m_toppingTableModel.getValueAt(rowSelected, 0);
        List listProducts = m_toppingManager.searchByExactName(nameSelected.toString());
        Iterator<Topping> iterator = listProducts.iterator();
        m_topping = new Topping ();
        Topping m_topping = (Topping) iterator.next();
        boolean isSucces = false;
        try {
            m_toppingManager.remove(m_topping);
            isSucces = true;
        }catch(Exception e){}
        if (isSucces) {
            this.m_toppingTableModel.removeRow(rowSelected);
            m_productsModule.disableRemoveButton();
            m_productsModule.disableModifyButton();
        }
    }
     
     
    @Override
    public void performDisplayProcedures() {
        m_productsTable = m_productsModule.productsTable;
        this.setProductsTableModel();
        List listToppings = this.getToppings();
        this.updateTableModel(listToppings);
        m_productsTable.setModel(m_toppingTableModel);
    }
    
    
    @Override
    public void closeCaptureWindow(){
        m_productsModule.setEnabled(true);
        m_captureWindow.dispose();
        m_productsModule.enableNewButton();
    }

    
    @Override
    public void setProductsTableModel(){       
        m_toppingTableModel = buildTableModel(TOPPING_COLUMN_TITLES);
    }
    
    
    private List getToppings() {
        List toppings = m_toppingManager.getAll();
        return toppings;
    }
    
    
    private void updateTableModel (List toppings){
        Iterator<Topping> iterator = toppings.iterator();
	
        while (iterator.hasNext()) {
            int columnNum = FIRST;
            Topping m_topping = (Topping) iterator.next();
            String toppingData[] = new String[ELEMENTS_TOTAL];
            toppingData[columnNum] = m_topping.getName();
            toppingData[++columnNum] = String.valueOf(m_topping.getPrice());
            this.m_toppingTableModel.addRow(toppingData);
        }
      
    }
    
    private static final String NAME_FIELD_LABEL = "Nombre";
    private static final String EXTRA_PRICE_FIELD_LABEL = "Precio de Extra";
    public static final String[] TOPPING_COLUMN_TITLES = {NAME_FIELD_LABEL, EXTRA_PRICE_FIELD_LABEL};
    private static final int FIRST = 0;
    private static final int ELEMENTS_TOTAL = TOPPING_COLUMN_TITLES.length;
    private static final String TITLE_LABEL = "Topping";
    private static Topping m_topping;
    private static ToppingManager m_toppingManager;
    private static JTable m_productsTable;
    private DefaultTableModel m_toppingTableModel;
    private CaptureProductData m_captureWindow;
    private static ProductsManagement m_productsModule;
}
