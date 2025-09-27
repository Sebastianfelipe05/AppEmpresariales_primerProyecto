/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primerproyecto.interfaz;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;
import primerproyecto.model.Carro;
import primerproyecto.model.Vehiculo;
import primerproyecto.service.ServicioVehiculo;

/**
 *
 * @author Sebastian
 */
public class GUIListCarro extends javax.swing.JFrame implements ICambio {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIListCarro.class.getName());

    private ServicioVehiculo barbosa = ServicioVehiculo.getInstance();

    // Colores del tema moderno
    private static final Color BACKGROUND_COLOR = new Color(245, 248, 250);
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color HEADER_COLOR = new Color(52, 73, 94);

    public GUIListCarro() {
        this.setTitle("🚗 Lista de Carros - Patrón Observer");
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                barbosa.deleteWindow(GUIListCarro.this);
            }
        });
        initComponents();
        customizeUI();
        makeResponsive();
        cambio(); // Cargar datos iniciales
    }

    private void customizeUI() {
        getContentPane().setBackground(BACKGROUND_COLOR);

        // Personalizar la tabla
        customizeTable();

        // Personalizar botones
        customizeButton(btnListar, "🔄 ACTUALIZAR LISTA", SUCCESS_COLOR);
        customizeButton(btnSalir, "❌ CERRAR", new Color(231, 76, 60));
        customizeButton(btnCalcularValor, "💰 CALCULAR VALOR TOTAL", PRIMARY_COLOR);
    }

    private void customizeTable() {
        // Personalizar la tabla
        jTCarro.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jTCarro.setRowHeight(35);
        jTCarro.setGridColor(new Color(189, 195, 199));
        jTCarro.setSelectionBackground(new Color(174, 207, 245));
        jTCarro.setSelectionForeground(new Color(52, 73, 94));
        jTCarro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Personalizar header de la tabla
        jTCarro.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTCarro.getTableHeader().setBackground(HEADER_COLOR);
        jTCarro.getTableHeader().setForeground(Color.WHITE);
        jTCarro.getTableHeader().setPreferredSize(new Dimension(0, 40));

        // Centrar contenido de ciertas columnas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // Personalizar el scroll pane
        jScrollPane1.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
            "📋 Lista de Carros Registrados (Observer Pattern)",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new Font("Segoe UI", Font.BOLD, 14),
            PRIMARY_COLOR
        ));
        jScrollPane1.getViewport().setBackground(Color.WHITE);
    }

    private void makeResponsive() {
        setLayout(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(HEADER_COLOR);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titleLabel = new JLabel("🚗 GESTIÓN DE CARROS");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerPanel.add(titleLabel);

        // Main content panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(BACKGROUND_COLOR);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        contentPanel.add(jScrollPane1, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.setBackground(new Color(236, 240, 241));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        buttonPanel.add(btnListar);
        buttonPanel.add(btnCalcularValor);
        buttonPanel.add(btnSalir);

        // Assembly
        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Configurar ventana responsive
        setMinimumSize(new Dimension(800, 500));
        setPreferredSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);
    }

    private void customizeButton(javax.swing.JButton button, String text, Color backgroundColor) {
        button.setText(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(180, 45));

        // Efecto hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            Color originalColor = backgroundColor;
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTCarro = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCalcularValor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // Configurar modelo de tabla mejorado
        jTCarro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "🔤 Placa", "🏷️ Marca", "🎨 Color", "📋 Modelo", "📅 Año",
                "⚙️ Estado", "🚪 Puertas", "❄️ A/C", "💰 Valor Comercial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTCarro);

        btnListar.setText("LISTAR");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnCalcularValor.setText("CALCULAR VALOR");
        btnCalcularValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularValorActionPerformed(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        cambio(); // Usar el patrón Observer
        JOptionPane.showMessageDialog(this,
            "✅ Lista actualizada usando el Patrón Observer\n\n" +
            "🔄 La tabla se actualiza automáticamente cuando\n" +
            "   se agregan, modifican o eliminan carros",
            "Patrón Observer en Acción",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        barbosa.deleteWindow(this);
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCalcularValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularValorActionPerformed
        double valorTotal = 0.0;
        int cantidadCarros = 0;

        List<Vehiculo> vehiculos = barbosa.readVehiculos();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Carro) {
                valorTotal += vehiculo.calcularValorComercial(); // POLIMORFISMO
                cantidadCarros++;
            }
        }

        String mensaje = String.format(
            "💰 CÁLCULO POLIMÓRFICO DE VALORES\n" +
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
            "🚗 Total de carros: %d\n" +
            "💵 Valor total del inventario de carros: $%.2f\n" +
            "📊 Valor promedio por carro: $%.2f\n\n" +
            "✨ Cada carro calculó su valor usando su propia\n" +
            "   implementación del método calcularValorComercial()\n\n" +
            "🔧 ¡Polimorfismo en acción!",
            cantidadCarros, valorTotal,
            cantidadCarros > 0 ? valorTotal / cantidadCarros : 0.0
        );

        JOptionPane.showMessageDialog(this, mensaje,
            "📊 Análisis Polimórfico de Carros",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnCalcularValorActionPerformed

    @Override
    public void cambio() {
        // Implementación del patrón Observer
        DefaultTableModel model = (DefaultTableModel) jTCarro.getModel();
        model.setRowCount(0); // Limpiar tabla

        List<Vehiculo> vehiculos = barbosa.readVehiculos();

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Carro) {
                Carro carro = (Carro) vehiculo;
                model.addRow(new Object[]{
                    carro.getPlaca(),
                    carro.getMarca(),
                    carro.getColor(),
                    carro.getModelo(),
                    carro.getAnio(),
                    carro.getEstado(),
                    carro.getNumeroPuertas(),
                    carro.isTieneAireAcondicionado() ? "Sí" : "No",
                    String.format("$%.2f", carro.calcularValorComercial()) // POLIMORFISMO
                });
            }
        }

        // Actualizar título con cantidad
        setTitle(String.format("🚗 Lista de Carros (%d registrados) - Observer Pattern",
            model.getRowCount()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcularValor;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCarro;
    // End of variables declaration//GEN-END:variables
}
