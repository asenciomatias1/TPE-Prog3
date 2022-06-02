package Estructuras;

import Biblioteca.Libro;

import java.util.LinkedList;

public class AVLTree<T extends Comparable<T>> {
    AVLNode<T> root;

    public AVLTree() {
    }

    public void setRoot(AVLNode<T> root) {
        this.root = root;
    }

    public int height(AVLNode<T> N) {
        if (N == null)
            return 0;
        return N.getHeight();
    }

    public AVLNode<T> getRoot() {
        return this.root;
    }

    public int max(int a, int b) {
        return Math.max(a, b);
    }

    public AVLNode<T> rightRotate(AVLNode<T> y) {
        AVLNode<T> x = y.getLeft();
        AVLNode<T> T2 = x.getRight();
        x.setRight(y);
        y.setLeft(T2);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        return x;
    }

    public LinkedList<Libro> buscarLibros(T valor) {
        AVLNode<T> nodo = buscarNodo(this.getRoot(), valor);
        if (nodo != null) {
            return nodo.getListaLibros();
        } else {
            return null;
        }
    }

    private AVLNode<T> buscarNodo(AVLNode<T> node, T valor) {
        if (node == null)
            return null;

        if (valor.compareTo(node.getValor()) == 0)
            return node;
        else if (valor.compareTo(node.getValor()) > 0)
            return buscarNodo(node.getRight(), valor);
        else
            return buscarNodo(node.getLeft(), valor);

    }

    public AVLNode<T> leftRotate(AVLNode<T> x) {
        AVLNode<T> y = x.getRight();
        AVLNode<T> T2 = y.getLeft();
        y.setLeft(x);
        x.setRight(T2);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        return y;
    }

    // Get balance factor of a node
    public int getBalanceFactor(AVLNode<T> N) {
        if (N == null)
            return 0;
        return height(N.getLeft()) - height(N.getRight());
    }

    public void insertarLibro(T item, Libro libro) {
        this.setRoot(this.insertNode(this.getRoot(), item, libro));
    }

    // Insert a node
    public AVLNode<T> insertNode(AVLNode<T> node, T item, Libro l) {

        // Find the position and insert the node
        if (node == null)
            return (new AVLNode<T>(item, l));
        if (item.compareTo(node.getValor()) < 0)
            node.setLeft(insertNode(node.getLeft(), item, l));
        else if (item.compareTo(node.getValor()) > 0)
            node.setRight(insertNode(node.getRight(), item, l));
        else {
            node.addLibro(l);
            return node;
        }

        // Update the balance factor of each node
        // And, balance the tree
        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (item.compareTo(node.getLeft().getValor()) < 0) {
                return rightRotate(node);
            } else if (item.compareTo(node.getLeft().getValor()) > 0) {
                node.setLeft(leftRotate(node.getLeft()));
                return rightRotate(node);
            }
        }
        if (balanceFactor < -1) {
            if (item.compareTo(node.getRight().getValor()) > 0) {
                return leftRotate(node);
            } else if (item.compareTo(node.getRight().getValor()) < 0) {
                node.setRight(rightRotate(node.getRight()));
                return leftRotate(node);
            }
        }
        return node;
    }

    AVLNode<T> nodeWithMimumValue(AVLNode<T> node) {
        AVLNode<T> current = node;
        while (current.getLeft() != null)
            current = current.getLeft();
        return current;
    }

    // Delete a node
    AVLNode<T> deleteNode(AVLNode<T> root, T item) {

        // Find the node to be deleted and remove it
        if (root == null)
            return root;
        if (item.compareTo(root.getValor()) < 0)
            root.setLeft(deleteNode(root.getLeft(), item));
        else if (item.compareTo(root.getValor()) > 0)
            root.setRight(deleteNode(root.getRight(), item));
        else {
            if ((root.getLeft() == null) || (root.getRight() == null)) {
                AVLNode<T> temp = null;
                if (temp == root.getLeft())
                    temp = root.getRight();
                else
                    temp = root.getLeft();
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                AVLNode<T> temp = nodeWithMimumValue(root.getRight());
                root.setValor(temp.getValor());
                root.setRight(deleteNode(root.getRight(), temp.getValor()));
            }
        }
        if (root == null)
            return root;

        // Update the balance factor of each node and balance the tree
        root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1) {
            if (getBalanceFactor(root.getLeft()) >= 0) {
                return rightRotate(root);
            } else {
                root.setLeft(leftRotate(root.getLeft()));
                return rightRotate(root);
            }
        }
        if (balanceFactor < -1) {
            if (getBalanceFactor(root.getRight()) <= 0) {
                return leftRotate(root);
            } else {
                root.setRight(rightRotate(root.getRight()));
                return leftRotate(root);
            }
        }
        return root;
    }

    void preOrder(AVLNode<T> node) {
        if (node != null) {
            System.out.print(node.getValor() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    // Print the tree
    public void printTree(AVLNode<T> currPtr, String indent, boolean last) {
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(currPtr.getValor());
            printTree(currPtr.getLeft(), indent, false);
            printTree(currPtr.getRight(), indent, true);
        }
    }
}
