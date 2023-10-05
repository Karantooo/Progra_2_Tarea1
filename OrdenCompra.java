package org.example;

import java.util.Date;
import java.util.ArrayList;

public class OrdenCompra {
    private Date fecha;
    private String estado;
    private ArrayList <DetalleOrden> detalleOrdenes;
    private int size;
    private Cliente cliente;


    public OrdenCompra(Date fecha, String estado, Cliente cliente) {
        this.fecha = fecha;
        this.estado = estado;
        this.detalleOrdenes = new ArrayList<DetalleOrden>();
        size = 0;
        this.cliente = cliente;
        cliente.asociarOrdenCompra(this);
    }
    public OrdenCompra(Date fecha, String estado) {
        this.fecha = fecha;
        this.estado = estado;
        this.detalleOrdenes = new ArrayList<DetalleOrden>();
        size = 0;
        this.cliente = null;

    }


    public void addDetalleOrden(DetalleOrden orden){
        size++;
        detalleOrdenes.add(orden);
    }

    public void addDetalleOrden(DetalleOrden orden, int index){
        size++;
        detalleOrdenes.add(index, orden);
    }

    public DetalleOrden removeDetalleOrden(){
        DetalleOrden detalleOrden = null;
        try{
            if (size == 0)
                throw new IllegalArgumentException("Se intenta extraer una orden pero no hay.");
            size--;
            detalleOrden = detalleOrdenes.remove(0);

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
}
