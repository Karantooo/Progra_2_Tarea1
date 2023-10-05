package org.example;

/**
 *
 * @author Benjamin Alonso Espinoza Henriquez
 */
public class DetalleOrden {
    private int cantidad;
    private Articulo articulo;

    /**
     * Constructor de la clase
     * @param cantidad
     * @param articulo
     */
    public DetalleOrden(int cantidad, Articulo articulo) {
        this.cantidad = cantidad;
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    public float calcPrecio(){
        return (float) (getCantidad() * articulo.getPrecio() * 1.19);
    }
    public float calcPrecioSinIVA(){
        return  getCantidad() * articulo.getPrecio();
    }
    public float calcIVA(){
        return (float) (getCantidad() * articulo.getPrecio() * 0.19);
    }
    public float calcPeso(){
        return getCantidad() * articulo.getPeso();
    }

    /**
     *
     * @return informacion del precio del articulo
     */
    @Override
    public String toString() {
        String descripcion_detalleorden = new String();
        descripcion_detalleorden += "Cantidad: " + getCantidad();
        descripcion_detalleorden += "\nPrecio sin IVA: " + calcPrecioSinIVA();
        descripcion_detalleorden += "\nIVA: " + calcIVA();
        descripcion_detalleorden += "\nPrecio total: " + calcPrecio();
        descripcion_detalleorden += "\nPeso: " + calcPeso();

        return descripcion_detalleorden;
    }
}

