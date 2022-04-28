package co.com.tcs.certification.api.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\api_consumption_universities.feature",
        glue = "co.com.tcs.certification.api.stepdefinitions",
        tags = "@Sc3",
        snippets = SnippetType.CAMELCASE
)
public class ApiConsumptionUniversities {
}
