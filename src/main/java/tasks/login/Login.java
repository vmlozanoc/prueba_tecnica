package tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.login.LoginUI;

public class Login implements Task {



    @Override
    public <T extends Actor> void performAs(T actor)  {
        actor.attemptsTo(
                Enter.theValue("Admin").into(LoginUI.USERNAME_INPUT),
                Enter.theValue("admin123").into(LoginUI.PASS_INPUT),
                Click.on(LoginUI.LOGIN_BUTTON)
        );
    }

    public static Login login() {
        return Tasks.instrumented(Login.class);
    }
}

