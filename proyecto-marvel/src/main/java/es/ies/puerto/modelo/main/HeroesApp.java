package es.ies.puerto.modelo.main;

import es.ies.puerto.modelo.ficheros.FileCsv;
import es.ies.puerto.modelo.ficheros.FileJson;
import es.ies.puerto.modelo.impl.Heroes;
import es.ies.puerto.modelo.impl.Personaje;
import es.ies.puerto.modelo.interfaces.IOperacionesFichero;

import java.util.ArrayList;

public class HeroesApp {

    public static void main(String[] args) {
        IOperacionesFichero iOperacionesFichero = new FileCsv();
        String path = "src/main/resources/heroes.csv";
        Heroes heroes = iOperacionesFichero.readFromFile(path);
        ArrayList<String> poderes = new ArrayList<>();
        poderes.add("salto");
        poderes.add("dskof");
        Personaje personaje = new Personaje("Susi", "test", "test", poderes);
        heroes.addHeroe(personaje);

        iOperacionesFichero.saveToFile(path, heroes);

    }

    public void menu () {


    }
}
