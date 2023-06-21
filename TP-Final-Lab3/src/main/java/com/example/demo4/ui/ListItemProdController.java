package com.example.demo4.ui;

import com.example.demo4.Clases.Product;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ListItemProdController {
    @FXML
    private Label nombre,marca,categora,precioCompra,precioVenta,fecha,stock,descripcion;
    @FXML
    private ImageView imageView;
    @FXML
    private Spinner<Integer> spinnerCantidad;
    private Integer cantidadStock=0;
    private SpinnerValueFactory<Integer> valueFactory;
    private ObservableValue<Boolean> agregarPedidoActivo;
    private Integer cantidadPedida;
    private Integer idProducto;
    @FXML
    private Button editar;
    private Product product;
    private Boolean editable;
    public void initialize() {
       // editar.setOnAction(actionEvent -> editarProd(product));
    }


    public void setNombre(String nombre) {
        this.nombre.setText(nombre);
    }
    public void setMarca(String marca) {
        this.marca.setText(marca);
    }

    public void setCategora(String categora) {
        this.categora.setText(categora);
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra.setText(precioCompra);
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta.setText(precioVenta);
    }

    public void setFecha(String fecha) {
        this.fecha.setText(fecha);
    }

    public void setStock(String stock) {
        this.stock.setText(stock);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.setText(descripcion);
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
        valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,cantidadStock,0);
        spinnerCantidad.setValueFactory(valueFactory);
    }

    public Spinner<Integer> getSpinnerCantidad() {
        return spinnerCantidad;
    }

    public void setSpinnerCantidad(Spinner<Integer> spinnerCantidad) {
        this.spinnerCantidad = spinnerCantidad;
    }

    public Integer getCantidadPedida() {
        return cantidadPedida;
    }

    public void setCantidadPedida(Integer cantidadPedida) {
        this.cantidadPedida = cantidadPedida;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }
}
