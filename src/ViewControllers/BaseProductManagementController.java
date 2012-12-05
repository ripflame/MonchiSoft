/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.BaseProduct;
import Helpers.MessageDisplayManger;
import Helpers.MessageType;
import Managers.BaseProductManager;
import Managers.BaseProductManagerImplementation;
import java.awt.HeadlessException;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */
public class BaseProductManagementController extends ManagementController{
    
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
            BaseProductManager baseProductManager, JTable productsTable) {
        m_baseProduct = baseProduct;
        m_baseProductManager = baseProductManager;
        m_productsTable = productsTable;
        return SingletonHolder.INSTANCE;
    }


    @Override
    public void displayCaptureView() {
        JOptionPane.showMessageDialog(null,"Aquí se mostrará la ventana para "
                + "capturar productos base");
    }

    
    public List getBaseProducts() {
        List products = m_baseProductManager.getAll();
        return products;
    }
    
    
    public void metodo (List productosBase){
        Iterator<BaseProduct> iterator = productosBase.iterator();
	
        while (iterator.hasNext()) {
            BaseProduct m_baseProduct = (BaseProduct) iterator.next();
            String baseProductData[] = new String[4];
            baseProductData[0] = m_baseProduct.getName();
            baseProductData[1] = String.valueOf(m_baseProduct.getSmallPrice());
            baseProductData[2] = String.valueOf(m_baseProduct.getMediumPrice());
            baseProductData[3] = String.valueOf(m_baseProduct.getLargePrice());
            this.m_baseProductTableModel.addRow(baseProductData);
        }
        
        
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
        List lista = this.getBaseProducts();
        this.metodo(lista);
        this.m_productsTable.setModel(m_baseProductTableModel);

       
    }
    
    
    @Override
    public void performSearchingProcedures() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    @Override
    public void setProductsTableModel(){       
        m_baseProductTableModel = buildTableModel(BASE_PRODUCT_COLUMN_TITLES);
    }
    
    public final String[] BASE_PRODUCT_COLUMN_TITLES = {"Nombre","Precio: Chico",
        "Precio: Mediano","Precio: Grande"}; 
    private static BaseProduct m_baseProduct;
    private static BaseProductManager m_baseProductManager;
    private static JTable m_productsTable;
    private DefaultTableModel m_baseProductTableModel;
    
}