package com.example.demo4.Clases;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Product {
    private Integer id;
    private String nombre;
    private String fechaIngreso;
    private String marca;
    private CategoriasProductos categoria;
    private Integer precioCompra;
    private Integer porcentajeDeVenta;
    private Integer precioDeVenta;
    private Integer stock;
    private String descripcion;

    ///region Constructor


    public Product(String nombre, String fechaIngreso, String marca, CategoriasProductos categoria,
                   Integer precioCompra, Integer porcentajeDeVenta, Integer stock, String descripcion) {
        this.id=Manager.getInstance().generarIdProd();
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.marca = marca;
        this.categoria = categoria;
        this.precioCompra = precioCompra;
        this.porcentajeDeVenta = porcentajeDeVenta;
        this.precioDeVenta = precioCompra+precioCompra*porcentajeDeVenta/100;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    public Product(String nombre, String fechaIngreso, String marca, CategoriasProductos categoria, Integer precioCompra, Integer porcentajeDeVenta, Integer precioDeVenta, Integer stock, String descripcion) {
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.marca = marca;
        this.categoria = categoria;
        this.precioCompra = precioCompra;
        this.porcentajeDeVenta = porcentajeDeVenta;
        this.precioDeVenta = precioDeVenta;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    public Product() {
    }

    ///endregion

    ///region Get and Set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public CategoriasProductos getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasProductos categoria) {
        this.categoria = categoria;
    }

    public Integer getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Integer precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Integer getPorcentajeDeVenta() {
        return porcentajeDeVenta;
    }

    public void setPorcentajeDeVenta(Integer porcentajeDeVenta) {
        this.porcentajeDeVenta = porcentajeDeVenta;
    }

    public Integer getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(Integer precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @JsonIgnore
    public Integer getGanancia(){
        return precioDeVenta-precioCompra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    ///endregion

    ///region Metodos

    @Override
    public String toString() {
        return "Product{" +
                "nombre='" + nombre + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                ", marca='" + marca + '\'' +
                ", categoria=" + categoria +
                ", precioCompra=" + precioCompra +
                ", porcentajeDeVenta=" + porcentajeDeVenta +
                ", precioDeVenta=" + precioDeVenta +
                ", stock=" + stock +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }


    ///endregion

}
