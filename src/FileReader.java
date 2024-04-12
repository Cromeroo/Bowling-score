import java.io.BufferedReader;
import java.util.ArrayList;

public class FileReader {
    private String filePath;

            public String[] leerTxt2(String filePath) {
                ArrayList<String> listaDeLineas = new ArrayList<>(); // Lista para almacenar las líneas leídas
                try {
                    BufferedReader bf = new BufferedReader(new java.io.FileReader(filePath));
                    String bfRead;
                    while ((bfRead = bf.readLine()) != null) {
                        listaDeLineas.add(bfRead); // Añadir cada línea a la lista
                    }
                } catch (Exception e) {
                    System.out.println("No se encontró el archivo");
                }
                return listaDeLineas.toArray(new String[0]); // Devuelve un arreglo de strings con las líneas del archivo
            }
        }




