package eliteprofessional.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CatalogoUI extends PageObject {

    public static final Target BTN_MIS_PPODUCTOS = Target.the("Boton Menu MIS PRODUCTOS").locatedBy("//span[contains(text(),'MIS PRODUCTOS')][ancestor::div[@class='menu']]");
    public static final Target BTN_PAPELES = Target.the("Boton Menu Papepeles").locatedBy("//a[contains(text(),'Papeles')][ancestor::div[@class='menu']]");
    public static final Target BTN_CUIDADO_BEBE = Target.the("Boton Menu Cuidado Bebe").locatedBy("//a[contains(text(),'Cuidado Bebé')][ancestor::div[@class='menu']]");
    public static final Target BTN_HIGIENE = Target.the("Boton Menu Higiene").locatedBy("//a[contains(text(),'Higiene')][ancestor::div[@class='menu']]");
    public static final Target BTN_PROTECCCION_ADULTOS = Target.the("Boton Menu Proteccion Adultos").locatedBy("//a[contains(text(),'Protección Adultos')][ancestor::div[@class='menu']]");
    public static final Target BTN_PROTECCION_FEMENINA = Target.the("Boton Menu Proteccion Femenina").locatedBy("//a[contains(text(),'Protección Femenina')][ancestor::div[@class='menu']]");
    public static final Target BTN_MARCAS = Target.the("Boton Menu Marcas").locatedBy("//span[contains(text(),'Marcas')][ancestor::div[@class='menu']]");

    public static Target BTN_MENU(String menu){
        return Target.the("Boton Menu "+ menu).locatedBy("//a[contains(text(),'"+ menu +"')][ancestor::div[@class='menu']]");

    }

    public static Target BTN_SUBMENU(String subMenu,int i){
        return Target.the("Boton SubMenu "+ subMenu).locatedBy("(//span[contains(text(),'"+ subMenu+"')][ancestor::div[@class='menu']])["+i+"]");

    }


    public static final Target BTN_PANHUELOS_DESECHABLES = Target.the("Boton SubMenu Pañuelos Desechables").locatedBy("//span[contains(text(),'Pañuelos Desechables')][ancestor::div[@class='menu']]");
    public static final Target BTN_PAPEL_HIGIENICO = Target.the("Boton SubMenu Papel Higienico").locatedBy("//span[contains(text(),'Papel Higiénico')][ancestor::div[@class='menu']]");
    public static final Target BTN_SERVILLETAS = Target.the("Boton SubMenu Servilletas").locatedBy("//span[contains(text(),'Servilletas')][ancestor::div[@class='menu']]");
    public static final Target BTN_TOALLAS_PAPEL = Target.the("Boton SubMenu Toallas Papel").locatedBy("//span[contains(text(),'Toallas papel')][ancestor::div[@class='menu']]");
    public static final Target BTN_TRAPERO_HUMEDO = Target.the("Boton SubMenu Trapero Humedo").locatedBy("//span[contains(text(),'Trapero Humedo')][ancestor::div[@class='menu']]");
    public static final Target BTN_WIPES = Target.the("Boton SubMenu Wipes").locatedBy("//span[contains(text(),'Wipes')][ancestor::div[@class='menu']]");

    public static final Target BTN_PANHALES_BEBES = Target.the("Boton SubMenu Pañales").locatedBy("(//span[contains(text(),' Pañales')][ancestor::div[@class='menu']])[1]");
    public static final Target BTN_TOALLAS_HUMEDAS = Target.the("Boton SubMenu Toallas Humedas").locatedBy("//span[contains(text(),'Toallas húmedas')][ancestor::div[@class='menu']]");

    public static final Target BTN_ALCOHOL_GEL = Target.the("Boton SubMenu Alcohol Gel").locatedBy("//span[contains(text(),' Alcohol Gel')][ancestor::div[@class='menu']]");
    public static final Target BTN_JABON_BARRA= Target.the("Boton SubMenu Jabon Barra").locatedBy("//span[contains(text(),'Jabón Barra')][ancestor::div[@class='menu']]");
    public static final Target BTN_JABON_LIQUIDO= Target.the("Boton SubMenu Jabon Liquido").locatedBy("//span[contains(text(),' Jabon Líquido')][ancestor::div[@class='menu']]");



    public static final Target BTN_APOSITOS = Target.the("Boton SubMenu Apositos").locatedBy("//span[contains(text(),' Apositos')][ancestor::div[@class='menu']]");
    public static final Target BTN_PANTS = Target.the("Boton SubMenu Pants").locatedBy("//span[contains(text(),'Pants')][ancestor::div[@class='menu']]");
    public static final Target BTN_SABANILLAS_TOALLAS_HUMEDAS= Target.the("Boton SubMenu Sabanillas y Toallas Humedas").locatedBy("(//span[contains(text(),' Pañales')][ancestor::div[@class='menu']])[2]");
    public static final Target BTN_TOALLAS_INCONTINENCIA_URINARIA = Target.the("Boton SubMenu Toallas para Incontinencia Urinaria").locatedBy("//span[contains(text(),' Toallas para Incontinencia Urinaria')][ancestor::div[@class='menu']]");

    public static final Target BTN_PROTECTORES_DIARIOS= Target.the("Boton SubMenu Protectores Diarios").locatedBy("//span[contains(text(),'Protectores Diarios')][ancestor::div[@class='menu']]");
    public static final Target BTN_TAMPONES = Target.the("Boton SubMenu Tampones").locatedBy("//span[contains(text(),'Tampones')][ancestor::div[@class='menu']]");
    public static final Target BTN_TOALLAS_HIGIENICAS= Target.the("Boton SubMenu Toallas Higienicas").locatedBy("//span[contains(text(),'Toallas Higiénicas')][ancestor::div[@class='menu']]");


    public static final Target BTN_ELITE = Target.the("Boton SubMenu Marcas Elite").locatedBy("//div[child::img[@src='/assets/imgs/categorias/logo-desktop-elite.png']]");
    public static final Target BTN_BABYSEC = Target.the("Boton SubMenu Marcas Baby Sec").locatedBy("//div[child::img[@src='/assets/imgs/categorias/logo-desktop-babysec.png']]");
    public static final Target BTN_NOVA = Target.the("Boton SubMenu Marcas Nova").locatedBy("//div[child::img[@src='/assets/imgs/categorias/logo-desktop-nova.png']]");
    public static final Target BTN_COMFORT = Target.the("Boton SubMenu Confort").locatedBy("//div[child::img[@src='/assets/imgs/categorias/logo-desktop-confort.png']]");
    public static final Target BTN_LADYSOFT = Target.the("Boton SubMenu Marcas Lady Soft").locatedBy("//div[child::img[@src='/assets/imgs/categorias/logo-desktop-ladysoft.png']]");
    public static final Target BTN_ABOLENGO = Target.the("Boton SubMenu Marcas Abolengo").locatedBy("//div[child::img[@src='/assets/imgs/categorias/logo-desktop-abolengo.png']]]");
    public static final Target BTN_COTIDIAN = Target.the("Boton SubMenu Marcas Cotidian").locatedBy("//div[child::img[@src='/assets/imgs/categorias/logo-desktop-cotidian.png']]");
    public static final Target BTN_NOBLE = Target.the("Boton SubMenu Marcas Noble").locatedBy("//div[child::img[@src='/assets/imgs/categorias/logo-desktop-noble.png']]");



}
