package eliteprofessional.utils;

import org.assertj.core.util.Arrays;

import java.util.List;

public class TextoAList {

    public List<Object> convertir (String cadena) {
        cadena=(cadena.replaceAll("\\s",""));
        return Arrays.asList(cadena.split(";"));
    }

}
