package primerproyecto.service;

import java.util.ArrayList;
import primerproyecto.model.Bus;
import primerproyecto.model.Pasajero;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author User
 */
public interface IServicioPasajero {
    boolean addPasajero(Bus bus, Pasajero p);
    Pasajero searchPasajero(Bus bus, String nombre);
    ArrayList<Pasajero> readPasajero(Bus bus);
    boolean updatePasajero(Bus bus, Pasajero v);
    boolean deletePasajero(Bus bus, Pasajero v);
}
