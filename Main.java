package org.example;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        //Creacion de los articulos que van a estar en la orden
        Articulo pan = new Articulo(250, "pan", "Pan hallula.", 300);
        Articulo dulces = new Articulo(100, "dulces", "Bolsa de dulces de distintos sabores.", 500);
        Articulo escoba = new Articulo(600, "escoba", "Escoba de madera.", 4000);
        Articulo comidaPerro = new Articulo(1000, "Comida de Perro", "Comida para perros sabor.", 5000);
        Articulo bebida = new Articulo(500, "Bebida", "Bebidas sabor cola", 700);

        System.out.println(escoba.toString() + "\n\n");

        //Creacion compradores
        Direccion direccion1 = new Direccion("Av Argentina 2134");
        Cliente comprador1 = new Cliente("Victor","20.589.231-2",direccion1);
        Direccion direccion2 = new Direccion("Falso 123");
        Cliente comprador2 = new Cliente("Jhonatan","18.451.312-K",direccion2);

        Date fechaEmision = new Date(); //fecha de emision de la orden

        OrdenCompra orden1 = new OrdenCompra(fechaEmision, comprador1);
        OrdenCompra orden2 = new OrdenCompra(fechaEmision, comprador2);
        OrdenCompra orden3 = new OrdenCompra(fechaEmision, comprador1);

        //detalle orden1
        DetalleOrden primerDetalleOrden1 = new DetalleOrden(5, pan, orden1);
        DetalleOrden segundoDetalleOrden1 = new DetalleOrden(1, escoba, orden1);
        DetalleOrden terceroDetalleOrden1 = new DetalleOrden(3, dulces, orden1);

        //detalle orden2
        DetalleOrden primerDetalleOrden2 = new DetalleOrden(2, comidaPerro, orden2);
        DetalleOrden segundoDetalleOrden2 = new DetalleOrden(1, bebida, orden2);

        //detalle orden3
        DetalleOrden primerDetalleOrden3 = new DetalleOrden(2, comidaPerro, orden3);
        DetalleOrden segundoDetalleOrden3 = new DetalleOrden(7, pan, orden3);


        System.out.println(orden1.toString() + "\n\n");


        Pago pago1 = orden1.pagarEnTarjeta(900, fechaEmision, "Debito", "78351");
        Pago pago2 = orden1.pagarEnEfectivo(400, 200, fechaEmision);
        Pago pago3 = orden1.pagarEnTransferencia(500,fechaEmision,"Bice", "42342351-0");

        System.out.println(pago2.toString() + "\n\n");

        Pago pagoOrden2 = orden2.pagarEnTransferencia(orden2.calcPrecio(),fechaEmision,"Bice", "42342351-0");

        Pago pagoOrden3Exceso = orden3.pagarEnTransferencia(100000,fechaEmision ,"Banco estado", "564654654");

        System.out.println("Monto primer pago orden 1 : " + pago1.getMonto() + "\n\n");

        DocTributario boleta = orden1.generarBoleta();
        System.out.println(boleta.toString());

    }
}