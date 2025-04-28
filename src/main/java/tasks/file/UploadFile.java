package tasks.file;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Upload;
import userinterfaces.file.FileUI;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFile implements Task {
    @Override
    public <T extends Actor> void performAs(T actor)  {

        Path path = Paths.get("src\\main\\resources\\files\\file.txt");
        actor.attemptsTo(
                Click.on(FileUI.UPLOAD_FILE_BUTTON),
                Upload.theFile(path).to(FileUI.UPLOAD_FILE_INPUT),
                Click.on(FileUI.SAVE_BUTTON)
        );
    }

    public static UploadFile uploadFile() {
        return Tasks.instrumented(UploadFile.class);
    }
}
