package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Base.TestBase;
import Pages.RegisterPage;

public class RegisterPageTest extends TestBase {
     RegisterPage registerpage ;     
    
    String first_name ;
    String second_name ;
    String email ;
    String day ;
    String month ;
    String year ;
    String gender ;
    String password;
    
    @Test
    public void SuccessfullRegister()
    {
    	first_name = "Insta";
    	second_name = "Bug";
    	email = "errnrscnwd@tfbnw.net";
    	day = "15";
    	month = "9";
    	year = "1992";
    	gender = "male";
    	password = "Aliii123123";
    	
    	System.out.println("***************** start of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");
    	        
        System.out.println("set first name :"+first_name);
        registerpage.SetFirstname(first_name);
    	
    	System.out.println("set second name :"+second_name);
    	registerpage.SetSecondname(second_name);
    	
    	System.out.println("set email :"+email);
    	registerpage.SetEmailAdd(email);

    	System.out.println("set email confirmation :"+email);
    	registerpage.SetEmailAddConfirm(email);

    	System.out.println("set day :"+day);
    	registerpage.Setday(day);
    	
    	System.out.println("set month :"+month);
    	registerpage.Setmonth(month);

    	System.out.println("set year :"+year);
    	registerpage.Setyear(year);

    	System.out.println("set password :"+password);
    	registerpage.SetPassword(day);

    	System.out.println("set gender :"+gender);
    	registerpage.Setgender(gender);

    	System.out.println("press register");
    	registerpage.ClickSubmit();
    	
        String loginsuccess = registerpage.GetSuccessRegisterText();
        System.out.println("Check register is successful");
        
        Assert.assertTrue(loginsuccess.contains("Log Out"));
        System.out.println("***************** end of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");

    }
    @Test(enabled = true)
    public void FailedMissingNameRegister()
    {
    	first_name = "";
    	second_name = "Bug";
    	email = "errnrscnwd@tfbnw.net";
    	day = "15";
    	month = "9";
    	year = "1992";
    	gender = "male";
    	password = "Aliii123123";
    	
    	System.out.println("***************** start of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");
        
        System.out.println("set first name :"+first_name);
        registerpage.SetFirstname(first_name);
    	
    	System.out.println("set second name :"+second_name);
    	registerpage.SetSecondname(second_name);
    	
    	System.out.println("set email :"+email);
    	registerpage.SetEmailAdd(email);

    	System.out.println("set email confirmation :"+email);
    	registerpage.SetEmailAddConfirm(email);

    	System.out.println("set day :"+day);
    	registerpage.Setday(day);
    	
    	System.out.println("set month :"+month);
    	registerpage.Setmonth(month);

    	System.out.println("set year :"+year);
    	registerpage.Setyear(year);

    	System.out.println("set password :"+password);
    	registerpage.SetPassword(day);

    	System.out.println("set gender :"+gender);
    	registerpage.Setgender(gender);

    	System.out.println("press register");
    	registerpage.ClickSubmit();
    	
        Boolean registerNameFail = registerpage.GetFailedMissingNameRegisterStatus();
        
        System.out.println("Check register is failing");
        Assert.assertTrue(registerNameFail);

    	System.out.println("***************** end of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");

    }
    @Test
    public void FailedIncorrectPasswordRegister()
    {
    	first_name = "Insta";
    	second_name = "Bug";
    	email = "errnrscnwd@tfbnw.net";
    	day = "15";
    	month = "9";
    	year = "1992";
    	gender = "male";
    	password = "Ali";
    	
    	System.out.println("***************** start of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");
        
        System.out.println("set first name :"+first_name);
        registerpage.SetFirstname(first_name);
    	
    	System.out.println("set second name :"+second_name);
    	registerpage.SetSecondname(second_name);
    	
    	System.out.println("set email :"+email);
    	registerpage.SetEmailAdd(email);

    	System.out.println("set email confirmation :"+email);
    	registerpage.SetEmailAddConfirm(email);

    	System.out.println("set day :"+day);
    	registerpage.Setday(day);
    	
    	System.out.println("set month :"+month);
    	registerpage.Setmonth(month);

    	System.out.println("set year :"+year);
    	registerpage.Setyear(year);

    	System.out.println("set password :"+password);
    	registerpage.SetPassword(day);

    	System.out.println("set gender :"+gender);
    	registerpage.Setgender(gender);

    	System.out.println("press register");
    	registerpage.ClickSubmit();
    	
        String registerPasswordFail = registerpage.GetFailedShortPasswordRegisterText();
        
        System.out.println("Check register is failing");
        Assert.assertTrue(registerPasswordFail.contains("Your password must be at least 6 characters long"));

    	System.out.println("***************** end of testcase :"+Thread.currentThread().getStackTrace()[1].getMethodName()+"*******************");

    }
}
