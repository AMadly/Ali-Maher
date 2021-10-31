package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    public final WebDriver driver;

    //set locators in the page
    public By emailfield = By.id("email");

    public By passwordfield = By.id("pass");

    public By button_login = By.id("loginbutton");

    public By ErrorEmailLogin = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/form/div/div[1]/div[2]");
    
    public By ErrorPassLogin = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/form/div/div[2]/div[2]");
    
    private By loginsuccesscheck = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void SetUsername(String username)
    {
        driver.findElement(emailfield).clear();
        driver.findElement(emailfield).sendKeys(username);
    }
    public void SetPassword(String password)
    {
        driver.findElement(passwordfield).clear();
        driver.findElement(passwordfield).sendKeys(password);
    }
    public void ClickSubmitButton()
    {
        driver.findElement(button_login).click();
        //return new (driver);
    }
    public String GetFailedEmailLoginText()
    {
        return driver.findElement(ErrorEmailLogin).getText();
    }

    public String GetFailedPassLoginText()
    {
        return driver.findElement(ErrorPassLogin).getText();
    }
    
    public String GetSuccessLoginText()
    {
        return driver.findElement(loginsuccesscheck).getText();
    }
    

}
