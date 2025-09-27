/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerproyecto.model;

/**
 * Singleton pattern para información de la empresa
 * @author User
 */
public class EmpresaInfo {

    private static EmpresaInfo instance;

    // Información de la empresa
    private final String nombreEmpresa = "Concesionario AAA";
    private final String version = "2.0";
    private final String[] desarrolladores = {
        "Sebastian Solano",
        "Juan David Reyes",
        "Julio Suarez"
    };
    private final String fechaCreacion = "2025";
    private final String descripcion = "Sistema de gestión de concesionario con polimorfismo";

    // Constructor privado para Singleton
    private EmpresaInfo() {
    }

    // Implementación thread-safe del Singleton
    public static synchronized EmpresaInfo getInstance() {
        if (instance == null) {
            instance = new EmpresaInfo();
        }
        return instance;
    }

    // Getters
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getVersion() {
        return version;
    }

    public String[] getDesarrolladores() {
        return desarrolladores.clone();
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDesarrolladoresTexto() {
        return String.join(", ", desarrolladores);
    }

    public String getInfoCompleta() {
        return String.format(
            "%s v%s\n\n" +
            "Desarrollado por: %s\n" +
            "Año: %s\n\n" +
            "%s",
            nombreEmpresa, version, getDesarrolladoresTexto(), fechaCreacion, descripcion);
    }

    @Override
    public String toString() {
        return "EmpresaInfo{" +
               "nombreEmpresa='" + nombreEmpresa + '\'' +
               ", version='" + version + '\'' +
               ", fechaCreacion='" + fechaCreacion + '\'' +
               '}';
    }
}
