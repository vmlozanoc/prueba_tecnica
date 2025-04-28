package tasks.file;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.file.FileUI;



public class DeleteFile implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(FileUI.DELETE_BUTTON),
                Click.on(FileUI.ACCEPT_DELETE_BUTTON)
        );

    }

    public static DeleteFile deleteFile() {
        return Tasks.instrumented(DeleteFile.class);
    }

}
