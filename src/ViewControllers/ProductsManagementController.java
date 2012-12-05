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
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */
public class ProductsManagementController implements ActionListener{
  
    //Constructor utilizado en LauncherMonchiSoft
    ProductsManagementController(ProductsManagement productsManagementGUI) {
        this.m_productsManagementGUI = productsManagementGUI;
        initBaseProductManagementController();
        initToppingManagementController();
        initOtherProductManagementController();
    }

    
    //Constructor utilizado en AdministratorView
    public ProductsManagementController() {
        this.m_productsManagementGUI = new ProductsManagement ();
        initBaseProductManagementController();
        initToppingManagementController();
        initOtherProductManagementController();
    }
    
     
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String optionSelected = e.getActionCommand();
        
        if (optionSelected.equalsIgnoreCase(BASE_PRODUCT_OPTION)){
            this.m_productsManagementGUI.addActionsListener(m_baseProductManagementController);
            this.m_baseProductManagementController.performDisplayProcedures();
        } else if (optionSelected.equalsIgnoreCase(TOPPING_OPTION)){
            this.m_productsManagementGUI.addActionsListener(m_toppingManagementController);
            m_toppingManagementController.performDisplayProcedures();
        } else if (optionSelected.equalsIgnoreCase(OTHER_PRODUCT_OPTION)){
            this.m_productsManagementGUI.addActionsListener(m_otherProductManagementController);
            this.m_otherProductManagementController.performDisplayProcedures();
        } else {}
   
        this.m_productsManagementGUI.enableNewButton();
    }
    
    
    private void initBaseProductManagementController() {
        BaseProduct baseProduct = new BaseProduct();
        BaseProductManager baseProductManager = 
                new BaseProductManagerImplementation(); 
        this.m_baseProductManagementController = new BaseProductManagementController
                (baseProduct, baseProductManager, m_productsManagementGUI.productsTable);
        
    }
    
    
    private void initToppingManagementController() {
        Topping topping = new Topping();
        ToppingManager toppingManager = new ToppingManagerImplementation();
        this.m_toppingManagementController = 
                new ToppingManagementController(topping, toppingManager);
    }
    
    
    private void initOtherProductManagementController() {
        OtherProduct otherProduct = new OtherProduct();
        OtherProductManager otherProductManager = 
                new OtherProductManagerImplementation();
        this.m_otherProductManagementController = 
                new OtherProductManagementController(otherProduct, otherProductManager);
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

}
