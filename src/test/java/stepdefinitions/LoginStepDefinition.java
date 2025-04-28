package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import questions.ValidateObject;
import tasks.login.Login;
import userinterfaces.login.LoginUI;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinition {

    @Given("The login page is displayed")
    public void theLoginPageIsDisplayed() {
        theActorInTheSpotlight().asksFor(ValidateObject.validateObject(LoginUI.VALIDATE_LOGIN));
    }

    @When("I enter the credentials")
    public void iEnterTheCredentials() {
        theActorInTheSpotlight().attemptsTo(Login.login());

    }
}
