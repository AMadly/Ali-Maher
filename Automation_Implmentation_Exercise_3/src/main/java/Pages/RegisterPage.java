package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage {
	private final WebDriver driver;

	//set locators in the page
	private By firstname = By.name("firstname");

	private By secondname = By.name("lastname");

	private By emailAddress = By.name("reg_email__");

	private By emailAddressConfirm = By.name("reg_email_confirmation__");

	private By registerPassword = By.name("reg_passwd__");

	private By day = By.id("day");

	private By month = By.id("day");

	private By year = By.id("day");

	private By genderMale = By.xpath("//input[@type='radio' and @value='2']");
	
	private By genderFemale = By.xpath("//input[@type='radio' and @value='1']");

	private By submitButton = By.name("websubmit");
	
	private By errorPass = By.id("reg_error_inner");
	
	private By registerSuccessCheck = By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div/div[2]/a");

	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void SetFirstname(String username)
	{
		driver.findElement(firstname).clear();
		driver.findElement(firstname).sendKeys(username);
	}
	public void SetSecondname(String second)
	{
		driver.findElement(secondname).clear();
		driver.findElement(secondname).sendKeys(second);
	}
	public void SetEmailAdd (String email)
	{
		driver.findElement(emailAddress).clear();
		driver.findElement(emailAddress).sendKeys(email);
	}

	public void SetEmailAddConfirm (String email)
	{
		driver.findElement(emailAddressConfirm).clear();
		driver.findElement(emailAddressConfirm).sendKeys(email);
	}

	public void SetPassword (String pass)
	{
		driver.findElement(registerPassword).clear();
		driver.findElement(registerPassword).sendKeys(pass);
	}

	public void Setday (String date)
	{
		driver.findElement(day).clear();
		driver.findElement(day).sendKeys(date);
	}

	public void Setmonth (String date)
	{
		driver.findElement(month).clear();
		driver.findElement(month).sendKeys(date);
	}

	public void Setyear (String date)
	{
		driver.findElement(year).clear();
		driver.findElement(year).sendKeys(date);
	}
	
	public void Setgender (String type)
	{
		if (type == "male") {
			driver.findElement(genderMale).click();
		}
		else if(type == "female") {
			driver.findElement(genderFemale).click();
		}
	}
	

	public void ClickSubmit ()
	{
		driver.findElement(submitButton).click();

	}

	public String GetSuccessRegisterText()
	{
		return driver.findElement(registerSuccessCheck).getText();
	}
	
	public boolean GetFailedMissingNameRegisterStatus()
	{
		return driver.getPageSource().contains("What's your name");
	}

	public String GetFailedShortPasswordRegisterText()
	{
		return driver.findElement(errorPass).getText();
	}


}
