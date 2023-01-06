package model;

import java.util.ArrayList;
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

    /*public Entry findEntry(String name) {
        Entry[] res = new Entry[1];
        findEntry(name, this, res);
        return res[0];
    }*/

    /*private void findEntry(String name, Entry current, Entry[] res) {
        for (int i = 0; i < ; i++) {

        }
    }*/

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

    @Override
    public String toString() {
        return "Entry{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                ", children=" + children +
                '}';
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
