package eliteprofessional.runners;


import eliteprofessional.utils.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(features = "src/test/resources/features",
        tags = "@crearCotizacionCategoria",
        glue = "eliteprofessional.stepsDefinitions",
        snippets =  CucumberOptions.SnippetType.CAMELCASE)

public class R2_CotizacionCrearCotizacionCategoriaEliteRunner {
    @utils.BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features");
    }
}
