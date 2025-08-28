/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerproyecto.model;

import java.time.Year;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Bus extends Vehiculo implements ICalcularTarifa {

    private static final int TARIFA_BASE = 3000;
    
    private ArrayList<Pasajero> pasajeros;
    
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

    @Override
    public double calcularTarifaUnitaria(int anio) {
        int anioActual = Year.now().getValue();

        int diferencia = anioActual - anio;

        double descuento = diferencia * 0.03;
        if (descuento > 0.30) {
            descuento = 0.30;
        }

        return TARIFA_BASE * (1 - descuento);
    }

    @Override
    public double calcularTotal(int cantidadPasajeros, int anio) {
        return cantidadPasajeros*calcularTarifaUnitaria(anio);
    }
}
