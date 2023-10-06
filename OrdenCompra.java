package org.example;

import java.util.Date;
import java.util.ArrayList;

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


    public void addDetalleOrden(DetalleOrden orden){
        size++;
        precioPorPagar += orden.calcPrecio();
        detalleOrdenes.add(orden);
    }

    public void addDetalleOrden(DetalleOrden orden, int index){
        size++;
        precioPorPagar += orden.calcPrecio();
        detalleOrdenes.add(index, orden);
    }

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

    public float calcPrecioSinIVA(){
        float precioSinIVA = 0;

        for (int i = 0; i < size; i++){
            precioSinIVA += detalleOrdenes.get(i).calcPrecioSinIVA();
        }
        return precioSinIVA;
    }

    public float calcIVA(){
        float IVA = 0;
        for (int i = 0; i < size; i++){
            IVA += detalleOrdenes.get(i).calcIVA();
        }
        return IVA;
    }

    public float calcPrecio(){
        float precioConIVA = 0;
        for (int i = 0; i < size; i++){
            precioConIVA += detalleOrdenes.get(i).calcPrecio();
        }
        return precioConIVA;
    }

    public float calcPeso(){
        float peso = 0;
        for (int i = 0; i < size; i++){
            peso += detalleOrdenes.get(i).calcPeso();
        }
        return peso;
    }

    /**
     *Se detalla lo que se quiere pagar asi como el pago en efectivo que realiza para devolver el vuelto.
     * En caso de que se quiera pagar más de lo que falta por pgar o el monto pagado es inferior a obtetivo a pagar
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
    public DocTributario generarBoleta(){
        if (docTributario == null) {
            this.docTributario = new Boleta(Integer.toString(numdoc), cliente.getRut(), fecha, cliente.getDireccion(), this);
            numdoc++;
        }
        else
            throw new IllegalArgumentException("Ya existe un documento tributario.");
        return this.docTributario;

    }
    public DocTributario generarFactura(){
        if(docTributario == null) {
            this.docTributario = new Factura(Integer.toString(numdoc), cliente.getRut(), fecha, cliente.getDireccion(), this);
            numdoc++;
        }
        else
            throw new IllegalArgumentException("Ya existe un documento tributario.");
        return this.docTributario;
    }

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
