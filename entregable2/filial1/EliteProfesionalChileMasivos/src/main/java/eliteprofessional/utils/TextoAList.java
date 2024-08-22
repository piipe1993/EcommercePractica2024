package eliteprofessional.utils;

import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextoAList {

    public static  List<String> convertir (String cadena) {
        cadena=(cadena.replaceAll("\\s;",";"));
        cadena=(cadena.replaceAll(";\\s",";"));
        List<Object> categoriasListObjet = Arrays.asList(cadena.split(";"));
        List<String> categoriasList = new ArrayList<>(categoriasListObjet.size());
        for (Object object : categoriasListObjet) {
            categoriasList.add(Objects.toString(object, null));
        }
        return categoriasList;
    }

}
