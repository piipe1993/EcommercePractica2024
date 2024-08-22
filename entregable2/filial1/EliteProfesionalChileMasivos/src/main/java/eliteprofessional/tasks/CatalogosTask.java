package eliteprofessional.tasks;


import eliteprofessional.utils.PaginaStateRedy;
import eliteprofessional.utils.UtilsWaits;
import eliteprofessional.utils.ValidarTextoEnPDF;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static eliteprofessional.userinterfaces.FooterUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class CatalogosTask implements Task {

    Map<Target, String> catalogos = new LinkedHashMap<>();
    public WebElement errorDialog,tittleDocument,pdfviewer;

    @Override
    public <T extends Actor> void performAs(T actor) {

        catalogos.put(LINK_CATALOGO_ELITE_PROFESIONAL, TITLE_ELITE_PROFESIONAL);
        int i=0;
        int t=0;
        String failureCatalaogos= "Catalogos : ";

        for (Map.Entry<Target, String> catalogo : catalogos.entrySet()) {
            Target key = catalogo.getKey();
            String value = catalogo.getValue();

            actor.attemptsTo(
                    WaitUntil.the(FOOTER, isVisible()).forNoMoreThan(30).seconds(),
                    Scroll.to(FOOTER).andAlignToBottom()
            );
            actor.attemptsTo(
                    WaitUntil.the(key, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(key)
            );
            Set<String> windowHandles = getDriver().getWindowHandles();
            int j=0;
            while ((windowHandles.size()<i+1) & (j<10)){
                windowHandles = getDriver().getWindowHandles();
                j=j+1;
            }
            if (j >10) {
                Serenity.recordReportData().withTitle("Existe un problema con el link del catalogo de  "+value )
                        .andContents("Existe un problema con el catalogo de  "+value);
                Assert.fail ("Existe un problema con el catalogo de  "+value );
            }
            getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[i+1].toString());
            PaginaStateRedy.completed();
            Serenity.takeScreenshot();
            UtilsWaits.wait(5);
           if(ValidarTextoEnPDF.validar(value)) {
                Serenity.recordReportData().withTitle("El catalogo de  " + value + " ha sido validada")
                        .andContents("El catalogo de  " + value + " ha sido validada");
            }else{
                t=t+1;
                failureCatalaogos= failureCatalaogos +value+" - ";

            }
            actor.attemptsTo(Switch.toWindowTitled("Elite"));
            i=+1;
        }


        if (t>0) {
            Assert.fail ("Existen problemas al validar los "+ failureCatalaogos );
        }


    }
    public static Performable ir ( ){
        return Instrumented.instanceOf(CatalogosTask.class).withProperties();
    }
}