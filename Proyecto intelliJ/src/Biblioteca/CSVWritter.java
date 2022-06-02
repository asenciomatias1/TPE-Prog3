package Biblioteca;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class CSVWritter {

    public void guardarArchivo(LinkedList<Libro> libros, String path) {
        BufferedWriter bw = null;
        try {
            File file = new File(path);/*"C:/Users/Facu/Documents/Facultad/Programacion 3/salida.csv"*/
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            for (Libro l :
                    libros) {
                String contenido = l.getTitulo();
                bw.write(contenido);
                bw.newLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}