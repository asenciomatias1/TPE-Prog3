package tpe;

import java.util.ArrayList;

public class Biblioteca {
	ArrayList<Libro> libros;
	//BinarySearchTree generos;

	public Biblioteca(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Biblioteca [libros=" + libros + "]";
	}
	
	
}
