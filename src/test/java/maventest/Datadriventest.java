package maventest;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mavenpage.Datadrivenpage;
import utilityfiles.XLUtils;

public class Datadriventest extends Baseclass {
	@Test(dataProvider="logindata")
	public void login(String email,String pwd)
	{
		driver.get(baseurl);
		driver.manage().window().maximize();
		Datadrivenpage dp=new Datadrivenpage(driver);
		logger.info("email is provided");
		dp.setemail(email);
		logger.info("password is provided");
		dp.setpassword(pwd);
		dp.setclick();
		logger.info("login is completed");
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			logger.info("Test is passed");
			
		}else
		{
			Assert.assertTrue(false);
			logger.info("Test is failed");
		}
	}
	
	
	@DataProvider(name="logindata")
	public String[][] getdata() throws IOException
	{
		String path=System.getProperty("user.dir")+"//src//test//java//data//LoginData.xlsx";
		
		int row=XLUtils.getRowCount(path, "sheet1");
				
		int col=XLUtils.getCellCount(path, "sheet1", 1);
		
		String logindata[][]=new String[row][col];
		for(int i=1;i<=row;i++)
		{
			for(int j=0;j<=col;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i,j);
			}
		}
		return logindata;
	}

}
