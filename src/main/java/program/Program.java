package program;

import model.Entry;

public class Program {
    public static void main(String[] args) {
        Entry first = new Entry("Granddad");
        Entry second = new Entry(first);
        second.setName("Dad");
        Entry third = new Entry(first);
        third.setName("Uncle");
        Entry fourth = new Entry(second);
        fourth.setName("Me");
        first.showChildren();
    }

}
