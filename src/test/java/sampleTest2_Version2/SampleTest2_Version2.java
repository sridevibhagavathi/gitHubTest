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
			
				ChromeOptions opt=new ChromeOptions();
				opt.addArguments("--remote-allow-origins=*");
				wd=new ChromeDriver(opt);
				wd.manage().window().maximize();
				wd.get("https://www.bing.com/");
				wd.findElement(By.id("sb_form_q")).sendKeys("Chennai");
				wd.findElement(By.id("sb_form_q")).submit();
			
		}
		
		@AfterMethod
		public void tearDown() throws IOException{
			
			File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("C:/Users/Sridevi Bhagavathi/workspace/GitHubTest/screenshot/bing.png"));
		}
		

	}


