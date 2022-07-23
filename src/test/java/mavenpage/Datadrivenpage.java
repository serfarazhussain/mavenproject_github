package mavenpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Datadrivenpage {
	
	WebDriver ldriver;
	public Datadrivenpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	
	By txtemail=By.name("Email");
	
	By txtpassword=By.name("Password");
	By clklogin=By.xpath("");
	
	
	public void setemail(String email)
	{
	  ldriver.findElement(txtemail).clear();
	  ldriver.findElement(txtemail).sendKeys(email);
	}
	public void setpassword(String pwd)
	{
	  ldriver.findElement(txtpassword).clear();
	  ldriver.findElement(txtpassword).sendKeys(pwd);
	}
	public void setclick()
	{
	  ldriver.findElement(clklogin).clear();
	  ldriver.findElement(clklogin).click();
	}
	

}
