package stepdefinitions;

import interactions.Wait;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.EmployeeData;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;
import questions.ValidateObject;
import tasks.SelectBannerOption;
import tasks.employee.AddEmployee;
import tasks.employee.DeleteEmployee;
import tasks.employee.SearchEmployee;
import userinterfaces.employee.EmployeeUI;
import userinterfaces.login.LoginUI;

import java.util.List;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EmployeeStepDefinition {
    @Given("I am on the main page")
    public void onMainPage() {
        theActorInTheSpotlight().asksFor(ValidateObject.validateObject(LoginUI.VALIDATE_LOGIN_SUCCESSFULLY));
    }

    @When("^I select the (.*) option$")
    public void selectPimOption(String bannerOption) {
        theActorInTheSpotlight().attemptsTo(SelectBannerOption.selectBannerOption(bannerOption));

    }

    @And("I add employee")
    public void iAddEmployee(DataTable table) {

        List<EmployeeData> employees = table.asMaps(String.class, String.class)
                .stream()
                .map(map -> new EmployeeData(
                        map.get("firstName"),
                        map.get("middleName"),
                        map.get("lastName")))
                .collect(Collectors.toList());

        EmployeeData employee = employees.get(0);
        theActorInTheSpotlight().attemptsTo(AddEmployee.addEmployee(employee));
    }

    @Then("I verify that the employee was created successfully")
    public void verifyEmployeeCreatedSuccessfully() {
        EmployeeData employeeData =  Serenity.sessionVariableCalled("employeeData");
        theActorInTheSpotlight().attemptsTo(
                Wait.waitTimeImplicit(EmployeeUI.PERSONAL_DETAIL_TITLE, 20));
                Ensure.that(Text.of(EmployeeUI.PERSONAL_DETAIL_TITLE)).isEqualTo("Personal Details");
                Ensure.that(Value.of(EmployeeUI.FIRST_NAME_INPUT)).isEqualTo(employeeData.getFirstName());
                Ensure.that(Value.of(EmployeeUI.MIDDLE_NAME_INPUT)).isEqualTo(employeeData.getMiddleName());
                Ensure.that(Value.of(EmployeeUI.LAST_NAME_INPUT)).isEqualTo(employeeData.getLastName());
    }


    @And("^I search for the employee by name (.*)$")
    public void iSearchForTheEmployeeByName(String name) {
        theActorInTheSpotlight().attemptsTo(SearchEmployee.searchEmployee(name));
    }

    @Then("I verify that the correct result is shown")
    public void iVerifyThatTheCorrectResultIsShown() {
        theActorInTheSpotlight().attemptsTo(Ensure.that(Text.of(EmployeeUI.CUANITY_RESULT_VALIDATION)).isEqualTo("(1) Record Found"));
        theActorInTheSpotlight().asksFor(ValidateObject.validateObject(EmployeeUI.RESULT_TABLE));
    }

    @And("I delete the employee")
    public void iDeleteTheEmployee() {
        theActorInTheSpotlight().attemptsTo(DeleteEmployee.deleteEmployee());
    }

    @Then("I verify that the employee was deleted successfully")
    public void iVerifyThatTheEmployeeWasDeletedSuccessfully() {
        theActorInTheSpotlight().attemptsTo(SearchEmployee.searchEmployee("Fulanito"));
        theActorInTheSpotlight().attemptsTo(Ensure.that(Text.of(EmployeeUI.CUANITY_RESULT_VALIDATION)).isEqualTo("No Records Found"));
    }

    @Then("I verify that the employee cannot be created")
    public void iVerifyThatTheEmployeeCannotBeCreated() {
        theActorInTheSpotlight().attemptsTo(Ensure.that(Text.of(EmployeeUI.VALIDATE_EMPTY_INPUTS)).isEqualTo("Required"));
    }
}
