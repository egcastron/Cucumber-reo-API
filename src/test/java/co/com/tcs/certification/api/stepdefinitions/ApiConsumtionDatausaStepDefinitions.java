package co.com.tcs.certification.api.stepdefinitions;

import co.com.tcs.certification.api.questions.VerifyFields;
import co.com.tcs.certification.api.tasks.ConsultYear;
import co.com.tcs.certification.api.utils.Constants;
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

public class ApiConsumtionDatausaStepDefinitions {

    @Before
    public void setUpDatausa(){
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(Constants.END_POINT2)));
        OnStage.theActorCalled("user");
        SerenityRest.useRelaxedHTTPSValidation();
    }

    @When("^the user consults the api$")
    public void theUserConsultsTheApi(){
        OnStage.theActorInTheSpotlight().attemptsTo(Get.resource(Constants.PATH2).with(requestSpecification -> requestSpecification.param("Population", "328239523")));
    }

    @When("^the user consult the service with params$")
    public void theUserConsultsTheServiceWithParams(List<String> params){
        OnStage.theActorInTheSpotlight().attemptsTo(ConsultYear.year(params));
    }

    @Then("^the user will see the response population$")
    public void theUserWillSeeTheResponsePopulation(List<String> params){
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifyFields.response(), Matchers.containsString(params.get(0)+"\": "+params.get(1))));
    }
}