/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

//import Managers.BaseProductDataManager;
import Entities.BaseProduct;
import Entities.Topping;
import Managers.ToppingManager;
import Managers.ToppingManagerImplementation;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Asus
 */
public class ExtraTopping extends javax.swing.JFrame {

    /**
     * Creates new form ExtraTopping
     */
    public ExtraTopping() {
        initComponents();
    }
    
    
    public ExtraTopping(JFrame summonerWindow, int productInCreationId) {
        initComponents();
        this.m_summonerWindow = summonerWindow;
        currentProductId = productInCreationId;
        
        ToppingManager toppingManager = new ToppingManagerImplementation();
        List toppingList = toppingManager.getAll();
        Iterator<Topping> toppingIterator = toppingList.iterator();
        while (toppingIterator.hasNext()) {
            Topping currentTopping = toppingIterator.next();
            m_extraToppingComboBox.addItem(currentTopping.getName());
        }
        m_extraToppingComboBox.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        m_newToppingButton = new javax.swing.JButton();
        m_productFinishedButton = new javax.swing.JButton();
        m_extraToppingComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        m_newToppingButton.setText("Agregar Topping");
        m_newToppingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_newToppingButtonActionPerformed(evt);
            }
        });

        m_productFinishedButton.setText("Terminar Producto");
        m_productFinishedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_productFinishedButtonActionPerformed(evt);
            }
        });

        m_extraToppingComboBox.setModel(new javax.swing.DefaultComboBoxModel());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(m_extraToppingComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(layout.createSequentialGroup()
                .add(160, 160, 160)
                .add(m_newToppingButton)
                .add(10, 10, 10)
                .add(m_productFinishedButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(23, 23, 23)
                .add(m_extraToppingComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(97, 97, 97)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(m_newToppingButton)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(m_productFinishedButton))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void m_newToppingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_newToppingButtonActionPerformed
        addExtraTopping();
        ExtraTopping extraToppingWindow = new ExtraTopping(m_summonerWindow, currentProductId);
        extraToppingWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_m_newToppingButtonActionPerformed

    private void addExtraTopping(){
        String toppingName = m_extraToppingComboBox.getSelectedItem().toString();
        ToppingManager toppingManager = new ToppingManagerImplementation();
        List<Topping> toppingFoundList = toppingManager.searchByName(toppingName);
        Topping toppingFound = toppingFoundList.get(0);
        double toppingPrice = toppingFound.getPrice();
        ((SalesModule)m_summonerWindow).addExtraToppingToTable(toppingName, toppingPrice, currentProductId);
    }
    
    private void m_productFinishedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_productFinishedButtonActionPerformed
        
        m_summonerWindow.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_m_productFinishedButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       m_summonerWindow.setEnabled(true);
       this.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExtraTopping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExtraTopping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExtraTopping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExtraTopping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExtraTopping().setVisible(true);
            }
        });
    }
    
    private int currentProductId;
    //private ProductsDataManager m_productsDataManager;
    private JFrame m_summonerWindow;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox m_extraToppingComboBox;
    private javax.swing.JButton m_newToppingButton;
    private javax.swing.JButton m_productFinishedButton;
    // End of variables declaration//GEN-END:variables
}
