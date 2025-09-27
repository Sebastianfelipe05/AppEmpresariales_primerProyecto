/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primerproyecto.interfaz;

import javax.swing.*;
import java.awt.*;
import primerproyecto.model.Carro;
import primerproyecto.model.Vehiculo;
import primerproyecto.service.ServicioVehiculo;

/**
 *
 * @author jdsol
 */
public class GUISearchCarro extends javax.swing.JFrame {

    private Carro carroActual;
    private final ServicioVehiculo barbosa = ServicioVehiculo.getInstance();

    // Colores del tema moderno
    private static final Color BACKGROUND_COLOR = new Color(245, 248, 250);
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(241, 196, 15);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);
    private static final Color HEADER_COLOR = new Color(52, 73, 94);

    public GUISearchCarro() {
        this.setTitle("🔍 Buscar Carro");
        initComponents();
        customizeUI();
        makeResponsive();
    }

    private void customizeUI() {
        getContentPane().setBackground(BACKGROUND_COLOR);

        // Personalizar el panel principal
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        // Personalizar labels con iconos
        customizeLabel(jLabel1, "🔍 BUSCAR CARRO");
        customizeLabel(jLabel2, "🔤 Placa a buscar:");
        customizeLabel(jLabel4, "🏷️ Marca:");
        customizeLabel(jLabel5, "🎨 Color:");
        customizeLabel(jLabel6, "📋 Modelo:");
        customizeLabel(jLabel7, "📅 Año:");
        customizeLabel(jLabel8, "⚙️ Estado:");
        customizeLabel(jLabel9, "⛽ Combustible:");
        customizeLabel(jLabel10, "🚪 Número de Puertas:");
        customizeLabel(jLabel11, "❄️ Aire Acondicionado:");
        customizeLabel(jLabel12, "💰 Valor Comercial:");

        // Personalizar título principal
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabel1.setForeground(PRIMARY_COLOR);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // Personalizar campo de búsqueda
        txtSearch.setFont(new Font("Segoe UI", Font.BOLD, 14));
        txtSearch.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(WARNING_COLOR, 2),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        // Personalizar campos de resultado (solo lectura)
        customizeResultField(txtMarca);
        customizeResultField(txtColor);
        customizeResultField(txtModelo);
        customizeResultField(txtAnio);
        customizeResultField(txtEstado);
        customizeResultField(txtCombustible);
        customizeResultField(txtNumeroPuertas);
        customizeResultField(txtAireAcondicionado);

        // Campo de valor comercial con estilo especial
        txtValorComercial.setFont(new Font("Segoe UI", Font.BOLD, 16));
        txtValorComercial.setForeground(SUCCESS_COLOR);
        txtValorComercial.setEditable(false);
        txtValorComercial.setBackground(new Color(248, 249, 250));
        txtValorComercial.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SUCCESS_COLOR, 2),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        // Personalizar botones
        customizeButton(buscarCarro, "🔍 BUSCAR", WARNING_COLOR);
        customizeButton(btnSalir, "❌ SALIR", DANGER_COLOR);
        customizeButton(btnLimpiar, "🧹 LIMPIAR", new Color(155, 89, 182));
    }

    private void makeResponsive() {
        setLayout(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(HEADER_COLOR);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titleLabel = new JLabel("🔍 BÚSQUEDA DE CARROS");
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

        jPanel1.setMinimumSize(new Dimension(500, 450));
        jPanel1.setPreferredSize(new Dimension(600, 550));

        contentPanel.add(jPanel1, gbc);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.setBackground(new Color(236, 240, 241));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        buttonPanel.add(buscarCarro);
        buttonPanel.add(btnLimpiar);
        buttonPanel.add(btnSalir);

        // Assembly
        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Configurar ventana responsive
        setMinimumSize(new Dimension(650, 600));
        setPreferredSize(new Dimension(750, 700));
        setLocationRelativeTo(null);
    }

    private void customizeLabel(javax.swing.JLabel label, String text) {
        label.setText(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(new Color(52, 73, 94));
    }

    private void customizeResultField(javax.swing.JTextField textField) {
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        textField.setEditable(false);
        textField.setBackground(new Color(248, 249, 250));
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
        button.setPreferredSize(new Dimension(120, 40));

        // Efecto hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            final Color originalColor = backgroundColor;
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtCombustible = new javax.swing.JTextField();
        txtNumeroPuertas = new javax.swing.JTextField();
        txtAireAcondicionado = new javax.swing.JTextField();
        txtValorComercial = new javax.swing.JTextField();
        buscarCarro = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));

        jLabel1.setText("BUSCAR CARRO");
        jLabel2.setText("Placa:");
        jLabel4.setText("Marca:");
        jLabel5.setText("Color:");
        jLabel6.setText("Modelo:");
        jLabel7.setText("Año:");
        jLabel8.setText("Estado:");
        jLabel9.setText("Combustible:");
        jLabel10.setText("Número de Puertas:");
        jLabel11.setText("Aire Acondicionado:");
        jLabel12.setText("Valor Comercial:");

        buscarCarro.setText("BUSCAR");
        buscarCarro.addActionListener(evt -> buscarCarroActionPerformed());

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(evt -> btnSalirActionPerformed());

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(evt -> btnLimpiarActionPerformed());

        // Layout responsive mejorado
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
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtMarca)
                            .addComponent(txtColor)
                            .addComponent(txtModelo)
                            .addComponent(txtAnio)
                            .addComponent(txtEstado)
                            .addComponent(txtCombustible)
                            .addComponent(txtNumeroPuertas)
                            .addComponent(txtAireAcondicionado)
                            .addComponent(txtValorComercial))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNumeroPuertas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtAireAcondicionado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtValorComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarCarroActionPerformed() {
        try {
            String placa = txtSearch.getText().trim();

            if (placa.isEmpty()) {
                mostrarMensaje("❌ Error de Validación", "Por favor ingresa la placa del carro a buscar", JOptionPane.ERROR_MESSAGE);
                txtSearch.requestFocus();
                return;
            }

            Vehiculo vehiculo = barbosa.searchVehiculo(placa);

            if (vehiculo == null) {
                mostrarMensaje("❌ Carro No Encontrado",
                    "No se encontró un carro con la placa: " + placa.toUpperCase() + "\n\n" +
                    "Verifica que la placa esté correctamente escrita.", JOptionPane.ERROR_MESSAGE);
                limpiarCampos();
                txtSearch.requestFocus();
                return;
            }

            if (!(vehiculo instanceof Carro)) {
                mostrarMensaje("❌ Tipo Incorrecto",
                    "La placa " + placa.toUpperCase() + " corresponde a un BUS, no a un carro.\n\n" +
                    "Usa la búsqueda de buses para este vehículo.", JOptionPane.ERROR_MESSAGE);
                limpiarCampos();
                txtSearch.requestFocus();
                return;
            }

            // Cast seguro y mostrar información
            carroActual = (Carro) vehiculo;
            mostrarInformacionCarro();

            String mensaje = """
                🚗 Carro encontrado exitosamente:

                🏷️ %s %s (%s)
                📅 Año: %d
                💰 Valor: $%.2f

                ℹ️ Información calculada con polimorfismo""".formatted(
                    carroActual.getMarca(), carroActual.getModelo(),
                    carroActual.getPlaca(), carroActual.getAnio(),
                    carroActual.calcularValorComercial()
                );

            mostrarMensaje("✅ Carro Encontrado", mensaje, JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            mostrarMensaje("❌ Error Inesperado", "Ocurrió un error: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnSalirActionPerformed() {
        dispose();
    }

    private void btnLimpiarActionPerformed() {
        limpiarCampos();
        txtSearch.setText("");
        txtSearch.requestFocus();
        carroActual = null;
    }

    private void mostrarInformacionCarro() {
        if (carroActual != null) {
            txtMarca.setText(carroActual.getMarca());
            txtColor.setText(carroActual.getColor());
            txtModelo.setText(carroActual.getModelo());
            txtAnio.setText(String.valueOf(carroActual.getAnio()));
            txtEstado.setText(carroActual.getEstado());
            txtCombustible.setText(carroActual.getCombustible());
            txtNumeroPuertas.setText(String.valueOf(carroActual.getNumeroPuertas()));
            txtAireAcondicionado.setText(carroActual.isTieneAireAcondicionado() ? "Sí" : "No");
            txtValorComercial.setText(String.format("$%.2f", carroActual.calcularValorComercial()));
        }
    }

    private void limpiarCampos() {
        txtMarca.setText("");
        txtColor.setText("");
        txtModelo.setText("");
        txtAnio.setText("");
        txtEstado.setText("");
        txtCombustible.setText("");
        txtNumeroPuertas.setText("");
        txtAireAcondicionado.setText("");
        txtValorComercial.setText("");
    }

    private void mostrarMensaje(String titulo, String mensaje, int tipoMensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, tipoMensaje);
    }

    private void mostrarExito(String mensaje) {
        mostrarMensaje("✅ Éxito", mensaje, JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarError(String titulo, String mensaje) {
        mostrarMensaje(titulo, mensaje, JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton buscarCarro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAireAcondicionado;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtCombustible;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumeroPuertas;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtValorComercial;
    // End of variables declaration//GEN-END:variables
}
