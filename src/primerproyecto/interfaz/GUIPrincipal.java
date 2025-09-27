/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primerproyecto.interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import primerproyecto.service.ServicioVehiculo;

/**
 *
 * @author Sebastian
 */
public class GUIPrincipal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIPrincipal.class.getName());

    private final ServicioVehiculo barbosa = ServicioVehiculo.getInstance();

    // Colores modernos para el tema
    private static final Color BACKGROUND_COLOR = new Color(245, 248, 250);
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SECONDARY_COLOR = new Color(46, 204, 113);
    private static final Color ACCENT_COLOR = new Color(241, 196, 15);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);

    public GUIPrincipal() {
        // Configurar Look and Feel moderno
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            // Fallback al look and feel del sistema
        }

        this.setTitle("🚗 Concesionario AAA - Sistema de Gestión");
        initComponents();
        customizeUI();
        setLocationRelativeTo(null); // Centrar ventana
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar ventana
    }

    private void customizeUI() {
        // Personalizar la barra de menú
        jMenuBar1.setBackground(PRIMARY_COLOR);
        jMenuBar1.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Personalizar menús principales
        customizeMenu(archivo, "📁", SECONDARY_COLOR);
        customizeMenu(search, "🚗", PRIMARY_COLOR);
        customizeMenu(jMenu1, "🚌", ACCENT_COLOR);
        customizeMenu(jMAddpasajero, "👥", new Color(155, 89, 182));
        customizeMenu(ayuda, "❓", new Color(52, 73, 94));

        // Personalizar el panel principal
        getContentPane().setBackground(BACKGROUND_COLOR);

        // Crear panel principal con mejor layout
        javax.swing.JPanel mainPanel = new javax.swing.JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        // Panel superior con título
        javax.swing.JPanel headerPanel = createHeaderPanel();

        // Panel central con imagen y información
        javax.swing.JPanel centerPanel = createCenterPanel();

        // Panel inferior con estadísticas
        javax.swing.JPanel footerPanel = createFooterPanel();

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private javax.swing.JPanel createHeaderPanel() {
        javax.swing.JPanel headerPanel = new javax.swing.JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(52, 73, 94));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        javax.swing.JLabel titleLabel = new javax.swing.JLabel("🏢 CONCESIONARIO AAA");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.JLabel subtitleLabel = new javax.swing.JLabel("Sistema Integral de Gestión Vehicular");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitleLabel.setForeground(new Color(189, 195, 199));
        subtitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        headerPanel.add(titleLabel, BorderLayout.CENTER);
        headerPanel.add(subtitleLabel, BorderLayout.SOUTH);

        return headerPanel;
    }

    private javax.swing.JPanel createCenterPanel() {
        javax.swing.JPanel centerPanel = new javax.swing.JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(BACKGROUND_COLOR);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        GridBagConstraints gbc = new GridBagConstraints();

        // Panel de imagen principal
        javax.swing.JPanel imagePanel = new javax.swing.JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        imagePanel.setLayout(new BorderLayout());

        try {
            ImageIcon originalIcon = new ImageIcon(getClass().getResource("/primerproyecto/interfaz/image.png"));
            Image scaledImage = originalIcon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            javax.swing.JLabel imageLabel = new javax.swing.JLabel(new ImageIcon(scaledImage));
            imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imagePanel.add(imageLabel, BorderLayout.CENTER);
        } catch (Exception e) {
            javax.swing.JLabel placeholderLabel = new javax.swing.JLabel("🚗 IMAGEN DEL CONCESIONARIO");
            placeholderLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            placeholderLabel.setForeground(new Color(127, 140, 141));
            placeholderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            imagePanel.add(placeholderLabel, BorderLayout.CENTER);
        }

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 20, 10);
        centerPanel.add(imagePanel, gbc);

        // Panel de características
        javax.swing.JPanel featuresPanel = createFeaturesPanel();
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        centerPanel.add(featuresPanel, gbc);

        // Panel de acciones rápidas
        javax.swing.JPanel quickActionsPanel = createQuickActionsPanel();
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.insets = new Insets(10, 20, 10, 10);
        centerPanel.add(quickActionsPanel, gbc);

        return centerPanel;
    }

    private javax.swing.JPanel createFeaturesPanel() {
        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
            "✨ Características del Sistema",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new Font("Segoe UI", Font.BOLD, 14),
            PRIMARY_COLOR
        ));

        String[] features = {
            "🚗 Gestión completa de automóviles",
            "🚌 Administración de buses",
            "👥 Control de pasajeros",
            "💰 Cálculos polimórficos de valores",
            "📊 Reportes detallados",
            "🔄 Patrón Observer implementado"
        };

        for (String feature : features) {
            javax.swing.JLabel featureLabel = new javax.swing.JLabel(feature);
            featureLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            featureLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            panel.add(featureLabel);
        }

        return panel;
    }

    private javax.swing.JPanel createQuickActionsPanel() {
        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(SECONDARY_COLOR, 2),
            "🚀 Acciones Rápidas",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new Font("Segoe UI", Font.BOLD, 14),
            SECONDARY_COLOR
        ));

        // Botones de acciones rápidas
        javax.swing.JButton addCarBtn = createStyledButton("➕ Agregar Carro", PRIMARY_COLOR);
        addCarBtn.addActionListener(evt -> addCarroActionPerformed(evt));

        javax.swing.JButton addBusBtn = createStyledButton("➕ Agregar Bus", ACCENT_COLOR);
        addBusBtn.addActionListener(evt -> addBusActionPerformed(evt));

        javax.swing.JButton listCarBtn = createStyledButton("📋 Listar Carros", SECONDARY_COLOR);
        listCarBtn.addActionListener(evt -> listarCarroActionPerformed(evt));

        javax.swing.JButton listBusBtn = createStyledButton("📋 Listar Buses", new Color(155, 89, 182));
        listBusBtn.addActionListener(evt -> listarBusActionPerformed(evt));

        javax.swing.JButton reportBtn = createStyledButton("📊 Reporte Polimórfico", new Color(230, 126, 34));
        reportBtn.addActionListener(evt -> reporteValorComercialActionPerformed(evt));

        javax.swing.JButton tarifaBtn = createStyledButton("💰 Ver Tarifas", new Color(26, 188, 156));
        tarifaBtn.addActionListener(evt -> mostrarTarifaActionPerformed(evt));

        panel.add(addCarBtn);
        panel.add(addBusBtn);
        panel.add(listCarBtn);
        panel.add(listBusBtn);
        panel.add(reportBtn);
        panel.add(tarifaBtn);

        return panel;
    }

    private javax.swing.JButton createStyledButton(String text, Color backgroundColor) {
        javax.swing.JButton button = new javax.swing.JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Efecto hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor);
            }
        });

        return button;
    }

    private javax.swing.JPanel createFooterPanel() {
        javax.swing.JPanel footerPanel = new javax.swing.JPanel();
        footerPanel.setLayout(new BorderLayout());
        footerPanel.setBackground(new Color(52, 73, 94));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

        // Panel de estadísticas
        javax.swing.JPanel statsPanel = new javax.swing.JPanel();
        statsPanel.setLayout(new FlowLayout());
        statsPanel.setBackground(new Color(52, 73, 94));

        int totalVehiculos = barbosa.readVehiculos().size();

        javax.swing.JLabel statsLabel = new javax.swing.JLabel(
            String.format("📈 Total de Vehículos: %d | 🔧 Sistema Activo | ⚡ Polimorfismo Implementado",
            totalVehiculos)
        );
        statsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        statsLabel.setForeground(new Color(189, 195, 199));

        statsPanel.add(statsLabel);

        // Información del desarrollador
        javax.swing.JLabel devLabel = new javax.swing.JLabel("💻 Desarrollado por Sebastian Solano, Juan David Reyes y Julio Suarez - v2.0");
        devLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        devLabel.setForeground(new Color(127, 140, 141));

        footerPanel.add(statsPanel, BorderLayout.CENTER);
        footerPanel.add(devLabel, BorderLayout.SOUTH);

        return footerPanel;
    }

    private void customizeMenu(javax.swing.JMenu menu, String icon, Color color) {
        menu.setText(icon + " " + menu.getText());
        menu.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menu.setForeground(Color.WHITE);
        menu.setOpaque(true);
        menu.setBackground(color);
        menu.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        mostrarTarifa = new javax.swing.JMenuItem();
        search = new javax.swing.JMenu();
        addCarro = new javax.swing.JMenuItem();
        updateCarro = new javax.swing.JMenuItem();
        deleteCarro = new javax.swing.JMenuItem();
        listarCarro = new javax.swing.JMenuItem();
        jMenuSearchCarro = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        addBus = new javax.swing.JMenuItem();
        updateBus = new javax.swing.JMenuItem();
        deleteBus = new javax.swing.JMenuItem();
        listarBus = new javax.swing.JMenuItem();
        jMenuSearchBus = new javax.swing.JMenuItem();
        jMAddpasajero = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMUpdpasa = new javax.swing.JMenuItem();
        jMDelePasa = new javax.swing.JMenuItem();
        jMListPasajero = new javax.swing.JMenuItem();
        ayuda = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("🚗 Concesionario AAA - Sistema Avanzado");
        setMinimumSize(new java.awt.Dimension(1000, 700));

        archivo.setText("Archivo");

        mostrarTarifa.setText("💰 Mostrar Tarifa");
        mostrarTarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTarifaActionPerformed(evt);
            }
        });
        archivo.add(mostrarTarifa);

        // NUEVO MENU PARA DEMOSTRAR POLIMORFISMO
        javax.swing.JMenuItem reporteValorComercial = new javax.swing.JMenuItem();
        reporteValorComercial.setText("📊 Reporte Valores Comerciales (POLIMORFISMO)");
        reporteValorComercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteValorComercialActionPerformed(evt);
            }
        });
        archivo.add(reporteValorComercial);

        jMenuBar1.add(archivo);

        search.setText("Carro");

        addCarro.setText("➕ Agregar Carro");
        addCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCarroActionPerformed(evt);
            }
        });
        search.add(addCarro);

        updateCarro.setText("✏️ Actualizar Carro");
        updateCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCarroActionPerformed(evt);
            }
        });
        search.add(updateCarro);

        deleteCarro.setText("🗑️ Eliminar Carro");
        deleteCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCarroActionPerformed(evt);
            }
        });
        search.add(deleteCarro);

        listarCarro.setText("📋 Listar Carros");
        listarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarCarroActionPerformed(evt);
            }
        });
        search.add(listarCarro);

        jMenuSearchCarro.setText("🔍 Buscar Carro");
        jMenuSearchCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSearchCarroActionPerformed(evt);
            }
        });
        search.add(jMenuSearchCarro);

        jMenuBar1.add(search);

        jMenu1.setText("Bus");

        addBus.setText("➕ Agregar Bus");
        addBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBusActionPerformed(evt);
            }
        });
        jMenu1.add(addBus);

        updateBus.setText("✏️ Actualizar Bus");
        updateBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBusActionPerformed(evt);
            }
        });
        jMenu1.add(updateBus);

        deleteBus.setText("🗑️ Eliminar Bus");
        deleteBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBusActionPerformed(evt);
            }
        });
        jMenu1.add(deleteBus);

        listarBus.setText("📋 Listar Buses");
        listarBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarBusActionPerformed(evt);
            }
        });
        jMenu1.add(listarBus);

        jMenuSearchBus.setText("🔍 Buscar Bus");
        jMenuSearchBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSearchBusActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSearchBus);

        jMenuBar1.add(jMenu1);

        jMAddpasajero.setText("Pasajero");

        jMenuItem3.setText("➕ Agregar Pasajero");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMAddpasajero.add(jMenuItem3);

        jMUpdpasa.setText("✏️ Actualizar Pasajero");
        jMUpdpasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMUpdpasaActionPerformed(evt);
            }
        });
        jMAddpasajero.add(jMUpdpasa);

        jMDelePasa.setText("🗑️ Eliminar Pasajero");
        jMDelePasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMDelePasaActionPerformed(evt);
            }
        });
        jMAddpasajero.add(jMDelePasa);

        jMListPasajero.setText("📋 Listar Pasajeros");
        jMListPasajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListPasajeroActionPerformed(evt);
            }
        });
        jMAddpasajero.add(jMListPasajero);

        jMenuBar1.add(jMAddpasajero);

        ayuda.setText("Ayuda");

        jMenuItem2.setText("ℹ️ Acerca de");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        ayuda.add(jMenuItem2);

        jMenuBar1.add(ayuda);

        setJMenuBar(jMenuBar1);


        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // Usar el Singleton optimizado con Lombok
        primerproyecto.model.EmpresaInfo empresaInfo = primerproyecto.model.EmpresaInfo.getInstance();
        JOptionPane.showMessageDialog(this, empresaInfo.getInfoCompleta(),
                "Acerca de " + empresaInfo.getNombreEmpresa(),
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void updateCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCarroActionPerformed
        // TODO add your handling code here:
        GUIUpdateCarro updateCarroFrame = new GUIUpdateCarro();
        updateCarroFrame.setLocationRelativeTo(this); // centrar respecto al principal
        updateCarroFrame.setVisible(true);
    }//GEN-LAST:event_updateCarroActionPerformed

    private void listarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarCarroActionPerformed
        // TODO add your handling code here:
        GUIListCarro listCarroFrame = new GUIListCarro();
        listCarroFrame.setLocationRelativeTo(this); // centrar respecto al principal
        listCarroFrame.setVisible(true);
        barbosa.addWindow(listCarroFrame);
    }//GEN-LAST:event_listarCarroActionPerformed

    private void updateBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBusActionPerformed
        // TODO add your handling code here:

        GUIUpdateBus updateBusFrame = new GUIUpdateBus();
        updateBusFrame.setLocationRelativeTo(this); // centrar respecto al principal
        updateBusFrame.setVisible(true);

    }//GEN-LAST:event_updateBusActionPerformed

    private void deleteBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBusActionPerformed
        // TODO add your handling code here:
        GUIDeleteBus deleteBusFrame = new GUIDeleteBus();
        deleteBusFrame.setLocationRelativeTo(this); // centrar respecto al principal
        deleteBusFrame.setVisible(true);
    }//GEN-LAST:event_deleteBusActionPerformed

    private void listarBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarBusActionPerformed
        // TODO add your handling code here:
        GUIListBus listBusFrame = new GUIListBus();
        listBusFrame.setLocationRelativeTo(this); // centrar respecto al principal
        listBusFrame.setVisible(true);
        barbosa.addWindow(listBusFrame);
    }//GEN-LAST:event_listarBusActionPerformed

    private void addCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCarroActionPerformed
        // TODO add your handling code here:

        GUIAddCarro panel = new GUIAddCarro(); // tu JPanel

        JFrame frame = new JFrame("Agregar Carro");
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // centrar
        frame.setVisible(true);

    }//GEN-LAST:event_addCarroActionPerformed

    private void addBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBusActionPerformed
        // TODO add your handling code here:

        GUIAddBus panel = new GUIAddBus(); // tu JPanel

        JFrame frame = new JFrame("Agregar Bus");
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // centrar
        frame.setVisible(true);

    }//GEN-LAST:event_addBusActionPerformed

    private void deleteCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCarroActionPerformed
        // TODO add your handling code here:
        GUIDeleteCarro deleteCarroFrame = new GUIDeleteCarro();
        deleteCarroFrame.setLocationRelativeTo(this); // centrar respecto al principal
        deleteCarroFrame.setVisible(true);
    }//GEN-LAST:event_deleteCarroActionPerformed

    private void jMenuSearchCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSearchCarroActionPerformed
        // TODO add your handling code here:
        GUISearchCarro searchCarroFrame = new GUISearchCarro();
        searchCarroFrame.setLocationRelativeTo(this); // centrar respecto al principal
        searchCarroFrame.setVisible(true);
    }//GEN-LAST:event_jMenuSearchCarroActionPerformed

    private void jMenuSearchBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSearchBusActionPerformed
        // TODO add your handling code here:
        GUISearchBus searchBusFrame = new GUISearchBus();
        searchBusFrame.setLocationRelativeTo(this); // centrar respecto al principal
        searchBusFrame.setVisible(true);
    }//GEN-LAST:event_jMenuSearchBusActionPerformed

    private void mostrarTarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTarifaActionPerformed
        // TODO add your handling code here:
        GUIMostrarTarifa searchBusFrame = new GUIMostrarTarifa();
        searchBusFrame.setLocationRelativeTo(this); // centrar respecto al principal
        searchBusFrame.setVisible(true);
    }//GEN-LAST:event_mostrarTarifaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        GUIAddPasaje addPasajeroFrame = new GUIAddPasaje();
        JFrame frame = new JFrame("Agregar Pasajero");
        frame.setContentPane(addPasajeroFrame);
        frame.pack();
        frame.setLocationRelativeTo(null); // centrar
        frame.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMUpdpasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMUpdpasaActionPerformed
        // TODO add your handling code here:
        GUIUpdatePasaje addPasajeroFrame = new GUIUpdatePasaje();
        JFrame frame = new JFrame("Actualizar Pasajero");
        frame.setContentPane(addPasajeroFrame);
        frame.pack();
        frame.setLocationRelativeTo(null); // centrar
        frame.setVisible(true);
    }//GEN-LAST:event_jMUpdpasaActionPerformed

    private void jMDelePasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMDelePasaActionPerformed
        // TODO add your handling code here:
        GUIDeletePasaje addPasajeroFrame = new GUIDeletePasaje();
        JFrame frame = new JFrame("Eliminar Pasajero");
        frame.setContentPane(addPasajeroFrame);
        frame.pack();
        frame.setLocationRelativeTo(null); // centrar
        frame.setVisible(true);
    }//GEN-LAST:event_jMDelePasaActionPerformed

    private void jMListPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListPasajeroActionPerformed
        // TODO add your handling code here:
        GUIListPasaje addPasajeroFrame = new GUIListPasaje(null);
        JFrame frame = new JFrame("Listar Pasajeros");
        frame.setContentPane(addPasajeroFrame);
        frame.pack();
        frame.setLocationRelativeTo(null); // centrar
        frame.setVisible(true);
    }//GEN-LAST:event_jMListPasajeroActionPerformed

    private void reporteValorComercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteValorComercialActionPerformed
        // TODO add your handling code here:
        GUIReporteValorComercial reporteFrame = new GUIReporteValorComercial();
        reporteFrame.setLocationRelativeTo(this); // centrar respecto al principal
        reporteFrame.setVisible(true);
    }//GEN-LAST:event_reporteValorComercialActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GUIPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addBus;
    private javax.swing.JMenuItem addCarro;
    private javax.swing.JMenu archivo;
    private javax.swing.JMenu ayuda;
    private javax.swing.JMenuItem deleteBus;
    private javax.swing.JMenuItem deleteCarro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMAddpasajero;
    private javax.swing.JMenuItem jMDelePasa;
    private javax.swing.JMenuItem jMListPasajero;
    private javax.swing.JMenuItem jMUpdpasa;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuSearchBus;
    private javax.swing.JMenuItem jMenuSearchCarro;
    private javax.swing.JMenuItem listarBus;
    private javax.swing.JMenuItem listarCarro;
    private javax.swing.JMenuItem mostrarTarifa;
    private javax.swing.JMenu search;
    private javax.swing.JMenuItem updateBus;
    private javax.swing.JMenuItem updateCarro;
    // End of variables declaration//GEN-END:variables
}
