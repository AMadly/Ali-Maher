package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private final WebDriver driver;

    //Set locators in page
    private By loginsuccesscheck = By.xpath("//button[@type='submit']");

    public SecureAreaPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public String GetSuccessLoginText()
    {
        return driver.findElement(loginsuccesscheck).getText();
    }
}
