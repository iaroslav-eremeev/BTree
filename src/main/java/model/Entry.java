package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;

public class Entry {
    private String name;
    private Entry parent;
    private ArrayList<Entry> children;

    public Entry(Entry parent) {
        this.parent = parent;
    }

    public Entry(String name, Entry parent) {
        this.name = name;
        this.parent = parent;
    }

    public void addChild(Entry child) {
        this.children.add(child);
    }

    public Entry findEntry(String name) {
        Entry[] res = new Entry[1];
        findEntry(name, this, res);
        return res[0];
    }

    private void findEntry(String name, Entry current, Entry[] res) {
        for (int i = 0; i <; i++) {

        }
    }

    public Entry(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showChildren() {
        System.out.print(this.name);
        if (this.children.size() > 0) {
            for (Entry child : this.children) {
                System.out.print(" " + child);
            }
            for (Entry child : this.children) {
                child.showChildren();
            }
        }
    }

    /**
     * Написать программу, которая последовательно строит дерево иерархии объектов,
     * слева направо и сверху вниз. Переход на новый уровень происходит от правого (последнего)
     * объекта предыдущего уровня.
     */

    // Проверка уникальности имени объекта
    public boolean checkUniqueName(Entry entry) {
        if (Objects.equals(entry.name, this.name)) return false;
        for (Entry child : this.children) {
            if (!checkUniqueName(child)) return false;
        }
        return true;
    }
}
