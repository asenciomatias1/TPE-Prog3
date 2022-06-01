package tpe;

public class main {

	public static void main(String[] args) {
		CSVReader csvr = new CSVReader();
		String csvPath = "C:/Users/Matias/eclipse-workspace/Programacion 3/datasets/dataset1.csv";
		Biblioteca b1 = new Biblioteca(csvr.cargarLibros(csvPath));
		System.out.println(b1);
	}

}
