/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaD;

/**
 *
 * @author HP
 */
public class PEDIDO {
    private short Num_pedido;
    private double importe;
    private String producto;
    private short Num_cliente;

    public int getNum_pedido() {
        return Num_pedido;
    }

    public void setNum_pedido(short Num_pedido) {
        this.Num_pedido = Num_pedido;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getNum_cliente() {
        return Num_cliente;
    }

    public void setNum_cliente(short Num_cliente) {
        this.Num_cliente = Num_cliente;
    }

   
    public PEDIDO(short Num_cuenta, double importe, String producto, short Num_cliente) {
        this.Num_pedido = Num_cuenta;
        this.importe = importe;
        this.producto = producto;
        this.Num_cliente = Num_cliente;
    }
    
}
