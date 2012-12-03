/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

/**
 *
 * @author bzeheatnix
 */
public class AdministratorView extends javax.swing.JFrame {

    /**
     * Creates new form AdministratorView
     */
    public AdministratorView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CustomersModule = new javax.swing.JButton();
        ProductsModule = new javax.swing.JButton();
        StatisticsModule = new javax.swing.JButton();
        ExpensesModule = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CustomersModule.setText("Clientes");
        CustomersModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomersModuleActionPerformed(evt);
            }
        });

        ProductsModule.setText("Productos");
        ProductsModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsModuleActionPerformed(evt);
            }
        });

        StatisticsModule.setText("Estadísticas");
        StatisticsModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatisticsModuleActionPerformed(evt);
            }
        });

        ExpensesModule.setText("Gastos");
        ExpensesModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpensesModuleActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(94, 94, 94)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(StatisticsModule)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 87, Short.MAX_VALUE)
                        .add(ExpensesModule)
                        .add(138, 138, 138))
                    .add(layout.createSequentialGroup()
                        .add(CustomersModule)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(ProductsModule)
                        .add(126, 126, 126))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(62, 62, 62)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(CustomersModule)
                    .add(ProductsModule))
                .add(72, 72, 72)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(StatisticsModule)
                    .add(ExpensesModule))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CustomersModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomersModuleActionPerformed
        CustomersView clientsModule = new CustomersView();
        clientsModule.setVisible(rootPaneCheckingEnabled);
        
        this.dispose();
    }//GEN-LAST:event_CustomersModuleActionPerformed

    private void ProductsModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsModuleActionPerformed
        createAndDisplayProductsManagement ();
        this.dispose();
    }//GEN-LAST:event_ProductsModuleActionPerformed

    private void StatisticsModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatisticsModuleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatisticsModuleActionPerformed

    private void ExpensesModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpensesModuleActionPerformed
        ExpensesView expensesModule = new ExpensesView();
        expensesModule.setVisible(rootPaneCheckingEnabled);
        this.dispose();
    }//GEN-LAST:event_ExpensesModuleActionPerformed

    private void createAndDisplayProductsManagement (){
        ProductsManagement productsManagementGUI = new ProductsManagement();
        productsManagementGUI.setVisible(rootPaneCheckingEnabled);
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
            java.util.logging.Logger.getLogger(AdministratorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministratorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministratorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministratorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdministratorView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CustomersModule;
    private javax.swing.JButton ExpensesModule;
    private javax.swing.JButton ProductsModule;
    private javax.swing.JButton StatisticsModule;
    // End of variables declaration//GEN-END:variables
}
