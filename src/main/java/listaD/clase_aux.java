/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaD;

/**
 *
 * @author HP
 */
public class clase_aux {

    private Lista_cola com, fl;

    public Lista_cola getCom() {
        return com;
    }

    public void setCom(Lista_cola com) {
        this.com = com;
    }

    public Lista_cola getFl() {
        return fl;
    }

    public void setFl(Lista_cola fl) {
        this.fl = fl;
    }

    public boolean empty() {
        if (getCom() == null && getFl() == null) {
            return true;
        }
        return false;
    }

    public void Insert(Lista_cola nodo) {
        if (empty()) {
            setCom(nodo);
            setFl(nodo);
        } else {
            nodo.setAnt(getFl().getAnt());
            getFl().setSig(nodo);
            setFl(nodo);
        }

    }

    public Lista_cola elimve() {
        Lista_cola lc = getCom();
        if (lc==getCom()&&lc==getFl()) {
            setCom(null);
            setFl(null);
        } else {
            lc.getSig().setAnt(null);
            setCom(lc.getSig());
        }
        return lc;
    }

    

}
