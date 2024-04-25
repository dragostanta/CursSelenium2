package curs16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumutils.BaseTest;

public class IsEnabledExample extends BaseTest{
	
	@Test
	public void isEnabledTest() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement loginMenu = driver.findElement(By.cssSelector("ul[class^='menu_user_nav']>li>a"));
		
		System.out.println("Login before disable : " + loginMenu.isEnabled());
		
		jse.executeScript("arguments[0].setAttribute('disabled', '')", loginMenu);
		
		System.out.println("Login after disable : " + loginMenu.isEnabled());
		
		loginMenu.click();
		
		System.out.println("-----------------------------------");
		
		WebElement usernameField =  driver.findElement(By.cssSelector("input[id='log']"));
		
		System.out.println("Username before disable :" + usernameField.isEnabled());
		
		jse.executeScript("arguments[0].setAttribute('disabled', '')", usernameField);
		
		System.out.println("Username after disable :" + usernameField.isEnabled());

		usernameField.sendKeys("TestUser");
		
		
		
	}
	

}
