package eliteprofessional.runners;


import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(features = "src/test/resources/features",
        tags = "@NuevaCotizacion",
        glue = "eliteprofessional.stepsDefinitions",
        snippets =  CucumberOptions.SnippetType.CAMELCASE)

public class R44_CotizacionesNuevaCotizacionRunner {

    @utils.BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        eliteprofessional.utils.DataToFeature.overrideFeatureFiles("./src/test/resources/features");
    }
}