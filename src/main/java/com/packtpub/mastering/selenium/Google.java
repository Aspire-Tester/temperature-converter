package com.packtpub.mastering.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google {
	private WebDriver driver;
	private String baseUrl;
	
	public Google(WebDriver driver) {
		this.driver = driver;
		baseUrl = "https://www.google.com/?gl=us&hl=en&pws=0&gws_rd=cr";
		goGoogleMainPage();
	}
	
	public void goGoogleMainPage() throws WrongPageException {
		driver.get(baseUrl);
		if (!driver.getTitle().equalsIgnoreCase("Google")) {
			throw new WrongPageException("Wrong page for google main page");
		}
	}
	
	public TemperatureConverterPage goToTemperatureConversionPage() {
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("from fahrenheit to celsius");
		driver.findElement(By.name("btbG")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("resultStats")));
		return new TemperatureConverterPage(driver);
	}
	
	
}
