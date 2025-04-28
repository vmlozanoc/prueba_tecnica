package tasks.file;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.file.FileUI;

public class SelectOptionMyInfo implements Task {
    public final String option;


    public SelectOptionMyInfo(String option) {
        this.option = option;

    }

    @Override
    public <T extends Actor> void performAs(T actor)  {
        actor.attemptsTo(
                Click.on(FileUI.CONTACT_DETAIL_OPTIONS.of(option))
        );
    }



    public static SelectOptionMyInfo selectOptionFromMyInfo(String option) {
        return Tasks.instrumented(SelectOptionMyInfo.class, option);
    }
}
