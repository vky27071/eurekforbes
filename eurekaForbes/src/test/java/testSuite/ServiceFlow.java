package testSuite;

import Managers.LoginManager;
import commonUtils.InitiateDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.util.Properties;

public class ServiceFlow {

    private FileInputStream environemnt;
    private Properties environemntData = new Properties();
    private FileInputStream locators;
    private Properties locatorsData = new Properties();

    private FileInputStream login;
    private Properties loginData = new Properties();

    String url;
    InitiateDriver initiateDriver= new InitiateDriver();

    WebDriver driver;
LoginManager loginManager= new LoginManager();


    @Parameters({"environment","device"})
    @BeforeClass
    public void setEnvironment(@Optional("qa")String environment,@Optional("desktop")String device) {
        try {
            driver=initiateDriver.initiateDriver("chrome");

            environemnt = new FileInputStream(System.getProperty("user.dir") + "/config/env_"+environment+".properties");
            environemntData.load(environemnt);
            locators = new FileInputStream(System.getProperty("user.dir") + "/locators/login/login_"+device+".properties");
            locatorsData.load(locators);
            login = new FileInputStream(System.getProperty("user.dir") + "/testData/loginTestData.properties");
            loginData.load(login);

            if(device.equals("desktop"))
            driver.manage().window().maximize();

        } catch (Exception e) {

        }
        url = environemntData.getProperty("url");

    }

    @Test
    public void checkServiceFlow() throws InterruptedException {

        driver.get(url);
        String loginIcon=locatorsData.getProperty("login_Icon");
        String userName_xpath=locatorsData.getProperty("enter_Mobile");
        String continue_xpath=locatorsData.getProperty("continue_btn");
        String password_xpath=locatorsData.getProperty("enter_otp");

        String userName_Value=loginData.getProperty("mobileNumber");
        String password_value=loginData.getProperty("otp");;

        System.out.println("loginIcon Xpath"+loginIcon);
        loginManager.login(driver,loginIcon,userName_xpath,password_xpath,userName_Value,password_value,continue_xpath);

    }

    @AfterClass
    public void closeDriver()
    {
        driver.quit();
    }




}
