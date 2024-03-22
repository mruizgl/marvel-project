package es.ies.puerto.modelo.ficheros;

import es.ies.puerto.modelo.impl.Heroes;
import es.ies.puerto.modelo.impl.Personaje;
import es.ies.puerto.modelo.interfaces.IOperacionesFichero;

import java.io.*;
import java.util.ArrayList;

public class FileCsv implements IOperacionesFichero {
    @Override
    public Heroes readFromFile(String path) {
        Heroes heroes = null;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            heroes = new Heroes();
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                linea = linea.replace("\"", "");
                ArrayList<String> poderes = new ArrayList<>();
                String[] partes = linea.split(",");
                for (int i = 3; i  < partes.length; i++) {
                    poderes.add(partes[i]);
                }
                Personaje personaje = new Personaje(partes[0], partes[1], partes[2], poderes);
               heroes.addHeroe(personaje);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return heroes;
    }



    @Override
    public boolean saveToFile(String path, Heroes heroes) {
        boolean resultado = false;
        try(PrintWriter printWriter = new PrintWriter(path)) {
            printWriter.println("nombre,alias,genero,poderes");
            for (Personaje personaje : heroes.getPersonajes()) {
                String poderes = "\"";
                for (int i = 0; i < personaje.getPoderes().size(); i++) {
                    poderes = poderes + personaje.getPoderes().get(i) + ", ";
                }
                poderes = poderes.substring(0, poderes.length() -2);
                poderes = poderes+ "\"";
                printWriter.println(personaje.getNombre() + ", " + personaje.getAlias() + ", " + personaje.getGenero() + "," + poderes);
            }

            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return resultado;
    }
}
