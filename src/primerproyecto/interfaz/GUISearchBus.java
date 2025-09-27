/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primerproyecto.interfaz;

import javax.swing.*;
import java.awt.*;
import primerproyecto.model.Bus;
import primerproyecto.model.Vehiculo;
import primerproyecto.service.ServicioVehiculo;

/**
 *
 * @author jdsol
 */
public class GUISearchBus extends javax.swing.JFrame {
    
    private Bus busActual;
    private final ServicioVehiculo barbosa = ServicioVehiculo.getInstance();

    // Colores del tema moderno (amarillo para buses)
    private static final Color BACKGROUND_COLOR = new Color(245, 248, 250);
    private static final Color PRIMARY_COLOR = new Color(241, 196, 15);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(230, 126, 34);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);
    private static final Color HEADER_COLOR = new Color(52, 73, 94);

    public GUISearchBus() {
        this.setTitle("🔍 Buscar Bus");
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

        // Personalizar título
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabel1.setForeground(PRIMARY_COLOR);
        jLabel1.setText("🔍 BUSCAR BUS");

        // Personalizar labels con iconos
        customizeLabel(jLabel2, "🔤 Placa a buscar:");
        customizeLabel(jLabel4, "🏷️ Marca:");
        customizeLabel(jLabel5, "🎨 Color:");
        customizeLabel(jLabel6, "📋 Modelo:");
        customizeLabel(jLabel7, "📅 Año:");
        customizeLabel(jLabel8, "⚙️ Estado:");
        customizeLabel(jLabel9, "⛽ Combustible:");
        customizeLabel(jLabel10, "📺 Televisores:");
        customizeLabel(jLabel11, "🚿 Baño:");
        customizeLabel(jLabel12, "🏢 Segundo Piso:");
        customizeLabel(jLabel13, "👥 Pasajeros:");
        customizeLabel(jLabel14, "💰 Valor Comercial:");

        // Personalizar campo de búsqueda
        txtSearch.setFont(new Font("Segoe UI", Font.BOLD, 14));
        txtSearch.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(WARNING_COLOR, 2),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        // Personalizar campos de resultado
        customizeResultField(txtMarca);
        customizeResultField(txtColor);
        customizeResultField(txtModelo);
        customizeResultField(txtAnio);
        customizeResultField(txtEstado);
        customizeResultField(txtCombustible);
        customizeResultField(txtTelevisores);
        customizeResultField(txtBanio);
        customizeResultField(txtSegundoPiso);
        customizeResultField(txtPasajeros);

        // Campo de valor comercial especial
        txtValorComercial.setFont(new Font("Segoe UI", Font.BOLD, 16));
        txtValorComercial.setForeground(SUCCESS_COLOR);
        txtValorComercial.setEditable(false);
        txtValorComercial.setBackground(new Color(248, 249, 250));
        txtValorComercial.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SUCCESS_COLOR, 2),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        // Personalizar botones
        customizeButton(buscarBus, "🔍 BUSCAR", WARNING_COLOR);
        customizeButton(btnSalir, "❌ SALIR", DANGER_COLOR);
        customizeButton(btnLimpiar, "🧹 LIMPIAR", new Color(155, 89, 182));
        customizeButton(btnCalcularTarifa, "🎫 CALCULAR TARIFA", PRIMARY_COLOR);
    }

    private void makeResponsive() {
        setLayout(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(HEADER_COLOR);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titleLabel = new JLabel("🔍 BÚSQUEDA DE BUSES");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerPanel.add(titleLabel);

        // Main content - hacer scrollable
        JScrollPane scrollPane = new JScrollPane(jPanel1);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        scrollPane.getViewport().setBackground(BACKGROUND_COLOR);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(new Color(236, 240, 241));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        buttonPanel.add(buscarBus);
        buttonPanel.add(btnCalcularTarifa);
        buttonPanel.add(btnLimpiar);
        buttonPanel.add(btnSalir);

        // Assembly
        add(headerPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Configurar ventana responsive
        setMinimumSize(new Dimension(700, 650));
        setPreferredSize(new Dimension(800, 750));
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
        button.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(130, 35));

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
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtCombustible = new javax.swing.JTextField();
        txtTelevisores = new javax.swing.JTextField();
        txtBanio = new javax.swing.JTextField();
        txtSegundoPiso = new javax.swing.JTextField();
        txtPasajeros = new javax.swing.JTextField();
        txtValorComercial = new javax.swing.JTextField();
        buscarBus = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCalcularTarifa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(Color.WHITE);
        jPanel1.setMinimumSize(new Dimension(550, 600));
        jPanel1.setPreferredSize(new Dimension(600, 650));

        jLabel1.setText("BUSCAR BUS");
        jLabel2.setText("Placa:");
        jLabel4.setText("Marca:");
        jLabel5.setText("Color:");
        jLabel6.setText("Modelo:");
        jLabel7.setText("Año:");
        jLabel8.setText("Estado:");
        jLabel9.setText("Combustible:");
        jLabel10.setText("Televisores:");
        jLabel11.setText("Baño:");
        jLabel12.setText("Segundo Piso:");
        jLabel13.setText("Pasajeros:");
        jLabel14.setText("Valor Comercial:");

        buscarBus.setText("BUSCAR");
        buscarBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBusActionPerformed(evt);
            }
        });

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCalcularTarifa.setText("CALCULAR TARIFA");
        btnCalcularTarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularTarifaActionPerformed(evt);
            }
        });

        // Layout del panel principal
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
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(txtMarca)
                            .addComponent(txtColor)
                            .addComponent(txtModelo)
                            .addComponent(txtAnio)
                            .addComponent(txtEstado)
                            .addComponent(txtCombustible)
                            .addComponent(txtTelevisores)
                            .addComponent(txtBanio)
                            .addComponent(txtSegundoPiso)
                            .addComponent(txtPasajeros)
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
                .addGap(15, 15, 15)
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
                    .addComponent(txtTelevisores, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtBanio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSegundoPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtValorComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarBusActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String placa = txtSearch.getText().trim();

            if (placa.isEmpty()) {
                mostrarError("❌ Error de Validación", "Por favor ingresa la placa del bus a buscar");
                txtSearch.requestFocus();
                return;
            }

            Vehiculo vehiculo = barbosa.searchVehiculo(placa);

            if (vehiculo == null) {
                mostrarError("❌ Bus No Encontrado",
                    "No se encontró un bus con la placa: " + placa.toUpperCase() + "\n\n" +
                    "Verifica que la placa esté correctamente escrita.");
                limpiarCampos();
                txtSearch.requestFocus();
                return;
            }

            if (!(vehiculo instanceof Bus)) {
                mostrarError("❌ Tipo Incorrecto",
                    "La placa " + placa.toUpperCase() + " corresponde a un CARRO, no a un bus.\n\n" +
                    "Usa la búsqueda de carros para este vehículo.");
                limpiarCampos();
                txtSearch.requestFocus();
                return;
            }

            // Cast seguro y mostrar información
            busActual = (Bus) vehiculo;
            mostrarInformacionBus();

            mostrarExito("✅ Bus Encontrado",
                String.format(
                    "🚌 Bus encontrado exitosamente:\n\n" +
                    "🏷️ %s %s (%s)\n" +
                    "📅 Año: %d\n" +
                    "👥 Pasajeros: %d\n" +
                    "💰 Valor: $%.2f\n\n" +
                    "🎯 %s\n\n" +
                    "ℹ️ Información calculada con polimorfismo",
                    busActual.getMarca(), busActual.getModelo(),
                    busActual.getPlaca(), busActual.getAnio(),
                    busActual.cantPasajeros(),
                    busActual.calcularValorComercial(),
                    busActual.getDetallesEspecificos()
                ));

        } catch (Exception e) {
            mostrarError("❌ Error Inesperado", "Ocurrió un error: " + e.getMessage());
        }
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
        limpiarCampos();
        txtSearch.setText("");
        txtSearch.requestFocus();
        busActual = null;
    }

    private void btnCalcularTarifaActionPerformed(java.awt.event.ActionEvent evt) {
        if (busActual == null) {
            mostrarError("❌ Error", "Primero debes buscar un bus para calcular su tarifa");
            return;
        }

        try {
            String input = JOptionPane.showInputDialog(this,
                "👥 Ingresa el número de pasajeros:",
                "Calcular Tarifa",
                JOptionPane.QUESTION_MESSAGE);

            if (input == null || input.trim().isEmpty()) {
                return;
            }

            int numeroPasajeros = Integer.parseInt(input.trim());

            if (numeroPasajeros <= 0) {
                mostrarError("❌ Error de Validación", "El número de pasajeros debe ser mayor a 0");
                return;
            }

            // Calcular tarifa usando polimorfismo
            double tarifa = busActual.calcularTotal(numeroPasajeros, busActual.getAnio());

            mostrarExito("✅ Tarifa Calculada",
                String.format(
                    "🎫 CÁLCULO DE TARIFA\n" +
                    "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                    "🚌 Bus: %s %s (%s)\n" +
                    "👥 Pasajeros: %d\n" +
                    "💰 Tarifa total: $%.2f\n" +
                    "💵 Tarifa por pasajero: $%.2f\n\n" +
                    "🎯 Características:\n%s\n\n" +
                    "ℹ️ Cálculo realizado usando polimorfismo\n" +
                    "con el método calcularTotal() de ICalcularTarifa",
                    busActual.getMarca(), busActual.getModelo(), busActual.getPlaca(),
                    numeroPasajeros, tarifa, tarifa / numeroPasajeros,
                    busActual.getDetallesEspecificos()
                ));

        } catch (NumberFormatException e) {
            mostrarError("❌ Error de Formato", "Debes ingresar un número válido de pasajeros");
        } catch (Exception e) {
            mostrarError("❌ Error Inesperado", "Ocurrió un error: " + e.getMessage());
        }
    }

    private void mostrarInformacionBus() {
        if (busActual != null) {
            txtMarca.setText(busActual.getMarca());
            txtColor.setText(busActual.getColor());
            txtModelo.setText(busActual.getModelo());
            txtAnio.setText(String.valueOf(busActual.getAnio()));
            txtEstado.setText(busActual.getEstado());
            txtCombustible.setText(busActual.getCombustible());
            txtTelevisores.setText(String.valueOf(busActual.getCantidadTelevisores()));
            txtBanio.setText(busActual.isTieneBanio() ? "Sí" : "No");
            txtSegundoPiso.setText(busActual.isTieneSegundoPiso() ? "Sí" : "No");
            txtPasajeros.setText(String.valueOf(busActual.cantPasajeros()));
            txtValorComercial.setText(String.format("$%.2f", busActual.calcularValorComercial()));
        }
    }

    private void limpiarCampos() {
        txtMarca.setText("");
        txtColor.setText("");
        txtModelo.setText("");
        txtAnio.setText("");
        txtEstado.setText("");
        txtCombustible.setText("");
        txtTelevisores.setText("");
        txtBanio.setText("");
        txtSegundoPiso.setText("");
        txtPasajeros.setText("");
        txtValorComercial.setText("");
    }

    private void mostrarExito(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcularTarifa;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton buscarBus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtBanio;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtCombustible;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPasajeros;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSegundoPiso;
    private javax.swing.JTextField txtTelevisores;
    private javax.swing.JTextField txtValorComercial;
    // End of variables declaration//GEN-END:variables
}
