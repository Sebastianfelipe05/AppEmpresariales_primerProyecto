/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerproyecto.model;

/**
 *
 * @author User
 */
public class Bus extends Vehiculo {
    private int cantidadTelevisores;
    private boolean tienebano;
    private boolean tieneSegundoPiso;

    public Bus(String marca, String color, String placa, String combustible, String modelo, int anio, String estado) {
        super(marca, color, placa, combustible, modelo, anio, estado);
    }

    public int getCantidadTelevisores() {
        return cantidadTelevisores;
    }

    public void setCantidadTelevisores(int cantidadTelevisores) {
        this.cantidadTelevisores = cantidadTelevisores;
    }

    public boolean isTienebano() {
        return tienebano;
    }

    public void setTienebano(boolean tienebano) {
        this.tienebano = tienebano;
    }

    public boolean isTieneSegundoPiso() {
        return tieneSegundoPiso;
    }

    public void setTieneSegundoPiso(boolean tieneSegundoPiso) {
        this.tieneSegundoPiso = tieneSegundoPiso;
    }

    @Override
    public String toString() {
        return "Bus{" + "cantidadTelevisores=" + cantidadTelevisores + ", tienebano=" + tienebano + ", tieneSegundoPiso=" + tieneSegundoPiso + '}';
    }

    
    
}
