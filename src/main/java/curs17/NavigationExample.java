package curs17;

import org.testng.annotations.Test;

import seleniumutils.BaseTest;

public class NavigationExample extends BaseTest {

	@Test
	public void navigationTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("http://emag.ro");
		Thread.sleep(3000);
		driver.navigate().to("http://www.altex.ro");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	
	
	
}
