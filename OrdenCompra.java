package org.example;

import java.util.Date;
import java.util.ArrayList;

/**
 * Clase encarga de generar la orden de compra, calcular el precio total, generar documentos tributarios y
 * ingresar los pagos hechos
 * @author Carlos Tomás Álvarez Norambuena
 * @author Benjamin Alonso Espinoza Henriquez
 */
public class OrdenCompra {
    private Date fecha;
    private String estado;
    private ArrayList <DetalleOrden> detalleOrdenes;
    private ArrayList <Pago> pagoCompra;
    private int size;
    private Cliente cliente;
    private float precioPorPagar;
    private DocTributario docTributario;
    private static int numdoc;


    /**
     * Constructor de la clase con cliente y fecha asociada
     * @param fecha fecha en la que se realizo la orden
     * @param cliente cliente para el que se realiza la orden
     */
    public OrdenCompra(Date fecha, Cliente cliente) {
        this.fecha = fecha;
        this.detalleOrdenes = new ArrayList<DetalleOrden>();
        this.docTributario = null;
        numdoc = 0;
        size = 0;
        this.cliente = cliente;
        cliente.asociarOrdenCompra(this);
        pagoCompra = new ArrayList<Pago>();
        precioPorPagar = calcPrecio();
        estado = new String("Sin resolver.");
    }

    /**
     * Constructor de la clase con fecha y estado de la compra asociados
     * @param fecha fecha en la que se realizo la orden
     * @param estado estado de la orden
     */
    public OrdenCompra(Date fecha, String estado) {
        this.fecha = fecha;
        this.estado = estado;
        this.detalleOrdenes = new ArrayList<DetalleOrden>();
        this.docTributario = null;
        numdoc = 0;
        size = 0;
        this.cliente = null;
        pagoCompra = new ArrayList<Pago>();
        precioPorPagar = calcPrecio();
    }

    /**
     *Se encarga de agregar detalles de orden.
     *
     * @param orden detalle de orden ingresado
     */
    public void addDetalleOrden(DetalleOrden orden){
        size++;
        precioPorPagar += orden.calcPrecio();
        detalleOrdenes.add(orden);
    }

    /**
     *Se encarga de agregar detalles de orden en el indice indicado.
     *
     * @param orden detalle de orden ingresado
     * @param index indice en el que se quiere agregar el detalle de orden
     */
    public void addDetalleOrden(DetalleOrden orden, int index){
        size++;
        precioPorPagar += orden.calcPrecio();
        detalleOrdenes.add(index, orden);
    }

    /**
     *Se encarga de retirar un detalle de orden.
     *
     * @return primer detalle de orden
     */
    public DetalleOrden removeDetalleOrden(){
        DetalleOrden detalleOrden = null;
        try{
            if (size == 0)
                throw new IllegalArgumentException("Se intenta extraer una orden pero no hay.");
            size--;
            detalleOrden = detalleOrdenes.remove(0);
            precioPorPagar -= detalleOrden.calcPrecio();

        }
        finally{
            return detalleOrden;
        }
    }

