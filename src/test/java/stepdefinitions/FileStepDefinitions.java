package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import questions.NoExistValidator;
import questions.ValidateObject;
import tasks.file.DeleteFile;
import tasks.file.SelectOptionMyInfo;
import tasks.file.UploadFile;
import userinterfaces.file.FileUI;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FileStepDefinitions {
    @And("^I select the (.*) option option from my info$")
    public void iSelectTheContactDetailsOptionOptionFromMyInfo(String option) {
        theActorInTheSpotlight().attemptsTo(SelectOptionMyInfo.selectOptionFromMyInfo(option));
    }
    @And("I upload a file")
    public void uploadFile() {
        theActorInTheSpotlight().attemptsTo(UploadFile.uploadFile());
    }

    @And("I delete the file")
    public void deleteFile() {
        theActorInTheSpotlight().attemptsTo(DeleteFile.deleteFile());

    }
    @Then("I verify the uploaded file")
    public void verifyUploadedFile() {
        theActorInTheSpotlight().asksFor(ValidateObject.validateObject(FileUI.FILE_VALIDATION));
    }
    @Then("I verify the file has been deleted")
    public void verifyFileDeleted() {
        theActorInTheSpotlight().asksFor(NoExistValidator.noExistValidator(FileUI.FILE_VALIDATION));
    }


}
