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
    private Bus bus = null;
    
    // Constructor con validaciones personalizadas
    public Pasajero(String nombre, int edad) {
        setNombre(nombre);
        setEdad(edad);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Bus getBus() {
        return bus;
    }

    // Setters con validaciones personalizadas
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("La edad debe estar entre 0 y 120 años");
        }
        this.edad = edad;
    }
    
    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
               "nombre='" + nombre + '\'' +
               ", edad=" + edad +
               ", bus=" + (bus != null ? bus.getPlaca() : "null") +
               '}';
    }
}
