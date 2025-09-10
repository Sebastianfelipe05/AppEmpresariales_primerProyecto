/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerproyecto.service;

import java.util.ArrayList;
import primerproyecto.model.Bus;
import primerproyecto.model.Pasajero;

/**
 *
 * @author User
 */
public class ServicioPasajero implements IServicioPasajero {

    private static ServicioPasajero instance;

    private ServicioPasajero() {}

    public static ServicioPasajero getInstance() {
        if (instance == null) instance = new ServicioPasajero();
        return instance;
    }

    // Agrega pasajero al bus
    @Override
    public boolean addPasajero(Bus bus, Pasajero p) {
        if (bus == null || p == null) return false;
        bus.addPasajero(p);
        ServicioVehiculo.getInstance().notifyObservers(); // notifica a las vistas registradas
        return true;
    }

    // Buscar pasajero en un bus por nombre
    @Override
    public Pasajero searchPasajero(Bus bus, String nombre) {
        if (bus == null || nombre == null) return null;
        for (Pasajero k : bus.getPasajeros()) {
            if (k.getNombre().equalsIgnoreCase(nombre)) return k;
        }
        return null;
    }

    @Override
    public java.util.ArrayList<Pasajero> readPasajero(Bus bus) {
        return bus.getPasajeros(); // devuelve la lista del bus
    }

    @Override
    public boolean updatePasajero(Bus bus, Pasajero v) {
        if (bus == null || v == null) return false;
        bus.updatePasajero(v);
        ServicioVehiculo.getInstance().notifyObservers();
        return true;
    }

    @Override
    public boolean deletePasajero(Bus bus, Pasajero v) {
        if (bus == null || v == null) return false;
        bus.removePasajero(v);
        ServicioVehiculo.getInstance().notifyObservers();
        return true;
    }
}