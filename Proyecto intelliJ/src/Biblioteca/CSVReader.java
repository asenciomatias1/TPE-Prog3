package Biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public ArrayList<Libro> cargarLibros(String csvPath) {
        //path: "C:/Users/Matias/eclipse-workspace/Programacion 3/datasets/dataset1.csv"
        String csvFile = csvPath;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Libro> biblioteca = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            line = br.readLine();//la primer linea es el formato, por lo que se ignora
            while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy);
                String nombreLibro = items[0];
                String autor = items[1];
                int nroPaginas = Integer.parseInt(items[2]);
                String[] generos = items[3].split(" ");

                Libro libro = new Libro(nombreLibro, autor, nroPaginas, generos);
                biblioteca.add(libro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return biblioteca;
    }
}