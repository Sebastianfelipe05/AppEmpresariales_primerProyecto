/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package primerproyecto.interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import primerproyecto.interfaz.components.YearCalendarPicker;
import primerproyecto.model.Carro;
import primerproyecto.service.ServicioVehiculo;


/**
 *
 * @author jdsol
 */
public class GUIAddCarro extends javax.swing.JPanel {

    private final ServicioVehiculo barbosa = ServicioVehiculo.getInstance();
    private YearCalendarPicker yearPicker;

    // Colores del tema moderno
    private static final Color BACKGROUND_COLOR = new Color(245, 248, 250);
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(241, 196, 15);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);

    /**
     * Creates new form GUIAddCarro
     */
    public GUIAddCarro() {
        initComponents();
        customizeUI();
        makeResponsive();
    }

    private void customizeUI() {
        setBackground(BACKGROUND_COLOR);

        // Personalizar el panel principal
        placa.setBackground(Color.WHITE);
        placa.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        // Personalizar título
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabel1.setForeground(PRIMARY_COLOR);
        jLabel1.setText("🚗 AGREGAR NUEVO CARRO");

        // Personalizar labels
        customizeLabel(txtNombreCarro, "🏷️ Marca:");
        customizeLabel(color, "🎨 Color:");
        customizeLabel(jLabel2, "🔤 Placa:");
        customizeLabel(Combustible, "⛽ Combustible:");
        customizeLabel(jLabel3, "📋 Modelo:");
        customizeLabel(AnioCarro, "📅 Año:");
        customizeLabel(EstadoCarro, "⚙️ Estado:");
        customizeLabel(jLabel4, "❄️ ¿Tiene Aire Acondicionado?");
        customizeLabel(jLabel5, "🚪 Número de Puertas");

        // Personalizar campos de texto
        customizeTextField(txtMarca);
        customizeTextField(txtPlaca);
        customizeTextField(txtModelo);
        customizeTextField(txtNumeroPuertas);

        // Personalizar ComboBoxes
        customizeComboBox(boxColor);
        customizeComboBox(boxCombustible);
        customizeComboBox(boxEstado);
        customizeComboBox(boxAire);

        // Reemplazar el spinner con el calendario personalizado
        yearPicker = new YearCalendarPicker(Calendar.getInstance().get(Calendar.YEAR));

        // Personalizar botones
        customizeButton(btnGuardar, "💾 GUARDAR CARRO", SUCCESS_COLOR);
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
        placa.setMinimumSize(new Dimension(500, 450));
        placa.setPreferredSize(new Dimension(600, 550));

        mainContainer.add(placa, gbc);
        add(mainContainer, BorderLayout.CENTER);

        // Configurar el frame padre para ser responsive
        SwingUtilities.invokeLater(() -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (parentFrame != null) {
                parentFrame.setMinimumSize(new Dimension(650, 650));
                parentFrame.setPreferredSize(new Dimension(750, 750));
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
        textField.setMinimumSize(new Dimension(200, 35));
        textField.setPreferredSize(new Dimension(250, 35));
    }

    private void customizeComboBox(javax.swing.JComboBox comboBox) {
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        comboBox.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));
        comboBox.setMinimumSize(new Dimension(200, 35));
        comboBox.setPreferredSize(new Dimension(250, 35));
    }

    private void customizeButton(javax.swing.JButton button, String text, Color backgroundColor) {
        button.setText(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setMinimumSize(new Dimension(140, 45));
        button.setPreferredSize(new Dimension(160, 45));

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        placa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreCarro = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        color = new javax.swing.JLabel();
        boxColor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        Combustible = new javax.swing.JLabel();
        boxCombustible = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        AnioCarro = new javax.swing.JLabel();
        yearPickerPanel = new javax.swing.JPanel();
        EstadoCarro = new javax.swing.JLabel();
        boxEstado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        boxAire = new javax.swing.JComboBox<>();
        txtNumeroPuertas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        placa.setBackground(Color.WHITE);
        placa.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));

        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24));
        jLabel1.setForeground(PRIMARY_COLOR);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AGREGAR NUEVO CARRO");

        txtNombreCarro.setText("Marca:");
        color.setText("Color:");
        jLabel2.setText("Placa:");
        Combustible.setText("Combustible:");
        jLabel3.setText("Modelo:");
        AnioCarro.setText("Año:");
        EstadoCarro.setText("Estado:");
        jLabel4.setText("¿Tiene Aire Acondicionado?");
        jLabel5.setText("Número de Puertas");

        boxColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Azul", "Rojo", "Gris", "Blanco", "Negro", "Verde", "Amarillo", "Plateado" }));

        boxCombustible.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasolina", "Diésel", "Eléctrico", "Híbrido" }));

        // Panel para el selector de año
        yearPickerPanel.setBackground(Color.WHITE);
        yearPickerPanel.setLayout(new BorderLayout());

        boxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo", "Usado", "Seminuevo" }));

        boxAire.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));

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
        javax.swing.GroupLayout placaLayout = new javax.swing.GroupLayout(placa);
        placa.setLayout(placaLayout);
        placaLayout.setHorizontalGroup(
            placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(placaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(placaLayout.createSequentialGroup()
                        .addGroup(placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreCarro)
                            .addComponent(color)
                            .addComponent(jLabel2)
                            .addComponent(Combustible)
                            .addComponent(jLabel3)
                            .addComponent(AnioCarro)
                            .addComponent(EstadoCarro)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(30, 30, 30)
                        .addGroup(placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(boxColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPlaca)
                            .addComponent(boxCombustible, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtModelo)
                            .addComponent(yearPickerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxAire, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumeroPuertas))))
                .addGap(30, 30, 30))
            .addGroup(placaLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        placaLayout.setVerticalGroup(
            placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(placaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreCarro)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(color)
                    .addComponent(boxColor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Combustible)
                    .addComponent(boxCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(AnioCarro)
                    .addComponent(yearPickerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EstadoCarro)
                    .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(boxAire, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNumeroPuertas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(placaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

    // Métodos de eventos generados automáticamente - algunos no se usan pero son requeridos por NetBeans
    @SuppressWarnings("unused")
    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // Evento generado automáticamente - no requiere implementación
    }//GEN-LAST:event_txtMarcaActionPerformed

    @SuppressWarnings("unused")
    private void boxColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxColorActionPerformed
        // Evento generado automáticamente - no requiere implementación
    }//GEN-LAST:event_boxColorActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            // Validaciones con mensajes modernos
            if (txtMarca.getText().trim().isEmpty()) {
                mostrarError("❌ Error de Validación", "Por favor ingresa la marca del carro");
                txtMarca.requestFocus();
                return;
            }

            if (txtPlaca.getText().trim().isEmpty()) {
                mostrarError("❌ Error de Validación", "Por favor ingresa la placa del carro");
                txtPlaca.requestFocus();
                return;
            }

            if (txtModelo.getText().trim().isEmpty()) {
                mostrarError("❌ Error de Validación", "Por favor ingresa el modelo del carro");
                txtModelo.requestFocus();
                return;
            }

            if (txtNumeroPuertas.getText().trim().isEmpty()) {
                mostrarError("❌ Error de Validación", "Por favor ingresa el número de puertas");
                txtNumeroPuertas.requestFocus();
                return;
            }

            // Crear el carro con los datos del formulario
            String marca = txtMarca.getText().trim();
            String color = boxColor.getSelectedItem() != null ? boxColor.getSelectedItem().toString() : "Azul";
            String placa = txtPlaca.getText().trim().toUpperCase();
            String combustible = boxCombustible.getSelectedItem() != null ? boxCombustible.getSelectedItem().toString() : "Gasolina";
            String modelo = txtModelo.getText().trim();
            int anio = yearPicker.getSelectedYear(); // Usar el selector de calendario
            String estado = boxEstado.getSelectedItem() != null ? boxEstado.getSelectedItem().toString() : "Nuevo";
            int numeroPuertas = Integer.parseInt(txtNumeroPuertas.getText().trim());
            boolean tieneAire = boxAire.getSelectedItem() != null && "Sí".equals(boxAire.getSelectedItem().toString());

            Carro nuevoCarro = new Carro(marca, color, placa, combustible, modelo, anio, estado, numeroPuertas, tieneAire);

            // Guardar el carro
            if (barbosa.addVehiculo(nuevoCarro)) {
                mostrarExito("✅ ¡Carro Guardado!",
                    "El carro ha sido registrado exitosamente en el sistema.\n\n" +
                    "🚗 Marca: " + marca + "\n" +
                    "🔤 Placa: " + placa + "\n" +
                    "📅 Año: " + anio);
                limpiarFormulario();
            } else {
                mostrarError("❌ Error al Guardar", "No se pudo guardar el carro. Intenta nuevamente.");
            }

        } catch (NumberFormatException e) {
            mostrarError("❌ Error de Formato", "El número de puertas debe ser un número válido");
            txtNumeroPuertas.requestFocus();
        } catch (Exception e) {
            mostrarError("❌ Error Inesperado", "Ocurrió un error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void limpiarFormulario() {
        txtMarca.setText("");
        txtPlaca.setText("");
        txtModelo.setText("");
        txtNumeroPuertas.setText("");
        boxColor.setSelectedIndex(0);
        boxCombustible.setSelectedIndex(0);
        boxEstado.setSelectedIndex(0);
        boxAire.setSelectedIndex(0);
        yearPicker.setSelectedYear(Calendar.getInstance().get(Calendar.YEAR));
    }

    private void mostrarExito(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    @SuppressWarnings("unused")
    private void boxAireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAireActionPerformed
        // Evento generado automáticamente - no requiere implementación
    }//GEN-LAST:event_boxAireActionPerformed

    @SuppressWarnings("unused")
    private void txtNumeroPuertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroPuertasActionPerformed
        // Evento generado automáticamente - no requiere implementación
    }//GEN-LAST:event_txtNumeroPuertasActionPerformed

    @SuppressWarnings("unused")
    private void boxCombustibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCombustibleActionPerformed
        // Evento generado automáticamente - no requiere implementación
    }//GEN-LAST:event_boxCombustibleActionPerformed

    @SuppressWarnings("unused")
    private void boxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxEstadoActionPerformed
        // Evento generado automáticamente - no requiere implementación
    }//GEN-LAST:event_boxEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnioCarro;
    private javax.swing.JLabel Combustible;
    private javax.swing.JLabel EstadoCarro;
    private javax.swing.JComboBox<String> boxAire;
    private javax.swing.JComboBox<String> boxColor;
    private javax.swing.JComboBox<String> boxCombustible;
    private javax.swing.JComboBox<String> boxEstado;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel color;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel placa;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JLabel txtNombreCarro;
    private javax.swing.JTextField txtNumeroPuertas;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JPanel yearPickerPanel;
    // End of variables declaration//GEN-END:variables
}
