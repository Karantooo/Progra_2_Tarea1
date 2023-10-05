package org.example;
import java.util.Date;

/**
 * Clase con el objetivo de generar un documento tributario de tipo factura
 *
 * @author Benjamin Alonso Espinoza Henriquez
 */
public class Factura extends DocTributario{

    /**
     * Constructor de la clase
     * @param num numero de factura
     * @param rut rut del cliente
     * @param fecha fecha en la que se realizo el pago
     * @param direccion direccion de la tienda
     */
    public Factura(String num, String rut, Date fecha, Direccion direccion) {
        super(num, rut, fecha, direccion);
    }
    /**
     * @return String de la factura con los datos de la compra
     */
    @Override
    public String toString() {
        String descripcion_factura = new String();
        descripcion_factura += super.toString() + "\nTipo: Factura";

        return descripcion_factura;
    }
}
