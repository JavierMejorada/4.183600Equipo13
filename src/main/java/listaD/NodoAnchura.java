/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaD;

import com.mycompany.equipo13.Sucursal;

/**
 * Mejorada Soto Jose Javier
 * Vallejo Ramirez Emmanuel
 */
public class NodoAnchura {
    private Sucursal Sucursal;
    private NodoAnchura sig,ant;

    public NodoAnchura(Sucursal Sucursal) {
        this.Sucursal = Sucursal;
        this.sig = this.ant = null;
    }

    public Sucursal getSucursal() {
        return Sucursal;
    }

    public void setSucursal(Sucursal Sucursal) {
        this.Sucursal = Sucursal;
    }

    public NodoAnchura getSig() {
        return sig;
    }

    public void setSig(NodoAnchura sig) {
        this.sig = sig;
    }

    public NodoAnchura getAnt() {
        return ant;
    }

    public void setAnt(NodoAnchura ant) {
        this.ant = ant;
    }

    
}
