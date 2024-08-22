package eliteprofessional.tasks;

import eliteprofessional.enums.Marcas;
import eliteprofessional.userinterfaces.PaginaInicioUI;
import eliteprofessional.utils.PaginaStateRedy;
import eliteprofessional.utils.UtilsWaits;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.*;

import static eliteprofessional.userinterfaces.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class FuncionamientoCarruselMarcasTask implements Task {



    // Obtiene el valor del atributo src

    Map<String, String> mapMarcas = new LinkedHashMap<>();
    Optional<String> marca;
    public WebElement paginaInicioButton;
    public static List<WebElementFacade>  imgElement= new ArrayList<>();
    public static List<WebElementFacade> elementoCarruselSegmentos = new ArrayList<>();

        @Override
        public <T extends Actor > void performAs (T actor){
            mapMarcas= Marcas.imagenes();
            actor.attemptsTo(WaitUntil.the(BTN_SIGUIENTE_SEGMENTO_MARCAS, isClickable()).forNoMoreThan(30).seconds());
            actor.attemptsTo(Scroll.to(PaginaInicioUI.BTN_SIGUIENTE_SEGMENTO_MARCAS).andAlignToBottom());
            JavascriptExecutor jscriptExecutor = (JavascriptExecutor) ThucydidesWebDriverSupport.getDriver();
            PaginaStateRedy.completed();
            UtilsWaits.wait(5);
            elementoCarruselSegmentos = BTNS_CARRUSEL_SEGMENTOS_MARCAS.resolveAllFor(actor);

            //Inicio Validacion Productos Carrusel- Martha De la Ossa

            for (int i = 0; i < (elementoCarruselSegmentos.size()); i++) {
                boolean clickSegmento = false;
                int secure=0;
                while ((!clickSegmento)) {
                    secure=secure+1;
                    actor.attemptsTo(
                            MoveMouse.to(BTN_SIGUIENTE_SEGMENTO_MARCAS)
                    );
                    if (BTN_INDEX_ACTIVO_MARCA(i).resolveFor(actor).isClickable()) {
                        imgElement=IMG_INDEX_ACTIVO_MARCA(i).resolveAllFor(actor);
                        String srcValue = imgElement.get(0).getElement().getAttribute("src");
                        String[] partSrcValue = srcValue.split("\\?");
                        srcValue=partSrcValue[0];
                        if (mapMarcas.containsValue(srcValue)){
                            String finalSrcValue = srcValue;
                            marca = mapMarcas.entrySet().stream()
                                    .filter(entry -> entry.getValue().equals(finalSrcValue))
                                    .map(Map.Entry::getKey)
                                    .findFirst();
                            mapMarcas.remove(marca.get());
                        }
                        actor.attemptsTo(Click.on (BTN_INDEX_ACTIVO_MARCA(i)));
                        clickSegmento = true;
                        secure=0;
                    }else {
                        actor.attemptsTo(
                                Click.on (BTN_SIGUIENTE_SEGMENTO_MARCAS)
                        );
                    }

                    if (secure>((elementoCarruselSegmentos.size())*4)){
                        Serenity.recordReportData().withTitle("Existe un problemas con los botones de atras y/o adelante del carrusel Marcas" )
                                .andContents("Existe un problemas con los botones de atras y/o adelante del carrusel Marcas" );
                        Assert.fail ("Existe un problemas con los botones de atras y/o adelante del carrusel Marcas");

                    }
                }

                PaginaStateRedy.completed();
                Serenity.takeScreenshot();
                UtilsWaits.wait(5);
                String  tituloLandingPageMarca = (LBL_MARCA.resolveFor(actor).getText()).trim();
                if ((tituloLandingPageMarca.toLowerCase()).contains(marca.get().toLowerCase())){
                    Serenity.recordReportData().withTitle(" Marca Validada " + marca.get())
                            .andContents(" Marca Validada "+ marca.get());
                }else{
                    Serenity.recordReportData().withTitle(" Marca No Validada " + marca.get())
                            .andContents(" Marca No Validada "+ marca.get());
                    Assert.fail ("");

                }

                UtilsWaits.wait(2);
                paginaInicioButton = (WebElement) jscriptExecutor.executeScript("return  document.querySelector(\"#cx-header > cx-page-layout.header > cx-page-slot.SiteLogo.has-components > cx-banner > cx-generic-link > a\")");
                paginaInicioButton.click();
                Serenity.takeScreenshot();
                actor.attemptsTo(
                        WaitUntil.the(PaginaInicioUI.BTN_SIGUIENTE_SEGMENTO_MARCAS, isClickable()).forNoMoreThan(30).seconds()
                );
            }


            if(mapMarcas.size()==0){
                Serenity.recordReportData().withTitle("Se ha Validado correctamente todas las Marcas " )
                        .andContents("Se ha Validado correctamente todas las Marcas" );


            }else{

                for (int i = 0; i < (mapMarcas.size()+1); i++) {
                    Serenity.recordReportData().withTitle("No Se encuentra algunas Marcas " )
                            .andContents("No Se ha en contrado la marca "+ mapMarcas.get(i));
                }
                Assert.fail ("No Se encuentra algunos SKU");


            }
        }


    public static Performable ir () {
        return Instrumented.instanceOf(FuncionamientoCarruselMarcasTask.class).withProperties();
    }
}


