package ru.skvrez.composite_example;

import java.util.ArrayList;
import java.util.List;

public class ItemStorage<T> {

    protected List<T> items = new ArrayList<>();

    ItemStorage(){}

    ItemStorage(ItemStorage<T> itemStorage){
        this.items = itemStorage.items;
    }

    public void add(T item) {
        items.add(item);
    }

    public void add(List<T> item) {
        items.addAll(item);
    }


    public void remove(T item) {
        items.remove(item);
    }

    public List<T> getItems() {
        return items;
    }
}
