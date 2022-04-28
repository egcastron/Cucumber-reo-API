package co.com.tcs.certification.api.stepdefinitions;

import co.com.tcs.certification.api.questions.VerifyFields;
import co.com.tcs.certification.api.tasks.ConsultName;
import co.com.tcs.certification.api.utils.Constants;
import co.com.tcs.certification.api.tasks.ConsultInfo;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.hamcrest.Matchers;

import java.util.List;

public class ApiConsumptionUniversitiesStepDefinitions {

    @Before
    public void setUpUniversities(){
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(Constants.END_POINT)));
        OnStage.theActorCalled("user");
        SerenityRest.useRelaxedHTTPSValidation();
    }

    @When("^the user consults the service$")
    public void theUserConsultsTheService(){
        OnStage.theActorInTheSpotlight().attemptsTo(ConsultInfo.api());
    }

    @Then("^the user will see the fields (.*)$")
    public void theUserWillSeeTheFields(String params){
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifyFields.response(), Matchers.containsString(params)));
    }

    @When("^the user consults the service with param$")
    public void theUserConsultsTheServiceWithParam(List<String> params){
        OnStage.theActorInTheSpotlight().attemptsTo(ConsultName.name(params));
    }

    @Then("^the user will see the response domain$")
    public void theUserWillSeeTheResponseDomain(List<String> params){
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifyFields.response(), Matchers.containsString(params.get(0)+"\": [\n" +
                "            \""+params.get(1))));
    }

    @Then("^the user will see the response alpha$")
    public void theUserWillSeeTheResponseAlpha(List<String> params){
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifyFields.response(), Matchers.containsString(params.get(0)+"\": \""+params.get(1))));
    }
}
