package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RedesSocialesUI extends PageObject {

    public static final Target LINK_FACEBOOK= Target.the("Link Facebook").locatedBy("(//a[ancestor::*[@class='FooterRightC']])[1]");
    public static final String URL_FACEBOOK= "https://www.facebook.com/Softys.la?mibextid=LQQJ4d";


    public static final Target LINK_INSTAGRAM= Target.the("Link Instagram").locatedBy("(//a[ancestor::*[@class='FooterRightC']])[2]");
    public static final String URL_INSTAGRAM= "https://www.instagram.com/softys.la/?igshid=MzRlODBiNWFlZA%3D%3D";

    public static final Target LINK_YOUTUBE= Target.the("Link Instagram").locatedBy("(//a[ancestor::*[@class='FooterRightC']])[3]");
    public static final String URL_YOUTUBE= "https://www.youtube.com/@softys884";


    public static final Target LINK_LINKEDIN= Target.the("Link LinkedIn").locatedBy("(//a[ancestor::*[@class='FooterRightC']])[4]");
    public static final String URL_LINKEDIN= "https://www.linkedin.com/company/softys-la/";


}
