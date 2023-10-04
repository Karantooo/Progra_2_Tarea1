package org.example;
import java.util.Date;
/**
 * Esta clase esta creada con el objetivo de gestionar los pagos realizados con efectivo.
 * Cabe recalcar que esta clase no maneja el caso en que el monto pagado sea inferior a precio.
 * Esto con el objetivo de que si esto sucede el objeto nunca se genere.
 * @author Carlos Tomás Álvarez Norambuena
 */
public class Efectivo extends Pago{
    private float precio_articulo;

    /**
     *Constructor de la clase que toma la fecha actual del sistema para el pago
     * @param precio_articulo precio que la tienda cobra por el articulo.
     * @param monto monto que pago el cliente.
     */
    public Efectivo(float precio_articulo, float monto) {
        super(monto);
        if (precio_articulo > monto)
            throw new IllegalArgumentException("Se esta intentando comprar un articulo por debajo de su precio.");
        this.precio_articulo = precio_articulo;
    }

    /**
     *Constructor de la clase que toma fecha personalizada
     * @param precio_articulo precio que la tienda cobra por el articulo.
     * @param monto monto que pago el cliente.
     * @param fecha momento especifico en que se realiza el pago.
     */
    public Efectivo(float precio_articulo, float monto, Date fecha) {
        super(monto, fecha);
        if (precio_articulo > monto)
            throw new IllegalArgumentException("Se esta intentando comprar un articulo por debajo de su precio.");
        this.precio_articulo = precio_articulo;
    }

    /**
     * @return Devuelve el vuelto que se debe devolver al cliente.
     */
    public float calcDevolucion(){
        return super.getMonto() - precio_articulo;
    }

    /**
     *
     * @return Entrega string con el toString de pago y su vuelto.
     */
    @Override
    public String toString(){
        return super.toString() + "\nMetodo: Efectivo"  + "Vuelto: " + calcDevolucion() + "\n\n";
    }
}
