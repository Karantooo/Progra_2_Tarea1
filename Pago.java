package org.example;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * El objetivo de esta clase es que se encargue de la gestion de los pagos de los diferentes articulos asi como en que
 * fechas estos pagos deberian ser efectuados.
 * Esta clase solo gestiona pagos individuales pero no pagos por cuotas.
 * No
 * @author Carlos Tomás Álvarez Norambuena
 */
public abstract class Pago {
    private float monto;
    private Date fecha;

    /**
     * Constructor de la clase donde se define el monto pagado por el cliente.
     * Si se utiliza este constructor la fecha se infiera a partir de la fecha del computador esto teniendo en mente
     * que el pago se haga al momento.
     * @param monto
     */
    public Pago(float monto) {
        this.monto = monto;
        this.fecha = new Date();
    }

    /**
     * Igual que el constructor de arriba pero aca se define una fecha personalizada para realizar, por ejemplo,
     * pagos con cuotas.
     * @param monto
     * @param fecha
     */

    public Pago(float monto, Date fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Metodo toString que devuelve monto y la fecha de pago.
     */
    @Override
    public String toString(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormateada = formatoFecha.format(fecha);

        return "Informacion del pago\nMonto: " + monto + "\nDia de pago: " + fechaFormateada;
    }
}
