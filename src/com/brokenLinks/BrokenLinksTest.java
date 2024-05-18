package com.brokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\PackageForTesting\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		/*driver.get("https://freecrm.co.in/");
		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		driver.findElement(By.name("email")).sendKeys("nsonali21@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Abc@1234");
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();*/
		driver.get("https://in.ebay.com/");
		List<WebElement> linksList=driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		System.out.println("total links and images on the page is"+linksList.size());
		
		List<WebElement> activeLinks=new  ArrayList<WebElement>();
		
		for(int i=0;i<linksList.size();i++) {
			if(linksList.get(i).getAttribute("href")!=null &&(! linksList.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linksList.get(i));
			}
		}
		System.out.println("size of active Links is "+activeLinks.size());
		
       for(int j=0;j<activeLinks.size();j++) {
    	  HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
////    	/*HttpURLConnection is abstract class. We can create reference of abstract class(i.e here connection) but we cant instanciate.
//    	  (i.e we can't create object of abtract class)but we can refer this reference to object of subclass
//    	  (here URL is subclass extending HttpURLConnection (i.e Abstract class) */   	  
//    	  
//    	  connection.connect();
    	  System.out.println("hello");//checkn fr ggit
    	  String response=connection.getResponseMessage();
    	  System.out.println(activeLinks.get(j).getAttribute("href")+"----->"+response);
     	  connection.disconnect();
    	  
    	  System.out.println("************Testing for git****************");

    	  
    	  System.out.println("Git Brannching checks1");
    	  System.out.println("Git Brannching checks1");
    	  System.out.println("Git Brannching checks1");
    	  System.out.println("Git Brannching checks2");
    	  System.out.println("Git Brannching checks3");
    	  
    	  
    	  System.out.println("My secpndhance");
    	  
       }
	}

}
