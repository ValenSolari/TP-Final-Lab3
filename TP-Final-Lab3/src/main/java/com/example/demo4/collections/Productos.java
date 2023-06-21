package com.example.demo4.collections;

import com.example.demo4.Clases.Product;
import com.example.demo4.ui.DatosBuscador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.*;

public class Productos implements DatosBuscador<Product> {
    //private ArrayList<Product> productos;
    private ObservableList<Product> productos;

    ///region Constructor
    public Productos() {
        this.productos = FXCollections.observableArrayList();
        //this.productos = new ArrayList<>();
    }

    public Productos(ObservableList<Product> productos) {
        this.productos = productos;
    }
    ///endregion

    ///region Metodos
    public void ordenarPorNombre(){
        productos.sort(Comparator.comparing(Product::getNombre));
    }
    public void ordenarPorPrecio(){
        productos.sort(Comparator.comparing(Product::getPrecioDeVenta));
    }
    public void ordenarPorStock(){
        productos.sort(Comparator.comparing(Product::getStock));

    }
    public void ordenarPorPrecioCompra(){
        productos.sort(Comparator.comparing(Product::getPrecioCompra));

    }
    public void ordenarPorGanancia(){
        productos.sort(Comparator.comparing(Product::getGanancia));

    }
    public Product buscarPorId(Integer id){
        for (Product p:productos
             ) {
            if (Objects.equals(p.getId(), id)){
                return p;
            }
        }
        return null;
    }

    public Integer obtenerValor(HashMap<Integer, Integer> map){
        Integer result=0;
        for (Map.Entry<Integer,Integer> p: map.entrySet()
             ) {
            result+=buscarPorId(p.getKey()).getPrecioDeVenta()*p.getValue();

        }
        return result;
    }

    public void agregarProducto(Product product){
        productos.add(product);
      /* ObjectMapper mapper=new ObjectMapper();
        try {
            File file=new File("Productos.json");
            FileWriter writer=new FileWriter(file,true);
            //file.createNewFile();
            mapper.writeValue(writer,product);
        } catch (IOException e) {
            e.getStackTrace();
        }*/
    }

    public void mostrarProd(){
        for (Product p: productos
        ) {
            System.out.println(p);

        }
    }



    public ObservableList<Product> getProductos() {
        return productos;
    }



    @Override
    public String toString() {
        return "Productos{" +
                "productos=" + productos.toString() +
                '}';
    }

    @Override
    public ObservableList<Product> buscar(String dato) {
        ObservableList<Product> result=FXCollections.observableArrayList();
        for (Product p:productos
             ) {
            if (p.getNombre().toLowerCase().contains(dato.toLowerCase())
                    ||p.getMarca().toLowerCase().contains(dato.toLowerCase())||
                    p.getCategoria().toString().toLowerCase().contains(dato.toLowerCase())){
                result.add(p);
            }
        }
        return result;
    }

    ///endregion

    ///region Get and Set
    public void setProductos(ObservableList<Product> productos) {
        this.productos = productos;
    }

    ///endregion
}
