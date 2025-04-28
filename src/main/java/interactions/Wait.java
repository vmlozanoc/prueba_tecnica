package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Wait implements Interaction {
    private final Target target;
    private final int time;
    private final WaitType waitType;

    // Enum para los tipos de espera
    public enum WaitType {
        VISIBLE, PRESENT, CLICK
    }

    // Constructor
    public Wait(Target target, int time, WaitType waitType) {
        this.target = target;
        this.time = time;
        this.waitType = waitType;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            switch (waitType) {
                case VISIBLE:
                    actor.attemptsTo(
                            WaitUntil.the(target, isVisible()).forNoMoreThan(time).seconds()
                    );
                    break;
                case PRESENT:
                    actor.attemptsTo(
                            WaitUntil.the(target, isPresent()).forNoMoreThan(time).seconds()
                    );
                    break;
                case CLICK:
                    actor.attemptsTo(
                            WaitUntil.the(target, isClickable()).forNoMoreThan(time).seconds()
                    );
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException("No se encontró el objeto: " + target.getName() + " después de esperar " + time + " segundos.");
        }
    }

    public static Wait forVisibility(Target target, int time) {
        return Tasks.instrumented(Wait.class, target, time, WaitType.VISIBLE);
    }
    public static Wait waitTimeImplicit(Target target, int time) {
        return Tasks.instrumented(Wait.class, target, time, WaitType.PRESENT);
    }

    public static Wait waitForClickeable(Target target, int time) {
        return Tasks.instrumented(Wait.class, target, time, WaitType.CLICK);
    }

}