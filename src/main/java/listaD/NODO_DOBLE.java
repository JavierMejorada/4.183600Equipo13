/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaD;

/**
 *
 * @author Alumno
 */
public class NODO_DOBLE
{
    private PEDIDO pedido;
    private NODO_DOBLE sig,ant;

    public NODO_DOBLE(PEDIDO pedido){
        this.pedido = pedido;
        sig=ant=null;
    }

    public PEDIDO getPedido(){
        return pedido;
    }

    public void setInfo(PEDIDO pedido){
        this.pedido = pedido;
    }

    public NODO_DOBLE getSig(){
        return sig;
    }

    public void setSig(NODO_DOBLE sig){
        this.sig = sig;
    }

    public NODO_DOBLE getAnt(){
        return ant;
    }

    public void setAnt(NODO_DOBLE ant){
        this.ant = ant;
    }
    
}
