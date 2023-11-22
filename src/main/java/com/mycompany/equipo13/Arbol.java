/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo13;

/**
 *
 * @author Emmanuel V
 */
public class Arbol {
    private Sucursal raiz;

    public Sucursal getRaiz(){
        return raiz;
    }

    public void setRaiz(Sucursal raiz){
        this.raiz = raiz;
    }
    
    public boolean empty(){
        if(getRaiz() == null)
            return true;
        return false;
    }
    
    public void insert(Sucursal nodo){
        if(empty())
            setRaiz(nodo);
        else{
            Sucursal aux = getRaiz();
            do{
                if(nodo.getNivel() < aux.getNivel()){
                    if(aux.getHizq() == null)
                        aux.setHizq(nodo);
                    else
                        aux = aux.getHizq();
                }else{
                    if(aux.getHder() == null)
                        aux.setHder(nodo);
                    else
                        aux = aux.getHder();
                }
            }while(aux.getHder() != nodo && aux.getHizq()!= nodo);
        }
    }
     public Sucursal busqueda(String nombre,Sucursal nodo,Sucursal dev){
        if (nodo!=null) {
            if (nodo.getNombre().equals(nombre)) {
                dev=nodo;
            }
            dev=busqueda(nombre,nodo.getHizq(),dev);
            dev=busqueda(nombre,nodo.getHder(),dev);
            
        }
        return dev;
    }
    
}
