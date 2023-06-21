package com.example.demo4.ui;

import com.example.demo4.Clases.Empleado;
import com.example.demo4.Clases.Persona;
import com.example.demo4.ui.ListItemProdController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ListItemPersAdapter extends ListCell<Persona> {
    private ListItemPersController controller;
    AnchorPane root;
    public ListItemPersAdapter() {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("list-item-pers.fxml"));
            controller = new ListItemPersController();
            root=fxmlLoader.load();
            controller=fxmlLoader.getController();
            fxmlLoader.setController(controller);

        }catch (IOException e){e.printStackTrace();}
    }

    @Override
    protected void updateItem(Persona persona, boolean b) {
        super.updateItem(persona, b);
        if (b || persona == null) {
            setText(null);
            setGraphic(null);
        } else {
             //Configurar los datos del elemento utilizando el controlador
            controller.setNombre(persona.getNombre()+" "+persona.getApellido());
            controller.setDni(persona.getDni());
            controller.setEmail(persona.getEmail());
            controller.setDireccion(persona.getDireccion());
            controller.setEdad(persona.getEdad().toString());
            controller.setTipo(persona instanceof Empleado?"Empleado":"Cliente");

            setText(null);
            setGraphic(root);
        }
    }
}
