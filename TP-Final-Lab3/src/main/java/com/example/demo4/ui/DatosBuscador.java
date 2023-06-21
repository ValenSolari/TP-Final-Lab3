package com.example.demo4.ui;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface DatosBuscador<T> {
    ObservableList<T> buscar(String dato);

}
