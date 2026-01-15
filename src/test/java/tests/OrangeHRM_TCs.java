package tests;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;


public class OrangeHRM_TCs extends BaseTest {
	
	String baseURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
  @Test
  public void openApp() {
	  driver.get(baseURL);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  
  }
	
  @Test(priority =1)
  public void invalidLoginCredentials() {
	  openApp();
	  WebElement userName=driver.findElement(By.xpath("//input[@placeholder='Username']"));
	
	  userName.sendKeys("adminhello");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin321");
	  driver.findElement(By.cssSelector("button[type='submit']")).click();
	  String errTitle=driver.findElement(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text")).getText();
      System.out.println(errTitle);
      Assert.assertTrue(errTitle.contains("Inavalid Credentials"),"Inavalid Credentials Messege  not Displayed ");  
  }
  
  @Test(priority=2)
  public void loginwithEmptyCredentials() {
	  openApp();
	  driver.findElement(By.xpath("//input[@placeholder='Username']"));
	  driver.findElement(By.xpath("//input[@placeholder='Password']"));
	  driver.findElement(By.cssSelector("button[type='submit']")).click();
	  String errTitle1=driver.findElement(By.xpath("//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")).getText();
      System.out.println("Alert Title : "+errTitle1);
      Assert.assertTrue(errTitle1.contains("Required"), "Required alert is not displayed to user");        
  }
   @Test(priority=3)
   public void validLoginCredentials() {
	   openApp();
	      driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		  driver.findElement(By.cssSelector("button[type='submit']")).click();
		  String pageTitle=driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).getText();
	      System.out.println("Page Title : "+pageTitle);
	      Assert.assertTrue(pageTitle.contains("Dashboard"), "User in not able to Login with Valid Credentials");
   }
  
  @Test(priority=4,dependsOnMethods="validLoginCredentials")
  public void navigateToAdminPage() {
	 
	  driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click(); 
	  String adminpageTitle=driver.findElement(By.xpath("")).getText();
	  System.out.println("");
	  Assert.assertTrue(adminpageTitle.contains(""),"") ;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
