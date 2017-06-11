package com.packtpub.mastering.selenium;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber-h"})
public class RunCukesTest {
}
