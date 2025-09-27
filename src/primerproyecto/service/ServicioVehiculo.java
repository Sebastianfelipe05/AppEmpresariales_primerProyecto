/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerproyecto.service;

import java.util.ArrayList;
import primerproyecto.interfaz.ICambio;
import primerproyecto.model.Vehiculo;

public class ServicioVehiculo implements IServicioVehiculo {

    // Instancia única del Singleton
    private static ServicioVehiculo instance;

    // Lista de vehículos (estado interno)
    private final ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private final ArrayList<ICambio> windows = new ArrayList<>();

    // Constructor privado para prevenir instanciación externa
    private ServicioVehiculo() {
    }
    
    public void addWindow(ICambio window) {
        windows.add(window);
    }
    
    public void deleteWindow(ICambio window) {
        windows.remove(window);
    }
    
    public boolean notifyObservers() {

        for (ICambio window : windows) {
            window.cambio();
        }

        return true;
    }

    public static ServicioVehiculo getInstance() {
        if (instance == null) {
            instance = new ServicioVehiculo();
        }
        return instance;
    }

    @Override
    public boolean addVehiculo(Vehiculo v) {
        if (v == null) {
            return false;
        }
        vehiculos.add(v);
        for (Vehiculo k : vehiculos) {
            System.out.println(k);
        }
        notifyObservers();
        return true;
    }

    @Override
    public Vehiculo searchVehiculo(String placa) {
        for (Vehiculo v : vehiculos) {
            if (placa.equalsIgnoreCase(v.getPlaca())) {
                return v;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Vehiculo> readVehiculos() {
        return vehiculos; // devuelvo la lista
    }

    @Override
    public boolean updateVehiculo(Vehiculo v) {
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo actual = vehiculos.get(i);
            if (actual.getPlaca().equalsIgnoreCase(v.getPlaca())) {
                vehiculos.set(i, v);
                notifyObservers();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteVehiculo(Vehiculo v) {
        if (v != null) {
            vehiculos.remove(v);
            notifyObservers();
            return true;
        }
        return false;
    }

    // MÉTODOS QUE DEMUESTRAN POLIMORFISMO
    /**
     * Calcula el valor comercial total de todos los vehículos usando polimorfismo
     * Cada tipo de vehículo (Carro/Bus) tiene su propia implementación del cálculo
     */
    public double calcularValorComercialTotal() {
        double valorTotal = 0.0;
        for (Vehiculo vehiculo : vehiculos) {
            valorTotal += vehiculo.calcularValorComercial(); // LLAMADA POLIMÓRFICA
        }
        return valorTotal;
    }

    /**
     * Calcula el valor promedio por tipo de vehículo usando polimorfismo
     */
    public String calcularValorPromedioPorTipo() {
        double valorCarros = 0.0;
        double valorBuses = 0.0;
        int contadorCarros = 0;
        int contadorBuses = 0;

        for (Vehiculo vehiculo : vehiculos) {
            double valor = vehiculo.calcularValorComercial(); // LLAMADA POLIMÓRFICA
            if (vehiculo.getTipoVehiculo().contains("AUTOMÓVIL")) { // LLAMADA POLIMÓRFICA
                valorCarros += valor;
                contadorCarros++;
            } else {
                valorBuses += valor;
                contadorBuses++;
            }
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append("=== ANALISIS DE VALORES COMERCIALES ===\n");

        if (contadorCarros > 0) {
            resultado.append(String.format("Carros - Promedio: $%.2f (Total: %d vehículos)\n",
                valorCarros / contadorCarros, contadorCarros));
        }

        if (contadorBuses > 0) {
            resultado.append(String.format("Buses - Promedio: $%.2f (Total: %d vehículos)\n",
                valorBuses / contadorBuses, contadorBuses));
        }

        if (!vehiculos.isEmpty()) {
            resultado.append(String.format("Valor Total de Inventario: $%.2f",
                calcularValorComercialTotal()));
        } else {
            resultado.append("No hay vehículos en el inventario");
        }

        return resultado.toString();
    }

    /**
     * Obtiene información detallada de todos los vehículos usando polimorfismo
     */
    public String obtenerReporteCompleto() {
        if (vehiculos.isEmpty()) {
            return "No hay vehiculos registrados en el sistema.";
        }

        StringBuilder reporte = new StringBuilder();
        reporte.append("=== REPORTE COMPLETO DE VEHICULOS ===\n\n");

        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo vehiculo = vehiculos.get(i);
            reporte.append(String.format("VEHICULO #%d\n", i + 1));
            reporte.append(vehiculo.getInformacionCompleta()); // LLAMADA POLIMÓRFICA
            reporte.append("\n");
            reporte.append("Mantenimiento: ").append(vehiculo.obtenerInformacionMantenimiento()); // LLAMADA POLIMÓRFICA
            reporte.append("\n");
            reporte.append("─".repeat(50)).append("\n\n");
        }

        reporte.append(calcularValorPromedioPorTipo());
        return reporte.toString();
    }
}
