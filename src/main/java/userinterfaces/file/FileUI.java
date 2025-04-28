package userinterfaces.file;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class FileUI  extends PageObject {

    public static final Target CONTACT_DETAIL_OPTIONS = Target.the("Contact details options").locatedBy("//a[text()='{0}']");
    public static final Target UPLOAD_FILE_BUTTON = Target.the("Upload file button").locatedBy("//button[text()=' Add ']");
    public static final Target UPLOAD_FILE_INPUT = Target.the("Upload file input").locatedBy("//input[@type=\"file\"]");
    public static final Target SAVE_BUTTON = Target.the("Save button").locatedBy("(//button[@type=\"submit\"])[2]");
    public static final Target FILE_VALIDATION = Target.the("Save button").locatedBy("//div[contains(text(),'file.txt')]");
    public static final Target DELETE_BUTTON = Target.the("Delete button").locatedBy("//i[@class=\"oxd-icon bi-trash\"]");
    public static final Target ACCEPT_DELETE_BUTTON = Target.the("Accept delete button").locatedBy("//i[@class=\"oxd-icon bi-trash oxd-button-icon\"]");

}
