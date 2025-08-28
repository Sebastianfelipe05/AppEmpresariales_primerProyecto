/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerproyecto.model;

/**
 *
 * @author User
 */
public class Pasajero {
    private String nombre;
    private int edad;
    
    Pasajero(String nombre, int edad) { // 👈 constructor con paquete default
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
