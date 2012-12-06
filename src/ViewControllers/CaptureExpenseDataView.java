
package ViewControllers;

import Entities.Expense;
import Helpers.MessageDisplayManger;
import Helpers.MessageType;
import Managers.ExpenseManager;
import Managers.ExpenseManagerImplementation;

/**
 *
 * @author Ivan
 */
public class CaptureExpenseDataView extends javax.swing.JDialog {
    

    /**
     * Creates new form CaptureExpenseDataView
     */
    public CaptureExpenseDataView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.isAddButton = true;
        this.setAddText();
    }
    
    public CaptureExpenseDataView(java.awt.Frame parent, boolean modal, Expense modifiedExpense) {
        super(parent, modal);
        initComponents();
        
        this.isAddButton = false;
        this.setModifyText();
        this.modifiedExpense = modifiedExpense;
        this.m_supplierField.setText(this.modifiedExpense.getSupplier());
        this.m_descriptionField.setText(this.modifiedExpense.getDescription());
        this.m_totalField.setText(Double.toString(this.modifiedExpense.getTotal()));
        this.m_dateField.setDate(this.modifiedExpense.getDate());
        
   }
   
   private void setAddText() {
        this.setTitle("Agregar gasto");
        this.m_saveButton.setText("Agregar");
    }
   
   private void setModifyText() {
        this.setTitle("Modificar gasto");
        this.m_saveButton.setText("Modificar");
    }
   
   private void addExpense() {
        double total= Double.parseDouble(this.m_totalField.getText());
        if (this.validData()) {
            ExpenseManager expenseManager = new ExpenseManagerImplementation();
            Expense expense = new Expense(this.m_dateField.getDate(), 
                                          this.m_supplierField.getText(),
                                          this.m_descriptionField.getText(), 
                                          total
                                          );
            expenseManager.add(expense);
            this.dispose();
        } else {
            MessageDisplayManger.showInformation(MessageType.EMPTY_FIELDS, this );
        }
    }
   
   private void modifyExpense(Expense expense) {  
        if (this.validData()) {
            ExpenseManager expenseManager = new ExpenseManagerImplementation();
            modifiedExpense= this.modifyDataExpense(expense);
            expenseManager.modify(modifiedExpense);
            ((ExpensesView)this.getParent()).showAllExpenses();
            this.dispose();
        } else {
            MessageDisplayManger.showInformation(MessageType.EMPTY_FIELDS, this );
        }
    }
   
   public Expense modifyDataExpense(Expense expense){
       double total= Double.parseDouble(this.m_totalField.getText());
       Expense modifiedExpense = expense;
       modifiedExpense.setSupplier(this.m_supplierField.getText());
            modifiedExpense.setDescription(this.m_descriptionField.getText());
            modifiedExpense.setTotal(total);
            modifiedExpense.setDate(this.m_dateField.getDate());
       
       return modifiedExpense;
   }
   
   
   
   private boolean validData() {
        boolean correctData = true;
        if (this.m_supplierField.getText().isEmpty()) {
            if(this.m_descriptionLabel.getText().isEmpty())
                if(this.m_totalLabel.getText().isEmpty())
                    if(this.m_dateLabel.getText().isEmpty())
                         correctData = false;
        }else{
            
        }
        return correctData;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        m_cancelButton = new javax.swing.JButton();
        m_saveButton = new javax.swing.JButton();
        m_totalField = new javax.swing.JTextField();
        m_dateLabel = new javax.swing.JLabel();
        m_totalLabel = new javax.swing.JLabel();
        m_descriptionLabel = new javax.swing.JLabel();
        m_supplierLabel = new javax.swing.JLabel();
        m_descriptionField = new javax.swing.JTextField();
        m_supplierField = new javax.swing.JTextField();
        m_dateField = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        m_cancelButton.setText("Cancelar");
        m_cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_cancelButtonActionPerformed(evt);
            }
        });

        m_saveButton.setText("Guardar");
        m_saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_saveButtonActionPerformed(evt);
            }
        });

        m_dateLabel.setText("Fecha:");

        m_totalLabel.setText("Total:");

        m_descriptionLabel.setText("Descripción:");

        m_supplierLabel.setText("Vendedor:");

        m_descriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_descriptionFieldActionPerformed(evt);
            }
        });

        m_supplierField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_supplierFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(m_supplierLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_descriptionLabel)
                    .addComponent(m_totalLabel)
                    .addComponent(m_dateLabel))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(m_cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(m_saveButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(m_totalField, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                        .addComponent(m_descriptionField)
                        .addComponent(m_supplierField)
                        .addComponent(m_dateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(m_supplierLabel)
                    .addComponent(m_supplierField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(m_descriptionLabel)
                    .addComponent(m_descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(m_totalLabel)
                    .addComponent(m_totalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(m_dateLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(m_dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(m_saveButton)
                    .addComponent(m_cancelButton))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void m_saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_saveButtonActionPerformed
        if (this.isAddButton) {
            this.addExpense();
        } else {
            this.modifyExpense(this.modifiedExpense);
        }
    }//GEN-LAST:event_m_saveButtonActionPerformed

    private void m_descriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_descriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m_descriptionFieldActionPerformed

    private void m_supplierFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_supplierFieldActionPerformed
        
    }//GEN-LAST:event_m_supplierFieldActionPerformed
/**
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
       
    }//GEN-LAST:event_cancelButtonActionPerformed
*/
    private void m_cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_cancelButtonActionPerformed
       this.dispose();
    }//GEN-LAST:event_m_cancelButtonActionPerformed

    
    
    
    
    private Expense modifiedExpense;
    private boolean isAddButton;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton m_cancelButton;
    private com.toedter.calendar.JDateChooser m_dateField;
    private javax.swing.JLabel m_dateLabel;
    private javax.swing.JTextField m_descriptionField;
    private javax.swing.JLabel m_descriptionLabel;
    private javax.swing.JButton m_saveButton;
    private javax.swing.JTextField m_supplierField;
    private javax.swing.JLabel m_supplierLabel;
    private javax.swing.JTextField m_totalField;
    private javax.swing.JLabel m_totalLabel;
    // End of variables declaration//GEN-END:variables
}
