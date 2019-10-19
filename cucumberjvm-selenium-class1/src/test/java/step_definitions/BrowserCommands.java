package step_definitions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.File;

public class BrowserCommands{
    public WebDriver driver;
    public BrowserCommands()
    {
    	driver = Hooks.driver;
    }
    @Given("^I open seleniumframework website$")
    public void i_open_seleniumframework_website() throws Throwable {
        driver.get("http://www.seleniumframework.com");
        driver.manage().window().maximize();
    }
    @And("^I navigate to ABOUT link$")
    public void i_navigate_to_ABOUT_link() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.ignoring(WebDriverException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("ABOUT")));
        driver.findElement(By.linkText("ABOUT")).click();
    }
    @Then("^I print the html$")
    public void i_print_the_html() throws Throwable {
       System.out.println("Browser title-"+driver.getTitle());
    }
    @And("^I perform selenium browser commands$")
    public void i_perform_selenium_browser_commands() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://www.seleniumframework.com");

        System.out.println("Printing website title...");
        System.out.println(driver.getTitle());
        System.out.println("Printing current title...");
        System.out.println(driver.getCurrentUrl());
        System.out.println("Printing page source.....");
        System.out.println(driver.getPageSource());
        System.out.println("Clicking ABOUT link...");
        driver.findElement(By.linkText("ABOUT")).click();
        driver.navigate().back();
        driver.navigate().forward();
        System.out.println("Printing title again...");
        System.out.println(driver.getTitle());
        System.out.println("Refreshing the browser");
        driver.navigate().refresh();
        System.out.println("Exiting the browser now");
    }

    @Then("^I take a screenshot$")
    public void TakeScreenShot() throws Exception{

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.seleniumframework.com");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("C:\\Users\\User\\Documents\\screenshot.png"));

    }

}