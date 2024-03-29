/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.BaseProduct;
import Entities.OtherProduct;
import Entities.Topping;
import Managers.BaseProductManager;
import Managers.BaseProductManagerImplementation;
import Managers.OtherProductManager;
import Managers.OtherProductManagerImplementation;
import Managers.ToppingManager;
import Managers.ToppingManagerImplementation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */
public class ProductsManagementController implements ActionListener{
  
    public ProductsManagementController() {
        this.m_productsManagementGUI = new ProductsManagement ();
    }
    
     
    @Override
    public void actionPerformed(ActionEvent e) {
        
        this.m_productsManagementGUI.removeActionsListener(m_currentListener);
        String optionSelected = e.getActionCommand();
        
        if (optionSelected.equalsIgnoreCase(BASE_PRODUCT_OPTION)){
            initBaseProductManagementController();
            this.m_currentListener = this.m_baseProductManagementController;
            this.m_baseProductManagementController.performDisplayProcedures();
        } else if (optionSelected.equalsIgnoreCase(TOPPING_OPTION)){
            initToppingManagementController();
            this.m_currentListener = this.m_toppingManagementController;
            this.m_toppingManagementController.performDisplayProcedures();
        } else if (optionSelected.equalsIgnoreCase(OTHER_PRODUCT_OPTION)){
            initOtherProductManagementController();
            this.m_currentListener = this.m_otherProductManagementController;
            this.m_otherProductManagementController.performDisplayProcedures();
        } else {}
        
        this.m_productsManagementGUI.addActionsListener(m_currentListener); 
        this.m_productsManagementGUI.enableNewButton();
    }
    
    
    private void initBaseProductManagementController() {
        BaseProduct baseProduct = new BaseProduct();
        BaseProductManager baseProductManager = 
                new BaseProductManagerImplementation(); 
        m_baseProductManagementController = 
                BaseProductManagementController.getInstance( 
                baseProductManager, m_productsManagementGUI);      
    }
    
    
    private void initToppingManagementController() {
        Topping topping = new Topping();
        ToppingManager toppingManager = new ToppingManagerImplementation();
        m_toppingManagementController = 
                ToppingManagementController.getInstance(toppingManager,
                m_productsManagementGUI);
    }
    
    
    private void initOtherProductManagementController() {
        OtherProduct otherProduct = new OtherProduct();
        OtherProductManager otherProductManager = 
                new OtherProductManagerImplementation();
        m_otherProductManagementController = 
                OtherProductManagementController.getInstance( 
                otherProductManager, m_productsManagementGUI);
    }
    
    
    public void EndCreateAndDisplayProductsManagement (){
        m_productsManagementGUI.initButtonGroup();
        m_productsManagementGUI.addButtonGroupListener(this);
        m_productsManagementGUI.setVisible(true);
    }
    
     
    private final String BASE_PRODUCT_OPTION = "Producto Base";
    private final String OTHER_PRODUCT_OPTION = "Otro Producto";
    private final String TOPPING_OPTION = "Topping";
    private ProductsManagement m_productsManagementGUI;
    private ManagementController m_baseProductManagementController;
    private ManagementController m_otherProductManagementController;
    private ManagementController m_toppingManagementController;
    private ActionListener m_currentListener;


}
