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
    private String marca;
    private String color;
    private String placa;
    private String combustible;
    private String modelo;
    private int anio;
    private String estado;

    public Vehiculo(String marca, String color, String placa, String combustible, String modelo, int anio, String estado) {
        this.marca = marca;
        this.color = color;
        this.placa = placa;
        this.combustible = combustible;
        this.modelo = modelo;
        this.anio = anio;
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", color=" + color + ", placa=" + placa + ", combustible=" + combustible + ", modelo=" + modelo + ", anio=" + anio + ", estado=" + estado + '}';
    }

   
    
    
    
}
