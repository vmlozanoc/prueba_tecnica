package runners;//package runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/fileTest.feature",
        glue = "stepdefinitions",
        //tags = "@test",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class File {
    private File() {
    }
}
