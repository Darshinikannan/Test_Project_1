package com.cucumber;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StepDefinition {
	public static WebDriver driver;
	private static String postBody = "{\n" + "  \"name\": \"foo\",\n" + "  \"job\": \"bar\"\n}";
	private static String putBody = "{\n" + "  \"name\": \"Adrin\",\n" + "	\"job\": \"xyz\"\n}";

	@Given("user launch the application")
	public void user_launch_the_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

	}

	@Given("login with {string} and {string}")
	public void login_with_and(String string, String string2) {
		WebElement name = driver.findElement(By.id("user-name"));
		name.click();
		name.sendKeys(string); // 1

		WebElement pwd = driver.findElement(By.id("password"));
		pwd.click();
		pwd.sendKeys(string2); // 2
	}

	@Then("click login button")
	public void click_login_button() {
		driver.findElement(By.id("login-button")).click(); // 3
	}

	@Then("add the product to cart")
	public void add_the_product_to_cart() {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click(); // 4
	}

	@Then("user Navigateds to the cart")
	public void user_navigateds_to_the_cart() {
		driver.findElement(By.id("shopping_cart_container")).click();
		driver.quit();
	}

	@When("I fetch the data")
	public void i_fetch_the_data() {
		Response get = given().contentType(ContentType.JSON).when().get("https://reqres.in/api/users").then().extract()
				.response();
		get.prettyPrint(); // 1
	}

	@When("I query parameters")
	public void i_query_parameters() {
		Response getparam = given().contentType(ContentType.JSON).param("id", "4").when()
				.get("https://reqres.in/api/users").then().extract().response();
		getparam.prettyPrint(); // 2
	}

	@Then("I post data")
	public void i_post_data() {
		Response post = given().header("Content-type", "application/json").and().body(postBody).when()
				.post("https://reqres.in/api/users").then().extract().response();
		post.prettyPrint(); // 3
	}

	@Then("I put request")
	public void i_put_request() {
		Response put = given().header("Content-type", "application/json").and().body(putBody).when()
				.put("https://reqres.in/api/users/2").then().extract().response();
		put.prettyPrint(); // 4
	}

	@Then("I delete a resource")
	public void i_delete_a_resource() {
		Response delete = given().header("Content-type", "application/json").and().body(postBody).when()
				.delete("https://reqres.in/api/users").then().extract().response();
	}

}
