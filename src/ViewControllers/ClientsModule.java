/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Entities.Costumer;
import Managers.ClientManager;
import Managers.ClientManagerImplementation;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ripflame
 */
public class ClientsModule extends javax.swing.JFrame {

    /**
     * Creates new form ClientsModule
     */
    public ClientsModule() {
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

        filtroBusqueda = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        newButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(180, 0), new java.awt.Dimension(180, 0), new java.awt.Dimension(180, 0));
        showAllButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClients = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Facturación");
        setResizable(false);

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

        searchButton.setText("Buscar");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        tableClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableClients.setColumnSelectionAllowed(true);
        tableClients.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableClients);
        tableClients.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(searchField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 339, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(searchButton)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 430, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(searchField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(searchButton))
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 233, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        RegisterClient addClientView = new RegisterClient(this, true);
        addClientView.setLocationRelativeTo(this);
        addClientView.setVisible(true);
    }//GEN-LAST:event_newButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        int selectedRow = this.tableClients.getSelectedRow();        
        if (selectedRow > -1) {
            int clientID = Integer.parseInt((String) this.tableClients.getValueAt(selectedRow, 0));
            String clientName = (String) this.tableClients.getValueAt(selectedRow, 1);
            Costumer selectedClient = new Costumer(clientName);
            selectedClient.setId(clientID);
            RegisterClient modifyClientView = new RegisterClient(this, true, selectedClient);
            modifyClientView.setLocationRelativeTo(this);
            modifyClientView.setVisible(true);
        } else if (selectedRow == -1) {
            this.showMessage("No seleccionaste ninguna celda.");
        }
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if (this.validData()) {
            List foundClient = this.getClient(this.searchField.getText());
            this.showFoundClient(foundClient);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void showAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllButtonActionPerformed
        this.searchField.setText("");
        this.showAllClients();
    }//GEN-LAST:event_showAllButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int selectedRow = this.tableClients.getSelectedRow();        
        if (selectedRow > -1) {
            int idCliente = Integer.parseInt((String) this.tableClients.getValueAt(selectedRow, 0));
            String clientName = (String) this.tableClients.getValueAt(selectedRow, 1);
            Costumer selectedClient = new Costumer(clientName);
            selectedClient.setId(idCliente);
            ClientManager clientManager = new ClientManagerImplementation();
            clientManager.remove(selectedClient);
            this.showAllClients();
        } else if (selectedRow == -1) {
            this.showMessage("No seleccionaste ninguna celda.");
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private boolean validData() {
        boolean validData = true;

        if (this.searchField.getText().isEmpty()) {
            this.showError("No escribiste nada en el campo de búsqueda.");
            validData = false;
        } 

        return validData;
    }
    
    private List getClient(String name) {
        ClientManager clientManager = new ClientManagerImplementation();
        List foundClient = clientManager.searchByName(name);
        
        return foundClient;
    }
    
    private List getClients() {
        ClientManager clientManager = new ClientManagerImplementation();
        List clients = clientManager.getAll();
        
        return clients;
    }
    
    private DefaultTableModel createTableModel() {
        DefaultTableModel model = new DefaultTableModel() {
          @Override
          public boolean isCellEditable(int row, int column) {
              return false;
          }
        };
        
        String[] columnNames = new String[2];
        columnNames[0] = "Id";
        columnNames[1] = "Nombre";
        
        model.setColumnIdentifiers(columnNames);
        
        return model;
    }
    
    public void showAllClients() {
        List clients = this.getClients();
        DefaultTableModel model = this.createTableModel();
        if (clients == null) {
            this.tableClients.setModel(model);
            this.showMessage("No se encontró ningún cliente.");
            return;
        }
        
        String[] clientData = new String[2];
        Iterator<Costumer> iterator = clients.iterator();
        while (iterator.hasNext()) {
            Costumer client = (Costumer)iterator.next();
            clientData[0] = Integer.toString(client.getId());
            clientData[1] = client.getName();
            model.addRow(clientData);
        }
        this.tableClients.setModel(model);
        this.rowSelection();
    }
    
    private void showFoundClient(List clientFound) {        
        DefaultTableModel model = this.createTableModel();
        if (clientFound == null) {
            this.tableClients.setModel(model);
            this.showMessage("No se encontró el cliente.");
            return;
        }
        
        String[] clientData = new String[2];
        Iterator<Costumer> iterator = clientFound.iterator();
        while (iterator.hasNext()) {
            Costumer client = (Costumer)iterator.next();
            clientData[0] = Integer.toString(client.getId());
            clientData[1] = client.getName();
            model.addRow(clientData);
        }
        
        this.tableClients.setModel(model);
        this.rowSelection();
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
        this.tableClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tableClients.setRowSelectionAllowed(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.ButtonGroup filtroBusqueda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton newButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton showAllButton;
    private javax.swing.JTable tableClients;
    // End of variables declaration//GEN-END:variables
}
