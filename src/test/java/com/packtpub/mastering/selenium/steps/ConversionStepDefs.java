package com.packtpub.mastering.selenium.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.packtpub.mastering.selenium.Google;
import com.packtpub.mastering.selenium.TemperatureConverterPage;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;

public class ConversionStepDefs {
	private WebDriver driver;
	private Google googlePage;
	private TemperatureConverterPage temperatureConverterPage;
	
	@Given("^I want to convert (\\d+).(\\d+) degree Fahrenheit to Celsius$")
	public void I_want_to_convert_degree_Fahrenheit_to_Celsius(int arg1, int arg2) throws Throwable {
		System.setProperty("webdriver.gecko.driver", "/Users/ellobo/Downloads/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		googlePage = new Google(driver);
		temperatureConverterPage = googlePage.goToTemperatureConversionPage();
		temperatureConverterPage = new TemperatureConverterPage(driver);
	}

	@When("^I input the value of Fahrenheit as (\\d+).(\\d+) in text field$")
	public void I_input_the_value_of_Fahrenheit_as_in_text_field(int arg1, int arg2) throws Throwable {
		temperatureConverterPage.inputFahrenheit(98.6);
	}

	@Then("^It should be converted to Celsius as (\\d+) degree$")
	public void It_should_be_converted_to_Celsius_as_degree(int arg1) throws Throwable {
		Assert.assertEquals(temperatureConverterPage.actualResult(), temperatureConverterPage.expectedResult());
		driver.quit();
	}
}
