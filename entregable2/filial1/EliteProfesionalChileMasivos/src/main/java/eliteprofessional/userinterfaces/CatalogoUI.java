package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CatalogoUI extends PageObject {

    public static Target BTN_MENU(String menu){
        return Target.the("Boton Menu "+ menu).locatedBy("//a[contains(text(),'"+ menu +"')][ancestor::div[@class='menu']]");

    }
    public static Target BTN_SUBMENU(String subMenu,int i){
        return Target.the("Boton SubMenu "+ subMenu).locatedBy("(//span[contains(text(),'"+ subMenu+"')][ancestor::div[@class='menu']])["+i+"]");

    }

    public static Target LBL_SUBCATEGORIA (String subMenu){
        return Target.the("LBL SubCategoria "+ subMenu).locatedBy(" //span[contains(text(),'"+ subMenu+"')][(parent::div[@class='custom-breadcrumb__search-header ng-star-inserted'])and (ancestor::*[@class='BottomHeaderSlot has-components'])]");

    }




}
