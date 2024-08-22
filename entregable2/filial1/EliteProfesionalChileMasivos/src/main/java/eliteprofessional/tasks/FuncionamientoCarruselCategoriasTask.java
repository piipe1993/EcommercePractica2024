package eliteprofessional.tasks;

import eliteprofessional.enums.Categorias;
import eliteprofessional.userinterfaces.PaginaInicioUI;
import eliteprofessional.utils.PaginaStateRedy;
import eliteprofessional.utils.TextoAList;
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
import static eliteprofessional.userinterfaces.ProductosUI.LBL_SKU;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;


public class FuncionamientoCarruselCategoriasTask implements Task {
    Map<String, String> mapCategorias = new LinkedHashMap<>();
    Optional<String> OpCategorias;
    public static List<WebElementFacade>  imgElement= new ArrayList<>();
    public static List<WebElementFacade> listaProductos=new ArrayList<>();
    public static int sizelistaProductos;
    public WebElement paginaInicioButton ;
    String categorias, nombreCategoria;
    public static List<WebElementFacade> botonesCarruselCategorias=new ArrayList<>();
    public FuncionamientoCarruselCategoriasTask(String categorias) {
        this.categorias = categorias;
    }

    @Override
    public <T extends Actor > void performAs (T actor){
        mapCategorias= Categorias.imagenes();
        actor.attemptsTo(WaitUntil.the(PaginaInicioUI.BTN_SIGUIENTE_CATEGORIAS, isClickable()).forNoMoreThan(30).seconds());
        actor.attemptsTo(Scroll.to(PaginaInicioUI.BTN_SIGUIENTE_CATEGORIAS).andAlignToBottom());
        JavascriptExecutor jscriptExecutor = (JavascriptExecutor) ThucydidesWebDriverSupport.getDriver();
        PaginaStateRedy.completed();
        UtilsWaits.wait(5);
        botonesCarruselCategorias = PaginaInicioUI.BTNS_CARRUSEL_CATEGORIAS.resolveAllFor(actor);
        //Inicio Validacion Productos Carrusel- Martha De la Ossa
        List<String> categoriasList = TextoAList.convertir(categorias);
        for (int i = 0; i < (botonesCarruselCategorias.size()); i++) {
            boolean clickSegmento = false;
            int secure=0;
            while ((!clickSegmento)) {
                secure=secure+1;
                actor.attemptsTo(
                        MoveMouse.to(BTN_SIGUIENTE_CATEGORIAS)
                );
                if (BTN_INDEX_ACTIVO_CATEGORIAS (i).resolveFor(actor).isClickable()) {
                    imgElement=IMG_INDEX_ACTIVO_CATEGORIAS(i).resolveAllFor(actor);
                    String srcValue = imgElement.get(0).getElement().getAttribute("src");
                    String[] partSrcValue = srcValue.split("\\?");
                    srcValue=partSrcValue[0];
                    if (mapCategorias.containsValue(srcValue)){
                        String finalSrcValue = srcValue;
                        OpCategorias = mapCategorias.entrySet().stream()
                                .filter(entry -> entry.getValue().equals(finalSrcValue))
                                .map(Map.Entry::getKey)
                                .findFirst();
                        mapCategorias.remove(OpCategorias.get());
                    }
                    actor.attemptsTo(Click.on (BTN_INDEX_ACTIVO_CATEGORIAS (i)));
                    clickSegmento = true;
                    secure=0;
                }else {
                    actor.attemptsTo(
                            Click.on (BTN_SIGUIENTE_CATEGORIAS),
                            MoveMouse.to(CARRUSEL_CATEGORIAS)
                    );
                }

                if (secure>((botonesCarruselCategorias.size())*4)){
                    Serenity.recordReportData().withTitle("Existe un problemas con los botones de atras y/o adelante del Carrusel Categorias por favor revisar" )
                            .andContents("Existe un problemas con los botones de atras y/o adelante del del Carrusel Categorias  por favor revisar" );
                    Assert.fail ("Existe un problemas con los botones de atras y/o adelante del del Carrusel Categorias  por favor revisar");

                }
            }
            PaginaStateRedy.completed();
            Serenity.takeScreenshot();
            UtilsWaits.wait(5);
            actor.attemptsTo(WaitUntil.the(LBL_CATEGORIA, isEnabled()).forNoMoreThan(30).seconds());
            actor.attemptsTo(WaitUntil.the(LBL_SKU, isEnabled()).forNoMoreThan(30).seconds());
            nombreCategoria = (LBL_CATEGORIA.resolveFor(actor).getText()).trim();
            listaProductos= LBL_SKU.resolveAllFor(actor);
            sizelistaProductos=listaProductos.size();
            if (((nombreCategoria.toLowerCase()).contains(OpCategorias.get().toLowerCase()))){
                Serenity.recordReportData().withTitle(" Categoria Validada " + nombreCategoria+", han cargado "+(sizelistaProductos+1)+ "  Productos")
                        .andContents(" Categoria Validada "+ nombreCategoria+", han cargado "+(sizelistaProductos+1)+ "  Productos");
            }else{
                Serenity.recordReportData().withTitle(" Categoria No Validada " + nombreCategoria)
                        .andContents(" Categoria No Validada "+ nombreCategoria);
                Assert.fail ("");

            }

            UtilsWaits.wait(2);
            paginaInicioButton = (WebElement) jscriptExecutor.executeScript("return  document.querySelector(\"#cx-header > cx-page-layout.header > cx-page-slot.SiteLogo.has-components > cx-banner > cx-generic-link > a\")");
            paginaInicioButton.click();
            Serenity.takeScreenshot();
            actor.attemptsTo(
                    WaitUntil.the(BTN_SIGUIENTE_CATEGORIAS, isClickable()).forNoMoreThan(30).seconds()
            );
        }

        if(mapCategorias.size()==0){
            Serenity.recordReportData().withTitle("Se ha Validado correctamente todas las categorias " )
                    .andContents("Se ha Validado correctamente todas las categorias" );


        }else{

            for (int i = 0; i < (mapCategorias.size()+1); i++) {
                Serenity.recordReportData().withTitle("No Se encuentra algunas categorias" )
                        .andContents("No Se encuentra algunas categorias"+ mapCategorias.get(i));
            }
            Assert.fail ("No Se encuentra algunas categorias");


        }

    }

    public static Performable ir (String categorias) {
        return Instrumented.instanceOf(FuncionamientoCarruselCategoriasTask.class).withProperties(categorias);
    }
}


