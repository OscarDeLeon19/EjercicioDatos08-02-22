package main;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrega la cantidad de datos:");
        int cantidadDatos = entrada.nextInt();
        int[] arreglo = new int[cantidadDatos];
        ordenarDatos(cantidadDatos, arreglo);

    }

    public static void ordenarDatos(int cantidadDatos, int[] arreglo) {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();
        for (int i = 0; i < cantidadDatos; i++) {
            arreglo[i] = random.nextInt((cantidadDatos * 10) - 1) + 1;
        }
        Arrays.sort(arreglo);
        for (int i = 0; i < cantidadDatos; i++) {
            System.out.print(arreglo[i] + ", ");
        }
        System.out.println("");
        System.out.println("Ingresa el numero para buscar:");
        int numeroBusqueda = entrada.nextInt();
        int pasos = 0;
        int cantidad = busquedaBinaria(arreglo, numeroBusqueda, pasos);
        System.out.println("Pasos: " + cantidad);
    }

    public static int busquedaBinaria(int[] arreglo, int numeroBusqueda, int pasos) {
        pasos++;
        int tamaño = arreglo.length;
        int mitad = tamaño / 2;
        if (tamaño == 1) {
            System.out.println("El dato no esta");
            return pasos;
        } else {
            if (arreglo[mitad] == numeroBusqueda) {
                System.out.println("Busqueda Correcta");
                return pasos;
            } else {
                if (arreglo[mitad] >= numeroBusqueda) {
                    return busquedaBinaria(Arrays.copyOfRange(arreglo, 0, mitad), numeroBusqueda, pasos);
                } else {
                    return busquedaBinaria(Arrays.copyOfRange(arreglo, mitad + 1, tamaño), numeroBusqueda, pasos);
                }
            }

        }
    }

}
