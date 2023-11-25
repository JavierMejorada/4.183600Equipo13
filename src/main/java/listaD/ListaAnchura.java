/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaD;

import com.mycompany.equipo13.Sucursal;

/**
 * Mejorada Soto Jose Javier
 * Vallejo Ramirez Emmanule
 */
public class ListaAnchura {

    private NodoAnchura frente, ult;

    public NodoAnchura getFrente() {
        return frente;
    }

    public void setFrente(NodoAnchura frente) {
        this.frente = frente;
    }

    public NodoAnchura getUlt() {
        return ult;
    }

    public void setUlt(NodoAnchura ult) {
        this.ult = ult;
    }
    

    public boolean empty() {
        if (frente == null && ult == null) {
            return true;
        }
        return false;
    }

    public void insert(NodoAnchura nodo) {
        if (empty()) {
            setFrente(nodo);
            setUlt(nodo);
        } else {
            nodo.setAnt(getUlt());
            getUlt().setSig(nodo);
            setUlt(nodo);
        }
    }
    
    public NodoAnchura remove(){
        NodoAnchura aux = getFrente();
        if(aux == getFrente() && aux == getUlt())
            this.frente = this.ult = null;
        else{
            aux.getSig().setAnt(null);
            setFrente(aux.getSig());
        }
        return aux;
    }
}
