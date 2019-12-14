/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.Cliente;
import Clases.Empleado;
import Clases.PrestamoAdelantoSueldo;
import Clases.PrestamoHipotecario;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ordenador
 */
public class frmPrestamoHipotecario extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    
    private void HabilitarBotones(){
        btnNuevo.setEnabled(false);
        btnGrabar.setEnabled(true);
        btnCancelar.setEnabled(true);        
        btnEliminar.setEnabled(false);    
    }
    private void DesHabilitarBotones(){
        btnNuevo.setEnabled(true);
        btnGrabar.setEnabled(false);
        btnCancelar.setEnabled(false);   
        btnEliminar.setEnabled(true);     
    }
    
    private void HabilitarTextos(){
        txtCCliente.setEnabled(true);
        txtCEmpleado.setEnabled(true);
        txtNTarjeta.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtValor.setEnabled(true);
      txtPrestamo.setEnabled(true);
      txtCantidadaños.setEnabled(true);
       
    }
    
    private void DesHabilitarTextos(){
         txtCCliente.setEnabled(false);
        txtCEmpleado.setEnabled(false);
        txtNTarjeta.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtValor.setEnabled(false);
      txtPrestamo.setEnabled(false);
      txtCantidadaños.setEnabled(false);
       
    }
    
    private void ColumnasTabla(){
        modelo.addColumn("Codigo Cliente");
        modelo.addColumn("Codigo Empleado");
        modelo.addColumn("N° Tarjeta");
        modelo.addColumn("Direccion");
        modelo.addColumn("Tipo de Hipoteca");
        modelo.addColumn("Valor del Bien");
        modelo.addColumn("Estado");
        modelo.addColumn("Prestamo a Solicitar");
        modelo.addColumn("Tiempo De Devolucion");
        tblPrestamoHipotecario.setModel(modelo);                        
    } 
    private void Limpiar(){
        
       txtCCliente.setText(null);
        txtCEmpleado.setText(null);
        txtNTarjeta.setText(null);
        txtDireccion.setText(null);
        txtValor.setText(null);
      txtPrestamo.setText(null);
      txtCantidadaños.setText(null);
        
        txtCCliente.requestFocus();
    }
    private void Eliminar(){
        int fila=tblPrestamoHipotecario.getSelectedRow();
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
            File archivo = new File("C:\\Users\\User\\Desktop\\repositorio\\TEPRO_V1.1\\Ficheros\\PHipotecario.txt");
            if (archivo.exists()){
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                
                while((linea=br.readLine())!=null){
                    StringTokenizer st = new StringTokenizer(linea, ";");
                    String cod = st.nextToken().trim();
                    String cod1 = st.nextToken().trim();
                    
                    String tarjeta = st.nextToken().trim();
                    String dir = st.nextToken().trim();
                    String tipo = st.nextToken().trim();
                    String valor =st.nextToken().trim();
                     String est=st.nextToken().trim();
                      String pres=st.nextToken().trim();
                       String an=st.nextToken().trim();
                    
                    Object[] obj = new Object[]{
                      cod,cod1, tarjeta, dir, tipo, valor , est, pres, an
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
            fw= new FileWriter("C:\\Users\\User\\Desktop\\repositorio\\TEPRO_V1.1\\Ficheros\\PHipotecario.txt", true);
            //escribir el archivo
            pw=new PrintWriter(fw);
            //enviar datos al archivo
            PrestamoHipotecario obj = new PrestamoHipotecario();
            PrestamoAdelantoSueldo obj1 = new PrestamoAdelantoSueldo();
            Cliente obj2 = new Cliente();
                    
            
            
            obj.setCcodigo(Integer.parseInt(txtCCliente.getText()));
            obj.setCemodigo(Integer.parseInt(txtCEmpleado.getText()));
            obj1.setNumerotarjeta(Integer.parseInt(txtNTarjeta.getText()));
            obj2.setDireccion(txtDireccion.getText());
            obj.setTipo(cboTipo.getSelectedItem().toString());
            obj.setValor(Integer.parseInt(txtValor.getText()));
            obj.setEstado(cboEstado.getSelectedItem().toString());
            obj.setMSolicitarPh(Integer.parseInt(txtPrestamo.getText()));
            obj.setAños(Integer.parseInt(txtCantidadaños.getText()));
            
//            obj.setMSolicitarA(Integer.parseInt(txtPrestamo.getText()));
//            obj.setNroCuotas(Integer.parseInt(txtCantidadaños.getText()));
//            
//            obj.setNumerotarjeta(Integer.parseInt(txtNTarjeta.getText()));
//            obj.setSueldocliente(Integer.parseInt(txtPrestamo.getText()));
//
//            
            pw.println(
                  obj.getCcodigo()+ ";"+
                    
                          
                    +obj.getCemodigo()+ ";" 
                    +obj1.getNumerotarjeta()+";"
                    +obj2.getDireccion()+";"
                    +obj.getTipo()+";"
                    +obj.getValor()+";"
                    +obj.getEstado()+";"
                    +obj.getMSolicitarPh()+";"
                    +obj.getAños()+";" 
            );
            
            //liberar buffer
            pw.close();
            //enviar mensaje de exito
            JOptionPane.showMessageDialog(null, "Prestamo Registrado");
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error Fichero: \n" + ex.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public frmPrestamoHipotecario() {
        initComponents();
        setLocationRelativeTo(null);
        DesHabilitarTextos();
        DesHabilitarBotones();
       ColumnasTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtCEmpleado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCCliente = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNTarjeta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPrestamo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCantidadaños = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrestamoHipotecario = new javax.swing.JTable();
        btnExportarExcel2007 = new javax.swing.JButton();
        cboTipo = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtCEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCEmpleadoKeyTyped(evt);
            }
        });

        jLabel1.setText("Codigo Cliente:");

        jLabel2.setText("Codigo Empleado:");

        txtCCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCClienteKeyTyped(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

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

        txtNTarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNTarjetaKeyTyped(evt);
            }
        });

        jLabel5.setText("Número de Tarjeta:");

        jLabel3.setText("Direcciòn del inmueble:");

        jLabel4.setText("Estado del bien");

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });

        jLabel6.setText("Valor del bien");

        jLabel7.setText("Cantidad de años a devolver:");

        txtPrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrestamoKeyTyped(evt);
            }
        });

        jLabel8.setText("Prestamo a Solicitar");

        txtCantidadaños.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadañosKeyTyped(evt);
            }
        });

        jLabel9.setText("Tipo de hipoteca:");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo", "Usado" }));

        tblPrestamoHipotecario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPrestamoHipotecario);

        btnExportarExcel2007.setText("Exportar Excel 2007");
        btnExportarExcel2007.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarExcel2007ActionPerformed(evt);
            }
        });

        cboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comprar casa", "comprar terreno", "remodelar casa" }));

        btnLimpiar.setText("Limpiar");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(txtPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtNTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExportarExcel2007)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(154, 154, 154))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(235, 235, 235))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCantidadaños, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExportarExcel2007))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCCliente))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCEmpleado))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(176, 176, 176)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadaños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCClienteKeyTyped
        char c = evt.getKeyChar();
        
        if(txtCCliente.getText().length()>= 6 ){
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
           }
         if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCClienteKeyTyped

    private void txtCEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCEmpleadoKeyTyped
        char c = evt.getKeyChar();
        
        if(txtCEmpleado.getText().length()>= 6 ){
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
           }
         if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCEmpleadoKeyTyped

    private void txtNTarjetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNTarjetaKeyTyped
        char c = evt.getKeyChar();
        
        if(txtNTarjeta.getText().length()>= 10 ){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            Toolkit.getDefaultToolkit().beep();
            
           }
         if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNTarjetaKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        char c = evt.getKeyChar();
        
        if(txtDireccion.getText().length()>= 35 ){
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
           }
        
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        char c = evt.getKeyChar();
        
        if(txtValor.getText().length()>= 7 ){
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
           }
         if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtValorKeyTyped

    private void txtPrestamoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrestamoKeyTyped
        char c = evt.getKeyChar();
        
        if(txtPrestamo.getText().length()>= 6 ){
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
           }
         if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtPrestamoKeyTyped

    private void txtCantidadañosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadañosKeyTyped
        char c = evt.getKeyChar();
        
        if(txtCantidadaños.getText().length()>= 2 ){
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
           }
         if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCantidadañosKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Limpiar();
        HabilitarTextos();
        HabilitarBotones();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnExportarExcel2007ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarExcel2007ActionPerformed
        try {
            Clases.clsExportarExcel obj = new Clases.clsExportarExcel();
            obj.exportarExcel2010(tblPrestamoHipotecario);
        } catch (IOException ex) {
            Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarExcel2007ActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        llenarTabla();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        DesHabilitarTextos();
        DesHabilitarBotones();
        
        PrestamoHipotecario obj4 = new PrestamoHipotecario();
           
                
            PrestamoHipotecario obj = new PrestamoHipotecario();
            PrestamoAdelantoSueldo obj1 = new PrestamoAdelantoSueldo();
            Cliente obj2 = new Cliente();
            
//            obj.setCcodigo(Integer.parseInt(txtCCliente.getText()));
//            obj.setCemodigo(Integer.parseInt(txtCEmpleado.getText()));
//            obj1.setNumerotarjeta(Integer.parseInt(txtNTarjeta.getText()));
//            obj2.setDireccion(txtDireccion.getText());
//            obj.setTipo(cboTipo.getSelectedItem().toString());
//            obj.setValor(Integer.parseInt(txtValor.getText()));
//            obj.setEstado(cboEstado.getSelectedItem().toString());
//            obj.setMSolicitarPh(Integer.parseInt(txtPrestamo.getText()));
//            obj.setAños(Integer.parseInt(txtCantidadaños.getText()));
            
          
        
        Object[] fila = new Object[9];
        fila[0] = obj.getCcodigo();
        fila[1] = obj.getCemodigo();
        fila[2] = obj1.getNumerotarjeta();
        fila[3] = obj2.getDireccion();
        fila[4] = obj.getTipo();
        fila[5] = obj.getValor();
        fila[6] =obj.getEstado() ;
        fila[7] = obj.getMSolicitarPh();
        fila[8] =obj.getAños() ;
        modelo.addRow(fila);

        Enviarfichero();
        modelo.setRowCount(0);
        llenarTabla();
        Limpiar();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        DesHabilitarTextos();
        DesHabilitarBotones();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        Eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiartabla();
    }//GEN-LAST:event_btnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrestamoHipotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrestamoHipotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrestamoHipotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrestamoHipotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrestamoHipotecario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportarExcel2007;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPrestamoHipotecario;
    private javax.swing.JTextField txtCCliente;
    private javax.swing.JTextField txtCEmpleado;
    private javax.swing.JTextField txtCantidadaños;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNTarjeta;
    private javax.swing.JTextField txtPrestamo;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
