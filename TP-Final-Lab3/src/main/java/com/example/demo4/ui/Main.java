package com.example.demo4.ui;

import com.example.demo4.Clases.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Manager.getProductos().setProductos(Manager.fileToList("productos.json", Product.class));
        Manager.getInstance().getProductos().setProductos(FXCollections.observableList(Objects.requireNonNull(Manager.fileToList("productos.json", Product.class))));
        Manager.getInstance().getEmpleados().setList(FXCollections.observableList(Objects.requireNonNull(Manager.fileToList("empleados.json", Empleado.class))));
        Manager.getInstance().getClientes().setList(FXCollections.observableList(Objects.requireNonNull(Manager.fileToList("clientes.json", Cliente.class))));
        Manager.getInstance().getPedidos().setPedidos(FXCollections.observableList(Manager.fileToList("pedidos.json", Pedido.class)));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MenuUI.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 850, 550);
        stage.setTitle("Gestor de inventario");
        stage.setScene(scene);
        stage.show();


    }
    @Override
    public void stop(){
        Manager.getInstance().salvarDatos();
    }
    public static void main(String[] args) {
        launch();
    }


}