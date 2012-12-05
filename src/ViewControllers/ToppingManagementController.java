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
 
    
    public static ToppingManagementController getInstance(Topping topping, 
            ToppingManager toppingManager, JTable productsTable) {
        m_topping = topping;
        m_toppingManager = toppingManager;
        m_productsTable = productsTable;
        return SingletonHolder.INSTANCE;
    }
      

    @Override
    public void createAndDisplayCaptureWindow() {
        CaptureProductData captureWindow = new CaptureProductData(this);
        captureWindow.setVisible(true);
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
        this.setProductsTableModel();
        List listToppings = this.getToppings();
        this.updateTableModel(listToppings);
        m_productsTable.setModel(m_toppingTableModel);
    }

    
    @Override
    public void performSearchingProcedures() {
        throw new UnsupportedOperationException("Not supported yet.");
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
    
    public final String[] TOPPING_COLUMN_TITLES = {"Nombre","Precio de Extra"};
    private final int FIRST = 0;
    private final int ELEMENTS_TOTAL = TOPPING_COLUMN_TITLES.length;
    private static Topping m_topping;
    private static ToppingManager m_toppingManager;
    private static JTable m_productsTable;
    private DefaultTableModel m_toppingTableModel;
}
