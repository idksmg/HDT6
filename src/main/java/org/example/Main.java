package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> listaDeCadenas = new ArrayList<>();
        int opcion = 0;
        System.out.println("Ingrese la ruta del archivo ej: C:\\ejemplos\\datos.txt");
        String fpath = in.nextLine();
        if (fpath == "") {
            fpath = "C:\\codigo\\SEMESTRE 3\\Calculator\\datos.txt";
        }
        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                listaDeCadenas.add(data);
                System.out.println(data);
            }
            myReader.close();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Escriba el tipo de mapa a utilizar:\n1.HashMap\n2.TreeMap\n3.LinkedHashMap\n");
        String tipo = in.nextLine();
        Productos productos = new Productos(tipo);
        while(opcion !=7) {
        System.out.println("Seleccione lo que desea realizar:\n1. Agregar producto\n2.Mostrar categoria del producto\n3.Mostrar datos del producto\n4.Mostrar datos del producto por tipo\n5.Mostrar inventario\n6.Mostrar inventario por tipo");
            opcion = Integer.parseInt(in.nextLine());
            if (opcion == 1) {
                System.out.println("Ingrese la categoria del producto: ");
                String categoria = in.nextLine();
                System.out.println("Ingrese el producto: ");
                String producto = in.nextLine();
                productos.agregarProducto(categoria, producto);
            }
            if (opcion == 2) {
                System.out.println("Ingrese el producto: ");
                String producto = in.nextLine();
                productos.mostrarCategoria(producto);
            }
            if (opcion == 3) {
                productos.mostrarDatos();
            }
            if (opcion == 4) {
                productos.mostrarDatosOrdenados();
            }
            if (opcion == 5) {
                productos.mostrarInventario();
            }
            if (opcion == 6) {
                productos.mostrarCategoriasOrdenadas();
            }
            if(opcion>6){
                System.out.println("Gracias por usar este programa");
                break;
            }
        }
    }
}