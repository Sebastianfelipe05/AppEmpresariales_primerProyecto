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
 * Selector de año tipo calendario moderno
 * @author User
 */
public class YearCalendarPicker extends JPanel {

    private int selectedYear;
    private JLabel yearLabel;
    private JPanel yearGrid;
    private JPopupMenu popup;
    private JButton triggerButton;

    // Colores del tema
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SECONDARY_COLOR = new Color(46, 204, 113);
    private static final Color HOVER_COLOR = new Color(174, 207, 245);
    private static final Color SELECTED_COLOR = PRIMARY_COLOR;

    public YearCalendarPicker() {
        this.selectedYear = Calendar.getInstance().get(Calendar.YEAR);
        initComponents();
    }

    public YearCalendarPicker(int initialYear) {
        this.selectedYear = initialYear;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Botón principal que activa el calendario
        triggerButton = new JButton();
        updateButtonText();
        triggerButton.setPreferredSize(new Dimension(150, 35));
        triggerButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        triggerButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        triggerButton.setBackground(Color.WHITE);
        triggerButton.setHorizontalAlignment(SwingConstants.LEFT);
        triggerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        triggerButton.addActionListener(e -> showYearPicker());

        add(triggerButton, BorderLayout.CENTER);

        // Crear el popup del calendario
        createYearPickerPopup();
    }

    private void updateButtonText() {
        if (triggerButton != null) {
            triggerButton.setText("📅 " + selectedYear);
        }
    }

    private void createYearPickerPopup() {
        popup = new JPopupMenu();
        popup.setLayout(new BorderLayout());

        // Panel principal del calendario
        JPanel calendarPanel = new JPanel(new BorderLayout());
        calendarPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        calendarPanel.setPreferredSize(new Dimension(280, 220));

        // Header con navegación
        JPanel headerPanel = createHeaderPanel();
        calendarPanel.add(headerPanel, BorderLayout.NORTH);

        // Grid de años
        yearGrid = new JPanel(new GridLayout(4, 3, 5, 5));
        updateYearGrid();

        JScrollPane scrollPane = new JScrollPane(yearGrid);
        scrollPane.setPreferredSize(new Dimension(260, 160));
        scrollPane.setBorder(null);
        calendarPanel.add(scrollPane, BorderLayout.CENTER);

        popup.add(calendarPanel);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Botones de navegación
        JButton prevButton = new JButton("◀");
        JButton nextButton = new JButton("▶");

        prevButton.setPreferredSize(new Dimension(40, 30));
        nextButton.setPreferredSize(new Dimension(40, 30));

        styleNavigationButton(prevButton);
        styleNavigationButton(nextButton);

        // Label del rango de años
        yearLabel = new JLabel();
        yearLabel.setHorizontalAlignment(SwingConstants.CENTER);
        yearLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        yearLabel.setForeground(PRIMARY_COLOR);
        updateYearLabel();

        // Eventos de navegación
        prevButton.addActionListener(e -> {
            selectedYear -= 12;
            updateYearGrid();
            updateYearLabel();
        });

        nextButton.addActionListener(e -> {
            selectedYear += 12;
            updateYearGrid();
            updateYearLabel();
        });

        headerPanel.add(prevButton, BorderLayout.WEST);
        headerPanel.add(yearLabel, BorderLayout.CENTER);
        headerPanel.add(nextButton, BorderLayout.EAST);

        return headerPanel;
    }

    private void styleNavigationButton(JButton button) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(PRIMARY_COLOR.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(PRIMARY_COLOR);
            }
        });
    }

    private void updateYearLabel() {
        int startYear = selectedYear - (selectedYear % 12);
        int endYear = startYear + 11;
        yearLabel.setText(startYear + " - " + endYear);
    }

    private void updateYearGrid() {
        yearGrid.removeAll();

        int startYear = selectedYear - (selectedYear % 12);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = 0; i < 12; i++) {
            int year = startYear + i;
            JButton yearButton = new JButton(String.valueOf(year));

            styleYearButton(yearButton, year, currentYear);

            final int finalYear = year;
            yearButton.addActionListener(e -> {
                selectedYear = finalYear;
                updateButtonText();
                popup.setVisible(false);
                firePropertyChange("selectedYear", null, selectedYear);
            });

            yearGrid.add(yearButton);
        }

        yearGrid.revalidate();
        yearGrid.repaint();
    }

    private void styleYearButton(JButton button, int year, int currentYear) {
        button.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        button.setPreferredSize(new Dimension(60, 35));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Colores según el estado
        if (year == selectedYear) {
            button.setBackground(SELECTED_COLOR);
            button.setForeground(Color.WHITE);
        } else if (year == currentYear) {
            button.setBackground(SECONDARY_COLOR);
            button.setForeground(Color.WHITE);
        } else {
            button.setBackground(Color.WHITE);
            button.setForeground(new Color(52, 73, 94));
        }

        // Efecto hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            Color originalBg = button.getBackground();
            Color originalFg = button.getForeground();

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (year != selectedYear) {
                    button.setBackground(HOVER_COLOR);
                    button.setForeground(PRIMARY_COLOR);
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (year != selectedYear) {
                    button.setBackground(originalBg);
                    button.setForeground(originalFg);
                }
            }
        });
    }

    private void showYearPicker() {
        updateYearGrid();
        updateYearLabel();
        popup.show(triggerButton, 0, triggerButton.getHeight());
    }

    // Métodos públicos
    public int getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(int year) {
        this.selectedYear = year;
        updateButtonText();
        updateYearGrid();
    }

    public void addYearChangeListener(ActionListener listener) {
        addPropertyChangeListener("selectedYear", evt ->
            listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "yearChanged")));
    }
}
