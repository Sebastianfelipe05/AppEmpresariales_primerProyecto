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
    private String estado;

    public Vehiculo(String nombre, String color, String placa, String combustible, int modelo, String estado) {
        this.nombre = nombre;
        this.color = color;
        this.placa = placa;
        this.combustible = combustible;
        this.modelo = modelo;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "nombre=" + nombre + ", color=" + color + ", placa=" + placa + ", combustible=" + combustible + ", modelo=" + modelo + ", estado =" + estado + '}';
    }
    
    
    
}
