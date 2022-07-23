package utilityfiles;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Pagereading {
	
	Properties pro;
	
	public void readpage()
	{
		File src=new File("./configure/configure.properties");
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			
			pro.load(fis);
		}catch(Exception e)
		{
			System.out.println("Exception is" +e.getMessage());
		}
	}
	
	public String geturl()
	{
		String url=pro.getProperty("baseurl");
		return url;
	}
	public String getemail()
	{
		String email=pro.getProperty("email");
		return email;
	}
	public String getpassword()
	{
		String pwd=pro.getProperty("password");
		return pwd;
	}
	public String getchrome()
	{
		String chpath=pro.getProperty("chromepath");
		return chpath;
	}
	public String firefoxpath()
	{
		String fpath=pro.getProperty("firefoxpath");
		return fpath;
	}

}
