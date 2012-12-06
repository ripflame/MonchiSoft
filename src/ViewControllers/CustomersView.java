/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.Customer;
import Entities.Sale;
import Helpers.MessageDisplayManger;
import Helpers.MessageType;
import Managers.CustomerManager;
import Managers.CustomerManagerImplementation;
import Managers.SaleManager;
import Managers.SaleManagerImplementation;
import java.util.Iterator;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ripflame
 */
public class CustomersView extends javax.swing.JFrame {

    /**
     * Creates new form CustomersView
     */
    public CustomersView() {
        initComponents();
        hideChooserView();
    }

    public CustomersView(SalesModule parentWindow) {
        initComponents();
        //m_backButton.setVisible(false);
        summonerWindow = (SalesModule) parentWindow;
    }

    private void hideChooserView(){
        m_cancelButton.setVisible(false);
        m_selectUserButton.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filtroBusqueda = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        m_newButton = new javax.swing.JButton();
        m_modifyButton = new javax.swing.JButton();
        m_removeButton = new javax.swing.JButton();
        m_filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(180, 0), new java.awt.Dimension(180, 0), new java.awt.Dimension(180, 0));
        m_showAllButton = new javax.swing.JButton();
        m_searchField = new javax.swing.JTextField();
        m_searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        m_customersTable = new javax.swing.JTable();
        m_cancelButton = new javax.swing.JButton();
        m_selectUserButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestión de Clientes");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        m_newButton.setText("Nuevo");
        m_newButton.setFocusable(false);
        m_newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        m_newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        m_newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_newButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(m_newButton);

        m_modifyButton.setText("Modificar");
        m_modifyButton.setFocusable(false);
        m_modifyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        m_modifyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        m_modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_modifyButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(m_modifyButton);

        m_removeButton.setFocusable(false);
        m_removeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        m_removeButton.setLabel("Eliminar");
        m_removeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        m_removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_removeButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(m_removeButton);
        jToolBar1.add(m_filler1);

        m_showAllButton.setText("Mostrar todos");
        m_showAllButton.setFocusable(false);
        m_showAllButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        m_showAllButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        m_showAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_showAllButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(m_showAllButton);

