package com.example.demo4.ui;

import com.example.demo4.Clases.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AgregarClienteController {

    @FXML
    private Button cancel;
    @FXML
    private TextField txtNombre,txt_apellido,txt_edad,txt_email,txt_direccion,txt_dni,txt_salario;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<Rol> menupickerRol;

    private Pedido pedido;
    private HashMap<Integer, Integer> products;
    private SpinnerValueFactory<Integer>factory;
    @FXML
    private Spinner<Integer> cantidad;

    @FXML
    private TextField dni,metodoPago,idProd;


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
    public void alert(String titulo,String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(mensaje);

        alert.showAndWait();
}
    public void agregarProd(){
        try {
            Product product = Manager.getInstance().getProductos().buscarPorId(Integer.parseInt(idProd.getText()));
            if (product != null) {
                factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, product.getStock(), cantidad.getValue());
                cantidad.setValueFactory(factory);
                for (int i = 0; i < cantidad.getValue(); i++) {
                    products.put(product.getId(),cantidad.getValue());
                    //product.setStock(product.getStock()-cantidad.getValue());
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Agregado");
                alert.setHeaderText("Pedido agregado correctamente");

                alert.showAndWait();

            }
            else{
                alert("Error","ID incorrecto");
            }
        }catch (NumberFormatException castException){
            alert("Error","Id incorrecto");
    }
        }
}
