package eliteprofessional.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Marcas {

    NOBLE ("https://api.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/medias/logo-desktop-noble.png"),
    ELITE ("https://api.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/medias/logo-desktop-elite.png"),
    BABYSEC ("https://api.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/medias/logo-desktop-babysec.png"),
    NOVA ("https://api.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/medias/logo-desktop-nova.png"),
    CONFORT ("https://api.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/medias/logo-desktop-confort.png"),
    LADYSOFT ("https://api.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/medias/logo-desktop-ladysoft.png"),
    ABOLENGO ("https://api.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/medias/logo-desktop-abolengo.png"),
    COTIDIAN ("https://api.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/medias/logo-desktop-cotidian.png");
    private final String url;
    Marcas(final String url) { this.url=url;}

    public static Map<String, String>  imagenes(){
        Map<String, String> mapMarcas = new LinkedHashMap<>();
        for (Marcas marca:values()){
            mapMarcas.put(marca.name(), marca.url);
        }
        return mapMarcas;
    }
}
