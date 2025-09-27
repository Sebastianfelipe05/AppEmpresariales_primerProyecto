/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerproyecto.interfaz.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * Selector de año simplificado tipo calendario
 * @author User
 */
public class SimpleYearPicker extends JPanel {

    private int selectedYear;
    private JButton triggerButton;
    private JPopupMenu popup;

    // Colores del tema
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);

    public SimpleYearPicker() {
        this.selectedYear = Calendar.getInstance().get(Calendar.YEAR);
        initComponents();
    }

    public SimpleYearPicker(int initialYear) {
        this.selectedYear = initialYear;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(150, 35));

        // Botón principal
        triggerButton = new JButton("📅 " + selectedYear);
        triggerButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        triggerButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        triggerButton.setBackground(Color.WHITE);
        triggerButton.setHorizontalAlignment(SwingConstants.LEFT);
        triggerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        triggerButton.setFocusPainted(false);

        triggerButton.addActionListener(e -> showYearSelector());

        add(triggerButton, BorderLayout.CENTER);
        createPopup();
    }

    private void createPopup() {
        popup = new JPopupMenu();
        JPanel yearPanel = new JPanel(new GridLayout(0, 4, 5, 5));
        yearPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // Crear botones para años (desde 1990 hasta año actual + 2)
        for (int year = 1990; year <= currentYear + 2; year++) {
            JButton yearBtn = new JButton(String.valueOf(year));
            yearBtn.setFont(new Font("Segoe UI", Font.PLAIN, 10));
            yearBtn.setPreferredSize(new Dimension(50, 25));
            yearBtn.setBorder(BorderFactory.createEmptyBorder(3, 6, 3, 6));
            yearBtn.setFocusPainted(false);
            yearBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

            if (year == selectedYear) {
                yearBtn.setBackground(PRIMARY_COLOR);
                yearBtn.setForeground(Color.WHITE);
            } else if (year == currentYear) {
                yearBtn.setBackground(SUCCESS_COLOR);
                yearBtn.setForeground(Color.WHITE);
            } else {
                yearBtn.setBackground(Color.WHITE);
                yearBtn.setForeground(new Color(52, 73, 94));
            }

            final int finalYear = year;
            yearBtn.addActionListener(e -> {
                selectedYear = finalYear;
                triggerButton.setText("📅 " + selectedYear);
                popup.setVisible(false);
            });

            yearPanel.add(yearBtn);
        }

        JScrollPane scrollPane = new JScrollPane(yearPanel);
        scrollPane.setPreferredSize(new Dimension(220, 200));
        scrollPane.setBorder(null);

        popup.add(scrollPane);
    }

    private void showYearSelector() {
        popup.show(triggerButton, 0, triggerButton.getHeight());
    }

    public int getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(int year) {
        this.selectedYear = year;
        triggerButton.setText("📅 " + selectedYear);
    }
}
