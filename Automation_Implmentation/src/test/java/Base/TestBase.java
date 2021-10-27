package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class TestBase {
    public static WebDriver driver ;
    @BeforeSuite
    public void SetUp() throws InterruptedException
    {
    	System.out.println("Setting system property");
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        
        System.out.println("Creating ChromeDriver session");
        driver = new ChromeDriver();
        
        System.out.println("Navigate to URL https://developers.facebook.com/apps/296019418796805");
        driver.get("https://developers.facebook.com/apps/296019418796805");
        
        System.out.println("Maximize window");
        //driver.manage().window().maximize();
        Thread.sleep(2000);
        
        
        
        
    }
    
    
    @AfterMethod
    public void ReturnToHome()
    {
    	System.out.println("return to HomePage https://developers.facebook.com/apps/296019418796805");
        driver.get("https://developers.facebook.com/apps/296019418796805");
    }

    @AfterSuite
    public void Quit()
    {
    	System.out.println("Driver session Ended");
        driver.quit();
    }
}
