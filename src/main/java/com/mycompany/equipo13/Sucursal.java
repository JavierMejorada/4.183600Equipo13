/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo13;

import listaD.Lista_doble;

/**
 *
 * @author Emmanuel V
 */
public class Sucursal {
    private String nombre;
    private int nivel;
    private char zona;
    private Lista_doble pedidos;
    private double ventas;
    private Sucursal hizq, hder;
    
    public Sucursal(String nombre, char zona){
        this.nombre = nombre;
        this.zona = zona;
        this.nivel = -1;
        this.pedidos = new Lista_doble();
        this.ventas = 0;
        this.hizq = this.hder = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public char getZona() {
        return zona;
    }

    public void setZona(char zona) {
        this.zona = zona;
    }

    public Lista_doble getPedidos() {
        return pedidos;
    }

    public void setPedidos(Lista_doble pedidos) {
        this.pedidos = pedidos;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    public Sucursal getHizq() {
        return hizq;
    }

    public void setHizq(Sucursal hizq) {
        this.hizq = hizq;
    }

    public Sucursal getHder() {
        return hder;
    }

    public void setHder(Sucursal hder) {
        this.hder = hder;
    }
    
    
}
