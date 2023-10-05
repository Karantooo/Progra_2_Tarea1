package org.example;
import org.DetalleOrden;

import java.util.Date;
import java.util.ArrayList;

public class OrdenCompra {
    private Date fecha;
    private String estado;
    private ArrayList <DetalleOrden> detalleOrdenes;
    private int size;

    public OrdenCompra(Date fecha, String estado, ArrayList<DetalleOrden> detalleOrdenes) {
        this.fecha = fecha;
        this.estado = estado;
        this.detalleOrdenes = detalleOrdenes;
        size = this.detalleOrdenes.size();
    }

    public OrdenCompra(Date fecha, String estado) {
        this.fecha = fecha;
        this.estado = estado;
        size = 0;
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

    public ArrayList<DetalleOrden> getOrdenesDeCompra() {
        return detalleOrdenes;
    }

    public ArrayList<DetalleOrden> getDetalleOrdenes() {
        return detalleOrdenes;
    }

    public void setDetalleOrdenes(ArrayList<DetalleOrden> detalleOrdenes) {
        this.detalleOrdenes = detalleOrdenes;
    }
}
