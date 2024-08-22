package eliteprofessional.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class PaginaStateRedy {

    public static ExpectedCondition<Boolean> completed() {
        return driver -> {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
            return (Boolean) jsExecutor.executeScript("return document.readyState").equals("complete");
        };}

}
