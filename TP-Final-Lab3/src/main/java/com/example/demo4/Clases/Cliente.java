package com.example.demo4.Clases;

import java.util.ArrayList;

public class Cliente extends Persona {
    private ArrayList<Integer> pedidosId;
    private Integer saldo;
    private Boolean activo;

    ///region Constructor

    public Cliente(String dni, String nombre, String apellido, Integer edad, String direccion, String email,
                   ArrayList<Integer> pedidos, Integer saldo, Boolean activo) {
        super(dni, nombre, apellido, edad, direccion, email);
        this.pedidosId = pedidos;
        this.saldo = saldo;
        this.activo = activo;
    }

    public Cliente() {
    }
    ///endregion

    ///region Get and Set
    public ArrayList<Integer> getPedidosId() {
        return pedidosId;
    }

    public void setPedidosId(ArrayList<Integer> pedidosId) {
        this.pedidosId = pedidosId;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    ///endregion

    ///region Metodos

    @Override
    public String toString() {
        return "Cliente{" +
                "pedidosId=" + pedidosId +
                ", saldo=" + saldo +
                ", activo=" + activo +
                "} " + super.toString();
    }

    public void agregarPedido(Integer id)
    {
        pedidosId.add(id);
    }

    ///endregion
}
