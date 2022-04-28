package co.com.tcs.certification.api.tasks;

import co.com.tcs.certification.api.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.List;

public class ConsultName implements Task {

    private List<String> param;

    public ConsultName(List<String> param){
        this.param = param;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(Constants.PATH).with(requestSpecification -> requestSpecification.param(param.get(0), param.get(1))));
    }

    public static ConsultName name(List<String> params){
        return Tasks.instrumented(ConsultName.class, params);
    }
}
