import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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

        for (int i = 0; i < n - 1; i++){
            intercambio = false;
            
            // Últimos i elementos ya están ordenados
            for (int j = 0; j < n - i - 1; j++){

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
}