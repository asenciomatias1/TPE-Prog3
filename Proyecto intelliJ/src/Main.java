import Biblioteca.*;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String localDir = System.getProperty("user.dir");
        localDir += "\\src";
        String[] datasets = {localDir + "/datasets/dataset1.csv",
                localDir + "/datasets/dataset2.csv",
                localDir + "/datasets/dataset3.csv",
                localDir + "/datasets/dataset4.csv"};

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
        System.out.println("la altura del indice generado es de: " + b1.altura());
        String genero;
        Scanner scannerGenero = new Scanner(System.in);
        System.out.println("Elija un genero");
        genero = scannerGenero.nextLine();
        long v1 = System.nanoTime();
        LinkedList<Libro> resultado = b1.buscarGenero(genero);
        long v2 = System.nanoTime();
        System.out.println(resultado);
        System.out.println(v2);
        System.out.println(v1);
        double diferencia = (v2 - v1);
        int saltos = b1.saltosHastaNodo(genero);
        System.out.println("la busqueda tardo: " + diferencia + " nanosegundos, y paso por " + saltos + ((saltos == 1) ? " nodo" : " nodos"));
        Scanner scannerPath = new Scanner(System.in);
        System.out.println("Elija un nombre para el archivo, el mismo se guardara en " + localDir + "\\resultados\\");
        String pathToFile = scannerPath.nextLine();
        writter.guardarArchivo(resultado, localDir + "\\resultados\\" + pathToFile + ".csv");
    }
}
