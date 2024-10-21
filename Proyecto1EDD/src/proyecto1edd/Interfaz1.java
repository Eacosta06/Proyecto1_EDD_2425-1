/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1edd;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author maria
 */
public class Interfaz1 extends javax.swing.JFrame {
    int t;

    /**
     * Creates new form Interfaz1
     */
    public Interfaz1() {
        initComponents();
        t = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        MostrarGrafo = new javax.swing.JButton();
        NuevoValorT = new javax.swing.JTextField();
        LabelT = new javax.swing.JLabel();
        LabelSucursal = new javax.swing.JLabel();
        SucursalNueva = new javax.swing.JTextField();
        Lineanueva = new javax.swing.JScrollPane();
        LineaNueva = new javax.swing.JTextArea();
        LabelLinea = new javax.swing.JLabel();
        GuardarSucursal = new javax.swing.JButton();
        GuardarLinea = new javax.swing.JButton();
        GuardarT = new javax.swing.JButton();
        VerCobertura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Sylfaen", 1, 37)); // NOI18N
        Titulo.setText("Cobertura de sucursales");
        jPanel1.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 410, -1));

        MostrarGrafo.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        MostrarGrafo.setText("Mostrar Grafo");
        MostrarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarGrafoActionPerformed(evt);
            }
        });
        jPanel1.add(MostrarGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 130, -1));

        NuevoValorT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoValorTActionPerformed(evt);
            }
        });
        jPanel1.add(NuevoValorT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 240, -1));

        LabelT.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        LabelT.setText("Inserta un valor para \"t\"");
        jPanel1.add(LabelT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        LabelSucursal.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        LabelSucursal.setText("Colocar sucursal");
        jPanel1.add(LabelSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        SucursalNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SucursalNuevaActionPerformed(evt);
            }
        });
        jPanel1.add(SucursalNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 240, -1));

        LineaNueva.setColumns(20);
        LineaNueva.setRows(5);
        Lineanueva.setViewportView(LineaNueva);

        jPanel1.add(Lineanueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 240, -1));

        LabelLinea.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        LabelLinea.setText("Agregar linea");
        jPanel1.add(LabelLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        GuardarSucursal.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        GuardarSucursal.setText("Guardar sucursal");
        GuardarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarSucursalActionPerformed(evt);
            }
        });
        jPanel1.add(GuardarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 130, -1));

        GuardarLinea.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        GuardarLinea.setText("Guardar linea");
        jPanel1.add(GuardarLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));

        GuardarT.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        GuardarT.setText("Guardar \"T\"");
        jPanel1.add(GuardarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        VerCobertura.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        VerCobertura.setText("Ver Cobertura");
        VerCobertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerCoberturaActionPerformed(evt);
            }
        });
        jPanel1.add(VerCobertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarGrafoActionPerformed
// Especificar que se usará Swing como interfaz de usuario
        System.setProperty("org.graphstream.ui", "swing");

        Graph graph = new SingleGraph("Cobertura de Sucursales");
        

        // Agregar nodos y asignarles un nombre/etiqueta
        Node nodeA = graph.addNode("A");
        nodeA.setAttribute("ui.label", "Nodo A");

        Node nodeB = graph.addNode("B");
        nodeB.setAttribute("ui.label", "Nodo B");

        Node nodeC = graph.addNode("C");
        nodeC.setAttribute("ui.label", "Nodo C");

        // Agregar aristas (edges) entre los nodos y asignarles etiquetas
        Edge edgeAB = graph.addEdge("AB", "A", "B");

        Edge edgeBC = graph.addEdge("BC", "B", "C");

        Edge edgeCA = graph.addEdge("CA", "C", "A");

        // Mostrar el grafo con etiquetas
        graph.display();
        
        
    }//GEN-LAST:event_MostrarGrafoActionPerformed

    private void NuevoValorTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoValorTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NuevoValorTActionPerformed

    private void SucursalNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SucursalNuevaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SucursalNuevaActionPerformed

    private void GuardarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardarSucursalActionPerformed

    private void VerCoberturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerCoberturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VerCoberturaActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GuardarLinea;
    private javax.swing.JButton GuardarSucursal;
    private javax.swing.JButton GuardarT;
    private javax.swing.JLabel LabelLinea;
    private javax.swing.JLabel LabelSucursal;
    private javax.swing.JLabel LabelT;
    private javax.swing.JTextArea LineaNueva;
    private javax.swing.JScrollPane Lineanueva;
    private javax.swing.JButton MostrarGrafo;
    private javax.swing.JTextField NuevoValorT;
    private javax.swing.JTextField SucursalNueva;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton VerCobertura;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

