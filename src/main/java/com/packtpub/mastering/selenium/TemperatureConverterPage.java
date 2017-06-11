package com.packtpub.mastering.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TemperatureConverterPage {
	private WebDriver driver;
	
	public TemperatureConverterPage(WebDriver driver) {
		this.driver = driver;
		System.out.println(driver.getTitle());
		if (!driver.getTitle().equals("from fahrenheit to celsius")) {
			throw new WrongPageException("Incorrect page for the converter page");
		}
	}
	
	public void inputFahrenheit(double valueOfFahrenheit) {
		String s = Double.toString(valueOfFahrenheit);
		driver.findElement(By.xpath(".//*[@id='_Aif'/input")).click();
		driver.findElement(By.xpath(".//*[@id='_Aif']/input")).sendKeys("98.3");
		
	}
	
	public String actualResult() {
		String valueOfCelsius = driver.findElement(By.xpath(".//*[@id='_Cif']/input")).getAttribute("value");
		System.out.println(valueOfCelsius);
		return valueOfCelsius;
	}
	
	
}
