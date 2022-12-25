package util;

import model.Entry;

import java.util.InputMismatchException;
import java.util.Objects;

public class Util {
    public void newHead(String[] args){
        if (args.length > 1) throw new InputMismatchException("Too many arguments!");
        if (args.length == 0) throw new InputMismatchException("Not enough arguments!");
        else {
            Entry headEntry = new Entry(args[0]);
        }
    }

    public Entry newChild(String parent, String child){

    }

    public void treeBuilder(String[] args){
        if (args.length > 2) throw new InputMismatchException("Too many arguments!");
        if (args.length < 2) throw new InputMismatchException("Not enough arguments!");
        else {
            while (Objects.equals(args[0], args[1])){
                Entry child = newChild(args[0], args[1]);
                if (child.checkUniqueName())
            }
        }
    }
}
