package Tests;

import Entities.BaseProduct;
import Entities.Customer;
import Entities.DailyCashClosing;
import Entities.Expense;
import Entities.FinalProduct;
import Entities.FinalProductToppings;
import Entities.FinalProductToppingsId;
import Entities.OtherProduct;
import Entities.Sale;
import Entities.SaleFinalProducts;
import Entities.SaleFinalProductsId;
import Entities.Topping;
import Managers.BaseProductManager;
import Managers.BaseProductManagerImplementation;
import Managers.CustomerManager;
import Managers.CustomerManagerImplementation;
import Managers.DailyCashClosingManager;
import Managers.DailyCashClosingManagerImplementation;
import Managers.ExpenseManager;
import Managers.ExpenseManagerImplementation;
import Managers.FinalProductManager;
import Managers.FinalProductManagerImplementation;
import Managers.FinalProductToppingsManager;
import Managers.FinalProductToppingsManagerImplementation;
import Managers.OtherProductManager;
import Managers.OtherProductManagerImplementation;
import Managers.SaleFinalProductsManager;
import Managers.SaleFinalProductsManagerImplementation;
import Managers.SaleManager;
import Managers.SaleManagerImplementation;
import Managers.ToppingManager;
import Managers.ToppingManagerImplementation;
import java.util.Iterator;
import java.util.List;

/**
 * Esta clase solo existe para hacer pruebas y no se está aplicando nada de
 * construcción y evolución.
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
        
        CustomerManager clientManager = new CustomerManagerImplementation();
        List<Customer> clients = clientManager.getAll();
        Iterator<Customer> clientIterator = clients.iterator();
        System.out.println("List of clients:");
        while (clientIterator.hasNext()) {
            Customer temporalClient = clientIterator.next();
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
        List<Expense> expenses = expenseManager.searchBySupplier("walmart");
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
        
        FinalProductToppingsManager fptm = new FinalProductToppingsManagerImplementation();
        
//        FinalProductToppingsId prueba1 = new FinalProductToppingsId(12, 2);
//        FinalProductToppings prueba2 = new FinalProductToppings(prueba1);
//        fptm.add(prueba2);
        
        List<FinalProductToppings> products = fptm.getAll();
        System.out.println("Final product toppings: ");
        Iterator<FinalProductToppings> fptmIterator = products.iterator();
        while (fptmIterator.hasNext()) {
            FinalProductToppings tempFPT = fptmIterator.next();
            FinalProductToppingsId temp = tempFPT.getId();
            System.out.println("FPId: " + temp.getFinalProductId());
            System.out.println("TOPID: " + temp.getToppingId());
        }
        
        SaleFinalProductsManager sfpm = new SaleFinalProductsManagerImplementation();
        
        List<SaleFinalProducts> prods = sfpm.getAll();
        System.out.println("Sale Final Products: ");
        Iterator<SaleFinalProducts> sfpIterator = prods.iterator();
        while (sfpIterator.hasNext()) {
            SaleFinalProducts temp1 = sfpIterator.next();
            SaleFinalProductsId temp = temp1.getId();
            System.out.println("SFPID: " + temp.getFinalProductsId());
            System.out.println("SID: " + temp.getSaleId());
        }
    }
}
