package com.example.demo4.Clases;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private Integer id;
    private HashMap<Integer, Integer> productsId;
    private String fecha;
    private Integer valor;
    private String  dniCliente;
    private String metodoDePago;

    ///region Constructor

    public Pedido(HashMap<Integer, Integer> products, String fecha, Integer valor, String dniCliente, String metodoDePago) {
        this.id=Manager.getInstance().generarIdPed();
        this.productsId = products;
        this.fecha = fecha;
        this.valor = valor;
        this.dniCliente = dniCliente;
        this.metodoDePago = metodoDePago;
    }

    public Pedido() {
    }
    ///endregion

    ///region Get and Set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HashMap<Integer, Integer> getProducts() {
        return productsId;
    }

    public void setProducts(HashMap<Integer, Integer> products) {
        this.productsId = products;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }
    ///endregion

    ///region Metodos

    @JsonIgnore
    public Integer getCantidadProd()
    {
        Integer result=0;
        for (Map.Entry<Integer,Integer> p: productsId.entrySet()) {
            result+=p.getValue();
        }
        return result;
    }
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", products=" + productsId +
                ", fecha='" + fecha + '\'' +
                ", valor='" + valor + '\'' +
                ", dniCliente='" + dniCliente + '\'' +
                ", metodoDePago='" + metodoDePago + '\'' +
                '}';
    }


    ///endregion
}
