package commonUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitiateDriver {

WebDriver driver;
    public WebDriver initiateDriver(String browser)
    {

        if (browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
             driver= new ChromeDriver();
             return driver;
        }

        return null;
    }

}
