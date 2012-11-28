/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.Expense;
import Managers.ExpenseManager;
import Managers.ExpenseManagerImplementation;
import javax.swing.JOptionPane;

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
        this.supplierField.setText(this.modifiedExpense.getSupplier());
        this.descriptionField.setText(this.modifiedExpense.getDescription());
        this.totalField.setText(Double.toString(this.modifiedExpense.getTotal()));
        this.dateField.setDate(this.modifiedExpense.getDate());
        
    }
   
   private void setAddText() {
        this.setTitle("Agregar");
        this.saveButton.setText("Agregar");
    }
   
   private void setModifyText() {
        this.setTitle("Modificar");
        this.saveButton.setText("Modificar");
    }
   
   private void addExpense() {
        double total= Double.parseDouble(this.totalField.getText());
        if (this.validData()) {
            
            
            ExpenseManager expenseManager = new ExpenseManagerImplementation();
            Expense expense = new Expense(this.dateField.getDate(), this.supplierField.getText(),
                                           this.descriptionField.getText(), total
                                          );
            expenseManager.add(expense);
            this.dispose();
        } else {
            this.showErrorView();
        }
    }
   
   private void modifyExpense(Expense expense) {
       //java.util.Date utilDate = ;

      double total= Double.parseDouble(this.totalField.getText());
        if (this.validData()) {
            Expense modifiedExpense = expense;
            ExpenseManager expenseManager = new ExpenseManagerImplementation();
            modifiedExpense.setSupplier(this.supplierField.getText());
            modifiedExpense.setDescription(this.descriptionField.getText());
            modifiedExpense.setTotal(total);
            modifiedExpense.setDate(this.dateField.getDate());
            
            expenseManager.modify(modifiedExpense);
            ((ExpensesView)this.getParent()).showAllExpenses();
            this.dispose();
        } else {
            this.showErrorView();
        }
    }
   
   private void showErrorView() {
        JOptionPane.showConfirmDialog(this,
                "No todos los campos están llenos.",
                "Oops!",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
    }
   
   private boolean validData() {
        boolean correctData = true;
        if (this.supplierField.getText().isEmpty()) {
            if(this.DescriptionLabel.getText().isEmpty())
                if(this.TotalLabel.getText().isEmpty())
                    if(this.DateLabel.getText().isEmpty())
                
            
            correctData = false;
        }else{
             //correctData= true;
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

        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        totalField = new javax.swing.JTextField();
        DateLabel = new javax.swing.JLabel();
        TotalLabel = new javax.swing.JLabel();
        DescriptionLabel = new javax.swing.JLabel();
        supplierLabel = new javax.swing.JLabel();
        descriptionField = new javax.swing.JTextField();
        supplierField = new javax.swing.JTextField();
        dateField = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cancelButton.setText("Cancelar");

        saveButton.setText("Guardar");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        DateLabel.setText("Fecha:");

        TotalLabel.setText("Total:");

        DescriptionLabel.setText("Descripción:");

        supplierLabel.setText("Vendedor:");

        descriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionFieldActionPerformed(evt);
            }
        });

        supplierField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(supplierLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DescriptionLabel)
                            .addComponent(TotalLabel)
                            .addComponent(DateLabel))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalField, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(descriptionField)
                            .addComponent(supplierField)
                            .addComponent(dateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(saveButton)
                        .addGap(31, 31, 31)
                        .addComponent(cancelButton)
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(supplierLabel)
                    .addComponent(supplierField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DescriptionLabel)
                    .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalLabel)
                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(DateLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (this.isAddButton) {
            this.addExpense();
        } else {
            this.modifyExpense(this.modifiedExpense);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void descriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionFieldActionPerformed

    private void supplierFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierFieldActionPerformed

    
    
    
    
    private Expense modifiedExpense;
    private boolean isAddButton;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JButton cancelButton;
    private com.toedter.calendar.JDateChooser dateField;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField supplierField;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JTextField totalField;
    // End of variables declaration//GEN-END:variables
}