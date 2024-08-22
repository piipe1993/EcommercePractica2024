package eliteprofessional.tasks;

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

import java.util.ArrayList;
import java.util.List;

import static eliteprofessional.userinterfaces.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class FuncionamientoSegundoCarruselTask implements Task {

        public final String SKU;
        TextoAList textoALista= new TextoAList();
        public String SKUProductoActivo, nombreProductoActivo,nombreProducto, SKUProducto;
        public WebElement paginaInicioButton;
        public static List<WebElementFacade> ProductosSegundoCarrusel, segundoCarrusel = new ArrayList<>();

        public FuncionamientoSegundoCarruselTask(String SKU) {this.SKU = SKU; }

    @Override
        public <T extends Actor > void performAs (T actor){
            List<String> listSKU = textoALista.convertir(SKU);
            actor.attemptsTo(WaitUntil.the(BTN_SIGUIENTE_PRODUCTO_SEGUNDO_CARRUSEL, isClickable()).forNoMoreThan(30).seconds());
            actor.attemptsTo(Scroll.to(BTN_SIGUIENTE_PRODUCTO_SEGUNDO_CARRUSEL).andAlignToBottom());
            JavascriptExecutor jscriptExecutor = (JavascriptExecutor) ThucydidesWebDriverSupport.getDriver();
            PaginaStateRedy.completed();
            UtilsWaits.wait(5);
            ProductosSegundoCarrusel = BTNS_SEGUNDO_CARRUSEL.resolveAllFor(actor);

            //Inicio Validacion Productos Carrusel- Martha De la Ossa
            segundoCarrusel=SEGUNDO_CARRUSEL.resolveAllFor(actor);
            if( segundoCarrusel.size()>1){
                Serenity.recordReportData().withTitle("Existen "+ segundoCarrusel.size()+" carruseles en esta seccion:Nuevos Lanzamientos, por favor revisar" )
                        .andContents("Existen "+ segundoCarrusel.size()+" carruseles en esta seccion:Nuevos Lanzamientos, por favor revisar" );
                Assert.fail ("Existen "+ segundoCarrusel.size()+" carruseles en esta seccion:Nuevos Lanzamientos, por favor revisar");

            }

            //Inicio Validacion Productos Carrusel- Martha De la Ossa

            for (int i = 0; i < (ProductosSegundoCarrusel.size()); i++) {
                boolean clickProducto = false;
                int secure=0;
                while ((!clickProducto)) {
                    secure=secure+1;
                    actor.attemptsTo(
                            MoveMouse.to(BTN_SIGUIENTE_PRODUCTO_SEGUNDO_CARRUSEL)
                    );

                    if (BTN_INDEX_ACTIVO_SEGUNDO_CARRUSEL(i).resolveFor(actor).isClickable()) {
                        nombreProductoActivo= (LBL_NOMBRE_PRODUCTO_ACTIVO_SEGUNDO_CARRUSEL.resolveFor(actor).getText()).trim();
                        SKUProductoActivo=(LBL_SKU_PRODUCTO_ACTIVO_SEGUNDO_CARRUSEL.resolveFor(actor).getText()).replaceAll("SKU:","").trim();
                        if (listSKU.contains(SKUProductoActivo)){
                            listSKU.remove(listSKU.indexOf(SKUProductoActivo));
                        }
                        actor.attemptsTo(Click.on (BTN_INDEX_ACTIVO_SEGUNDO_CARRUSEL(i)));
                        clickProducto = true;
                        secure=0;
                    }else{
                        actor.attemptsTo(
                                Click.on (BTN_SIGUIENTE_PRODUCTO_SEGUNDO_CARRUSEL),
                                MoveMouse.to(BTN_SIGUIENTE_PRODUCTO_SEGUNDO_CARRUSEL)
                        );
                    }

                    if (secure>((ProductosSegundoCarrusel.size())*6)){
                        Serenity.recordReportData().withTitle("Existe un problemas con los botones de atras y/o adelante del Segundo carrusel por favor revisar" )
                                .andContents("Existe un problemas con los botones de atras y/o adelante del Segundo carrusel por favor revisar" );
                        Assert.fail ("Existe un problemas con los botones de atras y/o adelante del Segundo carrusel por favor revisar");

                    }
                }
                PaginaStateRedy.completed();
                Serenity.takeScreenshot();
                UtilsWaits.wait(5);
                actor.attemptsTo(WaitUntil.the(LBL_SKU_PRODUCTO, isEnabled()).forNoMoreThan(30).seconds());
                nombreProducto = (LBL_NOMBRE_PRODUCTO.resolveFor(actor).getText()).trim();
                SKUProducto=(LBL_SKU_PRODUCTO.resolveFor(actor).getText()).replaceAll("SAP:","").trim();
                if (SKUProducto.equalsIgnoreCase(SKUProductoActivo)) {
                    Serenity.recordReportData().withTitle("Producto Validado, "+nombreProductoActivo+" con SKU: " + SKUProductoActivo)
                            .andContents("Producto Validado, "+nombreProductoActivo+" con SKU: " + SKUProductoActivo);
                }else{
                    Serenity.recordReportData().withTitle(" El Producto con SKU: " + SKUProductoActivo+" no corresponde con el producto con SKU clickeado: "+ SKUProducto)
                            .andContents("El Producto con SKU: " + SKUProductoActivo+" no corresponde con el producto con SKU clickeado: "+ SKUProducto);
                    Assert.fail ("El Producto con SKU: " + SKUProductoActivo+" no corresponde con el producto con SKU clickeado: "+ SKUProducto);

                }
                UtilsWaits.wait(3);
                paginaInicioButton = (WebElement) jscriptExecutor.executeScript("return  document.querySelector(\"#cx-header > cx-page-layout.header > cx-page-slot.SiteLogo.has-components > cx-banner > cx-generic-link > a\")");
                paginaInicioButton.click();
                Serenity.takeScreenshot();
                actor.attemptsTo(
                        WaitUntil.the(PaginaInicioUI.BTN_SIGUIENTE_PRODUCTO_SEGUNDO_CARRUSEL, isClickable()).forNoMoreThan(30).seconds()
                );
            }

        if(listSKU.size()==0){
            Serenity.recordReportData().withTitle("Se ha Validado correctamente todo los SKU " )
                    .andContents("Se ha Validado correctamente todo los SKU " );


        }else{

            for (int i = 0; i < (listSKU.size()+1); i++) {
                Serenity.recordReportData().withTitle("No Se encuentra algunos SKU " )
                        .andContents("No Se ha en contrado el producto con SKU: "+ listSKU.get(i));
            }
            Assert.fail ("No Se encuentra algunos SKU");


        }

        }


    public static Performable ir (String SKU) {
        return Instrumented.instanceOf(FuncionamientoSegundoCarruselTask.class).withProperties(SKU);
    }
}


