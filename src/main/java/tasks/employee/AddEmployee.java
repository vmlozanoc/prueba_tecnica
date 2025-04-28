package tasks.employee;

import interactions.WaitExplicit;
import models.EmployeeData;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.employee.EmployeeUI;
import utils.Utilities;

public class AddEmployee implements Task {
    private final EmployeeData employee;

    public AddEmployee(EmployeeData employee) {
        this.employee = employee;
    }

    @Override
    public <T extends Actor> void performAs(T actor)  {
        actor.attemptsTo(
                Click.on(EmployeeUI.ADD_EMPLOYED_OPTION),
                Enter.theValue(employee.getFirstName()).into(EmployeeUI.FIRST_NAME_INPUT),
                Enter.theValue(employee.getMiddleName()).into(EmployeeUI.MIDDLE_NAME_INPUT),
                Enter.theValue(employee.getLastName()).into(EmployeeUI.LAST_NAME_INPUT),
                Enter.theValue(Utilities.generateRandomNumber(4)).into(EmployeeUI.ID_EMPLOYEE_INPUT),
                Click.on(EmployeeUI.SAVE_BUTTON)

        );
        WaitExplicit.waitExplicit(5);
        Serenity.setSessionVariable("employeeData").to(employee);
    }

    public static AddEmployee addEmployee(EmployeeData employee) {
        return Tasks.instrumented(AddEmployee.class, employee);
    }
}
