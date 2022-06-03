package Biblioteca;

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

    public String[] getGeneros() {
        return generos;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + ", generos="
                + Arrays.toString(generos) + "\n";
    }

}
