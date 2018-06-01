/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class View extends javax.swing.JFrame {

    ArrayList<String> simbolo = new ArrayList(Arrays.asList("{", "}", "(", ")", ";", ",", "="));
    ArrayList<String> op = new ArrayList(Arrays.asList("+", "-", "*", "/", "%"));
    ArrayList<String> num = new ArrayList(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
    char begin[] = {'B', 'E', 'G', 'I', 'N'};
    int cont = 0, column = 0, enter = 0;
    DefaultListModel<String> errores = new DefaultListModel();
    DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public View() {
        initComponents();
        agregarColumnas();
        modeloTabla.setNumRows(100);
    }

    public void agregarColumnas() {
        modeloTabla.addColumn("Token");
        modeloTabla.addColumn("Lexema");
    }

    public void eliminarColumns() {
        int cantidad = modeloTabla.getColumnCount();
        for (int i = 0; i < cantidad; i++) {
            modeloTabla.removeRow(i);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Cargar Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 378, 243));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jList1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jList1.setForeground(new java.awt.Color(153, 0, 0));
        jList1.setModel(errores);
        jScrollPane3.setViewportView(jList1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 790, 120));

        jButton2.setText("Analizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jTable1.setModel(modeloTabla);
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 348, 243));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String texto = areaTexto.getText();
        System.out.println(texto);
        int i = 0;
        cont = 0;
        eliminarColumns();
        errores.clear();
        int count = texto.length();
        while (i < count && i >= 0) {
            System.out.println("es i:" + i);
            String aux = String.valueOf(texto.charAt(i));
            System.out.println(aux + "debe tener *");
            if (simbolo.contains(aux) || aux.equals(".")) {
                llenarTabla("tk_simbolo", aux);
                //i++;
            }

            if (aux.equals(" ")) {
                //aux=String.valueOf(texto.charAt(i+1));
                //System.out.println("entro y aux:"+aux);
            }
            if (op.contains(aux)) {
                llenarTabla("tk_operacion", aux);
                //i++;
            }

            if (aux.equals(aux.toUpperCase()) && Character.isAlphabetic(aux.charAt(0)) && !" ".equals(aux)) {
                while (!op.contains(aux) && !simbolo.contains(aux) && i < count && !" ".equals(aux)) {
                    System.out.println("aux: " + aux + " " + i);
                    switch (aux) {
                        case "B":
                            if ((i + 5 <= texto.length()) && (Character.isAlphabetic(texto.charAt(i + 1)))) {
                                System.out.println(texto.charAt(i + 1)+"  esta nel ");
                                //Calculo de las constantes 
                                System.out.println("entro a ifffff");
                                boolean flag = true;
                                int j = 1;
                                //Validacion de escritura
                                while (j < begin.length) {
                                    if (texto.charAt(++i) != begin[j]) {
                                        flag = false;
                                        j = 6;
                                    }
                                    aux = String.valueOf(texto.charAt(i));
                                    j++;
                                }
                                //Identificacion de errores
                                if (i + 1 < texto.length()) {
                                    //System.out.println("primer if");
                                    if (flag == true && (texto.charAt(i + 1) == ' ' || simbolo.contains(String.valueOf(texto.charAt(i + 1))) || texto.charAt(i + 1) == '\n')) {
                                        llenarTabla("tk_reservado", "BEGIN");
                                        aux = String.valueOf(texto.charAt(++i));
                                    } else {
                                        System.out.println("errrooor " + enter);
                                        errores.addElement("Error al intentar escribir BEGIN");

                                        while ((i + 1 < texto.length()) && (Character.isAlphabetic(texto.charAt(i++)) || num.contains(String.valueOf(aux.charAt(0))))) {
                                            aux = String.valueOf(texto.charAt(i));

                                        }
                                        if (i + 1 < texto.length()) {
                                            aux = String.valueOf(texto.charAt(i - 1));
                                            i--;
                                        } else {
                                            i++;
                                        }
                                    }
                                } else {
                                    llenarTabla("tk_reservado", "BEGIN");
                                    i++;
                                }

                            } else {
                                //Identificacion de variables
                                boolean flag = true;
                                int j = 0;
                                String var = "";
                                while (!op.contains(aux) && !simbolo.contains(aux) && j <= 3) {
                                    var += aux;
                                    System.out.println("aux 1" + aux);
                                    j++;
                                    if (i >= count - 1) {
                                        j = 5;
                                    } else {
                                        aux = String.valueOf(texto.charAt(++i));
                                    }
                                    if (" ".equals(aux) || "\n".equals(aux)) {
                                        j = 5;
                                    } else {
                                        if (!num.contains(aux) && j <= 4) {
                                            flag = false;
                                            j = 5;
                                        }
                                    }
                                }

                                if (flag == true) {

                                    llenarTabla("tk_variable", var);
                                    System.out.println("aux en i de inc" + aux);
                                    if(texto.charAt(i)!='\n'){
                                        i++;
                                    }
                                    //i++;

                                } else {
                                    System.out.println("errrooror " + enter);
                                    errores.addElement("Error al intentar escribir Variable con B***");
                                    while ((i + 1 < texto.length()) && (Character.isAlphabetic(texto.charAt(i++)) || num.contains(String.valueOf(aux.charAt(0))))) {
                                            aux = String.valueOf(texto.charAt(i));

                                    }
                                    if (i + 1 < texto.length()) {
                                            aux = String.valueOf(texto.charAt(i - 1));
                                            i--;
                                        } else {
                                            i++;
                                        }
                                    //i++;
                                }
                                System.out.println("fin i " + i);
                            }
                            break;

                        case "E":

                            break;

                        case "I":

                            break;

                        case "R":

                            break;
                        case " ":

                            if (i + 1 <= texto.length()) {
                                aux = String.valueOf(texto.charAt(i + 1));
                                i++;
                                System.out.println("entro a space");
                            }
                            break;
                        case "\n":
                            if (i + 1 <= texto.length()) {
                                aux = String.valueOf(texto.charAt(i+1));
                                i++;
                                ++enter;
                                System.out.println("entro a space " + aux + "  i " + i);
                            }
                            break;
                    }

                }

                i--;
                //System.out.println("aux: "+aux);
                //System.out.println(i+"---");
            }
            i++;
            //System.out.println(i+"BEGUN { { }");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private void llenarTabla(String token, String lexema) {
        modeloTabla.setValueAt(token, cont, 0);
        modeloTabla.setValueAt(lexema, cont, 1);
        cont++;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser j = new JFileChooser();

        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas

        int estado = j.showOpenDialog(null);

        if (estado == JFileChooser.APPROVE_OPTION) {
            File fichero = new File(j.getSelectedFile().toString());
            Scanner s = null;

            try {
                // Leemos el contenido del fichero

                s = new Scanner(fichero);
//creacion del fichero de tokens
                File archivo = new File("C:/Users/uli_v/Documents/tokens.txt");
                BufferedWriter bw;
                bw = new BufferedWriter(new FileWriter(archivo));
                // Leemos linea a linea el fichero
                while (s.hasNextLine()) {
                    String linea = s.nextLine(); 	// Guardamos la linea en un String

                    //obteniendo los tokens
                    if (!linea.isEmpty()) {
                        StringTokenizer st = new StringTokenizer(linea);
                        while (st.hasMoreElements()) {
                            String tokenActual = st.nextToken();

                            for (int i = 0; i < tokenActual.length(); i++) {
                                if (tokenActual.charAt(i) == 'B') {
                                    System.out.println("entra");
                                    bw = new BufferedWriter(new FileWriter(archivo));
                                    bw.write("Token_inicio-BEGIN");
                                }
                            }

                        }
                        areaTexto.setText(areaTexto.getText() + linea + "\n");
                    }
                    bw.close();
                }
            } catch (Exception ex) {
                System.out.println("Mensaje: " + ex.getMessage());
            } finally {

                // Cerramos el fichero tanto si la lectura ha sido correcta o no
                try {
                    if (s != null) {
                        s.close();
                    }
                } catch (Exception ex2) {
                    System.out.println("Mensaje 2: " + ex2.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                    new View().setVisible(true);
                } catch (Exception ex) {
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
