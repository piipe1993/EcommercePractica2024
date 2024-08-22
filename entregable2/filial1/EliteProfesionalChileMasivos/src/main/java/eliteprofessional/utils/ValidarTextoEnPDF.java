package eliteprofessional.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.net.URL;
import java.text.Normalizer;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ValidarTextoEnPDF {

    public static boolean  validar(String value) {
        boolean validation=false;
        try {
            String currentURL = getDriver().getCurrentUrl();
            URL url = new URL(currentURL);
            PDDocument document = PDDocument.load(url.openStream());
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String pdfText = Normalizer.normalize(pdfStripper.getText(document),Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase();
            String NormalizeValue = Normalizer.normalize(value,Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase();
            validation=pdfText.contains(NormalizeValue);

        }catch (IOException e) {}
        return (validation);
    }



}
