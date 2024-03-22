import es.ies.puerto.modelo.ficheros.FileJson;
import es.ies.puerto.modelo.ficheros.FileXml;
import es.ies.puerto.modelo.impl.Heroes;
import es.ies.puerto.modelo.impl.Personaje;
import es.ies.puerto.modelo.interfaces.IOperacionesFichero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class XmlTest {

    @Test
    public void xmlSaveTest () {
        IOperacionesFichero fileXml = new FileXml();
        Heroes heroes = new Heroes();
        ArrayList<String> poderes = new ArrayList<>();
        poderes.add("ads");
        poderes.add("sdkf");
        Personaje personaje1 = new Personaje("Prueba", "Pruebaapellido", "NS", poderes);
        Personaje personaje2 = new Personaje("sad", "djs", "genero", poderes);
        heroes.addHeroe(personaje1);
        heroes.addHeroe(personaje2);
        fileXml.saveToFile("proyecto-marvel/src/test/resources/heroes.xml", heroes);
    }

    @Test
    public void xmlReadTest () {
        IOperacionesFichero fileXml = new FileXml();
        Heroes heroes = fileXml.readFromFile("proyecto-marvel/src/test/resources/heroes.xml");
        Assertions.assertEquals(heroes.getPersonajes().size(), 2, "El resultado no es el esperado");
    }
}
