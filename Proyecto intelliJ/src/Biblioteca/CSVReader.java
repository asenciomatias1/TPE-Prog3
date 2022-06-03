package Biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Stream;

public class CSVReader {


    public Libro[] cargarLibros(String csvPath) {
        //path: "C:/Users/Matias/eclipse-workspace/Programacion 3/datasets/dataset1.csv"
        //String line = "";
        String cvsSplitBy = ",";
        Libro[] biblioteca;
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            //line = br.readLine();//la primer linea es el formato, por lo que se ignora

            long cantidadLibros = br.lines().count();
            BufferedReader br2 = new BufferedReader(new FileReader(csvPath));
            Stream<String> lines = br2.lines();

            biblioteca = new Libro[(int) cantidadLibros - 1];
            Iterator<String> i = lines.iterator();
            i.next();//la primer fila no es un libro
            int key = 0;
            while (i.hasNext()) {
                String[] items = i.next().split(cvsSplitBy);

                String nombreLibro = items[0];
                String autor = items[1];
                int nroPaginas = Integer.parseInt(items[2]);
                String[] generos = items[3].split(" ");

                Libro libro = new Libro(nombreLibro, autor, nroPaginas, generos);
                biblioteca[key] = libro;
                key++;
            }

            /*while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy);
                String nombreLibro = items[0];
                String autor = items[1];
                int nroPaginas = Integer.parseInt(items[2]);
                String[] generos = items[3].split(" ");

                Libro libro = new Libro(nombreLibro, autor, nroPaginas, generos);
                biblioteca.add(libro);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
            biblioteca = null;
        }
        return biblioteca;
    }
}