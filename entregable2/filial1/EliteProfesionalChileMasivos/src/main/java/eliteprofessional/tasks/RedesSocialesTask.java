package eliteprofessional.tasks;


import eliteprofessional.utils.PaginaStateRedy;
import eliteprofessional.utils.UtilsWaits;
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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static eliteprofessional.userinterfaces.FooterUI.FOOTER;
import static eliteprofessional.userinterfaces.RedesSocialesUI.*;
import static eliteprofessional.userinterfaces.RedesSocialesUI.URL_YOUTUBE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class RedesSocialesTask implements Task {

    Map<Target, String> map = new LinkedHashMap<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        map.put(LINK_FACEBOOK, URL_FACEBOOK);
        map.put(LINK_INSTAGRAM, URL_INSTAGRAM);
        map.put(LINK_YOUTUBE, URL_YOUTUBE);
        map.put(LINK_LINKEDIN, URL_LINKEDIN);

        int i=0;
        int t=0;
        String currentURL = null;
        StringBuilder socialMediaFailure= new StringBuilder();
        for (Map.Entry<Target, String> entry : map.entrySet()) {
            Target key = entry.getKey();
            String value = entry.getValue();

            actor.attemptsTo(
                    WaitUntil.the(FOOTER, isVisible()).forNoMoreThan(30).seconds(),
                    Scroll.to(FOOTER).andAlignToBottom()
            );
            actor.attemptsTo(
                    WaitUntil.the(key, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(key)
            );
            UtilsWaits.wait(2);
            Set<String> windowHandles = getDriver().getWindowHandles();
            int j=0;
            while ((windowHandles.size()<i+1) & (j<10)){
                windowHandles = getDriver().getWindowHandles();
                j=j+1;
            }
            if (j >10) {
                Serenity.recordReportData().withTitle("Existe un problema en la pagina con el  link de   "+value )
                        .andContents("Existe un problema en la pagina con el  link de"+value);
                Assert.fail ("Existe un problema en la pagina con el  link de "+value );
            }
            getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[i+1].toString());
            i=i+1;
            PaginaStateRedy.completed();
            try {
                currentURL = getDriver().getCurrentUrl();
            }catch  (Exception e) {}
            Serenity.takeScreenshot();
            if(value.equals(currentURL)) {
                Serenity.recordReportData().withTitle("La Red Solcial " + value + " ha sido validada")
                        .andContents("La Red Solcial " + value + " ha sido validada");
            }else{
                t=t+1;
                socialMediaFailure.append(value).append(" - ");
            }
            UtilsWaits.wait(5);
            actor.attemptsTo(Switch.toWindowTitled("Elite"));

        }

        if (t>0) {
            Assert.fail ("Existen problemas al validar las redes Sociales "+ socialMediaFailure );
        }
    }



    public static Performable ir ( ){
        return Instrumented.instanceOf(RedesSocialesTask.class).withProperties();
    }
}