package Helpers;

/**
 *
 * @author Gilberto Leon <ripflame@gmail.com>
 */
public class QueryConstants {
    
    public static final String CUSTOMER_QUERY_NAME = "from Customer c where c.name like '";
    public static final String CUSTOMER_QUERY_ID = "from Customer c where c.id like '";
    
    public static final String BASE_PRODUCT_QUERY_NAME = "from BaseProduct bp where bp.name like '";
    public static final String BASE_PRODUCT_QUERY_ID = "from BaseProduct bp where bp.id like '";
    
    public static final String OTHER_PRODUCT_QUERY_NAME = "from OtherProduct op where op.name like '";
    public static final String OTHER_PRODUCT_QUERY_ID = "from OtherProduct op where op.id like '";
    
    public static final String TOPPING_QUERY_NAME = "from Topping t where t.name like '";
    public static final String TOPPING_QUERY_ID = "from Topping t where t.id like '";
    
    public static final String DAILY_CASH_CLOSING_QUERY_ID = "from DailyCashClosing dcc where dcc.id like '";
    
    public static final String EXPENSE_QUERY_ID = "from Expense e where e.id like '";
    public static final String EXPENSE_QUERY_SUPPLIER = "from Expense e where e.supplier like '";
    
    public static final String FINAL_PRODUCT_QUERY_ID = "from FinalProduct fp where fp.id like '";
    
    public static final String SALE_QUERY_ID = "from Sale s where s.id like '";
    
    public static final String SIMILAR_TERMINATION_CHARACTER = "%'";
    public static final String TERMINATION_CHARACTER = "'";

}
