package maventest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilityfiles.Pagereading;

public class Baseclass {
	Pagereading pg=new Pagereading();
	
	public String baseurl=pg.geturl();
    public String email=pg.getemail();
    public String password=pg.getpassword();
    public String chromepath=pg.getchrome();
    public String firefoxpath=pg.firefoxpath();
    public static WebDriver driver;
    public static Logger logger;
    
    @Parameters("browser")
    @BeforeClass
    public void setup(String br)	
	{
    	
    	logger=Logger.getLogger("maventest");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",pg.getchrome() );
		driver=new ChromeDriver();
		}else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", pg.firefoxpath());
			driver=new FirefoxDriver();
		}
		
	}
    
    @AfterClass
    public void teardown()
	{
		driver.quit();
	}
    
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}


}
