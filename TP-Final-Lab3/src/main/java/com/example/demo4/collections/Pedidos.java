package com.example.demo4.collections;

import com.example.demo4.Clases.Cliente;
import com.example.demo4.Clases.Pedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Pedidos {
    private ObservableList<Pedido> pedidos;
    private Integer valorTotal;
    private Integer costoTotal;

    ///region Construcor

    public Pedidos() {
        this.pedidos= FXCollections.observableArrayList();
        this.valorTotal=0;
        this.costoTotal=0;
    }
    ///endregion

    ///region Metodos
    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    public void eliminarPedido(Pedido pedido){
        pedidos.remove(pedido);
    }
    public Pedido buscarPorId(Integer id){
        for (Pedido p:pedidos) {
            if(p.getId().equals(id)){return p;}
        }
        return null;
    }
    public ObservableList<Pedido> buscarPorCliente(ArrayList<Cliente> clientes){
        ObservableList<Pedido> result=FXCollections.observableArrayList();
        clientes.forEach(cliente -> result.setAll(obtenerPorCliente(cliente)));
        return result;
    }
    public ArrayList<Pedido> obtenerPorCliente(Cliente cliente){
        ArrayList<Pedido> result=new ArrayList<>();
        cliente.getPedidosId().forEach(id->result.add(buscarPorId(id)));
        return result;
    }
    ///endregion

    ///region Get and Set

    public ObservableList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ObservableList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Integer costoTotal) {
        this.costoTotal = costoTotal;
    }


    ///endregion
}
