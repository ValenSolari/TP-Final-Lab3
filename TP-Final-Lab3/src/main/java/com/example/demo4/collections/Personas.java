package com.example.demo4.collections;


import com.example.demo4.Clases.Persona;
import com.example.demo4.ui.DatosBuscador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Personas <T extends Persona> implements DatosBuscador {
    private ObservableList<T> list;

    ///region Constructor

    public Personas() {
        this.list = FXCollections.observableArrayList();
    }
    ///endregion

    ///region Metodos
    public void agregarItem(T t){
        list.add(t);
    }
    public T buscarItemDNI(String dni){
        return list.stream().filter(p->p.getDni().equals(dni)).findFirst().get();
    }
    public ArrayList<T> buscarItemsNombre(String nombre){
       /* ArrayList<Persona> match=new ArrayList<>();
        for (Map.Entry<String,Persona> entry: personas.entrySet()){
            if(entry.getValue().getNombre().contains(nombre)){
                match.add(entry.getValue());
            }
        }
        return match;*/
        return null;
    }

    private void eliminarItem(String dni){
        list.remove(dni);
    }

    public ObservableList<T> getList() {
        return list;
    }


    @Override
    public ObservableList<T> buscar(String dato) {
        ObservableList<T> result=FXCollections.observableArrayList();
        for (T t:list
        ) {
            if (t.getNombre().toLowerCase().contains(dato.toLowerCase())
                    ||t.getDni().toLowerCase().contains(dato.toLowerCase())||
                    t.getEmail().toLowerCase().contains(dato.toLowerCase())||
                    t.getApellido().toLowerCase().contains(dato.toLowerCase())){
                result.add(t);
            }
        }
       /* if(result.isEmpty())
        {
            result.setAll(getList());
        }*/
        return result;
    }
    ///endregion

    ///region Get and Set
    public void setList(ObservableList<T> list) {
        this.list = list;
    }
    ///endregion
/*
    public ArrayList<Persona> toList(){
        ArrayList<Persona> arrayList=new ArrayList<>();
        for (Map.Entry<String,Persona> entry: personas.entrySet()){
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }*/
}
