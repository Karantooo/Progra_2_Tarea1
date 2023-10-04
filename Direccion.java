package org.cliente;
/**
 * Clase para generar la direccion de la tienda o del cliente
 *
 * @author Benjamin Alonso Espinoza Henriquez
 */
public class Direccion {
    String direccion;

    /**
     * Constructor de la clase
     * @param direccion
     */
    public Direccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return La direccion sea del cliente o de la tienda
     */
    @Override
    public String toString() {
        return "La Direccion es" + getDireccion();
    }
}
