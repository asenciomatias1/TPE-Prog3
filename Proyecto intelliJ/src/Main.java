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
        String SN;
        Scanner scannerIndice = new Scanner(System.in);
        System.out.println("Usar indice? S/N");
        SN = scannerIndice.nextLine();
        Scanner scannerGenero = new Scanner(System.in);
        System.out.println("Elija un genero");
        genero = scannerGenero.nextLine();
        long v1 = System.nanoTime();
        LinkedList<Libro> resultado;
        if (SN.equals("N")) {
            resultado = b1.buscarGeneroSinIndice(genero);
            System.out.println("No se esta usando el indice");
        } else
            resultado = b1.buscarGenero(genero);
        long v2 = System.nanoTime();
        //System.out.println(resultado);
        double diferencia = (v2 - v1) / 1000000F;
        int saltos = b1.saltosHastaNodo(genero);
        System.out.println("la busqueda tardo: " + diferencia + " milisegundos4, devolvio: " + resultado.size() + " resultados" + ((SN.equals("N")) ? "" : ", y paso por " + saltos + ((saltos == 1) ? " nodo" : " nodos")));
        Scanner scannerPath = new Scanner(System.in);
        System.out.println("Elija un nombre para el archivo, el mismo se guardara en " + localDir + "\\resultados\\");
        String pathToFile = scannerPath.nextLine();
        writter.guardarArchivo(resultado, localDir + "\\resultados\\" + pathToFile + ".csv");
    }
}
