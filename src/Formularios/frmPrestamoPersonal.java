/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;


import Clases.PrestamoPersonal;
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
 * @author UPN
 */
public class frmPrestamoPersonal extends javax.swing.JFrame {

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
        txtCodigo.setEnabled(true);
        txtEmpleado.setEnabled(true);
       txtMontoSoli.setEnabled(true);
        txtNcuotasP.setEnabled(true);
        txtSueldoCliente.setEnabled(true);
      txtTarjeta.setEnabled(true);
       
    }
    
    private void DesHabilitarTextos(){
         txtCodigo.setEnabled(false);
        txtEmpleado.setEnabled(false);
       txtMontoSoli.setEnabled(false);
        txtNcuotasP.setEnabled(false);
        txtSueldoCliente.setEnabled(false);
      txtTarjeta.setEnabled(false);
       
    }
    private void Limpiar(){
        
        txtCodigo.setText(null);
        txtEmpleado.setText(null);
       txtMontoSoli.setText(null);
        txtNcuotasP.setText(null);
        txtSueldoCliente.setText(null);
      txtTarjeta.setText(null);
        
        txtCodigo.requestFocus();
    }
    private void Eliminar(){
        int fila=TblPrestamoP.getSelectedRow();
        modelo.removeRow(fila);
    }
    private void Limpiartabla(){
        int filas=modelo.getRowCount();
        for(int i=0;i<filas;i++)
        {
            modelo.removeRow(0);
        }
    }
    private void ColumnasTabla(){
        modelo.addColumn("Codigo Cliente");
        modelo.addColumn("Codigo Empleado");
        modelo.addColumn("N° Cuotas");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Numero de Tarjeta");
        modelo.addColumn("Monto a Solicitar");
        TblPrestamoP.setModel(modelo);                        
    } 
     private void llenarTabla(){
        try{
            File archivo = new File("C:\\Users\\User\\Desktop\\repositorio\\TEPRO_V1.1\\Ficheros\\PPersonal.txt");
            if (archivo.exists()){
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                
                while((linea=br.readLine())!=null){
                    StringTokenizer st = new StringTokenizer(linea, ";");
                    String codc = st.nextToken().trim();
                    String code = st.nextToken().trim();
                    String cuo = st.nextToken().trim();
                    String sue = st.nextToken().trim();
                    String tar=st.nextToken().trim();
                     String monto=st.nextToken().trim();
                    
                    Object[] obj = new Object[]{
                      codc, code, cuo, sue, tar ,monto
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
            fw= new FileWriter("C:\\PPersonal.txt", true);
            //escribir el archivo
            pw=new PrintWriter(fw);
            //enviar datos al archivo
            PrestamoPersonal obj = new PrestamoPersonal();
            obj.setCodigoCliente(txtCodigo.getText());
            obj.setCodigoEmpleado(txtEmpleado.getText());
            obj.setNroCuotas(Integer.parseInt(txtNcuotasP.getText()));
            obj.setSueldo(Double.parseDouble(txtSueldoCliente.getText()));
            obj.setNtarjeta(Integer.parseInt(txtTarjeta.getText()));
            obj.setMSolicitarP(Integer.parseInt(txtMontoSoli.getText()));
   
            
            pw.println(
            obj.getCodigoCliente() + ";"
            + obj.getCodigoEmpleado()+ ";" 
            + obj.getNroCuotas()+ ";" 
            + obj.getSueldo()+ ";"
            + obj.getNtarjeta()+ ";"
            + obj.getMSolicitarP()+ ";"
            );
            
            //liberar buffer
            pw.close();
            //enviar mensaje de exito
            JOptionPane.showMessageDialog(null, "Prestamo Registrado");
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error Fichero: \n" + ex.getMessage());
        }
    }
    

    
    
    
    public frmPrestamoPersonal() {
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

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNcuotasP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMontoSoli = new javax.swing.JTextField();
        btnGrabar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblPrestamoP = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        txtSueldoCliente = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnExportarExcel2007 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Codigo Cliente");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        jLabel2.setText("N° de Cuotas");

        txtNcuotasP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNcuotasPKeyTyped(evt);
            }
        });

        jLabel3.setText("Sueldo del cliente ");

        jLabel4.setText("N° de Tarjeta");

        txtTarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTarjetaKeyTyped(evt);
            }
        });

        jLabel5.setText("Monto a Solicitar");

        txtMontoSoli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoSoliKeyTyped(evt);
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

        TblPrestamoP.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TblPrestamoP);

        jLabel6.setText("Codigo Empleado");

        txtEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmpleadoKeyTyped(evt);
            }
        });

        txtSueldoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoClienteKeyTyped(evt);
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

        btnExportarExcel2007.setText("Exportar Excel 2007");
        btnExportarExcel2007.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarExcel2007ActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNcuotasP, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMontoSoli, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTarjeta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSueldoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(btnExportarExcel2007))
                            .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNcuotasP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSueldoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExportarExcel2007)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoSoli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
            DesHabilitarTextos();
        DesHabilitarBotones();
        PrestamoPersonal obj = new PrestamoPersonal();

            Object[] fila = new Object[6];
            fila[0] = obj.getCodigoCliente();
            fila[1] = obj.getCodigoEmpleado();
            fila[2] = obj.getNroCuotas();
            fila[3] = obj.getSueldo();
            fila[4]=  obj.getNtarjeta();
            fila[5]=  obj.getMSolicitarP();
            modelo.addRow(fila);  
            Enviarfichero();
            
        modelo.setRowCount(0);
        llenarTabla();
        Limpiar();
            
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char c = evt.getKeyChar();
        
        if(txtCodigo.getText().length()>= 6 ){
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            evt.consume();
           }
         if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpleadoKeyTyped
        char c = evt.getKeyChar();
        
        if(txtEmpleado.getText().length()>= 6 ){
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            evt.consume();
           }
         if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtEmpleadoKeyTyped

    private void txtNcuotasPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNcuotasPKeyTyped
        char c = evt.getKeyChar();
        
        if(txtNcuotasP.getText().length()>= 2 ){
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            evt.consume();
           }
         if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNcuotasPKeyTyped

    private void txtSueldoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoClienteKeyTyped
        char c = evt.getKeyChar();
        
        if(txtSueldoCliente.getText().length()>= 5 ){
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            evt.consume();
           }
         if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtSueldoClienteKeyTyped

    private void txtTarjetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTarjetaKeyTyped
        char c = evt.getKeyChar();
        
        if(txtTarjeta.getText().length()>= 10 ){
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            evt.consume();
           }
         if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtTarjetaKeyTyped

    private void txtMontoSoliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoSoliKeyTyped
        char c = evt.getKeyChar();
        
        if(txtMontoSoli.getText().length()>= 6 ){
            JOptionPane.showMessageDialog(null, "Limite de Caracteres");
            evt.consume();
           }
         if(c<'0' || c>'9'){
            JOptionPane.showMessageDialog(null, "No se Aceptan Letras");
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtMontoSoliKeyTyped

    private void btnExportarExcel2007ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarExcel2007ActionPerformed
        try {
            Clases.clsExportarExcel obj = new Clases.clsExportarExcel();
            obj.exportarExcel2010(TblPrestamoP);
        } catch (IOException ex) {
            Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarExcel2007ActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Limpiar();
        HabilitarTextos();
        HabilitarBotones();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        DesHabilitarTextos();
        DesHabilitarBotones();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiartabla();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Limpiartabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrestamoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrestamoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrestamoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrestamoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrestamoPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblPrestamoP;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportarExcel2007;
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
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtMontoSoli;
    private javax.swing.JTextField txtNcuotasP;
    private javax.swing.JTextField txtSueldoCliente;
    private javax.swing.JTextField txtTarjeta;
    // End of variables declaration//GEN-END:variables
}
