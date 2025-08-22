/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerproyecto.model;

/**
 *
 * @author User
 */
public class Moto extends Vehiculo {
    private int cilindraje;
    private boolean tieneSideCar;

    public Moto(String nombre, String color, String placa, String combustible, int modelo, int kilometraje, int cilindraje, boolean tieneSideCar) {
        super(nombre, color, placa, combustible, modelo, kilometraje);
        this.cilindraje = cilindraje;
        this.tieneSideCar = tieneSideCar;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public boolean isTieneSideCar() {
        return tieneSideCar;
    }

    public void setTieneSideCar(boolean tieneSideCar) {
        this.tieneSideCar = tieneSideCar;
    }

    @Override
    public String toString() {
        return "Moto{" + "cilindraje=" + cilindraje + ", tieneSideCar=" + tieneSideCar + '}';
    }
    
}
