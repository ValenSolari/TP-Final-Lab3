package com.example.demo4.Clases;

import com.example.demo4.collections.Pedidos;
import com.example.demo4.collections.Personas;
import com.example.demo4.collections.Productos;
import com.example.demo4.ui.DatosBuscador;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import java.io.*;
import java.util.ArrayList;

public final class Manager implements DatosBuscador<Persona> {

    private static Manager manager;
    private Pedidos pedidos=new Pedidos();
    private  Productos productos=new Productos();
    private  Personas<Empleado> empleados=new Personas<>();
    private  Personas<Cliente> clientes=new Personas<>();


    ///region Constructor
    private Manager(){}
    public static Manager getInstance(){
        if(manager==null){
          return manager=new Manager();
        }
        return manager;
    }
    ///endregion

    ///region Metodos
    public  static <T> void saveToFile(String path,T t){
        ObjectMapper mapper=new ObjectMapper();
        try {
            File file=new File(path);
           // Boolean result=file.createNewFile();
            mapper.writerWithDefaultPrettyPrinter().writeValue(file,t);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
    public void saveToFile(String path,ArrayList<Product> products){
        ObjectMapper mapper=new ObjectMapper();
        try {
            File file=new File(path);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            // Boolean result=file.createNewFile();
            mapper.writerWithDefaultPrettyPrinter().writeValue(file,products);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
    public void agregarProducto(Product product){
        productos.agregarProducto(product);
        //Manager.productos.mostrarProd();
        System.out.println(getProductos().getProductos().toString());
       // saveToFile("productos.json",Manager.getProductos().getProductos());
    }

    public  void agregarEmpleado(Empleado empleado){
        empleados.agregarItem(empleado);
    }
    public  void agregarCliente(Cliente cliente){
        clientes.agregarItem(cliente);
    }
    public static <T> ArrayList<T> fileToList(String path, Class<T> t){
        try {
            File file=new File(path);
            ObjectMapper mapper=new ObjectMapper();
            return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class,t));

        } catch (IOException e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public  ObservableList<Persona> clientesYEmpleados(){
        ObservableList list= FXCollections.observableArrayList();
        list.setAll(getClientes().getList());
        list.setAll(getEmpleados().getList());
        return list;
    }
    @Override
    public  ObservableList<Persona> buscar(String dato) {
        ObservableList<Persona> result = FXCollections.observableArrayList();
        for (Persona t : getEmpleados().getList()
        ) {
            if (t.getNombre().concat(" "+t.getApellido()).toLowerCase().contains(dato.toLowerCase())
                    || t.getDni().toLowerCase().contains(dato.toLowerCase()) ||
                    t.getEmail().toLowerCase().contains(dato.toLowerCase()) ||
                    t.getApellido().toLowerCase().contains(dato.toLowerCase())
                    ||"empleados".contains(dato.toLowerCase())) {
                result.add(t);
            }
        }
        for (Persona t : getClientes().getList()
        ) {
            if (t.getNombre().concat(" "+t.getApellido()).toLowerCase().contains(dato.toLowerCase())
                    || t.getDni().toLowerCase().contains(dato.toLowerCase()) ||
                    t.getEmail().toLowerCase().contains(dato.toLowerCase()) ||
                    t.getApellido().toLowerCase().contains(dato.toLowerCase())
                    ||"clientes".contains(dato.toLowerCase())) {
                result.add(t);
            }
        }
        return result;
    }
    public void agregarPedido(Pedido pedido){
        pedidos.agregarPedido(pedido);
        clientes.buscarItemDNI(pedido.getDniCliente()).agregarPedido(pedido.getId());
    }

    public Integer generarIdProd()
    {
        return getProductos().getProductos().size();
    }
    public Integer generarIdPed()
    {
        return getPedidos().getPedidos().size();
    }
    public void salvarDatos(){
        Manager.saveToFile("clientes.json",Manager.getInstance().getClientes().getList());
        Manager.saveToFile("empleados.json",Manager.getInstance().getEmpleados().getList());
        Manager.saveToFile("productos.json",Manager.getInstance().getProductos().getProductos());
        Manager.saveToFile("pedidos.json",Manager.getInstance().getPedidos().getPedidos());
    }

    ///endregion

    ///region Get and Set
    public  Personas<Empleado> getEmpleados() {
        return empleados;
    }

    public  void setEmpleados(Personas<Empleado> empleados) {
        empleados = empleados;
    }

    public  Personas<Cliente> getClientes() {
        return clientes;
    }

    public  void setClientes(Personas<Cliente> clientes) {
        clientes = clientes;
    }

    public  Productos getProductos() {
        return productos;
    }

    public  void setProductos(Productos productos) {
        productos = productos;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
    ///endregion


}
