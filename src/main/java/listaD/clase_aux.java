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
        Lista_cola elim = getCom();
        if (getCom().getSig() == null) {
            setCom(null);
            setFl(null);
        } else {
            elim.getSig().setAnt(null);
            setCom(elim.getSig());
        }
        return elim;
    }

    public Lista_cola elim() {
        Lista_cola pp = getCom();
        if (!empty()) {

            pp.getSig().setAnt(null);
            setCom(pp.getSig());

        }
        return pp;

    }

}
