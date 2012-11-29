/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import java.awt.HeadlessException;

/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */
public abstract class ManagementComponents extends javax.swing.JFrame{

    public ManagementComponents() throws HeadlessException {
    }
    
    
    public abstract void displayCaptureView ();
    public abstract void displayProductsTable ();
    
        
    private javax.swing.JTable _productsTable;
    private javax.swing.JFrame _captureFrame;
       
}
