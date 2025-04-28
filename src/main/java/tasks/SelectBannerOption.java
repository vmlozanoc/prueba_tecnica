package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.employee.EmployeeUI;

public class SelectBannerOption implements Task {
    public final String option;



    public SelectBannerOption(String option) {
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T actor)  {

        actor.attemptsTo(
                Click.on(EmployeeUI.BANNER_OPTION.of(option))
        );

    }

    public static SelectBannerOption selectBannerOption(String option) {
        return Tasks.instrumented(SelectBannerOption.class, option);
    }


}
