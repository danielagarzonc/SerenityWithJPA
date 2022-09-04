package com.serenityjpa.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/interact_with_database.feature",
        glue = {"com.serenityjpa.stepdefinitions"}
)
public class InteractWithDatabaseRunner {
}
