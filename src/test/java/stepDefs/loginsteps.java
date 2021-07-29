package stepDefs;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginsteps {
WebDriver driver = Baseclass.driver;
	
	
	@Given("^User is on the Swag Lab application$")
    public void user_is_on_the_swag_lab_application() throws Throwable {
		 driver.get("https://www.saucedemo.com/");
        
    }

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_something_and_something(String username, String password) throws Throwable {
    	WebElement UserName = driver.findElement(By.xpath("//*[@id = 'user-name']"));
    	UserName.sendKeys(username);
    	WebElement Password = driver.findElement(By.xpath("//*[@id = 'password']"));
    	Password.sendKeys(password);    
    }

    @Then("^User should be able to see the homepage$")
    public void user_should_be_able_to_see_the_homepage() throws Throwable {
    	
    	WebElement ProductPageTitle = driver.findElement(By.xpath("//*[@class='title']"));
		String ActualText =  ProductPageTitle.getText();
		String ExpectedText = "PRODUCTS";
		Assert.assertEquals(ExpectedText, ActualText);
 
    }

    @And("^User clicks on the login button$")
    public void user_clicks_on_the_login_button() throws Throwable {
    	
    	WebElement loginLink = driver.findElement(By.xpath("//*[@name= 'login-button']"));
    	loginLink.click();
       
    }
    
    @When("^User enters incorrect \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_incorrect_something_and_something(String incorrectusername, String incorrectpassword) throws Throwable {
    	WebElement UserNameincorrect = driver.findElement(By.xpath("//*[@id = 'user-name']"));
    	UserNameincorrect.sendKeys(incorrectusername);
    	WebElement Passwordincorrect = driver.findElement(By.xpath("//*[@id = 'password']"));
    	Passwordincorrect.sendKeys(incorrectpassword);  
    	
    }

    @Then("^User should be able to see the error \"([^\"]*)\"$")
    public void user_should_be_able_to_see_the_error_something(String error) throws Throwable {
    	WebElement ErrorMsg = driver.findElement(By.xpath("//*[@data-test='error']"));
		String ActualError =  ErrorMsg.getText();
		Assert.assertEquals(ActualError, error);

    	
    	
 	
       
    }
}



