package org;

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
        return getCantidad() * articulo.getPrecio * 1.19;
    }
    public float calcPrecioSinIVA(){
        return  getCantidad() * articulo.getPrecio;
    }
    public float calcIVA(){
        return getCantidad() * articulo.getPrecio * 0.19;
    }
    public float calcPeso(){
        return getCantidad() * articulo.getPeso;
    }

    /**
     *
     * @return informacion del precio del articulo
     */
    @Override
    public String toString() {
        return "La cantidad de articulos son: " + getCantidad() + "\nPrecio sin IVA: " + calcPrecioSinIVA() +
                "\nIVA: " + calcIVA() + "\nPrecio final: " + calcPrecio() + "\nPeso total: " + calcPeso();
    }
}

