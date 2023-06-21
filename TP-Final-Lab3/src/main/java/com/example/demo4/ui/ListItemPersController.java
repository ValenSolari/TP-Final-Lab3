package com.example.demo4.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ListItemPersController {
    @FXML
    private Label nombreCompleto,dni,edad,direccion,email,tipo;

    public void setNombre(String nombre) {
        this.nombreCompleto.setText(nombre);
    }
    public void setDni(String dni) {
        this.dni.setText(dni);
    }

    public void setEdad(String edad) {
        this.edad.setText(edad);
    }

    public void setDireccion(String direccion) {
        this.direccion.setText(direccion);
    }

    public void setEmail(String email) {
        this.email.setText(email);
    }
    public void setTipo(String tipo) {
        this.tipo.setText(tipo);
    }

}
