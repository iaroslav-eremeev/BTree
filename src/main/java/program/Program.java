package program;

import com.sun.security.jgss.GSSUtil;
import model.Entry;

public class Program {
    public static void main(String[] args) {
        // Head of the hierarchy
        Entry granddad = new Entry("Granddad");
        // Head's children, constructor by parent
        Entry dad = new Entry(granddad);
        dad.setName("Dad");
        Entry uncle = new Entry(granddad);
        uncle.setName("Uncle");
        // Dad's children, constructor by parent and name separately
        Entry me = new Entry(dad);
        me.setName("Me");
        Entry brother = new Entry("Brother");
        dad.addChild(brother);
        // Uncle's child, constructor by name and parent together
        Entry cousin = new Entry("Cousin", uncle);
        // Show all the elements beginning from the head
        granddad.showChildren();
    }
}
