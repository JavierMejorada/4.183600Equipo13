/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaD;

import com.mycompany.equipo13.Sucursal;
import com.mycompany.equipo13.Arbol;

/**
 *
 * @author Usuario
 */
public class Lista_cola {

   private Sucursal info;
   private Lista_cola sig,ant;

    public Lista_cola(Sucursal info) {
        this.info = info;
        this.sig = null;
        this.ant = null;
    }
   

    public Sucursal getInfo() {
        return info;
    }

    public void setInfo(Sucursal info) {
        this.info = info;
    }

    public Lista_cola getSig() {
        return sig;
    }

    public void setSig(Lista_cola sig) {
        this.sig = sig;
    }

    public Lista_cola getAnt() {
        return ant;
    }

    public void setAnt(Lista_cola ant) {
        this.ant = ant;
    }

   
   


    

}
