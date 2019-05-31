package com.kata.spring.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class SendAndDeleteMessages {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new ChromeWebDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Given("^In a conversation$")
    public void inAConversation() {
        driver.get("https://web.whatsapp.com/");
        driver.manage().window().setSize(new Dimension(1050, 664));
        driver.findElement(By.cssSelector(".hover .xD91K .\\_19RFN")).click();
    }

    @When("^I click on the cloud of a message$")
    public void iClickOnTheCloudOfAMessage() {
        js.executeScript("window.scrollTo(0,0)");
    }

    @And("^A options panel is displayed$")
    public void aOptionsPanelIsDisplayed() {
        driver.findElement(By.cssSelector(".\\_2-qoA > span")).click();
    }

    @And("^Several options are visualized$")
    public void severalOptionsAreVisualized() {
    }

    @Then("^I select the option \"([^\"]*)\"$")
    public void iSelectTheOption(String arg0)  {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector(".\\_2-qoA > span")).click();
    }

    @And("^I click on the OK button$")
    public void iClickOnTheOKButton() {
        driver.findElement(By.cssSelector(".\\_3VXiW > .\\_3zy-4")).click();
    }

    @And("^The message is removed from the conversation$")
    public void theMessageIsRemovedFromTheConversation() {
        
    }

    @And("^It is displayed in the message cloud \"([^\"]*)\"$")
    public void itIsDisplayedInTheMessageCloud(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I write a text message \"([^\"]*)\"$")
    public void iWriteATextMessage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://web.whatsapp.com/");
        driver.manage().window().setSize(new Dimension(1050, 664));
        driver.findElement(By.cssSelector(".hover .\\_3H4MS")).click();

    }

    @And("^I press the send button$")
    public void iPressTheSendButton() {
        js.executeScript("window.scrollTo(0,0)");
    }

    @Then("^The message is displayed in a cloud$")
    public void theMessageIsDisplayedInACloud() {
        driver.findElement(By.cssSelector(".\\_3u328")).click();
    }

    @And("^Two gray arrows are displayed$")
    public void twoGrayArrowsAreDisplayed() {
        driver.findElement(By.cssSelector(".\\_3M-N- > span")).click();
    }

    @Then("^The text box is cleaned$")
    public void theTextBoxIsCleaned() {

    }

    @And("^The cursor is placed at the beginning to send another message$")
    public void theCursorIsPlacedAtTheBeginningToSendAnotherMessage() {
    }
}
