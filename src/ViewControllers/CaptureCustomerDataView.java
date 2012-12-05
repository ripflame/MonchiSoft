/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.Customer;
import Helpers.MessageDisplayManger;
import Helpers.MessageType;
import Managers.CustomerManager;
import Managers.CustomerManagerImplementation;

/**
 *
 * @author Ripflame
 */
public class CaptureCustomerDataView extends javax.swing.JDialog {
    
    public CaptureCustomerDataView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.isAddButton = true;
        this.setAddText();
    }
    
    public CaptureCustomerDataView(java.awt.Frame parent, boolean modal, Customer modifiedCustomer) {
        super(parent, modal);
        initComponents();
        this.isAddButton = false;
        this.setModifyText();
        this.modifiedCustomer = modifiedCustomer;
        this.m_nameField.setText(this.modifiedCustomer.getName());
    }
    
    private void setAddText() {
        this.setTitle("Agregar Cliente");
        this.m_addModifyButton.setText("Agregar");
    }
    
    private void setModifyText() {
        this.setTitle("Modificar Cliente");
        this.m_addModifyButton.setText("Modificar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        m_addModifyButton = new javax.swing.JButton();
        m_cancelButton = new javax.swing.JButton();
        m_nameField = new javax.swing.JTextField();
        m_nameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        m_addModifyButton.setText("Agregar/Modificar");
        m_addModifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_addModifyButtonActionPerformed(evt);
            }
        });

        m_cancelButton.setText("Cancelar");
        m_cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_cancelButtonActionPerformed(evt);
            }
        });

        m_nameLabel.setText("Nombre:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(m_cancelButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(m_addModifyButton))
                    .add(layout.createSequentialGroup()
                        .add(m_nameLabel)
                        .add(22, 22, 22)
                        .add(m_nameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 234, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(m_nameLabel)
                    .add(m_nameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(m_addModifyButton)
                    .add(m_cancelButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void m_addModifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_addModifyButtonActionPerformed
        if (this.isAddButton) {
            this.addCustomer();
        } else {
            this.modifyCustomer(this.modifiedCustomer);
        }
    }//GEN-LAST:event_m_addModifyButtonActionPerformed

    private void m_cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_m_cancelButtonActionPerformed

    private void addCustomer() {
        if (this.validData()) {
            CustomerManager customerManager = new CustomerManagerImplementation();
            Customer customer = new Customer(this.m_nameField.getText());
            customerManager.add(customer);
            ((CustomersView)this.getParent()).showAllCustomers();
            this.dispose();
        } else {
            MessageDisplayManger.showInformation(MessageType.EMPTY_FIELDS, this );
        }
    }
    
    private void modifyCustomer(Customer customer) {
        if (this.validData()) {
            CustomerManager customerManager = new CustomerManagerImplementation();
            Customer modifiedCustomer = customer;
            modifiedCustomer.setName(this.m_nameField.getText());
            customerManager.modify(modifiedCustomer);
            ((CustomersView)this.getParent()).showAllCustomers();
            this.dispose();
        } else {
            MessageDisplayManger.showInformation(MessageType.EMPTY_FIELDS, this );
        }
    }
    
    private boolean validData() {
        boolean correctData = true;
        if (this.m_nameField.getText().isEmpty()) {
            correctData = false;
        }
        
        return correctData;
    }
    
    private Customer modifiedCustomer;
    private boolean isAddButton;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton m_addModifyButton;
    private javax.swing.JButton m_cancelButton;
    private javax.swing.JTextField m_nameField;
    private javax.swing.JLabel m_nameLabel;
    // End of variables declaration//GEN-END:variables
}
