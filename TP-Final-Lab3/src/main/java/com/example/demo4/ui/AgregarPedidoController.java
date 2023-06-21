package com.example.demo4.ui;

import com.example.demo4.Clases.Manager;
import com.example.demo4.Clases.Pedido;
import com.example.demo4.Clases.Product;
import com.example.demo4.collections.Productos;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class AgregarPedidoController {
    @FXML
    private TextField dni,metodoPago,idProd;
    @FXML
    private Spinner<Integer> cantidad;
    @FXML
    private DatePicker fecha;
    @FXML
    private Button cancel;

    private Pedido pedido;
    private HashMap<Integer, Integer> products;
    private SpinnerValueFactory<Integer> factory;

    @FXML
    void initialize(){
        factory=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,Integer.MAX_VALUE,0);
        cantidad.setValueFactory(factory);
        products=new HashMap<>();
    }
    public void agregarProd(){
        try {
            Product product = Manager.getInstance().getProductos().buscarPorId(Integer.parseInt(idProd.getText()));
            if (product != null) {
                factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, product.getStock(), cantidad.getValue());
                cantidad.setValueFactory(factory);
                for (int i = 0; i < cantidad.getValue(); i++) {
                    products.put(product.getId(),cantidad.getValue());
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

    public void agregarPedido(){
        try {
            pedido=new Pedido(products,fecha.getValue().toString(),Manager.getInstance().getProductos().obtenerValor(products),dni.getText(),metodoPago.getText());
            Manager.getInstance().agregarPedido(pedido);
            Manager.saveToFile("pedidos.json",Manager.getInstance().getPedidos().getPedidos());

        }catch (ClassCastException castException){
            alert("Error","Datos incorrectos");
        }
    }
    public void closeForm(){
        Stage stage= (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public void alert(String titulo,String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(mensaje);

        alert.showAndWait();
    }

}
