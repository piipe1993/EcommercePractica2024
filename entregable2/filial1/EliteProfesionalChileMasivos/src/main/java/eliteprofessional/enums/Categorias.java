package eliteprofessional.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Categorias {

    Higiene ("https://api.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/medias/categoria-higiene-carousel.png"),
    Papeles ("https://api.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/medias/categoria-papeles-carousel.png"),
    Adultos ("https://api.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/medias/categoria-proteccionAdulto-carousel.png"),
    Femenina ("https://api.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/medias/categoria-proteccionFemenina-carousel.png"),
    Bebé ("https://api.cwgpxw02kj-empresasc1-s1-public.model-t.cc.commerce.ondemand.com/medias/categoria-cuidadoBebe-carousel.png");

    private final String url;
    Categorias(final String url) { this.url=url;}

    public static Map<String, String>  imagenes(){
        Map<String, String> mapMCategorias = new LinkedHashMap<>();
        for (Categorias categoria:values()){
            mapMCategorias.put(categoria.name(), categoria.url);
        }
        return mapMCategorias;
    }
}
