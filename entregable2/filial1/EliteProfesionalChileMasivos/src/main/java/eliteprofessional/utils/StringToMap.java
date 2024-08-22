package eliteprofessional.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StringToMap {

    public static Map<String, List<String>> convertir (String cadena) {
        cadena=(cadena.replaceAll("\\s;",";"));
        cadena=(cadena.replaceAll(";\\s",";"));
        cadena=(cadena.replaceAll("\\s:",":"));
        cadena=(cadena.replaceAll(":\\s",":"));
        cadena=(cadena.replaceAll(":\\s",":"));
        String[] categories = cadena.split("Categoria:");
            Map<String, List<String>> map = new LinkedHashMap<>();
        for (int i = 1; i < categories.length; i++) {
                String[] parts = categories[i].split(";");
                String categoryName = parts[0].trim();
                List<String> items = new ArrayList<>();
                for (int j = 1; j < parts.length; j++) {
                    items.add(parts[j].trim());
                }
                map.put(categoryName, items);
        }

        return  map;
    }

}
