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
import primerproyecto.model.Bus;
import primerproyecto.model.Vehiculo;
import primerproyecto.service.ServicioVehiculo;

/**
 *
 * @author Sebastian
 */
public class GUIListBus extends javax.swing.JFrame implements ICambio {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIListBus.class.getName());

    private ServicioVehiculo barbosa = ServicioVehiculo.getInstance();

    // Colores del tema moderno (amarillo para buses)
    private static final Color BACKGROUND_COLOR = new Color(245, 248, 250);
    private static final Color PRIMARY_COLOR = new Color(241, 196, 15);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color HEADER_COLOR = new Color(52, 73, 94);
    private static final Color INFO_COLOR = new Color(155, 89, 182);

    public GUIListBus() {
        this.setTitle("🚌 Lista de Buses - Patrón Observer");
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                barbosa.deleteWindow(GUIListBus.this);
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
        customizeButton(btnCalcularTarifas, "🎫 CALCULAR TARIFAS", INFO_COLOR);
    }

    private void customizeTable() {
        // Personalizar la tabla
        jTBus.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        jTBus.setRowHeight(35);
        jTBus.setGridColor(new Color(189, 195, 199));
        jTBus.setSelectionBackground(new Color(255, 235, 156));
        jTBus.setSelectionForeground(new Color(52, 73, 94));
        jTBus.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Personalizar header de la tabla
        jTBus.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 11));
        jTBus.getTableHeader().setBackground(HEADER_COLOR);
        jTBus.getTableHeader().setForeground(Color.WHITE);
        jTBus.getTableHeader().setPreferredSize(new Dimension(0, 40));

        // Personalizar el scroll pane
        jScrollPane1.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
            "🚌 Lista de Buses Registrados (Observer Pattern)",
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

        JLabel titleLabel = new JLabel("🚌 GESTIÓN DE BUSES");
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
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(new Color(236, 240, 241));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        buttonPanel.add(btnListar);
        buttonPanel.add(btnCalcularValor);
        buttonPanel.add(btnCalcularTarifas);
        buttonPanel.add(btnSalir);

        // Assembly
        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Configurar ventana responsive
        setMinimumSize(new Dimension(900, 500));
        setPreferredSize(new Dimension(1200, 650));
        setLocationRelativeTo(null);
    }

    private void customizeButton(javax.swing.JButton button, String text, Color backgroundColor) {
        button.setText(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(160, 40));

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
        jTBus = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCalcularValor = new javax.swing.JButton();
        btnCalcularTarifas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // Configurar modelo de tabla mejorado para buses
        jTBus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "🔤 Placa", "🏷️ Marca", "🎨 Color", "📋 Modelo", "📅 Año",
                "⚙️ Estado", "📺 TVs", "🚿 Baño", "🏢 2do Piso", "👥 Pasajeros", "💰 Valor Comercial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTBus);

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

        btnCalcularTarifas.setText("CALCULAR TARIFAS");
        btnCalcularTarifas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularTarifasActionPerformed(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        cambio(); // Usar el patrón Observer
        JOptionPane.showMessageDialog(this,
            "✅ Lista actualizada usando el Patrón Observer\n\n" +
            "🔄 La tabla se actualiza automáticamente cuando\n" +
            "   se agregan, modifican o eliminan buses",
            "Patrón Observer en Acción",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        barbosa.deleteWindow(this);
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCalcularValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularValorActionPerformed
        double valorTotal = 0.0;
        int cantidadBuses = 0;

        List<Vehiculo> vehiculos = barbosa.readVehiculos();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Bus) {
                valorTotal += vehiculo.calcularValorComercial(); // POLIMORFISMO
                cantidadBuses++;
            }
        }

        String mensaje = String.format(
            "💰 CÁLCULO POLIMÓRFICO DE VALORES - BUSES\n" +
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
            "🚌 Total de buses: %d\n" +
            "💵 Valor total del inventario de buses: $%.2f\n" +
            "📊 Valor promedio por bus: $%.2f\n\n" +
            "✨ Cada bus calculó su valor usando su propia\n" +
            "   implementación del método calcularValorComercial()\n" +
            "🏢 Bonificaciones por segundo piso, baño y TVs\n\n" +
            "🔧 ¡Polimorfismo en acción!",
            cantidadBuses, valorTotal,
            cantidadBuses > 0 ? valorTotal / cantidadBuses : 0.0
        );

        JOptionPane.showMessageDialog(this, mensaje,
            "📊 Análisis Polimórfico de Buses",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnCalcularValorActionPerformed

    private void btnCalcularTarifasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularTarifasActionPerformed
        List<Vehiculo> vehiculos = barbosa.readVehiculos();
        StringBuilder tarifasInfo = new StringBuilder();
        tarifasInfo.append("🎫 ANÁLISIS DE TARIFAS POR BUS\n");
        tarifasInfo.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n");

        int busCount = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Bus) {
                Bus bus = (Bus) vehiculo;
                busCount++;

                // Calcular tarifa para 20 pasajeros en el año actual
                double tarifa = bus.calcularTotal(20, java.util.Calendar.getInstance().get(java.util.Calendar.YEAR));

                tarifasInfo.append(String.format(
                    "🚌 Bus #%d: %s (%s)\n" +
                    "   💰 Tarifa para 20 pasajeros: $%.2f\n" +
                    "   💵 Tarifa por pasajero: $%.2f\n" +
                    "   🎯 Características: %s\n\n",
                    busCount, bus.getMarca(), bus.getPlaca(),
                    tarifa, tarifa / 20,
                    bus.getDetallesEspecificos()
                ));
            }
        }

        if (busCount == 0) {
            tarifasInfo.append("❌ No hay buses registrados en el sistema");
        }

        JOptionPane.showMessageDialog(this, tarifasInfo.toString(),
            "🎫 Análisis de Tarifas de Buses",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnCalcularTarifasActionPerformed

    @Override
    public void cambio() {
        // Implementación del patrón Observer
        DefaultTableModel model = (DefaultTableModel) jTBus.getModel();
        model.setRowCount(0); // Limpiar tabla

        List<Vehiculo> vehiculos = barbosa.readVehiculos();

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Bus) {
                Bus bus = (Bus) vehiculo;
                model.addRow(new Object[]{
                    bus.getPlaca(),
                    bus.getMarca(),
                    bus.getColor(),
                    bus.getModelo(),
                    bus.getAnio(),
                    bus.getEstado(),
                    bus.getCantidadTelevisores(),
                    bus.isTieneBanio() ? "Sí" : "No",
                    bus.isTieneSegundoPiso() ? "Sí" : "No",
                    bus.cantPasajeros(),
                    String.format("$%.2f", bus.calcularValorComercial()) // POLIMORFISMO
                });
            }
        }

        // Actualizar título con cantidad
        setTitle(String.format("🚌 Lista de Buses (%d registrados) - Observer Pattern",
            model.getRowCount()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcularTarifas;
    private javax.swing.JButton btnCalcularValor;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTBus;
    // End of variables declaration//GEN-END:variables

}
