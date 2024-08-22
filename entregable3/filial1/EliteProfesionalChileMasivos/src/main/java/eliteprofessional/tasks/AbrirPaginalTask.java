package eliteprofessional.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.WindowType;
import static net.serenitybdd.core.Serenity.getDriver;


public class AbrirPaginalTask implements Task {

    String url;


    public AbrirPaginalTask(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        getDriver().switchTo().newWindow(WindowType.TAB);
        getDriver().navigate().to(url);

    }
    public static AbrirPaginalTask ir(String url) {
        return Instrumented.instanceOf(AbrirPaginalTask.class).withProperties(url);
    }

}