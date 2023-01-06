package util;

import model.Entry;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Util {

    /*public Entry newHead(String[] args){
        if (args.length > 1) throw new InputMismatchException("Too many arguments! " +
                "To create new head type only one unique name!");
        else if (args.length == 0) throw new InputMismatchException("Not enough arguments!");
        else {
            return new Entry(args[0]);
        }
    }*/

    public static void treeBuilder(Scanner scanner){
        System.out.println("Please start building the tree");
        System.out.println("First type the root object name");
        System.out.println("Then continue filling the tree by typing parent name followed by child name");
        System.out.println("To quit type two equivalent names");
        String firstInput = scanner.nextLine();
        String[] firstElements = firstInput.split(" ");
        if (firstElements.length == 1){
            Entry rootEntry = new Entry(firstElements[0]);
            String input = scanner.nextLine();
            String[] inputElements = input.split(" ");
            while (!Objects.equals(inputElements[0], inputElements[1])){
                if (inputElements.length != 2) {
                    throw new InputMismatchException("You should type only 2 names - " +
                            "first is for parent and second is for child");
                }
                /*if (!rootEntry.checkUniqueName(inputElements[1])) {
                    throw new InputMismatchException("Name of the child must be unique!");
                }*/
                Entry parent = rootEntry.findEntry(inputElements[0]);
                parent.addChild(new Entry(inputElements[1]));
                input = scanner.nextLine();
                inputElements = input.split(" ");
            }
            System.out.println("Now let's see the whole tree!");
            rootEntry.showChildren();
        }
        else {
            System.out.println("You should start by creating the root object. Type only one name");
        }

    }
}
