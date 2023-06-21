package com.example.demo4.ui;

import com.example.demo4.Clases.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class AgregarClienteController {

    @FXML
    private Button cancel;
    @FXML
    private TextField txtNombre,txt_apellido,txt_edad,txt_email,txt_direccion,txt_dni,txt_salario;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<Rol> menupickerRol;


    public void closeForm(){
        Stage stage= (Stage) cancel.getScene().getWindow();
        stage.close();
    }
    public void onClickButtonAdd()
    {
        Cliente cliente =new Cliente(txt_dni.getText(),txtNombre.getText(),txt_apellido.getText(),Integer.parseInt(txt_edad.getText())
                ,txt_direccion.getText(),txt_email.getText(),new ArrayList<>(),0,true);
        Manager.getInstance().agregarCliente(cliente);
        Manager.saveToFile("clientes.json",Manager.getInstance().getClientes().getList());
        closeForm();
    }
}
