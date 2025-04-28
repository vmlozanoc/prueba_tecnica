package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;


public class TransversalStepDefinitions {
    @Managed
    WebDriver driver;

    EnvironmentVariables environmentVariables;

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
               .getProperty("webdriver.base.url");
        OnStage.theActorCalled("Robot QA").can(BrowseTheWeb.with(driver));
        OnStage.theActorCalled("Robot QA").wasAbleTo(
                Open.url(baseUrl)
        );

    }

    @After
    public void resetVariable() {
        driver.close();
    }
}