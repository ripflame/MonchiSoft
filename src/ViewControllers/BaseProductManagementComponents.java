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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */
public class BaseProductManagementComponents extends ManagementComponents{

    public BaseProductManagementComponents() throws HeadlessException {
        
    } 

    @Override
    public void displayCaptureView() {
        JOptionPane.showMessageDialog(null,"Aquí se mostrará la ventana para capturar productos base");
    }

    public List getProducts() {
        BaseProductManager baseProductManager = new BaseProductManagerImplementation();
        List products = baseProductManager.getAll();
        
        return products;
    }
    
    @Override
    public DefaultTableModel getModelTable() {
        
        
        DefaultTableModel model = new DefaultTableModel() {
          @Override
          public boolean isCellEditable(int row, int column) {
              return false;
          }
        };
        
        String[] columnNames = new String[4];
        columnNames[0] = "Nombre";
        columnNames[1] = "Precio chico";
        columnNames[2] = "Precio mediano";
        columnNames[3] = "Precio grande";
        model.setColumnIdentifiers(columnNames);
        
        List products = this.getProducts();
        
        if (products == null) {
           
            MessageDisplayManger.showInformation(MessageType.NO_COSTUMER_FOUND, this );
            return model;
        }
        else{
        String[] productData = new String[4];
        Iterator<BaseProduct> iterator = products.iterator();
        while (iterator.hasNext()) {
            BaseProduct product = (BaseProduct)iterator.next();
            productData[0] = product.getName();
            productData[1] = Double.toString(product.getSmallPrice());
            productData[2] = Double.toString(product.getMediumPrice());
            productData[3] = Double.toString(product.getLargePrice());
            model.addRow(productData);
        }
        
        
        return model;
        
        }
        
        
    }
    
    private DefaultTableModel createTableModel() {
        DefaultTableModel model = new DefaultTableModel() {
          @Override
          public boolean isCellEditable(int row, int column) {
              return false;
          }
        };
        
        String[] columnNames = new String[3];
        columnNames[0] = "Id";
        columnNames[1] = "Nombre";
        columnNames[2] = "Precio chico";
        columnNames[2] = "Precio mediano";
        model.setColumnIdentifiers(columnNames);
        
        return model;
    }
    
}
