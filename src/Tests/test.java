/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Entities.BaseProduct;
import Entities.Costumer;
import Entities.DailyCashClosing;
import Entities.Expense;
import Entities.FinalProduct;
import Entities.OtherProduct;
import Entities.Sale;
import Entities.Topping;
import Managers.BaseProductManager;
import Managers.BaseProductManagerImplementation;
import Managers.ClientManager;
import Managers.ClientManagerImplementation;
import Managers.DailyCashClosingManager;
import Managers.DailyCashClosingManagerImplementation;
import Managers.ExpenseManager;
import Managers.ExpenseManagerImplementation;
import Managers.FinalProductManager;
import Managers.FinalProductManagerImplementation;
import Managers.OtherProductManager;
import Managers.OtherProductManagerImplementation;
import Managers.SaleManager;
import Managers.SaleManagerImplementation;
import Managers.ToppingManager;
import Managers.ToppingManagerImplementation;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BaseProductManager baseProductManager = new BaseProductManagerImplementation();
        List<BaseProduct> baseProducts = baseProductManager.getAll();
        System.out.println("List of Base Products:");
        Iterator<BaseProduct> baseProductIterator = baseProducts.iterator();
        while (baseProductIterator.hasNext()) {
            BaseProduct temporalProduct = baseProductIterator.next();
            System.out.println("Product: " + temporalProduct.getName());
        }
        
        ClientManager clientManager = new ClientManagerImplementation();
        List<Costumer> clients = clientManager.getAll();
        Iterator<Costumer> clientIterator = clients.iterator();
        System.out.println("List of clients:");
        while (clientIterator.hasNext()) {
            Costumer temporalClient = clientIterator.next();
            System.out.println("Name: " + temporalClient.getName());
        }
        
        DailyCashClosingManager dCManager = new DailyCashClosingManagerImplementation();
        List<DailyCashClosing> dCCS = dCManager.getAll();
        System.out.println("List of DCC's:");
        Iterator<DailyCashClosing> dccIterator = dCCS.iterator();
        while (dccIterator.hasNext()) {
            DailyCashClosing temporalDCC = dccIterator.next();
            System.out.println("DCC date: " + temporalDCC.getDateEnd());
        }
        
        ExpenseManager expenseManager = new ExpenseManagerImplementation();
        List<Expense> expenses = expenseManager.getAll();
        System.out.println("Expenses: ");
        Iterator<Expense> expensesIterator = expenses.iterator();
        while (expensesIterator.hasNext()) {
            Expense temporalExpense = expensesIterator.next();
            System.out.println("Supplier: " + temporalExpense.getSupplier());
        }
        
        FinalProductManager fpManager = new FinalProductManagerImplementation();
        List<FinalProduct> finalProducts = fpManager.getAll();
        System.out.println("Final Products: ");
        Iterator<FinalProduct> fpIterator = finalProducts.iterator();
        while (fpIterator.hasNext()) {
            FinalProduct temporalFP = fpIterator.next();
            System.out.println("Final Product ID: " + temporalFP.getId());
        }
        
        OtherProductManager opManager = new OtherProductManagerImplementation();
        List<OtherProduct> otherProducts = opManager.getAll();
        System.out.println("Other products:");
        Iterator<OtherProduct> opIterator = otherProducts.iterator();
        while (opIterator.hasNext()) {
            OtherProduct temp = opIterator.next();
            System.out.println("Name: " + temp.getName());
        }
        
        SaleManager saleManager = new SaleManagerImplementation();
        List<Sale> sales = saleManager.getAll();
        System.out.println("Sales:");
        Iterator<Sale> salesIterator = sales.iterator();
        while (salesIterator.hasNext()) {
            Sale temp = salesIterator.next();
            System.out.println("Date: " + temp.getDate());
        }
        
        ToppingManager topManager = new ToppingManagerImplementation();
        List<Topping> toppings = topManager.getAll();
        System.out.println("Toppings:");
        Iterator<Topping> topsIterator = toppings.iterator();
        while (topsIterator.hasNext()) {
            Topping temp = topsIterator.next();
            System.out.println("Name: " + temp.getName());
        }
    }
}
