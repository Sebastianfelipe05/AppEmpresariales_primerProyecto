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

    public Bus(String nombre, String color, String placa, String combustible, int modelo, String estado, int cantidadTelelvisores, boolean tieneBano, boolean tieneSegundoPiso) {
        super(nombre, color, placa, combustible, modelo, estado);
        this.cantidadTelevisores = cantidadTelelvisores;
        this.tienebano = tieneBano;
        this.tieneSegundoPiso = tieneSegundoPiso;
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
