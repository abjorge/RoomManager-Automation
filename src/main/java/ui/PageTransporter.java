package ui;

import framework.DriverManager;
import org.openqa.selenium.WebDriver;
import ui.pages.LoginPage;
import utils.ConfigFileReader;
import utils.JSONReader;

/**
  * User: RonaldButron
 * Date: 12/03/15
 */
public class PageTransporter {

    private WebDriver driver = DriverManager.getInstance().getWebDriver();
    private JSONReader jsonReader = JSONReader.getInstance();
    private  String URLLogin = jsonReader.getAdminURL();
    private static PageTransporter instance;

    protected PageTransporter(){
            init();
    }

    public static PageTransporter getInstance(){
                if(instance == null){
                    instance = new PageTransporter();
                }
        return instance;
    }

    private void init(){

    }

    /**
     * This method navigate to the Login URL
     * @param URL
     */
    public void goToURL(String URL){
        driver.navigate().to(URL);
    }

    /**
     * This method obtain the current URL
     * @return a string with the URL
     */
    public String getCurrentURL(){

        return driver.getCurrentUrl();

    }

    /**
     * This method go to the Login Page
     * @return a new Login Page
     */
    public LoginPage toLoginPage(){

        goToURL(URLLogin);
        return new LoginPage();



    }

}
