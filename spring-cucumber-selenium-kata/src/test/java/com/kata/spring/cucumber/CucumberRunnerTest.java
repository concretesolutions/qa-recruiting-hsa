package com.kata.spring.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/com/kata/spring/cucumber/features"},
		plugin = {
				"pretty", 
				"html:target/cucumber"
		}) 
public class CucumberRunnerTest {

}
