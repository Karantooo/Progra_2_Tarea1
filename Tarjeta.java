package org.example;

import java.util.Date;

public class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;

    public Tarjeta(float monto, String tipo, String numTransaccion) {
        super(monto);
        this.tipo = tipo;
        this.numTransaccion = numTransaccion;
        tipoTransaccion = MetodoDePago.TARJETA;
    }

    public Tarjeta(float monto, Date fecha, String tipo, String numTransaccion) {
        super(monto, fecha);
        this.tipo = tipo;
        this.numTransaccion = numTransaccion;
        tipoTransaccion = MetodoDePago.TARJETA;
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
