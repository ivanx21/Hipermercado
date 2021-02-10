/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCategoria;
import ec.edu.ups.modelo.Categoria;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José A. Ramírez C.
 */
public class VistaCategoria extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaCategoria
     */
    ControladorCategoria cc;
    Categoria categoria;
    DefaultTableModel dtm;
    Object[] o = new Object[2];

    public VistaCategoria() {
        initComponents();
        cc = new ControladorCategoria();
        tCodigo.setText("" + cc.llenarIdCategoria());
        dtm = (DefaultTableModel) tbCategorias.getModel();
        llenarTabla();
        clickearTabla();
    }

    public void llenarTabla() {
        dtm.setRowCount(0);
        dtm = (DefaultTableModel) tbCategorias.getModel();
        cc.llenarTabla(dtm, o);
    }

    private void clickearTabla() {
        tbCategorias.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouse_evt) {
                Point point = mouse_evt.getPoint();
                if (mouse_evt.getClickCount() == 2) {
                    tCodigo.setText(tbCategorias.getValueAt(tbCategorias.getSelectedRow(), 0).toString());
                    tNombre.setText(tbCategorias.getValueAt(tbCategorias.getSelectedRow(), 1).toString());
                }
            }
        });
    }

    private void limpiarTexto() {
        tCodigo.setText("");
        tNombre.setText("");
        tBuscar.setText("");
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
        tbCategorias = new javax.swing.JTable();
        pOpciones = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lOpciones = new javax.swing.JLabel();
        bGuardar = new javax.swing.JButton();
        bActualizar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        pAgregarProducto = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        lAgregarCategoria = new javax.swing.JLabel();
        lNombre = new javax.swing.JLabel();
        tNombre = new javax.swing.JTextField();
        lCodigo = new javax.swing.JLabel();
        tCodigo = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        tBuscar = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Categorías");

        tbCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCategorias);
        if (tbCategorias.getColumnModel().getColumnCount() > 0) {
            tbCategorias.getColumnModel().getColumn(0).setMinWidth(60);
            tbCategorias.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbCategorias.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        pOpciones.setToolTipText("Opciones");

        lOpciones.setFont(new java.awt.Font("sansserif", 1, 30)); // NOI18N
        lOpciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lOpciones.setText("Opciones");

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        bActualizar.setText("Actualizar");
        bActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarActionPerformed(evt);
            }
        });

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pOpcionesLayout = new javax.swing.GroupLayout(pOpciones);
        pOpciones.setLayout(pOpcionesLayout);
        pOpcionesLayout.setHorizontalGroup(
            pOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pOpcionesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bActualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(bGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pOpcionesLayout.createSequentialGroup()
                        .addGroup(pOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(pOpcionesLayout.createSequentialGroup()
                                .addComponent(lOpciones)
                                .addGap(0, 8, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        pOpcionesLayout.setVerticalGroup(
            pOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bGuardar)
                .addGap(18, 18, 18)
                .addComponent(bActualizar)
                .addGap(18, 18, 18)
                .addComponent(bEliminar)
                .addGap(52, 52, 52))
        );

        pAgregarProducto.setToolTipText("Agregar Producto");

        lAgregarCategoria.setFont(new java.awt.Font("sansserif", 1, 30)); // NOI18N
        lAgregarCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAgregarCategoria.setText("Agregar Categoría");

        lNombre.setText("Nombre:");

        lCodigo.setText("Código:");

        tCodigo.setEditable(false);

        bBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/buscar.png"))); // NOI18N
        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pAgregarProductoLayout = new javax.swing.GroupLayout(pAgregarProducto);
        pAgregarProducto.setLayout(pAgregarProductoLayout);
        pAgregarProductoLayout.setHorizontalGroup(
            pAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAgregarProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pAgregarProductoLayout.createSequentialGroup()
                        .addComponent(lAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator2)
                    .addGroup(pAgregarProductoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lCodigo)
                            .addComponent(lNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pAgregarProductoLayout.createSequentialGroup()
                                .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pAgregarProductoLayout.createSequentialGroup()
                                .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAgregarProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bBuscar)
                .addContainerGap())
        );
        pAgregarProductoLayout.setVerticalGroup(
            pAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAgregarProductoLayout.createSequentialGroup()
                .addComponent(lAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(pAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNombre))
                .addGap(18, 18, 18)
                .addGroup(pAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCodigo)
                    .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bBuscar)
                    .addComponent(tBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pAgregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        tCodigo.setText("" + cc.llenarIdCategoria());
        if (!tNombre.equals("")) {
            categoria = new Categoria();
            categoria.setCat_id(Integer.parseInt(tCodigo.getText()));
            categoria.setCat_nombre(tNombre.getText());
            if (cc.crearCategoria(categoria) == true) {
                JOptionPane.showMessageDialog(this, "Se ha creado la categoría", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear la categoría", "Incorrecto", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Campos vacíos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        limpiarTexto();
        llenarTabla();
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarActionPerformed
        if (!tNombre.equals("")) {
            categoria = new Categoria();
            categoria.setCat_id(Integer.parseInt(tCodigo.getText()));
            categoria.setCat_nombre(tNombre.getText());
            if (cc.editarCategoria(categoria) == true) {
                JOptionPane.showMessageDialog(this, "Se ha editado la categoría", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al editar la categoría", "Incorrecto", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Campos vacíos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        limpiarTexto();
        llenarTabla();
    }//GEN-LAST:event_bActualizarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        if (cc.eliminarCategoria(Integer.parseInt(tCodigo.getText())) == true) {
            JOptionPane.showMessageDialog(this, "Se ha eliminado la categoría", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Categoría ocupada en otros datos", "Incorrecto", JOptionPane.WARNING_MESSAGE);
        }
        limpiarTexto();
        llenarTabla();
    }//GEN-LAST:event_bEliminarActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        String palabra = tBuscar.getText();
        dtm.setRowCount(0);
        dtm = (DefaultTableModel) tbCategorias.getModel();
        cc.buscarCategoria(dtm, o, palabra);
    }//GEN-LAST:event_bBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lAgregarCategoria;
    private javax.swing.JLabel lCodigo;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel lOpciones;
    private javax.swing.JPanel pAgregarProducto;
    private javax.swing.JPanel pOpciones;
    private javax.swing.JTextField tBuscar;
    private javax.swing.JTextField tCodigo;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTable tbCategorias;
    // End of variables declaration//GEN-END:variables
}
