/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primerproyecto.interfaz;

import primerproyecto.model.Bus;
import primerproyecto.service.ServicioVehiculo;
import primerproyecto.interfaz.components.YearCalendarPicker;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

/**
 *
 * @author jdsol
 */
public class GUIMostrarTarifa extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIMostrarTarifa.class.getName());

    private ServicioVehiculo barbosa = ServicioVehiculo.getInstance();
    private YearCalendarPicker yearPicker;

    // Colores del tema moderno
    private static final Color BACKGROUND_COLOR = new Color(245, 248, 250);
    private static final Color PRIMARY_COLOR = new Color(26, 188, 156);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(241, 196, 15);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);
    private static final Color HEADER_COLOR = new Color(52, 73, 94);

    public GUIMostrarTarifa() {
        this.setTitle("💰 Calculadora de Tarifas de Bus");
        initComponents();
        customizeUI();
        makeResponsive();
        setLocationRelativeTo(null);
    }

    private void customizeUI() {
        getContentPane().setBackground(BACKGROUND_COLOR);

        // Personalizar el panel principal
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        // Personalizar título
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabel1.setForeground(PRIMARY_COLOR);
        jLabel1.setText("💰 CALCULADORA DE TARIFAS");

        // Personalizar labels
        customizeLabel(jLabel2, "🚌 Placa del Bus:");
        customizeLabel(jLabel3, "💵 La tarifa calculada es:");
        customizeLabel(jLabel4, "📅 Año del Viaje:");
        customizeLabel(jLabel5, "👥 Número de Pasajeros:");

        // Personalizar campos de texto
        customizeTextField(txtSearch);
        customizeTextField(txtPasajeros);

        // Personalizar resultado
        txtMostrar.setFont(new Font("Segoe UI", Font.BOLD, 18));
        txtMostrar.setForeground(SUCCESS_COLOR);
        txtMostrar.setEditable(false);
        txtMostrar.setBackground(new Color(248, 249, 250));
        txtMostrar.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SUCCESS_COLOR, 2),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        // Crear el calendario personalizado
        yearPicker = new YearCalendarPicker(Calendar.getInstance().get(Calendar.YEAR));

        // Personalizar botones
        customizeButton(buscarPlacaBus, "🔍 CALCULAR TARIFA", SUCCESS_COLOR);
        customizeButton(jButton1, "❌ SALIR", DANGER_COLOR);
    }

    private void makeResponsive() {
        setLayout(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(HEADER_COLOR);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titleLabel = new JLabel("💰 CALCULADORA DE TARIFAS");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerPanel.add(titleLabel);

        // Main content panel
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(BACKGROUND_COLOR);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10);

        jPanel1.setMinimumSize(new Dimension(500, 350));
        jPanel1.setPreferredSize(new Dimension(600, 400));

        contentPanel.add(jPanel1, gbc);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.setBackground(new Color(236, 240, 241));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        buttonPanel.add(buscarPlacaBus);
        buttonPanel.add(jButton1);

        // Assembly
        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Configurar ventana responsive
        setMinimumSize(new Dimension(650, 550));
        setPreferredSize(new Dimension(750, 650));
    }

    private void customizeLabel(javax.swing.JLabel label, String text) {
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(new Color(52, 73, 94));
        label.setText(text);
    }

    private void customizeTextField(javax.swing.JTextField textField) {
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
    }

    private void customizeButton(javax.swing.JButton button, String text, Color backgroundColor) {
        button.setText(text);
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
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMostrar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        yearPickerPanel = new javax.swing.JPanel();
        txtPasajeros = new javax.swing.JTextField();
        buscarPlacaBus = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));

        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24));
        jLabel1.setForeground(PRIMARY_COLOR);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CALCULADORA DE TARIFAS");

        jLabel2.setText("Placa del Bus:");
        jLabel3.setText("La tarifa calculada es:");
        jLabel4.setText("Año del Viaje:");
        jLabel5.setText("Número de Pasajeros:");

        // Panel para el selector de año con calendario
        yearPickerPanel.setBackground(Color.WHITE);
        yearPickerPanel.setLayout(new BorderLayout());

        txtPasajeros.setText("1");

        buscarPlacaBus.setText("CALCULAR");
        buscarPlacaBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPlacaBusActionPerformed(evt);
            }
        });

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        // Layout responsive para el panel principal
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(yearPickerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPasajeros)
                            .addComponent(txtMostrar))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(yearPickerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        // Agregar el selector de año después de la inicialización
        SwingUtilities.invokeLater(() -> {
            if (yearPicker != null) {
                yearPickerPanel.add(yearPicker, BorderLayout.CENTER);
                yearPickerPanel.revalidate();
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarPlacaBusActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String placa = txtSearch.getText().trim();

            if (placa.isEmpty()) {
                mostrarError("❌ Error de Validación", "Por favor ingresa la placa del bus");
                txtSearch.requestFocus();
                return;
            }

            if (txtPasajeros.getText().trim().isEmpty()) {
                mostrarError("❌ Error de Validación", "Por favor ingresa el número de pasajeros");
                txtPasajeros.requestFocus();
                return;
            }

            Bus bus = (Bus) barbosa.searchVehiculo(placa);

            if (bus == null) {
                mostrarError("❌ Bus No Encontrado",
                    "No se encontró un bus con la placa: " + placa.toUpperCase() + "\n\n" +
                    "Verifica que la placa esté correctamente escrita.");
                txtSearch.requestFocus();
                return;
            }

            int numeroPasajeros = Integer.parseInt(txtPasajeros.getText().trim());
            int anioViaje = yearPicker.getSelectedYear(); // Usar el calendario personalizado

            if (numeroPasajeros <= 0) {
                mostrarError("❌ Error de Validación", "El número de pasajeros debe ser mayor a 0");
                txtPasajeros.requestFocus();
                return;
            }

            // Calcular tarifa usando polimorfismo
            double tarifa = bus.calcularTotal(numeroPasajeros, anioViaje);

            txtMostrar.setText(String.format("$%.2f", tarifa));

            // Mostrar información detallada
            mostrarExito("✅ Tarifa Calculada",
                String.format(
                    "🚌 Bus: %s %s (%s)\n" +
                    "📅 Año del viaje: %d\n" +
                    "👥 Pasajeros: %d\n" +
                    "💰 Tarifa total: $%.2f\n" +
                    "💵 Tarifa por pasajero: $%.2f\n\n" +
                    "🎯 Características del bus:\n%s\n\n" +
                    "ℹ️ Cálculo realizado con polimorfismo\n" +
                    "mediante el método calcularTotal() de la interfaz ICalcularTarifa",
                    bus.getMarca(), bus.getModelo(), bus.getPlaca(),
                    anioViaje, numeroPasajeros, tarifa, tarifa / numeroPasajeros,
                    bus.getDetallesEspecificos()
                ));

        } catch (NumberFormatException e) {
            mostrarError("❌ Error de Formato", "El número de pasajeros debe ser un número válido");
            txtPasajeros.requestFocus();
        } catch (Exception e) {
            mostrarError("❌ Error Inesperado", "Ocurrió un error: " + e.getMessage());
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void mostrarExito(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarPlacaBus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel yearPickerPanel;
    private javax.swing.JTextField txtMostrar;
    private javax.swing.JTextField txtPasajeros;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
