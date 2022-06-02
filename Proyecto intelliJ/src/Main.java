import Biblioteca.*;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] datasets = {"C:/Users/Facu/Documents/Facultad/Programacion 3/datasets/dataset1.csv",
                "C:/Users/Facu/Documents/Facultad/Programacion 3/datasets/dataset2.csv",
                "C:/Users/Facu/Documents/Facultad/Programacion 3/datasets/dataset3.csv",
                "C:/Users/Facu/Documents/Facultad/Programacion 3/datasets/dataset4.csv"};

        CSVReader csvr = new CSVReader();
        CSVWritter writter = new CSVWritter();
        String csvPath = "";

        int opcion;
        System.out.println("Elija un dataset (1, 2, 3 o 4)");
        opcion = sc.nextInt();
        while (!(opcion > 0 && opcion < 5)) {
            System.out.println("Elija un dataset (1, 2, 3 o 4)");
            opcion = sc.nextInt();
        }
        switch (opcion) {
            case 1 -> csvPath = datasets[0];
            case 2 -> csvPath = datasets[1];
            case 3 -> csvPath = datasets[2];
            case 4 -> csvPath = datasets[3];
        }
        Biblioteca b1 = new Biblioteca(csvr.cargarLibros(csvPath));
        b1.imprimirIndice();
        String genero;
        Scanner scannerGenero = new Scanner(System.in);
        System.out.println("Elija un genero");
        genero = scannerGenero.nextLine();
        LinkedList<Libro> resultado = b1.buscarGenero(genero);
        System.out.println(resultado);
        Scanner scannerPath = new Scanner(System.in);
        System.out.println("En donde le gustaria guardar el archivo");
        String pathToFile = scannerPath.nextLine();//espera por ejemplo C:/Users/Usuario/Documents/Programacion 3/salida.csv
        writter.guardarArchivo(resultado, pathToFile);
    }
}
