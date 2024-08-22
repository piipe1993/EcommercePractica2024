package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class PaginaInicioUI extends PageObject {

    public static final Target LBL_COTIZAR = Target.the("Menu Cotizar").locatedBy("//*[@class='customcmslink d-flex flex-row'][child::p[contains(text(),'cotizar')]]");
    public static final Target LBL_ORDEN_RAPIDA = Target.the("Menu Orden Rapida").locatedBy("//*[@class='customcmslink d-flex flex-row'][child::p[contains(text(),'orden rápida')]]");
    public static final Target LBL_SEGUIMINETO_PEDIDOS= Target.the("Menu Seguimiento Pedidos").locatedBy("//*[@class='customcmslink d-flex flex-row'][child::p[contains(text(),'Seguimiento pedidos')]]");

    public static final Target POPUP_COOKIES = Target.the("PopUp Cookies").locatedBy("//div[@class='container'][ancestor::app-cutom-cookies]");
    public static final Target BTN_ACEPTAR_COOKIES = Target.the("Boton Aceptar Cookies").locatedBy("//span[contains(text(),'ACEPTAR COOKIES')][ancestor::app-cutom-cookies]");

    public static final Target POPUP_DESTINATARIO = Target.the("PopUp Destinatario").locatedBy("//app-dialog-nav-btn[@class='ng-star-inserted'][ancestor::div[@class='cdk-overlay-container']]");
    public static final Target INPUT_DESTINATARIO= Target.the("Input Destinatario").locatedBy("//input[@class='inputDialogDir ng-pristine ng-invalid ng-touched'][ancestor::div[@class='cdk-overlay-container']]");
    public static final Target LBL_DESTINATARIO= Target.the("Valor ID Destinatario").locatedBy("(//span[@class='txtRender'][ancestor::div[@class='cdk-overlay-container']])[1]");
    public static final Target BTN_SELECCIONAR_DESTINATARIO= Target.the("Boton Seleccionar Destinatario").locatedBy("//span[@class='btnDest'][ancestor::div[@class='cdk-overlay-container']]");

    public static final Target BTN_CERRAR_SESION= Target.the("Boton Cerrar Sesion").locatedBy("//a[contains(text(),' Cerrar Sesion ')]");
    public static final Target BTN_CONFIRMACION_CERRAR_SESION= Target.the("Boton Confirmacion Cerrar Sesion").locatedBy("//a[@class='yes-btn-dialog'][ancestor::app-dialog-logout]");

    public static final Target INPUT_BUSCADOR= Target.the("Input Buscador").locatedBy("//input[@aria-describedby='initialDescription'][not(ancestor::*[@class='header-container'])]");
    public static final Target BTN_PRODUCTO_BUSCADO= Target.the("Boton Producto Buscado").locatedBy("(//a[@role='option'][ancestor::ul[@aria-label='resultados de productos']][not(ancestor::*[@class='header-container'])])[1]");

    public static final Target BTN_LINEA_CREDITO= Target.the("Boton Linea Credito").locatedBy("//a[@type='button'][(descendant::p[contains(text(),'LÍNEA DE CRÉDITO')]) and not(ancestor::*[@class='header-container'])]");
    public static final Target BTN_MI_CUENTA= Target.the("Boton Mi Cuenta").locatedBy("(//a[@class='no-decoration ng-star-inserted'][descendant::p[contains(text(),'MI CUENTA')]])[2]");
    public static final Target BTN_FAVORITOS= Target.the("Boton Favoritos").locatedBy("//a[descendant::p[contains(text(),'FAVORITOS')]]");
    public static final Target LBL_LISTA_DE_DESEOS= Target.the("Label Lista de Deseos").locatedBy("//span[contains(text(),'LISTA DE DESEOS')][ancestor::main]");

    public static final Target BTNS_CARRUSEL_CATEGORIAS = Target.the("Botonones Carrusel Categorias").locatedBy("//*[contains(@class, 'swiper-slide ng-star-inserted') and @data-swiper-slide-index][ancestor::*[@class='Section3 has-components ng-star-inserted']]");
    public static final Target BTN_SIGUIENTE_CATEGORIAS = Target.the("Boton Siguiente Carrusel Categorias").locatedBy("//div[@class='swiper-button-next ng-star-inserted'][ancestor::*[@class='Section3 has-components ng-star-inserted']]");
    public static final Target CARRUSEL_CATEGORIAS = Target.the("Boton Carrusel Carrusel Categorias").locatedBy("//swiper[ancestor::*[@class='Section3 has-components ng-star-inserted']]");

    public static Target BTN_INDEX_ACTIVO_CATEGORIAS(int index) {
        return Target.the("Categoria Activa").locatedBy(" //a[(ancestor::div[(@data-swiper-slide-index='"+index+"') and (contains(@class, 'swiper-slide-active'))]) and (ancestor::*[@class='Section3 has-components ng-star-inserted'])]");
    }
    public static Target IMG_INDEX_ACTIVO_CATEGORIAS(int index) {
        return Target.the("Categoria Activa").locatedBy("//img[(ancestor::div[(@data-swiper-slide-index='"+index+"') and (contains(@class, 'swiper-slide-active'))]) and (ancestor::*[@class='Section3 has-components ng-star-inserted'])]");
    }
    public static Target LBL_CATEGORIA = Target.the("Label Categoria/Subcategoria").locatedBy("(//span[parent::*[@class='custom-breadcrumb__search-header ng-star-inserted']])[2]");


    public static final Target SCT_PRIMER_CARRUSEL = Target.the("Secccion Primer Carrusel ").locatedBy("//span[@class='DeseasTextoClass'][ancestor::*[@class='Section4 has-components ng-star-inserted']]");
    public static final Target BTNS_PRIMER_CARRUSEL = Target.the("Botones Primer Carrusel ").locatedBy("//*[contains(@class, 'swiper-slide ng-star-inserted') and @data-swiper-slide-index][ancestor::*[@class='Section4 has-components ng-star-inserted']]");
    public static final Target LBL_NOMBRE_PRODUCTO_ACTIVO_PRIMER_CARRUSEL = Target.the("LBL Nombre Producto Activo Primer Carrusel ").locatedBy("(//P[(ancestor::div[(contains(@class, 'swiper-slide-active'))])and (ancestor::*[@class='Section4 has-components ng-star-inserted'])])[1]");
    public static final Target LBL_SKU_PRODUCTO_ACTIVO_PRIMER_CARRUSEL = Target.the("LBL SKU Producto Activo Primer Carrusel").locatedBy("(//div[contains(text(),'SKU')][(ancestor::div[(contains(@class, 'swiper-slide-active'))])and (ancestor::*[@class='Section4 has-components ng-star-inserted'])])[1]");

    public static final Target PRIMER_CARRUSEL = Target.the("Primer Carrusel").locatedBy("//swiper[ancestor::*[@class='Section4 has-components ng-star-inserted']]");
    public static final Target BTN_SIGUIENTE_PRODUCTO_PRIMER_CARRUSEL = Target.the("Boton Siguiente Producto Primer Carrusel").locatedBy("//div[@class='swiper-button-next ng-star-inserted'][ancestor::*[@class='Section4 has-components ng-star-inserted']]");

    public static Target BTN_INDEX_ACTIVO_PRIMER_CARRUSEL(int index) {
        return Target.the("Producto Activo Primer Carrusel").locatedBy("//div[@class='d-flex justify-content-center'][(ancestor::div[(@data-swiper-slide-index='"+index+"') and (contains(@class, 'swiper-slide-active'))]) and (ancestor::*[@class='Section4 has-components ng-star-inserted'])]");
    }


    public static final Target SCT_SEGUNDO_CARRUSEL = Target.the("Secccion Segundo Carrusel ").locatedBy("//span[@class='DeseasTextoClass'][ancestor::*[@class='Section6 has-components ng-star-inserted']]");
    public static final Target BTNS_SEGUNDO_CARRUSEL = Target.the("Botones Segundo Carrusel ").locatedBy("//*[contains(@class, 'swiper-slide ng-star-inserted') and @data-swiper-slide-index][ancestor::*[@class='Section6 has-components ng-star-inserted']]");
    public static final Target LBL_NOMBRE_PRODUCTO_ACTIVO_SEGUNDO_CARRUSEL = Target.the("LBL Nombre Producto Activo Segundo Carrusel").locatedBy("(//P[(ancestor::div[(contains(@class, 'swiper-slide-active'))])and (ancestor::*[@class='Section6 has-components ng-star-inserted'])])[1]");
    public static final Target LBL_SKU_PRODUCTO_ACTIVO_SEGUNDO_CARRUSEL = Target.the("LBL SKU Producto Activo Segundo Carrusel").locatedBy("(//div[contains(text(),'SKU')][(ancestor::div[(contains(@class, 'swiper-slide-active'))])and (ancestor::*[@class='Section6 has-components ng-star-inserted'])])[1]");

    public static final Target SEGUNDO_CARRUSEL= Target.the("Segundo Carrusel ").locatedBy("//swiper[ancestor::*[@class='Section6 has-components ng-star-inserted']]");
    public static final Target BTN_SIGUIENTE_PRODUCTO_SEGUNDO_CARRUSEL = Target.the("Boton Siguiente Producto Segundo Carrusel").locatedBy("//div[@class='swiper-button-next ng-star-inserted'][ancestor::*[@class='Section6 has-components ng-star-inserted']]");


    public static Target BTN_INDEX_ACTIVO_SEGUNDO_CARRUSEL(int index) {
        return Target.the("Producto Activo Segundo Carrusel").locatedBy("//div[@class='d-flex justify-content-center'][(ancestor::div[(@data-swiper-slide-index='"+index+"') and (contains(@class, 'swiper-slide-active'))]) and (ancestor::*[@class='Section6 has-components ng-star-inserted'])]");
    }


    public static final Target BTNS_CARRUSEL_SEGMENTOS_MARCAS = Target.the("Botonones Carrusel Segmentos/Marcas").locatedBy("//*[contains(@class, 'swiper-slide ng-star-inserted') and @data-swiper-slide-index][ancestor::*[@class='Section7 has-components ng-star-inserted']]");
    public static final Target BTN_SIGUIENTE_SEGMENTO_MARCAS = Target.the("Boton Siguiente Segmentos/Marcas").locatedBy("//div[@class='swiper-button-next ng-star-inserted'][ancestor::*[@class='Section7 has-components ng-star-inserted']]");
    public static final Target CARRUSEL_SEGMENTOS_MARCAS = Target.the("Boton Carrusel Segmentos/Marcas").locatedBy("//swiper[ancestor::*[@class='Section7 has-components ng-star-inserted']]");

    public static Target BTN_INDEX_ACTIVO_SEGMENTO(int index) {
        return Target.the("Segmento/Marca Activo").locatedBy(" //div[@class='flex-colum ng-star-inserted'][(ancestor::div[(@data-swiper-slide-index='"+index+"') and (contains(@class, 'swiper-slide-active'))]) and (ancestor::*[@class='Section7 has-components ng-star-inserted'])]");
    }

    public static Target BTN_INDEX_ACTIVO_MARCA(int index) {
        return Target.the("Marca Activa").locatedBy(" //a[(ancestor::div[(@data-swiper-slide-index='"+index+"') and (contains(@class, 'swiper-slide-active'))]) and (ancestor::*[@class='Section7 has-components ng-star-inserted'])]");
    }
    public static Target IMG_INDEX_ACTIVO_MARCA(int index) {
        return Target.the("Marca Activa").locatedBy(" //img[(ancestor::div[(@data-swiper-slide-index='"+index+"') and (contains(@class, 'swiper-slide-active'))]) and (ancestor::*[@class='Section7 has-components ng-star-inserted'])]");
    }
    public static Target LBL_MARCA = Target.the("Label Marca").locatedBy("//span[ancestor::*[@class='Section3 has-components ng-star-inserted']]");

    public static Target LBL_SEGMENTO = Target.the("Label Segmento").locatedBy("(//span[parent::*[@class='custom-breadcrumb__search-header ng-star-inserted']])[2]");
    public static Target ICONO_MARCA = Target.the("Icono Marca").locatedBy("//div[@class='imgWrapper']");




    public static final Target LBL_NOMBRE_PRODUCTO = Target.the("Label Producto").locatedBy("//h1[(ancestor::*[@class='ng-star-inserted ProductDetailsPageTemplate'])]");
    public static final Target LBL_SKU_PRODUCTO = Target.the("Label SKU Producto").locatedBy("//h3[contains(text(),'SAP')][(ancestor::*[@class='ng-star-inserted ProductDetailsPageTemplate'])]");

}
