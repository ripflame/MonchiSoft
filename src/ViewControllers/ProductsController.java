/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.BaseProduct;
import Managers.BaseProductManager;
import Managers.BaseProductManagerImplementation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */
public class ProductsController implements ActionListener{
  
    //Constructor utilizado en LauncherMonchiSoft
    ProductsController(ProductsManagement productsManagementGUI, BaseProduct baseProduct) {
        this.m_productsManagementGUI = productsManagementGUI;
        this.m_baseProduct = baseProduct;
        this.m_baseProductManager = new BaseProductManagerImplementation();        
    }

    
    //Constructor utilizado en AdministratorView
    public ProductsController() {
        this.m_productsManagementGUI = new ProductsManagement ();
    }
    
    
    public void finishAndDisplayProductsManagement (){
        m_productsManagementGUI.initButtonGroup();
        addButtonGroupListener();
        initManagementComponents();
        m_productsManagementGUI.setVisible(true);
    }

     
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String optionSelected = e.getActionCommand();
        
        if (optionSelected.equalsIgnoreCase(m_productsManagementGUI.BASE_PRODUCT_COMMAND)){
            this.m_productsManagementGUI.addActionsListener(m_baseProductManagementComponents);
        } else if (optionSelected.equalsIgnoreCase(m_productsManagementGUI.OTHER_PRODUCT_COMMAND)){
            m_baseProductManagementComponents.getModelTable();
        } else if (optionSelected.equalsIgnoreCase(m_productsManagementGUI.TOPPING_COMMAND)){
            m_baseProductManagementComponents.getModelTable();        
        } else {JOptionPane.showMessageDialog(null,"Ha ocurrido un evento que no se ha considerado");}
   
    }
    
    
    private void setBaseProductManagementComponents() {
        this.m_baseProductManagementComponents = new BaseProductManagementComponents();
    }
    
    
    private void setToppingManagementComponents() {
        this.m_toppingManagementComponents = new ToppingManagementComponents();
    }
    
    
    private void setOtherProductManagementComponents() {
        this.m_otherProductManagementComponents = new OtherProductManagementComponents();
    }
    
    
    private void initManagementComponents(){
        setBaseProductManagementComponents();
        setToppingManagementComponents();
        setOtherProductManagementComponents();
        
        m_baseProductTableModel = m_baseProductManagementComponents.getModelTable();
        m_productsManagementGUI.productsTable.setModel(m_baseProductTableModel);
    }
    
    
    private void addButtonGroupListener(){
        m_productsManagementGUI.baseProductRadioButton.addActionListener(this);
        m_productsManagementGUI.toppingRadioButton.addActionListener(this);
        m_productsManagementGUI.otherProductRadioButton.addActionListener(this);
    }

    
    private ProductsManagement m_productsManagementGUI;
    private BaseProduct m_baseProduct;
    private BaseProductManager m_baseProductManager;
    
    private BaseProductManagementComponents m_baseProductManagementComponents;
    private ManagementComponents m_otherProductManagementComponents;
    private ManagementComponents m_toppingManagementComponents;
    private DefaultTableModel m_baseProductTableModel;
    private DefaultTableModel m_toppingTableModel;
    private DefaultTableModel m_otherProductTableModel;
}
