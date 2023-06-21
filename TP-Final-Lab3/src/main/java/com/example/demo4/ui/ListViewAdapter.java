package com.example.demo4.ui;

import javafx.scene.control.ListView;

public class ListViewAdapter<T> {
    private ListView<T> listView;

    public ListViewAdapter(ListView<T> listView) {
        this.listView = listView;
    }
}
