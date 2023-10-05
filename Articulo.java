package org.example;

import java.util.ArrayList;

/**
 * Clase con informacion sobre el articulo
 *
 * @author Carlos Tomás Álvarez Norambuena
 * @author Benjamin Alonso Espinoza Henriquez
 */
public class Articulo {
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    private ArrayList<DetalleOrden> ordenes;

    /**
     * Constructor de la clase
     *
     * @param peso peso del articulo
     * @param nombre nombre del articulo
     * @param descripcion descripcion del articulo
     * @param precio precio del articulo
     */
    public Articulo(float peso, String nombre, String descripcion, float precio) {
        this.peso = peso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.ordenes = new ArrayList<DetalleOrden>();
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public ArrayList<DetalleOrden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(ArrayList<DetalleOrden> ordenes) {
        this.ordenes = ordenes;
    }

    public void addOrdenes(DetalleOrden orden){
        ordenes.add(orden);
    }

    /**
     *
     * @return informacion del articulo
     */
    @Override
    public String toString(){
        String descripcion_articulo = new String();
        descripcion_articulo += "Nombre: " + nombre;
        descripcion_articulo += "\nPeso: " + peso;
        descripcion_articulo += "\nDescripcion: " + descripcion;
        descripcion_articulo += "\nPrecio: " + precio;
        
        return descripcion_articulo;
    }
}
