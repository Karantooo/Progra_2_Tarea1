package org.example;

import java.util.Date;

/**
 * Esta clase esta pensanda para procesar los pagos de transferencia
 * Esta clase hereda directamente de Pago.
 * Todo pago hecho por transferencia se asume exacto
 * @author Carlos Tomás Álvarez Norambuena
 */

public class Transferencia extends Pago{
    private String banco;
    private String numCuenta;

    /**
     *
     * @param monto Monto a transferir.
     * @param banco Banco desde al que se hizo la transferencia.
     * @param numCuenta Numero de la cuenta.
     */
    public Transferencia(float monto, String banco, String numCuenta) {
        super(monto);
        this.banco = banco;
        this.numCuenta = numCuenta;
    }

    /**
     * Este constructor es igual al anterior con la diferencia de que acepta fecha arbitrarias
     * @param monto Monto a transferir.
     * @param fecha Fecha arbitraria en la que se realiza el pago.
     * @param banco Banco al que se hizo la transferencia.
     * @param numCuentaNumero de la cuenta.
     */
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
     * @return string con informacion de la transferencia
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
