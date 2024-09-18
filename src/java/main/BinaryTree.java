package src.java.main;

import java.util.Objects;
import java.util.Optional;

public class BinaryTree {
    private Node root;
    private int size;

    static final class Node {
        Integer e;
        Node left;
        Node right;

        Node(Integer e) {
            this.e = e;
            right = null;
            left = null;
        }

        public String toString() {
            return "Node[" + e + "]";
        }
    }

    public BinaryTree() {
        super();
        size = 0;
    }

    public BinaryTree(Integer... elements) {
        if (elements == null) {
            throw new NullPointerException("The parameter can not be 'null'");
        }

        for (Integer element : elements) {
            if (element == null) {
                throw new NullPointerException("The elements cannot contain 'null'");
            }
            add(element);
        }
    }

    public void add(Integer element) {
        if (element == null) {
            throw new NullPointerException("The parameter can not be 'null'");
        }

        if (isUnique(root, element)) {
            root = addRecursive(root, element);
        }

    }

    private Node addRecursive(Node current, Integer element) {
        if (current == null) {
            size++;
            return new Node(element);
        }

        if (element.compareTo(current.e) < 0) {
            current.left = addRecursive(current.left, element);
        } else if (element.compareTo(current.e) > 0) {
            current.right = addRecursive(current.right, element);
        }

        return current;
    }

    public void addAll(Integer... ar) {
        if (ar == null) {
            throw new NullPointerException("The elements cannot contain 'null'");
        }

        for (Integer i : ar) {
            if (i == null) {
                throw new NullPointerException("The elements cannot contain 'null'");
            }
            add(i);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        traverseInOrder(sb, root);

        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("]");

        return sb.toString();
    }


    private void traverseInOrder(StringBuilder sb, Node node) {
        if (node != null) {
            traverseInOrder(sb, node.left);
            sb.append(node.e).append(", ");
            traverseInOrder(sb, node.right);
        }
    }

    public Optional<Integer> remove(Integer element) {
        if (element == null) {
            throw new NullPointerException("The parameter cannot be 'null'");
        }

        if (isUnique(root, element)) {
            return Optional.empty();
        }

        root = deleteRecursive(root, element);
        size--;
        return Optional.of(element);
    }

    private Node deleteRecursive(Node current, Integer element) {
        if (current == null) {
            return null;
        }

        if (Objects.equals(element, current.e)) {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            int smallestValue = findSmallestValue(current.right);
            current.e = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }

        return current;
    }

    private Integer findSmallestValue(Node root) {
        return root.left == null ? root.e : findSmallestValue(root.left);
    }


    public int size() {
        return size;
    }


    private boolean isUnique(Node current, Integer element) {
        if (current == null) {
            return true;
        }

        if (Objects.equals(element, current.e)) {
            return false;
        }

        return element < current.e
                ? isUnique(current.left, element)
                : isUnique(current.right, element);
    }
}
