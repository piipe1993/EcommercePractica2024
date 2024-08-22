package eliteprofessional.tasks;

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

import java.util.ArrayList;
import java.util.List;

import static eliteprofessional.userinterfaces.PaginaInicioUI.*;
import static eliteprofessional.userinterfaces.ProductosUI.LBL_SKU;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class FuncionamientoCarruselSegmentosTask implements Task {
        public static List<WebElementFacade> listaProductos=new ArrayList<>();
        public static int sizelistaProductos;
        public String  nombreSegmento;
        public WebElement paginaInicioButton;
        public static List<WebElementFacade> elementoCarruselSegmentos = new ArrayList<>();

        @Override
        public <T extends Actor > void performAs (T actor){
            actor.attemptsTo(WaitUntil.the(BTN_SIGUIENTE_SEGMENTO_MARCAS, isClickable()).forNoMoreThan(30).seconds());
            actor.attemptsTo(Scroll.to(BTN_SIGUIENTE_SEGMENTO_MARCAS).andAlignToBottom());
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
                            MoveMouse.to(CARRUSEL_SEGMENTOS_MARCAS)
                    );
                    if (BTN_INDEX_ACTIVO_SEGMENTO(i).resolveFor(actor).isClickable()) {
                        actor.attemptsTo(Click.on (BTN_INDEX_ACTIVO_SEGMENTO(i)));
                        clickSegmento = true;
                        secure=0;
                    }else {
                        actor.attemptsTo(
                                Click.on (BTN_SIGUIENTE_SEGMENTO_MARCAS),
                                MoveMouse.to(CARRUSEL_SEGMENTOS_MARCAS)
                        );
                    }

                    if (secure>((elementoCarruselSegmentos.size())*4)){
                        Serenity.recordReportData().withTitle("Existe un problemas con los botones de atras y/o adelante del Segundo carrusel por favor revisar" )
                                .andContents("Existe un problemas con los botones de atras y/o adelante del Segundo carrusel por favor revisar" );
                        Assert.fail ("Existe un problemas con los botones de atras y/o adelante del Segundo carrusel por favor revisar");

                    }
                }
                PaginaStateRedy.completed();
                Serenity.takeScreenshot();
                UtilsWaits.wait(5);
                actor.attemptsTo(WaitUntil.the(LBL_SEGMENTO, isEnabled()).forNoMoreThan(30).seconds());
                actor.attemptsTo(WaitUntil.the(LBL_SKU, isEnabled()).forNoMoreThan(30).seconds());
                nombreSegmento = (LBL_SEGMENTO.resolveFor(actor).getText()).trim();
                listaProductos= LBL_SKU.resolveAllFor(actor);
                sizelistaProductos=listaProductos.size();
                Serenity.recordReportData().withTitle(" Segmento Validado " + nombreSegmento+", han cargado "+(sizelistaProductos+1)+ "  Productos")
                .andContents(" Segmento Validado " + nombreSegmento+", han cargado "+(sizelistaProductos+1)+ "  Productos");
                UtilsWaits.wait(2);
                paginaInicioButton = (WebElement) jscriptExecutor.executeScript("return  document.querySelector(\"#cx-header > cx-page-layout.header > cx-page-slot.SiteLogo.has-components > cx-banner > cx-generic-link > a\")");
                paginaInicioButton.click();
                Serenity.takeScreenshot();
                actor.attemptsTo(
                        WaitUntil.the(PaginaInicioUI.BTNS_CARRUSEL_SEGMENTOS_MARCAS, isClickable()).forNoMoreThan(30).seconds()
                );
            }


        }


    public static Performable ir () {
        return Instrumented.instanceOf(FuncionamientoCarruselSegmentosTask.class).withProperties();
    }
}


