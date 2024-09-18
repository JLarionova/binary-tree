# BinaryTree

## Overview

The `BinaryTree` class provides a basic implementation of a binary search tree (BST) in Java. This tree structure allows for efficient insertion, deletion, and in-order traversal of elements. The tree stores `Integer` values and maintains the binary search tree property, where each node's left subtree contains only nodes with values less than the node's value, and each node's right subtree contains only nodes with values greater than the node's value.

## Class Definition

### `BinaryTree`

- **Attributes:**
    - `private Node root`: The root node of the binary tree.
    - `private int size`: The number of elements in the tree.

- **Inner Class: `Node`**
    - `Integer e`: The value stored in the node.
    - `Node left`: Reference to the left child node.
    - `Node right`: Reference to the right child node.

- **Constructor:**
    - `public BinaryTree()`: Initializes an empty binary tree.
    - `public BinaryTree(Integer... elements)`: Initializes the tree with the provided elements.

- **Methods:**
    - `public boolean add(Integer element)`: Adds an element to the tree. Returns `true` if the element was added, `false` if it was already present.
    - `private Node addRecursive(Node current, Integer element)`: Recursively adds an element to the correct position in the tree.
    - `public void addAll(Integer... ar)`: Adds multiple elements to the tree.
    - `@Override public String toString()`: Returns a string representation of the tree in in-order traversal.
    - `private void traverseInOrder(StringBuilder sb, Node node)`: Helper method for in-order traversal.
    - `public Optional<Integer> remove(Integer element)`: Removes an element from the tree, if present. Returns an `Optional` containing the removed element or `Optional.empty()` if the element was not found.
    - `private Node deleteRecursive(Node current, Integer element)`: Recursively removes an element from the tree.
    - `private Integer findSmallestValue(Node root)`: Finds the smallest value in a subtree.
    - `public int size()`: Returns the number of elements in the tree.
    - `private boolean isUnique(Node current, Integer element)`: Checks if an element is unique in the tree.