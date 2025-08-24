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
    private boolean tieneBanio;
    private boolean tieneSegundoPiso;

    public Bus(String marca, String color, String placa, String combustible, String modelo, int anio, String estado, int cantidadTelevisores, boolean tieneBanio, boolean tieneSegundoPiso) {
        super(marca, color, placa, combustible, modelo, anio, estado);
        this.cantidadTelevisores = cantidadTelevisores;
        this.tieneBanio = tieneBanio;
        this.tieneSegundoPiso = tieneSegundoPiso;
    }

    public int getCantidadTelevisores() {
        return cantidadTelevisores;
    }

    public void setCantidadTelevisores(int cantidadTelevisores) {
        this.cantidadTelevisores = cantidadTelevisores;
    }

    public boolean isTieneBanio() {
        return tieneBanio;
    }

    public void setTieneBanio(boolean tienebano) {
        this.tieneBanio = tienebano;
    }

    public boolean isTieneSegundoPiso() {
        return tieneSegundoPiso;
    }

    public void setTieneSegundoPiso(boolean tieneSegundoPiso) {
        this.tieneSegundoPiso = tieneSegundoPiso;
    }

    @Override
    public String toString() {
        return "Bus{" + "cantidadTelevisores=" + cantidadTelevisores + ", tienebano=" + tieneBanio + ", tieneSegundoPiso=" + tieneSegundoPiso + '}';
    }

}
