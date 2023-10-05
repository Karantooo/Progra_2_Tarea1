package org.example;
/**
 * Clase para generar al cliente junto con sus datos
 *
 * @author Benjamin Alonso Espinoza Henriquez
 */
public class Cliente {
    String nombre;
    String rut;
    Direccion direccion;

    /**
     * Constructor de la clase
     * @param nombre nombre del cliente
     * @param rut rut del cliente
     * @param direccion direccion del cliente
     */
    public Cliente(String nombre, String rut, Direccion direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return Datos del cliente
     */
    @Override
    public String toString() {
        String descripcion_cliente = new String();
        descripcion_cliente += "Nombre: " + getNombre();
        descripcion_cliente += "\nRut: " + getRut();
        descripcion_cliente += "\nDireccion: " + getDireccion();

        return descripcion_cliente;
    }
}
