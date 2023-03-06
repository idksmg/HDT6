package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Productos<T> {
    private Map<String, T> coleccion;
    private ArrayList<String> categorias;

    public Productos(String tipoMapa) {
        if (tipoMapa.equals("HashMap")) {
            coleccion = new HashMap<>();
        } else if (tipoMapa.equals("TreeMap")) {
            coleccion = new TreeMap<>();
        } else if (tipoMapa.equals("LinkedHashmap")) {
            coleccion = new LinkedHashMap<>();
        } else {
            throw new IllegalArgumentException("Tipo de mapa no válido");
        }
        categorias = new ArrayList<>();
        categorias.add("Mueble de terraza");
        categorias.add("Sillones de masaje");
        categorias.add("Bebidas");
        categorias.add("Condimentos");
        categorias.add("Frutas");
        categorias.add("Carnes");
        categorias.add("Lácteos");
    }

    public void agregarProducto(String categoria, T producto) {
        if (!categorias.contains(categoria)) {
            System.out.println("Categoría no válida");
            return;
        }
        if (coleccion.containsKey(categoria)) {
            coleccion.put(categoria, producto);
        } else {
            coleccion.put(categoria, producto);
        }
    }

    public void mostrarCategoria(String producto) {
        for (String categoria : coleccion.keySet()) {
            if (coleccion.get(categoria).toString().contains(producto)) {
                System.out.println(categoria);
                return;
            }
        }
        System.out.println("Producto no encontrado");
    }

    public void mostrarDatos() {
        for (String categoria : coleccion.keySet()) {
            System.out.println(categoria + ": " + coleccion.get(categoria).toString());
        }
    }

    public void mostrarDatosOrdenados() {
        Map<String, T> coleccionOrdenada;
        if (coleccion instanceof HashMap) {
            coleccionOrdenada = new TreeMap<>(coleccion);
        } else if (coleccion instanceof TreeMap) {
            coleccionOrdenada = new TreeMap<>(coleccion);
        } else {
            coleccionOrdenada = new LinkedHashMap<>(coleccion);
        }
        for (String categoria : coleccionOrdenada.keySet()) {
            System.out.println(categoria + ": " + coleccionOrdenada.get(categoria).toString());
        }
    }

    public void mostrarInventario() {
        for (String categoria : coleccion.keySet()) {
            System.out.println(coleccion.get(categoria).toString() + " - " + categoria);
        }
    }

    public void mostrarCategoriasOrdenadas() {
        ArrayList<String> categoriasOrdenadas = new ArrayList<>(categorias);
        categoriasOrdenadas.sort(null);
        for (String categoria : categoriasOrdenadas) {
            if (coleccion.containsKey(categoria)) {
                System.out.println(categoria + ": " + coleccion.get(categoria).toString());
            } else {
                System.out.println(categoria + ": 0");
            }
        }
    }
}

