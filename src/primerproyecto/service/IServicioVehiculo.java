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
    public void addVehiculo(Vehiculo v);
    public Vehiculo searchVehiculo(String placa);
    public void readVehiculo(ArrayList<Vehiculo> vehiculos);
    public void updateVehiculo(Vehiculo v);
    public void deleteVehiculo(String placa);
}
