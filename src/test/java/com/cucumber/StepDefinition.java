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
	private static String postBody = "{\n" + "  \"name\": \"foo\",\n" + "  \"job\": \"bar\"\n}";
	private static String putBody = "{\n" + "  \"name\": \"Adrin\",\n" + "	\"job\": \"xyz\"\n}";

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
