package org.example;
import java.util.Date;

/**
 * Clase abstracta que se usa para dar forma a los documentos tributarios
 *
 * @author Benjamin Alonso Espinoza Henriquez
 */
 abstract public class DocTributario {
    private String num;
    private String rut;
    private Date fecha;
    private Direccion direccion;

    /**
     * Constructor donde se definen los datos del cliente
     * @param num numero del documento
     * @param rut rut del cliente
     * @param fecha fecha en la que se realizo el pago
     * @param direccion direccion de la tienda
     */
    public DocTributario(String num, String rut, Date fecha, Direccion direccion) {
        this.num = num;
        this.rut = rut;
        this.fecha = fecha;
        this.direccion = direccion;
    }
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    /**
     * @return String del documento con los datos de la compra
     */
    @Override
    public String toString() {
        String descrpicion_doc = new String();
        descrpicion_doc += "Numero: " + getNum();
        descrpicion_doc += "\nRut: " + getRut();
        descrpicion_doc += "\nFecha: " + getFecha();
        descrpicion_doc += "\nDireccion: " + getDireccion();

        return descrpicion_doc;
    }
}
