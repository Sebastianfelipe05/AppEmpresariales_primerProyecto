package primerproyecto.service;

import java.util.ArrayList;
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
    boolean addPasajero(Pasajero v);
    Pasajero searchPasajero(String nombre);
    ArrayList<Pasajero> readPasajero();
    boolean updatePasajero(Pasajero v);
    boolean deletePasajero(Pasajero v);
}
