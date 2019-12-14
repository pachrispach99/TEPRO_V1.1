/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;
import Clases.Cliente;
import Clases.Empleado;
import Clases.PrestamoAdelantoSueldo;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class frmPrestamoAdelantoSuel extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    
    private void HabilitarBotones(){
        btnNuevo.setEnabled(false);
        btnGrabar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        
        
    }
    
    private void DesHabilitarBotones(){
        btnNuevo.setEnabled(true);
        btnGrabar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(true);
        
    }
    
    private void HabilitarTextos(){
        txtCCliente.setEnabled(true);
        txtCEmpleado.setEnabled(true);
       txtNCuotas.setEnabled(true);
        txtNTarjeta.setEnabled(true);
        txtSCliente.setEnabled(true);
      txtMSoli.setEnabled(true);
       
    }
    
    private void DesHabilitarTextos(){
         txtCCliente.setEnabled(false);
        txtCEmpleado.setEnabled(false);
       txtNCuotas.setEnabled(false);
        txtNTarjeta.setEnabled(false);
        txtSCliente.setEnabled(false);
      txtMSoli.setEnabled(false);
       
    }
    
    private void ColumnasTabla(){
        modelo.addColumn("Codigo Cliente");
        modelo.addColumn("Codigo Empleado");
        modelo.addColumn("N° Cuotas");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Numero de Tarjeta");
        modelo.addColumn("Monto a Solicitar");
        tblPrestamoAdelantoS.setModel(modelo);                        
    } 
    private void Limpiar(){
        
        txtCCliente.setText(null);
        txtCEmpleado.setText(null);
       txtNCuotas.setText(null);
        txtNTarjeta.setText(null);
        txtSCliente.setText(null);
      txtMSoli.setText(null);
        
        txtCCliente.requestFocus();
    }
    private void Eliminar(){
        int fila=tblPrestamoAdelantoS.getSelectedRow();
        modelo.removeRow(fila);
    }
    private void Limpiartabla(){
        int filas=modelo.getRowCount();
        for(int i=0;i<filas;i++)
        {
            modelo.removeRow(0);
        }
    }
    
    
    
    private void llenarTabla(){
        try{
            File archivo = new File("C:\\Users\\User\\Desktop\\repositorio\\TEPRO_V1.1\\Ficheros\\PASueldo.txt");
            if (archivo.exists()){
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                
                while((linea=br.readLine())!=null){
                    StringTokenizer st = new StringTokenizer(linea, ";");
                    String cod = st.nextToken().trim();
                    String nom = st.nextToken().trim();
                    String ape = st.nextToken().trim();
                    String dni = st.nextToken().trim();
                    String sex=st.nextToken().trim();
                     String sue=st.nextToken().trim();
                    
                    Object[] obj = new Object[]{
                      cod, nom, ape, dni,sex ,sue
                    };
                    modelo.addRow(obj);
                    
                 }
                 //liberar recursos
                 br.close();
                                               
            }else{
                JOptionPane.showMessageDialog(null, 
                        "Ruta no valida del archivo");
            }
                                              
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, 
                    "Error Leer Fichero: " + ex.getMessage());
        }
        
    } 
    

    
    
    
     private void Enviarfichero()
    {
        /*atrapar posibles errores*/
        try{
            FileWriter fw;
            PrintWriter pw;
        
            //crear el archivo
            fw= new FileWriter("C:\\Users\\User\\Desktop\\repositorio\\TEPRO_V1.1\\Ficheros\\PASueldo.txt", true);
            //escribir el archivo
            pw=new PrintWriter(fw);
            //enviar datos al archivo
            PrestamoAdelantoSueldo obj = new PrestamoAdelantoSueldo();
            obj.setCodigoCliente(txtCCliente.getText());
            obj.setCodigoEmpleado(txtCEmpleado.getText());
            obj.setMSolicitarA(Integer.parseInt(txtMSoli.getText()));
            obj.setNroCuotas(Integer.parseInt(txtNCuotas.getText()));
            
            obj.setNumerotarjeta(Integer.parseInt(txtNTarjeta.getText()));
            obj.setSueldocliente(Integer.parseInt(txtSCliente.getText()));

            
            pw.println(
                  obj.getCodigoCliente() + ";"
                    +obj.getCodigoEmpleado()+ ";" 
             + obj.getMSolicitarA()+ ";" 
             + obj.getNroCuotas()+ ";"
            + obj.getNumerotarjeta()+ ";"
            + obj.getSueldocliente()+ ";"
          
                    
            
            );
            
            //liberar buffer
            pw.close();
            //enviar mensaje de exito
            JOptionPane.showMessageDialog(null, "Prestamo Registrado");
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error Fichero: \n" + ex.getMessage());
        }
    }
    
    
    
    public frmPrestamoAdelantoSuel() {
        initComponents();
        
        setLocationRelativeTo(null);
         DesHabilitarTextos();
        DesHabilitarBotones();
       ColumnasTabla();  
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCCliente = new javax.swing.JTextField();
        txtNCuotas = new javax.swing.JTextField();
        txtSCliente = new javax.swing.JTextField();
        txtCEmpleado = new javax.swing.JTextField();
        txtNTarjeta = new javax.swing.JTextField();
        txtMSoli = new javax.swing.JTextField();
        btnGrabar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrestamoAdelantoS = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();
        btnExportarExcel2007 = new javax.swing.JButton();
        btnExportarExcel2010 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Codigo Cliente:");

        jLabel2.setText("Codigo Empleado:");

        jLabel3.setText("Nº de Cuotas:");

        jLabel4.setText("Sueldo del Cliente:");

        jLabel5.setText("Número de Tarjeta:");

        jLabel6.setText("Monto a Solicitar:");

        txtCCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCClienteKeyTyped(evt);
            }
        });

        txtNCuotas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNCuotasKeyTyped(evt);
            }
        });

        txtSCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSClienteKeyTyped(evt);
            }
        });

        txtCEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCEmpleadoKeyTyped(evt);
            }
        });

        txtNTarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNTarjetaKeyTyped(evt);
            }
        });

        txtMSoli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMSoliKeyTyped(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        tblPrestamoAdelantoS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPrestamoAdelantoS);

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnExportarExcel2007.setText("Exportar Excel 2007");
        btnExportarExcel2007.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarExcel2007ActionPerformed(evt);
            }
        });

        btnExportarExcel2010.setText("Exportar Excel 2010");
        btnExportarExcel2010.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarExcel2010ActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar Registro");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(txtNCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMSoli, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExportarExcel2010)
                            .addComponent(btnExportarExcel2007)))
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCCliente)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCEmpleado))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNCuotas))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSCliente))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMSoli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpiar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExportarExcel2007)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExportarExcel2010)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCClienteKeyTyped
        char c = evt.getKeyChar();
        
        if(txtCCliente.getText().length()>= 6 ){
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            evt.consume();
           }
         if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCClienteKeyTyped

    private void txtCEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCEmpleadoKeyTyped
        if(txtCEmpleado.getText().length()>= 6){
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        char c = evt.getKeyChar();
        if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCEmpleadoKeyTyped

    private void txtNCuotasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNCuotasKeyTyped
        if(txtNCuotas.getText().length()>= 2){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            Toolkit.getDefaultToolkit().beep();
            
        }
        
        char c = evt.getKeyChar();
        if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNCuotasKeyTyped

    private void txtSClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSClienteKeyTyped
        if(txtSCliente.getText().length()>= 7){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            Toolkit.getDefaultToolkit().beep();
        }
        char c = evt.getKeyChar();
        if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtSClienteKeyTyped

    private void txtNTarjetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNTarjetaKeyTyped
        if(txtNTarjeta.getText().length()>= 19){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            Toolkit.getDefaultToolkit().beep();
        }
        char c = evt.getKeyChar();
        if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNTarjetaKeyTyped

    private void txtMSoliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMSoliKeyTyped
        if(txtMSoli.getText().length()>= 7){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            Toolkit.getDefaultToolkit().beep();
        }
        char c = evt.getKeyChar();
        if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtMSoliKeyTyped

    private void btnExportarExcel2007ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarExcel2007ActionPerformed
        try {
            Clases.clsExportarExcel obj = new Clases.clsExportarExcel();
            obj.exportarExcel2010(tblPrestamoAdelantoS);
        } catch (IOException ex) {
            Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarExcel2007ActionPerformed

    private void btnExportarExcel2010ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarExcel2010ActionPerformed
        
    }//GEN-LAST:event_btnExportarExcel2010ActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        
        DesHabilitarTextos();
        DesHabilitarBotones();
        
         Empleado obj = new Empleado();
                
//
//        obj.setCodigo(txtCCliente.getText());
//        obj.setApellido(txtCEmpleado.getText());
//        obj.setApellido(txtApellido.getText());
//        obj.setDni(Integer.parseInt(txtDni.getText()));
//        obj.setSexo1(rdFemenino.isSelected());
//        obj.setSexo2(rdMasculino.isSelected());
//        obj.setSueldo(Double.parseDouble(txtSueldo.getText()));

        //agregar fila a la tabla
        Object[] fila = new Object[6];
        fila[0] = obj.getCodigo();
        fila[1] = obj.getNombre();
        fila[2] = obj.getApellido();
        fila[3] = obj.getDni();
        fila[4] = obj.Sexo();
        fila[5] = obj.getSueldo();
        modelo.addRow(fila);

        Enviarfichero();
        modelo.setRowCount(0);
        llenarTabla();
        Limpiar();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Limpiar();
        HabilitarTextos();
        HabilitarBotones();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        DesHabilitarTextos();
        DesHabilitarBotones();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiartabla();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        llenarTabla();
    }//GEN-LAST:event_btnListarActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrestamoAdelantoSuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrestamoAdelantoSuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrestamoAdelantoSuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrestamoAdelantoSuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrestamoAdelantoSuel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportarExcel2007;
    private javax.swing.JButton btnExportarExcel2010;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPrestamoAdelantoS;
    private javax.swing.JTextField txtCCliente;
    private javax.swing.JTextField txtCEmpleado;
    private javax.swing.JTextField txtMSoli;
    private javax.swing.JTextField txtNCuotas;
    private javax.swing.JTextField txtNTarjeta;
    private javax.swing.JTextField txtSCliente;
    // End of variables declaration//GEN-END:variables

    private static class clsExportarExcel {

        public clsExportarExcel() {
        }

        private void exportarExcel(JTable tblPrestamoAdelantoS) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
