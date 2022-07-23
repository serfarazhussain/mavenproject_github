package maventest;



import org.junit.Assert;
import org.testng.annotations.Test;

import mavenpage.loginpage;

public class logintest extends Baseclass {
	
	
    
	
	@Test
	public void login() throws InterruptedException
	{
		driver.get(baseurl);
		driver.manage().window().maximize();
		
		loginpage lp=new loginpage(driver);
		lp.setemail(email);
		logger.info("email is provided");
		lp.setpassword(password);
		logger.info("password is provided");
		lp.clklogin();
		
		logger.info("validation is started");
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Thread.sleep(3000);
			Assert.assertTrue(true);
			logger.info("Test passed");
			
		}else
		{
			Assert.assertTrue(false);
			logger.info("Test failed");
		}
		
	}
	
	

}
