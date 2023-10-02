package org.cliente;
import java.util.Date;

/**
 * Clase con el objetivo de generar un documento tributario de tipo boleta
 *
 * @author Benjamin Alonso Espinoza Henriquez
 */
public class Boleta extends DocTributario {

    /**
     * Constructor de la clase
     * @param num numero de boleta
     * @param rut rut del cliente
     * @param fecha fecha en la que se realizo el pago
     * @param direccion direccion de la tienda
     */
    public Boleta(String num, String rut, Date fecha, Direccion direccion) {
        super(num, rut, fecha, direccion);
    }
    /**
     * @return String de la boleta con los datos de la compra
     */
    @Override
    public String toString() {
        return "Boleta numero: " + super.getNum() + "\nrut: " + super.getRut() + "\nfecha: " + super.getFecha()
                + "\ndireccion: " + super.getDireccion();
    }
}
