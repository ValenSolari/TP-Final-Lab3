package com.example.demo4.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ListItemPedidoController {
    @FXML
    private Label id,cantProd,valor,pago,fecha;

    public Label getId() {
        return id;
    }

    public void setId(Label id) {
        this.id = id;
    }

    public Label getCantProd() {
        return cantProd;
    }

    public void setCantProd(Label cantProd) {
        this.cantProd = cantProd;
    }

    public Label getValor() {
        return valor;
    }

    public void setValor(Label valor) {
        this.valor = valor;
    }

    public Label getPago() {
        return pago;
    }

    public void setPago(Label pago) {
        this.pago = pago;
    }

    public Label getFecha() {
        return fecha;
    }

    public void setFecha(Label fecha) {
        this.fecha = fecha;
    }
}
