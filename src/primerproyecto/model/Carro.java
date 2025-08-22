/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerproyecto.model;

/**
 *
 * @author User
 */
public class Carro extends Vehiculo{
    private int numeroPuertas;
    private boolean tieneAireAcondicionado;

    public Carro(String nombre, String color, String placa, String combustible, int modelo, int kilometraje, int numeroPuertas, boolean tieneAireAcondicionado) {
        super(nombre, color, placa, combustible, modelo, kilometraje);
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
