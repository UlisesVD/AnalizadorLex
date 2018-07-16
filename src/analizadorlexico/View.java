package analizadorlexico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class View extends javax.swing.JFrame {

    DefaultListModel<String> listModel = new DefaultListModel();
    //SIMBOLOS UTILIZADOS
    ArrayList<String> simbolo = new ArrayList(Arrays.asList("{", "}", "(", ")", ";", ",", "="));
    //OPERACIONES POSIBLES
    ArrayList<String> op = new ArrayList(Arrays.asList("+", "-", "*", "/", "%"));
    //SIMBOLOS INVALIDOS
    ArrayList<String> invalido = new ArrayList(Arrays.asList("°", "|", "¬", "!", "#", "$", "&", "'", "¿", "¡", "@", "´", "¨", "~", "[", "]", "^", ":", "_", "?"));
    //CARACTERES NUMERICOS
    ArrayList<String> num = new ArrayList(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
    //Variables analizadas 
    ArrayList<String> variables = new ArrayList();
    //PALABRAS RESERVADAS
    char begin[] = {'B', 'E', 'G', 'I', 'N'};
    char integer[] = {'I', 'N', 'T', 'E', 'G', 'E', 'R'};
    char write[] = {'W', 'R', 'I', 'T', 'E'};
    char read[] = {'R', 'E', 'A', 'D'};
    char real[] = {'R', 'E', 'A', 'L'};
    char end[] = {'E', 'N', 'D'};

    int cont = 0, enter = 1, i = 0, count = 0;

    String aux = "";

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
        int cantidad = modeloTabla.getRowCount();
        System.out.println("cantidad " + cantidad);
        for (int k = 0; k < 100; k++) {
            modeloTabla.removeRow(0);
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
        lista = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

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

        jScrollPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jScrollPane1ComponentMoved(evt);
            }
        });

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        areaTexto.setTabSize(4);
        jScrollPane1.setViewportView(areaTexto);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 400, 243));

        lista.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lista.setModel(listModel);
        jPanel1.add(lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 30, 240));

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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 810, 120));

        jButton2.setText("Analizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jTable1.setModel(modeloTabla);
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 50, 340, 243));

        jButton3.setText("Guardar Tokens");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

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
        cont = 0;
        i = 0;
        enter = 1;
        eliminarColumns();
        listModel.clear();
        modeloTabla.setNumRows(100);
        listModel.addElement("1");
        variables.clear();
        errores.clear();
        count = texto.length();

        while (i < count && i >= 0) {
            aux = String.valueOf(texto.charAt(i));
            if (simbolo.contains(aux) || aux.equals(".")) {
                llenarTabla("tk_simbolo", aux);
            }

            if (op.contains(aux)) {
                llenarTabla("tk_operacion", aux);
            }

            if (aux.equals("\n")) {
                ++enter;
                listModel.addElement(String.valueOf(enter));
            }

            if (invalido.contains(aux)) {
                errores.addElement("Simbolo invalido en linea " + enter);
            }

            if (num.contains(aux)) {
                boolean flag = true, decimal = false;
                String numero = "";
                int fin = 1;
                String token = "tk_num_entero";
                while (flag && i + 1 < texto.length() && fin < 2) {
                    numero += aux;
                    aux = String.valueOf(texto.charAt(++i));
                    int d = i;
                    if (aux.equals(".") && d + 1 < texto.length()) {
                        decimal = true;
                        int point = d + 2;
                        System.out.println("texto"+texto.charAt(i));
                        if (num.contains(String.valueOf(texto.charAt(i + 1)))) {
                            while (d <= point && d + 1 < texto.length() && fin <= 2) {
                                numero += aux;
                                i++;
                                aux = String.valueOf(texto.charAt(i));

                                d++;
                                if ((!num.contains(aux) && !aux.equals("."))) {
                                    System.out.println("entra" + aux);
                                    flag = false;

                                    d = d + 2;
                                    fin = 3;
                                }

                                fin++;
                            }
                        } else {
                            flag = false;
                        }

                        if (num.contains(aux)) {
                            numero += aux;
                        } else {
                            aux = String.valueOf(texto.charAt(--i));
                        }
                    } else {
                        if (!num.contains(aux) && !aux.equals(" ")) {
                            aux = String.valueOf(texto.charAt(--i));
                            flag = false;
                        }
                    }
                }

                if (decimal) {
                    if (i + 1 <= texto.length() || flag == true && !".".equals(String.valueOf(texto.charAt(i + 1))) && !Character.isAlphabetic(texto.charAt(i + 1)) && !num.contains(String.valueOf(texto.charAt(i + 1)))) {
                        llenarTabla("tk_real", numero);
                    } else {
                        errores.addElement("Error al escribir el numero " + numero + " en la linea " + enter);
                        while ((i + 1 < texto.length()) && (Character.isAlphabetic(texto.charAt(i++)) || num.contains(String.valueOf(aux.charAt(0))) || ".".equals(String.valueOf(texto.charAt(i + 1))))) {
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

                    if (flag == true || (!Character.isAlphabetic(texto.charAt(i + 1)) || aux.equals(" "))) {
                        if (flag) {
                            llenarTabla(token, numero + aux);
                        } else {
                            llenarTabla(token, numero);
                        }

                    } else {
                        errores.addElement("Error al escribir el numero " + numero + " en la linea " + enter);
                        while ((i + 1 < texto.length()) && (Character.isAlphabetic(texto.charAt(i++)) || num.contains(String.valueOf(aux.charAt(0))) || ".".equals(String.valueOf(texto.charAt(i + 1))))) {
                            aux = String.valueOf(texto.charAt(i));
                        }

                        if (i + 1 < texto.length()) {
                            aux = String.valueOf(texto.charAt(i - 1));
                            i--;
                        } else {
                            aux = String.valueOf(texto.charAt(i));
                            i++;
                        }
                    }
                }

            }
            if (aux.equals(aux.toUpperCase()) && Character.isAlphabetic(aux.charAt(0)) && !" ".equals(aux)) {
                while (!op.contains(aux) && !simbolo.contains(aux) && i < count && !" ".equals(aux)) {
                    switch (aux) {
                        case "B":
                            checkTokens(texto, begin, "tk_reservado", "BEGIN", "Error al intentar escribir BEGIN en linea ");
                            break;
                        case "E":
                            checkTokens(texto, end, "tk_reservado", "END", "Error al intentar escribir END en linea ");
                            break;
                        case "I":
                            checkTokens(texto, integer, "tk_reservado", "INTEGER", "Error al intentar escribir INTEGER en linea ");
                            break;
                        case "R":
                            if (texto.charAt(i + 3) == 'L') {
                                checkTokens(texto, real, "tk_reservado", "REAL", "Error al intentar escribir REAL en linea ");
                            } else {
                                checkTokens(texto, read, "tk_reservado", "READ", "Error al intentar escribir READ en linea ");
                            }
                            break;
                        case "W":
                            checkTokens(texto, write, "tk_reservado", "WRITE", "Error al intentar escribir WRITE en linea ");
                            break;
                        case " ":
                            if (i + 1 <= texto.length()) {
                                aux = String.valueOf(texto.charAt(i + 1));
                                i++;
                            }
                            break;
                        case "\n":

                            if (i + 2 <= texto.length()) {
                                //System.out.println("I= " + (i + 1) + " T= " + texto.length() + " AUX " + aux);
                                aux = String.valueOf(texto.charAt(i + 1));
                                i++;
                                ++enter;
                                listModel.addElement(String.valueOf(enter));
                            } else {
                                i++;
                            }
                            break;

                        default:
                            checarVariables(texto);
                            break;
                    }
                }
                i--;
            }

            if (aux.equals(aux.toLowerCase()) && !aux.equals(" ") && !aux.equals("\n") && Character.isAlphabetic(aux.charAt(0))) {

                //while (!op.contains(aux) && !simbolo.contains(aux) && i < count && !" ".equals(aux) && !aux.equals("\n") && i < texto.length()) {
                checarVariables(texto);

                //}
                if (simbolo.contains(aux) || op.contains(aux) || aux.equals("\n") || aux.equals(" ")) {
                    if (aux.equals("\n")) {
                        enter++;
                        listModel.addElement(String.valueOf(enter));
                    }
                    i--;
                }

            }

            i++;
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public void checarVariables(String texto) {
        //Identificacion de variables
        boolean flag = true;
        int j = 0;
        String var = "";

        if (texto.length() > i + 1 && num.contains(String.valueOf(texto.charAt(i + 1)))) {
            while (!op.contains(aux) && !simbolo.contains(aux) && j <= 3) {
                var += aux;
                j++;
                if (i >= count - 1) {
                    j = 5;
                } else {
                    aux = String.valueOf(texto.charAt(++i));
                }
                if (" ".equals(aux) || "\n".equals(aux)) {
                    //aux = String.valueOf(texto.charAt(--i));
                    j = 5;
                } else {
                    if (!num.contains(aux) && j <= 3) {
                        flag = false;
                        //aux = String.valueOf(texto.charAt(--i));
                        j = 5;
                    }
                }
            }
        }
        if (j == 4 || Character.isAlphabetic(aux.charAt(0))) {
            flag = false;
        }

        if (var.length() > 1 && (flag == true || simbolo.contains(aux) || op.contains(aux) || !num.contains(aux))) {
            if (!variables.contains(var)) {
                variables.add(var);
                llenarTabla("tk_variable", var);
            }
            if (texto.charAt(i) != '\n' && !simbolo.contains(aux) && !op.contains(aux)) {
                i++;
            }
        } else {
            errores.addElement("Error al intentar escribir Variable " + var + " en Linea " + enter);
            while ((i + 1 < texto.length()) && (Character.isAlphabetic(texto.charAt(i++)) || num.contains(String.valueOf(aux.charAt(0))) || ".".equals(String.valueOf(texto.charAt(i + 1))))) {
                aux = String.valueOf(texto.charAt(i));
            }
            if (i + 1 < texto.length()) {
                aux = String.valueOf(texto.charAt(i - 1));
                i--;
            } else {
                i++;
            }

        }
    }

    public void checkTokens(String texto, char aray[], String token, String lexema, String error) {
        if ((i + aray.length <= texto.length()) && (Character.isAlphabetic(texto.charAt(i + 1)))) {
            //Calculo de las constantes 
            boolean flag = true;
            int j = 1;
            //Validacion de escritura
            while (j < aray.length) {

                if (texto.charAt(++i) != aray[j]) {
                    flag = false;
                    j = aray.length;
                }

                aux = String.valueOf(texto.charAt(i));
                j++;
            }
            //Identificacion de errores
            if (i + 1 < texto.length()) {

                if (flag == true && (texto.charAt(i + 1) == ' ' || simbolo.contains(String.valueOf(texto.charAt(i + 1))) || texto.charAt(i + 1) == '\n')) {
                    llenarTabla(token, lexema);
                    aux = String.valueOf(texto.charAt(++i));
                } else {
                    errores.addElement(error + enter);
                    while ((i + 1 < texto.length()) && (Character.isAlphabetic(texto.charAt(i++)) || num.contains(String.valueOf(aux.charAt(0))) || ".".equals(String.valueOf(texto.charAt(i + 1))))) {
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
                llenarTabla(token, lexema);
                i++;
            }

        } else {
            checarVariables(texto);
        }
    }

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
                areaTexto.setText("");
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String ruta = "src/tokens/tokens.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;

        try {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Token             |  Lexema  \n");
            for (int j = 0; j < 100; j++) {
                if (modeloTabla.getValueAt(j, 0) != null) {
                    bw.write(modeloTabla.getValueAt(j, 0) + "         ");
                    bw.write(modeloTabla.getValueAt(j, 1) + "\n");
                } else {
                    break;
                }
            }
            bw.close();
            JOptionPane.showMessageDialog(this, "Archivo guardado en ruta src/tokens", "Successful", JOptionPane.OK_OPTION);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jScrollPane1ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jScrollPane1ComponentMoved
        System.out.println("hey");
    }//GEN-LAST:event_jScrollPane1ComponentMoved

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
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JList<String> lista;
    // End of variables declaration//GEN-END:variables
}
