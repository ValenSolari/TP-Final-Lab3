package com.example.demo4.ui;

import com.example.demo4.Clases.Product;
import com.example.demo4.ui.ListItemProdController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ListItemProdAdapter extends ListCell<Product> {
    private ListItemProdController controller;
    AnchorPane root;
    private Boolean mostrarAgregarProd=Boolean.FALSE;
    public ListItemProdAdapter() {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("list-item-prod.fxml"));
            controller = new ListItemProdController();
            root=fxmlLoader.load();
            controller=fxmlLoader.getController();
            fxmlLoader.setController(controller);

        }catch (IOException e){e.printStackTrace();}
    }

    @Override
    protected void updateItem(Product product, boolean b) {
        super.updateItem(product, b);
        if (b || product == null) {
            setText(null);
            setGraphic(null);
        } else {
            // Configurar los datos del elemento utilizando el controlador
            controller.setNombre(product.getNombre());
            controller.setMarca(product.getMarca());
            controller.setCategora(product.getCategoria().toString());
            controller.setPrecioCompra(product.getPrecioCompra().toString());
            controller.setPrecioVenta(product.getPrecioDeVenta().toString());
            controller.setFecha(product.getFechaIngreso());
            controller.setStock(product.getStock().toString());
            controller.setDescripcion(product.getDescripcion());
            controller.setCantidadStock(product.getStock());
            if(mostrarAgregarProd){
                controller.getSpinnerCantidad().visibleProperty().set(true);
            }else {
                controller.getSpinnerCantidad().visibleProperty().set(false);
            }
            //controller.setProduct(product);

            setText(null);
            setGraphic(root);
        }
    }
    public <T>void changeMostrarAgregarProd(ListView<T> listView){
        mostrarAgregarProd=!mostrarAgregarProd;
        System.out.println("hollala: "+mostrarAgregarProd);
    }
}
