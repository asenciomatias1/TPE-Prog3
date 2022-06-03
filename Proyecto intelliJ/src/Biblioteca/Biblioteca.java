package Biblioteca;

import Estructuras.AVLTree;

import java.util.ArrayList;
import java.util.LinkedList;

public class Biblioteca {
    ArrayList<Libro> libros;
    AVLTree<String> indiceGeneros;

    public Biblioteca(ArrayList<Libro> libros) {
        this.libros = libros;
        this.indiceGeneros = new AVLTree<>();
        for (Libro l :
                libros) {
            for (String genero :
                    l.getGeneros()) {
                indiceGeneros.insertarLibro(genero, l);
            }
        }
    }

    public LinkedList<Libro> buscarGeneroSinIndice(String genero) {
        LinkedList<Libro> resultado = new LinkedList<>();
        for (Libro l :
                libros) {
            for (String g :
                    l.getGeneros()) {
                if (g.equals(genero))
                    resultado.add(l);
            }
        }
        return resultado;
    }

    public LinkedList<Libro> buscarGenero(String genero) {
        return indiceGeneros.buscarLibros(genero);
    }

    public void imprimirIndice() {
        indiceGeneros.printTree(indiceGeneros.getRoot(), "", true);
    }

    public int saltosHastaNodo(String valor) {
        return indiceGeneros.saltosHastaNodo(valor);
    }

    public int altura() {
        return indiceGeneros.altura();
    }

    @Override
    public String toString() {
        return "Biblioteca [libros=" + libros + "]";
    }


}
