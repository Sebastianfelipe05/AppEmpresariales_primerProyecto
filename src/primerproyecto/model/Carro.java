/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerproyecto.model;

/**
 *
 * @author User
 */
public class Carro extends Vehiculo {

    private int numeroPuertas;
    private boolean tieneAireAcondicionado;

    public Carro(String marca, String color, String placa, String combustible, String modelo, int anio, String estado, int numeroPuertas, boolean tieneAireAcondicionado) {
        super(marca, color, placa, combustible, modelo, anio, estado);
        this.numeroPuertas = numeroPuertas;
        this.tieneAireAcondicionado = tieneAireAcondicionado;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public boolean isTieneAireAcondicionado() {
        return tieneAireAcondicionado;
    }

    public void setTieneAireAcondicionado(boolean tieneAireAcondicionado) {
        this.tieneAireAcondicionado = tieneAireAcondicionado;
    }

    @Override
    public String toString() {
        return "Carro{" + "numeroPuertas=" + numeroPuertas + ", tieneAireAcondicionado=" + tieneAireAcondicionado + '}';
    }

}
