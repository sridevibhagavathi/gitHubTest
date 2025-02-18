package sampleTest2_Version2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SampleTest2_Version2 {
		
		//write in test ng will get one error in jenkin for testng want to see that , 
		//so create class files in test ng
		//rightclick project and add testng libraries
		
		WebDriver wd;
		@Test
		public void loadGoogle(){
			
			//webdrivermanager().chromedriver().setup();
			
			//load browser with old version code(sytem. setproperty)
			//check chrome verion in your system chrome browser
			//go to google search with google download, match with yur chrome version , there is exe file of all versions
			//that version will be pased in system.set properly value, it was used in old version automation testing
			//webdrivermanager().chromedriver().setup(); - this is latest one
			//webdriver.chrome.driverf - thisis default key, which they provided, use only it
			//System.setProperty("webdriver.chrome.driverf", "download exe file in your local, paste that path here");
				ChromeOptions opt=new ChromeOptions();
				opt.addArguments("--remote-allow-origins=*");
				WebDriver wd=new ChromeDriver(opt);
				wd.manage().window().maximize();
				wd.get("https://www.bing.com/");
				wd.findElement(By.name("q")).sendKeys("Chennai");
				wd.findElement(By.name("q")).submit();
			
		}
		
		@AfterMethod
		public void tearDown() throws IOException{
			
			File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("C:/Users/Sridevi Bhagavathi/workspace/GitHubTest/screenshot/bing.png"));
		}
		

	}


