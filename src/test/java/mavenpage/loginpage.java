package mavenpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	WebDriver ldriver;
	
	public loginpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	By txtemail=By.name("Email");
	
	By txtpassword=By.name("Password");
	
	By btnlogin=By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button");
    By btnlogout=By.xpath("//*[@id=\"navbarText\"]/ul/li[3]/a");
    
    
	public void setemail(String email)
	{
		ldriver.findElement(txtemail).sendKeys(email);
	}
	public void setpassword(String pwd)
	{
		ldriver.findElement(txtpassword).sendKeys(pwd);
	}
	public void clklogin()
	{
		ldriver.findElement(btnlogin).click();
	}
	public void clklogout()
	{
		ldriver.findElement(btnlogout).click();
	}

}
