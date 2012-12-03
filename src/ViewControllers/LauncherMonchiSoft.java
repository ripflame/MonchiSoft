/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;
import Entities.*;

/**
 *
 * @author Ileana Guadalupe Ontiveros Mena
 */
public class LauncherMonchiSoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initProductsModule();
        
        
    }

    static void initProductsModule(){
        ProductsManagement productsManagementGUI = new ProductsManagement ();
        BaseProduct baseProduct = new BaseProduct();
        ProductsController productsController = new ProductsController(productsManagementGUI, baseProduct);
        productsController.DisplayProductsManagement();
    }

}
