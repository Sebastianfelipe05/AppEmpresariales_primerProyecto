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
public interface IServicioVehiculo {
    boolean addVehiculo(Vehiculo v);
    Vehiculo searchVehiculo(String placa);
    ArrayList<Vehiculo> readVehiculos();
    boolean updateVehiculo(Vehiculo v);
    boolean deleteVehiculo(Vehiculo v);
}

