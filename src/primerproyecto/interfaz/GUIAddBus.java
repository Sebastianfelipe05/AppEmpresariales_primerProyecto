/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package primerproyecto.interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import primerproyecto.interfaz.components.YearCalendarPicker;
import primerproyecto.model.Bus;
import primerproyecto.service.ServicioVehiculo;

/**
 *
 * @author jdsol
 */
public class GUIAddBus extends javax.swing.JPanel {

    private final ServicioVehiculo barbosa = ServicioVehiculo.getInstance();
    private YearCalendarPicker yearPicker;

    // Colores del tema moderno
    private static final Color BACKGROUND_COLOR = new Color(245, 248, 250);
    private static final Color PRIMARY_COLOR = new Color(241, 196, 15); // Amarillo para buses
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(230, 126, 34);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);

    /**
     * Creates new form GUIAddBus
     */
    public GUIAddBus() {
        initComponents();
        customizeUI();
        makeResponsive();
    }

    private void customizeUI() {
        setBackground(BACKGROUND_COLOR);

        // Personalizar el panel principal
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        // Personalizar título
        txtAddBus.setFont(new Font("Segoe UI", Font.BOLD, 24));
        txtAddBus.setForeground(PRIMARY_COLOR);
        txtAddBus.setText("🚌 AGREGAR NUEVO BUS");

        // Personalizar labels con iconos
        customizeLabel(marcaBUS, "🏷️ Marca:");
        customizeLabel(jLabel2BUS, "🎨 Color:");
        customizeLabel(JLabel2BUS, "🔤 Placa:");
        customizeLabel(jLabel4BUS, "⛽ Combustible:");
        customizeLabel(jLabel5, "📋 Modelo:");
        customizeLabel(anio, "📅 Año:");
        customizeLabel(estadoBUS, "⚙️ Estado:");
        customizeLabel(jLabel6, "📺 Cantidad de Televisores:");
        customizeLabel(jLabel7, "🚿 ¿Tiene Baño?");
        customizeLabel(jLabel8, "🏢 ¿Tiene Segundo Piso?");

        // Personalizar campos de texto
        customizeTextField(txtMarca);
        customizeTextField(txtPlaca);
        customizeTextField(txtModelo);
        customizeTextField(txtCantidadTV);

        // Personalizar ComboBoxes
        customizeComboBox(boxColor);
        customizeComboBox(boxCombustible);
        customizeComboBox(boxEstado);
        customizeComboBox(boxBanio);
        customizeComboBox(boxSegundoPiso);

        // Crear el calendario personalizado
        yearPicker = new YearCalendarPicker(Calendar.getInstance().get(Calendar.YEAR));

        // Personalizar botones
        customizeButton(btnGuardar, "💾 GUARDAR BUS", SUCCESS_COLOR);
        customizeButton(btnSalir, "❌ CANCELAR", DANGER_COLOR);
    }

    private void makeResponsive() {
        // Hacer que el panel se ajuste al contenedor padre
        setLayout(new BorderLayout());

        // Panel principal que se adapta al tamaño
        JPanel mainContainer = new JPanel(new GridBagLayout());
        mainContainer.setBackground(BACKGROUND_COLOR);
        mainContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Hacer que el panel interno sea responsive
        jPanel1.setMinimumSize(new Dimension(550, 500));
        jPanel1.setPreferredSize(new Dimension(650, 600));

        mainContainer.add(jPanel1, gbc);
        add(mainContainer, BorderLayout.CENTER);

        // Configurar el frame padre para ser responsive
        SwingUtilities.invokeLater(() -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (parentFrame != null) {
                parentFrame.setMinimumSize(new Dimension(700, 700));
                parentFrame.setPreferredSize(new Dimension(800, 800));
                parentFrame.pack();
                parentFrame.setLocationRelativeTo(null);
            }
        });
    }

    private void customizeLabel(javax.swing.JLabel label, String text) {
        label.setText(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(new Color(52, 73, 94));
    }

    private void customizeTextField(javax.swing.JTextField textField) {
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
    }

    private void customizeComboBox(javax.swing.JComboBox comboBox) {
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        comboBox.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            BorderFactory.createEmptyBorder(4, 8, 4, 8)
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

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtAddBus = new javax.swing.JLabel();
        marcaBUS = new javax.swing.JLabel();
        jLabel2BUS = new javax.swing.JLabel();
        JLabel2BUS = new javax.swing.JLabel();
        jLabel4BUS = new javax.swing.JLabel();
        estadoBUS = new javax.swing.JLabel();
        anio = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        boxColor = new javax.swing.JComboBox<>();
        txtPlaca = new javax.swing.JTextField();
        boxCombustible = new javax.swing.JComboBox<>();
        txtModelo = new javax.swing.JTextField();
        yearPickerPanel = new javax.swing.JPanel();
        boxEstado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCantidadTV = new javax.swing.JTextField();
        boxBanio = new javax.swing.JComboBox<>();
        boxSegundoPiso = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jLabel5.setText("Modelo:");

        setBackground(BACKGROUND_COLOR);

        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));

        txtAddBus.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24));
        txtAddBus.setForeground(PRIMARY_COLOR);
        txtAddBus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAddBus.setText("AGREGAR NUEVO BUS");

        marcaBUS.setText("Marca:");
        jLabel2BUS.setText("Color:");
        JLabel2BUS.setText("Placa:");
        jLabel4BUS.setText("Combustible:");
        jLabel5.setText("Modelo:");
        anio.setText("Año:");
        estadoBUS.setText("Estado:");
        jLabel6.setText("Cantidad de Televisores:");
        jLabel7.setText("¿Tiene Baño?");
        jLabel8.setText("¿Tiene Segundo Piso?");

        boxColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Azul", "Rojo", "Gris", "Blanco", "Negro", "Verde", "Amarillo", "Plateado" }));

        boxCombustible.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasolina", "Diésel", "Gas Natural", "Eléctrico" }));

        // Panel para el selector de año con calendario
        yearPickerPanel.setBackground(Color.WHITE);
        yearPickerPanel.setLayout(new BorderLayout());

        boxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo", "Usado", "Seminuevo", "En mantenimiento" }));

        boxBanio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));

        boxSegundoPiso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        // Layout responsive mejorado
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddBus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(marcaBUS)
                            .addComponent(jLabel2BUS)
                            .addComponent(JLabel2BUS)
                            .addComponent(jLabel4BUS)
                            .addComponent(jLabel5)
                            .addComponent(anio)
                            .addComponent(estadoBUS)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(boxColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPlaca)
                            .addComponent(boxCombustible, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtModelo)
                            .addComponent(yearPickerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCantidadTV)
                            .addComponent(boxBanio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxSegundoPiso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtAddBus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marcaBUS)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2BUS)
                    .addComponent(boxColor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel2BUS)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4BUS)
                    .addComponent(boxCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(anio)
                    .addComponent(yearPickerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadoBUS)
                    .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCantidadTV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(boxBanio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(boxSegundoPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        // Agregar el selector de año después de la inicialización
        SwingUtilities.invokeLater(() -> {
            if (yearPicker != null) {
                yearPickerPanel.add(yearPicker, BorderLayout.CENTER);
                yearPickerPanel.revalidate();
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Validaciones con mensajes modernos
            if (txtMarca.getText().trim().isEmpty()) {
                mostrarError("❌ Error de Validación", "Por favor ingresa la marca del bus");
                txtMarca.requestFocus();
                return;
            }

            if (txtPlaca.getText().trim().isEmpty()) {
                mostrarError("❌ Error de Validación", "Por favor ingresa la placa del bus");
                txtPlaca.requestFocus();
                return;
            }

            if (txtModelo.getText().trim().isEmpty()) {
                mostrarError("❌ Error de Validación", "Por favor ingresa el modelo del bus");
                txtModelo.requestFocus();
                return;
            }

            if (txtCantidadTV.getText().trim().isEmpty()) {
                mostrarError("❌ Error de Validación", "Por favor ingresa la cantidad de televisores");
                txtCantidadTV.requestFocus();
                return;
            }

            // Crear el bus con los datos del formulario
            String marca = txtMarca.getText().trim();
            String color = boxColor.getSelectedItem() != null ? boxColor.getSelectedItem().toString() : "Azul";
            String placa = txtPlaca.getText().trim().toUpperCase();
            String combustible = boxCombustible.getSelectedItem() != null ? boxCombustible.getSelectedItem().toString() : "Gasolina";
            String modelo = txtModelo.getText().trim();
            int anio = yearPicker.getSelectedYear(); // Usar el calendario personalizado
            String estado = boxEstado.getSelectedItem() != null ? boxEstado.getSelectedItem().toString() : "Nuevo";
            int cantidadTV = Integer.parseInt(txtCantidadTV.getText().trim());
            boolean tieneBanio = boxBanio.getSelectedItem() != null && "Sí".equals(boxBanio.getSelectedItem().toString());
            boolean tieneSegundoPiso = boxSegundoPiso.getSelectedItem() != null && "Sí".equals(boxSegundoPiso.getSelectedItem().toString());

            Bus nuevoBus = new Bus(marca, color, placa, combustible, modelo, anio, estado, cantidadTV, tieneBanio, tieneSegundoPiso);

            // Guardar el bus
            if (barbosa.addVehiculo(nuevoBus)) {
                mostrarExito("✅ ¡Bus Guardado!",
                    "El bus ha sido registrado exitosamente en el sistema.\n\n" +
                    "🚌 Marca: " + marca + "\n" +
                    "🔤 Placa: " + placa + "\n" +
                    "📅 Año: " + anio + "\n" +
                    "📺 TVs: " + cantidadTV + "\n" +
                    "🚿 Baño: " + (tieneBanio ? "Sí" : "No") + "\n" +
                    "🏢 Segundo Piso: " + (tieneSegundoPiso ? "Sí" : "No"));
                limpiarFormulario();
            } else {
                mostrarError("❌ Error al Guardar", "No se pudo guardar el bus. Intenta nuevamente.");
            }

        } catch (NumberFormatException e) {
            mostrarError("❌ Error de Formato", "La cantidad de televisores debe ser un número válido");
            txtCantidadTV.requestFocus();
        } catch (Exception e) {
            mostrarError("❌ Error Inesperado", "Ocurrió un error: " + e.getMessage());
        }
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.dispose();
        }
    }

    private void limpiarFormulario() {
        txtMarca.setText("");
        txtPlaca.setText("");
        txtModelo.setText("");
        txtCantidadTV.setText("");
        boxColor.setSelectedIndex(0);
        boxCombustible.setSelectedIndex(0);
        boxEstado.setSelectedIndex(0);
        boxBanio.setSelectedIndex(0);
        boxSegundoPiso.setSelectedIndex(0);
        yearPicker.setSelectedYear(Calendar.getInstance().get(Calendar.YEAR));
    }

    private void mostrarExito(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel2BUS;
    private javax.swing.JLabel anio;
    private javax.swing.JSpinner boxAnio;
    private javax.swing.JComboBox<String> boxBanio;
    private javax.swing.JComboBox<String> boxColor;
    private javax.swing.JComboBox<String> boxCombustible;
    private javax.swing.JComboBox<String> boxEstado;
    private javax.swing.JComboBox<String> boxSegundoPiso;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel estadoBUS;
    private javax.swing.JLabel jLabel2BUS;
    private javax.swing.JLabel jLabel4BUS;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel marcaBUS;
    private javax.swing.JTextField txtCantidadTV;
    private javax.swing.JLabel txtAddBus;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JPanel yearPickerPanel;
    // End of variables declaration//GEN-END:variables
}
