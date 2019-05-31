package com.kata.spring.cucumber.steps;

import com.kata.spring.cucumber.spring.CucumberContext;
import com.kata.spring.cucumber.spring.PropertiesContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes={CucumberContext.class, PropertiesContext.class})
public class ParentSteps {

	@Autowired
	protected WebDriver webdriver;
	
	@Autowired
	protected WebDriverWait wait;
	
	@Autowired
	protected boolean screenshotOnFailure;
	
	@Autowired
	protected String screenshotDestinationFolder;
	
}
