package org.example;

import java.util.Date;

/**
 * Clase que se encarga de realizar el pago mediante tarjeta
 * Esta clase hereda Pago
 * @author Carlos Tomás Álvarez Norambuena
 */
public class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;

    /**
     *  Constructor para pagos sin fecha especifica
     * @param monto monto pagado
     * @param tipo tipo de tarjeta
     * @param numTransaccion numero de transaccion
     */
    public Tarjeta(float monto, String tipo, String numTransaccion) {
        super(monto);
        this.tipo = tipo;
        this.numTransaccion = numTransaccion;
    }

    /**
     *  Constructor para pagos con fecha especifica
     * @param monto monto pagado
     * @param fecha fecha en la que se pagara
     * @param tipo tipo de tarjeta
     * @param numTransaccion numero de transaccion
     */
    public Tarjeta(float monto, Date fecha, String tipo, String numTransaccion) {
        super(monto, fecha);
        this.tipo = tipo;
        this.numTransaccion = numTransaccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumTransaccion() {
        return numTransaccion;
    }

    public void setNumTransaccion(String numTransaccion) {
        this.numTransaccion = numTransaccion;
    }

    /**
     *
     * @return informacion del pago con tarjeta
     */
    @Override
    public String toString(){
        String informacion_cuenta = new String();
        informacion_cuenta += super.toString();
        informacion_cuenta += "\nMetodo: Tarjeta";
        informacion_cuenta += "\nTipo: " + tipo;
        informacion_cuenta += "\nNumero de Transaccion: " + numTransaccion;
        informacion_cuenta += "\n\n";

        return informacion_cuenta;
    }

}
