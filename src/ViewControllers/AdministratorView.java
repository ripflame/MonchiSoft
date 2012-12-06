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

        m_customersModule = new javax.swing.JButton();
        m_productsModule = new javax.swing.JButton();
        m_statisticsModule = new javax.swing.JButton();
        m_expensesModule = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        m_customersModule.setText("Clientes");
        m_customersModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_customersModuleActionPerformed(evt);
            }
        });

        m_productsModule.setText("Productos");
        m_productsModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_productsModuleActionPerformed(evt);
            }
        });

        m_statisticsModule.setText("Estadísticas");
        m_statisticsModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_statisticsModuleActionPerformed(evt);
            }
        });

        m_expensesModule.setText("Gastos");
        m_expensesModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_expensesModuleActionPerformed(evt);
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
                        .add(m_statisticsModule)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 87, Short.MAX_VALUE)
                        .add(m_expensesModule)
                        .add(138, 138, 138))
                    .add(layout.createSequentialGroup()
                        .add(m_customersModule)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(m_productsModule)
                        .add(126, 126, 126))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(62, 62, 62)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(m_customersModule)
                    .add(m_productsModule))
                .add(72, 72, 72)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(m_statisticsModule)
                    .add(m_expensesModule))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void m_customersModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_customersModuleActionPerformed
        openCustomersView();
    }//GEN-LAST:event_m_customersModuleActionPerformed

    private void m_productsModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_productsModuleActionPerformed
        openProductsView();
    }//GEN-LAST:event_m_productsModuleActionPerformed

    private void m_statisticsModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_statisticsModuleActionPerformed
        openStatisticsView();
    }//GEN-LAST:event_m_statisticsModuleActionPerformed

    private void m_expensesModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_expensesModuleActionPerformed
        openExpensesView();
    }//GEN-LAST:event_m_expensesModuleActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        openMainView();
    }//GEN-LAST:event_formWindowClosing

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

            @Override
            public void run() {
                new AdministratorView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton m_customersModule;
    private javax.swing.JButton m_expensesModule;
    private javax.swing.JButton m_productsModule;
    private javax.swing.JButton m_statisticsModule;
    // End of variables declaration//GEN-END:variables

    private void openCustomersView() {
        CustomersView customersView = new CustomersView();
        customersView.setVisible(rootPaneCheckingEnabled);
        this.dispose();
    }

    private void openProductsView() {
        ProductsManagementController productsController = new ProductsManagementController();
        productsController.EndCreateAndDisplayProductsManagement();
        this.dispose();
    }

    private void openExpensesView() {
        ExpensesView expensesModule = new ExpensesView();
        expensesModule.setVisible(rootPaneCheckingEnabled);
        this.dispose();
    }

    private void openMainView() {
        Main main = new Main();
        main.setVisible(rootPaneCheckingEnabled);
        this.dispose();
    }

    private void openStatisticsView() {
        StatisticsView statisticView = new StatisticsView();
        statisticView.setVisible(rootPaneCheckingEnabled);
        this.dispose();
    }
}
