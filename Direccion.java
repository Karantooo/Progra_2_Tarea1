package org.example;

import java.util.ArrayList;

/**
 * Clase para generar la direccion de la tienda o del cliente
 *
 * @author Benjamin Alonso Espinoza Henriquez
 */
public class Direccion {
    private String direccion;
    private ArrayList<Cliente> clientes;
    private ArrayList<DocTributario> Doctributarios;
    /**
     * Constructor de la clase
     * @param direccion direccion dada
     */
    public Direccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<DocTributario> getDoctributarios() {
        return Doctributarios;
    }

    public void setDoctributarios(ArrayList<DocTributario> doctributarios) {
        Doctributarios = doctributarios;
    }

    /**
     * metodo para añadir clientes a la direccion
     * @param cliente cliente en la direccion
     */
    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }

    /**
     * metodo para asociar un documento tributario a la direccion
     * @param docTributario documento asociado a la direccion
     */
    public void addDetalleOrden(DocTributario docTributario){
        Doctributarios.add(docTributario);
    }

    /**
     * metodo para remover un cliente de una direccion
     * @param i index
     * @return remover al cliente de la direccion;
     */
    public Cliente removeCliente(int i){
        Cliente cliente = null;
        try{
            if (clientes.isEmpty())
                throw new IllegalArgumentException("Se intenta extraer una orden pero no hay.");
            cliente = clientes.remove(i);

        }
        finally{
            return cliente;
        }
    }

    /**
     * metodo para remover un documento de la direccion
     * @param i index
     * @return remover el documento de la direccion
     */
    public DocTributario removeDetalleOrden(int i){
        DocTributario Doctributario = null;
        try{
            if (Doctributarios.size() < i)
                throw new IllegalArgumentException("Se intenta extraer una orden fuera de indice.");
            Doctributario = Doctributarios.remove(i);
        }
        finally{
            return Doctributario;
        }
    }

    /**
     *
     * @return La direccion sea del cliente o de la tienda
     */
    @Override
    public String toString() {
        return "Direccion: " + getDireccion();
    }
}
