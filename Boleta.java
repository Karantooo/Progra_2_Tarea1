package org.example;
import java.util.Date;

/**
 * Clase con el objetivo de generar un documento tributario de tipo boleta
 * Esta clase hereda DocTributario
 * @author Benjamin Alonso Espinoza Henriquez
 */
public class Boleta extends DocTributario {

    /**
     * Constructor de la clase
     * @param num numero de boleta
     * @param rut rut del cliente
     * @param fecha fecha en la que se realizo el pago
     * @param direccion direccion del cliente
     */
    public Boleta(String num, String rut, Date fecha, Direccion direccion, OrdenCompra ordenCompra) {
        super(num, rut, fecha, direccion, ordenCompra);
    }
    /**
     * @return String de la boleta con los datos de la compra
     */
    @Override
    public String toString() {
        String descripcion_boleta = new String();
        descripcion_boleta += super.toString() + "\nTipo: Boleta";

        return descripcion_boleta;
    }
}
