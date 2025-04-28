package tasks.employee;

import interactions.WaitExplicit;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.employee.EmployeeUI;

public class SearchEmployee implements Task {

    private final String name;

    public SearchEmployee(String name){
        this.name = name;
    }
    @Override
    public <T extends Actor> void performAs(T actor)  {

        actor.attemptsTo(
                Enter.theValue(name).into(EmployeeUI.SEARCH_EMPLOYEE_INPUT),
                Click.on(EmployeeUI.SEARCH_EMPLOYEE_BUTTON),
                WaitExplicit.waitExplicit(5)
        );


    }

    public static SearchEmployee searchEmployee(String name) {
        return Tasks.instrumented(SearchEmployee.class, name);
    }
}
