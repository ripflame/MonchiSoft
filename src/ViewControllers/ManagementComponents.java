/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import java.awt.HeadlessException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */
public abstract class ManagementComponents extends javax.swing.JFrame{

    public ManagementComponents() throws HeadlessException {
            
   }                      
    
    //public abstract void 
    public abstract DefaultTableModel getModelTable ();
    public abstract void displayCaptureView ();
    
}
