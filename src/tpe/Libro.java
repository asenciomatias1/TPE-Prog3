package tpe;

import java.util.Arrays;

public class Libro {
	private String titulo;
	private String autor;
	private int paginas;
	private String[] generos;
	
	public Libro(String titulo, String autor, int paginas, String[] generos) {
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
		this.generos = generos;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + ", generos="
				+ Arrays.toString(generos) + "]\n";
	}
	
}
