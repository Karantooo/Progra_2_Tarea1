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

        //Creacion compradores
        Direccion direccion1 = new Direccion("Av Argentina 2134");
        Cliente comprador1 = new Cliente("Victor","20.589.231-2",direccion1);
        Direccion direccion2 = new Direccion("Falso 123");
        Cliente comprador2 = new Cliente("Jhonatan","18.451.312-K",direccion2);
    }
}