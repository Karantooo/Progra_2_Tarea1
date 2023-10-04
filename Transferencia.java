package org.example;

import java.util.Date;

public class Transferencia extends Pago{
    private String banco;
    private String numCuenta;

    public Transferencia(float monto, String banco, String numCuenta) {
        super(monto);
        this.banco = banco;
        this.numCuenta = numCuenta;
    }

    public Transferencia(float monto, Date fecha, String banco, String numCuenta) {
        super(monto, fecha);
        this.banco = banco;
        this.numCuenta = numCuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    /**
     * Devuelve informaciones varias del objeto.
     * @return
     */
    @Override
    public String toString(){
        String informacion_cuenta = new String();
        informacion_cuenta += super.toString();
        informacion_cuenta += "\nMetodo: Transferencia";
        informacion_cuenta += "\nBanco: " + banco ;
        informacion_cuenta += "\nNumero de cuenta: " + numCuenta + "\n\n";

        return informacion_cuenta;
    }
}
