package util;

import model.Entry;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Util {
    public static void treeBuilder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Start building the tree");
        System.out.println("First type the root object name. It should be written as only one word");
        String firstInput = scanner.nextLine();
        String[] firstElements = firstInput.split(" ");
        if (firstElements.length == 1){
            System.out.println("Great! The root object name is " + firstElements[0]);
            System.out.println("Now continue filling the tree by typing parent element name followed by a child element name");
            System.out.println("Name of a child element must be unique!");
            System.out.println("To quit type two equivalent words");
            Entry rootEntry = new Entry(firstElements[0]);
            String input;
            String[] inputElements = new String[0];
            do {
                try {
                    input = scanner.nextLine();
                    inputElements = input.split(" ");
                    if (Objects.equals(inputElements[0], inputElements[1])) break;
                    if (inputElements.length != 2 || rootEntry.checkUniqueName(inputElements[1])) {
                        throw new InputMismatchException();
                    }
                    System.out.println("Great! Parent element is " + inputElements[0] +
                            " and child element is " + inputElements[1]);
                    Entry parent = rootEntry.findEntry(inputElements[0]);
                    parent.addChild(new Entry(inputElements[1]));
                } catch (InputMismatchException e) {
                    System.out.println("You should type only 2 element names: " +
                            "first for the parent and second for a child\n" +
                            "Name of a child element must be unique!");
                }
            } while (!Objects.equals(inputElements[0], inputElements[1]));
            System.out.println("Now let's see the whole tree!\n");
            rootEntry.showChildren();
        }
        else {
            System.out.println("You should start by creating the root object. It should be written as only one word");
        }
    }


}
