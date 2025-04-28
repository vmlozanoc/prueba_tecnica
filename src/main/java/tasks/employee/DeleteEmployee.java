package tasks.employee;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.employee.EmployeeUI;

public class DeleteEmployee implements Task {
    @Override
    public <T extends Actor> void performAs(T actor)  {

        actor.attemptsTo(
                Click.on(EmployeeUI.DELETE_EMPLOYEE_BUTTON),
                Click.on(EmployeeUI.ACCEPT_DELETE_EMPLOYEE_BUTTON)
        );


    }

    public static DeleteEmployee deleteEmployee() {
        return Tasks.instrumented(DeleteEmployee.class);
    }
}
