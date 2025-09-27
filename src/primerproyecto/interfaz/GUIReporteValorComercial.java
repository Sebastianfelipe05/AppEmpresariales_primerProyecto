/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primerproyecto.interfaz;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import java.awt.*;
import javax.swing.ImageIcon;
import primerproyecto.service.ServicioVehiculo;

/**
 *
 * @author User
 */
public class GUIReporteValorComercial extends javax.swing.JFrame {

    private ServicioVehiculo servicioVehiculo = ServicioVehiculo.getInstance();

    // Colores modernos del tema
    private static final Color BACKGROUND_COLOR = new Color(245, 248, 250);
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(241, 196, 15);
    private static final Color INFO_COLOR = new Color(155, 89, 182);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);

    public GUIReporteValorComercial() {
        this.setTitle("📊 Reporte de Valores Comerciales - POLIMORFISMO");
        initComponents();
        customizeUI();
        actualizarReporte();
        setLocationRelativeTo(null);
    }

    private void customizeUI() {
        // Panel principal con gradiente
        getContentPane().setBackground(BACKGROUND_COLOR);

        // Personalizar el área de texto principal
        txtAreaReporte.setFont(new Font("Consolas", Font.PLAIN, 12));
        txtAreaReporte.setBackground(new Color(248, 249, 250));
        txtAreaReporte.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        // Personalizar el scroll pane
        jScrollPane1.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
            "📈 Análisis Polimórfico de Valores Comerciales",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new Font("Segoe UI", Font.BOLD, 14),
            PRIMARY_COLOR
        ));

        // Personalizar campo de valor total
        txtValorTotal.setFont(new Font("Segoe UI", Font.BOLD, 16));
        txtValorTotal.setForeground(SUCCESS_COLOR);
        txtValorTotal.setBackground(Color.WHITE);
        txtValorTotal.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SUCCESS_COLOR, 2),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));

        // Personalizar etiquetas
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jLabel1.setForeground(new Color(52, 73, 94));

        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel2.setForeground(new Color(52, 73, 94));

        // Personalizar botones
        customizeButton(btnActualizar, "🔄", SUCCESS_COLOR);
        customizeButton(btnCalcularTotal, "💰", WARNING_COLOR);
        customizeButton(btnReporteCompleto, "📋", INFO_COLOR);
        customizeButton(btnSalir, "❌", DANGER_COLOR);
    }

    private void customizeButton(javax.swing.JButton button, String icon, Color backgroundColor) {
        button.setText(icon + " " + button.getText());
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Efecto hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            Color originalColor = backgroundColor;
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor.darker());
                button.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(backgroundColor.darker().darker(), 2),
                    BorderFactory.createEmptyBorder(10, 18, 10, 18)
                ));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor);
                button.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaReporte = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCalcularTotal = new javax.swing.JButton();
        btnReporteCompleto = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(new BorderLayout());

        // Panel superior con título
        javax.swing.JPanel headerPanel = new javax.swing.JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(52, 73, 94));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REPORTE POLIMÓRFICO - VALORES COMERCIALES");
        jLabel1.setForeground(Color.WHITE);
        headerPanel.add(jLabel1, BorderLayout.CENTER);

        javax.swing.JLabel subtitleLabel = new javax.swing.JLabel("Demostración de Polimorfismo en Cálculos de Valores");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        subtitleLabel.setForeground(new Color(189, 195, 199));
        subtitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerPanel.add(subtitleLabel, BorderLayout.SOUTH);

        getContentPane().add(headerPanel, BorderLayout.NORTH);

        // Panel central
        javax.swing.JPanel centerPanel = new javax.swing.JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(BACKGROUND_COLOR);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // Panel de valor total
        javax.swing.JPanel totalPanel = new javax.swing.JPanel();
        totalPanel.setLayout(new FlowLayout());
        totalPanel.setBackground(BACKGROUND_COLOR);

        jLabel2.setText("💰 Valor Total del Inventario:");
        totalPanel.add(jLabel2);

        txtValorTotal.setEditable(false);
        txtValorTotal.setPreferredSize(new java.awt.Dimension(200, 35));
        totalPanel.add(txtValorTotal);

        centerPanel.add(totalPanel, BorderLayout.NORTH);

        txtAreaReporte.setColumns(20);
        txtAreaReporte.setRows(5);
        txtAreaReporte.setEditable(false);
        jScrollPane1.setViewportView(txtAreaReporte);

        centerPanel.add(jScrollPane1, BorderLayout.CENTER);

        getContentPane().add(centerPanel, BorderLayout.CENTER);

        // Panel de botones
        javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(new Color(236, 240, 241));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

        btnActualizar.setText("Actualizar Análisis");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        buttonPanel.add(btnActualizar);

        btnCalcularTotal.setText("Valor Total Inventario");
        btnCalcularTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularTotalActionPerformed(evt);
            }
        });
        buttonPanel.add(btnCalcularTotal);

        btnReporteCompleto.setText("Reporte Completo");
        btnReporteCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteCompletoActionPerformed(evt);
            }
        });
        buttonPanel.add(btnReporteCompleto);

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        buttonPanel.add(btnSalir);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarReporte();

        // Mensaje mejorado con diseño moderno
        String mensaje = "🎉 ¡Análisis actualizado con éxito!\n\n" +
                        "✨ POLIMORFISMO EN ACCIÓN:\n" +
                        "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
                        "🚗 Los métodos calcularValorComercial() se ejecutan\n" +
                        "   de forma diferente para cada tipo de vehículo\n\n" +
                        "🚌 Cada clase (Carro vs Bus) tiene su propia\n" +
                        "   implementación del mismo método\n\n" +
                        "⚡ ¡Mismo nombre de método, comportamiento diferente!";

        JOptionPane.showMessageDialog(this, mensaje,
                "✅ Polimorfismo Ejecutado Correctamente",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCalcularTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularTotalActionPerformed
        // DEMOSTRACIÓN DE POLIMORFISMO: Un solo método que funciona diferente para cada tipo
        double valorTotal = servicioVehiculo.calcularValorComercialTotal();
        txtValorTotal.setText(String.format("$%.2f", valorTotal));

        String mensaje = "💡 DEMOSTRACIÓN DE POLIMORFISMO:\n" +
                        "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                        "🔧 MÉTODO UTILIZADO:\n" +
                        "   → servicioVehiculo.calcularValorComercialTotal()\n\n" +
                        "🔄 PROCESO INTERNO:\n" +
                        "   1. Itera sobre todos los vehículos\n" +
                        "   2. Llama vehiculo.calcularValorComercial() para cada uno\n" +
                        "   3. Cada clase ejecuta SU PROPIA implementación\n\n" +
                        "🚗 CARROS:\n" +
                        "   • Depreciación: 8% anual\n" +
                        "   • Bonificación por aire acondicionado\n" +
                        "   • Bonificación por 4 puertas\n\n" +
                        "🚌 BUSES:\n" +
                        "   • Depreciación: 6% anual (menor que carros)\n" +
                        "   • Bonificación por baño\n" +
                        "   • Bonificación por segundo piso\n" +
                        "   • Bonificación por televisores\n\n" +
                        "✨ RESULTADO: ¡Mismo método, diferentes cálculos!\n" +
                        "💰 Valor total calculado: " + String.format("$%.2f", valorTotal);

        JOptionPane.showMessageDialog(this, mensaje,
                "🎯 Explicación Detallada del Polimorfismo",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnCalcularTotalActionPerformed

    private void btnReporteCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteCompletoActionPerformed
        String reporteCompleto = servicioVehiculo.obtenerReporteCompleto();

        // Crear ventana moderna para el reporte completo
        javax.swing.JFrame ventanaReporte = new javax.swing.JFrame("📋 Reporte Completo - Polimorfismo Detallado");
        ventanaReporte.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);

        // Panel principal con BorderLayout
        javax.swing.JPanel mainPanel = new javax.swing.JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        // Header del reporte
        javax.swing.JPanel headerPanel = new javax.swing.JPanel();
        headerPanel.setBackground(new Color(52, 73, 94));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        javax.swing.JLabel titleLabel = new javax.swing.JLabel("📊 REPORTE DETALLADO CON POLIMORFISMO");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerPanel.add(titleLabel);

        JTextArea textArea = new JTextArea(reporteCompleto);
        textArea.setFont(new Font("Consolas", Font.PLAIN, 11));
        textArea.setEditable(false);
        textArea.setBackground(new Color(248, 249, 250));
        textArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(800, 500));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        ventanaReporte.add(mainPanel);
        ventanaReporte.pack();
        ventanaReporte.setLocationRelativeTo(this);
        ventanaReporte.setVisible(true);

        String explicacion = "🎓 MÉTODOS POLIMÓRFICOS UTILIZADOS EN EL REPORTE:\n" +
                            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                            "✅ getInformacionCompleta()\n" +
                            "   → Cada vehículo muestra su información específica\n\n" +
                            "✅ calcularValorComercial()\n" +
                            "   → Cálculo único por tipo de vehículo\n\n" +
                            "✅ getTipoVehiculo()\n" +
                            "   → Identifica automáticamente el tipo correcto\n\n" +
                            "✅ getDetallesEspecificos()\n" +
                            "   → Detalles únicos de cada clase\n\n" +
                            "✅ obtenerInformacionMantenimiento()\n" +
                            "   → Información específica de mantenimiento\n\n" +
                            "🚀 ¡Todos estos métodos demuestran polimorfismo puro!";

        JOptionPane.showMessageDialog(this, explicacion,
                "🔬 Análisis de Métodos Polimórficos",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnReporteCompletoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void actualizarReporte() {
        String analisis = servicioVehiculo.calcularValorPromedioPorTipo();
        txtAreaReporte.setText(analisis);

        double valorTotal = servicioVehiculo.calcularValorComercialTotal();
        txtValorTotal.setText(String.format("$%.2f", valorTotal));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIReporteValorComercial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCalcularTotal;
    private javax.swing.JButton btnReporteCompleto;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaReporte;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
