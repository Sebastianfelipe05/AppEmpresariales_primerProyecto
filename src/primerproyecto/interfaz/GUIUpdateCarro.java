/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primerproyecto.interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import primerproyecto.interfaz.components.SimpleYearPicker;
import primerproyecto.model.Carro;
import primerproyecto.model.Vehiculo;
import primerproyecto.service.ServicioVehiculo;

/**
 *
 * @author Sebastian
 */
public class GUIUpdateCarro extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIUpdateCarro.class.getName());

    private Carro carroActual;
    private ServicioVehiculo barbosa = ServicioVehiculo.getInstance();
    private SimpleYearPicker yearPicker;
    
    // Colores del tema moderno
    private static final Color BACKGROUND_COLOR = new Color(245, 248, 250);
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(241, 196, 15);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);
    private static final Color HEADER_COLOR = new Color(52, 73, 94);
    private static final Color INFO_COLOR = new Color(155, 89, 182);

    public GUIUpdateCarro() {
        this.setTitle("✏️ Actualizar Carro");
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
        
        // Crear el calendario personalizado
        yearPicker = new SimpleYearPicker(Calendar.getInstance().get(Calendar.YEAR));
        
        // Personalizar botones
        customizeButton(btnBuscar, "🔍 BUSCAR CARRO", WARNING_COLOR);
        customizeButton(btnActualizar, "✏️ ACTUALIZAR", SUCCESS_COLOR);
        customizeButton(btnSalir, "❌ SALIR", DANGER_COLOR);
        customizeButton(btnLimpiar, "🧹 LIMPIAR", INFO_COLOR);
    }
    
    private void makeResponsive() {
        setLayout(new BorderLayout());
        
        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(HEADER_COLOR);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        
        JLabel titleLabel = new JLabel("✏️ ACTUALIZACIÓN DE CARROS");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerPanel.add(titleLabel);
        
        // Main content - hacer scrollable
        JScrollPane scrollPane = new JScrollPane(jPanel1);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        scrollPane.getViewport().setBackground(BACKGROUND_COLOR);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(new Color(236, 240, 241));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        buttonPanel.add(btnBuscar);
        buttonPanel.add(btnActualizar);
        buttonPanel.add(btnLimpiar);
        buttonPanel.add(btnSalir);
        
        // Assembly
        add(headerPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Configurar ventana responsive
        setMinimumSize(new Dimension(700, 600));
        setPreferredSize(new Dimension(800, 700));
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
        button.setPreferredSize(new Dimension(140, 40));
        
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
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(Color.WHITE);
        jPanel1.setMinimumSize(new Dimension(550, 400));
        jPanel1.setPreferredSize(new Dimension(600, 450));

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabel1.setForeground(PRIMARY_COLOR);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("✏️ ACTUALIZAR CARRO");

        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jLabel2.setForeground(new Color(52, 73, 94));
        jLabel2.setText("🔤 Placa del carro a actualizar:");

        txtSearch.setFont(new Font("Segoe UI", Font.BOLD, 14));
        txtSearch.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(WARNING_COLOR, 2),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
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

        // Layout simple y limpio
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20)
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(informacionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        // Panel de información que se muestra después de la búsqueda
        informacionPanel = new javax.swing.JPanel();
        informacionPanel.setBackground(new Color(248, 249, 250));
        informacionPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(INFO_COLOR, 2),
            "📋 Información del Carro",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new Font("Segoe UI", Font.BOLD, 14),
            INFO_COLOR
        ));
        informacionPanel.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            String placa = txtSearch.getText().trim();
            
            if (placa.isEmpty()) {
                mostrarError("❌ Error de Validación", "Por favor ingresa la placa del carro a actualizar");
                txtSearch.requestFocus();
                return;
            }
            
            Vehiculo vehiculo = barbosa.searchVehiculo(placa);
            
            if (vehiculo == null) {
                mostrarError("❌ Carro No Encontrado", 
                    "No se encontró un carro con la placa: " + placa.toUpperCase() + "\n\n" +
                    "Verifica que la placa esté correctamente escrita.");
                informacionPanel.setVisible(false);
                btnActualizar.setEnabled(false);
                pack();
                return;
            }
            
            if (!(vehiculo instanceof Carro)) {
                mostrarError("❌ Tipo Incorrecto", 
                    "La placa " + placa.toUpperCase() + " corresponde a un BUS, no a un carro.\n\n" +
                    "Usa la actualización de buses para este vehículo.");
                informacionPanel.setVisible(false);
                btnActualizar.setEnabled(false);
                pack();
                return;
            }
            
            // Mostrar información del carro encontrado
            carroActual = (Carro) vehiculo;
            mostrarInformacionCarro();
            informacionPanel.setVisible(true);
            btnActualizar.setEnabled(true);
            pack();
            
            mostrarExito("✅ Carro Encontrado", 
                String.format(
                    "🚗 Carro listo para actualizar:\n\n" +
                    "🏷️ %s %s (%s)\n" +
                    "📅 Año: %d\n" +
                    "💰 Valor actual: $%.2f\n\n" +
                    "✏️ Ahora puedes modificar los campos y\n" +
                    "hacer clic en ACTUALIZAR",
                    carroActual.getMarca(), carroActual.getModelo(), 
                    carroActual.getPlaca(), carroActual.getAnio(),
                    carroActual.calcularValorComercial()
                ));
            
        } catch (Exception e) {
            mostrarError("❌ Error Inesperado", "Ocurrió un error: " + e.getMessage());
        }
    }                                         

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if (carroActual == null) {
            mostrarError("❌ Error", "Primero debes buscar un carro para actualizar");
            return;
        }
        
        try {
            // Actualizar con los nuevos valores del formulario
            String nuevaMarca = txtMarca.getText().trim();
            String nuevoColor = boxColor.getSelectedItem().toString();
            String nuevoModelo = txtModelo.getText().trim();
            int nuevoAnio = yearPicker.getSelectedYear();
            String nuevoEstado = boxEstado.getSelectedItem().toString();
            String nuevoCombustible = boxCombustible.getSelectedItem().toString();
            int nuevasPuertas = Integer.parseInt(txtNumeroPuertas.getText().trim());
            boolean nuevoAire = "Sí".equals(boxAire.getSelectedItem().toString());
            
            // Crear carro actualizado
            Carro carroActualizado = new Carro(
                nuevaMarca, nuevoColor, carroActual.getPlaca(), // Placa no cambia
                nuevoCombustible, nuevoModelo, nuevoAnio, nuevoEstado,
                nuevasPuertas, nuevoAire
            );
            
            if (barbosa.updateVehiculo(carroActualizado)) {
                mostrarExito("✅ ¡Carro Actualizado!", 
                    String.format(
                        "El carro ha sido actualizado exitosamente:\n\n" +
                        "🚗 %s %s (%s)\n" +
                        "📅 Año: %d\n" +
                        "💰 Nuevo valor: $%.2f\n\n" +
                        "✨ Actualización realizada con polimorfismo",
                        nuevaMarca, nuevoModelo, carroActual.getPlaca(),
                        nuevoAnio, carroActualizado.calcularValorComercial()
                    ));
                
                // Recargar información actualizada
                carroActual = carroActualizado;
                mostrarInformacionCarro();
                
            } else {
                mostrarError("❌ Error al Actualizar", "No se pudo actualizar el carro");
            }
            
        } catch (NumberFormatException e) {
            mostrarError("❌ Error de Formato", "El número de puertas debe ser un número válido");
        } catch (Exception e) {
            mostrarError("❌ Error Inesperado", "Ocurrió un error: " + e.getMessage());
        }
    }                                             

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                         
        dispose();
    }                                        

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        txtSearch.setText("");
        informacionPanel.setVisible(false);
        btnActualizar.setEnabled(false);
        carroActual = null;
        pack();
        txtSearch.requestFocus();
    }                                          
    
    private void mostrarInformacionCarro() {
        if (carroActual != null) {
            // Aquí se cargarían los campos del formulario con la información actual
            // del carro para que el usuario pueda editarlos
        }
    }
    
    private void mostrarExito(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> boxAire;
    private javax.swing.JComboBox<String> boxColor;
    private javax.swing.JComboBox<String> boxCombustible;
    private javax.swing.JComboBox<String> boxEstado;
    private javax.swing.JPanel informacionPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumeroPuertas;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
