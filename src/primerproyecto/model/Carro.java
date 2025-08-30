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

    //POLINMORFISMO
    @Override
    public String getTipoVehiculo() {
        return "AUTOMÓVIL";
    }

    @Override
    public String getDetallesEspecificos() {
        return String.format("Puertas: %d | Aire A/C: %s",
                numeroPuertas,
                tieneAireAcondicionado ? "Sí" : "No");
    }

    @Override
    public double calcularValorComercial() {
        double valorBase = 45000000;
        double depreciacion = (2024 - getAnio()) * 0.08; // 8% anual

        // Bonificaciones específicas del CARRO
        if (tieneAireAcondicionado) {
            valorBase += 3000000;
        }
        if (numeroPuertas == 4) {
            valorBase += 2000000;
        }

        return valorBase * (1 - Math.min(depreciacion, 0.75));
    }

    @Override
    public String obtenerInformacionMantenimiento() {
        int kilometraje = (2024 - getAnio()) * 15000; // Estimado
        return String.format("Mantenimiento cada 10.000 km | Estimado: %d km", kilometraje);
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
