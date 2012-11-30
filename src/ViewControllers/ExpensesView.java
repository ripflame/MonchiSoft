/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;


import Entities.Expense;
import Helpers.MessageDisplayManger;
import Managers.ExpenseManager;
import Managers.ExpenseManagerImplementation;
import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan
 */
public class ExpensesView extends javax.swing.JFrame {

    /**
     * Creates new form ExpensesView
     */
    public ExpensesView() {
        initComponents();
        //setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        expensesTable = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        newButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(180, 0), new java.awt.Dimension(180, 0), new java.awt.Dimension(180, 0));
        showAllButton = new javax.swing.JButton();
        searchField = new java.awt.TextField();
        SearchButton = new java.awt.Button();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        expensesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Vendedor", "Descripcion", "Total", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(expensesTable);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        newButton.setText("Nuevo");
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(newButton);

        removeButton.setFocusable(false);
        removeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeButton.setLabel("Eliminar");
        removeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(removeButton);

        modifyButton.setText("Modificar");
        modifyButton.setFocusable(false);
        modifyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modifyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(modifyButton);
        jToolBar1.add(filler1);

        showAllButton.setText("Mostrar todos");
        showAllButton.setFocusable(false);
        showAllButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        showAllButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        showAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(showAllButton);

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        SearchButton.setActionCommand("");
        SearchButton.setLabel("Buscar");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        CaptureExpenseDataView addExpenseView = new CaptureExpenseDataView(this, true);
        addExpenseView.setLocationRelativeTo(this);
        addExpenseView.setVisible(true);
    }//GEN-LAST:event_newButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        
        int selectedRow = this.expensesTable.getSelectedRow(); 
        if (selectedRow > -1) {
            int idExpense = Integer.parseInt((String) this.expensesTable.getValueAt(selectedRow, 0));
            String expenseSupplier = (String) this.expensesTable.getValueAt(selectedRow, 1);
            String expenseDescription = (String) this.expensesTable.getValueAt(selectedRow, 2);
            Double expenseTotal = Double.parseDouble((String)this.expensesTable.getValueAt(selectedRow, 3));
            Date expenseDate = Date.valueOf((String) this.expensesTable.getValueAt(selectedRow, 4));
            Expense selectedExpense = new Expense(expenseDate, expenseSupplier, expenseDescription, expenseTotal);
            selectedExpense.setId(idExpense);
            ExpenseManager expenseManager = new ExpenseManagerImplementation();
            expenseManager.remove(selectedExpense);
            this.showAllExpenses();
        } else if (selectedRow == -1) {
            
            this.showMessage("No seleccionaste ninguna celda.");
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void showAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllButtonActionPerformed
        this.searchField.setText("");
        this.showAllExpenses();
    }//GEN-LAST:event_showAllButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
         
    }//GEN-LAST:event_searchFieldActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
       if (this.validData()) {
            List<Expense> foundExpense = this.getExpense(this.searchField.getText());
            this.showFoundExpense(foundExpense);
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        AdministratorView administratorView = new AdministratorView();
        administratorView.setVisible(rootPaneCheckingEnabled);
       // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    
    private List getExpense(String supplier) {
        ExpenseManager expenseManager = new ExpenseManagerImplementation();
        List<Expense> foundExpense = expenseManager.searchBySupplier(supplier);
        
        return foundExpense;
    }
    
    private List getExpenses() {
        ExpenseManager expenseManager = new ExpenseManagerImplementation();
        List<Expense> expenses = expenseManager.getAll();
        
        return expenses;
    }
    
    public void showAllExpenses() {
        List expenses = this.getExpenses();
        DefaultTableModel model = this.createTableModel();
        if (expenses == null) {
            this.expensesTable.setModel(model);
            this.showMessage("No se encontró ningún cliente.");
            return;
        }
        
        String[] expenseData = new String[5];
        Iterator<Expense> iterator = expenses.iterator();
        while (iterator.hasNext()) {
            Expense expense = (Expense)iterator.next();
            expenseData[0] = Integer.toString(expense.getId());
            expenseData[1] = expense.getSupplier();
            expenseData[2] = expense.getDescription();
            expenseData[3] = Double.toString(expense.getTotal());
            expenseData[4] = expense.getDate().toString();
            model.addRow(expenseData);
        }
        this.expensesTable.setModel(model);
        this.rowSelection();
    }
    
    private void showFoundExpense(List expenseFound) {        
        DefaultTableModel model = this.createTableModel();
        if (expenseFound == null) {
            this.expensesTable.setModel(model);
            this.showMessage("No se encontró ningun provedor.");
            return;
        }
        
        String[] expenseData = new String[5];
        Iterator<Expense> iterator = expenseFound.iterator();
        while (iterator.hasNext()) {
            Expense expense = (Expense)iterator.next();
            expenseData[0] = Integer.toString(expense.getId());
            expenseData[1] = expense.getSupplier();
            expenseData[2] = expense.getDescription();
            expenseData[3] = Double.toString(expense.getTotal());
            expenseData[4] = expense.getDate().toString();
            model.addRow(expenseData);
        }
        this.expensesTable.setModel(model);
        this.rowSelection();
    }
    
    
    private boolean validData() {
        boolean validData = true;

        if (this.searchField.getText().isEmpty()) {
            this.showError("No escribiste nada en el campo de búsqueda.");
            validData = false;
        } 

        return validData;
    }
    
    private DefaultTableModel createTableModel() {
        DefaultTableModel model = new DefaultTableModel() {
          @Override
          public boolean isCellEditable(int row, int column) {
              return false;
          }
        };
        
        String[] columnNames = new String[5];
        columnNames[0] = "Id";
        columnNames[1] = "Vendedor";
        columnNames[2] = "Descripción";
        columnNames[3] = "Total";
        columnNames[4] = "Fecha";
        
        model.setColumnIdentifiers(columnNames);
        
        return model;
    }
    
     private void showMessage(String mensaje) {
        JOptionPane.showConfirmDialog(this,
                mensaje,
                "Oops!",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showError(String mensajeError) {
        JOptionPane.showConfirmDialog(this,
                mensajeError,
                "Error",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE);
    }
    
    private void rowSelection() {
        this.expensesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.expensesTable.setRowSelectionAllowed(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExpensesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpensesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpensesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpensesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ExpensesView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button SearchButton;
    private javax.swing.JTable expensesTable;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton newButton;
    private javax.swing.JButton removeButton;
    private java.awt.TextField searchField;
    private javax.swing.JButton showAllButton;
    // End of variables declaration//GEN-END:variables
}
