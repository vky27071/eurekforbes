package Managers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginManager {

    WebDriver driver;

public void login(WebDriver driver,String clickLogin_xpath,String userName_xpath,String password_xpath,String userName_Value,String password_value,String continue_xpath) throws InterruptedException {

    driver.findElement(By.xpath(clickLogin_xpath)).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(userName_xpath)).sendKeys(userName_Value);
    driver.findElement(By.xpath(continue_xpath)).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(password_xpath)).sendKeys(password_value);
}

}
