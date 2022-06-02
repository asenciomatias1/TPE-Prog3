package Estructuras;

import java.util.LinkedList;

import Biblioteca.*;


public class AVLNode<T extends Comparable<T>> {
    private int height;
    private T valor;
    private final LinkedList<Libro> listaLibros;
    private AVLNode<T> left, right;

    public AVLNode(T d, Libro libro) {
        valor = d;
        height = 1;
        this.listaLibros = new LinkedList<Libro>();
        listaLibros.add(libro);
    }

    public void addLibro(Libro l) {
        this.listaLibros.add(l);
    }

    public LinkedList<Libro> getListaLibros() {
        return listaLibros;
    }

    public T getValor() {
        return this.valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode<T> getRight() {
        return this.right;
    }

    public AVLNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }
}

