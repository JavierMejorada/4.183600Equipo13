/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.equipo13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import listaD.Lista_doble;
import listaD.NODO_DOBLE;
import listaD.PEDIDO;

/**
 *
 * Mejorada Soto Jose Javier
 * Vallejo Ramirez Emmanuel
 */
public class App {

    public static void main(String[] args) {
        System.out.println("PROYECTO TEMA NO.4");
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        int op, op2;
        try {
            do {
                op = menuPrincipal();
                switch (op) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        Lista_doble Lista = new Lista_doble();
                        do {
                            op2 = menuPedidos();
                            switch (op2) {
                                case 1:
                                    insertarPedido(Lista);
                                    break;
                                case 2:
                                    if (Lista.empty()) {
                                        System.out.println("No hay pedidos en la lista");
                                    } else {
                                        System.out.println("Ingresa el numero de pedido que desea eliminar");
                                        Short num = Short.parseShort(leer.readLine());
                                        NODO_DOBLE aux = Lista.eliminar(num);
                                        if (aux == null) {
                                            System.out.println("No se encontro el pedido");
                                        } else {
                                            System.out.println("El pedido numero " + aux.getPedido().getNum_pedido() + " ha sido eliminado");
                                        }
                                    }
                                    break;
                                case 3:
                                    if (!Lista.empty()) {
                                        System.out.println("DESPLEGAR");
                                        Lista.desplegar(Lista);
                                    } else {
                                        System.out.println("No hay pedidos en la lista");
                                    }

                                    break;
                                case 4:
                                    if (!Lista.empty()) {
                                        System.out.println("Consultar un pedido con cambio de datos:");
                                        System.out.println("A continuacion se muestran todos los pedidos:");
                                        System.out.println("-------------------------------------");
                                        Lista.desplegar(Lista);
                                        System.out.println("-------------------------------------");
                                        System.out.println("ingrese el numero del pedido que desea eliminar:");
                                        Short num = Short.parseShort(leer.readLine());
                                        Lista.modificar(num, Lista);
                                    } else {
                                        System.out.println("No hay pedidos en la lista");
                                    }

                                    break;
                                case 0:
                                    System.out.println("!HASTA LUEGO!");
                                    break;
                                default:
                                    System.out.println("Ingrese una opcion valida");
                                    break;
                            }
                        } while (op2 != 0);
                        break;
                    case 5:

                        break;
                    case 6:
                        System.out.println("Gracias por usar el programa");
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                        break;
                }
            } while (op != 6);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static int menuPrincipal() {
        int op = 0;
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("MENU DE OPCIONES:");
            System.out.println("1.- Agregar Sucursal");
            System.out.println("2.- Eliminar Sucursal");
            System.out.println("3.- Desplegar sucursales en orden alfabetico");
            System.out.println("4.- Menu de pedidos de una Sucursal");
            System.out.println("5.- Desplegar Sucursales por codigo de estado");
            System.out.println("6.- Salir");
            op = Integer.parseInt(leer.readLine());
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return op;
    }

    public static int menuPedidos() {
        int op = -1;
        try {
            BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("-------------- AGRICHEM S.A de C.V --------------");
            System.out.println("Empresa 100% Mexicana");
            System.out.println("¿En que podemos ayudarte el dia de hoy?");
            System.out.println("-------------------------------------------------");
            System.out.println("1. Agregar un pedido");
            System.out.println("2. Eliminar algun pedido en especifico");
            System.out.println("3. Desplegar el listado de tus pedidos");
            System.out.println("4. Consultar un pedido con opcion a cambio de datos");
            System.out.println("0. SALIR");
            System.out.println("\nElije una de nuestras opciones");
            op = Integer.parseInt(leer.readLine());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return op;
    }

    public static void insertarPedido(Lista_doble Lista) {
        try {
            BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
            short numPedido, numCliente;
            String pedido;
            double importe;
            System.out.println("------------------------------");
            System.out.println("Agregando pedido");
            System.out.println("Ingrese el número de pedido:");
            numPedido = Short.parseShort(leer.readLine());
            if (Lista.busquedaPedido(numPedido) == null) {
                System.out.println("Ingrese el importe:");
                importe = Short.parseShort(leer.readLine());
                System.out.println("Ingrese el nombre del producto");
                pedido = leer.readLine();
                System.out.println("Ingrese el numero de cliente");
                numCliente = Short.parseShort(leer.readLine());
                PEDIDO Pedido = new PEDIDO(numPedido, importe, pedido, numCliente);
                NODO_DOBLE ob = new NODO_DOBLE(Pedido);
                Lista.insert(ob);
                System.out.println("Pedido agregado con exito");
            } else {
                System.out.println("Ya hay un pedido con ese numero");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
