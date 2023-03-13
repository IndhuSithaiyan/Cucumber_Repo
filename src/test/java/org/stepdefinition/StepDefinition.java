package org.stepdefinition;

import java.util.List;
import java.util.Map;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{

	By btnFrgPass = By.xpath("//a[text()='Forgotten password?']");
	By txtSearchBox = By.id("identify_email");
	By btnSearch = By.id("did_submit");

	@Given("User have to click forgotten Password")
	public void user_have_to_click_forgotten_Password() throws InterruptedException {
		WebElement frgtPass = driver.findElement(btnFrgPass);
		btnClick(frgtPass);
		Thread.sleep(3000);
	}

	@When("User have to enter email or phoneNO")
	public void user_have_to_enter_email_or_phoneNO() {
		WebElement txtSearchEmail = driver.findElement(txtSearchBox);
		fillTextbox(txtSearchEmail, "8989898123");
	}

	@Then("User have to click search btn")
	public void user_have_to_click_search_btn() {
		WebElement btnSearchIcon = driver.findElement(btnSearch);
		btnClick(btnSearchIcon);
	}

	@Given("User have to enter facebook login through chrome browser")
	public void user_have_to_enter_facebook_login_through_chrome_browser() {
		launchurl("https://www.facebook.com/");	
	}

	@When("User have to enter valid Email and invalid Password")
	public void user_have_to_enter_valid_Email_and_invalid_Password(io.cucumber.datatable.DataTable dTable) {
		//1-D List
		//		List<String> allData = dTable.asList();
		//		String email = allData.get(2);
		//		String pass = allData.get(3);

		//1-D Map
		Map<String, String> amp = dTable.asMap(String.class, String.class);
		String email = amp.get("Username");
		String pass = amp.get("email");

		System.out.println("email "+email);
		System.out.println("password "+pass);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(pass);
	}

	@When("User have to enter invalid Email and invalid Password")
	public void user_have_to_enter_invalid_Email_and_invalid_Password(io.cucumber.datatable.DataTable dataTable) {
		//2-D List
		//		List<List<String>> allDataTable = dataTable.asLists();
		//		String email = allDataTable.get(1).get(0);
		//		String pass = allDataTable.get(1).get(2);

		List<Map<String, String>> aMps = dataTable.asMaps();
		String email= aMps.get(2).get("Username");
		String pass = aMps.get(2).get("Password");
		System.out.println("email "+email);
		System.out.println("password "+pass);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(pass);
	}

	@When("User have to enter invalid email and invalid password")
	public void user_have_to_enter_invalid_email_and_invalid_password() {
		driver.findElement(By.id("email")).sendKeys("GREENS@.com");
		driver.findElement(By.id("pass")).sendKeys("12345");
	}

	@When("User have to click login button")
	public void user_have_to_click_login_button() throws InterruptedException {
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}

	@Then("User have to reach invalid credentials page")
	public void user_have_to_reach_invalid_credentials_page() {
		String url = driver.getCurrentUrl();
		if(url.contains("privacy_mutation_token")) {
			System.out.println("User is in invalid credentials page");
		}
		else {
			System.out.println("User is not in invalid credentials page");
		}
	}
}
