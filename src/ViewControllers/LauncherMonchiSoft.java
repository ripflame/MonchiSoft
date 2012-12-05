/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

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
        ProductsManagementController productsController = 
                new ProductsManagementController(productsManagementGUI);
        productsController.EndCreateAndDisplayProductsManagement();
    }

}
