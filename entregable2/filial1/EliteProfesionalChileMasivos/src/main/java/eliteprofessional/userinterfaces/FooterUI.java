package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.By;

public class FooterUI extends PageObject {

    public static final Target FOOTER = Target.the("Seccion Footer").locatedBy("//footer");
    public static final Target LINK_QUIENES_SOMOS= Target.the("Link Quienes Somos").locatedBy("//a[contains(text(), 'Quiénes Somos')]");
    public static final Target LINK_SERVICIO_DE_ATENCION = Target.the("Link Servicio de Atencion").locatedBy("//a[ancestor::*[(contains(@data-test, 'Aten'))]]");
    public static final Target LINK_CERTIFICACIONES = Target.the("Link Certificaciones").locatedBy("//a[ancestor::*[(contains(@data-test, 'Certifica'))]]");

    public static final Target LINK_NOVEDADES= Target.the("Link Novedades").locatedBy("//a[ancestor::*[(contains(@data-test, 'Nov'))]]");
    public static final Target LINK_CATALOGO_ELITE_PROFESIONAL = Target.the("Link Catalogo Elite Profesional").locatedBy("//a[ancestor::*[(contains(@data-test, 'Elite Profissional'))]]");
    public static final Target LINK_TERMINOS_Y_CONDICIONES = Target.the("Link Terminos y Condiciones").locatedBy("//a[contains(text(), 'Términos y condiciones')]");
    public static final Target LINK_POLITICA_DE_PROTECCION_DE_DATOS = Target.the("Link Proteccion de Datos Personales").locatedBy("//a[ancestor::*[(contains(@data-test, 'Política de Prot'))]]");
    public static final String  TITLE_ELITE_PROFESIONAL= "Elite Profesional";
    public static final Target LINK_POLITICA_DE_COOKIES = Target.the("Link Politica de Cookies").locatedBy("//a[contains(text(), 'Política de Cookies')]");
    public static final Target BTN_POLITICA_DE_COOKIES = Target.the("BTN Politica de Cookies").locatedBy("//span[@class='politicsDownloadText']");

    public static final By TITLE_DOCUMENT_POLITICA_DE_COOKIES = ByShadow.cssSelector("#titlle","#shadow-host", "#nested-shadow-host");

    public static final Target LINK_CENTRO_DE_AYUDA = Target.the("Link Centro de Ayuda").locatedBy("//a[ancestor::*[(contains(@data-test, 'Centro de'))]]");

    public static final Target BTN_PREGUNTAS= Target.the(" Pregunta ").locatedBy("//mat-expansion-panel-header[@role='button']");


    public static Target LBL_VALIDACION (String label,String loaclizador) {
        return Target.the("Validacion del Titulo "+label).locatedBy("//*[(contains(@class, 'title')) and (contains(text(),'"+loaclizador+"')) ]");
    }

    public static Target LBL_VALIDACION_TITLE (String label,String loaclizador) {
        return Target.the("Validacion del Titulo "+label).locatedBy("//*[(contains(text(),'"+loaclizador+"'))][ancestor::*[(contains(@class, 'title'))]]");
    }

    public static Target LBL_VALIDACION_TITLE_STRONG (String label,String loaclizador) {
        return Target.the("Validacion del Titulo "+label).locatedBy("//*[(contains(text(),'"+loaclizador+"'))][ancestor::*[(contains(@class, 'title')) or (contains(@class, 'Title')) ]]");
    }
}
