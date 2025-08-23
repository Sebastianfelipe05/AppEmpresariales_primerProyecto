/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerproyecto.service;

import java.util.ArrayList;
import primerproyecto.model.Vehiculo;

/**
 *
 * @author User
 */
public class ServicioVehiculo implements IServicioVehiculo {

    ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    @Override
    public void addVehiculo(Vehiculo v) {
        vehiculos.add(v);
    }

    @Override
    public Vehiculo searchVehiculo(String placa) {
        for (Vehiculo v : vehiculos) {
            if (placa.equals(v.getPlaca())) {
                return v;
            }
        }
        return null;
    }

    @Override
    public void readVehiculo(ArrayList<Vehiculo> vehiculos) {
        for (Vehiculo v : vehiculos) {
            //pasar vehiculo
        }
    }

    @Override
    public void updateVehiculo(Vehiculo v) {
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo actual = vehiculos.get(i);
            if (actual.getPlaca().equalsIgnoreCase(v.getPlaca())) {
                vehiculos.set(i, v);
                return;
            }
        }
    }

    @Override
    public void deleteVehiculo(String placa) {
        Vehiculo v = searchVehiculo(placa);
        if (v != null) {
            vehiculos.remove(v);
        }
    }
}
