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
        String fileNameOut;
        String[] nombres;
        
        // Leer archivo de entrada
        System.out.print("\nEscribe el nombre del archivo a leer: ");
        fileName = bufer.readLine();
        nombres = bsFiles.fileToStringArray(fileName);
        
        // Mostrar arreglo original
        System.out.println("\n* LISTA ORIGINAL (Sin ordenar) *");
        printStringArray(nombres);
        
        // Aplicar BubbleSort
        System.out.println(">>> Aplicando algoritmo BubbleSort...");
        System.out.println(" Comparando nombres alfabéticamente...");
        bsFiles.bubbleSort(nombres);
        
        // Mostrar arreglo ordenado
        System.out.println("\n* LISTA ORDENADA ALFABÉTICAMENTE *");
        printStringArray(nombres);
        
        // Guardar resultado en nuevo archivo
        System.out.print("Escribe el nombre del archivo de salida (ordenado): ");
        fileNameOut = bufer.readLine();
        bsFiles.writeStringArrayToFile(fileNameOut, nombres);
        
        System.out.println("\n¡Archivo ordenado guardado exitosamente!");
        System.out.println("Ubicacion: C:\\Archivos\\" + fileNameOut);
        System.out.println("==========================================");
    }
}