/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package primerproyecto.service;

import java.util.ArrayList;
import primerproyecto.model.Vehiculo;

public class ServicioVehiculo implements IServicioVehiculo {

    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    @Override
    public boolean addVehiculo(Vehiculo v) {
        if(v == null) return false;
        vehiculos.add(v);
        for(Vehiculo k : vehiculos) {
            System.out.println(k);
        }
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
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteVehiculo(Vehiculo v) {
        if (v != null) {
            vehiculos.remove(v);
            return true;
        }
        return false;
    }
}
