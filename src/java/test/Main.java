package src.java.test;

import src.java.main.BinaryTree;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();


        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(18);


        System.out.println("BinaryTree after additions:");
        System.out.println(tree);


        System.out.println("Size of the tree: " + tree.size());


        Optional<Integer> removed = tree.remove(15);
        if (removed.isPresent()) {
            System.out.println("Removed: " + removed.get());
        } else {
            System.out.println("Element 15 not found.");
        }


        System.out.println("BinaryTree after removal:");
        System.out.println(tree);


        System.out.println("Size of the tree after removal: " + tree.size());


        tree.addAll(20, 25, 30);


        System.out.println("BinaryTree after adding more elements:");
        System.out.println(tree);
    }
}
