/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lista_doble {

    private NODO_DOBLE frente, ult;

    public NODO_DOBLE getFrente() {
        return frente;
    }

    public void setFrente(NODO_DOBLE frente) {
        this.frente = frente;
    }

    public NODO_DOBLE getUlt() {
        return ult;
    }

    public void setUlt(NODO_DOBLE ult) {
        this.ult = ult;
    }

    public boolean empty() {
        if (frente == null && ult == null) {
            return true;
        }
        return false;

    }

    public void insert(NODO_DOBLE nodo) {
        if (empty()) {
            setFrente(nodo);
            setUlt(nodo);
        } else {
            if (nodo.getPedido().getNum_pedido() > getFrente().getPedido().getNum_pedido()) {
                nodo.setSig(getFrente());
                getFrente().setAnt(nodo);
                setFrente(nodo);
            } else {
                if (nodo.getPedido().getNum_pedido()<getUlt().getPedido().getNum_pedido() ) {
                    nodo.setAnt(getUlt());
                    getUlt().setSig(nodo);
                    setUlt(nodo);
                } else {
                    NODO_DOBLE aux = getFrente().getSig();
                    while (nodo.getPedido().getNum_pedido() <aux.getPedido().getNum_pedido()) {
                        aux = aux.getSig();
                    }
                    nodo.setAnt(aux.getAnt());
                    nodo.setSig(aux);
                    aux.setAnt(nodo);
                    nodo.getAnt().setSig(nodo);
                }
            }
        }
    }

    public void desplegar(Lista_doble Lista) {
        NODO_DOBLE aux = getUlt();
        System.out.println("-------------- LISTADO DE PEDIDOS -------------");
        while (aux != null) {
            
            System.out.println("Importe: " + aux.getPedido().getImporte());
            System.out.println("Producto: " + aux.getPedido().getProducto());
            System.out.println("Numero de cliente: " + aux.getPedido().getNum_cliente());
            System.out.println("");
            aux = aux.getAnt();
        }
    }

    public NODO_DOBLE busqueda(String Busca) {
        NODO_DOBLE aux = getFrente();

        while (aux != null && !Busca.equals(aux.getPedido().getProducto())) {
            aux = aux.getSig();

        }
        return aux;

    }

    public NODO_DOBLE busquedaPedido(short Busca) {
        NODO_DOBLE aux = getFrente();
        while (aux != null && Busca != aux.getPedido().getNum_pedido()) {
            aux = aux.getSig();
        }
        return aux;
    }

    public NODO_DOBLE eliminar(Short cad) {
        NODO_DOBLE elim = busquedaPedido(cad);
        if (elim == null) {
            return null;
        } else {
            if (elim == frente && elim == ult) {
                frente = null;
                ult = null;
            } else {
                if (elim == getFrente()) {
                    setFrente(elim.getSig());
                    getFrente().setAnt(null);
                } else {
                    if (elim == getUlt()) {
                        setUlt(elim.getAnt());
                        getUlt().setSig(null);
                    } else {
                        elim.getAnt().setSig(elim.getSig());
                        elim.getSig().setAnt(elim.getAnt());
                    }
                }
            }
        }
        return elim;
    }

    public NODO_DOBLE modificar(short cad, Lista_doble lista) throws IOException {
        NODO_DOBLE elim = busquedaPedido(cad);
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        short numPedido, numCliente;
        String pedido;
        double importe;
        if (elim == null) {
            return null;
        } else {
            System.out.println("Que dato desea modificar del pedido numero " + cad);

            System.out.println("Importe: " + elim.getPedido().getImporte());
            System.out.println("Producto: " + elim.getPedido().getProducto());
            System.out.println("Numero de cliente: " + elim.getPedido().getNum_cliente());
            System.out.println("----------------------------------");

            System.out.println("1.- Importe");
            System.out.println("2.- Producto");
            System.out.println("3.- NUM. CLIENTE");
            Short num = Short.parseShort(leer.readLine());
            switch (num) {

                case 1:
                    System.out.println("Ingrese el importe:");
                    importe = Double.parseDouble(leer.readLine());
                    elim.getPedido().setImporte(importe);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del producto");
                    pedido = leer.readLine();
                    elim.getPedido().setProducto(pedido);
                    break;
                case 3:
                    System.out.println("Ingrese el numero de cliente");
                    numCliente = Short.parseShort(leer.readLine());
                    elim.getPedido().getNum_cliente();
                    break;
            }

        }
        return elim;
    }

}
