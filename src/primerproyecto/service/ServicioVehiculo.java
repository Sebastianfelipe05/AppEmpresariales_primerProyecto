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
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private ArrayList<ICambio> windows = new ArrayList<>();

    // Constructor privado para prevenir instanciación externa
    private ServicioVehiculo() {
    }
    
    public void addWindow(ICambio window) {
        windows.add(window);
    }
    
    public void deleteWindow(ICambio window) {
        windows.remove(window);
    }
    
    private boolean windowUpdate() {

        for (ICambio window : windows) {
            window.cambio();
        }

        return true;
    }

    // Método estático para obtener la instancia única
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
        windowUpdate();
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
                windowUpdate();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteVehiculo(Vehiculo v) {
        if (v != null) {
            vehiculos.remove(v);
            windowUpdate();
            return true;
        }
        return false;
    }
}
