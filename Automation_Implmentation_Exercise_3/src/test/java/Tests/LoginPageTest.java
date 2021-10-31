package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class LoginPageTest extends TestBase {
     LoginPage loginpage ;     
    
    String username ;
    String password;
    @Test
    public void SuccessfullLogin()
    {
    	
    	username = "errnrscnwd_1634974566@tfbnw.net";
    	password = "ali123456";
    	
    	System.out.println("***************** start of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");
    	        
        System.out.println("set username :"+username);
    	loginpage.SetUsername(username);
    	
    	System.out.println("set password :"+password);
    	loginpage.SetPassword(password);
    	
    	System.out.println("press login");
    	loginpage.ClickSubmitButton();
    	
        String loginsuccess = loginpage.GetSuccessLoginText();
        System.out.println("Check login is successful");
        
        Assert.assertTrue(loginsuccess.contains("Log Out"));
        System.out.println("***************** end of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");

    }
    @Test(enabled = true)
    public void FailedUserLogin()
    {
    	username = "errnrscnwd@tfbnw.net";
    	password = "ali123456";
    	
    	System.out.println("***************** start of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");
        
        System.out.println("set username :"+username);
        loginpage.SetUsername(username);
        
    	System.out.println("set password :"+password);
        loginpage.SetPassword(password);
        
        System.out.println("press submit");
    	loginpage.ClickSubmitButton();
    	
    	String loginuserfailed = loginpage.GetFailedEmailLoginText();
        Assert.assertTrue(loginuserfailed.contains("The email address you entered isn't connected to an account"));

    	System.out.println("***************** end of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");

    }
    @Test
    public void FailedPasswordLogin()
    {
    	username = "errnrscnwd_1634974566@tfbnw.net";
    	password = "ali123459";
    	
    	System.out.println("***************** start of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");
    	
        System.out.println("set username :"+username);
        loginpage.SetUsername(username);
        
    	System.out.println("set password :"+password);
        loginpage.SetPassword(password);
        
        System.out.println("press submit");
    	loginpage.ClickSubmitButton();
    	
        String loginpassfailed = loginpage.GetFailedPassLoginText();
        Assert.assertTrue(loginpassfailed.contains("The password that you've entered is incorrect")); 

    	System.out.println("***************** end of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");

    }
}
