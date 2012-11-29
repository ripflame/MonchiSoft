/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import javax.swing.JOptionPane;

/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */
public class BaseProductManagementComponents extends ManagementComponents{

    @Override
    public void displayCaptureView() {
        JOptionPane.showMessageDialog(null,"Aquí se mostrará la ventana para capturar productos base");
    }

    @Override
    public void displayProductsTable() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
