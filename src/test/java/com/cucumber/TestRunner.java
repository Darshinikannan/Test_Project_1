package com.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/rds.feature", 
glue = {"com.cucumber"}, 
plugin = {"json:target/cucumber.json"},
publish = true,
monochrome = true, 
dryRun = false)

public class TestRunner {

}
