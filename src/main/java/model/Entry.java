package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;

public class Entry {
    private String name;
    private Entry parent;
    private ArrayList<Entry> children;

    public Entry(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public Entry(Entry parent) {
        this.parent = parent;
        this.children = new ArrayList<>();
        this.parent.addChild(this);
    }

    public Entry(String name, Entry parent) {
        this.name = name;
        this.parent = parent;
        this.children = new ArrayList<>();
        this.parent.addChild(this);
    }

    public void addChild(Entry child) {
        this.children.add(child);
        child.parent = this;
    }

    //TODO Спросить почему именно так? Почему не получалось return this после
    // сравнения имен элементов списка - выдавало null
    public Entry findEntry(String name) {
        Entry[] res = new Entry[1];
        findEntry(name, this, res);
        return res[0];
    }

    public void findEntry(String name, Entry current, Entry[] res){
        if (current.name.equals(name)) {
            res[0] = current;
            return;
        }
        for (int i = 0; i < current.children.size(); i++) {
            findEntry(name, current.children.get(i), res);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showChildren() {
        if (this.parent == null) System.out.println(this.name);
        if (this.children.size() != 0) System.out.print(this.name);
        if (this.children.size() > 0) {
            for (Entry child : this.children) {
                System.out.print(" " + child.getName());
            }
            System.out.println();
            for (Entry child : this.children) {
                child.showChildren();
            }
        }
    }
    // Checking if the name is unique
    public boolean checkUniqueName(Entry entry) {
        if (Objects.equals(entry.name, this.name)) return false;
        for (Entry child : this.children) {
            if (!checkUniqueName(child)) return false;
        }
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(name, entry.name) && Objects.equals(parent, entry.parent) && Objects.equals(children, entry.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parent, children);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
