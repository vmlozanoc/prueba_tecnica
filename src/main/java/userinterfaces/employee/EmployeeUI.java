package userinterfaces.employee;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class EmployeeUI  extends PageObject {
    public static final Target BANNER_OPTION = Target.the("Pim option").locatedBy("//span[text()='{0}']");
    public static final Target ADD_EMPLOYED_OPTION = Target.the("Add employed option").locatedBy("//a[text()='Add Employee']");
    public static final Target FIRST_NAME_INPUT = Target.the("First name input").locatedBy("//input[@name=\"firstName\"]");
    public static final Target MIDDLE_NAME_INPUT = Target.the("Middle name input").locatedBy("//input[@name=\"middleName\"]");
    public static final Target LAST_NAME_INPUT = Target.the("Last name input").locatedBy("//input[@name=\"lastName\"]");
    public static final Target ID_EMPLOYEE_INPUT = Target.the("Id employee input").locatedBy("//h6//following::input[@class=\"oxd-input oxd-input--active\"]");
    public static final Target SAVE_BUTTON = Target.the("Save button").locatedBy("//button[@type=\"submit\"]");
    public static final Target SEARCH_EMPLOYEE_INPUT = Target.the("Search employee input").locatedBy("//label[text()='Employee Name']//following::input");
    public static final Target SEARCH_EMPLOYEE_BUTTON = Target.the("Search employee button").locatedBy("//button[text()=' Search ']");
    public static final Target CUANITY_RESULT_VALIDATION = Target.the("Cuantity result validations").locatedBy("//span[@class=\"oxd-text oxd-text--span\"]");
    public static final Target PERSONAL_DETAIL_TITLE = Target.the("Personal detail title").locatedBy("//h6[@class=\"oxd-text oxd-text--h6 orangehrm-main-title\"]");
    public static final Target RESULT_TABLE = Target.the("Result table").locatedBy("//div[@class=\"oxd-table-row oxd-table-row--with-border oxd-table-row--clickable\"]");
    public static final Target DELETE_EMPLOYEE_BUTTON = Target.the("Delete Employee Button").locatedBy("//i[@class=\"oxd-icon bi-trash\"]");
    public static final Target ACCEPT_DELETE_EMPLOYEE_BUTTON = Target.the("Accept delete Employee Button").locatedBy("//button[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]");
    public static final Target VALIDATE_EMPTY_INPUTS = Target.the("Validate empty inputs").locatedBy("//span[text()='Required']");



}
