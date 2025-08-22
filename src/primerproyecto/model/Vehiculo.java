/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerproyecto.model;

/**
 *
 * @author User
 */
public abstract class Vehiculo {
    private String nombre;
    private String color;
    private String placa;
    private String combustible;
    private int modelo;
    private int kilometraje;

    public Vehiculo(String nombre, String color, String placa, String combustible, int modelo, int kilometraje) {
        this.nombre = nombre;
        this.color = color;
        this.placa = placa;
        this.combustible = combustible;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "nombre=" + nombre + ", color=" + color + ", placa=" + placa + ", combustible=" + combustible + ", modelo=" + modelo + ", kilometraje=" + kilometraje + '}';
    }
    
    
    
}
