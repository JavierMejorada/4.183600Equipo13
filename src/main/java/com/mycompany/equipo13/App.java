/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.equipo13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * Mejorada Soto Jose Javier
 * Vallejo Ramirez Emmanuel
 */
public class App {

    public static void main(String[] args) {
        System.out.println("PROYECTO TEMA NO.4");
    }
    public static int MENU_PRINCIPAL(){
        int op=0;
        BufferedReader leer=new BufferedReader(new InputStreamReader (System.in));
        try{
         System.out.println("MENU DE OPCIONES:");
        System.out.println("1.- Agregar sucursales");
        System.out.println("2.- Eliminar Sucursales");
        System.out.println("3.- Desplegar sucursales en orden alfabetico");
        System.out.println("4.- Menu de pedidos de una sucursal");
        System.out.println("5.- Desplegar sucursales");
        System.out.println("6.- Salir del menu");
            System.out.println("EMMA TONTO");
        op=Integer.parseInt(leer.readLine());   
        }catch(Exception e){
            System.out.println("Error opcion no valida");
        }
        
        return op;
    }
}
