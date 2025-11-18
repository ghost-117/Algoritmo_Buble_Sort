import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class BubbleSortFiles{

    int countFileLines(String fileName){
        File file;
        FileReader reader;
        BufferedReader bufer;
        int numLines = 0;

        try{
            file = new File("C:\\Archivos\\" + fileName);
            reader = new FileReader(file);
            bufer = new BufferedReader(reader);
            while ( (bufer.readLine()) != null ){
                numLines++;
            }
            reader.close();
        }catch( Exception e ) {
            System.out.println("Error al leer el archivo: " + e.toString());
        }
        return numLines;
    }

    // Método para intercambiar dos elementos en el arreglo
    private void swap(String[] array, int i, int j){
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Método principal BubbleSort para ordenar nombres (Strings)
    public void bubbleSort(String[] array){
        int n = array.length;
        boolean intercambio;
        
        // Recorrer todo el arreglo
        for (int i = 0; i < n - 1; i++){
            intercambio = false;
            
            for (int j = 0; j < n - i - 1; j++){
                // Comparar nombres alfabéticamente (ignorando mayúsculas/minúsculas)
                if (array[j].compareToIgnoreCase(array[j + 1]) > 0){
                    swap(array, j, j + 1);
                    intercambio = true;
                }
            }
            
            // Si no hubo intercambios, el arreglo ya está ordenado
            if (!intercambio)
                break;
        }
    }

    // Versión alternativa sin optimización
    public void bubbleSortBasic(String[] array){
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (array[j].compareToIgnoreCase(array[j + 1]) > 0){
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public String[] fileToStringArray(String fileName){
        File file;
        FileReader reader;
        BufferedReader bufer;
        String linea;
        String[] array = null;
        int i = 0;
        int t;
        
        try{
            t = countFileLines(fileName);
            array = new String[t];
            file = new File("C:\\Archivos\\" + fileName);
            reader = new FileReader(file);
            bufer = new BufferedReader(reader);
            
            
            while ( (linea = bufer.readLine()) != null ){
                array[i] = linea.trim(); // trim() elimina espacios extras
                i++;
            }
            reader.close();
        } catch( Exception e){
            System.out.println("Error al leer el archivo: " + e.toString());
        }
        return array;
    }

    // Escribir arreglo ordenado de nombres a archivo
    public void writeStringArrayToFile(String fileName, String[] array){
        FileWriter file;
        PrintWriter writer;
        
        try{
            file = new FileWriter("c:\\Archivos\\" + fileName);
            writer = new PrintWriter(file);
            for ( String nombre : array )
                writer.println(nombre);
            file.close();
        } catch ( Exception e) {
            System.out.println("Error al crear el archivo: " + e.toString());
        }
    }

}