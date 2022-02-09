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
        ingresarDatos(cantidadDatos, arreglo);

    }

    /**
     * Metodo para Ingresar los datos de el arreglo
     *
     * @param cantidadDatos
     * @param arreglo
     */
    public static void ingresarDatos(int cantidadDatos, int[] arreglo) {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();
        for (int i = 0; i < cantidadDatos; i++) {
            arreglo[i] = random.nextInt((cantidadDatos * 10) - 1) + 1;
        }
        Arrays.sort(arreglo); // Organiza los numeros de forma ascendente
        for (int i = 0; i < cantidadDatos; i++) {
            if (i == cantidadDatos - 1) {
                System.out.print(arreglo[i]);
            } else {
                System.out.print(arreglo[i] + ", ");
            }
        }
        System.out.println("");
        System.out.println("Ingresa el numero para buscar:");
        int numeroBusqueda = entrada.nextInt();
        int pasos = 0;
        int cantidad = realizarBusquedaBinaria(arreglo, numeroBusqueda, pasos);
        System.out.println("Pasos: " + cantidad);
    }
    /**
     * Realiza la busqueda binaria. Utiliza recursividad para encontrar el dato, y cada 
     * vez que el metodo sea llamado, significa que aumento un paso.
     * @param arreglo El arreglo donde se encuentran los datos
     * @param numeroBusqueda El numero que se buscará
     * @param cantidadPasos La cantidad de pasos
     * @return La cantidad de pasos
     */
    public static int realizarBusquedaBinaria(int[] arreglo, int numeroBusqueda, int cantidadPasos) {
        cantidadPasos++;
        int tamañoArreglo = arreglo.length;
        int mitad = tamañoArreglo / 2;
        if (tamañoArreglo == 1) {
            System.out.println("El dato no esta");
            return cantidadPasos;
        } else {
            if (arreglo[mitad] == numeroBusqueda) {
                System.out.println("Busqueda Correcta");
                return cantidadPasos;
            } else {
                if (arreglo[mitad] >= numeroBusqueda) {
                    return realizarBusquedaBinaria(Arrays.copyOfRange(arreglo, 0, mitad), numeroBusqueda, cantidadPasos);
                } else {
                    return realizarBusquedaBinaria(Arrays.copyOfRange(arreglo, mitad + 1, tamañoArreglo), numeroBusqueda, cantidadPasos);
                }
            }

        }
    }

}
