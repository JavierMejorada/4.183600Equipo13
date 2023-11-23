/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo13;

import listaD.Lista_cola;
import listaD.Lista_doble;
import listaD.NODO_DOBLE;


/**
 *
 * @author Emmanuel V
 */
public class Arbol {

    private Sucursal raiz;
   

    public Sucursal getRaiz() {
        return raiz;
    }

    public void setRaiz(Sucursal raiz) {
        this.raiz = raiz;
    }

  
    

    public boolean empty() {
        if (getRaiz() == null) {
            return true;
        }
        return false;
    }

    public void insert(Sucursal nodo) {
        int conta = 0;
        if (empty()) {
            setRaiz(nodo);
        } else {
            Sucursal aux = getRaiz();
            do {
                if (nodo.getNombre().compareTo(aux.getNombre()) < 0) {
                    if (aux.getHizq() == null) {
                        aux.setHizq(nodo);
                    } else {
                        aux = aux.getHizq();
                    }
                } else {
                    if (aux.getHder() == null) {
                        aux.setHder(nodo);
                    } else {
                        aux = aux.getHder();
                    }
                }
                conta++;
            } while (aux.getHder() != nodo && aux.getHizq() != nodo);
        }
        nodo.setNivel(conta);
       
    }

    public Sucursal busqueda(String nombre, Sucursal nodo, Sucursal dev) {
        if (nodo != null) {
            if (nodo.getNombre().equals(nombre)) {
                dev = nodo;
            }
            dev = busqueda(nombre, nodo.getHizq(), dev);
            dev = busqueda(nombre, nodo.getHder(), dev);
        }
        return dev;
    }

    public Sucursal remove(String Nombre) {
        Sucursal aux = getRaiz();
        Sucursal aux2 = null;
        while (aux != null && (Nombre.equals(aux.getNombre()) == false)) {
            aux2 = aux;
            if (Nombre.compareTo(aux.getNombre()) < 0) {
                aux = aux.getHizq();
            } else {
                aux = aux.getHder();
            }

        }
        if (aux == null) {
            return null;
        } else {
            //Caso hoja
            if (aux.getHizq() == null && aux.getHder() == null) {
                return eliminar_hoja(aux, aux2);
            }
            // caso de un solo hijo
            if (aux.getHizq() == null || aux.getHder() == null) {
                return eliminar_hijo(aux, aux2);
            }
            //Caso de dos hijos
            if (aux.getHder().getHizq() == null) {
                aux.getHder().setHizq(aux.getHizq());
                if (aux2.getHizq() == aux) {
                    aux2.setHizq(aux.getHder());
                } else {
                    aux2.setHder(aux.getHder());
                }
            } else {
                Sucursal tem = aux.getHder().getHizq();
                Sucursal tem2 = aux.getHder();
                while (tem.getHizq() != null) {
                    tem2 = tem2.getHizq();
                    tem = tem.getHizq();
                }
                tem2.setHizq(tem.getHder());
                aux2.setHder(tem);
                tem.setHizq(aux.getHizq());
                tem.setHder(aux.getHder());

            }
        }

        return aux;
    }

    public Sucursal eliminar_hoja(Sucursal hijo, Sucursal padre) {
        if (padre.getHizq() == hijo) {
            padre.setHizq(null);
        } else {
            padre.setHder(null);
        }
        return hijo;

    }

    public Sucursal eliminar_hijo(Sucursal hijo, Sucursal padre) {
        if (padre.getHizq() == hijo) {
            if (hijo.getHder() == null) {
                padre.setHizq(hijo.getHizq());
            } else {
                padre.setHizq(hijo.getHder());
            }
        } else {
            if (hijo.getHizq() == null) {
                padre.setHder(hijo.getHder());
            } else {
                padre.setHder(hijo.getHizq());
            }
        }
        return hijo;
    }

    public void preorden(Sucursal nodo) {
        if (nodo != null) {
            System.out.println("---------------------");
            System.out.println(nodo.getNombre());
            System.out.println(nodo.getZona());
            System.out.println(nodo.getVentas());
            System.out.println("---------------------");
            preorden(nodo.getHizq());
            preorden(nodo.getHder());
        }
    }

    public void desplegarAlf(Sucursal nodo) {
        if (nodo != null) {
            desplegarAlf(nodo.getHizq());
            System.out.println("- Nombre: " + nodo.getNombre());
            System.out.println("- Zona: " + nodo.getZona());
            System.out.println("- Ventas mensuales: " + nodo.getVentas());
            System.out.println("");
            desplegarAlf(nodo.getHder());
        }
    }
    public Sucursal busquedaNombre(Sucursal nodo, Sucursal aux, String nombre){
        if(nodo != null){
            if(nodo.getNombre().equals(nombre))
                aux = nodo;
            aux = busquedaNombre(nodo.getHizq(), aux, nombre);
            aux = busquedaNombre(nodo.getHder(), aux, nombre);
        }
        return aux;
    }
    public void DesplegarANCH(Sucursal PO){
        Lista_doble pp=new Lista_doble();
        Lista_cola aux=new Lista_cola();
        
        
        pp.insert(aux);
        while(!pp.empty()){
            
        }
    }
   
}
