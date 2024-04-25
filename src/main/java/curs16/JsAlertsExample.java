package curs16;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumutils.BaseTest;

public class JsAlertsExample extends BaseTest{
	
	@Test(priority = 1)
	public void simpleJSAlert() throws InterruptedException {
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		WebElement button = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
		button.click();
		//driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		Thread.sleep(3000);
		Alert alertaJs = driver.switchTo().alert();
		alertaJs.accept();
		//driver.switchTo().alert().accept();
		WebElement resultText = driver.findElement(By.cssSelector("p[id='result']"));
		assertEquals(resultText.getText(), "You successfully clicked an alert");	
		
	}
	
	@Test(priority = 2)
	public void confirmJsAlert() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		
		WebElement resultText = driver.findElement(By.cssSelector("p[id='result']"));
		assertEquals(resultText.getText(), "You clicked: Cancel");
	}
	
	
	@Test(priority = 3)
	public void promptJsAlert() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		Thread.sleep(3000);
	
		driver.switchTo().alert().sendKeys("Test");
		driver.switchTo().alert().accept();
		
		WebElement resultText = driver.findElement(By.cssSelector("p[id='result']"));
		assertEquals(resultText.getText(), "You entered: Test");
		
	}

}
