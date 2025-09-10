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
        this.pasajeros = new ArrayList<Pasajero>();
    }

    //POLIMORFISMO: Implementación específica para BUS
    @Override
    public String getTipoVehiculo() {
        return tieneSegundoPiso ? "BUS DE DOS PISOS" : "BUS INTERMUNICIPAL";
    }

    @Override
    public String getDetallesEspecificos() {
        return String.format("TV: %d | Baño: %s | 2do Piso: %s | Pasajeros: %d",
                cantidadTelevisores,
                tieneBanio ? "Sí" : "No",
                tieneSegundoPiso ? "Sí" : "No",
                cantPasajeros());
    }

    @Override
    public double calcularValorComercial() {
        double valorBase = 180000000;
        double depreciacion = (2024 - getAnio()) * 0.06; // 6% anual

        // Bonificaciones específicas del BUS
        if (tieneBanio) {
            valorBase += 15000000;
        }
        if (tieneSegundoPiso) {
            valorBase += 25000000;
        }
        valorBase += cantidadTelevisores * 800000;

        return valorBase * (1 - Math.min(depreciacion, 0.70));
    }

    @Override
    public String obtenerInformacionMantenimiento() {
        int kilometraje = (2024 - getAnio()) * 80000; // Estimado buses
        return String.format("Revisión cada 5.000 km | Estimado: %d km | Próxima: %s",
                kilometraje,
                tieneBanio ? "Revisión completa" : "Mantenimiento básico");
    }

    // IMPLEMENTACIÓN DE LA INTERFAZ ICalcularTarifa
    @Override
    public double calcularTotal(int cantidadPasajeros, int anio) {
        int anioActual = Year.now().getValue();
        int diferencia = anioActual - anio;
        double descuento = diferencia * 0.03;
        if (descuento > 0.30) {
            descuento = 0.30;
        }
        double tarifaUnitaria = TARIFA_BASE * (1 - descuento);

        // Bonificación por comodidades en la tarifa
        if (tieneBanio) {
            tarifaUnitaria += 500;
        }
        if (tieneSegundoPiso) {
            tarifaUnitaria += 800;
        }
        if (cantidadTelevisores > 0) {
            tarifaUnitaria += 300;
        }

        return cantidadPasajeros * tarifaUnitaria;
    }

    // Métodos específicos del Bus
    public void addPasajero(Pasajero pasajero) {
        pasajeros.add(pasajero);
    }

    public void removePasajero(Pasajero pasajero) {
        pasajeros.remove(pasajero);
    }
    
    public void updatePasajero(Pasajero v) {
        for (int i = 0; i < pasajeros.size(); i++) {
            Pasajero actual = pasajeros.get(i);
            if (actual.getNombre().equalsIgnoreCase(v.getNombre())) {
                pasajeros.set(i, v);
            }
        }
    }
    
    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public int cantPasajeros() {
        return pasajeros.size();
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

    public void setTieneBanio(boolean tienebanio) {
        this.tieneBanio = tienebanio;
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
