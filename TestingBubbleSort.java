import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestingBubbleSort{

    public static void printStringArray(String[] array){
        System.out.println("\n--- Lista de Nombres ---");
        for (int i = 0; i < array.length; i++)
            System.out.println((i + 1) + ". " + array[i]);
    }

    public static void main(String[] args) throws IOException{
        BubbleSortFiles bsFiles = new BubbleSortFiles();
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        String[] nombres;

        System.out.println("==========================================");
        System.out.println("  PROGRAMA BUBBLESORT - ORDENAR NOMBRES   ");

        
        // Leer archivo de entrada
        System.out.print("\nEscribe el nombre del archivo a leer: ");
        fileName = bufer.readLine();
        nombres = bsFiles.fileToStringArray(fileName);
        
        // Mostrar arreglo original
        System.out.println("\n* LISTA ORIGINAL (Sin ordenar) *");
        printStringArray(nombres);

    }
}