package userinterfaces.login;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginUI extends  PageObject {


    public static final Target VALIDATE_LOGIN = Target.the("Validate login").locatedBy("//h5[@class=\"oxd-text oxd-text--h5 orangehrm-login-title\"]");
    public static final Target USERNAME_INPUT = Target.the("Username input").locatedBy("//input[@name=\"username\"]");
    public static final Target PASS_INPUT = Target.the("Password input").locatedBy("//input[@name=\"password\"]");
    public static final Target LOGIN_BUTTON = Target.the("Login button").locatedBy("//button[@type=\"submit\"]");
    public static final Target VALIDATE_LOGIN_SUCCESSFULLY = Target.the("Validate Login successfully").locatedBy("//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]");

}