    /**
     *Se encarga de retirar un detalle de orden indicado.
     * @param index indice
     * @return detalle de orden indicado
     */
    public DetalleOrden removeDetalleOrden(int index){
        DetalleOrden detalleOrden = null;
        try{
            if (size < index)
                throw new IllegalArgumentException("Se intenta extraer una orden fuera de indice.");
            size--;
            detalleOrden = detalleOrdenes.remove(index);
            precioPorPagar -= detalleOrden.calcPrecio();
        }
        finally{
            return detalleOrden;
        }
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<DetalleOrden> getDetalleOrdenes() {
        return detalleOrdenes;
    }

    public void setDetalleOrdenes(ArrayList<DetalleOrden> detalleOrdenes) {
        this.detalleOrdenes = detalleOrdenes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Pago> getPagoCompra() {
        return pagoCompra;
    }

    public void setPagoCompra(ArrayList<Pago> pagoCompra) {
        this.pagoCompra = pagoCompra;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getPrecioPorPagar() {
        return precioPorPagar;
    }

    public void setPrecioPorPagar(float precioPorPagar) {
        this.precioPorPagar = precioPorPagar;
    }

    public DocTributario getDocTributario() {
        return docTributario;
    }

    public void setDocTributario(DocTributario docTributario) {
        this.docTributario = docTributario;
    }

    /**
     *Calcula el precio sin IVA.
     * @return precio total sin IVA
     */
    public float calcPrecioSinIVA(){
        float precioSinIVA = 0;

        for (int i = 0; i < size; i++){
            precioSinIVA += detalleOrdenes.get(i).calcPrecioSinIVA();
        }
        return precioSinIVA;
    }

    /**
     *Calcula solo el IVA.
     * @return solo el IVA
     */
    public float calcIVA(){
        float IVA = 0;
        for (int i = 0; i < size; i++){
            IVA += detalleOrdenes.get(i).calcIVA();
        }
        return IVA;
    }

    /**
     *Calcula el precio total.
     * @return precio total con IVA incluido
     */
    public float calcPrecio(){
        float precioConIVA = 0;
        for (int i = 0; i < size; i++){
            precioConIVA += detalleOrdenes.get(i).calcPrecio();
        }
        return precioConIVA;
    }

    /**
     *Calcula el peso total.
     * @return peso total de la orden
     */
    public float calcPeso(){
        float peso = 0;
        for (int i = 0; i < size; i++){
            peso += detalleOrdenes.get(i).calcPeso();
        }
        return peso;
    }

    /**
     *Se detalla lo que se quiere pagar asi como el pago en efectivo que realiza para devolver el vuelto.
     * En caso de que se quiera pagar más de lo que falta por pagar o el monto pagado es inferior a obtetivo a pagar
     * se devuelve 0 y no se efectua dicho pago.
     * @param montoPagado Monto que paga en dinero el usuario.
     * @param objetivoAPagar Monto que se quiere pagar para calcular el vuelto.
     * @param fechaPago Fecha en que se va a efectuar el pago.
     * @return Vuelto a devolver.
     */
    public Pago pagarEnEfectivo(float montoPagado,float objetivoAPagar ,Date fechaPago){
        if (montoPagado < objetivoAPagar || objetivoAPagar > precioPorPagar || estado == "Pago realizado.")
            return null;
        estado = "En proceso.";
        Efectivo efectivo = new Efectivo(objetivoAPagar, montoPagado, fechaPago);
        pagoCompra.add(efectivo);
        precioPorPagar -= objetivoAPagar;
        if (precioPorPagar == 0)
            estado = "Pago realizado.";

        return efectivo;
    }

    /**
     *Se encarga de realizar el pago por transferencia.
     * En caso de que se quiera pagar más de lo que falta por pagar o ya se haya realizado el pago
     * devuelve 0
     * @param montoPagado monto que se pago
     * @param fechaPago fecha en la que se pago
     * @param banco banco desde el que se realiza el pago
     * @param numCuenta numero de cuenta desde la que se realiza el pago
     * @return pago que se realizo
     */
    public Pago pagarEnTransferencia(float montoPagado, Date fechaPago, String banco, String numCuenta){
        if (montoPagado > precioPorPagar || estado == "Pago realizado.")
            return null;
        estado = "En proceso.";
        Transferencia transferencia = new Transferencia(montoPagado, fechaPago, banco, numCuenta);

        pagoCompra.add(transferencia);
        precioPorPagar -= montoPagado;
        if (precioPorPagar == 0)
            estado = "Pago realizado.";
        return transferencia;
    }

    /**
     *Se encarga de realizar el pago en tarjeta.
     * En caso de que se quiera pagar más de lo que falta por pagar o el pago esta realizado
     * devuelve 0
     * @param montoPagado monto pagado
     * @param fechaPago fecha en la que se realizo el pago
     * @param tipo tipo de tarjeta
     * @param numTransaccion numero de transaccion
     * @return pago que se realizo
     */
    public Pago pagarEnTarjeta(float montoPagado, Date fechaPago, String tipo, String numTransaccion){
        if (montoPagado > precioPorPagar || estado == "Pago realizado.")
            return null;
        estado = "En proceso.";
        Tarjeta tarjeta = new Tarjeta(montoPagado, fechaPago, tipo, numTransaccion);

        pagoCompra.add(tarjeta);
        precioPorPagar -= montoPagado;
        if (precioPorPagar == 0)
            estado = "Pago realizado.";
        return tarjeta;
    }

    /**
     *Genera un documento tributario de tipo boleta.
     * Revisa si es que ya hay un documento tributario generado, si es que lo hay retorna una excepcion
     * @return documento tributario de tipo boleta con informacion de la orden de compra
     */
    public DocTributario generarBoleta(){
        if (docTributario == null) {
            this.docTributario = new Boleta(Integer.toString(numdoc), cliente.getRut(), fecha, cliente.getDireccion(), this);
            numdoc++;
        }
        else
            throw new IllegalArgumentException("Ya existe un documento tributario.");
        return this.docTributario;

    }

    /**
     *Genera un documento tributario de tipo factura.
     * Revisa si es que ya hay un documento tributario generado, si es que lo hay retorna una excepcion
     * @return documento tributario de tipo factura con informacion de la orden de compra
     */
    public DocTributario generarFactura(){
        if(docTributario == null) {
            this.docTributario = new Factura(Integer.toString(numdoc), cliente.getRut(), fecha, cliente.getDireccion(), this);
            numdoc++;
        }
        else
            throw new IllegalArgumentException("Ya existe un documento tributario.");
        return this.docTributario;
    }

    /**
     *
     * @return informacion de la orden de compra
     */
    @Override
    public String toString() {
        String descripcion_OrdenCompra = new String();
        descripcion_OrdenCompra += "Fecha: " + fecha;
        descripcion_OrdenCompra += "\nEstado:" + estado;
        descripcion_OrdenCompra += "\nCliente: " + cliente;
        descripcion_OrdenCompra += "\nPrecio por pagar: " + precioPorPagar;
        descripcion_OrdenCompra += "\nPrecio total: " + calcPrecio();

        return descripcion_OrdenCompra;
    }
}
