package co.com.tcs.certification.api.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerifyFields implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().jsonPath().prettyPrint();
    }

    public static VerifyFields response(){
        return new VerifyFields();
    }
}