        m_searchButton.setText("Buscar");
        m_searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_searchButtonActionPerformed(evt);
            }
        });

        m_customersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Visitas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        m_customersTable.setColumnSelectionAllowed(true);
        m_customersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(m_customersTable);
        m_customersTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        m_cancelButton.setText("Cancelar");
        m_cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_cancelButtonActionPerformed(evt);
            }
        });

        m_selectUserButton.setText("Seleccionar");
        m_selectUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_selectUserButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(m_searchField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 339, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(m_searchButton)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 430, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(m_cancelButton)
                                .add(18, 18, 18)
                                .add(m_selectUserButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(m_searchField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(m_searchButton))
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 233, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(m_selectUserButton)
                    .add(m_cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void m_newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_newButtonActionPerformed
        openNewView();
    }//GEN-LAST:event_m_newButtonActionPerformed

    private void m_modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_modifyButtonActionPerformed
        int selectedRow = this.m_customersTable.getSelectedRow();
        if (selectedRow > -1) {
            Customer selectedCustomer = getCustomerInformation(selectedRow);
            openModifyView(selectedCustomer);
        } else if (selectedRow == -1) {
            MessageDisplayManger.showInformation(MessageType.NO_CELL_SELECTED, this);
        }
    }//GEN-LAST:event_m_modifyButtonActionPerformed

    private Customer getCustomerInformation(int selectedRow) {
        String customerName = (String) this.m_customersTable.getValueAt(selectedRow, 1);
        Customer selectedCustomer = new Customer(customerName);
        int customerID = Integer.parseInt((String) this.m_customersTable.getValueAt(selectedRow, 0));
        selectedCustomer.setId(customerID);

        return selectedCustomer;
    }

    private void openNewView() {
        CaptureCustomerDataView addCustomerView = new CaptureCustomerDataView(this, true);
        addCustomerView.setLocationRelativeTo(this);
        addCustomerView.setVisible(true);
    }

    private void openModifyView(Customer selectedCustomer) {
        CaptureCustomerDataView modifyCustomerView = new CaptureCustomerDataView(this, true, selectedCustomer);
        modifyCustomerView.setLocationRelativeTo(this);
        modifyCustomerView.setVisible(true);
    }

    private void m_searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_searchButtonActionPerformed

        if (this.validData()) {
            List foundCustomer = this.getCustomer(this.m_searchField.getText());
            this.showFoundCustomer(foundCustomer);
        }
    }//GEN-LAST:event_m_searchButtonActionPerformed

    private void m_showAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_showAllButtonActionPerformed
        this.m_searchField.setText("");
        this.showAllCustomers();
    }//GEN-LAST:event_m_showAllButtonActionPerformed

    private void m_removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_removeButtonActionPerformed
        int selectedRow = this.m_customersTable.getSelectedRow();
        if (selectedRow > -1) {
            Customer selectedCustomer = getCustomerInformation(selectedRow);
            CustomerManager customerManager = new CustomerManagerImplementation();
            customerManager.remove(selectedCustomer);
            this.showAllCustomers();
        } else if (selectedRow == -1) {
            MessageDisplayManger.showInformation(MessageType.NO_CELL_SELECTED, this);
        }
    }//GEN-LAST:event_m_removeButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (summonerWindow == null) {
            AdministratorView administratorView = new AdministratorView();
            administratorView.setVisible(rootPaneCheckingEnabled);
        } else {
            summonerWindow.setEnabled(true);
        }
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void m_cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_cancelButtonActionPerformed
        summonerWindow.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_m_cancelButtonActionPerformed

    private void m_selectUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_selectUserButtonActionPerformed
        String customerName = getSelectedCustomerName();
        summonerWindow.setCustomerName(customerName);
        summonerWindow.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_m_selectUserButtonActionPerformed

    private String getSelectedCustomerName() {
        int selectedRow = m_customersTable.getSelectedRow();
        boolean isSelectedRow = (selectedRow != -1);
        if (isSelectedRow) {
            String customerName = (String) m_customersTable.getValueAt(selectedRow, NAME_COLUMN);
            return customerName;
        }
        return COUNTER_CLIENT;
    }

    private boolean validData() {
        boolean validData = true;

        if (this.m_searchField.getText().isEmpty()) {
            MessageDisplayManger.showError(MessageType.SEARCH_FIELD_EMPTY, this);
            validData = false;
        }

        return validData;
    }

    private List getCustomer(String name) {
        CustomerManager customerManager = new CustomerManagerImplementation();
        List foundCustomer = customerManager.searchByName(name);

        return foundCustomer;
    }

    private List getCustomers() {
        CustomerManager customerManager = new CustomerManagerImplementation();
        List customers = customerManager.getAll();

        return customers;
    }

    private DefaultTableModel createTableModel() {
        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] columnNames = new String[3];
        columnNames[COLUMN_ID_POSITION] = ID;
        columnNames[COLUMN_NAME_POSITION] = NAME;
        columnNames[COLUMN_VISITS_POSITION] = VISITS;

        model.setColumnIdentifiers(columnNames);

        return model;
    }

    public void showAllCustomers() {
        List customers = this.getCustomers();
        DefaultTableModel model = this.createTableModel();
        if (customers == null) {
            this.m_customersTable.setModel(model);
            MessageDisplayManger.showInformation(MessageType.NO_COSTUMER_FOUND, this);
            return;
        }

        String[] customerData = new String[3];
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = (Customer) iterator.next();
            customerData[COLUMN_ID_POSITION] = Integer.toString(customer.getId());
            customerData[COLUMN_NAME_POSITION] = customer.getName();
            customerData[COLUMN_VISITS_POSITION] = Integer.toString(this.getVisits(customer));
            model.addRow(customerData);
        }
        this.m_customersTable.setModel(model);
        this.rowSelectionProperties();
    }

    private void showFoundCustomer(List customerFound) {
        DefaultTableModel model = this.createTableModel();
        if (customerFound == null) {
            this.m_customersTable.setModel(model);
            MessageDisplayManger.showInformation(MessageType.NO_COSTUMER_FOUND, this);
            return;
        }

        String[] customerData = new String[3];
        Iterator<Customer> iterator = customerFound.iterator();
        while (iterator.hasNext()) {
            Customer customer = (Customer) iterator.next();
            customerData[COLUMN_ID_POSITION] = Integer.toString(customer.getId());
            customerData[COLUMN_NAME_POSITION] = customer.getName();
            customerData[COLUMN_VISITS_POSITION] = Integer.toString(this.getVisits(customer));
            model.addRow(customerData);
        }

        this.m_customersTable.setModel(model);
        this.rowSelectionProperties();
    }

    private void rowSelectionProperties() {
        this.m_customersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.m_customersTable.setCellSelectionEnabled(false);
        this.m_customersTable.setRowSelectionAllowed(true);
    }
    
    public static final String COUNTER_CLIENT= "Mostrador";
    private static final int NAME_COLUMN = 1;
    private SalesModule summonerWindow;
    private int COLUMN_ID_POSITION = 0;
    private int COLUMN_NAME_POSITION = 1;
    private int COLUMN_VISITS_POSITION = 2;
    private String ID = "Id";
    private String NAME = "Nombre";
    private String VISITS = "Visitas";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup filtroBusqueda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton m_cancelButton;
    private javax.swing.JTable m_customersTable;
    private javax.swing.Box.Filler m_filler1;
    private javax.swing.JButton m_modifyButton;
    private javax.swing.JButton m_newButton;
    private javax.swing.JButton m_removeButton;
    private javax.swing.JButton m_searchButton;
    private javax.swing.JTextField m_searchField;
    private javax.swing.JButton m_selectUserButton;
    private javax.swing.JButton m_showAllButton;
    // End of variables declaration//GEN-END:variables

    private int getVisits(Customer customer) {
        SaleManager saleManager = new SaleManagerImplementation();
        List<Sale> sales = saleManager.getAll();
        int visitsNumber = 0;

        Iterator<Sale> iterator = sales.iterator();
        while (iterator.hasNext()) {
            Sale sale = iterator.next();
            if (sale.getCustomerId() == customer.getId()) {
                visitsNumber++;
            }

        }

        return visitsNumber;
    }
}
