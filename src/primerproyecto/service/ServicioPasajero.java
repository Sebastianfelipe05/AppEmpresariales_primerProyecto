/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerproyecto.service;

import java.util.ArrayList;
import primerproyecto.model.Pasajero;

/**
 *
 * @author User
 */
public class ServicioPasajero implements IServicioPasajero {
    
    private static ServicioPasajero servicioPasajero;
    private ArrayList<Pasajero> pasajeros;
    
    private ServicioPasajero () {
    }
    
    public static ServicioPasajero getInstance(){
        if(servicioPasajero == null) servicioPasajero = new ServicioPasajero();
        
        return servicioPasajero;
    }

    @Override
    public boolean addPasajero(Pasajero v) {
        if(pasajeros.add(v)) return true;
        return false;
    }

    @Override
    public Pasajero searchPasajero(String nombre) {
        for(Pasajero k: pasajeros) {
            if(k.getNombre().equalsIgnoreCase(nombre)) {
                return k;
            }
        }
        return null;
    }
        
    @Override
    public ArrayList<Pasajero> readPasajero() {
        return pasajeros;
    }
        
    @Override
    public boolean updatePasajero(Pasajero v) {
        for (int i = 0; i < pasajeros.size(); i++) {
            Pasajero actual = pasajeros.get(i);
            if (actual.getNombre().equalsIgnoreCase(v.getNombre())) {
                pasajeros.set(i, v);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deletePasajero(Pasajero v) {
        if(pasajeros.remove(v)) return true;
        return false; 
    }
}
