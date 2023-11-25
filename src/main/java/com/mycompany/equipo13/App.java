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
 * Mejorada Soto Jose Javier 
 * Vallejo Ramirez Emmanuel
 */
public class App {

    public static void main(String[] args) {
        System.out.println("PROYECTO TEMA NO.4");
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        int op, op2;
        Arbol arbol = new Arbol();
        try {
            do {
                op = menuPrincipal();
                switch (op) {
                    case 1:
                        insertarEmpresa(arbol);
                        break;
                    case 2:
                        if (!arbol.empty()) {
                            System.out.println("Ingreso a eliminar una sucursal:");
                            System.out.println("(Considere que eliminara solo las que no tienen pedidos)");
                            System.out.println("--------------------------------------------");
                            System.out.println("Ingrese el nombre de la empresa a eliminar:");
                            String nombre = leer.readLine();
                            Sucursal pp = arbol.busqueda(nombre, arbol.getRaiz(), null);
                            if (pp != null) {
                                System.out.println("Sucursal '" + pp.getNombre() + "' encontrada");
                                if (pp.getPedidos().empty()) {
                                    arbol.remove(nombre);
                                    System.out.println("La sucursal '" + pp.getNombre() + "' ha sido eliminada");
                                } else {
                                    System.out.println("Esta empresa tiene pedidos, por lo tanto no se puede eliminar");
                                }
                            } else {
                                System.out.println("Esa empresa no se encuentra\n");
                            }
                        } else {
                            System.out.println("No hay sucursales agregadas\n");
                        }
                        break;
                    case 3:
                        if (arbol.empty()) {
                            System.out.println("No hay sucursales agregadas\n");
                        } else {
                            System.out.println("\nLISTA DE SUCURSALES (ORDEN ALFABETICO)");
                            arbol.desplegarAlf(arbol.getRaiz());
                        }
                        break;
                    case 4:
                        if (arbol.empty()) {
                            System.out.println("No hay sucursales agregadas\n");
                        } else {
                            System.out.println("Ingrese el nombre de la sucursal para acceder a sus pedidos");
                            String buscar = leer.readLine().toUpperCase();
                            Sucursal aux = arbol.busquedaNombre(arbol.getRaiz(), null, buscar);
                            if (aux == null) {
                                System.out.println("No se encontro la sucursal\n");
                            } else {
                                System.out.println("Coincidencia de nombre encontrada");
                                do {
                                    System.out.println("-------------- MENU SUCURSAL '" + aux.getNombre() + "' --------------");
                                    op2 = menuPedidos();
                                    switch (op2) {
                                        case 1:
                                            insertarPedido(aux.getPedidos(), aux);
                                            break;
                                        case 2:
                                            if (aux.getPedidos().empty()) {
                                                System.out.println("No hay pedidos en la lista\n");
                                            } else {
                                                System.out.println("Ingresa el numero de pedido que desea eliminar");
                                                Short num = Short.parseShort(leer.readLine());
                                                NODO_DOBLE elim = aux.getPedidos().eliminar(num);

                                                if (elim == null) {
                                                    System.out.println("No se encontro el pedido\n");
                                                } else {
                                                    System.out.println("El pedido numero " + elim.getPedido().getNum_pedido() + " ha sido eliminado");
                                                    aux.setVentas(aux.getVentas() - elim.getPedido().getImporte());
                                                }
                                            }
                                            break;
                                        case 3:
                                            if (!aux.getPedidos().empty()) {
                                                System.out.println("LISTA DE PEDIDOS:");
                                                System.out.println("Nombre de la sucursal: " + aux.getNombre());
                                                aux.getPedidos().desplegar(aux.getPedidos());
                                            } else {
                                                System.out.println("No hay pedidos en la lista");
                                            }
                                            break;
                                        case 4:
                                            if (!aux.getPedidos().empty()) {
                                                System.out.println("Consultar un pedido con cambio de datos:");
                                                System.out.println("A continuacion se muestran todos los pedidos:");
                                                System.out.println("-------------------------------------");
                                                aux.getPedidos().desplegar(aux.getPedidos());
                                                System.out.println("-------------------------------------");
                                                System.out.println("Ingrese el numero del pedido que desea modificar:");
                                                Short num = Short.parseShort(leer.readLine());
                                                NODO_DOBLE elim = aux.getPedidos().busquedaPedido(num);
                                                double borrar = elim.getPedido().getImporte();
                                                double sumar = aux.getPedidos().modificar(num, aux.getPedidos());
                                                aux.setVentas(aux.getVentas() - borrar);
                                                aux.setVentas(aux.getVentas() + sumar);
                                            } else {
                                                System.out.println("No hay pedidos en la lista\n");
                                            }
                                            break;
                                        case 0:
                                            System.out.println("Regresando al menu...\n");
                                            break;
                                        default:
                                            System.out.println("Ingrese una opcion valida\n");
                                            break;
                                    }
                                } while (op2 != 0);
                            }
                        }
                        break;
                    case 5:
                        if (!arbol.empty()) {
                            arbol.desplegarA(arbol.getRaiz());
                        } else {
                            System.out.println("No hay sucursales agregadas\n");
                        }
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
            System.out.println("\nIngrese una opcion:");
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
            System.out.println("1. Agregar un pedido");
            System.out.println("2. Eliminar algun pedido en especifico");
            System.out.println("3. Desplegar el listado de tus pedidos");
            System.out.println("4. Consultar un pedido con opcion a cambio de datos");
            System.out.println("0. REGRESAR AL MENU PRINCIPAL");
            System.out.println("\nElije una de nuestras opciones");
            op = Integer.parseInt(leer.readLine());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return op;
    }

    public static void insertarEmpresa(Arbol arbol) {
        try {
            BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese el nombre de la sucursal que desea agregar: ");
            String nombre = leer.readLine().toUpperCase();
            Sucursal pp = arbol.busqueda(nombre, arbol.getRaiz(), null);
            if (pp != null) {
                System.out.println("El nombre de la empresa ya se encuentra");
            } else {
                System.out.println("Ingrese la zona geografica:");
                char zona = ' ';
                boolean flag = false;
                do {
                    System.out.println("1. Norte");
                    System.out.println("2. Sur");
                    System.out.println("3. Este");
                    System.out.println("4. Oeste");
                    System.out.println("Ingrese una opcion:");
                    int opZ = Integer.parseInt(leer.readLine());
                    switch (opZ) {
                        case 1:
                            zona = 'N';
                            flag = true;
                            break;
                        case 2:
                            zona = 'S';
                            flag = true;
                            break;
                        case 3:
                            zona = 'E';
                            flag = true;
                            break;
                        case 4:
                            zona = 'O';
                            flag = true;
                            break;
                        default:
                            System.out.println("Ingrese una opcion valida");
                            break;
                    }
                } while (!flag);
                Sucursal suc = new Sucursal(nombre, zona);
                arbol.insert(suc);
                System.out.println("Sucursal '" + suc.getNombre() + "' insertada con exito");
                System.out.println("Zona geografica: " + suc.getZona());
                System.out.println("Nivel: " + suc.getNivel() + "\n");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void insertarPedido(Lista_doble Lista, Sucursal a) {
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
                a.setVentas(a.getVentas() + importe);
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
