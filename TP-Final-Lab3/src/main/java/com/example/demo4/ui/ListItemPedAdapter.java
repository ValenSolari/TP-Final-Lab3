package com.example.demo4.ui;

import com.example.demo4.Clases.Empleado;
import com.example.demo4.Clases.Pedido;
import com.example.demo4.Clases.Persona;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ListItemPedAdapter extends ListCell<Pedido> {
    private ListItemPedidoController controller;
    AnchorPane root;
    public ListItemPedAdapter() {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("list-item-pedido.fxml"));
            controller = new ListItemPedidoController();
            root=fxmlLoader.load();
            controller=fxmlLoader.getController();
            fxmlLoader.setController(controller);

        }catch (IOException e){e.printStackTrace();}
    }

    @Override
    protected void updateItem(Pedido pedido, boolean b) {
        super.updateItem(pedido, b);
        if (b || pedido == null) {
            setText(null);
            setGraphic(null);
        } else {
            //Configurar los datos del elemento utilizando el controlador
            controller.getId().setText("DNI: "+pedido.getDniCliente());
            controller.getCantProd().setText(pedido.getCantidadProd().toString());
            controller.getFecha().setText(pedido.getFecha());
            controller.getValor().setText(pedido.getValor().toString());
            controller.getPago().setText(pedido.getMetodoDePago());

            setText(null);
            setGraphic(root);
        }
    }
}
