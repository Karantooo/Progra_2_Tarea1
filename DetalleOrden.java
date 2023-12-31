package org.example;

/**
 *Clase con el objetivo de generar el detalle de la orden de solo un articulo en especifico
 *
 * @author Benjamin Alonso Espinoza Henriquez
 */
public class DetalleOrden {
    private int cantidad;
    private Articulo articulo;
    private OrdenCompra ordenCompra;

    /**
     * Constructor de la clase
     * @param cantidad cantidad del articulo
     * @param articulo cual es el articulo
     */
    public DetalleOrden(int cantidad, Articulo articulo, OrdenCompra ordenCompra) {
        this.cantidad = cantidad;
        this.articulo = articulo;
        this.ordenCompra = ordenCompra;
        articulo.addOrdenes(this);
        ordenCompra.addDetalleOrden(this);
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

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    /**
     *
     * @return Precio total (Incluye IVA)
     */
    public float calcPrecio(){
        return (float) (getCantidad() * articulo.getPrecio() * 1.19);

    }

    /**
     *
     * @return Precio sin el IVA
     */
    public float calcPrecioSinIVA(){
        return  getCantidad() * articulo.getPrecio();
    }

    /**
     *
     * @return solo el IVA
     */
    public float calcIVA(){
        return (float) (getCantidad() * articulo.getPrecio() * 0.19);
    }

    /**
     *
     * @return Peso total de los articulos
     */
    public float calcPeso(){
        return getCantidad() * articulo.getPeso();
    }

    /**
     *
     * @return informacion de la cantidad y precio del articulo
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

